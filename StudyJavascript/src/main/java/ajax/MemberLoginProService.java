package ajax;

import java.sql.Connection;

public class MemberLoginProService {
	
	// 로그인 작업 요청을 수행할 isCorrectUser() 메서드 정의
	public boolean isCorrectUser(MemberBean member) {
		// 1. 로그인 판별 결과를 저장할 변수 선언(boolean 타입 isLoginSuccess)
		boolean isLoginSuccess = false;
		
		// 2. Connection 객체 가져오기(공통)
		Connection con = JdbcUtil.getConnection();
		
		// 3. MemberDAO 객체 가져오기(공통)
		MemberDAO dao = MemberDAO.getInstance();
		
		// 4. MemberDAO 객체에 Connection 객체 전달하기(공통)
		dao.setConnection(con);
		
		// 5. MemberDAO 객체의 selectCorrectUser() 메서드를 호출하여 로그인 판별 작업 요청
		// => 파라미터 : MemberBean 객체   리턴타입 : boolean(isLoginSuccess)
		isLoginSuccess = dao.selectCorrectUser(member);
		
		// 6. Connection 객체 반환하기(공통)
		JdbcUtil.close(con);
		
		// 7. 로그인 판별 결과 리턴
		return isLoginSuccess; // MemberLoginProAction 으로 리턴
	}

}













