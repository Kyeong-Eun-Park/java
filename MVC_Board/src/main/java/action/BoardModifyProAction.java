package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardDeleteProService;
import svc.BoardModifyProService;
import vo.ActionForward;
import vo.BoardBean;

public class BoardModifyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardModifyProAction");
		
		ActionForward forward = null;
		
		// 전달받은 폼 파라미터를 BoardBean 객체에 저장
		BoardBean board = new BoardBean();
		board.setBoard_num(Integer.parseInt(request.getParameter("board_num")));
		board.setBoard_name(request.getParameter("board_name"));
		board.setBoard_pass(request.getParameter("board_pass"));
		board.setBoard_subject(request.getParameter("board_subject"));
		board.setBoard_content(request.getParameter("board_content"));
//		board.setBoard_file(request.getParameter("board_file")); // 파일 제외
//		System.out.println(board);
		
		// BoardModifyProService - isBoardWriter() 메서드를 호출하여
		// 글 수정 가능 여부 판별 요청
		// => 파라미터 : 글번호, 패스워드    리턴타입 : boolean(isBoardWriter)
		BoardModifyProService service = new BoardModifyProService();
		boolean isBoardWriter = service.isBoardWriter(board.getBoard_num(), board.getBoard_pass());
		// 만약, 글번호와 패스워드를 BoardBean 객체에 저장된 채로 전달 시
//		boolean isBoardWriter = service.isBoardWriter(board);
		
		// 글 수정 권한이 없는 경우(= 패스워드 틀림)
		// 자바스크립트 사용하여 "수정 권한 없음!" 출력 후 이전페이지로 돌아가기
		if(!isBoardWriter) { // 수정 권한 없음
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter(); // IOException 예외 처리 필요
				out.println("<script>");
				out.println("alert('수정 권한 없음!');");
				out.println("history.back();");
				out.println("</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else { // 수정 권한 있음
			// BoardModifyProService 클래스의 modifyBoard() 메서드를 호출하여 글 수정 작업 요청
			// => 파라미터 : BoardBean 객체   리턴타입 : boolean(isModifySuccess)
			boolean isModifySuccess = service.modifyBoard(board);
			
			// 수정 작업 완료 결과 판별
			// 실패 시 자바스크립트로 '글 수정 실패' 출력 후 이전페이지로 이동하고
			// 성공 시 ActionForward 객체를 통해 "BoardDetail.bo" 서블릿 주소를 요청
			// (Redirect 방식 포워딩 = 새 주소로 변경(새 요청)되면서 request 객체가 새로 생성됨)
			// => 주의! Redirect 방식 포워딩 시 글번호(board_num)와 페이지번호(pageNum)를
			//    URL 뒤에 파라미터로 직접 붙여서 요청해야함
			if(!isModifySuccess) { // 수정 실패 시
				try {
					response.setContentType("text/html; charset=utf-8");
					PrintWriter out = response.getWriter(); // IOException 예외 처리 필요
					out.println("<script>");
					out.println("alert('수정 실패!');");
					out.println("history.back();");
					out.println("</script>");
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else { // 수정 성공 시
				forward = new ActionForward();
				forward.setPath("BoardDetail.bo?board_num=" + board.getBoard_num() 
									+ "&pageNum=" + request.getParameter("pageNum"));
				forward.setRedirect(true);
			}
		}
		
		return forward;
	}

}













