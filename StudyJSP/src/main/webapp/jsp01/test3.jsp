<%@page import="java.util.Calendar"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%
// 스크립틀릿(자바 메서드 내부와 동일) - 선언되는 변수는 모두 로컬변수
Calendar c = Calendar.getInstance();
int hour = c.get(Calendar.HOUR_OF_DAY); // 시
int min = c.get(Calendar.MINUTE); // 분
int sec = c.get(Calendar.SECOND); // 초
%>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test3.jsp</h1>
	<h1>스크립틀릿과 표현식 연습</h1>
	<%-- 스크립틀릿 내에서 선언된 변수(로컬 변수)는 표현식으로 출력 가능 --%>
	<h3>현재 시각은 <%=hour %>시 <%=min %>분 <%=sec %>초 입니다.</h3>
	
	<%--
	스크립틀릿 내에서는 자바 실행문 기술이 가능하므로 if 문 등의 문장 사용도 가능
	=> 따라서, HTML 태그를 특정 조건에서만 실행되도록 하려면
	   if 문 블록과 HTML 태그를 조합하여 조건에 따른 HTML 문장 실행
	   
	< 자바 코드와 HTML 태그 조합 방법 - 2가지 >
	- 자바 문장과 HTML 태그 조합하여 조건에 따른(또는 반복에 따른) HTML 문장 실행 위해서는
	1. 스크립틀릿 내에서 출력할 데이터(HTML 태그 등)만 out.print() 메서드로 출력하는 방법
	   => 주로, 자바 코드가 많고, HTML 태그가 적을 경우 사용
	2. 스크립틀릿 내에서 조건문 등의 실행문을 지정하고, 스크립틀릿 외부에 HTML 태그 작성
	   => 주로, HTML 태그가 많고, 자바 코드가 적을 경우 사용
	--%>
	<%
	// 1. 스크립틀릿 내에서 출력할 데이터(HTML 태그 등)만 out.print() 메서드로 출력하는 방법
	// if 문을 사용하여 현재 시각(hour)이 12 미만이면 "오전입니다." 출력하고
	// 아니면, "오후입니다." 출력
	if(hour < 12) {
		// 블럭 내에서 출력할 내용(태그 등)을 out.print() 메서드 내부에 문자열로 기술
		out.print("<h3>오전입니다.</h3>");
	} else {
		out.print("<h3>오후입니다.</h3>");
	}
	// => 웹브라우저에서 소스보기를 통해 볼 수 있는 코드는
	//    이미 서버에서 처리가 끝난 후 결과만 전송되어진 코드이므로
	//    오전 또는 오후 출력문(태그)만 보이고, 다른 한 문장은 보이지 않는다!
	%>
	<hr>
	<%
	// 2. 스크립틀릿 내에서 조건문 등의 실행문을 지정하고, 스크립틀릿 외부에 HTML 태그 작성
	// => 문장의 블록문 사이에 스크립틀릿을 단절시킨 후 HTML 태그를 직접 표현
	if(hour < 12) {
	%>
		<%-- 이 영역은 스크립틀릿 외부이므로 HTML 태그를 작성 가능(자바코드 작성 불가!) --%>
		<h3>오전입니다.</h3>
	<%	
	} else {
	%>
		<%-- 이 영역은 스크립틀릿 외부이므로 HTML 태그를 작성 가능(자바코드 작성 불가!) --%>
		<h3>오후입니다.</h3>
	<%	
	}
	%>
	<hr>
	<%if(hour < 12) {%>
		<h3>오전입니다.</h3>
	<%} else {%>
		<h3>오후입니다.</h3>
	<%}%>
	
	<hr>
	<%
	// for문을 사용하여 1 ~ 10 까지 정수를 차례대로 웹브라우저에 출력
	for(int i = 1; i <= 10; i++) {
// 		out.print(i + " ");
		%><%=i %> <%
	}
	%>
	
</body>
</html>
















