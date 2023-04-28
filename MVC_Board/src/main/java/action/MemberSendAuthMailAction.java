package action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import auth.GenerateRandomCode;
import mail.SendMailHandler;
import svc.MemberSendAuthMailService;
import vo.ActionForward;
import vo.AuthInfoBean;

public class MemberSendAuthMailAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("MemberSendAuthMailAction");
		
		ActionForward forward = null;
		
		String id = request.getParameter("id");
		String email = request.getParameter("email");
//		System.out.println(id + ", " + email);
		
		// GenerateRandomCode 클래스의 static 메서드 getRandomCode() 메서드를 호출하여
		// 인증코드로 사용할 난수 리턴받기 => 파라미터 : 난수 길이(50)
		String authCode = GenerateRandomCode.getRandomCode(50);
		System.out.println("인증코드 : " + authCode);
		
		// AuthInfoBean 객체 생성 및 아이디, 인증코드 저장
		AuthInfoBean authInfo = new AuthInfoBean();
		authInfo.setId(id);
		authInfo.setAuth_code(authCode);
		
		// MemberSendAuthMailService - registAuthInfo() 메서드를 호출하여
		// 인증 정보(아이디, 인증코드)를 auth_info 테이블에 등록 요청
		// => 파라미터 : AuthInfoBean 객체    리턴타입 : boolean(isRegistSuccess)
		MemberSendAuthMailService service = new MemberSendAuthMailService();
		boolean isRegistSuccess = service.registAuthInfo(authInfo);
//		System.out.println(isRegistSuccess);
		
		// 인증 메일 발송에 사용될 정보(수신자 email, 메일 제목, 메일 본문) 생성
		// => 수신자 메일 주소는 가입자의 email 주소를 그대로 사용
		String subject = "[아이티윌] 아이티윌 가입 인증 메일입니다.";
		String content = "<a href='http://localhost:8080/MVC_Board/MemberAuth.me?id=" + id + "&authCode=" + authCode + "'><b>인증하려면 이 곳을 클릭하세요.</b></a>";

		// 인증 메일 발송을 위해 SendMailHandler - sendMail() 메서드 호출
		// => 파라미터 : 수신자 이메일, 메일 제목, 본문   리턴타입 : boolean(isSendSuccess)
		SendMailHandler sendMailHanler = new SendMailHandler();
		boolean isSendSuccess = sendMailHanler.sendMail(email, subject, content);
		
		// 인증 정보 등록과 인증 메일 발송 모두 성공 시 result 변수값을 true 로 설정
		boolean result = false;
		
		if(isRegistSuccess && isSendSuccess) {
			result = true;
		}
		
		try {
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter(); // IOException 예외 처리 필요
			out.println(result); // 인증 정보 등록 및 메일 발송 결과 전송
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return forward;
	}

}












