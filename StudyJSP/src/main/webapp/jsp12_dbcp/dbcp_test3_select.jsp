<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@page import="jsp12_dbcp.JdbcUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>dbcp_test3_select.jsp</h1>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>이름</th>
			<th>나이</th>
			<th>E-Mail</th>
		</tr>
		<%
		// SELECT 구문을 실행하여 test3 테이블을 조회한 후 조회 결과를 반복해서 테이블에 출력
		Connection con = JdbcUtil.getConnection();
		
		String sql = "SELECT * FROM test3";
		PreparedStatement pstmt = con.prepareStatement(sql);
		
		ResultSet rs = pstmt.executeQuery();
		
		while(rs.next()) {
// 			out.print(rs.getInt(1) + ", "); // rs.getInt("idx") 대체 가능
// 			out.print(rs.getString(2) + ", "); // rs.getString("name") 대체 가능
// 			out.print(rs.getInt(3) + ", "); // rs.getInt("age") 대체 가능
// 			out.print(rs.getString(4) + "<br>"); // rs.getString("email") 대체 가능

			// 조회 결과를 각각의 변수에 저장하여 사용할 경우
			int idx = rs.getInt("idx");
			String name = rs.getString("name");
			int age = rs.getInt("age");
			String email = rs.getString("email");
			%>
			<!-- 스크립틀릿 외부에서 HTML 태그를 직접 사용도 가능 -->
<%-- 			번호 : <%=idx %>, 이름 : <%=name %>, 나이 : <%=age %>, E-Mail : <%=email %><br>  --%>
			
			<!-- 테이블의 각 행을 추가하여 데이터를 표시할 경우(행(<tr></tr>) 반복) -->
			<tr>
				<td><%=idx %></td>
				<td><%=name %></td>
				<td><%=age %></td>
				<td><%=email %></td>
			</tr>
			<%
		}
		
		JdbcUtil.close(rs);
		JdbcUtil.close(pstmt);
		JdbcUtil.close(con);
		%>
	</table>
</body>
</html>














