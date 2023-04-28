package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// FrontController 클래스로부터 지시를 받아 비지니스 로직 처리 준비 작업 수행 및
// 처리 요청 후 결과를 리턴받아 포워딩 준비 작업을 수행하는 Action 클래스
// => Action 인터페이스 상속(구현)받아 추상메서드 execute() 오버라이딩(구현) 필수
public class MemberJoinProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MemberJoinProAction");
		
		// 포워딩 정보를 관리할 ActionForward 타입 변수 선언
		ActionForward forward = null;
		
		// 회원 가입 폼에서 전달받은 파라미터 가져와서 MemberBean 객체에 저장 후 콘솔 출력
		MemberBean member = new MemberBean();
		member.setName(request.getParameter("name"));
		member.setId(request.getParameter("id"));
		member.setPasswd(request.getParameter("passwd"));
		member.setEmail(request.getParameter("email1") + "@" + request.getParameter("email2"));
		member.setGender(request.getParameter("gender"));
//		System.out.println(member);
		
		// MemberJoinProService 클래스 인스턴스 생성 후
		// registMember() 메서드를 호출하여 회원 가입 작업 요청 수행
		// => 파라미터 : MemberBean 객체   리턴타입 : boolean(isRegistSuccess)
		MemberJoinProService service = new MemberJoinProService();
		boolean isRegistSuccess = service.registMember(member);
		
		// 회원 가입 작업 요청 결과 판별
		// 성공(isRegistSuccess 가 true) 시 메인페이지("./") 요청 => Redirect 방식
		// 실패 시 자바스크립트 사용하여 "회원 가입 실패!" 출력 후 이전페이지로 돌아가기
		if(isRegistSuccess) { // 성공 시
			// ActionForward 객체 생성 후 포워딩 주소 및 방식 설정
			// (FrontController 클래스에서 설정하는 대신 Action 클래스에서 설정)
			forward = new ActionForward();
//			forward.setPath("./");
//			forward.setRedirect(true);
			
			// 만약, 회원 가입 성공 결과 페이지를 별도로 작성한 경우
			// => member/member_join_result.jsp 페이지로 포워딩 설정(Dispatch 방식)
//			forward.setPath("member/member_join_result.jsp");
//			forward.setRedirect(false); // MemberJoinPro.me 서블릿 주소 유지됨
			
			// => MemberJoinResult.me 서블릿 요청(Redirect)
			forward.setPath("MemberJoinResult.me");
			forward.setRedirect(true); // MemberJoinResult.me 서블릿 주소로 변경됨
		} else { // 실패 시
			try {
				response.setContentType("text/html; charset=utf-8");
				PrintWriter out = response.getWriter(); // IOException 예외 처리 필요
				out.println("<script>");
				out.println("alert('회원 가입 실패!');");
				out.println("history.back();");
				out.println("</script>");
				out.flush();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		// 포워딩 정보가 저장된 ActionForward 객체 리턴
		return forward;
	}

}












