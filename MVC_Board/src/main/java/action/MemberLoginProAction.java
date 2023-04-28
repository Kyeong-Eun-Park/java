package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import svc.MemberLoginProService;
import vo.ActionForward;
import vo.MemberBean;

public class MemberLoginProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MemberLoginProAction");
		
		ActionForward forward = null;
		
		// 폼으로 전달받은 아이디, 패스워드 가져와서 MemberBean 객체에 저장
		MemberBean member = new MemberBean();
		member.setId(request.getParameter("id"));
		member.setPasswd(request.getParameter("passwd"));
//		System.out.println(member);
		
		// MemberLoginProService - isCorrectUser() 메서드 호출하여 로그인 판별 작업 요청
		// => 파라미터 : MemberBean 객체    리턴타입 : boolean(isLoginSuccess)
		MemberLoginProService service = new MemberLoginProService();
		boolean isLoginSuccess = service.isCorrectUser(member);
		
		// 로그인 판별 작업 요청 처리 결과 판별
		// => 성공 시 세션 객체에 로그인 성공 아이디를 "sId" 속성으로 저장 후 메인페이지 포워딩
		// => 실패 시 자바스크립트 통해 "로그인 실패!" 출력 후 이전페이지 돌아가기
		if(isLoginSuccess) { // 성공 시
			// MemberLoginProService - isAuthenticatedUser() 메서드 호출하여 인증 여부 판별 요청
			// => 파라미터 : MemberBean 객체   리턴타입 : boolean(isAuthenticatedUser)
			boolean isAuthenticatedUser = service.isAuthenticatedUser(member);
			
			// 인증 상태가 false("N") 일 경우 
			// 자바스크립트 - "이메일 인증 필수!" 출력 후 이전페이지로 돌아가기
			// 아니면 로그인 작업 요청 수행
			if(!isAuthenticatedUser) {
				try {
					response.setContentType("text/html; charset=utf-8");
					PrintWriter out = response.getWriter(); // IOException 예외 처리 필요
					out.println("<script>");
					out.println("alert('이메일 인증 필수!');");
					out.println("history.back();");
					out.println("</script>");
					out.flush();
				} catch (IOException e) {
					e.printStackTrace();
				}
			} else { // 인증이 완료된 회원일 경우
				// 세션 객체 가져오기
				HttpSession session = request.getSession();
				// 세션 객체에 아이디 저장
				session.setAttribute("sId", member.getId());
				
				// 메인페이지로 포워딩 => 리다이렉트 방식
				forward = new ActionForward();
				forward.setPath("./");
				forward.setRedirect(true);
			}
			
		} else { // 실패 시
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter(); // IOException 예외 처리 필요
				out.println("<script>");
				out.println("alert('로그인 실패!');");
				out.println("history.back();");
				out.println("</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		return forward;
	}

}














