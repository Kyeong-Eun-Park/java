<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test7_redirect_dispatch.jsp</h1>
	<!-- "redirectServlet" 서블릿 주소 요청에 대한 Test7RedirectServlet 클래스 요청(GET 방식 요청) -->
	<form action="redirectServlet" method="get">
		아이디 : <input type="text" name="id"><br>
		패스워드 : <input type="text" name="passwd"><br>
		<input type="submit" value="로그인(Redirect)">
	</form>
	
	<!-- "dispatchServlet" 서블릿 주소 요청에 대한 Test7DispatchServlet 클래스 요청(GET 방식 요청) -->
	<form action="dispatchServlet" method="get">
		아이디 : <input type="text" name="id"><br>
		패스워드 : <input type="text" name="passwd"><br>
		<input type="submit" value="로그인(Dispatch)">
	</form>
</body>
</html>










