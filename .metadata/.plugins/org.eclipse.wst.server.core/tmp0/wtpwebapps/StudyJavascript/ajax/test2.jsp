<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- css/main.css 파일 불러오기 -->
<link href="css/inc.css" rel="stylesheet" type="text/css">
<link href="css/subpage.css" rel="stylesheet" type="text/css">
<script src="js/jquery-3.6.4.js"></script>
<script type="text/javascript">
	$(function() {
		// 중복확인 버튼 클릭됐을 때의 이벤트 처리		
		$("#btnCheckId").on("click", function() {
			// 새 창에 test2_check_id.jsp 페이지 열기(단, 서블릿 주소로 요청)
			window.open("MemberCheckDupIdForm.me", "check", "width=400, height=300");
		});
		
		// ==========================================================================
		// 아이디 입력란에서 포커스가 해제될 때(커서가 빠질 때)의 이벤트 처리
		$("#id").on("blur", function() {
			// 입력된 아이디가 널스트링이면 "checkIdResult" 영역에
			// "아이디는 필수 입력 항목입니다"(빨간색) 출력 후 함수 처리 종료(return)
			if($("#id").val() == "") {
				$("#checkIdResult").html("아이디는 필수 입력 항목입니다").css("color", "red");
				return; // 함수 처리 종료
			}
			
			// AJAX 를 활용하여 "MemberCheckDupIdPro2.me" 서블릿 요청을 통해
			// 아이디 중복 검사 작업 수행 후 결과값을 리턴받아 처리
			// => 전달할 파라미터 : 아이디
			$.ajax({
				url: "MemberCheckDupIdPro2.me", // MemberCheckDupIdProAction2 매핑
				data: {
					id: $("#id").val()
				},
				success: function(result) { // 성공 시에만 작업 처리
// 					alert(result + " : " + typeof(result));
					// 처리 페이지(비즈니스 로직)에서 처리 성공 후 "true" or "false" 값 리턴
					// 리턴받은 결과값에 대해 "true" 또는 "false" 판별
					if(result == "true") {
						// checkIdResult 영역에 "이미 사용중인 아이디"(빨간색) 출력
						$("#checkIdResult").html("이미 사용중인 아이디").css("color", "red");
					} else if(result == "false") {
						// checkIdResult 영역에 "사용 가능한 아이디"(파란색) 출력
						$("#checkIdResult").html("사용 가능한 아이디").css("color", "blue");
					}
				}
			});
		});
		
	});
</script>
</head>
<body>
	<header>
		<%-- inc/top.jsp 페이지 삽입(jsp:include 액션태그 사용 시 / 경로는 webapp 가리킴) --%>
		<jsp:include page="/inc/top.jsp"></jsp:include>
	</header>
	<article id="joinForm">
		<h1>회원 가입</h1>
		<form action="MemberJoinPro.me" method="post" name="joinForm">
			<table border="1">
				<tr>
					<th class="td_left">이름</th>
					<td class="td_right"><input type="text" name="name" required="required"></td>
				</tr>
				<tr>
					<th class="td_left">ID</th>
					<td class="td_right">
						<input type="text" name="id" id="id" placeholder="4 ~ 8글자 사이 입력" required="required">
						<input type="button" value="중복확인(새창)" id="btnCheckId">
						<div id="checkIdResult"></div>
					</td>
				</tr>
				<tr>
					<th class="td_left">비밀번호</th>
					<td class="td_right">
						<input type="text" name="passwd" placeholder="8 ~ 16글자 사이 입력" required="required">
						<span id="checkPasswdResult"></span>
					</td>
				</tr>
				<tr>
					<th class="td_left">비밀번호확인</th>
					<td class="td_right">
						<input type="password" name="passwd2" onchange="checkConfirmPasswd(this.value)" required="required">
						<span id="checkPasswd2Result"></span>
					</td>
				</tr>
				<tr>
					<th class="td_left">E-Mail</th>
					<td class="td_right">
						<input type="text" name="email1" class="email" required="required">@<input type="text" name="email2" class="email" required="required">
						<select id="emailDomain" onchange="selectDomain(this.value)">
							<option value="">직접입력</option>
							<option value="naver.com">naver.com</option>
							<option value="nate.com">nate.com</option>
							<option value="gmail.com">gmail.com</option>
						</select>
					</td>
				</tr>
				<tr>
					<th class="td_left">성별</th>
					<td class="td_right">
						<input type="radio" name="gender" value="남">남
						<input type="radio" name="gender" value="여">여
					</td>
				</tr>
				<tr>
					<td colspan="2" id="btnArea">
						<input type="submit" value="가입">
						<input type="reset" value="초기화">
						<input type="button" value="돌아가기">
					</td>
				</tr>
			</table>
		</form>
	</article>
</body>
</html>













