<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="../js/jquery-3.6.4.js"></script>
<script type="text/javascript">
	// ready 이벤트 처리
	$(function() {
		/*
		css() 메서드
		- 파라미터로 속성명 지정 시 해당 CSS 속성값 리턴
		  => 이 때, 대상이 복수개일 경우 첫번째 요소의 값만 리턴됨
		- 속성명과 속성값을 함께 지정 시 해당 CSS 속성값 변경
		  => 이 때, 대상이 복수개일 경우 복수개의 모든 요소에 변경 작업 적용됨
	    - 메서드 파라미터에 익명함수 활용할 경우 대상 요소를 차례대로 접근하는
	      반복문 형태로 사용 가능함
		*/
		// h3 태그의 "color" 속성값 출력
// 		alert($("h3").css("color")); // rgb(0, 0, 0)
		
		// h3 태그 중 첫번째 요소 글자색 파란색으로 변경
		$("h3:first").css("color", "blue");
// 		alert($("h3").css("color")); // rgb(0, 0, 255)
		
		// css() 메서드(다른 메서드에도 적용됨) 내에서 익명 함수 구현 시
		// 대상 태그를 차례대로 접근하는 반복문 형태로 활용 가능함
		// css("속성명", function(index, value) {});
		// => 대상 태그를 차례대로 접근하면서 해당 요소의 인덱스와 속성값이 파라미터로 전달됨
		//    이 때, 해당 작업은 반복문 형태로 처리됨
		// 1) 파라미터가 없는 익명 함수 구현 시 => 해당 선택자 요소 갯수만큼 반복 실행됨
		$("h3").css("color", function() {
// 			alert("h3 태그 접근!"); // 3번 호출됨(h3 태그가 3개이므로)
		});
	
		// 2) 파라미터가 1개인 익명 함수 구현 시 => 해당 요소의 인덱스가 전달됨(태그 순서 번호)
		$("h3").css("color", function(index) {
// 			// 대상 선택자 요소가 0번째 요소부터 차례대로 요소의 인덱스 값이 전달됨
// 			alert(index + "번 h3 태그 접근!"); // 0 ~ 2번 태그까지 총 3번 호출됨
		});
		
		// 3) 파라미터가 2개인 익명 함수 구현 시 
		//    => 해당 요소의 인덱스와 속성값이 전달됨
		$("h3").css("color", function(index, value) {
			// 대상 선택자 요소의 0번째 요소부터 차례대로 접근하여 
			// 해당 요소의 인덱스 값과 속성값이 전달됨
// 			alert(index + "번 h3 태그 접근 - 속성값 : " + value);
		});
		
		// =============================================================
		// 함수 반복하면서 해당 속성값을 변경하는 방법
		// => return 문 뒤에 변경할 값을 지정
		// -------------------------------------------
		// 대상 태그의 color 속성값을 차례대로 한꺼번에 변경
// 		$("h3").css("color", function() {
// 			return "red"; // 모든 h3 태그의 "color" 속성값을 "red" 변경
// 		});
		
		// 대상 태그의 color 속성값을 각각 다른 색으로 변경
		// => 함수 파라미터로 인덱스를 전달받고, 변경할 색상을 배열을 통해 저장하여 활용
		let colorValue = ["red", "green", "blue"];
		let bgColorValue = ["cyan", "magenta", "yellow"];
		
// 		$("h3").css("color", function(index) {
// 			// 배열 인덱스 지정을 위해 함수 파라미터로 전달된 index 값 활용
// 			return colorValue[index];
// 		});
		
		// 대상 태그의 "background" 속성값을 각각 "cyan", "magenta", "yellow" 로 변경
// 		$("h3").css("background", function(index) {
// 			return bgColorValue[index];
// 		});
		
		// 동일한 대상에 복수개의 속성을 반복 형태로 변경하는 경우
		// $("선택자").메서드명({속성1 : function(index) {}}, {속성2 : function(index) {}});
		$("h3").css({
			color : function(index) {
				// 글자색 변경을 위한 return 문 사용
				return colorValue[index];
			},
			background : function(index) {
				// 배경색 변경을 위한 return 문 사용
				return bgColorValue[index];
			}
		});
	});
	
	
	
</script>
</head>
<body>
	<h1>jQuery - test3.jsp</h1>
	<h3>제목1</h3>
	<h3>제목2</h3>
	<h3>제목3</h3>
</body>
</html>










