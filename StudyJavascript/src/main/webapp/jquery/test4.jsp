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
		/*
		특정 요소에 대한 조작 이벤트
		1. html()
		   - HTML 문서 내에서 지정된 범위(선택자) 안의 모든 요소를 가져오거나 추가하는 함수
		   - 요소를 가져올 때 주석까지 포함해서 가져옴
		   - 단, XML 문서를 대상으로는 사용 불가
		2. text()
		   - html() 함수와 달리 HTML 문서 및 XML 문서 모두 사용 가능
		   - 모든 문자열을 가져오거나 추가 가능
		   - 단, 브라우저마다 줄바꿈이나 공백 등이 달라질 수 있음
		3. empty() 
		   - 지정된 선택자 내의 하위 요소 제거(비움)
		4. remove()
		   - 지정된 선택자와 선택자 내의 하위 요소 모두 제거
		*/
		
		// h3 태그 내의 HTML 요소 가져오기
// 		alert($("h3").html()); // "h3" 태그 내의 HTML 요소인 "제목1" 텍스트 요소 출력됨

		// id 선택자가 "h3_2" 인 태그의 모든 요소(HTML 요소) 가져오기
// 		alert($("#h3_2").html()); // "#h3_2" 선택자 내의 모든 요소가 그대로 출력됨(태그 포함)
		// 제목2&nbsp;<span>제목2-1</span>&nbsp;<span>제목2-2</span>
		
		// id 선택자가 "h3_2" 인 태그의 텍스트 요소 가져오기
// 		alert($("#h3_2").text()); // "#h3_2" 선택자 내의 요소 중 텍스트 요소만 출력됨
		// 제목2 제목2-1 제목2-2
		// -------------------------------------------------------------------------
		// html() 메서드를 사용하여 대상 태그의 요소 바꾸기(= 태그 그대로 적용 가능)
		// id 선택자가 "h3_1" 인 태그의 요소 내용 바꾸기
		// => 자바스크립틔의 document.getElementById("선택자").innerHTML = "값"; 과 동일함
		$("#h3_1").html("<i>italic 적용된 제목1</i>");
		
		// test() 메서드를 사용하여 대상 태그의 텍스트 바꾸기(= 태그도 텍스트로 취급)
		// id 선택자가 "h3_1" 인 태그의 요소의 텍스트 바꾸기
// 		$("#h3_1").text("<i>italic 적용된 제목1</i>");
		// --------------------------------------------------------------------------
		// html() 메서드 내에서 익명함수 구현을 통해 반복문 형태로 요소 내용 접근 가능
		// => html(function(index, oldHtml)) 형식으로 정의
		//    (이 때, index 는 요소의 인덱스, oldHtml : 기존 요소 내용)
		// => 해당 태그에 값 적용(= 변경)하려면 return 문 사용
		$("h3").html(function(index, oldHtml) {
			return oldHtml + " 입니다.";
			// => 기존 요소의 내용(oldHtml) + 새로운 내용(" 입니다.") 형태로 변경
			// => 만약, html() 대신 text() 메서드 사용 시 첫번째 요소의 <i> 태그 제거됨
		});
		
		// -----------------------------------------------------------------------------
		// 대상 요소를 제거 : empty(), remove()
		// empty() 메서드 : 대상 선택자 내의 하위 요소들을 제거(= 대상 태그는 남겨둠)
		// remove() 메서드 : 대상 선택자 및 선택자 내의 하위 요소들을 제거(= 대상 태그 자체 제거)
		// => 개발자 도구 및 소스 보기에서 결과 확인이 불가능하므로
		//    작업 완료 후 대상 요소의 내용을 textarea 등에 출력해서 확인해야함 
		$("#h3_2").empty(); // 대상 요소인 <h3 id="h3_2"></h3> 태그는 남아있음
// 		$("#h3_2").remove(); // 대상 요소인 <h3 id="h3_2"></h3> 태그도 제거됨
		
		// id 선택자가 "ta" 인 textarea 에 id 선택자가 "wrap" 인 HTML 요소 전체를 표시
// 		$("#ta").html($("#wrap").html());
// 		$("#ta").text($("#wrap").html());
		$("#ta").val($("#wrap").html());
		
	});
</script>
</head>
<body>
	<h1>jQuery - test4.jsp</h1>
	<div id="wrap">
		<!-- 제목 표시 공간 -->
		<h3 id="h3_1">제목1</h3>
		<h3 id="h3_2">제목2&nbsp;<span>제목2-1</span>&nbsp;<span>제목2-2</span></h3>
		<h3 id="h3_3">제목3</h3>
	</div>
	<textarea rows="5" cols="50" id="ta"></textarea>
</body>
</html>
















