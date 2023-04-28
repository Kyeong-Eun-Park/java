<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.4.js"></script>
<script type="text/javascript">
	/*
	AJAX(Asynchonous Javascript And Xml, 비동기식 자바스크립트&XML)
	- 웹 페이지(브라우저)의 갱신(Refresh) 없이도 요청을 수행하고 
	  요청에 대한 응답을 처리할 수 있는 자바스크립트(jQuery) 라이브러리
	- 데이터베이스 등의 작업 요청 시 요청된 응답이 돌아올 때까지 기다리지 않고
	  다른 작업을 수행하면서 요청에 대한 응답이 돌아오면 해당 응답을 처리하는 기술
	- 주로, 아이디 및 패스워드 검증 등의 실시간 정보 조회 작업에 활용
	
	< 기본 문법 >
	$.ajax({
		type : xxx, // AJAX 로 요청 시 사용할 메서드(= 요청 방식 = "GET" or "POST" 등) 지정
		url : xxx, // AJAX 로 요청할 요청 주소(URL)
		data : xxx, // 요청(전송할) 데이터 지정(복수개 파라미터일 경우 중괄호로 묶음)
		dataType : xxx, // 응답 데이터에 대한 타입 지정
		success : function(response) { // 요청에 대한 처리 성공 시 처리할 함수 정의
			
		}, 
		error : function(xhr, textStatus, errorThrown) { // 요청에 대한 처리 실패 시 처리할 함수 정의
			
		}
	});
	*/
	
	// 로그인 버튼이 클릭되었을 때 AJAX 를 사용하여 test1_result.jsp 페이지로 요청 전송하기
	$(function() {
		$("#btnLogin").on("click", function() {
			
// 			$.ajax({
// 				type: "post", // 요청 방식을 POST 방식으로 지정
// 				url: "test1_result.jsp", // AJAX 로 요청할 요청 주소(URL)
// 				data: { // 전송할 데이터가 복수개일 경우 중괄호로 묶기
// 					// 폼에서 입력한 데이터를 가져와서 파라미터로 표현(전송)하는 경우
// 					// 파라미터명 : 데이터 형식으로 지정
// 					id: $("#id").val(), // id 선택자의 value 속성값을 id 파라미터로 저장
// 					passwd: $("#passwd").val() // passwd 선택자의 value 속성값을 passwd 파라미터로 저장
// 					// -------- 값을 직접 지정 시 --------
// // 					id: "admin", // id 선택자의 value 속성값을 id 파라미터로 저장
// // 					passwd: "1234" // passwd 선택자의 value 속성값을 passwd 파라미터로 저장
// 				},
// 				dataType: "text",
// 				success: function(response) { // 요청 처리 성공 시 자동으로 호출되는 콜백함수
// 					// 익명 함수 파라미터로 응답 데이터가 전달됨(처리하는 페이지에서 응답한 결과)
// 					// id 선택자 "resultArea" 영역에 응답 데이터(response) 출력하기
// 					$("#resultArea").html(response);
// 				},
// 				error: function(xhr, textStatus, errorThrown) {
// 					// 요청 처리 실패 시(= 에러 발생 시) 자동으로 호출되는 콜백함수
// 					$("#resultArea").html(
// 							"xhr = " + xhr + 
// 							"<br>textStatus = " + textStatus +
// 							"<br>errorThrown = " + errorThrown);
// 				}
// 			});
			
			// --------------------------------------------------------------------
			// form 태그 내부 파라미터를 모두 요청 페이지로 전송해야할 때
			// 자바스크립트를 통해 요소 각각에 접근하여 데이터를 가져올 수도 있지만
			// 폼(form 객체)를 대상으로 serialize() 메서드를 호출하면
			// 해당 폼의 데이터를 직렬화를 통해 내보내기 가능
			let sendData = $("form").serialize(); // 태그 선택자 "form" 활용하여 데이터 직렬화
// 			alert(sendData); // id=admin&passwd=1234
			
			$.ajax({
				type: "post",
// 				url: "test1_result.jsp",
				// 실제 로그인 작업을 수행하는 MemberLoginPro.me 서블릿 주소 요청
				url: "MemberLoginPro.me",
				// serialize() 메서드를 통해 가져온 폼데이터를 전송할 데이터로 지정(중괄호 불필요)
				data: sendData, // sendData 변수 대신 직접 $("form").serialize() 지정도 가능
				dataType: "text",
				success: function(response) { // 요청 처리 성공 시 자동으로 호출되는 콜백함수
					// 익명 함수 파라미터로 응답 데이터가 전달됨(처리하는 페이지에서 응답한 결과)
					// id 선택자 "resultArea" 영역에 응답 데이터(response) 출력하기
					$("#resultArea").html(response);
				},
				error: function(xhr, textStatus, errorThrown) {
					// 요청 처리 실패 시(= 에러 발생 시) 자동으로 호출되는 콜백함수
					$("#resultArea").html(
							"xhr = " + xhr + 
							"<br>textStatus = " + textStatus +
							"<br>errorThrown = " + errorThrown);
				}
			});
			
			
		});
	});
	
</script>
</head>
<body>
	<h1>AJAX - test1.jsp</h1>
	<form action="" method="post">
		<table border="1">
			<tr>
				<th>아이디</th>
				<td><input type="text" name="id" id="id" required="required"></td>
			</tr>
			<tr>
				<th>패스워드</th>
				<td><input type="password" name="passwd" id="passwd" required="required"></td>
			</tr>
			<tr>
				<td colspan="2" id="btnArea">
					<input type="button" id="btnLogin" value="로그인">
				</td>
			</tr>
		</table>
	</form>
	<hr>
	<h1>응답 처리 결과</h1>
	<div id="resultArea"><!-- AJAX 요청에 대한 응답 처리 결과를 출력할 위치 --></div>
	
</body>
</html>











