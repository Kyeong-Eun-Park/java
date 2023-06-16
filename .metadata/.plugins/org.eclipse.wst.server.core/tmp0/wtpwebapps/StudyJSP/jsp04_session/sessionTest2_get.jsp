<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>sessionTest2_get.jsp</h1>
	<h3>세션에 저장된 값 1 : <%=session.getAttribute("sessionValue1") %></h3>
	<h3>세션에 저장된 값 2 : <%=session.getAttribute("sessionValue2") %></h3>
	<%--
	sessionTest2_set.jsp 페이지에서 저장한 세션값은 다른 페이지로 이동 시에도 존재하며
	다른 페이지에서 세션 객체를 통해 해당 값에 접근이 가능하다!
	단, 웹브라우저를 완전히 종료하거나, 타이머(기본 30분)가 만료되거나
	또는 session.invalidate() 메서드를 호출하게 되면 저장된 세션값이 모두 제거됨(= 접근 불가)
	=> 즉, 새로운 세션 객체가 생성되어 기존 데이터가 존재하지 않는다! (null 값 리턴됨)
	--%>
	<hr>
	<%-- 하이퍼링크 사용하여 "sessionTest2.jsp 로 돌아가기" 클릭 시 해당 페이지로 이동 --%>
	<a href="sessionTest2.jsp">sessionTest2.jsp 로 돌아가기</a>
</body>
</html>















