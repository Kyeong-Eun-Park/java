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
		
		Connection con = JdbcUtil.getConnection();
		
		String sql = "SELECT * FROM test4_member WHERE id = ?";
		PreparedStatement pstmt = con.prepareStatement(sql);
		pstmt.setString(1, id);
		
		ResultSet rs = pstmt.executeQuery();
		
		// while 문 또는 if 문을 사용하여 1개 레코드에 접근 후 데이터 가져오기
		if(rs.next()) {
			// 각각의 변수에 조회된 레코드 컬럼값 저장
			int idx = rs.getInt("idx");
			String name = rs.getString("name");
// 			String id = rs.getString("id"); // 세션 아이디로 조회한 결과이므로 id 저장 불필요
			String jumin = rs.getString("jumin");
			String email = rs.getString("email");
			String job = rs.getString("job");
			String gender = rs.getString("gender");
			String hobby = rs.getString("hobby");
			String motivation = rs.getString("motivation");
			Date hire_date = rs.getDate("hire_date"); // java.sql.Date
			
			// 임시. 주민번호를 "-" 기호 기준으로 분리하기 => String 클래스의 split() 메서드
			// => 문자열.split("구분자") 형식으로 사용하며 분리된 문자열은 Stringp[] 타입으로 리턴
			String[] jumins = jumin.split("-");
			// => 주민번호 앞자리는 0번 배열, 뒷자리는 1번 배열에 저장됨
					
			// 임시. 취미를 "/" 기호 기준으로 분리하기
			String[] arrHobbies = hobby.split("/"); 
			%>
<%-- 			<h3>이름 : <%=name %></h3> --%>
<%-- 				<h3>아이디 : <%=id %></h3> --%>
<%-- 			<h3>주민번호 : <%=jumin %></h3> --%>
<%-- 			<h3>주민번호 : <%=jumins[0] %> - <%=jumins[1] %></h3> --%>
<%-- 			<h3>E-Mail : <%=email %></h3> --%>
<%-- 			<h3>성별 : <%=gender %></h3> --%>
<%-- 			<h3>취미 : <%=hobby %></h3> --%>

			<%
// 			for(int i = 0; i < arrHobbies.length; i++) {
// 				out.print(arrHobbies[i]);
// 			}
			%>
			
			<form action="dbcp_test4_member_update.jsp" name="joinForm" method="post">
			<table border="1">
				<tr>
					<th>이름</th>
					<td><input type="text" name="name" value="<%=name %>" required="required"></td>
				</tr>
				<tr>
					<th>ID</th>
					<td>
						<input type="text" name="id" value="<%=id %>" readonly="readonly" placeholder="4 ~ 8글자 사이 입력" onchange="checkDuplicateId()" required="required" style="background-color:lightgray">
						<span id="checkIdResult"></span>
					</td>
				</tr>
				<tr>
					<th>비밀번호</th>
					<td>
						<input type="text" name="passwd" placeholder="8 ~ 16글자 사이 입력" onchange="checkPasswd(this.value)">
					</td>
				</tr>
				<%-- 변경할 비밀번호 입력은 선택 사항이므로 required 속성 제거 --%>
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
						<%-- 입력 항목에 maxLength 속성 지정 시 최대 길이 지정 가능 --%>
<%-- 						<input type="text" name="jumin1" value="<%=jumins[0] %>" onkeyup="checkJumin1(this.value)" maxlength="6" required="required"> -  --%>
<%-- 						<input type="text" name="jumin2" value="<%=jumins[1] %>" onkeyup="checkJumin2(this.value)" maxlength="7" required="required"> --%>
						<input type="text" name="jumin1" value="<%=jumin.split("-")[0] %>" onkeyup="checkJumin1(this.value)" maxlength="6" required="required"> - 
						<input type="text" name="jumin2" value="<%=jumin.split("-")[1] %>" onkeyup="checkJumin2(this.value)" maxlength="7" required="required">
					</td>
				</tr>
				<tr>
					<th>E-Mail</th>
					<td>
						<input type="text" name="email1" value="<%=email.split("@")[0] %>" required="required">@<input type="text" name="email2" value="<%=email.split("@")[1] %>" required="required">
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
						<%-- 셀렉트박스 항목과 직업이 일치할 경우 해당 항목 기본값으로 선택하기 --%>
						<select name="job">
							<option value="">항목을 선택하세요</option>
							<option value="개발자" <%if(job.equals("개발자")) { %> selected="selected" <%} %>>개발자</option>
							<option value="DB엔지니어" <%if(job.equals("DB엔지니어")) { %> selected="selected" <%} %>>DB엔지니어</option>
							<option value="아르바이트" <%if(job.equals("아르바이트")) { %> selected="selected" <%} %>>아르바이트</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<input type="radio" name="gender" value="남" <%if(gender.equals("남")) { %>checked="checked" <%} %>>남
						<input type="radio" name="gender" value="여" <%if(gender.equals("여")) { %>checked="checked" <%} %>>여
					</td>
				</tr>
				<tr>
					<th>취미</th>
					<td>
						<input type="checkbox" name="hobby" value="여행" <%if(hobby.contains("여행")) { %> checked="checked" <%} %>>여행
						<input type="checkbox" name="hobby" value="독서" <%if(hobby.contains("독서")) { %> checked="checked" <%} %>>독서
						<input type="checkbox" name="hobby" value="게임" <%if(hobby.contains("게임")) { %> checked="checked" <%} %>>게임
						<input type="checkbox" id="check_all" onclick="checkAll(this.checked)">전체선택
					</td>
				</tr>
				<tr>
					<th>가입동기</th>
					<td>
						<textarea rows="10" cols="60" name="motivation" required="required"><%=motivation %></textarea>
					</td>
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
		} else { // id 파라미터에 해당하는 레코드가 존재하지 않을 경우(아이디 강제로 잘못 입력 등)
			%>
			<script type="text/javascript">
				alert("존재하지 않는 아이디입니다!");
				history.back();
			</script>
			<%
		}
		
		// 자원 반환
		JdbcUtil.close(rs);
		JdbcUtil.close(pstmt);
		JdbcUtil.close(con);
		%>
	</div>
</body>
</html>













