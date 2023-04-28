import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/redirectServlet")
public class Test7RedirectServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Test7RedirectServlet - doGet()");
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		System.out.println(id + ", " + passwd);
		
		// -----------------------------------------------------------------------------
		// 현재 서블릿 클래스에서 작업 완료 후 test7_redirect_result.jsp 페이지로 포워딩
		// => 리다이렉트 방식 포워딩 수행
		// => response 객체의 sendRedirect() 메서드를 호출하여 포워딩 할 URL 전달
		// => 현재 서블릿 주소 : http://localhost:8080/StudyServlet/redirectServlet
		//    (컨텍스트 루트에서 실행중인 서블릿이므로 현재 위치가 webapp 폴더와 같다)
		//    (즉, webapp/test7_redirect_result.jsp 페이지 지정)
		response.sendRedirect("test7_redirect_result.jsp");
		
		// Redirect 방식 포워딩 특징
		// 1. 포워딩 시 지정한 주소(URL)가 웹브라우저 주소 표시줄에 표시됨
		//    (즉, 새로 요청받은 새 주소(URL)로 변경됨)
		// => http://localhost:8080/StudyServlet/redirectServlet 주소에서
		//    http://localhost:8080/StudyServlet/test7_redirect_result.jsp 주소로 변경됨
		// 2. 이전 요청에서 생성된 request 객체가 유지되지 않음(= 새 request 객체가 생성됨)
		//    따라서, 이전 요청에서 저장되어 있던 파라미터는 더 이상 존재하지 않으므로
		//    새 페이지에서 이전 request 객체의 데이터에 접근 불가능함
		
	}

//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}
	
	
}
