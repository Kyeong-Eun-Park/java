<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>forwardPro2.jsp</h1>
	<%
	// POST 방식 요청 파라미터에 대한 한글 인코딩 설정
	request.setCharacterEncoding("UTF-8");
	
	// forwardForm.jsp 페이지의 폼에서 입력받은 폼 파라미터(아이디, 패스워드, 이름) 가져오기
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String name = request.getParameter("name");
	
	// 직접 입력받지 않고, input type="hidden" 태그로 전달한 파라미터로 가져오기
	String pageNum = request.getParameter("pageNum");
	
	// forward 액션 태그에서 param 태그를 사용하여 전달한 파라미터(str) 가져오기
	String str = request.getParameter("str");
	
	// forward 액션 태그에서 param 태그를 사용하여 전달한 파라미터(num) 가져오기
// 	String num = request.getParameter("num");
	// 만약, int 타입 변수에 저장하는 경우 Integer.parseInt() 메서드 사용
	int num = Integer.parseInt(request.getParameter("num"));
	%>
	<h3>아이디 : <%=id %></h3>
	<h3>패스워드 : <%=passwd %></h3>
	<h3>이름 : <%=name %></h3>
	<h3>페이지번호 : <%=pageNum %></h3>
	<hr>
	<h3>str : <%=str %></h3>
	<h3>num : <%=num %></h3>
</body>
</html>














