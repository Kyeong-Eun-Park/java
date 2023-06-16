<%@page import="jsp13_javabean.MemberDTO"%>
<%@page import="jsp13_javabean.MemberDAO"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="jsp12_dbcp.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
request.setCharacterEncoding("UTF-8");

// String id = request.getParameter("id");
// String passwd = request.getParameter("passwd");

// MemberDTO 객체 생성 후 폼 파라미터 저장
MemberDTO member = new MemberDTO();
member.setId(request.getParameter("id"));
member.setPasswd(request.getParameter("passwd"));

// 데이터베이스 작업을 수행할 MemberDAO 인스턴스 생성
MemberDAO dao = new MemberDAO();
// MemberDAO 객체의 isRightUser() 메서드를 호출하여 로그인을 위한 판별 작업 수행
// => 파라미터 : 아이디(id), 패스워드(passwd)    리턴타입 : boolean(isRightUser)
// boolean isRightUser = dao.isRightUser(id, passwd);
// => 파라미터 : MemberDTO 객체(member) 형태로 변경
boolean isRightUser = dao.isRightUser(member);

// 로그인 판별 작업 수행 결과를 통해 로그인 결과 처리
if(isRightUser) { // 로그인 성공(isRightUser == true)
	// 로그인에 성공한 아이디를 세션 객체(내장 객체명 session)에 저장(속성명 "sId") 후
	// 메인 페이지(dbcp_test4.jsp)로 리다이렉트
	session.setAttribute("sId", member.getId()); // id 변수에 저장된 값을 "sId" 속성명으로 세션 객체에 저장
	response.sendRedirect("dbcp_test4.jsp");
} else { // 로그인 실패
	// 자바스크립트를 사용하여 "아이디 또는 패스워드 틀림!" 출력 후 이전페이지로 돌아가기
	%>
	<script>
		alert("아이디 또는 패스워드 틀림!");
		history.back();
	</script>
	<%
}

%>












