package test8_member;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet("/Logout")
public class LogoutServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 세션 객체의 invalidate() 메서드를 호출하여 세션 초기화
		HttpSession session = request.getSession();
		session.invalidate();
		
		// 메인페이지로 포워딩 => Redirect
		response.sendRedirect("MemberMain");
	}

}











