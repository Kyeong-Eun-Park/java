<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
// 이 곳은 JSP 선언문(Declaration)으로 JSP 파일 전체 영역에서 사용 가능한
// 멤버변수 선언 및 메서드 정의하는 곳입니다.
// => 자바 클래스의 멤버레벨(클래스 내부, 메서드 외부)에 변수 및 메서드 위치와 동일
String str1 = "멤버(전역) 변수입니다."; // 멤버변수 선언

// 메서드 정의
public void method1() {
	// JSP 파일에서는 System.out.println() 메서드에 대한 어시스트 기능이 동작하지 않음!
	System.out.println("선언문 내의 method1() 메서드 호출됨!");
}

// 메서드 정의
// String 타입의 "method2() 메서드의 리턴값" 문자열을 리턴하는 method2() 메서드 정의
public String method2() {
	return "method2() 메서드의 리턴값";
}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>test2.jsp</h1>
	<%--
	표현식 <%= %>
	- 선언문 또는 스크립틀릿 내에서 선언된 변수에 접근하여 값을 출력하거나
	  리턴값을 갖는 메서드를 호출하여 리턴되는 값을 출력하는 용도로 사용
	- 자바의 System.out.print() 메서드와 동일한 구조, 동일한 역할을 수행하지만,
	  System.out.print() 메서드는 이클립스 콘솔창에 데이터를 출력하고,
	  표현식은 웹페이지 바디 영역에 출력됨. 따라서, JSP 의 out.print() 와 완전히 동일함.
	  (주의! 표현식 내부에는 반드시 출력할 데이터를 명시해야한다!)
	- 내부에 기술되는 변수명 또는 메서드명 뒤에는 세미콜론(;)이 없다!
	--%>
	<h3>멤버변수 str1 = <%=str1 %></h3>
	
	<%-- 리턴값이 있는 메서드는 표현식에서 호출 가능(리턴값을 출력할 수 있기 때문) --%>
	<h3>method2() 메서드 호출 결과 : <%=method2() %></h3>
	
	<%-- 리턴값이 없는 메서드는 표현식에서 호출 불가능(출력할 데이터가 없기 때문) - 실행 오류 발생! --%>
<%-- 	<h3>method1() 메서드 호출 결과 : <%=method1() %></h3> --%>
	<%--
	JSP 파일 [/jsp01/test2.jsp]의 [44] 행에서 오류가 발생했습니다.
	The method print(boolean) in the type JspWriter is not applicable for the arguments (void)
	--%>
	
	
	
	<%--
	스크립틀릿 <% %>
	- 자바의 실행문을 그대로 표현 가능한 블럭
	- 스크립틀릿 내부는 자바에서 메서드 내부와 동일한 위치
	  => 메서드 내에서 수행 가능한 작업들을 코드로 기술 가능
	  => 선언되는 변수는 로컬(지역) 변수로 취급됨
	  => 메서드 정의 불가능
	  => 자바 코드로 body 영역에 데이터 출력을 위해서 out.print() 또는 out.println() 사용
	--%>
	<%-- 표현식 대신 스크립틀릿 내부에 out.print() 메서드로 str1 변수값 출력 --%>
	<h3>멤버변수 str1 = <%out.print(str1); %></h3>
	
	<%-- 스크립틀릿 내부에서 선언된 변수는 선언 위치보다 윗쪽에서 접근 불가능! --%>
<%-- 	<h3>로컬변수 str2 = <%=str2 %></h3> str2 cannot be resolved to a variable --%>
	
	<%
	// 이 곳은 스크립틀릿 내부입니다.
	// 변수 선언이 가능하며, 해당 변수는 로컬 변수로 취급됨
	String str2 = "로컬(지역) 변수입니다.";
			
	// 스크립틀릿 내에서 다른 메서드를 호출하거나, 객체(인스턴스) 생성 등의 다양한 작업도 가능
	method1();
	
	// System.out.println() 또는 print() 메서드를 호출하여 이클립스 콘솔에 출력도 가능
	System.out.println("이 문장은 이클립스 콘솔에 출력됨!");
	
	// out.println() 또는 print() 메서드를 호출하여 웹브라우저에 출력도 가능
	// => 문자열 형태로 HTML 태그(자바스크립트 포함)도 그대로 사용 가능함
	out.print("<h3>스크립틀릿에서 출력한 문자열 데이터</h3>");
	
	// 스크립틀릿 내부에서 메서드 정의는 불가!
	// => 자바 문법 상 메서드 내에서 메서드 정의 불가!
// 	public void method3() {} // 오류 발생!
	%>
	
	<h3>로컬변수 str2 = <%=str2 %></h3>
	
	<%-- 선언문에서 선언되는 변수는 선언문보다 윗쪽에서 접근 가능 --%>
	<h3>멤버변수 str3 = <%=str3 %></h3>
	
	<%-- 선언문을 사용하여 str3 멤버변수 선언하고, "멤버변수 str3 입니다" 로 초기화 --%>
	<%! String str3 = "멤버변수 str3 입니다."; %>
	<h3>멤버변수 str3 = <%=str3 %></h3>
	
	
</body>
</html>















