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
	<div align="right">
		<!-- 
		로그인 상태에 따라 다른 메뉴(링크) 표시
		1) 로그인 상태일 경우(세션 아이디("sId" 속성값") 가 존재할 경우)
		   => 세션 아이디, 로그아웃(sessionTest3_logout.jsp)
		2) 로그인 상태가 아닐 경우(세션 아이디가 존재하지 않을 경우)
		   => 로그인(sessionTest3_login_form.jsp),	회원가입(sessionTest3_join_form.jsp)
		=> 주의! 세션 값이 존재하지 않을 경우 null 값이 리턴되므로 null 값 여부 판별
		-->
		<%
		// 세션 아이디를 String 타입 변수에 저장하는 방법
		// => getAttribute() 메서드 리턴타입이 Object 타입이므로 String 타입 형변환 필요
		// => 형변환 연산자 (String) 사용
		String sId = (String)session.getAttribute("sId");
		if(sId == null) {
			%><a href="test3_login_form.jsp">로그인</a> | <a href="test3_join_form.jsp">회원가입</a><%
		} else {
			%><%=session.getAttribute("sId") %> 님 | <a href="test3_logout.jsp">로그아웃</a><%
		}
		%>
		<hr>
		<c:choose>
			<c:when test="${empty sessionScope.sId }">
				<a href="test3_login_form.jsp">로그인</a> | <a href="test3_join_form.jsp">회원가입</a>
			</c:when>
			<c:otherwise>
				${sessionScope.sId } 님 | <a href="test3_logout.jsp">로그아웃</a>
			</c:otherwise>
		</c:choose>
	</div>
	<h1 align="center">메인 화면</h1>
</body>
</html>













