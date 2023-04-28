<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="jsp12_dbcp.JdbcUtil"%>
<%@page import="java.sql.Connection"%>
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
	<c:if test="${sessionScope.sId ne 'admin' }">
		<script type="text/javascript">
			alert("권한이 없습니다!");
			history.back();
		</script>
	</c:if>
	<div align="center">
		<h1>회원 목록 조회</h1>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>이름</th>
				<th>아이디</th>
				<th>E-Mail</th>
				<th>성별</th>
				<th>가입일</th>
				<th></th>
			</tr>	
			<%
			// 전체 회원 목록 조회 후 반복문을 통해 표시
			Connection con = JdbcUtil.getConnection();

			String sql = "SELECT * FROM test4_member";
			PreparedStatement pstmt = con.prepareStatement(sql);
			
			ResultSet rs = pstmt.executeQuery();
			
			// while 문을 사용하여 ResultSet 객체의 다음 레코드가 존재할 동안 반복
			while(rs.next()) {
				%>
				<%-- 반복문 한 바퀴 당 1개 레코드에 접근하므로 1명의 회원 정보 접근 가능 --%>
				<tr>
					<td><%=rs.getInt("idx") %></td>
					<td><%=rs.getString("name") %></td>
					<td><%=rs.getString("id") %></td>
					<td><%=rs.getString("email") %></td>
					<td><%=rs.getString("gender") %></td>
					<td><%=rs.getDate("hire_date") %></td>
					<td>
						<%-- 수정 버튼 클릭 시 회원 정보 조회 페이지로 이동(파라미터 : id) --%>
						<input type="button" value="수정" onclick="location.href='dbcp_test4_member_info.jsp?id=<%=rs.getString("id") %>'">
						<%-- 수정 버튼 클릭 시 회원 정보 조회 페이지로 이동(파라미터 : idx) --%>
<%-- 						<input type="button" value="수정" onclick="location.href='dbcp_test4_member_info.jsp?idx=<%=rs.getInt("idx") %>'"> --%>
						<input type="button" value="삭제">
					</td>
				</tr>
				<%
			}
			
			// 자원 반환
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
			%>	
		</table>
	</div>
</body>
</html>


















