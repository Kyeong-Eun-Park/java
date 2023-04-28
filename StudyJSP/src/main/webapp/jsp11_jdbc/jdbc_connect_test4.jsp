<%@page import="jsp12_dbcp.JdbcUtil"%>
<%@page import="java.sql.ResultSet"%>
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
	<h1>jdbc_connect_test4.jsp - SELECT</h1>
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
	// => SELECT 구문도 3단계까지는 동일함
	// => test2 테이블의 모든 레코드 검색(조회 = SELECT)
	String sql = "SELECT * FROM test2";
	PreparedStatement pstmt = con.prepareStatement(sql);
	
	// 4단계. SQL 구문 실행 및 결과 처리
	// => 실행 과정은 같으나 메서드명과 리턴타입이 달라지고, 리턴값에 대한 처리 과정도 달라짐
	// => PreparedStatement 객체의 executeQuery() 메서드를 호출하여 SELECT 구문을 실행하고
	//    리턴되는 결과값을 java.sql.ResultSet 타입 변수에 저장
	ResultSet rs = pstmt.executeQuery();
	/*
	다음 형태의 테이블 구조가 ResultSet 타입 객체로 리턴(관리)됨
	+------+--------+
	| idx  | name   | <- 현재 커서(Cursor) 위치(개념상 항상 첫번째 레코드 위에 위치)
	+------+--------+
	|    1 | 홍길동 | <- rs.next() 메서드 한 번 호출 시 커서 위치(true 리턴 = 레코드 있음)
	|    3 | 김태희 | <- rs.next() 메서드 두 번 호출 시 커서 위치(true 리턴 = 레코드 있음)
	|   10 | 이연태 | <- rs.next() 메서드 세 번 호출 시 커서 위치(true 리턴 = 레코드 있음)
	+------+--------+ <- rs.next() 메서드 네 번 호출 시 커서 위치(false 리턴 = 레코드 없음)
	*/
	
	// ResultSet 객체의 next() 메서드를 호출하여 커서를 다음 레코드로 이동시키기
	// => 레코드가 3개이므로 rs.next() 메서드 3번 호출할 동안 true 리턴, 4번째는 false 리턴됨
// 	out.print(rs.next() + "<br>"); // true
// 	out.print(rs.next() + "<br>"); // true
// 	out.print(rs.next() + "<br>"); // true
// 	out.print(rs.next() + "<br>"); // false

	// -----------------------------------------------------------------------------
	// 만약 조회 결과가 단일 레코드(1개 레코드)일 경우 if 문을 사용하여 
	// rs.next() 메서드 결과가 true 일 때 레코드에 접근하여 데이터를 가져올 수 있다!
// 	if(rs.next()) {
// 		out.print("레코드 있음!");
// 	} else {
// 		out.print("레코드 없음!");
// 	}
	// -----------------------------------------------------------------------------
	// 조회할 레코드가 복수개(2개 이상)일 경우(단일 레코드일 경우에도 유효함)
	// => if문 대신 while 문을 사용하여 다음 레코드가 존재할 동안(true) 반복
	while(rs.next()) {
// 		out.print("레코드 있음!<br>"); // 레코드가 3개일 경우 3번 반복 출력됨

		// 커서가 위치한 레코드의 각 컬럼에 접근하여 데이터 가져오기
		// => 첫번째 컬럼 데이터타입 : int 타입, 두번째 컬럼 데이터타입 : varchar 타입
		// => ResultSet 객체의 getXXX() 메서드를 호출하여 각 컬럼 데이터 가져오기
        // => 이 때, getXXX() 메서드의 XXX 은 가져올 컬럼의 자바 데이터타입명을 지정
        //    (ex. 문자데이터(VARCHAR) 가 저장된 컬럼 : getString(), 정수 데이터 컬럼 : getInt())
        // => getXXX() 메서드 파라미터는 컬럼의 인덱스번호(정수 1부터 시작) 또는 컬럼명(String)을 지정
        //    (ex. 문자데이터 저장된 두번째 컬럼(컬럼명 : name) : getString(2) 또는 getString("name")
//         int idx = rs.getInt(1); // 컬럼인덱스 지정 시(첫번째 컬럼 = 1번 인덱스)
//         String name = rs.getString(2);

		int idx = rs.getInt("idx"); // 컬럼명 지정 시(idx 컬럼)
		String name = rs.getString("name");
        
        out.print(idx + ", " + name + "<br>");
	}
	
	// 사용 완료된 자원 반환 필수!
	JdbcUtil.close(rs);
	JdbcUtil.close(pstmt);
	JdbcUtil.close(con);
	%>
</body>
</html>















