<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 
	관리자페이지에 진입한 세션 아이디가 "admin" 이 아니면 
	"권한이 없습니다" 출력 후 이전페이지로 돌아가기
	--%>
	<c:if test="${sessionScope.sId ne 'admin' }">
		<script type="text/javascript">
			alert("권한이 없습니다!");
			history.back();
		</script>
	</c:if>
	<h1>관리자페이지</h1>
	<h3><a href="dbcp_test4_member_list.jsp">회원 목록</a></h3>
</body>
</html>













