<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
request.setCharacterEncoding("UTF-8");
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test3_result.jsp</h1>
	<%-- EL 을 사용하여 파라미터 name, age 변수값 출력 --%>
	<h3>파라미터 name = ${param.name }, 파라미터 age = ${param.age }</h3>
	<%-- JSTL 을 사용하여 변수 num 에 정수 10 저장 후 출력 --%>
	<c:set var="num" value="10" />
	<h3>변수 num = ${num }</h3>
	
	<hr>
	<%--
	[ 조건문 - if문 ]
	- <c:if> 태그 : 자바의 if문에 해당하는 커스텀 태그
	- 단일 if문과 동일(else 문이 없음)
	
	<c:if test="조건식">   // 조건식은 EL 연산 활용
		// 조건식 판별 결과가 true 일 때 실행할 문장들...
	</c:if>
	
	--%>
	<%-- 변수 num 값이 0보다 큰가? --%>
	<c:if test="${num > 0 }">
		<%-- if문 판별 결과가 true 일 때 실행할 코드를 기술하는 공간(시작태그와 끝태그 사이) --%>
		<h3>
		\${num } 값이 0 보다 크다!<br>
		따라서, 이 문장은 현재 페이지에서 출력된다!
		</h3>
	</c:if>
	<hr>
	<%-- 파라미터 age 값이 20 이상인가? 맞으면 "성인이시네요!" 출력 --%>
	<c:if test="${param.age >= 20 }">
		<h3>성인이시네요!</h3>
	</c:if>
	<%-- else 문에 해당하는 문장이 없으므로, 또 다른 c:if 태그 사용하여 다른 경우의 수 판별 --%>
	<%-- 파라미터 age 값이 20 미만인가? 맞으면 "미성년이시네요!" 출력 --%>
	<c:if test="${param.age < 20 }">
		<h3>미성년이시네요!</h3>
	</c:if>
	<hr>
	<%--
	<c:choose> <c:when> <c:otherwise> 태그
	- if ~ else 문 또는 if ~ else if ~ else 문에 해당하는 커스텀 태그
	- <c:choose> 태그를 사용하여 조건문이라는 표시를 달고
	  <c:when> 태그를 사용하여 조건식을 지정(복수개 사용 시 else if 문이 됨)하고
	  <c:otherwise> 태그를 사용하여 조건식 판별 결과가 false 일 때 수행할 문장을 기술(= else 문과 동일)
	  
	<c:choose>
		<c:when test="조건식1">
			// 조건식1 이 true 일 때 실행할 문장들...
		</c:when>
		<c:when test="조건식2">
			// 조건식2 가 true 일 때 실행할 문장들...
		</c:when>
		<c:otherwise>
			// 조건식이 모두 false 일 때 실행할 문장들...(= else 문) => 생략 가능
		</c:otherwise>
	</c:choose>
	--%>
	<c:set var="num2" value="0" />
	<%-- 변수 num2 에 대해 양수, 음수, 0 판별 --%>
	<c:choose>
		<c:when test="${num2 > 0 }"> <%-- num2 가 0보다 클 경우 = 양수 --%>
			<h3>num2(${num2 }) : 양수!</h3>
		</c:when>
		<c:when test="${num2 < 0 }"> <%-- num2 가 0보다 작을 경우 = 음수 --%>
			<h3>num2(${num2 }) : 음수!</h3>
		</c:when>
		<c:otherwise> <%-- 위의 두 조건이 모두 false 일 때(else 문과 같으므로 조건 불필요) --%>
			<h3>num2(${num2 }) : 양수도 아니고 음수도 아님!</h3>
		</c:otherwise>
	</c:choose>
	<hr>
	<%-- 
	파라미터 name 값에 대해 "홍길동", "이순신", 비어있을 경우, 그 외 나머지 판별(4가지 경우)
	=> "홍길동" 일 경우 "홍길동입니다!" 출력, "이순신" 일 경우 "이순신입니다!" 출력
	=> 비어있을 경우 자바스크립트를 사용하여 "이름 입력 필수!" 출력 후 이전 페이지로 돌아가기
	=> 그 외 나머지는 "그 외 나머지!" 출력
	--%>
	<c:choose>
		<c:when test="${param.name eq '홍길동' }">
			<h3>홍길동입니다!</h3>
		</c:when>
		<c:when test="${param.name eq '이순신' }">
			<h3>이순신입니다!</h3>
		</c:when>
		<c:when test="${empty param.name }">
			<script type="text/javascript">
				alert("이름 입력 필수!");
				history.back();
			</script>
		</c:when>
		<c:otherwise>
			<h3>그 외 나머지!</h3>
		</c:otherwise>
	</c:choose>
</body>
</html>
















