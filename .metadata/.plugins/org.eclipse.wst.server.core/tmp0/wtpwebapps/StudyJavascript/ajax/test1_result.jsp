<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- test1.jsp 페이지에서 AJAX 를 통해 요청한 작업에 대한 처리 및 응답 결과 생성 페이지 --%>    
<h1>AJAX - test1_result.jsp</h1>
<%-- 실제 로그인 처리 과정 이후 응답 페이지로 이동됨 --%>
<%-- 이 때, 저장된 세션 아이디를 가져와서 출력해보기 --%>
<h3>세션 아이디 : ${sessionScope.sId }</h3>
<%--
이 페이지로 이동하여 출력되는 것이 아니라 이 페이지의 내용이 요청 페이지인
test1.jsp 페이지 내에서 응답 데이터로 전달되어 출력됨
--%>
