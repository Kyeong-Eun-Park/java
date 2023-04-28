<%@page import="jsp15_randomize.MyRandomize"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	MyRandomize r = new MyRandomize();
	%>
	
	<%for(int i = 1; i <= 10; i++) { %>
<%-- 		<h1>생성된 난수 : <%=r.getRandomNumber() %></h1> --%>
<%-- 		<h1>생성된 난수 : <%=r.getRandomNumber2(6) %></h1> --%>
<%-- 		<h1>생성된 난수 문자 : <%=r.getRandomString() %></h1> --%>
		<h1>생성된 난수 문자(8자리) : <%=r.getRandomString2(8) %></h1>
	<%} %>
</body>
</html>












