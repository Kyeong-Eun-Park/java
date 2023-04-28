<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%--
	2. jsp:include 액션 태그
	- 현재 페이지에 특정 페이지를 포함(include) 시키는 용도의 액션 태그
	- page 속성에 지정된 페이지로 제어권이 일시적으로 넘어간 후 해당 페이지에서 작업이 끝나면
	  다시 원래 페이지(현재 페이지)로 제어권이 돌아옴
	  => 결국, forward 액션 태그는 포워딩 된 후 그 위치에서 이전으로 돌아가지 않지만
	     include 액션 태그는 포워딩 작업 후 다시 원래 위치로 결과화면을 가지고 돌아감
	- forward 액션 태그와 마찬가지로 파라미터 전달 시 jsp:param 태그 사용
	  (전달되는 파라미터는 포함될 페이지에서 사용 가능)
	--%>
	<%-- 이 페이지는 여러 페이지를 하나의 페이지에 담도록 틀을 제공 : 템플릿 페이지 --%>
	<table border="1">
		<tr>
			<td colspan="2" width="1024" height="200">
				<%-- jsp:include 액션태그로 includeTest3_top.jsp 페이지 포함시키기 --%>
				<jsp:include page="includeTest3_top.jsp"></jsp:include>
			</td>
		</tr>
		<tr>
			<td width="200" height="400">
				<%-- jsp:include 액션태그로 includeTest3_left.jsp 페이지 포함시키기 --%>
				<jsp:include page="includeTest3_left.jsp"></jsp:include>
			</td>
			<td>
				<%-- jsp:include 액션태그로 includeTest3_main.jsp 페이지 포함시키기 --%>
<%-- 				<jsp:include page="includeTest3_main.jsp"></jsp:include> --%>
				<%--
				category 파라미터 값에 따라 중앙 영역에 포함할 페이지를 다르게 지정
				=> URL 로 전달받은 category 파라미터값을 변수에 저장
				=> 단, 전달받은 category 파라미터가 없을 경우 기본 값을 "main" 으로 설정
				--%>
				<%
				String category = request.getParameter("category");
				
				// if문으로 category 파라미터가 존재하지 않는지(category 변수값이 null) 판별
				// => 존재하지 않으면 category 변수값을 "main" 으로 변경
				if(category == null) {
					category = "main";
				}
				
				// 카테고리명을 문자열 결합을 통해 포함시킬 페이지명으로 결합
				String pageName = "includeTest3_" + category + ".jsp";
				%>
				<%-- 요청 카테고리에 따라 서로 다른 페이지 포함시키기 --%>
				<jsp:include page="<%=pageName %>"></jsp:include>
			</td>
		</tr>
		<tr>
			<td colspan="2" height="200">
				<%-- jsp:include 액션태그로 includeTest3_bottom.jsp 페이지 포함시키기 --%>
				<jsp:include page="includeTest3_bottom.jsp"></jsp:include>
			</td>
		</tr>
	</table>
</body>
</html>










