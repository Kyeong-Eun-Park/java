package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import action.Action;
import action.BoardDeleteProAction;
import action.BoardDetailAction;
import action.BoardListAction;
import action.BoardModifyFormAction;
import action.BoardModifyProAction;
import action.BoardReplyFormAction;
import action.BoardReplyProAction;
import action.BoardWriteProAction;
import action.Main2Action;
import vo.ActionForward;

// *.bo 서블릿 패턴에 대한 요청을 모두 처리하는 BoardFrontController 클래스 정의 - 서블릿
@WebServlet("*.bo")
public class BoardFrontController extends HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("BoardFrontController");
		
		// POST 방식 요청에 대한 한글 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		
		// 공통으로 사용할 변수 선언
		Action action = null;
		ActionForward forward = null; // 포워딩 정보를 저장할 ActionForward 타입
		
		// 서블릿 주소 추출
		String command = request.getServletPath();
		System.out.println("command : " + command);
		
		// ----------------------------------------------------------------------
		// 서블릿 주소 판별 후 컨트롤 작업 수행
		if(command.equals("/BoardWriteForm.bo")) {
			// board/board_write.jsp 페이지로 포워딩(Dispatch 방식)
			forward = new ActionForward();
			forward.setPath("board/board_write_form.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/BoardWritePro.bo")) {
			// 글쓰기 비즈니스 로직을 위한 BoardWriteProAction 클래스 사용
			action = new BoardWriteProAction();
			forward = action.execute(request, response);
		} else if(command.equals("/BoardList.bo")) {
			// 글목록 조회 비즈니스 로직을 위한 BoardListAction 클래스 사용
			action = new BoardListAction();
			forward = action.execute(request, response);
		} else if(command.equals("/BoardDetail.bo")) {
			// 글 상세정보 조회 비즈니스 로직을 위한 BoardDetailAction 클래스 사용
			action = new BoardDetailAction();
			forward = action.execute(request, response);
		} else if(command.equals("/BoardDeleteForm.bo")) {
			// board/board_delete_form.jsp 페이지로 포워딩(Dispatch 방식)
			forward = new ActionForward();
			forward.setPath("board/board_delete_form.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/BoardDeletePro.bo")) {
			// 글 삭제 비즈니스 로직을 위한 BoardDeleteProAction 클래스 사용
			action = new BoardDeleteProAction();
			forward = action.execute(request, response);
		} else if(command.equals("/BoardModifyForm.bo")) {
			// 글 삭제 비즈니스 로직을 위한 BoardModifyFormAction 클래스 사용
			action = new BoardModifyFormAction();
			forward = action.execute(request, response);
		} else if(command.equals("/BoardModifyPro.bo")) {
			// 글 삭제 비즈니스 로직을 위한 BoardModifyProAction 클래스 사용
			action = new BoardModifyProAction();
			forward = action.execute(request, response);
		} else if(command.equals("/BoardReplyForm.bo")) {
			// 답글 등록 폼 표시를 위한 BoardReplyFormAction 클래스 사용
			action = new BoardReplyFormAction();
			forward = action.execute(request, response);
		} else if(command.equals("/BoardReplyPro.bo")) {
			// 답글 등록 비즈니스 로직을 위한 BoardReplyProAction 클래스 사용
			action = new BoardReplyProAction();
			forward = action.execute(request, response);
		} else if(command.equals("/Main2.bo")) {
			// 샘플 메인페이지 비즈니스 로직을 위한 Main2Action 클래스 사용
			action = new Main2Action();
			forward = action.execute(request, response);
		}
		
		// ----------------------------------------------------------------------
		// 서블릿 주소 판별 후 포워딩 작업 수행
		// 1. ActionForward 객체가 null 이 아닌지 판별
		if(forward != null) { // ActionForward 객체가 존재할 경우
			// 2. 포워딩 방식 판별(ActionForward 객체의 isRedirect() 메서드 활용)
			if(forward.isRedirect()) { // 리다이렉트 방식
				// 3-1. 리다이렉트 방식 포워딩 수행
				// => 포워딩 경로 : ActionForward 객체의 getPath() 메서드 활용
				response.sendRedirect(forward.getPath());
			} else { // 디스패치 방식
				// 3-2. 디스패치 방식 포워딩 수행
				// => 포워딩 경로 : ActionForward 객체의 getPath() 메서드 활용
				RequestDispatcher dispatcher = request.getRequestDispatcher(forward.getPath());
				dispatcher.forward(request, response);
			}
		}
	}
	
	// GET 방식 요청에 대해 자동 호출되는 doGet() 메서드
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공통으로 요청을 처리할 doProcess() 메서드 호출
		doProcess(request, response);
	}

	// POST 방식 요청에 대해 자동 호출되는 doPost() 메서드
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공통으로 요청을 처리할 doProcess() 메서드 호출
		doProcess(request, response);
	}

}
