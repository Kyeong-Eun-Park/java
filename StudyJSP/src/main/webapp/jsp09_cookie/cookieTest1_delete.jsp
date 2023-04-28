<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>cookieTest1_delete.jsp - 쿠키 삭제</h1>
	<%
	// 쿠키 삭제
	// - 쿠키의 타이머(유효기간 = MaxAge 값)를 0 으로 설정하여 전송
	// 1. 특정 쿠키의 타이머를 0으로 설정 후 전송
	// => Cookie 객체 생성 시 쿠키명을 삭제할 쿠키명으로 지정하고 값은 무관하며, 타이머 0 설정
// 	Cookie cookie = new Cookie("id", null);
// 	cookie.setMaxAge(0);
// 	response.addCookie(cookie);
	
	// 2. 모든 쿠키 삭제
	// => Cookie[] 객체를 가져와서 각 Cookie 객체마다 타이머를 0으로 설정 후 전송
	Cookie[] cookies = request.getCookies();
	
	// 향상된 for문을 사용하여 각 쿠키 객체에 접근 후 타이머를 0으로 설정 및 응답 객체에 추가
	for(Cookie cookie : cookies) {
		cookie.setMaxAge(0);
		response.addCookie(cookie);
	}
	
	
	// 삭제된 쿠키 확인을 위해 "cookieTest1_use.jsp" 페이지로 리다이렉트
	response.sendRedirect("cookieTest1_use.jsp");
	%>
	
</body>
</html>











