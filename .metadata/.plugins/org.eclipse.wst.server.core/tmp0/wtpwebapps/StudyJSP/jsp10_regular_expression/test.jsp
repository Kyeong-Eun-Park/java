<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
	function checkName() {
// 		let name = document.fr.name.value;
		let name = document.querySelector("#name").value;
// 		alert(name);

		// 정규표현식에 사용된 패턴 문자열을 통해 생성한 정규표현식 객체를 변수 regex 에 저장
		// => 패턴 규칙 : 한글 2글자 ~ 5글자
		let regex = /^[가-힣]{2,5}$/;
		
		// 정규표현식에 따른 유효성 검사를 위해 if 문을 사용하여 이름 유효성 판별
		if(regex.exec(name)) {
// 			alert(name + " : 사용 가능한 이름!");
			document.querySelector("#nameResult").innerHTML = "사용 가능한 이름!";
			document.querySelector("#nameResult").style.color = "green";
		} else {
// 			alert(name + " : 사용 불가능한 이름!");
			document.querySelector("#nameResult").innerHTML = "사용 불가능한 이름!";
			document.querySelector("#nameResult").style.color = "red";
		}
	}
	
	function checkPhone(phone) {
		// 입력받은 번호가 전화번호 형식과 일치하는지 판별
		// 1. 앞자리 번호 010 또는 011
		// 2. 각 자리 번호 사이에 공백 또는 하이픈(-) 사용
		// 3. 가운데 번호 3자리 ~ 4자리
		// 4. 끝자리 번호 4자리
		let regex = /^(010|011)[-\s]?[\d]{3,4}[-\s]?[\d]{4}$/;
		if(!regex.exec(phone)) {
			document.querySelector("#phoneResult").innerHTML = "사용 불가능한 전화번호!";
			document.querySelector("#phoneResult").style.color = "red";
			document.querySelector("#phone").select();
		} else {
			document.querySelector("#phoneResult").innerHTML = "사용 가능한 전화번호";
			document.querySelector("#phoneResult").style.color = "green";
			
			// ==========================================================================
			// 만약, 전화번호 양식이 일치할 때
			// 입력된 전화번호에서 숫자가 아닌 나머지 문자는 모두 제거하기(공백 또는 -)
			// 1. 숫자가 아닌 데이터를 지정하는 정규표현식 패턴 작성
			let regexNaN = /\D/g;
			// => 주의! /\D/ 지정 시 일치하는 대상 1개에 대한 검사 수행(복수개는 검사 못함)
			//    따라서, 플래그 자리에 g 를 사용하여 전역 검사 수행(g = global)
			
			// 2. 대상 문자열 객체의 replace() 메서드를 호출하여 
			//    패턴과 일치하는 문자열을 지정한 문자열로 치환
			//    => 파라미터 : 정규표현식 패턴, 치환할 문자열
			document.querySelector("#phone").value = phone.replace(regexNaN, "");
			
		}
	}
	
	function checkPhone1(phone1) {
		// 입력받은 번호가 숫자 3자리 ~ 4자리인지 판별
		// => 아닐 경우 alert() 함수를 통해 "전화번호 확인 필수!" 출력 후
		//    해당 입력창 입력 항목 선택(포커스)
		let regex = /^[\d]{3,4}$/;
		if(!regex.exec(phone1)) {
			alert("전화번호 확인 필수!");
			document.querySelector("#phone1").select();
		}
	}
	
	function checkPhone2(phone2) {
		// 입력받은 번호가 숫자 4자리인지 판별
		// => 아닐 경우 alert() 함수를 통해 "전화번호 확인 필수!" 출력 후
		//    해당 입력창 입력 항목 선택(포커스)
		let regex = /^[\d]{4}$/;
		if(!regex.exec(phone2)) {
			alert("전화번호 확인 필수!");
			document.querySelector("#phone2").select();
		}
	}
	
	function copyNumber() {
		// phone0 셀렉트박스(010 or 011), phone1 과 phone2 텍스트박스 입력 항목을
		// xxx-xxxx-xxx 형식으로 문자열 결합하여 phone 텍스트박스에 출력
		let phone0 = document.querySelector("#phone0").value;
		let phone1 = document.querySelector("#phone1").value;
		let phone2 = document.querySelector("#phone2").value;
		
		document.querySelector("#phone").value = phone0 + "-" + phone1 + "-" + phone2;
	}
</script>
</head>
<body>
	<h1>test.jsp - 정규표현식</h1>
	<form action="test_result.jsp" name="fr">
		<table border="1">
			<tr>
				<td>이름</td>
				<td>
<!-- 					<input type="text" name="name" id="name"  -->
<!-- 							placeholder="한글2~5글자" onchange="checkName()"> -->
					<%-- input 태그에 pattern 속성을 활용하여 submit 동작 시 양식 체크도 가능 --%>
					<input type="text" name="name" id="name" 
							placeholder="한글2~5글자" required="required" pattern="^[가-힣]{2,5}$">
					<span id="nameResult"></span>		
				</td>
			</tr>
			<tr>
				<td>전화번호</td>
				<td>
					<select name="phone0" id="phone0">
						<option value="010">010</option>
						<option value="011">011</option>
					</select>
					<input type="text" name="phone1" id="phone1" onchange="checkPhone1(this.value)">
					<input type="text" name="phone2" id="phone2" onchange="checkPhone2(this.value)">
					<input type="button" value="전화번호 입력" onclick="copyNumber()">
					<hr>
					<input type="text" name="phone" id="phone" 
							placeholder="0x0-xxxx-xxxx" onchange="checkPhone(this.value)">
					<span id="phoneResult"></span>		
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" value="확인">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>










