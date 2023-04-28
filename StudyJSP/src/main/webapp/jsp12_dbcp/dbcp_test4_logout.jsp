<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// 로그아웃 처리
// 세션 객체를 초기화 후 메인페이지로 리다이렉트
session.invalidate();

response.sendRedirect("dbcp_test4.jsp");
%>