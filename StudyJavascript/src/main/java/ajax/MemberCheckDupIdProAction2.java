package ajax;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MemberCheckDupIdProAction2 implements Action {

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

		// HTML 태그 출력을 위한 PrintWriter 객체를 활용하여
		// 중복 판별 결과가 true 일 경우 "true", false 일 경우 "false" 문자열을
		// 응답데이터로 생성하기(포워딩 없이 AJAX 요청에 대해 응답데이터만 생성하여 전송) 
		// => 단, PrintWriter 객체로 출력 시 무조건 문자열로 전송됨
		try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter(); // IOException 예외 처리 필요
//			out.print(isDuplicate + ""); // boolean -> String 으로 변환(불필요)
			out.print(isDuplicate); // boolean 타입 그대로 출력 시 문자열로 사용됨
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return forward;
	}

}

















