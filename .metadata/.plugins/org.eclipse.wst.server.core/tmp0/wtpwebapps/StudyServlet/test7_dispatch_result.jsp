<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test7_dispatch_result.jsp</h1>
	<!-- 
	// Dispatch 방식 포워딩 특징
	// 1. 포워딩 시 지정한 URL(주소)가 웹브라우저 주소표시줄에 표시되지 않고
	//    이전의 요청 주소가 그대로 유지됨(즉, 주소표시줄 주소가 변경되지 않음)
	//    => http://localhost:8080/StudyServlet/dispatchServlet 주소가 그대로 남아있음
	//    => 결국, 클라이언트(웹브라우저)에서는 포워딩 여부를 알 수 없다!
	// 2. 이전 요청 시 생성된 request 객체를 포워딩 시점에서 함께 전달하므로
	//    포워딩 후에도 기존 request 객체가 그대로 유지됨
	//    따라서, 원래 저장되어 있던 파라미터 등의 데이터도 그대로 유지됨
	//    (= 포워딩 된 새 페이지에서 공유됨)
	-->
	<!-- 이전 요청에서 전달받은 폼 파라미터 데이터(아이디(id), 패스워드(passwd)) 출력하기 -->
	<h3>아이디 : <%=request.getParameter("id") %></h3>
	<h3>패스워드 : <%=request.getParameter("passwd") %></h3>
	
	<!-- EL 사용하여 파라미터 출력하기 -->
	<h3>아이디 : ${param.id }</h3>
	<h3>패스워드 : ${param.passwd }</h3>
	
	<!-- 
	결론! Dispatch 방식으로 포워딩 했기 때문에 이전 request 객체가 유지되어
	새로 포워딩 된 현재 페이지에서도 request 객체에 저장된 파라미터 값에 접근 가능함!
	-->
</body>
</html>












