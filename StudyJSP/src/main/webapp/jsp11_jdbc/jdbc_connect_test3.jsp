<%@page import="java.sql.PreparedStatement"%>
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
	<h1>jdbc_connect_test3.jsp</h1>
	<%
	// JDBC 연결 4단계
	// 1단계. JDBC 드라이버 클래스 로드
	String driver = "com.mysql.cj.jdbc.Driver";
	Class.forName(driver);
	
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
	<h3>1단계 & 2단계 성공!</h3>
	<h3>Connection 객체 정보 : <%=con %></h3>
	
	<%
	// 3단계. SQL 구문 작성 및 전달
	// 1) SQL 구문 작성
// 	String sql = "CREATE TABLE test (idx INT)"; // 테이블 생성 구문
	// => 주의! 이미 존재하는 테이블을 다시 생성할 경우 오류 발생
	//    (java.sql.SQLSyntaxErrorException: Table 'test' already exists)
	// => 구문이 틀렸을 경우 오류 발생
	//    (java.sql.SQLSyntaxErrorException: You have an error in your SQL syntax; 
	//     check the manual that corresponds to your MySQL server version for the 
	//     right syntax to use near 'CREAT TABLE test2 (idx INT, name VARCHAR(10))' at line 1)
	//     => 마지막 문장에 오류가 발생한 구문의 대략적인 위치 표시됨
	
	// test2 테이블 생성(idx 컬럼 = 정수, name 컬럼 = 문자(10글자))
// 	String sql = "CREAT TABLE test2 (idx INT, name VARCHAR(10))"; // 테이블 생성 구문
			
// 	String sql = "DROP TABLE test"; // 테이블 삭제 구문
	// => 삭제 대상 테이블이 존재하지 않을 경우 오류 발생
	//    (java.sql.SQLSyntaxErrorException: Unknown table 'study_jsp3.test')
	
	// test 테이블에 레코드 추가(idx 컬럼에 정수 1 추가) - INSERT
// 	String sql = "INSERT INTO test VALUES (1)";
	// => INSERT 구문 실행이 성공하면, 1개 레코드가 추가되므로 실행 후 리턴값으로 1 리턴됨
			
	// test 테이블에서 idx 컬럼값이 2 인 레코드 삭제 - DELETE
	String sql = "DELETE FROM test WHERE idx = 1";
	
	// 2) Connection 객체의 prepareStatement() 메서드를 호출하여 실행할 SQL 구문 전달
	//    => 파라미터 : 실행할 SQL 구문 문자열   리턴타입 : java.sql.PreparedStatement
	PreparedStatement pstmt = con.prepareStatement(sql);
	
	// 실행될 SQL 구문은 pstmt 객체를 출력하여 확인 가능함
	System.out.println("pstmt - " + pstmt);
	%>
	<h3>SQL 구문 전달 완료!</h3>
	<%-- 주의! 아직 전달된 구문이 실행되지 않은 상태! --%>
	
	<%
	// 4단계. SQL 구문 실행 및 결과 처리
	// => CREATE, DROP, ALTER, INSERT, DELETE, UPDATE 등의 조작 구문을 실행하기 위해
	//    PreparedStatement 객체의 executeUpdate() 메서드 호출
	// => 주의! 메서드 파라미터로 아무것도 전달하지 않음!
	int count = pstmt.executeUpdate();
	%>
	<h3>SQL 구문 실행 완료! - <%=count %></h3>
</body>
</html>















