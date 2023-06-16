<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>sessionTest2_remove2.jsp</h1>
	<%
	// 세션 객체에 저장된 "sessionValue2" 이라는 이름의 속성 제거
	session.removeAttribute("sessionValue2");
	
	// 존재하지 않는 속성명 지정하여 삭제 시 오류 발생 없음
	session.removeAttribute("sessionValue3");
	
	// 세션값 삭제 후 sessionTest2_get.jsp 페이지로 리다이렉트(이동)
	response.sendRedirect("sessionTest2_get.jsp");
	%>
</body>
</html>










