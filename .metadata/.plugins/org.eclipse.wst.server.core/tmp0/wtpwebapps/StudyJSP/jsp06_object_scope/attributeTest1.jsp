<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>attributeTest1.jsp</h1>
	<%
	/*
	[ JSP 영역 객체 ]
	- JSP 의 4대 영역(page, request, session, application)에 대한 객체이며
	  page 영역만 pageContext 라는 이름의 객체를 사용하고, 나머지는 영역명과 객체명이 동일
	- 4대 영역 객체에 데이터를 저장할 때 setAttribute() 메서드를 사용하고,
	  데이터를 꺼낼 때 getAttribute() 메서드를 사용
	- 4대 영역 객체의 데이터는 사용(접근) 가능한 범위(Scope)가 각각 다름
	  1) pageContext 객체 : 현재 페이지에서만 유효
	  2) request 객체 : 요청에 대한 응답까지만 유효
      3) session 객체 : 세션이 유지되는 동안 유효
	  4) application 객체 : 서버가 동작하는 동안 유효
	*/
	
	// 각 영역 객체에 값 저장하기
	// => 기본 문법 : setAttribute(String name, Object value)
	// => String name : 저장할 데이터(속성)를 가리키는 이름(= 속성명)
	//    Object value : 저장되는 데이터(= 속성값) 
	//                   => Object 타입이므로 모든 데이터타입의 데이터 저장 가능함
	pageContext.setAttribute("pageContextValue", "pageContext value");
	request.setAttribute("requestValue", "request value");
	session.setAttribute("sessionValue", "session value");
	application.setAttribute("applicationValue", "application value");
	%>
	
	<%-- 
	각 영역 객체에 저장된 값 가져오기
	=> 기본 문법 : Object getAttribute(String name)
	=> String name : 저장된 데이터(속성)를 가리키는 이름(= 속성명)
	=> 리턴타입이 Object 타입이므로 각 데이터를 변수에 저장 시 형변환 필요
	   ex) 문자열로 저장 시 (String), 정수로 저장 시 (int)
	--%>
	<h3>pageContext 객체 값 : <%=pageContext.getAttribute("pageContextValue") %></h3>
	<h3>request 객체 값 : <%=request.getAttribute("requestValue") %></h3>
	<h3>session 객체 값 : <%=session.getAttribute("sessionValue") %></h3>
	<h3>application 객체 값 : <%=application.getAttribute("applicationValue") %></h3>
	<%-- 현재 페이지에서 저장한 값은 현재 페이지 내에서 모두 접근 가능함  --%>
	
	<%
	// pageContext 객체의 forward() 메서드를 호출하여 "attributeTest2.jsp" 페이지로 이동(포워딩)
	// => Dispatch 방식 포워딩
	// => 하나의 요청으로 묶어서 request 객체를 다음페이지까지 유지시키기 위함
	pageContext.forward("attributeTest2.jsp");
	%>
</body>
</html>












