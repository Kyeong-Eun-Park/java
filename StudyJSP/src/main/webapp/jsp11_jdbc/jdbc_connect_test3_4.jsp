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
	<h1>jdbc_connect_test3_4.jsp</h1>
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
	// 번호(idx)에 해당하는 레코드 삭제
	// DELETE FROM 테이블명 [WHERE 컬럼명 = 값];
// 	int idx = 3;
// 	String sql = "DELETE FROM test2 WHERE idx = ?";
// 	PreparedStatement pstmt = con.prepareStatement(sql);
// 	pstmt.setInt(1, idx); // 첫번째 파라미터를 idx 값으로 교체

	// 번호(idx)와 이름(name)이 일치하는 레코드 삭제
	int idx = 2;
	String name = "이순신";
	
	String sql = "DELETE FROM test2 WHERE idx = ? AND name = ?";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setInt(1, idx); // 첫번째 파라미터를 idx 값으로 교체
	pstmt.setString(2, name);
	
	// 4단계. SQL 구문 실행 및 결과 처리
	int count = pstmt.executeUpdate();
	%>
	<h3>DELETE 성공 - <%=count %>개 레코드</h3>
</body>
</html>














