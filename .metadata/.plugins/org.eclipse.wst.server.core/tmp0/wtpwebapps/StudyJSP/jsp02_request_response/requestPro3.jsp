<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>requestPro3.jsp - 회원가입 처리</h1>
	<%
	// POST 방식 요청에 대한 한글 인코딩 방식 변경 필수!
	// => request 객체로부터 파라미터 접근 전에 수행해야한다!
	request.setCharacterEncoding("UTF-8");
	
	// requestForm3.jsp 페이지로부터 전달받은 파라미터 가져와서 변수에 저장
	String name = request.getParameter("name");
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	String jumin1 = request.getParameter("jumin1");
	String jumin2 = request.getParameter("jumin2");
	String email1 = request.getParameter("email1");
	String email2 = request.getParameter("email2");
	String job = request.getParameter("job");
	String gender = request.getParameter("gender");
	String[] hobbies = request.getParameterValues("hobby");
	String reason = request.getParameter("reason");
	%>
	
	<%-- 변수에 저장된 데이터들을 모두 출력 --%>
	이름 : <%=name %><br>
	아이디 : <%=id %><br>
	패스워드 : <%=passwd %><br>
	주민번호 : <%=jumin1 %>-<%=jumin2 %><br>
	E-mail : <%=email1 %>@<%=email2 %><br>
	직업 : <%=job %><br>
	성별 : <%=gender %><br>
	취미 : 
	<%for(String hobby : hobbies) { %>
		<%=hobby %> 
	<%} %>
	<br>
	가입동기 : <%=reason %><br>
	<hr>
	<table border="1">
		<tr>
			<th>이름</th>
			<td><%=name %></td>
		</tr>
		<tr>
			<th>ID</th>
			<td><%=id %></td>
		</tr>
		<tr>
			<th>비밀번호</th>
			<td><%=passwd %></td>
		</tr>
		<tr>
			<th>주민번호</th>
			<td><%=jumin1 %>-<%=jumin2 %></td>
		</tr>
		<tr>
			<th>E-Mail</th>
			<td><%=email1 %>@<%=email2 %></td>
		</tr>
		<tr>
			<th>직업</th>
			<td><%=job %></td>
		</tr>
		<tr>
			<th>성별</th>
			<td><%=gender %></td>
		</tr>
		<tr>
			<th>취미</th>
			<td>
				<%for(String hobby : hobbies) { %>
					<%=hobby %> 
				<%} %>
			</td>
		</tr>
		<tr>
			<th>가입동기</th>
			<td><%=reason %></td>
		</tr>
		<tr>
			<td colspan="2" align="center">
				<input type="button" value="돌아가기">
			</td>
		</tr>
	</table>
</body>
</html>















