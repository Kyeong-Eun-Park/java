<%@page import="jsp08_jstl.Person"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
// request 객체에 다음 데이터 저장 후 test4_result.jsp 페이지로 포워딩(= Dispatch 방식)
// 1) idx 속성명으로 정수 1 저장
request.setAttribute("idx", 1);

// 2) name 속성명으로 문자열 "홍길동" 저장
request.setAttribute("name", "홍길동");

// 3) String 타입 배열 subjects 에 "자바", "JSP", "스프링" 저장 후
//    "subjects" 속성명으로 subjects 배열 객체 저장 
String[] subjects = {"자바", "JSP", "스프링"};
request.setAttribute("subjects", subjects);

// 4) Person 객체 생성 후 "person" 속성명으로 request 객체에 저장
Person p = new Person("홍길동", 20);
request.setAttribute("person", p);

// Dispatch 방식으로 test4_result.jsp 페이지로 포워딩
// => 주소표시줄의 URL 이 유지되고, request 객체도 유지됨
pageContext.forward("test4_result.jsp");

// 만약, Redirect 방식으로 이동할 경우
// => 주소표시줄의 URL 이 변경되고, request 객체도 새로 생성됨(이전 객체 제거됨)
// response.sendRedirect("test4_result.jsp");
%>














