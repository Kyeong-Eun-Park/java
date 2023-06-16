<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>sessionTest2_remove1.jsp</h1>
	<%
	// session 객체의 값을 삭제하는 방법 1.
	// => session.removeAttribute("속성명");
	// => 세션 객체에 저장된 속성 중에서 지정된 속성명을 갖는 속성만 제거(= 특정 세션값 삭제)
			
	// 세션 객체에 저장된 "sessionValue1" 이라는 이름의 속성 제거
	session.removeAttribute("sessionValue1");
	
	// 세션값 삭제 후 sessionTest2_get.jsp 페이지로 리다이렉트(이동)
	response.sendRedirect("sessionTest2_get.jsp");
	// => 해당 페이지로 이동했을 때 첫번째 세션값이 null 값이 출력됨(해당 속성 제거되었기 때문)
	%>
</body>
</html>
























