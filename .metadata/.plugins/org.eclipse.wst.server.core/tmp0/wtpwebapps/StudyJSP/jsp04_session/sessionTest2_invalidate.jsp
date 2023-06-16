<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>sessionTest2_invalidate.jsp</h1>
	<%
	// session 객체의 값을 삭제하는 방법 2.
	// => session.invalidate() 메서드를 호출하여 세션 전체 초기화(= 세션 객체 자체 삭제)
	session.invalidate();
	
	// 세션 초기화 후 sessionTest2_get.jsp 페이지로 리다이렉트
	response.sendRedirect("sessionTest2_get.jsp");
	// => 이동 시 모든 세션값("sessionValue1", "sessionValue2")이 null 로 출력됨
	%>
</body>
</html>










