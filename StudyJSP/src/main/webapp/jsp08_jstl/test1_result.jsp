<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test1_result.jsp</h1>
	<%-- 기존 자바 코드를 활용한 세션값과 파라미터 처리 방법 --%>
	<%
	// 세션값(속성명 testValue) 가져와서 변수 value 에 저장
	// Object 타입 -> String 타입으로 형변환 필요
	String value = (String)session.getAttribute("testValue");
	
	// POST 방식 요청에 대한 request 파라미터 인코딩 설정 변경
	request.setCharacterEncoding("UTF-8");
	
	// 파라미터(name, age) 가져와서 각각의 변수에 저장
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age")); // String -> int 형변환 필요
	%>
	<h3>세션값 : <%=value %></h3>
	<h3>이름 : <%=name %></h3>
	<h3>나이 : <%=age %></h3>
	<hr>
	<h3>세션값 : <%=session.getAttribute("testValue") %></h3>
	<h3>이름 : <%=request.getParameter("name") %></h3>
	<h3>나이 : <%=request.getParameter("age")%></h3>
	<hr>
	<%-- 
	============================================================================== 
	EL 을 사용하여 request 객체의 파라미터 및 session 객체의 속성값 처리
	=> EL 내장 객체 param 과 sessionScope 활용
	   ${param.파라미터명}
	   ${sessionScope.속성명}
	=> EL 의 param 객체는 request 객체와 동일한 작업 수행
	   (즉 ${param.xxx} 과 request.getParameter("xxx") 은 동일하다! - 한글 인코딩 처리 적용받음)
	=> 특이사항> EL 문법을 텍스트로 인식하게 하려면(파싱되지 않게 하려면) 앞에 \ 기호 붙임
	--%>
	<h3>세션값(\${sessionScope.testValue }) : ${sessionScope.testValue }</h3>
	<h3>이름(\${param.name }) : ${param.name }</h3>
	<h3>나이(\${param.age }) : ${param.age }</h3>
	<hr>
	
	<%-- EL 의 연산자 --%>
	<%-- EL 의 연산자는 ${} 내부에서 다른 값과 함께 사용 --%>
	<h3>\${10 + 20 } = ${10 + 20 }</h3>
	<%-- 파라미터값을 연산자를 통해 연산도 가능하며, 숫자 데이터의 경우 형변환 생략 가능--%>
	<h3>\${param.age + 20 } = ${param.age + 20 }</h3>
	<%-- 산술 연산일 경우 연산이 가능한 데이터를 제외한 나머지는 오류 발생! --%>
<%-- 	<h3>\${param.name + 20 } = ${param.name + 20 }</h3>  --%>
	<%-- 연산자 기호를 사용하거나 기호에 대응하는 연산자명을 사용해도 된다! --%>
	<h3>\${10 >= 20 } = ${10 >= 20 }</h3>
	<h3>\${10 ge 20 } = ${10 ge 20 }</h3>
	<%-- empty 연산자 사용 시 null 값 또는 값이 비어있거나 사이즈가 0 일 경우 true 리턴 --%>
	<h3>\${empty param.name } = ${empty param.name }</h3> <%-- name 파라미터의 값이 없음(true) --%>
	<h3>\${empty param.name1 } = ${empty param.name1 }</h3> <%-- name1 파라미터가 없음(true) --%>
	<%-- 
	주의! 동등비교연산에 사용되는 eq 와 null 을 조합하여 eq null 값 비교 시
	진짜 null 값이 저장된 경우에만 true 가 리턴됨
	--%>
	<h3>\${param.name eq null } = ${param.name eq null }</h3>
	<h3>\${param.name ne null } = ${param.name ne null }</h3>
</body>
</html>












