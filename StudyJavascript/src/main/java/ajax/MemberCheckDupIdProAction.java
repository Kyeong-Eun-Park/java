package ajax;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberCheckDupIdProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		ActionForward forward = null;
		
		String id = request.getParameter("id");
//		System.out.println(id);
		
		// MemberCheckDupIdProService - checkId() 메서드 호출하여 중복 체크 작업 요청
		// => 파라미터 : 아이디    리턴타입 : boolean(isDuplicate)
		MemberCheckDupIdProService service = new MemberCheckDupIdProService();
		boolean isDuplicate = service.checkId(id);
//		System.out.println(isDuplicate);

		// MemberCheckDupIdForm.me 서블릿 주소 요청하여 포워딩 - 리다이렉트
		// => 파라미터로 아이디(id)와 판별결과(isDuplicate) 전달
		forward = new ActionForward();
		forward.setPath("MemberCheckDupIdForm.me?id=" + id + "&isDuplicate=" + isDuplicate);
		forward.setRedirect(true);
		
		return forward;
	}

}

















