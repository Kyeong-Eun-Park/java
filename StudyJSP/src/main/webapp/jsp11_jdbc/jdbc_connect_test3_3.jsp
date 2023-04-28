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
	<h1>jdbc_connect_test3_3.jsp</h1>
	<%
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/shopdb"; // study_jsp3 아님!
	String user = "root";
	String password = "1234";
	
	// 1단계. 드라이버 클래스 로드
	Class.forName(driver);
	
	// 2단계. DB 연결
	Connection con = DriverManager.getConnection(url, user, password);
	out.print("<h3>DB 연결 성공!</h3>");
	
	// 3단계. SQL 구문 작성 및 전달
	int deptno = 4;
	String dname = "영업팀";
	String loc = "7층 영업부";
	
// 	String sql = "INSERT INTO dept(deptno, dname, loc) VALUES (?, ?, ?)";
	String sql = "INSERT INTO dept VALUES (?, ?, ?, now())";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setInt(1, deptno);
	pstmt.setString(2, dname);
	pstmt.setString(3, loc);
	// 주의! 만능문자 갯수가 3개이므로 setXXX() 메서드도 3개(인덱스도 1 ~ 3 까지)
	
	// 4단계. SQL 구문 실행 및 결과 처리
	int count = pstmt.executeUpdate();
	%>
	<h3>INSERT 성공! - <%=count %>개 레코드</h3>
</body>
</html>














