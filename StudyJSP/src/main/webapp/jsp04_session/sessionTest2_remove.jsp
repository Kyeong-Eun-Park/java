<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>sessionTest2_remove.jsp</h1>
	<%--
	하이퍼링크 또는 버튼
	"세션값1 삭제" => sessionTest2_remove1.jsp
	"세션값2 삭제" => sessionTest2_remove2.jsp
	"세션 초기화" => sessionTest2_invalidate.jsp
	--%>
	<a href="sessionTest2_remove1.jsp">세션값1 삭제</a>
	<a href="sessionTest2_remove2.jsp">세션값2 삭제</a>
	<a href="sessionTest2_invalidate.jsp">세션 초기화</a>
	<hr>
	<input type="button" value="세션값1 삭제" onclick="location.href='sessionTest2_remove1.jsp'">
	<input type="button" value="세션값2 삭제" onclick="location.href='sessionTest2_remove2.jsp'">
	<input type="button" value="세션 초기화" onclick="location.href='sessionTest2_invalidate.jsp'">
</body>
</html>










