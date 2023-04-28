<%@page import="jsp12_dbcp.JdbcUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="javax.sql.DataSource"%>
<%@page import="javax.naming.InitialContext"%>
<%@page import="javax.naming.Context"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>dbcp_test2.jsp</h1>
	<%
	// JdbcUtil 클래스의 인스턴스를 통해 getConnection() 메서드를 호출하여
	// Connection 타입 객체 리턴받기 => 1단계&2단계
// 	JdbcUtil jdbcUtil = new JdbcUtil();
// 	Connection con = jdbcUtil.getConnection();
	
	// getConnection() 메서드를 static 메서드로 선언했을 경우
	Connection con = JdbcUtil.getConnection();
	
	// 3단계, 4단계 작업 수행
	// test2 테이블에 번호와 이름을 사용하여 레코드 추가
	int idx = 5;
	String name = "김전일";
	String sql = "INSERT INTO test2 VALUES (?, ?)";
	
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setInt(1, idx);
	pstmt.setString(2, name);
	
	int count = pstmt.executeUpdate();
	%>
	<h3>INSERT 성공! - <%=count %>개 레코드</h3>
</body>
</html>















