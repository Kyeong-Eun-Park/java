<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.6.4.js"></script>
<script type="text/javascript">
	/*
	[ 이벤트 처리 ]
	DOM 객체를 탐색 및 접근하여 대상에 대한 이벤트를 처리하는 방법
	- HTML 태그의 자바스크립트 이벤트와 동일(on'click', on'submit' 등)
	- 각각의 이벤트를 의미하는 메서드를 호출하거나
	  통합된 방식으로 on() 메서드를 통해 이벤트 지정 가능
	  ex) 클릭 이벤트 : click() 함수 또는 on("click") 함수 사용
	
	1. on("click") 메서드 이벤트
	- 특정 대상을 "클릭"했을 때 동작하는 이벤트 처리(click() 함수와 동일)
	- 클릭 대상에 대한 제한 없음(버튼이 아닌 요소도 적용 가능)
	
	2. on("focus") 메서드 또는 on("blur") 메서드 이벤트
	- 특정 대상에 포커스가 주어지거나 포커스 해제 시 동작하는 이벤트 처리
	- focus(), blur() 메서드로 대체 가능
	- 클릭이 아닌 키보드 등을 통한 포커스 이동도 동일하게 취급됨
	*/
	
	$(function() {
		// 버튼 클릭 시 이벤트 처리
// 		$("input[type=button]").on("click", function() {
// 			// 버튼들 중 아무 버튼이나 클릭 시 익명 함수 실행됨 
// 			alert("버튼 클릭!");
// 		});
		// 버튼 지정 시 "input[type=button]" 선택자 대신 가상선택자 ":button" 사용 가능
// 		$(":button").on("click", function() {
// 			// 버튼들 중 아무 버튼이나 클릭 시 익명 함수 실행됨 
// // 			alert("버튼 클릭!");
			
// 			// 버튼들 중에서 클릭된 대상에 포커스가 발생하므로 가상선택자(":focus") 사용하여
// 			// 클릭된 버튼을 판별 가능하며, 대상의 val() 메서드를 통해 버튼 텍스트 리턴 가능
// // 			alert($(":button:focus").val() + " 버튼 클릭!");
			
// 			if($(":button:focus").val() == "전송") { // 전송 버튼 클릭
// 				alert("전송 버튼 클릭됨!");
// 			} else if($(":button:focus").val() == "취소") { // 취소 버튼 클릭
// 				alert("취소 버튼 클릭됨!");
// 			}
// 		});
		
		// eq() 메서드를 통해 첫번째 버튼(전송 버튼) 클릭 시 이벤트 처리
		$(":button").eq(0).on("click", function() {
// 			alert("전송 버튼 클릭됨!");

			// 입력받은 아이디, 패스워드, 선택된 과목명을 textarea 에 출력
			// => 입력 항목 요소의 value 속성에 접근하기 위해 val() 메서드 활용
			$("#resultArea").val(
				"아이디 : " + $("input[name=id]").val() + "\n"
				+ "패스워드 : " + $("input[name=passwd]").val() + "\n"
				+ "선택과목 : " + $("#selectBox").val() + "\n"
			);
			
		});
		
		// textarea 를 "클릭" 했을 때의 이벤트 처리
// 		$("textarea").on("click", function() {
// 			alert("textarea 클릭!");
// 		});
		
		// div 영역("clickDiv") 클릭 시 이벤트 처리
		$("#clickDiv").on("click", function() {
			alert("div 영역 클릭!");
		});
		
		// textarea 에 포커스가 주어지면 이벤트 처리
		$("#resultArea").on("focus", function() {
			$("#resultArea").val("textarea focus in");
			
			// CSS 속성 중 배경색(background)을 "skyblue" 로 변경
			$("#resultArea").css("background", "skyblue");
		});
		
		// textarea 에서 포커스가 해제되면 이벤트 처리
		$("#resultArea").on("blur", function() {
			$("#resultArea").val("textarea focus out");
			
			// CSS 속성 중 배경색(background)을 "white" 로 변경
			$("#resultArea").css("background", "white");
		});
		
		// 아이디 및 패스워드 입력창에 포커스 요청 시 "skyblue", 해제 시 "white" 로 배경색 변경
		$("input").on("focus", function() {
// 			$("input[name=id]").css("background", "skyblue");

			// jQuery 객체 형태로 키워드 this 사용 시 현재 요소의 객체가 선택됨
			$(this).css("background", "skyblue");
		});
		
		$("input").on("blur", function() {
// 			$("input[name=id]").css("background", "white");
			$(this).css("background", "white");
		});
		
		
	});
	
</script>
</head>
<body>
	<h1>jQuery - test8.jsp</h1>
	<div>
		<div id="inputBox">
			아이디 : <input type="text" name="id" required="required"><br>
			패스워드 : <input type="password" name="passwd" required="required">
		</div>
		<select id="selectBox" name="subject">
			<option value="">과목을 선택하세요</option>
			<option value="자바">자바</option>
			<option value="JSP">JSP</option>
			<option value="스프링프레임워크">스프링프레임워크</option>
		</select>
		<br>
		<textarea rows="5" cols="20" id="resultArea"></textarea>
		<br>
		<input type="button" value="전송"><input type="button" value="취소">
	</div>
	-------------------
	<div id="clickDiv">&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</div>
	-------------------
</body>
</html>







