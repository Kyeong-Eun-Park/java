<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<script>
	function confirmLogout() {
		let result = confirm("로그아웃하시겠습니까?");
		return result;
	}
</script>

<div align="right">
	<%-- EL 과 JSTL 을 조합하여 위의 동작을 동일하게 구현 --%>
	<%-- 1) JSTL 과 EL 문법을 통해 세션 객체에 접근하여 sId 값이 비어있는지 판별 --%>
	<%--    => EL 문법을 통해 세션 객체 접근 방법 : ${sessionScope.속성명} --%>
	<c:choose>
		<c:when test="${empty sessionScope.sId }"> <%-- 비어있을 경우(= 로그인 X) --%>
			<a href="MemberLoginForm.me">로그인</a> | 
			<a href="MemberJoinForm.me">회원가입</a>
		</c:when>
		<c:otherwise>  <%-- 비어있을 경우(= 로그인 O) --%>
			<%-- 회원 아이디 클릭 시 회원 상세정보 조회를 위해 MemberInfo.me 서블릿 요청 --%>
			<a href="MemberInfo.me">${sessionScope.sId }</a> 님 | 
			<%-- 로그아웃 링크 클릭 시 자바스크립트를 통해 확인 작업 거쳐서 로그아웃 수행하기 --%>
			<%-- 주의! 하이퍼링크 동작 무효화하려면 return 함수명() 형태로 호출 필요 --%>
			<a href="MemberLogout.me" id="logout" onclick="return confirmLogout()">로그아웃</a>
			<%-- 세션 아이디가 "admin" 일 경우(= 관리자) "관리자페이지" 링크 표시 --%>
			<%-- 링크 클릭 시 "admin_main.jsp" 페이지로 이동 --%>
			<c:if test="${sessionScope.sId eq 'admin' }">
				| <a href="AdminMain">관리자페이지</a>
			</c:if>
		</c:otherwise>
	</c:choose>
	
</div>
<div align="center">
	<h3><a href="MemberMain.me">HOME</a> 상단메뉴1 상단메뉴2 상단메뉴3 상단메뉴4 상단메뉴5</h3>
</div>











