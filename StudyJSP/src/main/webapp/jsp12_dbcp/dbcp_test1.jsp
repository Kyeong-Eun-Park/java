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
	<h1>dbcp_test1.jsp</h1>
	<%
	// DBCP 를 활용한 데이터베이스 연동
	// context.xml 에 설정된 커넥션풀로부터 Connection 객체 가져오기
	// 0. context.xml 파일에 커넥션풀(CP) 정보 설정하기
	// 1. 톰캣으로부터 context.xml 파일의 <Context> 태그를 객체 형태로 가져오기
	// => InitialContext 객체 생성하여 Context 타입으로 업캐스팅(형변환)
	Context initCtx = new InitialContext();
	
	// 2. 생성된 Context 객체(initCtx)로부터 context.xml 파일의 <Resource> 태그를 객체로 가져오기
	// => Context 객체(initCtx)의 lookup() 메서드를 호출하여 찾아올 리소스 지정
	//    (파라미터 : "java:comp/env" 문자열)
	//    (리턴타입 : Object => Context 타입 객체로 다운캐스팅)
// 	Context envCtx = (Context)initCtx.lookup("java:comp/env");
	
	// 3. <Resource> 태그가 복수개 있을 경우(DB 여러개) 
	// 각 리소스 구분을 위해 지정한 이름(JNDI)을 사용하여 해당 리소스 선택하여 가져오기
	// => Context 객체(envCtx)의 lookup() 메서드를 호출하여 찾아올 리소스 지정
	//    (파라미터 : 리소스 이름 => Resource 태그에 설정된 name 속성값)
	//                => 주의! context.xml 파일 내의 지정된 name 속성값이 다를 수 있음!
	//    (리턴타입 : Object => javax.sql.DataSource 타입으로 다운캐스팅)
// 	DataSource ds = (DataSource)envCtx.lookup("jdbc/MySQL");
	
	// -- 참고. 위의 2번과 3번 작업을 하나의 문장으로 결합 --
	DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/MySQL");
	
	// 4. 커넥션 풀을 관리하는 DataSource 객체로부터 미리 생성되어 있는 Connection 객체 가져오기
	// => DataSource 객체의 getConnection() 메서드를 호출(리턴타입 : java.sql.Connection)
	Connection con = ds.getConnection();
	// 4번까지 성공하면 Connection 객체를 얻어오므로 해당 객체로 DB 접근 가능하다!
	// => 이 작업이 데이터베이스 작업 2단계까지와 동일
	// --------------------------------------------------------------------------------------
	// 3단계, 4단계 작업 수행
	// test2 테이블에 번호와 이름을 사용하여 레코드 추가
	int idx = 10;
	String name = "이연태";
	String sql = "INSERT INTO test2 VALUES (?, ?)";
	
	PreparedStatement pstmt = con.prepareStatement(sql);
	pstmt.setInt(1, idx);
	pstmt.setString(2, name);
	
	int count = pstmt.executeUpdate();
	%>
	<h3>INSERT 성공! - <%=count %>개 레코드</h3>
</body>
</html>















