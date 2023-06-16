<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="js/jquery-3.6.4.js"></script>
<script type="text/javascript">
	$(function() {
		// 파라미터로 전달받은 id, isDuplicate 값 가져와서 변수에 저장
		// => EL 표기법을 통해 파라미터에 접근 후 해당 값을 자바스크립트 변수에 저장
		// => 만약, 파라미터가 존재하지 않으면 널스트링("")값 저장됨
		let id = "${param.id}"; // string 타입으로 저장
		let isDuplicate = "${param.isDuplicate}"; // string 타입으로 저장
// 		alert(id + " : " + typeof(id) + "\n" + isDuplicate + " : " + typeof(isDuplicate));
		
		// id 파라미터와 isDuplicate 파라미터가 존재할 경우
		if(id != "" && isDuplicate != "") {
			// 아이디 입력창에 현재 아이디값을 표시
			$("#id").val(id);
			
			// isDuplicate 값을 문자열 그대로 활용하여 if문으로 판별
			// => "true" 일 경우 resultArea 영역에 "이미 사용중인 아이디" 텍스트 출력(빨간색)하고
			//    아니면, "사용 가능한 아이디" 텍스트(파란색) 출력
			// => 주의! 다른 데이터를 boolean 타입으로 변환 시 데이터가 존재하면 무조건 true
			//    따라서, "true" 와 "false" 문자열은 무조건 true 로 변환되어 판별이 불가능
			if(isDuplicate == "true") { // 문자열 상태로 그대로 판별
				$("#resultArea").html("이미 사용중인 아이디");
				$("#resultArea").css("color", "red");
				
				// 아이디 사용 버튼을 숨김 처리 = hide() 메서드 사용
				$("#btnUseId").hide();
				
				// 자바스크립트에서 버튼을 생성할 수도 있고, 숨길 수도 있다!
				// => resultArea 영역 바깥쪽의 뒷부분에 추가된 버튼 삭제하기(remove() 메서드 활용)
				$("#btnUseId").remove();
			} else {
				$("#resultArea").html("사용 가능한 아이디");
				$("#resultArea").css("color", "blue");
				
				// 아이디 사용 버튼을 숨김 해제 처리 = show() 메서드 사용
				$("#btnUseId").show();
				
				// 자바스크립트에서 버튼을 생성할 수도 있고, 숨길 수도 있다!
				// => resultArea 영역 바깥쪽의 뒷부분에 버튼 추가하기(after() 메서드 활용)
				$("#resultArea").after('<input type="button" value="아이디 사용2" id="btnUseId2">');
			}
		}
		
		// id 선택자가 btnUseId 인 버튼이 클릭되면 이벤트 처리
		$("#btnUseId").on("click", function() {
			// 부모창의 아이디 입력란에 중복 확인이 완료된 아이디를 표시
// 			opener.document.querySelector("#id").value = document.querySelector("#id").value;
			
			// jQuery 문법을 사용하여 부모창 아이디 입력란에 아이디 표시하기
			// 1) $("선택자", opener.document).val(아이디);
// 			$("#id", opener.document).val($("#id").val());
			// 2) $(opener.document).find("선택자").val(아이디);
			$(opener.document).find("#id").val($("#id").val());
			
			// 현재 아이디 중복 확인창(자식창) 닫기
			window.close();
		});
		
	});
</script>
</head>
<body>
	<h3>아이디 중복 체크</h3>
	<form action="MemberCheckDupIdPro.me" method="get">
		아이디 <input type="text" name="id" id="id" required="required"><br>
		<input type="submit" value="중복확인">
	</form>
	<div id="resultArea"></div>
	<input type="button" value="아이디 사용" id="btnUseId" style="display: none;">
</body>
</html>









