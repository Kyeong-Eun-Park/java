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
	form 객체의 submit() 메서드
	- form 태그를 사용한 요소의 submit 동작에 대한 이벤트 처리 담당
	- 자바스크립트에서의 기본적인 처리 방법과 동일(onsubmit 을 통한 처리)
	*/
	$(function() {
		// form 태그 요소에 submit 동작 발생 시 이벤트 처리할 경우
		$("form").submit(function() {
// 			alert("submit");

			// 셀렉트박스(id="selectBox")의 자식 요소(option 태그)들 중
			// 첫번째 option 태그의 "selected" 속성값 출력
// 			alert($("#selectBox > option").eq(0).prop("selected"));
			
			// 만약, 첫번째 option 태그의 selected 속성 상태가 true 일 경우
			// "과목 선택 필수!" 출력 후 폼 전송 작업을 취소(return false)하고
			// 아니면 폼 전송 작업 수행(return true = 기본값)
			if($("#selectBox > option").eq(0).prop("selected")) { // true 일 경우
				alert("과목 선택 필수!");
				
				// 셀렉트박스 지정하여 focus() 메서드 호출 시 해당 요소에 포커스 요청(<-> blur())
				$("#selectBox").focus();
					
				return false; // 폼 전송 작업 취소
			}
			
// 			return true; // 폼 전송 수행. 생략 가능.
		});
	});
</script>
</head>
<body>
	<h1>jQuery - test7.jsp</h1>
	<form action="test7_result.jsp">
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
		<input type="submit" value="전송">
	</form>
</body>
</html>













