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
	<h1>jdbc_connect_test3_2.jsp</h1>
	<%
	// test2 테이블에 번호(1), 이름('홍길동') 데이터 추가(INSERT)
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
// 	int idx = 3;
// 	String name = "강감찬";
	
	// ----------------------------------------------------------------------------------
	// 단순 데이터 전달 또는 변수 결합을 통해 SQL 구문 생성할 경우
// 	String sql = "INSERT INTO test2 VALUES (1,'홍길동')";
	// SQL 구문과 변수를 결합하여 문장을 생성하는 경우
	// => 주의! 문자 데이터의 경우 결합 과정에서 문자 표시를 위한 '' 기호가 포함되어야 함
// 	String sql = "INSERT INTO test2 VALUES (" + idx + ",'" + name + "')";
// 	PreparedStatement pstmt = con.prepareStatement(sql);
// 	System.out.println(pstmt);
	// --------------------------------------------------------------------------------
	// PreparedStatement 객체의 setXXX() 메서드 기능을 활용하여 만능문자로 데이터 처리할 경우
	// => test2 테이블에 추가할 데이터 위치에 만능문자 파라미터(?)로 표시만 해두기
	//    (주의! 문자 데이터도 무조건 ? 만 표시하고 작은따옴표'' 처리하지 않음)
	String sql = "INSERT INTO test2 VALUES (?,?)";
	PreparedStatement pstmt = con.prepareStatement(sql);
	
	int idx = 3;
	String name = "강감찬";
	// SQL 구문 전달을 위한 PreparedStatement 객체 생성 후
	// 데이터 위치의 만능문자(?)를 실제 데이터로 교체하기
	// => PreparedStatement 객체의 setXXX() 메서드 호출하여 파라미터 교체하기
	//    이 때, setXXX() 메서드의 XXX 은 전달(교체)할 데이터의 자바 데이터타입 이름 사용
	//    ex) 정수 : setInt(), 문자열 : setString()
	// => pstmt.setXXX(만능문자의 순서(위치)번호, 전달할 데이터);
	// 첫번째 만능문자를 int 타입 변수 idx 값으로 교체
	pstmt.setInt(1, idx);
	// 두번째 만능문자를 String 타입 변수 name 값으로 교체
	pstmt.setString(2, name);
	
	System.out.println(pstmt);
	// com.mysql.cj.jdbc.ClientPreparedStatement: INSERT INTO test2 VALUES (3,'강감찬')
	// => 문자 데이터인 name 변수값 '' 기호 처리 확인 가능   
	
	// 4단계. SQL 구문 실행 및 결과 처리
	int count = pstmt.executeUpdate();
	
	out.print("<h3>INSERT 성공! - " + count + "</h3>");
	%>
</body>
</html>














