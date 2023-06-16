<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>forwardForm.jsp</h1>
	<form action="forwardPro.jsp" method="post">
		<%--
		form 태그를 통해 데이터 입력받을 때 GET 또는 POST 방식에서
		직접 입력받는 데이터 외에 별도의 데이터를 포함시켜 전달해야하는 경우
		(ex. 게시판에서 페이지 번호 등)
		<input type="hidden" name="파라미터명" value="전달할데이터"> 태그 사용
		=> 전달받은 페이지에서 동일하게 request.getParameter() 메서드로 접근 가능 
		--%>
		<%-- 현재 페이지 번호(1)를 "pageNum" 이라는 속성명으로 전달 --%>
		<input type="hidden" name="pageNum" value="1">
		
		<%-- 사용자로부터 입력받을 데이터 --%>
		아이디 : <input type="text" name="id"><br>
		패스워드 : <input type="password" name="passwd"><br>
		이름 : <input type="text" name="name"><br>
		
		<input type="submit" value="전송">
	</form>
</body>
</html>











