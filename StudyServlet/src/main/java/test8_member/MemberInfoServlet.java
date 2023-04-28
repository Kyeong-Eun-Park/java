package test8_member;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/MemberInfo")
public class MemberInfoServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("MemberInfoServlet - doGet()");
		
		// 세션 객체 가져오기
		HttpSession session = request.getSession();
		
		// 세션 아이디(속성명 "sId") 가져와서 변수에 저장
		String id = (String)session.getAttribute("sId");
		System.out.println("세션 아이디 : " + id);
		
		// 만약, 세션 아이디가 없을 경우(null 또는 널스트링)
		// 자바스크립트를 사용하여 "잘못된 접근입니다!" 출력 후 메인페이지로 이동
		if(id == null || id.equals("")) {
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('잘못된 접근입니다!');");
			out.println("location.href='MemberMain';");
			out.println("</script>");
			out.flush();
		} else { // 세션 아이디가 있을 경우
			// MemberDAO 객체의 selectMemberInfo() 메서드 호출하여 회원 상세 정보 조회 요청
			// => 파라미터 : 세션 아이디   리턴타입 : MemberDTO(member)
			MemberDAO dao = new MemberDAO();
			MemberDTO member = dao.selectMemberInfo(id);
			
			// 조회된 정보가 없을 경우(null)
			// 자바스크립트를 사용하여 "회원 정보 조회 실패!" 출력 후 이전페이지로 돌아가기
			if(member == null) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원 정보 조회 실패!');");
				out.println("history.back();");
				out.println("</script>");
				out.flush();
			} else { // 조회 정보가 있을 경우
				// 회원 한 명의 정보(= 1개 레코드 = MemberDTO 객체)를 request 객체에 저장
				request.setAttribute("member", member);
				
				// 회원 상세 정보 출력을 위한 뷰페이지(test8_member/member_info.jsp)로 포워딩
				// => 서블릿 -> 뷰페이지 이동이므로 Dispatch 방식 포워딩
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("test8_member/member_info.jsp");
				dispatcher.forward(request, response);
			}
		}
		
	}

}
















