<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>sessionTest2_set.jsp</h1>
	<%
	// session 객체에 값(데이터)을 저장하는 방법
	// => session.setAttribute("속성명", 속성값(데이터));
	// => 첫번째 파라미터 : 저장할 값을 가리키는 이름(= 속성명 = 키) 
	//                      = 변수명과 유사한 역할로 String 타입(문자열)으로 지정
	// => 두번째 파라미터 : 세션 객체에 저장할 값(데이터) => 데이터타입은 무관함(아무거나)
	
	// 1) 세션 객체에 "sessionValue1" 이라는 이름(속성명)으로 "첫번째 세션값" 문자열을 저장
	session.setAttribute("sessionValue1", "첫번째 세션값");
	// 2) 세션 객체에 "sessionValue2" 이라는 이름(속성명)으로 "두번째 세션값" 문자열을 저장
	session.setAttribute("sessionValue2", "두번째 세션값");
	%>
	
	<%--
	session 객체에 저장된 값(데이터) 꺼내는 방법
	=> session.getAttribute("속성명");
	=> 파라미터 : 저장된 값을 가리키는 이름(속성명)
	--%>
	<h3>세션에 저장된 값 1 : <%=session.getAttribute("sessionValue1") %></h3>
	<h3>세션에 저장된 값 2 : <%=session.getAttribute("sessionValue2") %></h3>
	<%-- 주의! 만약, 속성명에 해당하는 속성이 존재하지 않으면 null 값 리턴됨 --%>
	<h3>세션에 저장된 값 3 : <%=session.getAttribute("sessionValue3") %></h3> <%-- null --%>
	<hr>
	
	<h1>세션값 저장 완료!</h1>
	<!-- "세션값 확인" 버튼 클릭 시 "sessionTest2_get.jsp" 페이지로 이동 -->
	<!-- "돌아가기" 버튼  클릭 시 이전 페이지로 돌아가기 -->
	<input type="button" value="세션값 확인" onclick="location.href='sessionTest2_get.jsp'">
	<input type="button" value="돌아가기" onclick="history.back()">
</body>
</html>












