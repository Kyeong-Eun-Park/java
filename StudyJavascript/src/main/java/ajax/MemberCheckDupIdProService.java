package ajax;

import java.sql.Connection;

public class MemberCheckDupIdProService {

	public boolean checkId(String id) {
		boolean isDuplicate = false;
		
		Connection con = JdbcUtil.getConnection();
		MemberDAO dao = MemberDAO.getInstance();
		dao.setConnection(con);
		
		// MemberDAO - selectId() 메서드 호출하여 아이디 중복 확인 작업 요청
		// => 파라미터 : 아이디   리턴타입 : boolean(isDuplicate)
		isDuplicate = dao.selectId(id);
		
		JdbcUtil.close(con);
		
		return isDuplicate;
	}

}
