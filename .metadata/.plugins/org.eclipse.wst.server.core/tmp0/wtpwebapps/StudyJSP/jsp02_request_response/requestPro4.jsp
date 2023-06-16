<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
	// 로그인 화면에서 입력받은 아이디, 패스워드 출력
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	%>
	<h3>아이디 : <%=id %></h3>
	<h3>패스워드 : <%=passwd %></h3>
	
	<%
	// 아이디가 "admin" 이고, 패스워드가 "1234" 이면 "로그인 성공" 출력, 
	// 아니면 "로그인 실패" 출력
// 	if(id.equals("admin") && passwd.equals("1234")) {
// 		out.print("<h3>로그인 성공</h3>");
// 	} else {
// 		out.print("<h3>로그인 실패</h3>");
// 	}
	%>
	<hr>
<%-- 	<%if(id.equals("admin") && passwd.equals("1234")) {%> --%>
<!-- 		<h3>로그인 성공</h3> -->
<%-- 	<%} else {%> --%>
<!-- 		<h3>로그인 실패</h3> -->
<%-- 	<%}%> --%>
	
	<%-- ============================================== --%>
	<%-- 로그인 성공 시 자바스크립트를 사용하여 requestPro4_responseResult1.jsp 로 이동 --%>
	<%-- 로그인 실패 시 자바스크립트를 사용하여 requestPro4_responseResult2.jsp 로 이동 --%>
	<%if(id.equals("admin") && passwd.equals("1234")) {%>
		<script type="text/javascript">
			// location 객체의 href 속성에 이동할 페이지 지정
// 			location.href = "requestPro4_responseResult1.jsp";
		</script>
	<%} else {%>
		<script type="text/javascript">
// 			alert("로그인 실패!");
// 			location.href = "requestPro4_responseResult2.jsp";
		</script>
	<%}%>
	<%-- ============================================== --%>
	<%--
	JSP 내장객체 중 response 객체의 sendRedirect() 메서드를 사용하여 
	자바스크립트의 location.href 속성과 동일한 작업 수행
	=> 기본 문법 : response.sendRedirect("이동할 페이지");
	=> GET 방식 요청
	--%>
	<%
	if(id.equals("admin") && passwd.equals("1234")) {
		// requestPro4_responseResult1.jsp 페이지로 이동
		response.sendRedirect("requestPro4_responseResult1.jsp");
	} else {
		%>
		<script type="text/javascript">
			alert("로그인 실패!");
			// 주의! alert() 함수 등 다이얼로그 표시 등의 기능을 수행하는 코드와
			// 자바의 response.sendRedirect() 메서드를 차례대로 수행하는 경우
			// 페이지 이동 과정에서 다이얼로그 표시 기능이 동작하지 않는다!
			// => 즉, alert 창 표시되지 않고, 즉시 페이지 이동
			// => 따라서, alert() 함수 등을 실행해야 하는 경우 location.href 로 이동
// 			location.href = "requestPro4_responseResult2.jsp";
			
			history.back(); // 이전 페이지로 돌아가기
		</script>
		<%
		// requestPro4_responseResult1.jsp 페이지로 이동
// 		response.sendRedirect("requestPro4_responseResult2.jsp");
	}
	%>
</body>
</html>












