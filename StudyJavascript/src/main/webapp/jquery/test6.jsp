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
	eq(인덱스)
	- 선택자를 포함하여 형제자매 요소 탐색
	- 인덱스는 0부터 시작하며, 인덱스에 해당하는 순서에 위치한 요소를 가져옴
	- 음수는 뒤에서부터 탐색
	
	attr('HTML속성명')
	- 선택자에서 해당 속성의 값을 가져오거나 추가
	- HTML 태그 속성값 자체를 가져오며 상태에 따라 변하지 않음
	  ex) 체크박스 checked="checked" 속성값을 가져올 때 체크상태가 변해도 checked 임
	  
	prop('Javascript속성명')
	- 선택자에서 해당 속성의 값에 대한 상태를 가져오거나 추가
	- 값 자체를 다루지 않고 해당 속성의 값에 대한 true/false 리턴
	- attr() 함수와 유사하나 HTML 태그의 상태에 따라 결과값이 변함
	  ex) 체크박스 checked="checked" 의 속성값을 가져올 때
	      체크박스 체크 시 true 리턴, 해제 시 false 리턴
	
	is()
	- 선택자가 입력한 값과 관련된 상태 확인 후 일치 여부(true/false) 리턴
	- 선택자의 실행 결과나 태그 확인용
	- prop() 함수 리턴값을 boolean 타입으로 비교하는 것과 동일
	*/
	$(function() {
		// 버튼 클릭 시 이벤트 처리 수행
		// => 버튼을 지정하여 click() 함수를 호출 후 파라미터로 익명함수 전달
		$("#btn").click(function() {
			// 대상 선택자 요소가 동일한 복수개일 경우 대상 선택자에 eq() 함수를 사용하여
			// 동일 요소들 중 지정한 인덱스에 해당하는 순서의 요소 지정
			// => 요소 지정 후 attr() 또는 prop() 함수를 통해 해당 요소의 속성에 접근
			// 1) checkbox 중에서 두번째 체크박스를 지정하여 HTML 기준 checked 속성 확인
			let attr1 = $("input[type=checkbox]").eq(1).attr("checked");
			// => checkbox 태그 내의 속성 중 "checked" 속성 값이 "checked"이므로 항상 "checked"
			
			// 2) checkbox 중에서 세번째 체크박스를 지정하여 HTML 기준 checked 속성 확인
			let attr2 = $("input[type=checkbox]").eq(2).attr("checked");
	  		// => checked 속성이 존재하지 않으므로 undefined
	  		
	  		// 3) checkbox 중에서 두번째 체크박스를 지정하여 자바스크립트 기준 checked 속성 확인
	  		// => attr() 메서드 대신 prop() 메서드 사용
	  		let prop1 = $(":checkbox").eq(1).prop("checked");
	  		// => checked 속성이 존재하며, 현재 체크 상태에 따라 true 또는 false 
	  		// => 가상선택자 중 ":checkbox" 지정 시 체크박스 지정 가능함
	  		let prop2 = $("input[type=checkbox]").eq(2).prop("checked");
	  		// => checked 속성이 존재하지 않지만, 현재 체크 상태에 따라 true 또는 false 
			
	  		// 가상선택자(:checked) 를 활용하여 대상 체크박스의 체크상태 비교
	  		let is1 = $("input[type=checkbox]").eq(1).is(":checked");
 	 		// => checked 속성이 존재하며, 현재 체크 상태가 checked 일 경우 true(체크)이면 true 아니면 false
	  		let is2 = $("input[type=checkbox]").eq(2).is(":checked");
	  	// => checked 속성이 존재하며, 현재 체크 상태가 checked 일 경우 true(체크)이면 true 아니면 false 
		
			// 결과 확인
			// id 선택자가 "result" 인 요소 내부에 attr1 값 출력
			$("#result").html(
					"attr1 = " + attr1 + ", attr2 = " + attr2
					+ "<br>prop1 = " + prop1 + ", prop2 = " + prop2
					+ "<br>is1 = " + is1 + ", is2 = " + is2);
	  	
	  		// =============================================================
	  		// 전체선택 체크박스(id="allCheck") 의 체크상태 확인
// 	  		alert($("#allCheck").prop("checked"));
	  		// 만약, 전체선택 체크박스의 체크상태가 true 일 경우
	  		// 다른 3개의 체크박스를 모두 체크상태로 변경
	  		// => prop() 메서드 파라미터로 속성명과 함께 true 또는 false 값 전달
	  		if($("#allCheck").prop("checked")) {
// 	  			alert("전체선택 체크됨!");
				$(":checkbox").eq(1).prop("checked", true); // 대상 체크박스를 체크상태로 변경
				$(":checkbox").eq(2).prop("checked", true); // 대상 체크박스를 체크상태로 변경
				$(":checkbox").eq(3).prop("checked", true); // 대상 체크박스를 체크상태로 변경
	  		} else {
				$(":checkbox").eq(1).prop("checked", false); // 체크해제상태로 변경
				$(":checkbox").eq(2).prop("checked", false); // 체크해제상태로 변경
				$(":checkbox").eq(3).prop("checked", false); // 체크해제상태로 변경
	  		}
	  		
		});
	});
</script>
</head>
<body>
	<h1>jQuery - test6.jsp</h1>
	<table border="1">
		<tr>
			<th><input type="checkbox" id="allCheck"></th>
			<th>번호</th>
			<th>이름</th>
		</tr>
		<tr>
			<th><input type="checkbox" name="check" id="check1" checked="checked" value="1"></th>
			<th>1</th>
			<th>홍길동</th>
		</tr>
		<tr>
			<th><input type="checkbox" name="check" value="2"></th>
			<th>2</th>
			<th>이순신</th>
		</tr>
		<tr>
			<th><input type="checkbox"  name="check" value="3"></th>
			<th>3</th>
			<th>강감찬</th>
		</tr>
		<tr>
			<td colspan="3">
				<input type="button" value="확인" id="btn"><br>
				<div id="result">결과 확인 위치</div>
			</td>
		</tr>
	</table>
</body>
</html>













