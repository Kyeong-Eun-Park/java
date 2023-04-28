package svc;

import java.sql.Connection;
import java.util.List;

import dao.BoardDAO;
import db.JdbcUtil;
import vo.BoardBean;

public class Main2Service {

	// 최근 게시물 목록 조회 요청
	// => 파라미터 : 없음   리턴타입 : List<BoardBean>
	public List<BoardBean> getRecentlyBoardList() {
		// 1. 리턴값을 저장할 변수 선언
		List<BoardBean> boardList = null;
		
		// 2. Connection 객체 가져오기(공통)
		Connection con = JdbcUtil.getConnection();
		
		// 3. BoardDAO 객체 가져오기(공통)
		BoardDAO dao = BoardDAO.getInstance();
		
		// 4. BoardDAO 객체에 Connection 객체 전달하기(공통)
		dao.setConnection(con);
		
		// 5. BoardDAO 객체의 selectRecentlyBoardList() 메서드 호출
		// => 파라미터 : 없음   리턴타입 : List<BoardBean>(boardList)
		boardList = dao.selectRecentlyBoardList();
		
		// 6. Connection 객체 반환하기(공통)
		JdbcUtil.close(con);
		
		// 7. 작업 요청 처리 결과 리턴
		return boardList;
	}

}
