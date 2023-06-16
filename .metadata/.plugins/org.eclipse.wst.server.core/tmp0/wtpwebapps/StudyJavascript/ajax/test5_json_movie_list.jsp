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
			/*
			영화진흥위원회 오픈API 를 활용하여 영화 정보 JSON 데이터 처리
			https://www.kobis.or.kr/kobisopenapi/homepg/main/main.do
			-------------------------------------------------------------
			일별 박스오피스 목록 조회 후 테이블에 표시
			https://www.kobis.or.kr/kobisopenapi/homepg/apiservice/searchServiceInfo.do?serviceId=searchDailyBoxOffice
			=> 지정된 요청 파라미터 형식에 맞게 URL 을 수정해야함
			
			샘플 API 요청 주소(단, 대상 조회일자(targetDt)는 어제(2023년 4월 25일로 변경))
			http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20230425
			*/
			$.ajax({
				type: "GET",
				url: "http://kobis.or.kr/kobisopenapi/webservice/rest/boxoffice/searchDailyBoxOfficeList.json?key=f5eef3421c602c6cb7ea224104795888&targetDt=20230425",
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

					// 4. 추출된 박스오피스 목록(배열)을 반복문을 통해 차례대로 접근하여
					//    순위(rank), 제목(movieNm), 개봉일(openDt), 누적관객수(audiAcc) 추출 후 출력
					for(let movie of dailyBoxOfficeList) {
						$("#resultArea > table").append(
							"<tr>"
							+ "<td>" + movie.rank + "</td>"
							+ "<td>" + movie.movieNm + "</td>"
							+ "<td>" + movie.openDt + "</td>"
							+ "<td>" + movie.audiAcc + "</td>"
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
	<h1>test5_json_movie_list.jsp - 일별 박스오피스</h1>
	<input type="button" value="일별 박스오피스 조회" id="btnOk">
	<div id="resultArea">
		<table border="1">
			<tr>
				<th width="80">현재순위</th>
				<th width="400">영화명</th>
				<th width="150">개봉일</th>
				<th width="100">누적관객수</th>
			</tr>
		</table>
	</div>
</body>
</html>














