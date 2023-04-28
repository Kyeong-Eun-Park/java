package test8_member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/MemberMain")
public class MemberMainServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberMainServlet - doGet()");
		
		// member_main.jsp 페이지로 포워딩
		// Redirect vs Dispatch
		// => 서블릿 클래스에서 뷰페이지(JSP)로 이동할 때 이동할 주소로 변경하지 않고
		//    기존 URL(주소)가 유지되도록 Dispatch 방식으로 포워딩 수행
		// => 이 때, 현재 서블릿 주소가 컨텍스트 루트의 하위에 있을 경우
		//    JSP 페이지는 webapp 디렉토리가 기준점이 된다!
		// => 따라서, webapp/test8_member 디렉토리에 JSP 파일이 존재할 경우
		//    반드시 test8_member/파일명.jsp 형식으로 지정해야한다!
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("test8_member/member_main.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
