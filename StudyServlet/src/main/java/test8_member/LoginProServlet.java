package test8_member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/LoginPro")
public class LoginProServlet extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginProServlet - doPost()");
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
//		System.out.println("아이디 : " + id);
//		System.out.println("패스워드 : " + passwd);
		
		// MemberDTO 객체(member) 생성 및 아이디, 패스워드 저장
		MemberDTO member = new MemberDTO();
		member.setId(id);
		member.setPasswd(passwd);
//		System.out.println(member.toString()); // 출력문에서 toString() 생략 가능
		
		// MemberDAO 객체 생성 및 isRightUser() 메서드 호출하여 아이디, 패스워드 판별 요청
		// => 파라미터 : MemberDTO 객체   리턴타입 : boolean(isRightUser)
		MemberDAO dao = new MemberDAO();
		boolean isRightUser = dao.isRightUser(member);
		
		// 요청 결과 판별
		// isRightUser 가 true 일 경우 세션 객체에 아이디를 속성명 "sId" 로 저장 후
		// 메인페이지(MemberMain)로 포워딩
		// 아니면, "로그인 실패" 출력
		if(isRightUser) {
			// 서블릿 클래스에서 세션 객체를 다루기 위해서는
			// HttpServletRequest 객체로부터 세션 객체를 얻어내야한다!
			// => getSession() 메서드 호출하여 HttpSession 객체 리턴받아 사용
			HttpSession session = request.getSession();
			
			// HttpSession 객체의 setAttribute() 메서드 호출하여 "sId" 속성에 아이디 저장 
			session.setAttribute("sId", id);
			
			// 메인페이지로 포워딩(서블릿 -> 서블릿 이동이므로 리다이렉트 방식 포워딩)
			response.sendRedirect("MemberMain");
		} else {
//			System.out.println("로그인 실패!");
			
			// 서블릿 클래스에서 웹브라우저로 전송할 HTML 문서 형태의 응답 데이터를 생성할 경우
			// ex) 자바스크립트 alert() 함수를 통한 메세지 출력 등의 작업 필요할 경우
			// => 자바의 출력 스트림 형태로 HTML 태그를 출력해야함
			
			// 1. 출력하는 HTML 문서에 대한 문서 타입(Content Type) 설정
			//    => 응답 데이터 타입으로 HTML 태그 문서가 전송됨을 클라이언트에게 알려주는 역할
			//    => response 객체의 setContentType() 메서드를 호출하여 문서 타입 문자열 전달
			//       (이 때, JSP 문서 최상단의 page 디렉티브 contentType=XXX 항목 활용)
			response.setContentType("text/html; charset=UTF-8");
			
			// 2. 자바 코스를 사용하여 HTML 태그나 자바스크립트 등을 출력(전송)하려면
			//    java.io.PrintWriter 객체가 필요(출력스트림과 연결되어 있는 객체)
			//    => response 객체의 getWriter() 메서드를 호출하여 객체 리턴받기
			PrintWriter out = response.getWriter();
			
			// 3. PrintWriter 객체의 print() 또는 println() 메서드를 호출하여
			//    파라미터로 HTML 태그나 자바스크립트 코드를 문자열 형태로 전달하여 
			//    클라이언트(웹브라우저)에 출력할 수 있다! (= 응답 데이터로 전송)
			out.println("<script>");
			// 자바스크립트를 통해 "로그인 실패!" 출력 후 이전페이지로 돌아가기
			out.println("alert('로그인 실패!');");
			out.println("history.back();");
			out.println("</script>");
			
			// 4. 출력스트림 객체(out)에 있는 모든 데이터를 내보내기(= 출력하기)
			out.flush();
			
		}
		
	}

}













