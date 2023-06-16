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
	선택자(Selector)
	- 문서 객체 내의 요소 선택을 위한 용도로 사용하는 구성 요소
	- 자바스크립트에서 사용하는 document.getElementXXX() 또는 document.querySelector() 와 달리
	  jQuery 에서는 $("선택자") 형태로 대상을 지정하므로 문장이 간결해짐
	  
	< 선택자 지정 기본 문법 >
	$("선택자" 또는 "*").함수명("속성명", "속성값");
	
	ex) 지정한 요소에 대한 CSS 속성을 변경하는 기본 문법
	    => $("선택자").css("속성명", "속성값");
	-----------------------------------------------------------------
	< 선택자 종류 >
	1. 직접 선택자 - 특정 대상(요소)을 직접 지정하기 위한 선택자
	   1) 아이디(#) - 페이지 내에서 유일한 요소(중복 불가) => $("#선택자명")
	   2) 클래스(.) - 복수개의 동일한 요소 => $(".선택자명")
	   3) 태그 - 동일한 태그를 갖는 복수개의 요소 => $("태그명")
	   4) 태그 속성 - 동일한 태그들 중 특정 속성을 갖는 요소만 지정 => $("태그명[속성명]")
	   5) 태그 속성 값 - 동일한 태그의 동일 속성들 중 특정 속성값을 갖는 요소만 지정 
	                     => $("태그명[속성명=값]")
	*/
	// ready 이벤트를 통해 문서 내의 선택자 요소에 접근
// 	$(document).ready(function() {
// 		alert("ready 이벤트!");
// 	});
	                     
	$(function() {
// 		alert("ready 이벤트22!");

		// 전체 요소(*)에 대한 CSS 속성을 변경
		// 모든 요소의 글자색("color" 속성)을 "red" 로 변경
		$("*").css("color", "red");
		
		// id 선택자(#) 중 "idSelector" 라는 이름을 갖는 요소의 글자색을 "blue" 로 변경
		$("#idSelector").css("color", "blue");
		
		// "idSelector" 라는 id 선택자의 "color" 속성에 대한 값 접근(= 값 확인)
// 		alert($("#idSelector").css("color")); // rgb(0, 0, 255) = blue
		
		// class 선택자(.) 중 "classSelector" 라는 이름을 갖는 요소 글자색을 "orange" 로 변경
		$(".classSelector").css("color", "orange");
		
		// class 선택자 "classSelector" 의 "color" 속성값을 리턴받아 변수 color 에 저장 후 출력
// 		let color = $(".classSelector").css("color");
// 		alert(color); // rgb(255, 165, 0) = orange
		
		// -------------------------------------------------------------------------------
		// 태그 선택자 활용
		// => 별도의 선택자를 따로 지정하지 않고, 태그 자체의 이름(= 태그명)으로 접근
		// table 태그의 테두리 변경, 배경색 변경
		// 1) table 태그를 지정하여 CSS 속성 중 테두리("border") 를 "1px solid blue" 로 변경
// 		$("table").css("border", "1px solid blue");
		
		// 2) table 태그의 배경색("background" 속성)을 "yellow" 로 변경
// 		$("table").css("background", "yellow");
		
		// 동일한 대상에 복수개의 작업을 수행할 경우
		// => 각각의 메서드를 연결하여 연쇄적으로 호출 가능하다!
// 		$("table").css("border", "1px solid blue").css("backgroundColor", "pink");
		// => background 또는 background-color 모두 배경색을 변경하는 CSS 속성명이다.
		//    이 때, 이름에 - 기호가 포함된 속성명은 - 기호를 제거하고 
		//    - 기호 뒤의 단어 첫글자를 대문자로 표기
		//    ex) background-color 속성 : backgroundColor 로 지정
		
		// 동일한 대상에 동일한 메서드를 적용할 경우
		// 하나의 메서드명을 기술하고 소괄호 내에 중괄호 블럭을 지정하여
		// 복수개의 속성을 한꺼번에 변경 가능(실제 CSS 와 유사)
		$("table").css({
			border : "1px solid blue",
			background : "lightgray"
		});
		
		// -------------------------------------------------------------
		// 태그들 중 특정 속성값을 갖는 태그 지정
		// input 태그들 중 type 속성값이 "text" 인 요소의 배경색을 "yellow" 로 변경
		$("input[type=text]").css("background", "yellow");
	}); // ready 이벤트 끝
	
	/*
	===========================================================================
	2. 인접 관계 선택자
	   1) 자식 선택자(>) - 특정 선택자의 바로 하위 요소(자식) 선택
	      => $("부모선택자 > 자식선택자")
	   2) 자식 또는 후손 선택자(공백) - 특정 선택자 하위에 일치하는 모든 요소 선택
	      => $("부모선택자 자식선택자")
	   3) 순서 선택자 - 특정 선택자 기준 지정된 순서에 해당하는 요소 선택
	      => $("선택자명:옵션명")
	      ex) 첫번째 요소 : "선택자명:first", 마지막 요소 : "선택자명:last"
	          홀수번째 요소 : "선택자명:odd", "짝수번째 요소" : "선택자명:even" 등
	*/
	
	// 또 다른 ready 이벤트 처리(ready 이벤트는 복수개 등록 가능하며, 차례대로 실행됨)
	$(document).ready(function() {
		// table 태그의 하위 요소들 중 첫번째 tr 태그의 배경색만 "green" 으로 변경
		$("table tr:first").css("background", "green");
		
		// tr 태그들 중 홀수번째(1, 3) tr 태그의 배경색만 "pink" 로 변경
		$("tr:odd").css("background", "pink");
		// tr 태그들 중 짝수번째(0, 2, 4) tr 태그의 배경색만 "yellow" 로 변경
		$("tr:even").css("background", "yellow");
		
		// ---------------------------------------
		// 대상 요소의 value 속성 접근 : val() 메서드 활용
		// id 선택자 "inputBox" 의 자식 중 input 태그의 type 속성이 "text" 인 요소의 값 가져오기
		let id = $("#inputBox > input[type=text]").val();
		// id 선택자 "inputBox" 의 자식 중 input 태그의 type 속성이 "password" 인 요소의 값 가져오기
		let passwd = $("#inputBox > input[type=password]").val();
// 		alert("아이디 : " + id + ", 패스워드 : " + passwd);

		// inputBox 하위 요소들 중 textarea 태그 속성이 readonly 인 요소 배경색 "lightgray" 로 변경
		$("#inputBox textarea[readonly]").css("background", "lightgray");
		
		// --------------------------------------------------------------------------
		// id 선택자가 "divBox" 인 요소의 후손들인 "div" 태그 글자색을 "blue" 로 변경
// 		$("#divBox div").css("color", "blue"); // 1, 1-1, 1-2, 2, 3, 3-1, 3-2 변경됨
		// => 즉, #divBox 요소 내의 모든 div 태그 글자색이 변경됨
		
		// id 선택자가 "divBox" 인 요소의 자식들인 "div" 태그 글자색을 "green" 으로 변경
		$("#divBox > div").css("color", "green"); // 1, 2, 3 변경됨
		// => 즉, #divBox 요소 내의 첫 단계 div 태그들만 글자색이 변경됨
		// -------------------------------------------------------------------------------
		// id 선택자가 "selectBox" 인 요소에서 선택된 값(option 태그의 selected 속성 있는 값)을
		// 가져와서 id 선택자가 "selectResult" 인 요소에 표시(출력)하기
		// => option:selected 사용
		let selectedItem = $("#selectBox > option:selected").val();
		// val() 함수에 값을 전달할 경우 해당 태그의 value 속성값 변경
		$("#selectResult").val(selectedItem);
		// => 주의! document 객체의 ready 이벤트 내에서 진행되는 작업이므로
		//    셀렉트박스 값이 변경되어도 변경된 값이 출력되지는 않는다!
	});
