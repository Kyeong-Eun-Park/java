<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test1.jsp</h1>
	
	<!-- 하이퍼링크 "myServlet" 서블릿 주소 요청("myServlet 서블릿 주소 요청(GET)") => GET 방식 요청 -->
	<h3><a href="myServlet">myServlet 서블릿 주소 요청(GET)</a></h3>
	
	<!-- form 태그를 활용한 서블릿 주소 요청(GET 방식 요청) -->
	<!-- submit 버튼에 "myServlet 서블릿 주소 요청(GET)" 표시 -->
	<form action="myServlet" method="get"> <!-- GET 방식 요청은 method="get" 생략 가능 -->
		<input type="submit" value="myServlet 서블릿 주소 요청(GET)">
	</form>
	
	<!-- form 태그를 활용한 서블릿 주소 요청(POST 방식 요청) -->
	<!-- submit 버튼에 "myServlet 서블릿 주소 요청(POST)" 표시 -->
	<form action="myServlet" method="post"> <!-- POST 방식 요청은 method="post" 생략 불가 -->
		<input type="submit" value="myServlet 서블릿 주소 요청(POST)">
	</form>
	
	<!-- 매핑 되어있지 않은 서블릿 주소 요청 시 HTTP 404 Not Found -->
	<form action="myServlet_fail" method="post">
		<input type="submit" value="myServlet_fail 서블릿 주소 요청(POST)">
	</form>
</body>
</html>











