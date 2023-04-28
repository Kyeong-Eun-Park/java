/**
 * 아이디(id) 와 패스워드(passwd) 를 전달받아 
 * 저장된 아이디(dbId), 패스워드(dbPasswd)와 비교하여
 * 일치할 경우 "로그인 성공!", 아니면 "로그인 실패!" 를 출력하는 login() 함수 정의
 */
// 데이터베이스에 저장되어 있다고 가정하고 아이디와 패스워드를 저장하는 변수 선언
let dbId = "admin";
let dbPasswd = "1234";

function login(id, passwd) {
	document.write("입력받은 아이디 : " + id + ", 패스워드 : " + passwd + "<br>");
//	if(id == dbId && passwd == dbPasswd) { // 아이디와 패스워드 모두 일치할 경우
//		document.write("로그인 성공!");
//	} else { // 하나라도 일치하지 않을 경우
//		document.write("로그인 실패!");
//	}

	// 다른 방법) 아이디 또는 패스워드 틀리면 "XXX 틀림!" 출력하고, 아니면 "로그인 성공!" 출력
	if(id != dbId) { // 아이디가 일치하지 않을 경우
		document.write("아이디 틀림!");
	} else if(passwd != dbPasswd) { // 패스워드가 일치하지 않을 경우
		document.write("패스워드 틀림!");
	} else { // 아이디와 패스워드 모두 일치할 경우
		document.write("로그인 성공!");
	}
}












