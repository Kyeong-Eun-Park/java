<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>cookieTest1_use.jsp - 쿠키 사용</h1>
	<%
	// 1. request 객체의 헤더에 "Cookie" 문자열 존재 여부 확인(= 쿠키 존재 여부 확인)
// 	String cookieHeader = request.getHeader("Cookie");
	
	// 2. 리턴받은 헤더 정보에 대한 문자열이 null 이 아닐 경우 쿠키가 존재한다는 의미
// 	if(cookieHeader != null) {}
	
	// 위의 두 문장을 하나로 결합
	if(request.getHeader("Cookie") != null) {
		// 3. request 객체를 활용하여 클라이언트에 저장된 Cookie 객체(들) 가져오기
		// => request 객체의 getCookies() 메서드를 호출
		//    (리턴되는 쿠키들은 Cookie[] 타입 배열로 리턴)
		Cookie[] cookies = request.getCookies();
		
		// 4. for 문을 사용하여 Cookie 배열 크키만큼 반복문을 통해 쿠키에 차례대로 접근
// 		for(int i = 0; i < cookies.length; i++) {
// 			// 5. Cookie 배열의 각 요소를 Cookie 타입 객체에 저장
// 			Cookie cookie = cookies[i];
			
// 			// 6. Cookie 객체의 getXXX() 메서드를 호출하여 쿠키 정보에 접근
// 			out.print("<h3>쿠키명 : " + cookie.getName() + "</h3>");
// 			out.print("<h3>쿠키값 : " + cookie.getValue() + "</h3>");
// 		}
		// -------------------------------------------------------------
		for(Cookie cookie : cookies) {
			out.print("<h3>쿠키명 : " + cookie.getName() + "</h3>");
			out.print("<h3>쿠키값 : " + cookie.getValue() + "</h3>");
			
			// 저장되어 있는 쿠키 중에서 이름이 "id" 인 쿠키가 있을 경우
			// => "아이디 : xxx" 형식으로 쿠키의 값("admin")을 출력
			if(cookie.getName().equals("id")) {
				out.print("<h3>아이디 : " + cookie.getValue() + "</h3>");
			}
		}
	}
	%>
	
	<hr>
	<%-- 
	JSTL 과 EL 을 활용하여 쿠키 탐색하고 쿠키값 접근하기
	- EL 을 통해 쿠키에 접근하는 방법 : ${cookie}  =>  복수개의 쿠키 객체(Cookie[] 개념)
	- JSTL 의 반복문을 통해 ${cookie} 객체의 크기만큼 반복하면서 각 쿠키에 접근
	--%>
<%-- 	<c:forEach var="c" items="${cookie }"> --%>
<%-- 		<h3>${c.value.name } : ${c.value.value }</h3> --%>
		<%-- 쿠키에 저장된 이름 중 "id" 라는 이름의 값 출력 --%>
<%-- 		<c:if test="${c.value.name eq 'id' }"> --%>
<%-- 			<h3>아이디 : ${c.value.value }</h3> --%>
<%-- 		</c:if> --%>
<%-- 	</c:forEach> --%>

	<%-- ${cookie.쿠키명.value} 형식으로 특정 쿠키의 값에 직접 접근 가능 --%>
	<h3>아이디 : ${cookie.id.value }</h3>
	
	<%-- 만약, 쿠키에 저장된 아이디(id) 값이 "admin" 이면 "관리자입니다!" 출력하기 --%>
	<c:if test="${cookie.id.value eq 'admin' }">
		<h3>관리자입니다!</h3>
	</c:if>
	
	<input type="button" value="메인페이지" onclick="location.href='cookieTest1.jsp'">
</body>
</html>












