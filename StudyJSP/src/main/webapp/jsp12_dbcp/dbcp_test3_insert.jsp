<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>dbcp_test3_insert.jsp</h1>
	<%-- 번호, 이름, 나이, 이메일 입력받는 form 태그 작성(확인, 취소 버튼 추가) --%>
	<%-- form 태그에서 submit 동작 시 이동할 액션 : dbcp_test3_insert_pro.jsp --%>
	<form action="dbcp_test3_insert_pro.jsp" method="post">
		<table border="1">
			<tr>
				<th>번호</th>
				<td><input type="text" name="idx"></td>
			</tr>
			<tr>
				<th>이름</th>
				<td><input type="text" name="name"></td>
			</tr>
			<tr>
				<th>나이</th>
				<td><input type="text" name="age"></td>
			</tr>
			<tr>
				<th>이메일</th>
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














