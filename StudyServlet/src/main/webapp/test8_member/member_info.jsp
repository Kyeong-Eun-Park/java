<%@page import="test8_member.MemberDTO"%>
<%@page import="java.sql.Date"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
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
		// request 객체에 저장된 MemberDTO 객체 꺼내기(속성명 : member)
		MemberDTO member = (MemberDTO)request.getAttribute("member");
		%>
		<form action="MemberUpdate" name="joinForm" method="post">
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
	</div>
</body>
</html>













