import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/myServlet3")
public class TestMyServlet3 extends HttpServlet {
	// 만약, 서블릿 클래스 내부에 doGet() 메서드만 오버라이딩 했을 경우
	// 해당 서블릿 주소의 요청 중 GET 방식 요청만 처리되고
	// POST 방식 요청이 들어오면 HTTP 405 에러가 발생함
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestMyServlet2 - doGet()");
	}

//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		System.out.println("TestMyServlet2 - doPost()");
//	}
	
}
