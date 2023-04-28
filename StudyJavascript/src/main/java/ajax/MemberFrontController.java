package ajax;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// *.me 서블릿 패턴에 대한 요청을 모두 처리하는 MemberFrontController 클래스 정의 - 서블릿
@WebServlet("*.me")
public class MemberFrontController extends HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberFrontController");
		
		// POST 방식 요청에 대한 한글 인코딩 설정
		request.setCharacterEncoding("UTF-8");
		
		// 공통으로 사용할 변수 선언
		Action action = null; // XXXAction 객체를 공통으로 관리할 Action 인터페이스 타입
		ActionForward forward = null; // 포워딩 정보를 저장할 ActionForward 타입
		
		// 서블릿 주소 추출
		String command = request.getServletPath();
		System.out.println("command : " + command);
		
		// ----------------------------------------------------------------------
		// 서블릿 주소 판별 후 컨트롤 작업 수행
		if(command.equals("/AjaxMain.me")) {
			forward = new ActionForward();
			forward.setPath("ajax/index.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/MemberJoinForm.me")) { // 회원 가입 폼
			forward = new ActionForward();
			forward.setPath("ajax/test2.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/MemberJoinPro.me")) { // 회원 가입 비즈니스 로직
			action = new MemberJoinProAction();
			forward = action.execute(request, response);
		} else if(command.equals("/MemberLoginForm.me")) { // 회원 로그인 폼
			forward = new ActionForward();
			forward.setPath("ajax/test1.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/MemberLoginPro.me")) { // 회원 로그인 비즈니스 로직
			action = new MemberLoginProAction();
			forward = action.execute(request, response);
		} else if(command.equals("/MemberLogout.me")) {
			action = new MemberLogoutAction();
			forward = action.execute(request, response);
		} else if(command.equals("/MemberCheckDupIdForm.me")) { // 아이디 중복 체크 폼
			forward = new ActionForward();
			forward.setPath("ajax/test2_check_id.jsp");
			forward.setRedirect(false);
		} else if(command.equals("/MemberCheckDupIdPro.me")) {
			action = new MemberCheckDupIdProAction();
			forward = action.execute(request, response);
		} else if(command.equals("/MemberCheckDupIdPro2.me")) {
			action = new MemberCheckDupIdProAction2();
			forward = action.execute(request, response);
		}
		// =======================================================================
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












