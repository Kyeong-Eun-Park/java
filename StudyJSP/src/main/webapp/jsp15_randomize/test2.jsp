<%@page import="jsp15_randomize.MyRandomize2"%>
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
	MyRandomize2 r = new MyRandomize2();
	%>
	
	<%for(int i = 1; i <= 10; i++) { %>
<%-- 		<h1>생성된 난수 : <%=r.getRandomNumeric() %></h1> --%>
<%-- 		<h1>생성된 난수 문자 : <%=r.getRandomAlphabetic() %></h1> --%>
<%-- 		<h1>생성된 난수 문자 및 숫자 : <%=r.getRandomAlphanumeric() %></h1> --%>
		<h1>생성된 난수 문자, 숫자, 특수문자 : <%=r.getRandom() %></h1>
	<%} %>
</body>
</html>

















