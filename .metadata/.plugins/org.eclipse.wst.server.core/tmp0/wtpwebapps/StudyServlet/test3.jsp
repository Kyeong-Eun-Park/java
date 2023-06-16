<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test3.jsp</h1>
	<!-- form 태그를 활용한 서블릿 주소 요청(GET 방식 요청) -->
	<form action="myServlet3" method="get">
		<input type="submit" value="myServlet3 서블릿 주소 요청(GET)">
	</form>
	
	<!-- form 태그를 활용한 서블릿 주소 요청(POST 방식 요청) -->
	<form action="myServlet3" method="post">
		<input type="submit" value="myServlet3 서블릿 주소 요청(POST)">
	</form>
</body>
</html>











