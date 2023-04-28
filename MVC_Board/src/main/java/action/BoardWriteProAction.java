package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardWriteProService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardWriteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardWriteProAction");
		
		ActionForward forward = null;
		
		// 전달받은 폼 파라미터를 BoardBean 객체에 저장
		BoardBean board = new BoardBean();
		board.setBoard_name(request.getParameter("board_name"));
		board.setBoard_pass(request.getParameter("board_pass"));
		board.setBoard_subject(request.getParameter("board_subject"));
		board.setBoard_content(request.getParameter("board_content"));
		board.setBoard_file(request.getParameter("board_file"));
//		System.out.println(board);
		
		// 글쓰기 작업 요청을 위해 BoardWriteProService 인스턴스 생성 및 registBoard() 메서드 호출
		// => 파라미터 : BoardBean 객체   리턴타입 : boolean(isWriteSuccess)
		BoardWriteProService service = new BoardWriteProService();
		boolean isWriteSuccess = service.registBoard(board);
		
		// 글쓰기 작업 완료 후 리턴된 결과값(isWriteSuccess)을 리턴받아 판별
		// => 실패 시 자바스크립트를 사용하여 오류메세지 출력 및 이전페이지로 돌아가기
		// => 성공 시 ActionForward 객체를 사용하여 BoardList.bo 서블릿 주소를 Redirect 방식으로 설정
		if(!isWriteSuccess) { // 실패 시
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter(); // IOException 예외 처리 필요
				out.println("<script>");
				out.println("alert('글쓰기 실패!');");
				out.println("history.back();");
				out.println("</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else { // 성공 시
			// BoardList.bo 서블릿 주소 요청 => 리다이렉트
			forward = new ActionForward();
			forward.setPath("BoardList.bo");
			forward.setRedirect(true);
		}
		
		return forward;
	}

}















