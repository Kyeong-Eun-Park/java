package svc;

import java.sql.Connection;

import dao.BoardDAO;
import db.JdbcUtil;
import vo.BoardBean;

public class BoardModifyProService {
	// 수정을 위한 패스워드 일치 여부 판별 요청 수행하는 isBoardWriter() 메서드 정의
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
		// => 기존 메서드 재사용
		isBoardWriter = dao.isBoardWriter(board_num, board_pass);
		
		// 6. Connection 객체 반환하기(공통)
		JdbcUtil.close(con);
		
		return isBoardWriter;
	}

	// 글 수정 작업 요청을 수행하는 modifyBoard() 메서드 정의
	// => 파라미터 : BoardBean 객체(board)   리턴타입 : boolean(isModifySuccess)
	public boolean modifyBoard(BoardBean board) {
		boolean isModifySuccess = false;
		
		// 2. Connection 객체 가져오기(공통)
		Connection con = JdbcUtil.getConnection();
		
		// 3. BoardDAO 객체 가져오기(공통)
		BoardDAO dao = BoardDAO.getInstance();
		
		// 4. BoardDAO 객체에 Connection 객체 전달하기(공통)
		dao.setConnection(con);
		
		// 5. BoardDAO 객체의 updateBoard() 메서드 호출
		// => 파라미터 : BoardBean 객체   리턴타입 : int(updateCount)
		int updateCount = dao.updateBoard(board);
		
		// 6. 수정 작업 성공 시 commit 작업 및 isModifySuccess 값 true 로 변경하고,
		//    실패 시 rollback 작업 수행
		if(updateCount > 0) {
			JdbcUtil.commit(con);
			isModifySuccess = true;
		} else {
			JdbcUtil.rollback(con);
		}
		
		// 7. Connection 객체 반환하기(공통)
		JdbcUtil.close(con);
		
		return isModifySuccess;
	}
	
}














