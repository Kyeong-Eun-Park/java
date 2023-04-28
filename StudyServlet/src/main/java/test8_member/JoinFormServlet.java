package test8_member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/JoinForm")
public class JoinFormServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("JoinFormServlet - doGet()");
		
		// test8_member/join_form.jsp 페이지로 포워딩 - Redirect 방식
//		response.sendRedirect("test8_member/join_form.jsp");
		
		// 마찬가지로, 서블릿 클래스 -> 뷰페이지로 이동하기 때문에 Dispatch 방식 사용
		// 반드시 test8_member/파일명.jsp 형식으로 지정해야한다!
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("test8_member/join_form.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}











