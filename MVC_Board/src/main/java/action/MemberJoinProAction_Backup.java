package action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import vo.ActionForward;

// 서블릿 요청에 대한 처리를 담당하는 FrontController 의 제어 작업을 보조할 Action 클래스 정의
// => FrontController 클래스는 흐름 제어를 담당하고
//    요청에 대한 처리 준비 작업(파라미터 접근) 등은 Action 클래스가 담당하도록 모듈화
// => 단, request 또는 response 객체 등에 접근해야하므로 FrontController 클래스로부터
//    Action 클래스의 메서드 호출 시 HttpServletRequest, HttpServletResponse 객체 전달받아야함
// => 요청 처리 후 FrontController 가 포워딩 작업을 수행해야하므로
//    FrontController 에 전달할 포워딩 정보를 Action 클래스가 생성하여 리턴해야함
public class MemberJoinProAction_Backup {
	
	// execute() 메서드 정의하여 컨트롤러 요청에 대한 처리 준비 작업 수행
	// => 파라미터 : HttpServletRequest(request), HttpServletResponse(response) 객체
	// => 리턴타입 : ActionForward
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MemberJoinProAction");
		
		// 회원 가입 작업을 위한 데이터 준비 작업....
		
		// 회원 가입 작업 요청....
		
		// 회원 가입 작업 완료 후 메인페이지로 포워딩하기 위해 포워딩 정보를 저장 후 리턴
		// => 이 때, 서블릿 주소("./") 와 함께 포워딩 방식(Redriect)도 지정해야하므로
		//    return 문에 두 정보를 동시에 리턴할 수 없기 때문에
		//    두 정보를 관리할 ActionForward 객체 생성 후 정보 저장 및 리턴
		ActionForward forward = new ActionForward();
		forward.setPath("./"); // 포워딩 경로 => 루트
		forward.setRedirect(true);
		
		// 생성된 ActionForward 객체 리턴
		return forward; // FrontController 객체의 메서드 호출 위치로 리턴(돌아감)
	}
	
}














