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
		$("#btnOk").on("click", function() {
			// 캘린더에서 입력(선택)한 날짜 가져오기
			// 단, 날짜를 선택하지 않은 경우 "날짜 선택 필수!" 출력 후 캘린더에 포커스 요청
			let selectedDate = $("#date").val();
// 			alert("선택된 날짜 : " + selectedDate);
			
			if(selectedDate == "") {
				alert("날짜 선택 필수!");
				$("#date").focus();
				return; // 다음 작업이 진행되지 않도록 함수 종료
			}
			
			// 전달받은 날짜 형식 : yyyy-MM-dd
			// 파라미터로 전달할 날짜 형식 : yyyyMMdd
			// 따라서, 조회 대상 일자에 맞는 날짜 형식으로 포맷 변환 필요('-' 기호 제거)
			// 1) split() 함수를 통해 기준 문자열 "-" 를 기준으로 문자열 분리
// 			let splitDate = selectedDate.split("-");
// 			let targetDt = splitDate[0] + splitDate[1] + splitDate[2];
// 			alert(targetDt); // 20230425	
			
			// 2) replace() 함수를 통해 "-" 기호를 널스트링("") 으로 치환
// 			let targetDt = selectedDate.replace("-", "");
			// => 처음 만나는 대상 문자열만 치환됨
// 			alert(targetDt); // 2023-04-25 중 첫번째 "-" 기호만 제거되어 202304-25 출력됨	
			
			// 자바에서는 replaceAll() 메서드가 제공되어 전체를 대상으로 치환이 가능하지만
			// 자바스크립트에서는 replaceAll() 함수가 제공되지 않는다!
			// 따라서, 정규표현식의 플래그를 활용하여 모든 문자열을 대상으로 탐색 필요
			// 참고) 정규표현식 플래그 종류
			//       1) /g(global) : 대상 문자열 내에서 패턴에 해당되는 모든 대상 검색
			//       2) /i(ignore case) : 대상 문자열을 대소문자 무시하고 검색
			//       3) /m(multi line) : 대상 문자열이 복수개의 라인일 경우 전체 라인에 걸쳐 검색
			// => 자바스크립트에서 플래그 사용법 : /패턴문자열/플래그 또는 new RegExp("패턴문자열", "플래그")
			// => 만약, 복수개의 라인을 대상으로 각 라인별 전체 패턴 검색 시 /g/m 지정
			//    (만약, /m 만 지정 시 각 라인에서 해당되는 첫 번째 대상만 검색)
			// => replace(패턴문자열, "치환할문자열") 형태로 정규표현식 조합 가능
			let targetDt = selectedDate.replace(/-/g, ""); // - 문자열을 모두 "" 으로 치환
// 			alert(targetDt); // 20230425
			// =================================================================
			// 박스오피스 조회 시 조회 대상 일자(targetDt)는 선택된 날짜 사용
			$.ajax({
				type: "GET",
				url: "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?"
						+ "key=f5eef3421c602c6cb7ea224104795888&targetDt=" + targetDt,
				dataType: "json", // 응답 데이터가 JSON 객체로 전달되도록 "json" 타입 지정
				success: function(data) { // 요청 성공 시
					// 임시) #resultArea 영역에 응답 데이터 출력(문자열로 변환 필요)
// 					$("#resultArea").html(JSON.stringify(data));		
					// ----------------------------------------------------------------------
					// 응답 데이터(박스오피스 목록) 객체(data)로부터 박스오피스 정보 추출하기
					// => 전체 데이터가 하나의 객체({})로 묶여 있음
					// 1. 박스오피스 전체 데이터가 저장된 "boxOfficeResult" 객체 추출
					let boxOfficeResult = data.boxOfficeResult;
// 					$("#resultArea").html(JSON.stringify(boxOfficeResult));		

					// 2. 박스오피스 타입(boxofficeType)과 조회날짜(showRange) 추출
					// => 1번에서 추출한 boxOfficeResult 객체를 통해 접근
					let boxOfficeType = boxOfficeResult.boxofficeType;
					let showRange = boxOfficeResult.showRange;
// 					$("#resultArea").html(JSON.stringify(boxOfficeType + ", " + showRange));
					// 두 데이터는 객체가 아니므로 별도의 변환 없이도 사용 가능
// 					$("#resultArea").html(boxOfficeType + ", " + showRange);	
					
					// 3. 일별 박스오피스 목록(dailyBoxOfficeList) 추출
					// => 복수개의 영화정보 객체{}가 dailyBoxOfficeList 배열[] 로 관리됨
					// => 단, 배열 내의 데이터가 객체이므로 출력 시 변환 필요함
					let dailyBoxOfficeList = boxOfficeResult.dailyBoxOfficeList;
// 					$("#resultArea").html(JSON.stringify(dailyBoxOfficeList));	

					// 데이터를 출력할 테이블 생성
					$("#resultArea").html(
						"<table border='1'>"
							+ "<tr>"
								+ "<th width='80'>현재순위</th>"
								+ "<th width='400'>영화명</th>"
								+ "<th width='150'>개봉일</th>"
								+ "<th width='100'>누적관객수</th>"
								+ "<th></th>"
							+ "</tr>"
						+ "</table>"		
					);
					
					// 4. 추출된 박스오피스 목록(배열)을 반복문을 통해 차례대로 접근하여
					//    순위(rank), 제목(movieNm), 개봉일(openDt), 누적관객수(audiAcc) 추출 후 출력
					// => 상세정보 버튼 추가
					//    test7_json_movie_detail.jsp 요청 -> 파라미터 : 영화코드(movieCd)
					
					for(let movie of dailyBoxOfficeList) {
						let url = "location.href='test7_json_movie_detail.jsp?movieCd=" + movie.movieCd + "'";
						$("#resultArea > table").append(
							"<tr>"
							+ "<td>" + movie.rank + "</td>"
							+ "<td>" + movie.movieNm + "</td>"
							+ "<td>" + movie.openDt + "</td>"
							+ "<td>" + movie.audiAcc + "</td>"
							+ "<td><button onclick=" + url + ">상세정보</button></td>"
							+ "</tr>"
						);
					}
					
				},
				error: function() { // 요청 실패 시
					$("#resultArea").html("<h1>요청 실패!</h1>");
				}
			});
		});
	});
</script>
</head>
<body>
	<h1>test6_json_movie_list.jsp - 일별 박스오피스</h1>
	<input type="date" id="date">
	<input type="button" value="일별 박스오피스 조회" id="btnOk">
	<hr>
	<div id="resultArea"></div>
</body>
</html>














