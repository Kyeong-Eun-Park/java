<%@page import="java.sql.PreparedStatement"%>
<%@page import="jsp12_dbcp.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>dbcp_test3_insert.jsp</h1>
	<%
	/*
	test3 테이블 생성
	번호(idx) - 정수
	이름(name) - 문자 10자
	나이(age) - 정수
	E-mail(email) - 문자 50자
	
	CREATE TABLE test3 (
		idx INT,
		name VARCHAR(10),
		age INT,
		email VARCHAR(50)
	);
	*/
	// 번호, 이름, 나이, 이메일 값을 test3 테이블에 INSERT
	int idx = 1;
	String name = "홍길동";
	int age = 20;
	String email = "hong@hong.com";
	
	// 1단계&2단계 - JdbcUtil 클래스의 getConnection() 메서드 호출
	Connection con = JdbcUtil.getConnection();
	
	String sql = "INSERT INTO test3 VALUES (?, ?, ?, ?)";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setInt(1, idx);
	pstmt.setString(2, name);
	pstmt.setInt(3, age);
	pstmt.setString(4, email);
	
	int count = pstmt.executeUpdate();
	%>
	<h3>INSERT 성공 - <%=count %> 개 레코드</h3>
</body>
</html>














