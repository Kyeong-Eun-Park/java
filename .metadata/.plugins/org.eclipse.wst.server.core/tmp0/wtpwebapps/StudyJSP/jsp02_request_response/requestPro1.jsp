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
	<h1>requestPro1.jsp</h1>
	<h1>request 객체 처리 페이지</h1>
	<%
	/*
	requestForm1.jsp 페이지에서 submit 버튼 클릭 시
	form 태그 내의 데이터(= 폼 파라미터)가 request 객체에 모두 저장되고
	action 속성에 지정된 페이지로 이동(= 요청)하면서 데이터 전달됨
	=> 요청 관련 모든 정보는 request 객체가 관리(= JSP 가 자동으로 생성하는 객체 = 내장 객체)
	   따라서, request.메서드명() 형태로 request 객체에 접근 가능
	=> 요청받은 request 객체에 저장된 폼 파라미터 데이터를 가져오는 방법
	   1) request.getParameter("파라미터명"); // 단일 항목 데이터 가져오기(String 타입 리턴)
	   2) request.getParameterValues("파라미터명"); // 복수 항목 파라미터 가져오기(String[] 타입 리턴)
	   => "파라미터명"에 해당하는 부분은 폼 요소의 name 속성값을 지정해야한다!
	   => 주의! 전달받은 파라미터가 존재하지 않을 경우(지정한 이름이 없을 경우) 
	   	  null 값이 리턴되고, 파라미터는 있으나 데이터가 없는 경우 널스트링("") 이 리턴됨
	*/
	// ------------------------------------------------------------------------------------
	// POST 방식 요청으로 폼 파라미터가 전달될 경우 한글 인코딩 방식 변경 처리
	// => 반드시 응답페이지(데이터를 실제로 가져와서 사용하는 곳)에서 설정
	// => request 객체의 setCharacterEncoding() 메서드를 호출하여
	//    인코딩 방식 지정("UTF-8")
	request.setCharacterEncoding("UTF-8");
	// => 주의! 파라미터 값을 가져오는 코드(request.getParameter())보다 먼저 수행해야한다!
	// ------------------------------------------------------------------------------------
	// 1. 파라미터 중 파라미터명(name 속성값)이 "name" 인 값을 가져와서 strName 변수에 저장
	//    이 때, 리턴타입이 String 타입이므로 String 타입 변수에 저장
	String strName = request.getParameter("name");
	// 웹브라우저에 파라미터 데이터(이름) 출력하기
// 	out.print("이름 : " + strName + "<br>");
	
	// 2. 파라미터 중 파라미터명(name 속성값)이 "age" 인 값을 가져와서 strAge 변수에 저장
	String strAge = request.getParameter("age");
// 	out.print("나이 : " + strAge + "<br>");
	// => 주의! 정수 데이터도 getParameter() 로 가져올 경우 무조건 문자열로 취급됨!
	//    따라서, 만약, 연산 등을 위해 정수형태로 변환해야할 경우 추가 작업 필요
	// => Integer.parseInt("정수문자열") 호출 시 int 타입 정수 리턴됨
// 	int age = Integer.parseInt(strAge);
// 	out.print("나이(정수) : " + age + "<br>");
	
	// 3. 파라미터 중 파라미터명(name 속성값)이 "gender" 인 값을 가져와서 strGender 변수에 저장
	String strGender = request.getParameter("gender");
// 	out.print("성별 : " + strGender + "<br>");
	
	// 4. 파라미터 중 파라미터명(name 속성값)이 "hobby" 인 값을 가져와서 strHobby 에 저장
// 	String strHobby = request.getParameter("hobby");
// 	out.print("취미 : " + strHobby + "<br>"); // 무조건 첫번째 체크 항목만 출력됨
	// 주의! 복수개의 데이터가 하나의 파라미터로 전달되는 경우(ex. 체크박스)
	// getParameter() 메서드를 사용 시 하나의 데이터(첫번째)만 리턴함
	// 따라서, getParameter() 메서드 대신 getParameterValues() 메서드를 호출하여
	// 복수개의 동일한 이름의 파라미터를 String[] 타입(배열)으로 리턴받아 처리해야함
	String[] strHobbies = request.getParameterValues("hobby");
// 	out.print("취미 : " + strHobbies + "<br>");
	// => 배열 데이터이므로 직접 출력은 의미가 없다! (참조값이 출력됨)
	// 반복문을 사용하여 배열에 접근 후 각 인덱스의 값을 출력해야함
// 	out.print("취미 : ");
// 	for(int i = 0; i < strHobbies.length; i++) {
// 		out.print(strHobbies[i] + " ");
// 	}

// 	for(String strHobby : strHobbies) {
// 		out.print(strHobby + " ");
// 	}
	%>
	
	<table border="1">
		<tr>
			<td>이름</td>
			<td><%=strName %></td>
		</tr>
		<tr>
			<td>나이</td>
			<td><%=strAge %></td>
		</tr>
		<tr>
			<td>성별</td>
			<td><%=strGender %></td>
		</tr>
		<tr>
			<td>취미</td>
			<td>
				<%
				for(String strHobby : strHobbies) {
					out.print(strHobby + " ");
				}
				%>
			</td>
		</tr>
	</table>
	<hr>
	<%-- request 객체의 부가적인 메서드 --%>
	<h3>서버 도메인명 : <%=request.getServerName() %></h3>
	<h3>서버 포트번호 : <%=request.getServerPort() %></h3>
	<h3>요청 URL : <%=request.getRequestURL() %></h3>
	<h3>요청 URI : <%=request.getRequestURI() %></h3>
	<h3>클라이언트 IP 주소 : <%=request.getRemoteAddr() %></h3>
	<h3>요청 프로토콜 : <%=request.getProtocol() %></h3>
	<h3>요청 방식 : <%=request.getMethod() %></h3>
	<h3>컨텍스트 경로 : <%=request.getContextPath() %></h3>
</body>
</html>
















