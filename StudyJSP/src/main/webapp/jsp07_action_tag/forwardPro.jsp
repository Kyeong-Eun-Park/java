<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>forwardPro.jsp</h1>
	<%
	// POST 방식 요청 파라미터에 대한 한글 인코딩 설정
	request.setCharacterEncoding("UTF-8");
	
	// forwardForm.jsp 페이지의 폼에서 입력받은 폼 파라미터(아이디, 패스워드, 이름) 가져오기
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	
	// 직접 입력받지 않고, input type="hidden" 태그로 전달한 파라미터로 가져오기
	String pageNum = request.getParameter("pageNum");
	
	int num = 100; // jsp:param 태그를 사용하여 전달할 데이터
	%>
	<h3>아이디 : <%=id %></h3>
	<h3>패스워드 : <%=passwd %></h3>
	<h3>이름 : <%=name %></h3>
	<h3>페이지번호 : <%=pageNum %></h3>
	<hr>
	
	<%--
	액션 태그(Action Tag)
	- JSP 페이지 내에서 자바 코드를 직접 사용하지 않고
	  XML 형식의 태그 문법을 활용하여 동일한 작업을 수행하도록 하는 태그(기능)
	- <jsp:액션태그명 속성명="값" /> 형태로 사용하며
	  태그 사이에 다른 태그를 포함해야하는 경우 끝 태그(</jsp:액션태그명>)를 사용해야함
	  => 주의! 반드시 끝에 끝태그 또는 끝 표시(/) 를 포함해야함
	- 액션 태그명 : forward, include, useBean, setProperty 등
	
	1. forward 액션 태그
	   - pageContext 객체의 forward() 메서드와 동일한 기능을 제공하는 액션 태그
	     즉, 페이지 이동(포워딩) 처리를 수행하는 액션 태그
	   - 현재 페이지의 request 객체를 그대로 유지하여 페이지 이동 수행
	     => 주소표시줄의 URL(주소)이 그대로 유지되며, request 객체에 저장된 데이터가 유지됨
	        (= Dispatcher 방식 포워딩)
	   - 포워딩 시 전달하는 데이터는 주소(URL) 뒤에 파라미터 형식으로 붙여서 전달하거나
	     (ex. forwardPro.jsp?id=admin)
	     <jsp:param> 태그를 사용하여 데이터를 포함시켜 전달 가능
	     (= form 태그에서 <input type="hidden"> 과 동일한 역할 수행)
	     => 전달되는 데이터는 GET 방식이라 하더라도 URL 에 파라미터가 노출되지 않는다!
	   
	   < 기본 문법 >
	   <jsp:forward page="포워딩 할 페이지 또는 파일" />
	   또는
	   <jsp:forward page="포워딩 할 페이지 또는 파일">
	   		<jsp:param name="파라미터명1" value="데이터1" />
	   		<jsp:param name="파라미터명n" value="데이터n" />
	   </jsp:forward>  
	--%>
	
	<%-- jsp:forward 액션태그로 forwardPro2.jsp 페이지 포워딩 작업 수행 --%>
	<%-- 1) 시작태그와 끝태그 사이에 별도의 태그가 없을 경우 /> 기호로 끝태그 처리 가능  --%>
<%-- 	<jsp:forward page="forwardPro2.jsp" /> --%>
	
	<%-- 2) 시작태그와 끝태그 사이에 별도의 태그가 포함될 경우 반드시 끝태그 필수! --%>
	<%-- 함께 포함하여 전달할 데이터를 "str" 이라는 이름으로 포함시켜서 전송하기 --%>
	<%-- 주의! forward 태그 사이에 주석 작성 금지! (오류 발생함) --%>
	<jsp:forward page="forwardPro2.jsp">
		<jsp:param name="str" value="forward 액션 태그의 param 데이터"/>
		<jsp:param name="num" value="<%=num %>"/>
	</jsp:forward>
	
</body>
</html>















