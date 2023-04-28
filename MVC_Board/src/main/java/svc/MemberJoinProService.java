package svc;

import java.sql.Connection;

import dao.MemberDAO;
import db.JdbcUtil;
import vo.MemberBean;

// Action 객체로부터 요청을 받아 DAO 객체와 상호 작용을 통해
// 실제 데이터베이스 처리 작업 요청을 수행하는 Service 클래스 정의
public class MemberJoinProService {
	
	// Action 클래스의 제어에 따라 회원 가입 작업 요청을 수행할 registMember() 메서드 정의
	// => 파라미터 : MemberBean 객체(member)   리턴타입 : boolean
	public boolean registMember(MemberBean member) {
		// 1. 회원 가입 작업 요청 처리 결과를 저장할 boolean 타입 변수 선언
		// => Action 클래스 입장에서는 요청 성공/실패 여부만 중요하므로 boolean 타입 사용
		boolean isRegistSuccess = false;
		
		// 2. JdbcUtil 객체로부터 Connection Pool 에 저장된 Connection 객체 가져오기(공통)
		//    => 트랜잭션 관리를 Service 클래스가 수행하기 때문에
		//       DAO 가 아닌 Service 클래스가 Connection 관리 주체가 되어야 한다!
		Connection con = JdbcUtil.getConnection();
		
		// 3. DAO 클래스의 인스턴스 생성(공통)
//		MemberDAO dao = new MemberDAO();
		// => MemberDAO 클래스는 싱글톤 패턴으로 구현되어 있으므로 
		//    MemberDAO 클래스에서 생성된 인스턴스를 리턴받아야 함
		MemberDAO dao = MemberDAO.getInstance();
		
		// 4. DAO 인스턴스에 setConnection() 메서드를 호출하여 Connection 객체 전달(공통)
		dao.setConnection(con);
		
		// 5. DAO 객체의 XXX 메서드를 호출하여 XXX 작업 수행 요청 및 결과 리턴받기
		// MemberDAO 객체의 insertMember() 메서드를 호출하여 회원 가입 작업 요청
		// => 파라미터 : MemberBean 객체    리턴타입 : int(insertCount)
		int insertCount = dao.insertMember(member);
		
		// 6. 작업 처리 결과 판별 후 트랜잭션 처리
		//    => 작업 성공/실패에 따른 커밋, 롤백 수행
		//       (JdbcUtil 클래스의 commit(), rollback() 메서드 활용)
		if(insertCount > 0) { // 작업 성공 시
			JdbcUtil.commit(con);
			
			// 작업 처리 결과를 성공으로 표시하여 Action 클래스에게 리턴하기 위해
			// isRegistSuccess 를 true 로 변경
			isRegistSuccess = true;
		} else { // 실패 시
			JdbcUtil.rollback(con);
		}
		
		// 7. 작업 처리 완료 후 Connection Pool 로부터 가져온 Connection 객체 반환(공통)
		//    => 주의! DAO 객체 내에서 Connection 객체 반환 금지!!!! (close() 호출 금지!)
		JdbcUtil.close(con);
		
		// 8. 작업 요청 처리 결과에 대한 판별 결과 리턴
		return isRegistSuccess;
	}
	
}













