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
	<h1>INSERT 결과</h1>
	<%
	// dbcp_test3_insert.jsp 페이지에서 입력받아 전달된 폼 파라미터(번호, 이름, 나이, 이메일)를
	// 가져와서 변수에 각각 저장한 후 데이터베이스 test3 테이블에 INSERT
	// request.getParameter() 메서드를 호출하여 파라미터 데이터 가져오기
	// => 주의! 리턴타입이 String 이므로 int 타입 등으로 사용하려면 변환 필요
	//    ex) String -> int 로 변환 시 Integer.parseInt(문자열데이터)
	request.setCharacterEncoding("UTF-8");
	
	int idx = Integer.parseInt(request.getParameter("idx"));
	String name = request.getParameter("name");
	int age = Integer.parseInt(request.getParameter("age"));
	String email = request.getParameter("email");
	
	%>
	<h3>번호 : <%=idx %></h3>
	<h3>이름 : <%=name %></h3>
	<h3>나이 : <%=age %></h3>
	<h3>이메일 : <%=email %></h3>
	<hr>
	<%-- 만약, EL 을 사용하여 파라미터 데이터를 표현하는 경우 ${param.파라미터명} --%>
	<h3>번호 : ${param.idx }</h3>
	<h3>이름 : ${param.name }</h3>
	<h3>나이 : ${param.age }</h3>
	<h3>이메일 : ${param.email }</h3>
	<hr>
	<%
	// 1단계&2단계 - JdbcUtil 클래스의 getConnection() 메서드 호출
	Connection con = JdbcUtil.getConnection();
	
	String sql = "INSERT INTO test3 VALUES (?, ?, ?, ?)";
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setInt(1, idx);
	pstmt.setString(2, name);
	pstmt.setInt(3, age);
	pstmt.setString(4, email);
	
	int count = pstmt.executeUpdate();
	
	// 사용이 끝난 Connection 객체, PreparedStatement 객체 등은 반드시 반환 필수!
	// => 해당 객체 반환을 위해 각각의 객체에서 close() 메서드를 호출해도 되지만,
	//    JdbcUtil 클래스에 반환 작업을 대신 수행할 close() 메서드를 정의했으므로 호출 가능
	// => 단, 객체 생성 순서의 역순으로 반환할 것(필요에 따라 Connection 만 반환해도 됨)
	JdbcUtil.close(pstmt);
	JdbcUtil.close(con);
	
	%>
	<h3>INSERT 성공 - <%=count %> 개 레코드</h3>
	<input type="button" value="홈" onclick="location.href='dbcp_test3.jsp'">
</body>
</html>












