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
		// each() 메서드 : 대상 요소에 대한 반복을 수행하는 함수
		// => 지정 가능한 대상 : 태그, 배열 등의 객체
		// => 기본 문법 : $("선택자").each(function(index, item) {});
		//                (index 파라미터 : 대상 요소의 인덱스, item 파라미터 : 대상 요소 객체)
		
		// "h3" 태그를 차례대로 접근하는 반복문 작성
		$("h3").each(function(index, item) {
// 			alert(index + " : " + item);
			// 0 : [object HTMLHeadingElement], 1 : [object HTMLHeadingElement], 2 : [object HTMLHeadingElement]
			// => h3 태그가 세 개이므로, 각 요소를 차례대로 접근하여 세 번 반복됨
			// => index 파라미터에 요소의 순서번호(인덱스)가 전달되고
			//    item 파라미터에 해당 요소의 객체가 전달됨
			// => 단, 전달되는 객체는 jQuery 객체가 아닌 HTML 요소에 대한 객체로 전달됨
			//    따라서, 해당 객체를 통해 html() 등의 메서드를 직접 호출이 불가능하며,
			//    대상을 선택자 형식으로 지정하여 jQuery 메서드 호출해야한다!
// 			alert(index + " : " + item.html()); // 오류 발생!
			
			// 전달받은 HTML 객체를 jQuery 문장 내에 기술하여 jQuery 객체로 사용 가능
// 			alert(index + " : " + $(item).html());
			// 0 : element-1, 1 : element-2, 2 : element-3
			
			// 전달받은 객체를 가리키는 this 키워드 사용해도 현재 반복중인 대상 객체 접근 가능함
// 			alert(index + " : " + $(this).html());
			
			// table1 테이블 태그 내의 가장 마지막 요소로 index 값을 각 행에 데이터로 추가
			// => <tr><td></td></tr> 사이에 index 값을 데이터로 표시
// 			$("#table1").append("<tr><td>" + index + "</td></tr>");
			// => 첫번째 테이블의 번호 항목에 인덱스 번호가 차례대로 표시됨
			//    (h3 태그가 3개이므로 3번 반복하면서 0 ~ 2 까지의 값을 각 셀에 출력)
			
// 			$("table").append("<tr><td>" + index + "</td></tr>");
			// => 주의! 테이블이 복수개 존재할 경우 복수개의 테이블에 모두 적용됨
			
			// 두번째 테이블 내의 가장 마지막 요소로 
			// 인덱스 번호와 h3 태그 내의 텍스트 데이터를 차례대로 추가
// 			$("table").eq(1).append("<tr><td>" + index + "</td><td>" + $(item).text() + "</td></tr>");
			
		});
		
		// 배열을 활용하여 반복할 경우
		let arr = [
			{no : "1번", name : "홍길동"},
			{no : "2번", name : "이순신"},
			{no : "3번", name : "강감찬"}
		];
		
		// 배열처럼 지정할 선택자가 없을 경우 $.each() 형태로 메서드를 호출한 후
		// 파라미터로 반복할 객체(배열 등), 익명함수를 전달
		$.each(arr, function(index, item) {
// 			alert(item); // [object Object][object Object][object Object]
			// 배열 내의 요소가 각각의 객체이므로 객체명을 통해 객체 내의 값 접근 가능
			// => 이 때, 중괄호{} 로 묶인 객체만큼 자동으로 반복됨
			//    (배열 인덱스가 index 파라미터에, 배열 내의 각 객체가 item 파라미터에 전달됨)
			$("table").eq(1).append("<tr><td>" + item.no + "</td><td>" + item.name + "</td></tr>");
		});
		
	});
</script>
</head>
<body>
	<h1>jQuery - test9.jsp</h1>
	<h3>element-1</h3>
	<h3>element-2</h3>
	<h3>element-3</h3>
	<div></div>
	<table border="1" id="table1">
		<tr><th>번호</th></tr>
	</table>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>항목</th>
		</tr>
	</table>
</body>
</html>













