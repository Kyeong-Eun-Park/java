package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardDetailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardDetailAction");
		
		ActionForward forward = null;
		
		// 상세정보 조회에 필요한 파라미터(글번호) 가져오기
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		// BoardDetailService 클래스의 인스턴스 생성 후
		// 게시물 상세 정보 조회 작업을 위한 getBoard() 메서드 호출
		// => 파라미터 : 글번호   리턴타입 : BoardBean
		BoardDetailService service = new BoardDetailService();
		BoardBean board = service.getBoard(board_num);
		
		// 뷰페이지로 전달할 글 상세정보(BoardBean 객체)를 request 객체에 저장
		request.setAttribute("board", board);
		
		// board_view.jsp 페이지로 포워딩
		// => URL 유지 및 request 객체 유지를 위해 디스패치 방식 포워딩
		forward = new ActionForward();
		forward.setPath("board/board_view.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}










