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
			$.ajax({
				type: "GET",
				url: "test4_json_data.json",
				dataType: "json" // 응답 데이터가 JSON 객체 형태로 전달되도록 "json" 타입 지정
			})
			.done(function(data) {
				$("#resultArea").html(
					"<table border='1'><tr><th>JSON 데이터 파싱 결과</th></tr>"
					+ "<tr><th>이름</th></table>"
				);
				
				// 응답된 JSON 데이터가 배열 형태일 경우(데이터 직접 출력도 가능)
				// => 일반 자바스크립트 배열 접근 형식과 동일(반복문 사용)
				// 배열 data 의 길이만큼 for문을 통해 반복 수행
// 				for(let i = 0; i < data.length; i++) {
// 					// 배열명[i] 형식으로 배열의 각 요소에 접근
// 					$("#resultArea > table").append(
// 						"<tr>"
// 						+ "<td>" + data[i] + "</td>"
// 						+ "</tr>"
// 					);
// 				}
				
				// for...of 문으로 동일한 작업 수행
				for(let name of data) {
					$("#resultArea > table").append(
						"<tr>"
						+ "<td>" + name + "</td>"
						+ "</tr>"
					);
				}
			})
			.fail(function() {
				alert("요청 실패!");
			});
			
			$.ajax({
				type: "GET",
				url: "test4_json_data2.json",
				dataType: "json" // 응답 데이터가 JSON 객체 형태로 전달되도록 "json" 타입 지정
			})
			.done(function(data) {
				$("#resultArea2").html(
					"<table border='1'><tr><th colspan='3'>JSON 데이터 파싱 결과</th></tr>"
					+ "<tr><th>아이디</th><th>이름</th><th>나이</th></tr></table>"
				);
				
				// 배열 내에 객체 형태로 JSON 데이터가 존재할 경우
				// => 배열 반복하면서 각 배열 요소(객체) 내의 속성에 접근
				for(let member of data) {
					$("#resultArea2 > table").append(
						"<tr>"
						+ "<td>" + member.id + "</td>"
						+ "<td>" + member.name + "</td>"
						+ "<td>" + member.age + "</td>"
						+ "</tr>"
					);
				}
				
			})
			.fail(function() {
				alert("요청 실패!");
			});
			
			// ------------------------------------------------------------
			$.ajax({
				type: "GET",
				url: "test4_json_data3.json",
				dataType: "json" // 응답 데이터가 JSON 객체 형태로 전달되도록 "json" 타입 지정
			})
			.done(function(data) {
				$("#resultArea3").html(
					"<table border='1'><tr><th colspan='4'>JSON 데이터 파싱 결과</th></tr>"
					+ "<tr><th>아이디</th><th>이름</th><th>나이</th><th>주소</th></tr></table>"
				);
				
				// 배열 내에 객체 형태로 JSON 데이터가 존재할 경우(객체 내에 또다른 객체 존재)
				// => 배열 반복하면서 각 배열 요소(객체) 내의 속성에 접근하여
				//    해당 객체 내의 다른 객체에 다시 접근
				for(let member of data) {
					$("#resultArea3 > table").append(
						"<tr>"
						+ "<td>" + member.id + "</td>"
						+ "<td>" + member.name + "</td>"
						+ "<td>" + member.age + "</td>"
						+ "<td>" + member.address.address1 + " " + member.address.address2 + "</td>"
						+ "</tr>"
					);
				}
				
			})
			.fail(function() {
				alert("요청 실패!");
			});
			
		});
		
		// ------------------------------------------------------------
		
		
	});
</script>
</head>
<body>
	<h1>test4_json.jsp - AJAX</h1>
	<input type="button" value="JSON 데이터 파싱" id="btnOk">
	<hr>
	<div id="resultArea"></div>
	<hr>
	<div id="resultArea2"></div>
	<hr>
	<div id="resultArea3"></div>
</body>
</html>














