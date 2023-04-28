<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.DriverManager"%>
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
	<h1>jdbc_connect_test3_5.jsp</h1>
	<%
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/study_jsp3";
	String user = "root";
	String password = "1234";
	
	// 1단계. 드라이버 클래스 로드
	Class.forName(driver);
	
	// 2단계. DB 연결
	Connection con = DriverManager.getConnection(url, user, password);
	out.print("<h3>DB 연결 성공!</h3>");
	
	// 3단계. SQL 구문 작성 및 전달
	// 번호(idx)가 일치하는 레코드의 이름(name) 컬럼 값을 변경
	int searchIdx = 3;
	String newName = "김태희";
	// => 번호가 3인 레코드의 이름을 "김태희" 로 변경
	// => UPDATE 테이블명 SET 컬럼명1 = 컬럼값, 컬럼명n = 컬럼값 [WHERE절];
	String sql = "UPDATE test2 SET name = ? WHERE idx = ?";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setString(1, newName);
	pstmt.setInt(2, searchIdx);
	
	// 4단계. SQL 구문 실행 및 결과 처리
	int count = pstmt.executeUpdate();
	%>
	<h3>UPDATE 성공 - <%=count %>개 레코드</h3>
</body>
</html>














