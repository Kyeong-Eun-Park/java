<%@page import="java.sql.PreparedStatement"%>
<%@page import="jsp12_dbcp.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// test4_member 테이블에 입력받은 회원정보를 INSERT 후
// INSERT 작업이 성공했을 경우 dbcp_test4.jsp 페이지로 리다이렉트하고
// 실패했을 경우 자바스크립트를 호출하여 "회원가입 실패!" 출력 후 이전페이지로 돌아가기
// => 번호(idx)는 AUTO_INCREMENT 에 의해 자동 증가하므로 SQL 구문에서 null 로 표기하면 된다!
// => 가입일(hire_date)는 DATE 타입이므로 now() 함수를 사용하여 현재 시스템 날짜 사용하면 된다!
// POST 방식 요청에 대한 한글 인코딩 방식 변경 필수!
// => request 객체로부터 파라미터 접근 전에 수행해야한다!
request.setCharacterEncoding("UTF-8");

String name = request.getParameter("name");
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");
// String jumin1 = request.getParameter("jumin1");
// String jumin2 = request.getParameter("jumin2");
// 주민번호는 앞자리(6자리)와 뒷자리(7자리) 결합하여 하나의 변수로 생성(xxxxxx-yyyyyyy)
// String jumin = jumin1 + "-" + jumin2;
String jumin = request.getParameter("jumin1") + "-" + request.getParameter("jumin2");

// String email1 = request.getParameter("email1");
// String email2 = request.getParameter("email2");
// E-Mail 도 계정명과 도메인 결합하여 하나의 변수로 생성(xxx@yyy.zzz)
String email = request.getParameter("email1") + "@" + request.getParameter("email2");

String job = request.getParameter("job");
String gender = request.getParameter("gender");
// 취미(hobby)는 최대 3개(최소 0개)까지 동일한 name 속성으로 전달되므로
// request.getParameterValues() 메서드를 사용해야한다!
String[] hobbies = request.getParameterValues("hobby");
String hobby = ""; // 문자열 결합을 통해 취미를 하나로 묶을 변수 선언(실제 사용할 변수)
// 배열 내의 각 요소를 반복하면서 각각의 취미 뒤에 "/" 문자열을 결합하여
// 하나의 문자열에 모든 취미를 저장
// ex) 여행, 독서 체크 시 저장될 문자열 : "여행/독서/"
for(String item : hobbies) {
	hobby += item + "/";
}

String motivation = request.getParameter("motivation");
%>
<%-- 변수에 저장된 데이터들을 모두 출력 --%>
<%-- 이름 : <%=name %><br> --%>
<%-- 아이디 : <%=id %><br> --%>
<%-- 패스워드 : <%=passwd %><br> --%>
<%-- 주민번호 : <%=jumin %><br> --%>
<%-- E-mail : <%=email %><br> --%>
<%-- 직업 : <%=job %><br> --%>
<%-- 성별 : <%=gender %><br> --%>
<%-- 취미 : <%=hobby %><br> --%>
<%-- 가입동기 : <%=motivation %><br> --%>

<%
// 전달받은 폼 파라미터 데이터를 데이터베이스에 추가(INSERT)
Connection con = JdbcUtil.getConnection();

String sql = "INSERT INTO test4_member VALUES (null,?,?,?,?,?,?,?,?,?,now())";
PreparedStatement pstmt = con.prepareStatement(sql);
pstmt.setString(1, name);
pstmt.setString(2, id);
pstmt.setString(3, passwd);
pstmt.setString(4, jumin);
pstmt.setString(5, email);
pstmt.setString(6, job);
pstmt.setString(7, gender);
pstmt.setString(8, hobby);
pstmt.setString(9, motivation);
System.out.println(pstmt);

int count = pstmt.executeUpdate();

// 성공/실패 여부 판별
if(count > 0) { // 성공
	// dbcp_test4.jsp 페이지로 리다이렉트
	response.sendRedirect("dbcp_test4.jsp");
} else { // 실패
	// 자바스크립트를 사용하여 "회원가입 실패!" 출력 후 이전페이지로 돌아가기
	%>
	<script>
		alert("회원가입 실패!");
		history.back();
	</script>
	<%
}

// 자원 반환
JdbcUtil.close(pstmt);
JdbcUtil.close(con);
%>











