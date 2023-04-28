import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/dispatchServlet")
public class Test7DispatchServlet extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Test7DispatchServlet - doGet()");
		
		String id = request.getParameter("id");
		String passwd = request.getParameter("passwd");
		System.out.println(id + ", " + passwd);
		
		// -----------------------------------------------------------------------------
		// 현재 서블릿 클래스에서 작업 완료 후 test7_dispatch_result.jsp 페이지로 포워딩
		// => Dispatch 방식 포워딩 수행
		// 1. request 객체의 getRequestDispatcher() 메서드 호출
		//    => 파라미터 : 포워딩 할 페이지(URL) 
		//       리턴타입 : javax.servlet.RequestDispatcher
		RequestDispatcher dispatcher = request.getRequestDispatcher("test7_dispatch_result.jsp");
		
		// 2. 리턴받은 RequestDispatcher 객체의 forward() 메서드 호출하여 포워딩 작업 수행
		//    => 파라미터 : 이전 요청에서 사용된 request, response 객체
		dispatcher.forward(request, response);
		
		// Dispatch 방식 포워딩 특징
		// 1. 포워딩 시 지정한 URL(주소)가 웹브라우저 주소표시줄에 표시되지 않고
		//    이전의 요청 주소가 그대로 유지됨(즉, 주소표시줄 주소가 변경되지 않음)
		//    => http://localhost:8080/StudyServlet/dispatchServlet 주소가 그대로 남아있음
		//    => 결국, 클라이언트(웹브라우저)에서는 포워딩 여부를 알 수 없다!
		// 2. 이전 요청 시 생성된 request 객체를 포워딩 시점에서 함께 전달하므로
		//    포워딩 후에도 기존 request 객체가 그대로 유지됨
		//    따라서, 원래 저장되어 있던 파라미터 등의 데이터도 그대로 유지됨
		//    (= 포워딩 된 새 페이지에서 공유됨)
	}

//	@Override
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		
//	}
	
}










