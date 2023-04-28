package svc;

import java.sql.Connection;

import dao.BoardDAO;
import db.JdbcUtil;

public class BoardDeleteProService {

	// 삭제를 위한 패스워드 일치 여부 판별 요청 수행하는 isBoardWriter() 메서드 정의
	public boolean isBoardWriter(int board_num, String board_pass) {
		boolean isBoardWriter = false;
		
		// 2. Connection 객체 가져오기(공통)
		Connection con = JdbcUtil.getConnection();
		
		// 3. BoardDAO 객체 가져오기(공통)
		BoardDAO dao = BoardDAO.getInstance();
		
		// 4. BoardDAO 객체에 Connection 객체 전달하기(공통)
		dao.setConnection(con);
		
		// 5. BoardDAO 객체의 isBoardWriter() 메서드 호출
		// => 파라미터 : 글번호, 패스워드   리턴타입 : boolean(isBoardWriter)
		isBoardWriter = dao.isBoardWriter(board_num, board_pass);
		
		// 6. Connection 객체 반환하기(공통)
		JdbcUtil.close(con);
		
		return isBoardWriter;
	}

	// 글 삭제 작업 수행
	// => 파라미터 : 글번호(board_num)    리턴타입 : boolean(isDeleteSuccess)
	public boolean removeBoard(int board_num) {
		boolean isDeleteSuccess = false;
		
		// 2. Connection 객체 가져오기(공통)
		Connection con = JdbcUtil.getConnection();
		
		// 3. BoardDAO 객체 가져오기(공통)
		BoardDAO dao = BoardDAO.getInstance();
		
		// 4. BoardDAO 객체에 Connection 객체 전달하기(공통)
		dao.setConnection(con);
		
		// 5. BoardDAO 객체의 deleteBoard() 메서드 호출
		// => 파라미터 : 글번호   리턴타입 : int(deleteCount)
		int deleteCount = dao.deleteBoard(board_num);
		
		// 6. 리턴받은 결과를 판별하여 commit, rollback 결정 후
		//    commit 일 경우 isDeleteSuccess 를 true 로 변경
		if(deleteCount > 0) {
			JdbcUtil.commit(con);
			isDeleteSuccess = true;
		} else {
			JdbcUtil.rollback(con);
		}
		
		// 7. Connection 객체 반환하기(공통)
		JdbcUtil.close(con);
		
		return isDeleteSuccess;
	}

}














