<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.6.4.js"></script>
<script type="text/javascript">
	$(function() {
		$("#btnOk").on("click", function() {
			// =====================================================
			// test3_json_data.txt 파일을 AJAX 를 통해 요청
			// - 응답 데이터 형식을 "text" 로 지정하여 text 형식 데이터 요청
			// - AJAX 요청 성공 시 자동으로 호출되는 콜백 함수를 success: 속성에 기술
			//   (또는 $.ajax() 함수 외부에 done() 함수를 연결하여 콜백 처리도 가능)
			//   (=> 단, success: 와 done() 은 기술 위치가 다름)
// 			$.ajax({
// 				type: "GET",
// 				url: "test3_json_data.txt",
// 				dataType: "text", // 응답 데이터가 일반 텍스트로 전달되도록 "text" 타입 지정
// 				success: function(msg) { // 요청 성공 시
// 					alert("요청 성공! - " + msg);
// 				},
// 				error: function() { // 요청 실패 시
// 					alert("요청 실패!");
// 				}
// 			});
			
			// 위와 동일한 작업 결과를 가지나 성공/실패 처리 형태가 다른 문법
			// => done(), fail() 함수를 사용하며, done() 은 success 와 같지만 우선순위가 낮음
// 			$.ajax({
// 				type: "GET",
// 				url: "test3_json_data.txt",
// 				dataType: "text" // 응답 데이터가 일반 텍스트로 전달되도록 "text" 타입 지정
// 			})
// 			.done(function(msg) {
// 				alert("요청 성공! - " + msg);
// 			})
// 			.fail(function() {
// 				alert("요청 실패!");
// 			});
			// ============================================================================
			// test3_json_data.txt 파일 내용 요청 시 응답 형식을 JSON 형식으로 지정하여
			// JSON 객체로 데이터가 응답되도록 할 수 있다! 
			// => 즉시, JSON 객체로 처리 가능
			// => 단, 잘못된 JSON 형태의 데이터도 일단 JSON 객체로 전달받음(처리 과정에서 오류 발생)
			$.ajax({
				type: "GET",
				url: "test3_json_data.txt",
				dataType: "json" // 응답 데이터가 JSON 객체 형태로 전달되도록 "json" 타입 지정
			})
			.done(function(data) {
// 				alert("요청 성공! - " + data); // JSON 객체 형태이므로 그대로 사용 불가(object 타입)
				// ------------------------------------------------------------------
				// 만약, 전달받은 JSON 객체를 문자열 형식으로 변환할 경우
				// 자바스크립트 내장 객체인 JSON 을 사용하여
				// JSON.stringify() 형식으로 메서드를 호출하여 변환 가능(파라미터 : JSON 객체)
// 				$("#resultArea").html(JSON.stringify(data)); // {"id":"admin","name":"관리자","age":0}
// 				$("#resultArea").append("<br>타입 : " + typeof(JSON.stringify(data))); // string
				// ------------------------------------------------------------------
				// JSON 데이터를 객체 형태로 접근하여 테이블에 해당 데이터 출력
				// JSON 데이터를 표시할 테이블 생성
				$("#resultArea").html(
					"<table border='1'><tr><th colspan='3'>JSON 데이터 파싱 결과</th></tr>"
					+ "<tr><th>아이디</th><th>이름</th><th>나이</th></tr></table>"
				);
				
				// JSON 데이터가 중괄호{} 로 감싸져 있을 경우 객체 데이터로 취급되고
				// 해당 객체 내의 속성들이 변수 역할을 수행하므로
				// AJAX 를 통해 리턴받은 객체가 저장된 변수 data 를 통해 id, name, age 속성에 접근
				// => 객체명.속성명 형태로 접근(ex. data.id)
				// #resultArea 영역의 <table> 태그 내에 마지막 요소로 1개 행 삽입
				$("#resultArea > table").append(
					"<tr>"
					+ "<td>" + data.id + "</td>"
					+ "<td>" + data.name + "</td>"
					+ "<td>" + data.age + "</td>"
					+ "</tr>"
				);
			})
			.fail(function() {
				alert("요청 실패!");
			});
			// ==========================================================================
			// test3_json_data.txt 파일 내용 요청 시 응답 형식을 JSON 형식으로 지정하여
			// JSON 객체로 데이터가 응답되도록 할 수 있다! 
			// => 즉시, JSON 객체로 처리 가능
			// => 단, 잘못된 JSON 형태의 데이터도 일단 JSON 객체로 전달받음(처리 과정에서 오류 발생)
			$.ajax({
				type: "GET",
				url: "test3_json_data2.json",
				dataType: "json" // 응답 데이터가 JSON 객체 형태로 전달되도록 "json" 타입 지정
			})
			.done(function(data) {
// 				alert("요청 성공! - " + data); // JSON 객체 형태이므로 그대로 사용 불가(object 타입)
				// ------------------------------------------------------------------
				// 만약, 전달받은 JSON 객체를 문자열 형식으로 변환할 경우
				// 자바스크립트 내장 객체인 JSON 을 사용하여
				// JSON.stringify() 형식으로 메서드를 호출하여 변환 가능(파라미터 : JSON 객체)
// 				$("#resultArea").html(JSON.stringify(data)); // {"id":"admin","name":"관리자","age":0}
// 				$("#resultArea").append("<br>타입 : " + typeof(JSON.stringify(data))); // string
				// ------------------------------------------------------------------
				// JSON 데이터를 객체 형태로 접근하여 테이블에 해당 데이터 출력
				// JSON 데이터를 표시할 테이블 생성
				$("#resultArea2").html(
					"<table border='1'><tr><th colspan='4'>JSON 데이터 파싱 결과</th></tr>"
					+ "<tr><th>아이디</th><th>이름</th><th>나이</th><th>주소</th></tr></table>"
				);
				
				// JSON 데이터에서 객체 내에 또 다른 객체가 포함되어 있을 경우
				// 객체명1.객체명2.속성명 형태로 접근
				$("#resultArea2 > table").append(
					"<tr>"
					+ "<td>" + data.id + "</td>"
					+ "<td>" + data.name + "</td>"
					+ "<td>" + data.age + "</td>"
// 					+ "<td>" + data.address + "</td>" // address 객체 내에 객체가 또 있으므로 object 출력됨
					+ "<td>" + data.address.address1 + " " + data.address.address2 + "</td>"
					+ "</tr>"
				);
			})
			.fail(function() {
				alert("요청 실패!");
			});
			
		});
	});
</script>
</head>
<body>
	<h1>test3_json.jsp - AJAX</h1>
	<input type="button" value="JSON 데이터 파싱" id="btnOk">
	<hr>
	<div id="resultArea"></div>
	<hr>
	<div id="resultArea2"></div>
</body>
</html>














