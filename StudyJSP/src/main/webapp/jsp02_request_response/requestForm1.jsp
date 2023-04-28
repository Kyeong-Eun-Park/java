<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>requestForm1 - request 객체 예제</h1>
	<%--
	<form> 태그
	1) action 속성 : submit 동작 시 action 속성에 지정된 페이지로 이동 요청 수행
	                 이 때, 폼 태그 내의 파라미터(= 폼 파라미터)를 
	                 모두 request 객체에 저장하여 함께 전송
	                 ex) submit 버튼 클릭 시 requestPro1.jsp 페이지로 이동
	2) method 속성 
	   - GET 방식 : method="get" 또는 생략 또는 하이퍼링크 또는 URL 직접 입력 등으로 이동할 경우
	                (POST 방식 한 가지를 제외하면 거의 대부분 GET 방식)
	     => 전달되는 파라미터 모두 URL(주소) 뒤에 붙여서 전송
	        ex) http://localhost:8080/StudyJSP/jsp02_request/requestPro1.jsp?name=홍길동&age=20&gender=male&hobby=독서&hobby=게임\
         => 한글 등의 데이터 처리를 위해서는 문서의 문자 인코딩(= 캐릭터셋) 방식을 UTF-8 로 변경 필요
            (Window - Preferences - Web - JSP Files 메뉴 - Encoding 부분 UTF-8 로 변경)
            => 변경 후 JSP 파일 생성 시 <%@ page %> 부분에 pageEncoding="UTF-8" 등 추가되며
               <meta charset="UTF-8"> 도 추가됨
	   - POST 방식 : method="post" 를 지정할 경우
	     => 한글 처리를 위해서는 request 객체의 setCharacterEncoding() 메서드를 호출하여
	        "UTF-8" 문자열을 파라미터로 전달해야함
	--%>
<!-- 	<form action="requestPro1.jsp" method="get"> -->
	<form action="requestPro1.jsp" method="post">
		<table border="1">
			<tr>
				<td>이름</td>
				<td><input type="text" name="name" required="required"></td>
			</tr>
			<tr>
				<td>나이</td>
				<td><input type="text" name="age" required="required"></td>
			</tr>
			<tr>
				<td>성별</td>
				<td>
					<%-- 
					라디오버튼 또는 체크박스 등의 선택이 까다로운 요소들은
					label 태그의 for 속성값과 폼태그 요소의 id 속성값을 같게 지정 시
					정확하게 클릭하지 않아도 해당 항목 텍스트 클릭해도 선택됨 
					--%>
					<input type="radio" id="gender_male" name="gender" value="male"><label for="gender_male">남</label>
					<input type="radio" id="gender_female" name="gender" value="female"><label for="gender_female">여</label>
				</td>
			</tr>
			<tr>
				<td>취미</td>
				<td>
					<input type="checkbox" name="hobby" id="hobby_book" value="독서"><label for="hobby_book">독서</label>
					<input type="checkbox" name="hobby" id="hobby_game" value="게임"><label for="hobby_game">게임</label>
					<input type="checkbox" name="hobby" id="hobby_tv" value="TV시청"><label for="hobby_tv">TV시청</label>
				</td>
			</tr>
			<tr>
				<td colspan="2">
					<%-- 
					submit 버튼(전송) 생성
					=> 클릭 시 요청 페이지(requestPro1.jsp) 정보와 폼 파라미터 모두 서버로 전송
					--%>
					<input type="submit" value="전송">
				</td>
			</tr>
		</table>
	</form>
</body>
</html>















