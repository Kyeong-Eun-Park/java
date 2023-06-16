<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- JSP 에서 GET 방식 요청은 page 디렉티브(@page) 에 pageEncoding="UTF-8" 로 처리됨 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>requestPro2.jsp - 로그인 처리</h1>
	<%
	// 아이디, 패스워드 파라미터 가져와서 변수에 저장 후 출력
	String id = request.getParameter("id");
	String passwd = request.getParameter("passwd");
	%>
	<h3>아이디 : <%=id %></h3>
	<h3>패스워드 : <%=passwd %></h3>
	
	<%--
	입력받은 아이디와 패스워드에 대해 로그인 성공 여부 판별
	임시) 아이디가 "admin" 이고, 패스워드가 "1234" 일 경우 성공, 아니면 실패로 판별
	1차) 로그인 성공 시 "로그인 성공!" 출력, 실패 시 "로그인 실패!"
	2차) 로그인 성공 시 자바스크립트로 "로그인 성공!" 출력, 
	     실패 시 자바스크립트로 "로그인 실패!" 후 이전페이지로 돌아가기
	-------------------------------------------------------------------------------
	주의! 자바 코드 내에서 문자열 데이터에 대한 일치 여부를 판별할 때
	동등비교연산자(==) 대신 String 객체의 equals() 메서드를 사용한다!
	
	< 기본 문법 >
	if(변수명.equals(변수명 또는 "비교할문자열")) {}
	ex) id.equals("admin") 형태로 판별
	=> 판별 결과가 boolean 타입 형태로 리턴(true : 일치, false : 불일치)
	--%>
	<%if(id.equals("admin") && passwd.equals("1234")) { %>
		<script type="text/javascript">
			alert("로그인 성공!");
		</script>
	<%} else { %>
		<script type="text/javascript">
			alert("로그인 실패!");
			history.back();
		</script>
	<%}	%>
</body>
</html>
















