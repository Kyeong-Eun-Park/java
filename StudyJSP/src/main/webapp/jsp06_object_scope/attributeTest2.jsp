<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>attributeTest2.jsp</h1>
	<%-- pageContext 객체는 페이지마다 새로 생성되므로 이전 페이지 데이터 접근 불가(null) --%>
	<h3>pageContext 객체 값 : <%=pageContext.getAttribute("pageContextValue") %></h3>
	
	<%-- 
	request 객체는 요청에 대한 응답페이지까지 유효하므로
	Redirect 방식으로 이동했을 경우에는 접근 불가(null), 
	Dispatch 방식으로 이동했을 경우 접근 가능
	--%>
	<h3>request 객체 값 : <%=request.getAttribute("requestValue") %></h3>
	
	<%-- session 객체는 웹브라우저 종료전까지 유효하므로 웹브라우저 종료 시 접근 불가(null) --%>
	<h3>session 객체 값 : <%=session.getAttribute("sessionValue") %></h3>
	
	<%-- application 객체는 서버(톰캣) 종료 시 접근 불가(null) --%>
	<h3>application 객체 값 : <%=application.getAttribute("applicationValue") %></h3>
</body>
</html>













