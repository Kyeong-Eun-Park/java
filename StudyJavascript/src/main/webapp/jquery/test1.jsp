<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- jQuery 사용에 필요한 외부 라이브러리 등록 -->
<!-- 1) jQuery 라이브러리 파일 직접 등록   2) jQuery 라이브러리 외부 링크 등록 -->
<script src="../js/jquery-3.6.4.js"></script>
<script type="text/javascript">
	// jQuery 기본 문법
	// => jQuery(객체명 또는 선택자).함수명();
	// => $(객체명 또는 선택자).함수명();
	// -----------------------------------------
	// HTML 문서의 DOM 객체가 로딩되면 자동으로 호출되는 이벤트 : document 객체의 ready 이벤트
	// 1) Ready 이벤트 처리 문법-1
// 	jQuery(document).ready(function() {
// 		alert("Ready 이벤트 처리 방법-1");
// 	});
	
	// 2) Ready 이벤트 처리 문법-2
	// => jQuery 객체명을 $ 기호로 대체
	// => document 객체의 ready 이벤트가 아닌 다른 객체 및 이벤트에 활용 가능한 형태
// 	$(document).ready(function() {
// 		alert("Ready 이벤트 처리 방법-2");
// 	});
	
	// 3) Ready 이벤트 처리 문법-3
	// => document 객체 지정 및 ready 이벤트 함수 호출 생략
	//    즉, document 객체의 ready 이벤트 전용 함수 형태
	$(function() {
		alert("Ready 이벤트 처리 방법-3");
	});
	
</script>
</head>
<body>
	<h1>jQuery - test1.jsp</h1>
</body>
</html>
















