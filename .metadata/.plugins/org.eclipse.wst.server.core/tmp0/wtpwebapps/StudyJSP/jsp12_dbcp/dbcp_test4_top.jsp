<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script>
	function confirmLogout() {
		let result = confirm("로그아웃하시겠습니까?");
		
		// result 값이 true 일 때 dbcp_test4_logout.jsp 페이지로 이동 위해 true 값 리턴하고
		// 아니면, false 값 리턴하여 이동 작업 취소
// 		if(result) {
// 			location.href = "dbcp_test4_logout.jsp";
// 			return true;
// 		} else {
// 			return false;
// 		}
		// => result 값이 true 이면 true, false 이면 false 값이 리턴됨
		//    즉, result 값과 리턴값이 동일함
		
		if(result) {
			location.href = "dbcp_test4_logout.jsp";
		}
		
		return result;
		
	}
</script>

<div align="right">
	<%
// 	String sId = (String)session.getAttribute("sId");
// 	if(sId == null) {
 		%>
<!--  		<a href="dbcp_test4.jsp?category=login_form">로그인</a> | <a href="dbcp_test4.jsp?category=join_form">회원가입</a> -->
		<%
// 	} else {
		%>
<%-- 		<%=session.getAttribute("sId") %> 님 | <a href="dbcp_test4_logout.jsp">로그아웃</a> --%>
		<%
// 	}
	%>
	
	<%-- EL 과 JSTL 을 조합하여 위의 동작을 동일하게 구현 --%>
	<%-- 1) JSTL 과 EL 문법을 통해 세션 객체에 접근하여 sId 값이 비어있는지 판별 --%>
	<%--    => EL 문법을 통해 세션 객체 접근 방법 : ${sessionScope.속성명} --%>
	<c:choose>
		<c:when test="${empty sessionScope.sId }"> <%-- 비어있을 경우(= 로그인 X) --%>
			<a href="dbcp_test4.jsp?category=login_form">로그인</a> | 
			<a href="dbcp_test4.jsp?category=join_form">회원가입</a>
		</c:when>
		<c:otherwise>  <%-- 비어있을 경우(= 로그인 O) --%>
			<%-- 회원 아이디 클릭 시 회원 상세정보 조회를 위해 dbcp_test4_member_info.jsp 페이지로 이동 --%>
			<a href="dbcp_test4_member_info.jsp">${sessionScope.sId }</a> 님 | 
			<%-- 로그아웃 링크 클릭 시 자바스크립트를 통해 확인 작업 거쳐서 로그아웃 수행하기 --%>
			<%-- 주의! 하이퍼링크 동작 무효화하려면 return 함수명() 형태로 호출 필요 --%>
			<a href="dbcp_test4_logout.jsp" id="logout" onclick="return confirmLogout()">로그아웃</a>
			<%-- 세션 아이디가 "admin" 일 경우(= 관리자) "관리자페이지" 링크 표시 --%>
			<%-- 링크 클릭 시 "admin_main.jsp" 페이지로 이동 --%>
			<c:if test="${sessionScope.sId eq 'admin' }">
				| <a href="admin_main.jsp">관리자페이지</a>
			</c:if>
		</c:otherwise>
	</c:choose>
	
</div>
<div align="center">
	<h3><a href="dbcp_test4.jsp">HOME</a> 상단메뉴1 상단메뉴2 상단메뉴3 상단메뉴4 상단메뉴5</h3>
</div>











