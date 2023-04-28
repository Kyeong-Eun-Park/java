<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 1. 로그인 폼에서 입력받은 아이디, 패스워드 파라미터 가져와서 변수에 저장
String id = request.getParameter("id");
String passwd = request.getParameter("passwd");
// out.print("아이디 : " + id + ", 패스워드 : " + passwd);

// 2. 아이디, 패스워드 판별(지금은 DB 가 없으므로 임의로 처리)
// => 임의의 아이디와 패스워드를 변수에 저장
String dbId = "admin";
String dbPasswd = "1234";

// 3. 아이디와 패스워드도 일치하는지 판별(1번과 2번에서 저장한 아이디, 패스워드 각각 비교)
// => 일치할 경우(= 로그인 성공) 
//    세션 객체에 "sId" 라는 속성명으로 로그인에 성공한 아이디 저장 후
//    sessionTest3_login_main.jsp 페이지로 리다이렉트
// => 일치하지 않을 경우(= 로그인 실패)
//    자바스크립트를 사용하여 "로그인 실패!" 출력 후 이전페이지로 돌아가기
if(id.equals(dbId) && passwd.equals(dbPasswd)) { // 로그인 성공(아이디와 패스워드 모두 일치)
// 	out.print("로그인 성공!");

	session.setAttribute("sId", id);
	response.sendRedirect("sessionTest3_login_main.jsp");
} else { // 로그인 실패(아이디 또는 패스워드 또는 둘 다 불일치)
// 	out.print("로그인 실패!");
	
	%>
	<script type="text/javascript">
		alert("로그인 실패!");
		history.back();
	</script>
	<%
}
%>














