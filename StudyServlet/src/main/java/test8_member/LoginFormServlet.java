package test8_member;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/LoginForm")
public class LoginFormServlet extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("LoginFormServlet - doGet()");
		
		// test8_member/login_form.jsp 페이지로 포워딩 - Redirect 방식
//		response.sendRedirect("test8_member/login_form.jsp");
		
		// 서블릿 -> 뷰페이지로 포워딩 시 Dispatch 방식 사용
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("test8_member/login_form.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}











