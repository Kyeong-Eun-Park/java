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
	// 아이디(input type="text"), ID기억하기(input type="checkbox") 파라미터 가져오기
	String id = request.getParameter("id");
	String saveId = request.getParameter("saveId");
	// => 체크박스의 value 속성을 설정하지 않으면 체크상태 = on, 미체크상태 = null 값 전달됨
			
	// 만약, saveId 값이 null 이 아닐 경우
	// Cookie 객체에 "id" 라는 이름으로 입력받은 아이디를 저장 후 클라이언트에 쿠키 전송
	// => 쿠키 유효기간은 1일로 설정
	if(saveId != null) { // ID 기억하기 항목이 체크됐을 경우
		Cookie cookie = new Cookie("id", id);
		cookie.setMaxAge(60 * 60 * 24); // 86400초 = 1일
		response.addCookie(cookie);
	}
	
	// lang 파라미터값이 존재할 경우(null 이 아닐 경우)
	// 쿠키에 "lang" 이라는 이름으로 lang 파라미터값(ko-kr 또는 en-us) 저장(유효기간 1일)
	String lang = request.getParameter("lang");
	if(lang != null) { 
		Cookie cookie = new Cookie("lang", lang);
		cookie.setMaxAge(60 * 60 * 24); // 86400초 = 1일
		response.addCookie(cookie);
	}
	
	// cookieTest2.jsp 페이지로 리다이렉트
	response.sendRedirect("cookieTest2.jsp");
	%>
</body>
</html>














