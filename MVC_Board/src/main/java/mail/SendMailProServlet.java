package mail;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.Properties;

import javax.mail.Address;
import javax.mail.Authenticator;
import javax.mail.Message;
import javax.mail.Message.RecipientType;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SendMailProServlet
 */
@WebServlet("/SendMailPro")
public class SendMailProServlet extends HttpServlet {

	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("SendMailProServlet");
		
		// mail_form.jsp 페이지로부터 전달받은 폼 파라미터 가져와서 확인
		request.setCharacterEncoding("UTF-8");
		String sender = request.getParameter("sender");
		String receiver = request.getParameter("receiver");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
//		System.out.println(sender + ", " + receiver + ", " + title + ", " + content);
		
		try {
			// --------------------- 메일 전송에 필요한 정보 설정 작업 -----------------------
			// 메일 전송 프로토콜 : SMTP(Simple Mail Tranfer Protocol) <-> 수신 프로토콜 : POP3, IMAP
			// => 기본 포트(Well-known port) : 25번이지만, Gmail 은 587번 포트를 SMTP 포트로 사용
			// 1. 시스템(서버=톰캣)의 속성 정보(=서버 정보)를 java.util.Protperties 객체로 리턴받기
			Properties properties = System.getProperties();
			
			// 2. Properties 객체를 활용하여 메일 전송에 필요한 기본 설정 정보를 서버 정보에 추가
			//    => Properties 객체의 put() 메서드 사용
			// 메일 전송에 사용할 메일 서버에 대한 정보 설정(구글, 네이버, 아웃룩 등)
			properties.put("mail.smtp.host", "smtp.gmail.com"); // 구글(Gmail) SMTP 서버 주소
			properties.put("mail.smtp.auth", "true"); // SMTP 서버 접근 시 인증 여부 설정 
			properties.put("mail.smtp.port", "587"); // SMTP 서비스 포트 설정
			// 메일 서버 인증 관련 정보 설정
			properties.put("mail.smtp.starttls.enable", "true"); // TLS 라는 인증 프로토콜 사용 여부 설정
			properties.put("mail.smtp.ssl.protocols", "TLSv1.2"); // TLS 인증 프로토콜 버전 설정 
			// => 만약, 메일 발송 과정에서 TLS 버전 관련 문제 발생 시 설정하는 내용 입력 후에도
			//    could not convert socket to TLS... 메세지 표시될 경우 다음 라인 추가
//			properties.put("mail.smtp.ssl.trust", "smtp.gmail.com");
			
			// 3. 메일 서버 인증 정보를 관리하는 사용자 정의 클래스의 인스턴스 생성
			// => GoogleMailAuthenticator -> javax.mail.Authenticator 타입으로 업캐스팅
			Authenticator authenticator = new GoogleMailAuthenticator();
			
			// 4. 자바 메일 전송을 수행하는 작업을 javax.mail.Session 객체 단위로 관리하므로
			//    Session 클래스의 getDefauiltInstance() 메서드를 호출하여 Session 객체 리턴받기
			//    (주의! 웹에서 사용하는 기본 세션 객체는 java.servlet.http.HttpSession 이므로 다르다!)
			// => 파라미터 : Properties 객체, Authenticator 객체
			Session mailSession = Session.getDefaultInstance(properties, authenticator);
			
			// 5. 서버 정보와 인증 정보를 함께 관리할 javax.mail.MimeMessage 객체 생성
			// => javax.mail.MimeMessage -> javax.mail.Message 타입으로 업캐스팅
			// => 파라미터 : javax.mail.Session 객체
			Message mailMessage = new MimeMessage(mailSession);
			
			// 6. 전송할 메일 정보 설정
			// 1) 발신자 정보 설정을 위한 InternetAddress 객체 생성(=> Address 타입 업캐스팅)
			// => 파라미터 : 발신자 주소, 발신자 이름
			// => 단, 상용 메일 서버(구글, 네이버 등)의 경우 스팸 정책으로 인해 발신자 주소 변경 불가
			//    (실제 사용중인 계정의 메일 주소가 발신자 주소로 자동 설정됨)
			Address senderAddress = new InternetAddress(sender, "아이티윌");
			// 2) 수신자 정보 설정을 위한 InternetAddress 객체 생성
			// => 파라미터 : 수신자 주소
			Address receiverAddress = new InternetAddress(receiver);
			// 3) Message 객체를 통해 전송할 메일에 대한 내용 정보 설정
			// 3-1) 메일 헤더 정보 설정
			mailMessage.setHeader("content-type", "text/html; charset=UTF-8");
			// 3-2) 발신자 정보 설정
			// => 파라미터 : 발신자 정보 객체
			mailMessage.setFrom(senderAddress);
			// 3-3) 수신자 정보 설정
			// => addRecipient() 메서드를 사용하여 수신자 정보 설정
			// => 파라미터 : 수신 타입, 수신자 정보 객체
			mailMessage.addRecipient(RecipientType.TO, receiverAddress);
			// => RecipentType.TO : 수신자에게 직접 전송(직접 받을 수신자 선택)
			//    RecipentType.CC : 참조. Carbon Copy 의 약자. 직접적인 수신자는 아니나 참조용으로 수신
			//    RecipentType.BCC : 숨은참조. Blind CC 의 약자. 다른 사람들이 누가 참조하는지 알 수 없게 숨김
			// 3-4) 메일 제목 설정
			mailMessage.setSubject(title);
			// 3-5) 메일 본문 설정
			// => 파라미터 : 본문, 본문의 컨텐츠 타입
			mailMessage.setContent("<h1>" + content + "</h1>", "text/html; charset=UTF-8");
			// 3-6) 메일 전송 날짜 및 시각 설정
			// => java.util.Date 객체 생성을 통해 현재 시스템 시각 정보 사용
			mailMessage.setSentDate(new Date());
			
			// 7. 메일 전송
			// javax.mail.Transport 클래스의 static 메서드 send() 호출
			// => 파라미터 : Message 객체
			Transport.send(mailMessage);
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('메일 발송 성공!');");
			out.println("</script>");
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
			
			response.setContentType("text/html; charset=utf-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('메일 발송 실패!');");
			out.println("history.back();");
			out.println("</script>");
			out.flush();
		}
		
		
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doProcess(request, response);
	}

}