</script>
</head>
<body>
	<h1>jQuery - test2.jsp</h1>
	<hr>
	<h3 id="idSelector">id 선택자</h3>
	<h3 class="classSelector">class 선택자</h3>
	<h3 class="classSelector">class 선택자2</h3>
	<hr>
	<table border="1">
		<tr><td>번호</td><td>제목</td></tr>
		<tr><td>1</td><td>1번제목</td></tr>
		<tr><td>2</td><td>2번제목</td></tr>
		<tr><td>3</td><td>3번제목</td></tr>
		<tr><td>4</td><td>4번제목</td></tr>
	</table>
	<hr>
	<div id="inputBox">
		<input type="text" value="admin" id="id">
		<input type="password" value="1234" id="passwd"><br>
		<textarea rows="5" cols="20" readonly="readonly"></textarea>
		<textarea rows="5" cols="20" id="inputData"></textarea>
	</div>
	<hr>
	<div id="divBox">
		<div>
			1번 div 태그
			<div>1-1번 div 태그</div>
			<div>1-2번 div 태그</div>
		</div>
		<span>span 태그</span>
		<div>2번 div 태그</div>
		<div>
			3번 div 태그
			<div>3-1번 div 태그</div>
			<div>3-2번 div 태그</div>
		</div>
	</div>
	<hr>
	<select id="selectBox">
		<option value="JAVA">JAVA</option>
		<option value="JSP">JSP</option>
		<option value="Spring Framework">Spring Framework</option>
	</select>
	<input type="text" id="selectResult">
</body>
</html>