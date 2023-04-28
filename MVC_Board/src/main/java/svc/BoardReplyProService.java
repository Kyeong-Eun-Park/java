package svc;

import java.sql.Connection;

import dao.BoardDAO;
import db.JdbcUtil;
import vo.BoardBean;

public class BoardReplyProService {
	// 답글 쓰기 요청을 수행하는 registReplyBoard() 메서드 정의
	// => 파라미터 : BoardBean 객체   리턴타입 : boolean(isWriteSuccess)
	public boolean registReplyBoard(BoardBean board) {
		// 1. 리턴값을 저장할 변수 선언
		boolean isWriteSuccess = false;
		
		// 2. Connection 객체 가져오기(공통)
		Connection con = JdbcUtil.getConnection();
		
		// 3. BoardDAO 객체 가져오기(공통)
		BoardDAO dao = BoardDAO.getInstance();
		
		// 4. BoardDAO 객체에 Connection 객체 전달하기(공통)
		dao.setConnection(con);
		
		// 5. BoardDAO 객체의 insertBoard() 메서드 호출
		// => 파라미터 : BoardBean 객체(board)   리턴타입 : int(insertCount)
		int insertCount = dao.insertReplyBoard(board);
		
		// 6. BoardDAO 의 INSERT 작업이 완료된 후 결과값(insertCount)을 리턴받아 판별
		// => 실패 시 rollback, 성공 시 commit 작업 및 결과값(isWriteSuccess)을 true 로 변경
		// => commit 과 rollback 은 JdbcUtil 클래스의 commit(), rollback() 메서드 활용
		if(insertCount > 0) { // 작업 성공 시
			JdbcUtil.commit(con);
			isWriteSuccess = true;
		} else { // 작업 실패 시
			JdbcUtil.rollback(con);
		}
		
		// 7. Connection 객체 반환하기(공통)
		JdbcUtil.close(con);
		
		// 8. 작업 요청 처리 결과 리턴
		return isWriteSuccess;
	}

}
