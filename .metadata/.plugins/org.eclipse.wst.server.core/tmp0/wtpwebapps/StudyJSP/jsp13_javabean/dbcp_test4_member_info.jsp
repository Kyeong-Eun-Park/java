<%@page import="jsp13_javabean.MemberDTO"%>
<%@page import="jsp13_javabean.MemberDAO"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="jsp12_dbcp.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="center">
		<h1>회원 상세정보</h1>
		<%
		// 세션 아이디와 일치하는 레코드 검색(SELECT) 후 회원 상세정보 출력
// 		String id = (String)session.getAttribute("sId");
		// => 단, 관리자가 회원 정보 수정을 위해 수정 버튼 클릭 시에는
		//    URL 뒤에 파라미터로 id 값이 전달되며, 해당 아이디로 조회 수행해야함
		// => 주의! id 파라미터가 없을 경우 세션 아이디를 조회할 아이디로 사용
		String id = "";
		
		// 주의! 일반 회원이 id 파라미터를 직접 입력했을 경우에 해당 아이디를 사용하면
		// 자신이 아닌 다른 정보 조회가 가능하므로 차단해야함
		id = request.getParameter("id");
		
		// id 값이 null 또는 널스트링("") 일 경우 세션 아이디를 id 변수에 저장
		if(id == null || id.equals("")) {
			id = (String)session.getAttribute("sId");
		} else if(!session.getAttribute("sId").equals("admin")) {
			// id 파라미터가 존재하고, 세션 아이디가 "admin" 이 아닐 경우
			// 자바스크립트를 사용하여 "잘못된 접근입니다!" 출력 후 이전페이지로 돌아가기
			%>
			<script type="text/javascript">
				alert("잘못된 접근입니다!");
				history.back();
			</script>
			<%
		}
		
		// 데이터베이스 작업을 수행할 MemberDAO 클래스의 인스턴스 생성
		MemberDAO dao = new MemberDAO();
		
		// MemberDAO 객체의 selectMemberInfo() 메서드를 호출하여 회원 상세정보 조회 작업 수행
		// => 파라미터 : 아이디(id)   리턴타입 : MemberDTO()
		MemberDTO member = dao.selectMemberInfo(id);
		// => 뷰페이지(jsp 파일)에서 표시할 데이터는 MemberDTO 타입 객체에 저장되어 있으므로
		//    member.getXXX() 메서드를 호출하여 접근 가능
		
		// 단, 조회 결과(MemberDTO 객체)가 없을 경우(= null) 
		// 자바스크립트를 사용하여 "해당 회원 정보가 존재하지 않습니다!" 출력 후 이전페이지
		if(member == null) {
			%>
			<script type="text/javascript">
				alert("해당 회원 정보가 존재하지 않습니다!");
				history.back();
			</script>
			<%
		} else {
			%>
			<form action="dbcp_test4_member_update.jsp" name="joinForm" method="post">
			<table border="1">
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" value="<%=member.getName() %>" required="required"></td>
				</tr>
				<tr>
					<th>ID</th>
					<td>
						<input type="text" name="id" value="<%=member.getId() %>" readonly="readonly" placeholder="4 ~ 8글자 사이 입력" onchange="checkDuplicateId()" required="required" style="background-color:lightgray">
						<span id="checkIdResult"></span>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="text" name="passwd" placeholder="8 ~ 16글자 사이 입력" onchange="checkPasswd(this.value)">
					</td>
				</tr>
	<!-- 			변경할 비밀번호 입력은 선택 사항이므로 required 속성 제거 -->
				<tr>
					<th>변경할 비밀번호</th>
					<td>
						<input type="text" name="newPasswd" placeholder="8 ~ 16글자 사이 입력" onchange="checkPasswd(this.value)">
						<span id="checkPasswdResult"></span>
					</td>
				</tr>
				<tr>
					<th>변경할 비밀번호 확인</th>
					<td>
						<input type="password" name="newPasswd2" onchange="checkConfirmPasswd(this.value)">
						<span id="checkPasswd2Result"></span>
					</td>
				</tr>
				<tr>
					<th>주민번호</th>
					<td>
						<input type="text" name="jumin1" value="<%=member.getJumin().split("-")[0] %>" onkeyup="checkJumin1(this.value)" maxlength="6" required="required"> - 
						<input type="text" name="jumin2" value="<%=member.getJumin().split("-")[1] %>" onkeyup="checkJumin2(this.value)" maxlength="7" required="required">
					</td>
				</tr>
				<tr>
					<th>E-Mail</th>
					<td>
						<input type="text" name="email1" value="<%=member.getEmail().split("@")[0] %>" required="required">@<input type="text" name="email2" value="<%=member.getEmail().split("@")[1] %>" required="required">					
						<select id="emailDomain" onchange="selectDomain(this.value)">
							<option value="">직접입력</option>
							<option value="naver.com">naver.com</option>
							<option value="nate.com">nate.com</option>
							<option value="gmail.com">gmail.com</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>직업</th>
					<td>
						<select name="job">
							<option value="">항목을 선택하세요</option>
							<option value="개발자" <%if(member.getJob().equals("개발자")) { %> selected="selected" <%} %>>개발자</option>
							<option value="DB엔지니어" <%if(member.getJob().equals("DB엔지니어")) { %> selected="selected" <%} %>>DB엔지니어</option>
							<option value="아르바이트" <%if(member.getJob().equals("아르바이트")) { %> selected="selected" <%} %>>아르바이트</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<input type="radio" name="gender" value="남" <%if(member.getGender().equals("남")) { %>checked="checked" <%} %>>남
						<input type="radio" name="gender" value="여" <%if(member.getGender().equals("여")) { %>checked="checked" <%} %>>여
					</td>
				</tr>
				<tr>
					<th>취미</th>
					<td>
						<input type="checkbox" name="hobby" value="여행" <%if(member.getHobby().contains("여행")) { %> checked="checked" <%} %>>여행
						<input type="checkbox" name="hobby" value="독서" <%if(member.getHobby().contains("독서")) { %> checked="checked" <%} %>>독서
						<input type="checkbox" name="hobby" value="게임" <%if(member.getHobby().contains("게임")) { %> checked="checked" <%} %>>게임
						<input type="checkbox" id="check_all" onclick="checkAll(this.checked)">전체선택
					</td>
				</tr>
				<tr>
					<th>가입동기</th>
					<td>
						<textarea rows="10" cols="60" name="motivation" required="required"><%=member.getMotivation() %></textarea>
					</td>
				</tr>
				<tr>
					<th>가입일</th>
					<td><%=member.getHire_date() %></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="수정">
						<input type="reset" value="초기화">
						<input type="button" value="돌아가기" onclick="history.back()">
					</td>
				</tr>
			</table>
		</form>
			<%
		}
		%>
	</div>
</body>
</html>













