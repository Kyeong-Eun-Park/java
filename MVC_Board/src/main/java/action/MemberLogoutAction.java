package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import vo.ActionForward;

public class MemberLogoutAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MemberLogoutAction");
		
		ActionForward forward = null;
		
		// 로그아웃 작업 수행
		// => 별도의 데이터베이스 접근이 불필요하므로 Action 클래스에서 작업 후 포워딩
		// HttpSession 객체 가져와서 invalidate() 메서드를 호출하여 세션 초기화
		HttpSession session = request.getSession();
		session.invalidate();
		
		// ActionForward 객체를 통해 메인페이지로 포워딩 설정(리다이렉트)
		forward = new ActionForward();
		forward.setPath("./");
		forward.setRedirect(true);
		
		return forward;
	}

}













