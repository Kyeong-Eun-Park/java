<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<div align="right">
	<%
	String sId = (String)session.getAttribute("sId");
	if(sId == null) {
		%><a href="sessionTest3_login_form.jsp">로그인</a> | <a href="sessionTest3_join_form.jsp">회원가입</a><%
	} else {
		%><%=session.getAttribute("sId") %> 님 | <a href="sessionTest3_logout.jsp">로그아웃</a><%
	}
	%>
</div>
<div align="center">
	<h1>includeTest3_top.jsp</h1>
	<a href="includeTest3.jsp">HOME</a> 상단메뉴1 상단메뉴2 상단메뉴3 상단메뉴4 상단메뉴5
</div>











