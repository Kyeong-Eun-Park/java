package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardDetailService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardModifyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardModifyFormAction");
		
		ActionForward forward = null;
		
		// 글 상세정보 조회에 필요한 파라미터(글번호) 가져오기
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		
		// 수정에 필요한 게시물 상세정보 조회
		// 기존 BoardDetailService 클래스에 정의한 getBoard() 메서드를 재사용 가능하다!
		// BoardDetailService - getBoard() 메서드 호출하여 게시물 상세 정보 조회 작업 요청 
		// => 파라미터 : 글번호   리턴타입 : BoardBean(board)
		BoardDetailService service = new BoardDetailService();
		BoardBean board = service.getBoard(board_num);
		
		// 뷰페이지로 전달할 글 상세정보(BoardBean 객체)를 request 객체에 저장
		request.setAttribute("board", board);
		
		// board_modify_form.jsp 페이지로 포워딩
		// => URL 유지 및 request 객체 유지를 위해 디스패치 방식 포워딩
		forward = new ActionForward();
		forward.setPath("board/board_modify_form.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}













