<%@page import="jsp08_jstl.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test4_result.jsp</h1>
	<%
	// 자바 코드를 사용하여 request 객체의 데이터 가져오기
	// => getAttribute() 메서드 리턴타입이 Object 일 때 변수에 저장 시 형변환 필요
	//    Object 타입 -> X 타입으로 변환하기 위해 형변환 연산자 (X) 사용
	// 1) 번호(idx) 가져와서 저장
	int idx = (int)request.getAttribute("idx"); // Object -> int
	// 2) 이름(name) 가져와서 저장
	String name = (String)request.getAttribute("name"); // Object -> String
	%>
	<h3>번호 : <%=idx %></h3>
	<h3>이름 : <%=name %></h3>
	<%
	// "subjects" 라는 이름의 String[] 타입과 "person" 이라는 이름의 Person 객체 꺼내기
	String[] subjects = (String[])request.getAttribute("subjects");
	Person p = (Person)request.getAttribute("person");
	%>
	<%-- Person 객체의 name, age 멤버변수값 출력 --%>
	<h3>Person 객체의 name : <%=p.getName() %></h3>
	<h3>Person 객체의 age : <%=p.getAge() %></h3>
	<%-- subjects 배열을 차례대로 접근하여 값 출력(for문 활용) --%>
	<%-- 1) 일반 for문 활용 --%>
	<%for(int i = 0; i < subjects.length; i++) { %>
		<%=subjects[i] %>&nbsp;
	<%} %>
	<br>
	<%-- 2) 향상된 for문 활용 --%>
	<%for(String subject : subjects) { %>
		<%=subject %>&nbsp;
	<%} %>
	<hr>
	<%-- ================================================ --%>
	<%-- JSTL 과 EL 을 활용하여 동일한 작업 수행 --%>
	<%-- 1. request 객체의 idx, name 속성값 출력하기(속성명만 지정) --%>
	<h3>번호 : ${requestScope.idx }</h3> <%-- requestScope 객체를 통해 request 영역 접근 --%>
	<h3>번호 : ${idx }</h3> <%-- requestScope 객체는 생략 가능 --%>
	<h3>이름 : ${name }</h3>
	<%-- 2. person 객체의 name, age 멤버변수값 출력(person객체속성명.멤버변수명 으로 접근) --%>
	<%-- 주의! 멤버변수에 대한 Getter/Setter 정의 필수! (값 가져오는 Getter 필수) --%>
	<%-- ${person.name } 문장은 내부적으로 person 객체의 getName() 메서드를 호출한다! --%>
	<h3>Person 객체의 name : ${person.name }</h3>
	<h3>Person 객체의 age : ${person.age }</h3>
	
	<%-- ================================================ --%>
	<%-- 3. subjects 배열의 모든 값 출력 --%>
	<%-- JSTL 의 <c:forEach> 문을 사용하여 배열 인덱스를 차례대로 접근 --%>
	<%-- <c:forEach var="변수명" items="${객체(배열)명}">${변수명}</forEach> --%>
	<c:forEach var="subject" items="${subjects }">
		<%-- subjects 배열의 데이터를 차례대로 접근하면서 변수명 subject 에 저장 --%>
		${subject }&nbsp;
	</c:forEach>
	<hr>
	<%-- <c:forEach> 태그 사용법 --%>
	<%-- 
	1) 지정된 배열(또는 컬렉션 객체)을 차례대로 접근하면서 데이터 꺼내기(향상된 for문과 유사)
	   <c:forEach var="변수명" items="${객체(배열)명}"></c:forEach>
	   => items 에 지정된 객체에서 꺼낸 데이터를 var 속성으로 지정된 변수에 차례대로 저장
	   => 주의! items 속성에 지정할 대상 객체는 EL 문장 ${} 으로 표기(변수명도 동일하게 접근)
	 
	2) 특정 인덱스 범위만큼 반복하기(일반 for문과 유사)
	   <c:forEach var="변수명" begin="시작인덱스" end="끝인덱스" step="증감값"></c:forEach>
	   => step 속성 생략 시 기본값 1
	--%>
	<c:forEach var="i" begin="1" end="10"> <%-- i값이 1 ~ 10 까지 1씩 증가 --%>
		${i }&nbsp;
	</c:forEach>
	<hr>
	<c:forEach var="subject" items="${subjects }" varStatus="status">
		<%-- subjects 배열의 데이터를 차례대로 접근하면서 변수명 subject 에 저장 --%>
		<%-- varStatus 속성 사용 시 지정된 객체 상태 정보 관리(속성명.index 로 인덱스값 사용 가능) --%>
		${status.index } 번 배열 데이터 : ${subject }<br>
	</c:forEach>
	<hr>
	<%
	String[] hobbies = {"등산", "낚시", "게임"};
	String strHobby = "";
	// 배열 hobbies 차례대로 접근하면서 저장된 문자열을 strHobby 변수에 결합
	// => 이 때, 각 항목을 구분하기 위해 "/" 문자열을 구분자(Delimeter)로 사용
	//    ex) "등산/낚시/게임/"
	for(String hobby : hobbies) {
		strHobby += hobby + "/";
	}
	%>
	<h3>취미 : <%=strHobby %></h3>
	<%-- 
	<c:forTokens> 태그를 사용하여 문자열 분리하기
	=> 특정 기준 문자열(구분자 또는 분리자 = Delimeter)을 기준으로
	   지정된 문자열을 분리하는데 사용
	=> <c:forTokens items="대상문자열" delims="구분자기호"></c:forTokens>
	--%>
	<%-- 1) 자바에서 선언한 변수를 EL 에서 접근하기 위해 c:set 태그 사용 --%>
	<%-- => 또는 자바코드에서 pageContext.setAttribute("strHobby", strHobby); 도 사용 가능 --%>
	<c:set var="strHobby" value="<%=strHobby %>"></c:set>
	<%-- 
	2) strHobby 변수를 "/" 기호 기준으로 분리 후 
	   분리된 문자열을 차례대로 접근하여 변수명 hobby 에 저장 
	--%>
	<c:forTokens var="hobby" items="${strHobby }" delims="/">
		<%-- 3) 변수명 hobby 를 통해 분리된 문자열에 차례대로 접근 --%>
		${hobby }<br>
	</c:forTokens>
	
	
	&lt;c:set&gt;
</body>
</html>












