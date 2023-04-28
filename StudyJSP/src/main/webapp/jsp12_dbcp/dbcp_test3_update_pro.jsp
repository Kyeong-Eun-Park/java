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
	<h1>UPDATE 처리 결과</h1>
	<%
	request.setCharacterEncoding("UTF-8");
	
	// 전달받은 파라미터 중 번호(idx)에 해당하는 레코드의 
	// 이름(name), 나이(age), 이메일(email) 값을 UPDATE
	// idx 파라미터 가져오기(String -> int 변환)
	int idx = Integer.parseInt(request.getParameter("idx"));
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String email = request.getParameter("email");
	
	// 1단계&2단계 - JdbcUtil 클래스의 getConnection() 메서드 호출
	Connection con = JdbcUtil.getConnection();
	
	String sql = "UPDATE test3 SET name = ?, age = ?, email = ? WHERE idx = ?";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setString(1, name);
	pstmt.setInt(2, age);
	pstmt.setString(3, email);
	pstmt.setInt(4, idx);
	
	System.out.println(pstmt);
	
	int count = pstmt.executeUpdate();
	
	// DB 자원 반환
	JdbcUtil.close(pstmt);
	JdbcUtil.close(con);
	%>
	
	<h3>UPDATE 성공 - <%=count %> 개 레코드</h3>
	<input type="button" value="홈" onclick="location.href='dbcp_test3.jsp'">
</body>
</html>
















