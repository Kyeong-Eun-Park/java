<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 1. 쿠키 생성 = Cookie 객체 생성(실제 쿠키 파일이 생성되는 시점이 아님!)
// => new Cookie("쿠키명", "쿠키값");
// => session 등의 setAttribute() 메서드와 달리 쿠키의 값은 무조건 String 타입
Cookie cookie = new Cookie("cookieName", "cookieValue");
// => "cookieName" 이라는 쿠키 이름으로 "cookieValue" 라는 문자열 값을 갖는 객체 생성

// 2. 생성되는 쿠키의 유효기간(만료기간) 설정
// => Cookie 객체의 setMaxAge() 메서드를 호출하여 유효기간 지정(초 단위)
//    만약, 생략했을 경우 세션과 동일하게 브라우저 종료 시 삭제됨
cookie.setMaxAge(60); // 60초 = 1분간 쿠키 유지됨

// 3. 생성된 쿠키를 클라이언트로 전송하기 위해 응답 객체인 response 객체에 쿠키 저장
// => response 객체의 addCookie() 메서드 호출하여 쿠키 전달
response.addCookie(cookie);

// ------------------------------------------------------------
// 새로운 쿠키(cookie2) 생성
// => 쿠키명 : "id", 쿠키값 : "admin", 타이머 : 30분
Cookie cookie2 = new Cookie("id", "admin");
cookie2.setMaxAge(1800);
response.addCookie(cookie2);

%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>cookieTest1_make.jsp - 쿠키 생성</h1>
	<%--
	Cookie 객체 정보 확인(임시로 쿠키 생성한 현재 페이지에서 확인)
	- getName() : 쿠키명 리턴 
	- getValue() : 쿠키값 리턴
	- getMaxAge() : 쿠키 유효기간 리턴
	=> 저장된 쿠키 정보는 웹브라우저(크롬) 개발자 도구의 Application - Cookies 에서 확인 가능
	--%>
	<h3>쿠키명 : <%=cookie.getName() %></h3>
	<h3>쿠키값 : <%=cookie.getValue() %></h3>
	<h3>쿠키 유효기간 : <%=cookie.getMaxAge() %>초</h3>
	<hr>
	<%-- 버튼을 활용하여 "쿠키확인" 클릭 시 "cookieTest1_use.jsp" 페이지로 이동 --%>
	<%-- 버튼을 활용하여 "돌아가기" 클릭 시 이전 페이지로 돌아가기 --%>
	<input type="button" value="쿠키확인" onclick="location.href='cookieTest1_use.jsp'">
	<input type="button" value="돌아가기" onclick="history.back()">
</body>
</html>










