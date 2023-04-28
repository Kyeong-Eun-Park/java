<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test6.jsp</h1>
	<!-- 복수개의 서블릿 요청을 하나의 서블릿 클래스로 처리하기 위한 링크 생성 -->
	<form action="myServlet6-1.do" method="get">
		<input type="submit" value="myServlet6-1.do 서블릿 주소 요청(GET)">
	</form>
	
	<form action="myServlet6-2.do" method="post">
		<input type="submit" value="myServlet6-2.do 서블릿 주소 POST">
	</form>
	
	
	<!-- form 태그를 활용한 서블릿 주소 요청(GET 방식 요청) -->
	<form action="myServlet6Get.do" method="get">
		이름 : <input type="text" name="name"><br>
		나이 : <input type="text" name="age"><br>
		<input type="submit" value="myServlet6Get.do 서블릿 주소 요청(GET)">
	</form>
	
	<!-- form 태그를 활용한 서블릿 주소 요청(POST 방식 요청) -->
	<form action="myServlet6Post.do" method="post">
		이름 : <input type="text" name="name"><br>
		나이 : <input type="text" name="age"><br>
		<input type="submit" value="myServlet6Post.do 서블릿 주소 요청(POST)">
	</form>
</body>
</html>











