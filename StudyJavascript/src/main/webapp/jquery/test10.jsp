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
		$("table").css("width", "300px").css("text-align", "center");
		
		// on("change") 이벤트
		// - 특정 대상의 "상태가 변하면" 동작하는 이벤트 
		// - 기본 문법 : on("change", function() {})
		// --------------------------------------------------
		// 전체선택 체크박스의 체크 상태가 변하면 이벤트 처리
		$("#allCheck").on("change", function() {
			// 전체선택 체크박스의 상태가 checked 인지 판별 후
			// 체크 상태일 경우 다른 모든 체크박스 체크, 체크 해제 시 모두 해제
			if($("#allCheck").is(":checked")) { // 전체선택 체크 시
				// prop() 함수를 사용하여 체크 상태를 true 로 변경
				// => each() 메서드를 활용하여 체크박스 요소를 반복 접근하거나
				//    체크박스 전체를 지정하는 방법 사용(가상선택자 :checkbox 사용)
// 				$(":checkbox").each(function(index, item) {
// 					$(item).prop("checked", true);
// 				});
				
				$(":checkbox").prop("checked", true);
			} else { // 전체선택 체크 해제 시
				$(":checkbox").prop("checked", false);
			}
		});
		
		// 셀렉트박스 항목 선택(= 항목 변경) 시 이벤트 처리
		$("#selectBox").on("change", function() {
			// 선택된 항목의 값(value 속성값)을 출력
// 			alert($("#selectBox").val() + " 선택됨!");
			
			// 선택된 값을 회원목록 조회 서블릿 요청 시 파라미터로 전달
			location.href = "MemberList.me?level=" + $("#selectBox").val();
		});
		
		// 텍스트박스(id="keyword")의 내용이 변경되면 이벤트 처리
		// => 텍스트 입력이 끝난 후 포커스가 해제될 때 이전 내용과 다름 여부 판별하여 동작
		//    즉, 변경 전 내용과 포커스 해제 시 내용이 같으면 동작하지 않음
		$("#keyword").on("change", function() {
			alert("내용 변경됨!");
			$("#resultArea").html($("#keyword").val());
		});
		
		// 텍스트박스에 포커스가 위치한 채로 키보드를 눌렀다 "떼면" 이벤트 동작
		$("#keyword").on("keyup", function() {
			$("#resultArea").html($("#keyword").val());
		});
		
	});
</script>
</head>
<body>
	<h1>jQuery - test10.jsp</h1>
	<table border="1">
		<tr>
			<td colspan="3">
				<select id="selectBox" name="level">
					<option value="전체">전체</option>
					<option value="VIP">VIP</option>
					<option value="일반">일반</option>
				</select>
			</td>
		</tr>
		<tr>
			<th><input type="checkbox" id="allCheck">전체</th>
			<th>번호</th>
			<th>이름</th>
		</tr>
		<tr>
			<th><input type="checkbox" name="check"></th>
			<th>1</th>
			<th>홍길동</th>
		</tr>
		<tr>
			<th><input type="checkbox" name="check"></th>
			<th>2</th>
			<th>이순신</th>
		</tr>
		<tr>
			<th><input type="checkbox"  name="check"></th>
			<th>3</th>
			<th>강감찬</th>
		</tr>
		<tr>
			<td colspan="3">
				<select id="searchType" name="searchType">
					<option value="이름">이름</option>
					<option value="아이디">아이디</option>
				</select>
				<input type="text" id="keyword" name="keyword" placeholder="검색어 입력">
			</td>
		</tr>
	</table>
	<div id="resultArea"></div>
</body>
</html>











