<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
	include 디렉티브<%@ include %> 를 사용하여
	현재 페이지 내에 다른 문서를 포함시킬 수 있다!
	--%>
	<header>
		<%-- test4_top.jsp 페이지를 현재 위치에 포함(include) 시키기 --%>
		<%@ include file="test4_top.jsp" %>
	</header>
	<hr>
	<article>
		<h1>test4.jsp</h1>
	</article>
	<hr>
	<footer>
		<%-- test4_bottom.jsp 페이지를 현재 위치에 포함(include) 시키기 --%>
		<%@ include file="test4_bottom.jsp" %>
	</footer>
</body>
</html>






