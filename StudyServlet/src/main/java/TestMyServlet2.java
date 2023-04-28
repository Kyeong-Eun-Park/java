import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 2) 서블릿 클래스 선언부 상단에 @WebServlet 어노테이션을 사용하는 방법
//    => @WebServlet("/서블릿주소") 또는 @WebServlet("*.패턴") 형식으로 지정
// "/myServlet2" 서블릿 요청이 발생하면 현재 클래스가 실행되도록 어노테이션을 사용한 매핑 수행
@WebServlet("/myServlet2")
public class TestMyServlet2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestMyServlet2 - doGet()");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestMyServlet2 - doPost()");
	}
	
}
