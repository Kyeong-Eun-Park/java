package svc;

import java.sql.Connection;

import dao.MemberDAO;
import db.JdbcUtil;
import vo.AuthInfoBean;

public class MemberSendAuthMailService {

	// 인증 정보(아이디, 인증코드)를 auth_info 테이블에 등록 요청
	// => 파라미터 : AuthInfoBean 객체    리턴타입 : boolean(isRegistSuccess)
	public boolean registAuthInfo(AuthInfoBean authInfo) {
		boolean isRegistSuccess = false;
		
		// 2. Connection 객체 가져오기(공통)
		Connection con = JdbcUtil.getConnection();
		
		// 3. MemberDAO 객체 가져오기(공통)
		MemberDAO dao = MemberDAO.getInstance();
		
		// 4. MemberDAO 객체에 Connection 객체 전달하기(공통)
		dao.setConnection(con);
		
		// 5. MemberDAO 객체의 insertAuthInfo() 메서드 호출
		// => 파라미터 : AuthInfoBean 객체    리턴타입 : int(insertCount)
		int insertCount = dao.insertAuthInfo(authInfo);
		
		// 6. 인증 정보 등록 작업 성공 시 commit 작업 및 isRegistSuccess 값 true 로 변경하고,
		//    실패 시 rollback 작업 수행
		if(insertCount > 0) {
			JdbcUtil.commit(con);
			isRegistSuccess = true;
		} else {
			JdbcUtil.rollback(con);
		}
		
		// 7. Connection 객체 반환하기(공통)
		JdbcUtil.close(con);
		
		return isRegistSuccess;
	}

}
