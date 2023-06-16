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
		// URL 로 전달받은 영화코드(movieCd) 가져오기
		let movieCd = ${param.movieCd};
// 		alert(movieCd);
		
		$.ajax({
			type: "GET",
			url: "http://www.kobis.or.kr/kobisopenapi/webservice/rest/movie/searchMovieInfo.json?"
					+ "key=f5eef3421c602c6cb7ea224104795888&movieCd=" + movieCd,
			dataType: "json", // 응답 데이터가 JSON 객체로 전달되도록 "json" 타입 지정
			success: function(data) { // 요청 성공 시
				// 영화명(국문 - movieNm, 영문 - movieNmEn)
				// 개봉일(openDt)
				// 상영시간(showTm)
				// 감독(directors 배열 내의 peopleNm) => 복수개의 감독 존재할 수 있음
				// 배우(actors 배열 내의 peopleNm) => 복수개의 배우 존재할 수 있음
				let movieInfo = data.movieInfoResult.movieInfo;
				
				$("#movieNm").html(movieInfo.movieNm + "<br>(" + movieInfo.movieNmEn + ")");
				$("#openDt").html(movieInfo.openDt);
				$("#showTm").html(movieInfo.showTm + " 분");
				
				// 감독이 복수개의 객체일 수 있으므로 배열에 접근할 반복문 필요
				// 감독 여러명의 이름(peopleNm)을 저장할 변수 선언
				let directorNames = "";
				for(let i = 0; i < movieInfo.directors.length; i++) {
					// 일반 감독명만 문자열 결합을 수행한 후
					directorNames += movieInfo.directors[i].peopleNm;
					
					// 현재 인덱스가 배열크기-1 보다 작을 경우에만 ", " 문자열을 추가
					if(i < movieInfo.directors.length - 1) {
						directorNames += ", ";
					}
				}

				$("#directors").html(directorNames);
				
				// 배우가 복수개의 객체일 수 있으므로 배열에 접근할 반복문 필요
				// 배우 여러명의 이름(peopleNm)을 저장할 변수 선언
				let actorNames = "";
				for(let actor of movieInfo.actors) {
					// 일단 배우명과 구분자(", ")를 결합한 후
					actorNames += actor.peopleNm + ", ";
				}

				// 반복문이 끝난 다음 마지막 구분자(", ")를 제거(구분자를 제외한 나머지만 추출)
				// => 시작 인덱스는 0, 끝 인덱스는 문자열 길이 - 2 지정(끝인덱스 -1 까지 추출)
				actorNames = actorNames.substr(0, actorNames.length - 2);
				
				$("#actors").html(actorNames);
				
			},
			error: function() { // 요청 실패 시
				$("#resultArea").html("<h1>요청 실패!</h1>");
			}
		});
	});
</script>
</head>
<body>
	<h1>test7_json_movie_detail.jsp - 영화 상세정보</h1>
	<hr>
	<div id="resultArea">
		<table border="1">
			<tr>
				<th>영화명</th>
				<td id="movieNm" width="400"></td>
			</tr>				
			<tr>
				<th>개봉일</th>
				<td id="openDt"></td>
			</tr>				
			<tr>
				<th>상영시간</th>
				<td id="showTm"></td>
			</tr>				
			<tr>
				<th>감독</th>
				<td id="directors"></td>
			</tr>				
			<tr>
				<th>출연진</th>
				<td id="actors"></td>
			</tr>				
		</table>
	</div>
</body>
</html>














