<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String id = "";

// 현재 페이지의 언어 설정 값을 한국어("ko-kr")로 기본값 설정
String lang = "ko-kr";

// 쿠키 중에서 "id" 라는 이름의 쿠키가 있을 경우
// 해당 쿠키의 값을 id 변수에 저장하기
// "lang" 쿠키값 저장하기
if(request.getHeader("Cookie") != null) {
	Cookie[] cookies = request.getCookies();
	
	for(Cookie cookie : cookies) {
		if(cookie.getName().equals("id")) {
			id = cookie.getValue(); // 아이디 저장
		} else if(cookie.getName().equals("lang")) {
			lang = cookie.getValue(); // 언어 설정값 저장
		}
	}
}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div align="right">
		<input type="button" value="한국어" onclick="location.href='cookieTest2_set.jsp?lang=ko-kr'">
		<input type="button" value="영어" onclick="location.href='cookieTest2_set.jsp?lang=en-us'">
	</div>
	<div align="center">
		<%-- lang 파라미터값이 "ko-kr" 이면 한국어 페이지로 로그인 화면 표시 --%>
		<%if(lang.equals("ko-kr")) { %>
		<h1>로그인</h1>
		<form action="cookieTest2_set.jsp" method="get">
			<table border="1">
				<tr>
					<td>아이디</td>
					<td>
						<%-- 자바 변수 id 값이 널스트링이 아니면 해당 값을 id 값에 출력 --%>
						<input type="text" name="id" <%if(!id.equals("")) { %>value="<%=id%>"<%} %> required="required"><br>
						<input type="checkbox" name="saveId">ID기억하기
					</td>
				</tr>
				<tr>
					<td>패스워드</td>
					<td><input type="password" name="passwd" required="required"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="로그인">
					</td>
				</tr>
			</table>
		</form>
		<%-- ========================================================= --%>
		<%} else if(lang.equals("en-us")) { %>
		<h1>Log-In</h1>
		<form action="cookieTest2_set.jsp" method="get">
			<table border="1">
				<tr>
					<td>ID</td>
					<td>
						<%-- 자바 변수 id 값이 널스트링이 아니면 해당 값을 id 값에 출력 --%>
						<input type="text" name="id" <%if(!id.equals("")) { %>value="<%=id%>"<%} %> required="required"><br>
						<input type="checkbox" name="saveId">Remember ID
					</td>
				</tr>
				<tr>
					<td>PASSWORD</td>
					<td><input type="password" name="passwd" required="required"></td>
				</tr>
				<tr>
					<td colspan="2" align="center">
						<input type="submit" value="LOGIN">
					</td>
				</tr>
			</table>
		</form>
		<%} %>
	</div>
</body>
</html>