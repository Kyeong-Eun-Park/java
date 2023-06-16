<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>dbcp_test3_delete.jsp</h1>
	<%-- 번호(idx)를 입력받아 해당 번호와 일치하는 레코드 DELETE --%>
	<%-- submit 버튼 클릭 시 dbcp_test3_delete_pro.jsp 페이지로 이동하여 삭제 --%>
	<form action="dbcp_test3_delete_pro.jsp" method="post">
		삭제할 번호 <input type="text" name="idx"><br>
		<input type="submit" value="삭제">
		<input type="button" value="취소" onclick="history.back()">
	</form>
</body>
</html>















