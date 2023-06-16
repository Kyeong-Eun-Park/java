<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="jsp12_dbcp.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

String id = request.getParameter("id");
String passwd = request.getParameter("passwd");

/*
[ 로그인 처리 방법 2가지 ]
1. 아이디와 패스워드를 각각 판별하여 각각의 실패 사유를 별도로 처리하는 방법
   (ex. 아이디 없음 or 패스워드 틀림 or 로그인 성공)
   => 보안상의 이유로 사용하지 않게 된 방법
2. 아이디와 패스워드를 함께 판별하여 실패 사유를 통합 처리하는 방법
   (ex. 아이디 또는 패스워드 틀림 or 로그인 성공)
----------------------------------------------------------------------------
SELECT 구문을 사용하여 데이터베이스를 통해 아이디, 패스워드 조회
1) 아이디에 해당하는 패스워드 컬럼을 조회하는 방법
   => 위의 로그인 처리 방법에서 1번에 해당하는 방법으로 사용 가능한 방법
2) 아이디와 패스워드를 WHERE 절을 통해 한꺼번에 조건으로 설정하는 방법
   => 아이디 AND 패스워드 형식으로 두 조건을 모두 만족해야만 로그인 성공으로 처리
   => 2번에 해당하는 방법
*/

// SELECT 구문 실행 결과가 있을 경우 "로그인 성공", 아니면 "로그인 실패!" 출력
Connection con = JdbcUtil.getConnection();
String sql = "SELECT id FROM test4_member WHERE id = ? AND passwd = ?";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1, id);
pstmt.setString(2, passwd);

ResultSet rs = pstmt.executeQuery();

// 조회 결과 레코드가 1개 or 0개이므로 반복 불필요
// => 따라서, if 문을 사용하여 판별하거나 while 문 판별도 무관함
if(rs.next()) { // while(rs.next()) 도 동일(한 번 반복하고 끝남)
	// next() 메서드 리턴값이 true = 로그인 성공
// 	out.print("<h1>로그인 성공!</h1>");

	// 로그인에 성공한 아이디를 세션 객체(내장 객체명 session)에 저장(속성명 "sId") 후
	// 메인 페이지(dbcp_test4.jsp)로 리다이렉트
	session.setAttribute("sId", id); // id 변수에 저장된 값을 "sId" 속성명으로 세션 객체에 저장
	response.sendRedirect("dbcp_test4.jsp");
} else {
	// next() 메서드 리턴값이 false = 로그인 실패
// 	out.print("<h1>로그인 실패!</h1>");
	
	// 자바스크립트를 사용하여 "아이디 또는 패스워드 틀림!" 출력 후 이전페이지로 돌아가기
	%>
	<script>
		alert("아이디 또는 패스워드 틀림!");
		history.back();
	</script>
	<%
}

//자원 반환
JdbcUtil.close(rs);
JdbcUtil.close(pstmt);
JdbcUtil.close(con);
%>












