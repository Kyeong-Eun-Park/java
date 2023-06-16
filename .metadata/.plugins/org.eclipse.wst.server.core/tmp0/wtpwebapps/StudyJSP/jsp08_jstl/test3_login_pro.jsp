<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
// 아이디와 패스워드 일치하는지 판별(아이디는 "admin", 패스워드는 "1234" 로 비교)
// => 일치할 경우(= 로그인 성공) 
//    세션 객체에 "sId" 라는 속성명으로 로그인에 성공한 아이디 저장 후 (자바 코드)
//    test3_login_main.jsp 페이지로 리다이렉트 (자바 코드)
// => 아이디가 일치하지 않을 경우
//    자바스크립트를 사용하여 "존재하지 않는 아이디!" 출력 후 이전페이지로 돌아가기
// => 패스워드가 일치하지 않을 경우
//    자바스크립트를 사용하여 "패스워드 틀림!" 출력 후 이전페이지로 돌아가기
%>
<c:choose>
	<%-- 만약, 아이디와 패스워드 일치 여부를 먼저 비교할 경우 --%>
<%-- 	<c:when test="${param.id eq 'admin' and param.passwd eq '1234' }"></c:when> --%>
	<c:when test="${param.id ne 'admin' }"> <%-- 아이디 없음 --%>
		<script>
			alert("존재하지 않는 아이디!");
			history.back();
		</script>
	</c:when>
	<c:when test="${param.passwd ne '1234' }"> <%-- 패스워드 틀림 --%>
		<script>
			alert("패스워드 틀림!");
			history.back();
		</script>
	</c:when>
	<c:otherwise> <%-- 아이디와 패스워드가 일치할 경우(= 로그인 성공) --%>
		<%
// 		session.setAttribute("sId", request.getParameter("id"));
// 		response.sendRedirect("test3_login_main.jsp");
		%>
		<%-- 위의 코드와 동일한 작업을 JSTL 문법으로 수행 --%>
		<%-- 1. 세션 영역에 sId 변수를 지정하여 아이디 저장 --%>
		<%-- 주의! 세션 영역에 접근하려면 scope 속성에 session 지정 --%>
		<%-- 지정 가능한 scope 속성명 : page(기본값), request, session, application --%>
		<c:set var="sId" value="${param.id }" scope="session" />
		
		<%-- 2. test3_login_main.jsp 페이지로 리다이렉트 --%>
		<c:redirect url="test3_login_main.jsp" />
	</c:otherwise>
</c:choose>












