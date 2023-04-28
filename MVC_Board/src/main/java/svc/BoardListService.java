package svc;

import java.sql.Connection;
import java.util.List;

import dao.BoardDAO;
import db.JdbcUtil;
import vo.BoardBean;

public class BoardListService {
	
	// 게시물 목록 조회 작업 요청을 위한 getBoardList() 메서드 정의
	public List<BoardBean> getBoardList(int startRow, int listLimit) {
		// 1. 리턴값을 저장할 변수 선언
		List<BoardBean> boardList = null;
		
		// 2. Connection 객체 가져오기(공통)
		Connection con = JdbcUtil.getConnection();
		
		// 3. BoardDAO 객체 가져오기(공통)
		BoardDAO dao = BoardDAO.getInstance();
		
		// 4. BoardDAO 객체에 Connection 객체 전달하기(공통)
		dao.setConnection(con);
		
		// 5. BoardDAO 객체의 selectBoardList() 메서드 호출
		// => 파라미터 : 시작행번호, 조회할목록갯수   리턴타입 : List<BoardBean>(boardList)
		boardList = dao.selectBoardList(startRow, listLimit);
		
		// 6. Connection 객체 반환하기(공통)
		JdbcUtil.close(con);
		
		// 7. 작업 요청 처리 결과 리턴
		return boardList;
	}

	// 총 게시물 수 조회 요청을 위하는 getBoardListCount()
	public int getBoardListCount() {
		// 1. 리턴값을 저장할 변수 선언
		int listCount = 0;
		
		// 2. Connection 객체 가져오기(공통)
		Connection con = JdbcUtil.getConnection();
		
		// 3. BoardDAO 객체 가져오기(공통)
		BoardDAO dao = BoardDAO.getInstance();
		
		// 4. BoardDAO 객체에 Connection 객체 전달하기(공통)
		dao.setConnection(con);
		
		// 5. BoardDAO 객체의 selectBoardListCount() 메서드 호출
		// => 파라미터 : 없음   리턴타입 : int(listCount)
		listCount = dao.selectBoardListCount();
		
		// 6. Connection 객체 반환하기(공통)
		JdbcUtil.close(con);
		
		// 7. 작업 요청 처리 결과 리턴
		return listCount;
	}
	
}
