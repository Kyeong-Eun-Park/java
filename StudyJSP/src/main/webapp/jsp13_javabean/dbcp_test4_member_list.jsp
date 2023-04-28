<%@page import="jsp13_javabean.MemberDTO"%>
<%@page import="java.util.List"%>
<%@page import="jsp13_javabean.MemberDAO"%>
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
			// 회원 목록 조회를 수행하기 위해 MemberDAO 객체의 selectMemberList() 메서드 호출
			// => 파라미터 : 없음   리턴타입 : List<MemberDTO>(memberList)
			MemberDAO dao = new MemberDAO();
			List<MemberDTO> memberList = dao.selectMemberList();
			
			// ----------------------------------------------------------------------
			// List 타입 객체를 반복문을 통해 접근하여 저장된 객체를 꺼내는 방법
			// 1. 기본 for 문 사용
			// 1-1) 기본 for 문에서 조건식에 리스트 객체의 크기(size()) 활용하여 반복 설정
// 			for(int i = 0; i < memberList.size(); i++) {
// 				// 1-2) 리스트 객체의 get() 메서드를 호출하여 저장된 객체(MemberDTO) 꺼내기
// 				//      => 파라미터 : 인덱스 번호(배열과 동일)  리턴타입 : MemberDTO
// 				//                    (단, 리턴타입은 List<XXX> 부분의 XXX 타입이 사용됨)
// 				MemberDTO member = memberList.get(i);
// 			}
			
			// 2. 향상된 for문 사용
			// => 우변에 리스트 객체, 좌변에 리스트 객체에서 꺼낼 객체 타입 변수 선언
// 			for(MemberDTO member : memberList) {}
			// ----------------------------------------------------------------------
			for(MemberDTO member : memberList) {
				%>
				<%-- 반복문 한 바퀴 당 1개 레코드에 접근하므로 1명의 회원 정보 접근 가능 --%>
				<%-- 각각의 레코드는 MemberDTO 객체에 저장되어 있음(member.getXXX() 으로 접근) --%>
				<tr>
					<td><%=member.getIdx() %></td>
					<td><%=member.getName() %></td>
					<td><%=member.getId() %></td>
					<td><%=member.getEmail() %></td>
					<td><%=member.getGender() %></td>
					<td><%=member.getHire_date() %></td>
					<td>
						<%-- 수정 버튼 클릭 시 회원 정보 조회 페이지로 이동(파라미터 : id) --%>
						<input type="button" value="수정" onclick="location.href='dbcp_test4_member_info.jsp?id=<%=member.getId() %>'">
						<input type="button" value="삭제">
					</td>
				</tr>
				<%
			}
			%>	
		</table>
	</div>
</body>
</html>


















