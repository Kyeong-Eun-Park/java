<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1">
		<tr>
			<td colspan="2" width="1024" height="100">
				<%-- jsp:include 액션태그로 includeTest3_top.jsp 페이지 포함시키기 --%>
				<jsp:include page="dbcp_test4_top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td width="200" height="400">
				<%-- jsp:include 액션태그로 includeTest3_left.jsp 페이지 포함시키기 --%>
				<jsp:include page="dbcp_test4_left.jsp"></jsp:include>
			</td>
			<td>
				<%
				String category = request.getParameter("category");
				
				// if문으로 category 파라미터가 존재하지 않는지(category 변수값이 null) 판별
				// => 존재하지 않으면 category 변수값을 "main" 으로 변경
				if(category == null) {
					category = "main";
				}
				
				// 카테고리명을 문자열 결합을 통해 포함시킬 페이지명으로 결합
				String pageName = "dbcp_test4_" + category + ".jsp";
				%>
				<%-- 요청 카테고리에 따라 서로 다른 페이지 포함시키기 --%>
				<jsp:include page="<%=pageName %>"></jsp:include>
			</td>
		</tr>
		<tr>
			<td colspan="2" height="100">
				<%-- jsp:include 액션태그로 includeTest3_bottom.jsp 페이지 포함시키기 --%>
				<jsp:include page="dbcp_test4_bottom.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>










