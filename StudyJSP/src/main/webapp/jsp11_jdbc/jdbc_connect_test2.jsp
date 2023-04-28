<%@page import="java.sql.Connection"%>
<%@page import="java.sql.DriverManager"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>jdbc_connect_test2.jsp</h1>
	<%
	// JDBC 연결 4단계
	// 1단계. JDBC 드라이버 클래스 로드
	String driver = "com.mysql.cj.jdbc.Driver";
	Class.forName(driver);
	%>
	<h3>드라이버 로드 성공!</h3>
	
	<%
	// 2단계. DB 연결
	// java.sql.DriverManager 클래스의 static 메서드 getConnection() 메서드 호출
	// 1) 접속에 필요한 정보 문자열을 변수에 저장
	String url = "jdbc:mysql://localhost:3306/study_jsp3";
	String user = "root";
	String password = "1234";
	// 2) getConnection() 메서드에 3가지 파라미터를 전달하여 DB 연결
	// => 이 때, DB 연결에 성공했을 경우 java.sql.Connection 타입 객체가 리턴됨
	Connection con = DriverManager.getConnection(url, user, password);
	%>
	<h3>DB 연결 성공!</h3>
	<%--
	2단계까지는 데이터베이스 제품(Oracle, MySQL 등)별로 정보가 다름(드라이버 클래스도 다름)
	3단계부터는 실제 데이터베이스 내에서 SQL 구문 실행을 담당하므로 공통 작업에 해당
	(즉, SQL 구문이 동일한 경우 코드가 완전히 동일)
	--%>
</body>
</html>















