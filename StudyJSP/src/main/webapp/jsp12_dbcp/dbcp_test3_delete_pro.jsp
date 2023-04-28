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
	<h1>DELETE 작업 확인</h1>
	<h3>삭제할 번호 : ${param.idx }</h3>
	<%
	// idx 파라미터 가져오기(String -> int 변환)
	int idx = Integer.parseInt(request.getParameter("idx"));
	
	// 1단계&2단계 - JdbcUtil 클래스의 getConnection() 메서드 호출
	Connection con = JdbcUtil.getConnection();
	
	String sql = "DELETE FROM test3 WHERE idx = ?";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setInt(1, idx);
	
	int count = pstmt.executeUpdate();
	
	// DB 자원 반환
	JdbcUtil.close(pstmt);
	JdbcUtil.close(con);
	%>
	<h3>DELETE 성공 - <%=count %> 개 레코드</h3>
	<input type="button" value="홈" onclick="location.href='dbcp_test3.jsp'">
</body>
</html>











