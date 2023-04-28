<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>dbcp_test3_update.jsp</h1>
	<form action="dbcp_test3_update_pro.jsp" method="post">
		<table border="1">
			<tr>
				<th>찾을 번호</th>
				<td><input type="text" name="idx"></td>
			</tr>
			<tr>
				<th>변경할 이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>변경할 나이</th>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<th>변경할 이메일</th>
				<td><input type="text" name="email"></td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="확인">
					<input type="button" value="취소" onclick="history.back()">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>