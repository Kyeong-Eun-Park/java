<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	var isDuplicateId = true; // 아이디 중복 여부를 저장할 변수 선언(true : 중복, false : 중복아님)
	var isSamePassword = false; // 패스워드 일치 여부를 저장할 변수(true : 일치, false : 불일치)
	var isCorrectPassword = false; // 패스워드 사용 가능 여부(true : 가능, false : 불가능)
	
	// 아이디 중복체크
	function checkDuplicateId() {
		// ID 입력란에 입력된 아이디 가져오기
		let id = document.joinForm.id.value;
		
		// -----------------------------------------------------------------------
		// 임시) 아이디 중복 체크를 위한 새 창 열기(check_id.jsp)
// 		window.open("check_id.jsp", "", "width=400, height=200");
		// -----------------------------------------------------------------------
	
		// ------------------------ 숙제1 ---------------------------
		// 입력받은 아이디가 정규표현식과 일치할 경우 
		// checkIdResult 위치에 "적합한 아이디" 출력하고, 아니면 "아이디 규칙 확인 필수!" 출력
		// => 영문자(대소문자), 숫자를 조합하여 4 ~ 8자리(단, 첫글자는 숫자 사용 불가)
		let idRegex = /^[A-Za-z][A-Za-z0-9]{3,7}$/; 
		
		if(idRegex.exec(id)) {
			// 버튼 우측 span 영역에 중복확인완료 표시
			document.getElementById("checkIdResult").innerHTML = "적합한 아이디";
			document.joinForm.id.style.background = "white";
		} else {
			alert("아이디 규칙 확인 필수!");
			
			// 만약, 중복체크 과정에서 중복이 발생했다고 가정(또는 아이디가 사용 불가능하다고 가정)
			// => 중복확인완료 표시를 제거하기 위해 isDuplicate 변수를 true 로 변경
			document.getElementById("checkIdResult").innerHTML = "";
			
			document.joinForm.id.select(); // 아이디 입력창 커서 요청 및 입력 항목 선택
			document.joinForm.id.style.background = "pink";
		}
	}
	
	/*
	---------------------------- 숙제2 ----------------------------
	2. 비밀번호 입력란에 키를 누를때마다 비밀번호 규칙 체크하기
	=> 체크 결과를 비밀번호 입력창 우측 빈공간에 표시하기
	=> 영문자, 숫자, 특수문자(!@#$) 8 ~ 16글자 사이이면 "사용 가능한 패스워드"(파란색) 표시,
	   아니면, "사용 불가능한 패스워드"(빨간색) 표시
	*/
	function checkPasswd(passwd) { // 함수 호출될 때 입력된 패스워드 전달받기(this.value)
		let span_checkPasswdResult = document.getElementById("checkPasswdResult");
	
		// 메세지 출력 문장의 중복을 제거하기 위해 메세지와 색상명을 저장할 변수 선언
		let msg = "";
		let color = "";
		
		// 패스워드가 변경될 때 패스워드 확인 동작도 함께 수행하기 위해
		// checkConfirmPassword() 함수를 이 위치에서 호출
		checkConfirmPasswd(document.joinForm.passwd2.value);
		
		let passwdRegex = /^[A-Za-z0-9!@#$]{8,16}$/;
		
		// 패스워드 복잡도 검사를 수행하려면 각 규칙을 별도로 지정한 후 부분 검사를 수행해야한다.
		// 또한, 부분 검사 수행 결과를 포인트화 하여 일정 점수 이상만 사용 가능하도록 처리
		// 1) 영문자 대문자 포함 시 +1점
		// 2) 영문자 소문자 포함 시 +1점
		// 3) 숫자 포함 시 +1점
		// 4) 특수문자(!@#$) 포함 시 +1점
		// => 최소 2가지 이상 조합되도록 체크
		let upperCaseRegex = /[A-Z]/; // 영문 대문자
		let lowerCaseRegex = /[a-z]/; // 영문 소문자
		let numRegex = /[0-9]/; // 숫자
		let specRegex = /[!@#$]/; // 특수문자
		
		// 입력된 패스워드 길이 체크
		if(passwdRegex.exec(passwd)) { // 사용 가능
			// 패스워드 전체 규칙을 통과했을 경우 복잡도 검사 수행
			// => 각 규칙에 해당하는 문자가 포함될 때마다 점수를 1점씩 가산
			let score = 0; // 점수를 누적(카운팅)할 변수
			
			score += upperCaseRegex.exec(passwd) ? 1 : 0;
			score += lowerCaseRegex.exec(passwd) ? 1 : 0;
			score += numRegex.exec(passwd) ? 1 : 0;
			score += specRegex.exec(passwd) ? 1 : 0;
// 			console.log(score);
			
			// 복잡도 검사 결과 판별하여 출력
			// => 만약, 1점 이하일 경우 "사용 불가능한 패스워드",
			//    2점이면 "패스워드 : 위험", 
			//    3점이면 "패스워드 : 보통", 
			//    4점이면 "패스워드 : 안전"
			switch(score) {
				case 4 :  
					msg = "패스워드 : 안전";
					color = "BLUE";
					break;
				case 3 : 
					msg = "패스워드 : 보통";
					color = "GREEN";
					break;
				case 2 : 
					msg = "패스워드 : 위험";
					color = "ORANGE";
					break;
				default : 
					msg = "영문 대문자, 소문자, 숫자, 특수문자 2가지 이상 조합 필수!";
					color = "RED";
			}
		} else { // 사용 불가능
			msg = "사용 불가능한 패스워드";
			color = "RED";
		}
		
		// 모든 판별이 끝난 후 결과값을 적용(코드 중복 제거)
		span_checkPasswdResult.innerHTML = msg;
		span_checkPasswdResult.style.color = color;
		
	}
	
	/*
	3. 비밀번호확인 입력란에 키를 누를때마다 비밀번호와 같은지 체크하기
	=> 체크 결과를 비밀번호확인 입력창 우측 빈공간에 표시하기
	=> 비밀번호와 비밀번호확인 입력 내용이 같으면 "비밀번호 일치"(파란색) 표시,
	   아니면, "비밀번호 불일치"(빨간색) 표시
	*/
	function checkConfirmPasswd(passwd2) { // 함수 호출될 때 입력된 패스워드 전달받기
		let span_checkPasswd2Result = document.getElementById("checkPasswd2Result");
		
		// 입력된 패스워드 일치 여부 체크
		if(passwd2 == document.joinForm.passwd.value) { // 두 패스워드 일치
			span_checkPasswd2Result.innerHTML = "비밀번호 일치";
			span_checkPasswd2Result.style.color = "BLUE";
			
			// 비밀번호 일치 표시를 위해 isSamePassword 변수값을 true 로 변경
			isSamePassword = true;
		} else { // 패스워드 불일치
			span_checkPasswd2Result.innerHTML = "비밀번호 불일치";
			span_checkPasswd2Result.style.color = "RED";
			
			// 비밀번호 불일치 표시를 위해 isSamePassword 변수값을 false 로 변경
			isSamePassword = false;
		}
	}
	
	// 주민번호 앞자리 6자리 입력되면 뒷자리로 커서 요청
	function checkJumin1(jumin1) { // checkJumin1(this.value)
		if(jumin1.length == 6) {
			document.joinForm.jumin2.focus(); // 커서 요청(포커스 요청)
		}
	}
	
	// 주민번호 뒷자리 7자리 입력되면 커서 해제
	function checkJumin2(jumin2) {
		if(jumin2.length == 7) {
			document.joinForm.jumin2.blur(); // 커서 제거(포커스 해제)
		}
	}
	
	// 도메인 셀렉트박스 처리
	function selectDomain(domain) {
		document.joinForm.email2.value = domain;
		
		// 만약, 직접입력 항목 선택 시("" 입력 시) 입력 항목 포커스 요청 및 읽기 전용 해제
		// 아니면, 입력 항목 읽기 전용 설정
		if(domain == "") {
			document.joinForm.email2.focus();
			document.joinForm.email2.readOnly = false; // 주의! readonly 속성 readOnly 로 표기
			document.joinForm.email2.style.backgroundColor = "white"; // 배경색 변경
		} else {
			document.joinForm.email2.readOnly = true;
			document.joinForm.email2.style.backgroundColor = "lightgray";
		}
	}
	
	// 체크박스 전체 선택 기능
	function checkAll(isChecked) { // this.checked 값 전달을 통해 체크 상태 받아오기
		if(isChecked) { // true(체크)
			document.joinForm.hobby[0].checked = true;
			document.joinForm.hobby[1].checked = true;
			document.joinForm.hobby[2].checked = true;
		} else { // false(체크 해제)
			document.joinForm.hobby[0].checked = false;
			document.joinForm.hobby[1].checked = false;
			document.joinForm.hobby[2].checked = false;
		}
	}
	
	// submit 버튼 클릭 시 필수 조건들이 만족할 경우에만 다음 페이지로 이동하기
	function checkForm(fr) { // 함수 파라미터로 폼 객체 전달받기(document.joinForm = fr)
		// 각 조건이 만족하지 않을 때마다 false 리턴, 모두 만족하면 true 리턴
		if(isDuplicateId) { // isDuplicateId == true (아이디 중복)
			alert("아이디 4 ~ 8자리 필수!");
			fr.id.select();
			return false;
		} else if(!isCorrectPassword) { // isCorrectPassword == false (불가능한 패스워드)
			alert("패스워드 8 ~ 16자리 필수!");
			fr.passwd.select();
			return false;
		} else if(!isSamePassword) { // isSamePassword == false (패스워드 불일치)
			alert("패스워드가 일치하지 않습니다!");
			fr.passwd2.select();
			return false;
		} else if(fr.jumin1.value.length != 6) {
			alert("주민번호 앞자리 6자리 필수!");
			fr.jumin1.select();
			return false;
		} else if(fr.jumin2.value.length != 7) {
			alert("주민번호 뒷자리 7자리 필수!");
			fr.jumin2.select();
			return false;
		} else if(fr.job.value == "") {
			alert("직업 선택 필수!");
			fr.job.focus();
			return false;
		} else if(fr.gender.value.length == 0) { 
			// 성별은 둘 중 하나만 전달되므로 길이 체크 가능
			alert("성별 선택 필수!");
			return false;
		} else if(!fr.hobby[0].checked && !fr.hobby[1].checked && !fr.hobby[2].checked) {
			// 체크박스는 배열 형태로 접근하며 checked 속성값이 true 면 체크, false 면 미체크
			// => 따라서, 3개의 항목이 모두 false 이면 체크 요청
			alert("취미 하나 이상 선택 필수!");
			return false;
		}
	
		// 위의 모든 조건을 만족하지 않을 때(= 입력이 모두 정상) submit 동작 수행(= true 리턴)
		return true;
	}
</script>
</head>
<body>
	<h1>회원가입</h1>
	<form action="requestPro3.jsp" name="joinForm" method="post" onsubmit="return checkForm(this)">
		<table border="1">
			<tr>
				<th>이름</th>
				<td><input type="text" name="name" required="required"></td>
			</tr>
			<tr>
				<th>ID</th>
				<td>
					<input type="text" name="id" placeholder="4 ~ 8글자 사이 입력" onchange="checkDuplicateId()" required="required">
					<span id="checkIdResult"></span>
				</td>
			</tr>
			<tr>
				<th>비밀번호</th>
				<td>
					<input type="text" name="passwd" placeholder="8 ~ 16글자 사이 입력" onchange="checkPasswd(this.value)" required="required">
					<span id="checkPasswdResult"></span>
				</td>
			</tr>
			<tr>
				<th>비밀번호확인</th>
				<td>
					<input type="password" name="passwd2" onchange="checkConfirmPasswd(this.value)" required="required">
					<span id="checkPasswd2Result"></span>
				</td>
			</tr>
			<tr>
				<th>주민번호</th>
				<td>
					<%-- 입력 항목에 maxLength 속성 지정 시 최대 길이 지정 가능 --%>
					<input type="text" name="jumin1" onkeyup="checkJumin1(this.value)" maxlength="6" required="required"> - 
					<input type="text" name="jumin2" onkeyup="checkJumin2(this.value)" maxlength="7" required="required">
				</td>
			</tr>
			<tr>
				<th>E-Mail</th>
				<td>
					<input type="text" name="email1" required="required">@<input type="text" name="email2" required="required">
					<select id="emailDomain" onchange="selectDomain(this.value)">
						<option value="">직접입력</option>
						<option value="naver.com">naver.com</option>
						<option value="nate.com">nate.com</option>
						<option value="gmail.com">gmail.com</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>직업</th>
				<td>
					<select name="job">
						<option value="">항목을 선택하세요</option>
						<option value="개발자">개발자</option>
						<option value="DB엔지니어">DB엔지니어</option>
						<option value="아르바이트">아르바이트</option>
					</select>
				</td>
			</tr>
			<tr>
				<th>성별</th>
				<td>
					<input type="radio" name="gender" value="남">남
					<input type="radio" name="gender" value="여">여
				</td>
			</tr>
			<tr>
				<th>취미</th>
				<td>
					<input type="checkbox" name="hobby" value="여행">여행
					<input type="checkbox" name="hobby" value="독서">독서
					<input type="checkbox" name="hobby" value="게임">게임
					<input type="checkbox" id="check_all" onclick="checkAll(this.checked)">전체선택
				</td>
			</tr>
			<tr>
				<th>가입동기</th>
				<td>
					<textarea rows="10" cols="60" name="reason" required="required"></textarea>
				</td>
			</tr>
			<tr>
				<td colspan="2" align="center">
					<input type="submit" value="가입">
					<input type="reset" value="초기화">
					<input type="button" value="돌아가기">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>