package test8_member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


// 현재 서블릿 주소가 "http://localhost:8080/StudyServlet/test8_member/JoinForm" 일 경우 매핑
//@WebServlet("/test8_member/JoinPro")
// 현재 서블릿 주소가 "http://localhost:8080/StudyServlet/JoinPro" 일 경우 매핑
@WebServlet("/JoinPro")
public class JoinProServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// join_form.jsp 페이지로부터 POST 방식의 요청이 발생하므로
		// doPost() 메서드에서 요청을 처리해야한다!
		System.out.println("JoinProServlet - doPost()");
		
		request.setCharacterEncoding("UTF-8");

		String name = request.getParameter("name");
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		String jumin = request.getParameter("jumin1") + "-" + request.getParameter("jumin2");
		String email = request.getParameter("email1") + "@" + request.getParameter("email2");
		String job = request.getParameter("job");
		String gender = request.getParameter("gender");
		String[] hobbies = request.getParameterValues("hobby");
		String hobby = ""; // 문자열 결합을 통해 취미를 하나로 묶을 변수 선언(실제 사용할 변수)
		for(String item : hobbies) {
			hobby += item + "/";
		}
		String motivation = request.getParameter("motivation");
		
		// MemberDTO 객체 생성 및 파라미터 데이터 저장
		MemberDTO member = new MemberDTO();
		member.setName(name);
		member.setId(id);
		member.setPasswd(passwd);
		member.setJumin(jumin);
		member.setEmail(email);
		member.setJob(job);
		member.setGender(gender);
		member.setHobby(hobby);
		member.setMotivation(motivation);
		
		// MemberDAO 객체 생성 후 insertMember() 메서드 호출하여 회원 가입 처리 요청
		// => 파라미터 : MemberDTO 객체(member)   리턴타입 : int(insertCount)
		MemberDAO dao = new MemberDAO();
		int insertCount = dao.insertMember(member);
		
		// 회원 가입 처리 결과 판별
		// => 성공 시 메인페이지로 포워딩
		// => 실패 시 자바스크립트를 사용하여 "회원 가입 실패!" 출력 후 이전 페이지로 돌아가기
		if(insertCount > 0) {
			// 리다이렉트 방식 포워딩
			response.sendRedirect("MemberMain");
		} else {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('회원 가입 실패!');");
			out.println("history.back();");
			out.println("</script>");
			out.flush();
		}
		
		// ----------------------------------------------------------------------
		// 회원 가입 완료 후 메인 페이지(test8_member/member_main.jsp)로 포워딩
//		response.sendRedirect("test8_member/member_main.jsp");
		// => 리다이렉트 방식을 사용하여 뷰페이지 직접 지정 시 URL(파일명) 노출됨
		
//		RequestDispatcher dispatcher = 
//				request.getRequestDispatcher("test8_member/member_main.jsp");
//		dispatcher.forward(request, response);
		// => 디스패치 방식을 사용하여 뷰페이지 지정 시 파일명은 노출되지 않음
		//    그러나, 메인페이지를 표시하는 작업이지만 URL 에는 JoinPro 가 표시되어 있기 때문에
		//    현재 작업과 서블릿 주소가 어울리지 않는다.
		
		// 결국, 현재 메인페이지로 이동하기 위한 작업에 뷰페이지 파일명을 직접 기술하는 것은
		// 올바른 포워딩 방법이 아니다!
		// ---------------------------------------------------------------------------------
		// 메인페이지를 표시하기 위한 MemberMain 서블릿 주소 요청을 통해 메인페이지로 포워딩
//		RequestDispatcher dispatcher = request.getRequestDispatcher("MemberMain");
//		dispatcher.forward(request, response);
		// => 서블릿 주소를 디스패치 방식으로 요청 시 해당 서블릿 주소 동작하지 않음!
		//    즉, 새로운 요청이 아니므로 톰캣이 해당 서블릿 주소 매핑하지 못함!
		
		// 결론! 서블릿에서 또 다른 서블릿으로 이동할 경우 리다이렉트 방식으로 포워딩한다!!
//		response.sendRedirect("MemberMain");
		// ---------------------------------------------------------------------------------
	}

}















