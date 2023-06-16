<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>dbcp_test3.jsp.jsp</h1>
	<%-- 버튼 4개 생성 --%>
	<%-- 1. INSERT 버튼(클릭 시 dbcp_test3_insert.jsp 페이지로 이동) --%>
	<%-- 2. UPDATE 버튼(클릭 시 dbcp_test3_update.jsp 페이지로 이동) --%>
	<%-- 3. DELETE 버튼(클릭 시 dbcp_test3_delete.jsp 페이지로 이동) --%>
	<%-- 4. SELECT 버튼(클릭 시 dbcp_test3_select.jsp 페이지로 이동) --%>
	<input type="button" value="INSERT" onclick="location.href='dbcp_test3_insert.jsp'">
	<input type="button" value="UPDATE" onclick="location.href='dbcp_test3_update.jsp'">
	<input type="button" value="DELETE" onclick="location.href='dbcp_test3_delete.jsp'">
	<input type="button" value="SELECT" onclick="location.href='dbcp_test3_select.jsp'">
</body>
</html>















