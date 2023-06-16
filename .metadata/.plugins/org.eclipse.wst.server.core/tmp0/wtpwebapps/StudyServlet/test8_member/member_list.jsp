<%@page import="test8_member.MemberDTO"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="top.jsp" />
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
			// request.setAttribute() 메서드를 통해 저장된 데이터(객체)는
			// request.getAttribute() 메서드를 통해 꺼낼 수 있다!
			// => 단, 리턴타입이 Object 타입이므로 다운캐스팅(형변환) 필수!
			// "memberList" 속성명으로 저장된 객체 꺼내기(Object -> List<MemberDTO> 다운캐스팅)
			List<MemberDTO> memberList = (List<MemberDTO>)request.getAttribute("memberList");
			
			// List 객체에 순차 접근을 위한 for문
			// 1) 일반 for문
// 			for(int i = 0; i < memberList.size(); i++) {
// 				// MemberList 객체의 get() 메서드를 호출하여 MemberDTO 객체 꺼내기
// 				// => 파라미터 : 리스트 객체의 인덱스(i)
// 				MemberDTO member = memberList.get(i);
// 			}
			
			// 2) 향상된 for문
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


















