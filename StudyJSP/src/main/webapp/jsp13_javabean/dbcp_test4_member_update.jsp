<%@page import="jsp13_javabean.MemberDAO"%>
<%@page import="jsp13_javabean.MemberDTO"%>
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

// 회원 정보 수정을 위한 데이터를 MemberDTO 객체에 저장
MemberDTO member = new MemberDTO();
member.setName(request.getParameter("name"));
member.setId(request.getParameter("id"));
member.setPasswd(request.getParameter("passwd"));
member.setJumin(request.getParameter("jumin1") + "-" + request.getParameter("jumin2"));
member.setEmail(request.getParameter("email1") + "@" + request.getParameter("email2"));
member.setJob(request.getParameter("job"));
member.setGender(request.getParameter("gender"));

String[] hobbies = request.getParameterValues("hobby");
String hobby = ""; // 문자열 결합을 통해 취미를 하나로 묶을 변수 선언(실제 사용할 변수)
for(String item : hobbies) {
	hobby += item + "/";
}

member.setHobby(hobby);
member.setMotivation(request.getParameter("motivation"));

// MemberDAO 클래스 인스턴스 생성
MemberDAO dao = new MemberDAO();

// MemberDAO 객체의 isRightUser() 메서드를 호출하여 아이디와 패스워드 일치 여부 판별
// => 새로운 메서드를 정의하는 것이 아니라 로그인에 사용된 메서드를 재사용한다!
// => 전달할 데이터는 MemberDTO 객체에 저장되어 있으므로 member.getXXX() 메서드로 접근
// boolean isRightUser = dao.isRightUser(member.getId(), member.getPasswd());

// 각각의 변수를 별도로 전달하지 않고 MemberDTO 객체 자체를 전달해도 된다!
// => 파라미터 : MemberDTO 객체(mebmer) 로 변경되어야 함
boolean isRightUser = dao.isRightUser(member);

// 회원 정보 수정 권한 여부 판별
// => 패스워드가 일치하거나 또는 세션 아이디가 관리자("admin") 일 경우 수정 권한 있음으로 판별
if(isRightUser || sId.equals("admin")) { // 수정 권한 있음
	// MemberDAO 객체의 updateMember() 메서드를 호출하여 회원 정보 수정 
	// => 파라미터 : MemberDTO 객체(mebmer)  리턴타입 : int(updateCount)
	int updateCount = dao.updateMember(member);
	
	// 수정 성공 시 페이지 이동
	if(updateCount > 0) {
		// => 단, 관리자가 다른 회원의 정보를 수정한 경우 회원 목록 페이지(dbcp_test4_member_list.jsp)로 이동하고
		//    (세션 아이디가 "admin" 이고, 수정하는 회원 아이디가 "admin" 이 아닐 경우)
		//    아니면, 회원 정보 페이지(dbcp_test4_member_info.jsp)로 이동
		String url = "";
		if(sId.equals("admin") && !sId.equals(member.getId())) { // 관리자가 다른 회원 정보를 수정했을 경우
			url = "dbcp_test4_member_list.jsp";
		} else {
			url = "dbcp_test4_member_info.jsp";
		}
		%>
		<script type="text/javascript">
			alert("회원 정보 수정 완료!");
			location.href = "<%=url%>";
		</script>
		<%
	} else { // 수정 실패 시
		// 자바스크립트 사용하여 "수정 실패!" 출력 후 이전페이지로 돌아가기
		%>
		<script type="text/javascript">
			alert("수정 실패!");
			history.back();
		</script>
		<%
	}
} else { // 수정 권한 없음
	// 자바스크립트 사용하여 "수정 권한이 없습니다!" 출력 후 이전페이지로 돌아가기
	%>
	<script type="text/javascript">
		alert("수정 권한이 없습니다!");
		history.back();
	</script>
	<%
}

%>










