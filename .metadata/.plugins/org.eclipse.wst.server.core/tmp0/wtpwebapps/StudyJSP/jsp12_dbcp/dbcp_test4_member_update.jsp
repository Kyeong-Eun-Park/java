<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="jsp12_dbcp.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 세션 아이디가 없을 경우 "잘못된 접근입니다" 출력 후 이전페이지로 돌아가기
String sId = (String)session.getAttribute("sId");
if(sId == null) {
	%>
	<script>
		alert("잘못된 접근입니다!");
		history.back();
	</script>
	<%
}

request.setCharacterEncoding("UTF-8");

String name = request.getParameter("name");
String id = request.getParameter("id");
String passwd = request.getParameter("passwd"); // 기존 패스워드
String newPasswd = request.getParameter("newPasswd"); // 변경할 패스워드
String jumin = request.getParameter("jumin1") + "-" + request.getParameter("jumin2");

String email = request.getParameter("email1") + "@" + request.getParameter("email2");

String job = request.getParameter("job");
String gender = request.getParameter("gender");
String[] hobbies = request.getParameterValues("hobby");
String hobby = ""; // 문자열 결합을 통해 취미를 하나로 묶을 변수 선언(실제 사용할 변수)
for(String item : hobbies) {
	hobby += item + "/";
}

String motivation = request.getParameter("motivation");
%>
<%-- 변수에 저장된 데이터들을 모두 출력 --%>
<%-- 이름 : <%=name %><br> --%>
<%-- 아이디 : <%=id %><br> --%>
<%-- 패스워드 : <%=passwd %><br> --%>
<%-- 변경할 패스워드 : <%=newPasswd %><br> --%>
<%-- 주민번호 : <%=jumin %><br> --%>
<%-- E-mail : <%=email %><br> --%>
<%-- 직업 : <%=job %><br> --%>
<%-- 성별 : <%=gender %><br> --%>
<%-- 취미 : <%=hobby %><br> --%>
<%-- 가입동기 : <%=motivation %><br> --%>

<%
// 입력받은 기존 패스워드(passwd)가 일치하는지 검사
Connection con = JdbcUtil.getConnection();
String sql = "SELECT id FROM test4_member WHERE id = ? AND passwd = ?";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1, id);
pstmt.setString(2, passwd);

ResultSet rs = pstmt.executeQuery();

// 조회 결과가 있을 경우 아이디 및 비밀번호 일치하므로 정보를 수정하고, 
// 아니면 불일치이므로 오류 메세지 출력 후 이전페이지로 돌아가기
// => 단, 비밀번호가 일치하지 않아도 세션 아이디가 관리자("admin") 이면 수정 작업 수행
if(rs.next() || sId.equals("admin")) { // 조회 결과가 있을 경우(= 비밀번호 일치할 경우)
	// UPDATE 구문을 실행하여 회원 정보 수정(이름, 주민번호, 이메일, 직업, 성별, 취미, 가입동기)
	// => 동일한 파일에서 데이터베이스 작업 2종류를 차례대로 수행하는 경우
	//    기존 Connection 객체 그대로 사용
	String sql2 = "UPDATE test4_member " 
					+ "SET name = ?, jumin = ?, email = ?, job = ?, gender = ?, hobby = ?, motivation = ? " 
					+ "WHERE id = ?";
	PreparedStatement pstmt2 = con.prepareStatement(sql2);
	pstmt2.setString(1, name);
	pstmt2.setString(2, jumin);
	pstmt2.setString(3, email);
	pstmt2.setString(4, job);
	pstmt2.setString(5, gender);
	pstmt2.setString(6, hobby);
	pstmt2.setString(7, motivation);
	pstmt2.setString(8, id);
	
	pstmt2.executeUpdate();
	
	JdbcUtil.close(pstmt2);
	
	// 수정 성공 시 회원 상세정보 페이지(dbcp_test4_member_info.jsp)로 이동
	// => 단, 관리자가 다른 회원의 정보를 수정한 경우 회원 목록 페이지(dbcp_test4_member_list.jsp)로 이동
	//    (세션 아이디가 "admin" 이고, 수정하는 회원 아이디가 "admin" 이 아닐 경우)
	if(sId.equals("admin") && !sId.equals(id)) { // 관리자가 다른 회원 정보를 수정했을 경우
		response.sendRedirect("dbcp_test4_member_list.jsp");
	} else {
		response.sendRedirect("dbcp_test4_member_info.jsp");
	}
} else { // 조회 결과가 없을 경우(= 비밀번호 틀렸을 경우)
	// 자바스크립트 사용하여 "비밀번호 틀림!" 출력 후 이전페이지로 돌아가기
	%>
	<script type="text/javascript">
		alert("비밀번호 틀림!");
		history.back();
	</script>
	<%
}



//자원 반환
JdbcUtil.close(rs);
JdbcUtil.close(pstmt);
JdbcUtil.close(con);
%>










