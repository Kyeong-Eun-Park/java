import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/test5/myServlet")
public class TestMyServlet5 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestMyServlet5 - doGet()");
		
		// doGet() 메서드 파라미터로 HttpServletRequest, HttpServletResponse 객체가 자동 전달됨
		// => JSP 페이지에서 사용하던 내장 객체 request, response 와 동일한 객체
		// test5.jsp 페이지로부터 전달받은 폼 파라미터 데이터(이름, 나이) 가져와서 출력하기
		// => request 객체의 getParameter() 메서드 활용
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		
		// test5_result.jsp 페이지로 포워딩(이동)
		// response 객체의 sendRedirect() 메서드를 호출하여 포워딩 수행
//		response.sendRedirect("test5_result.jsp");
		// 주의! webapp 폴더에 있는 test5_result.jsp 페이지로 포워딩하려 할 경우
		// 현재 서블릿 주소를 담고 있는 경로가 "/StudyServlet/test5/myServlet" 일 때
		// "/StudyServlet/test5/test5_result.jsp" 주소로 리다이렉트 되며
		// webapp 폴더 내의 test5 폴더 내에 있는 test5_result.jsp 페이지를 요청하게 된다.
		// 그러나, 실제 파일은 webapp 폴더에 위치하므로 HTTP 404 오류가 발생한다!
		// ---------------------------------------------------------------------------------
		// 방법1) test5_result.jsp 페이지 지정 시 상대 주소 형식으로 상위 디렉토리를 지정
//		response.sendRedirect("../test5_result.jsp"); // test5 의 상위 디렉토리를 지정
		// http://localhost:8080/StudyServlet/test5/test5_result.jsp 주소가 아닌
		// http://localhost:8080/StudyServlet/test5_result.jsp 주소로 리다이렉트 됨(정상 실행)
		// ---------------------------------------------------------------------------------
		// 방법2) jsp 파일의 구조를 실제 요청 주소 구조로 설계(생성)
		// 컨텍스트 루트(StudyServlet) 가 webapp 폴더이므로
		// webapp 폴더 하위에 test5 폴더를 생성하고 test5_result.jsp 파일을 위치시킴
		response.sendRedirect("test5_result.jsp");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestMyServlet5 - doPost()");
		
		// test5.jsp 페이지로부터 전달받은 폼 파라미터 데이터(이름, 나이) 가져와서 출력하기
		// => 단, POST 방식 요청의 경우 한글 파라미터 처리를 위한 설정 필수!
		request.setCharacterEncoding("UTF-8");
		
		String name = request.getParameter("name");
		int age = Integer.parseInt(request.getParameter("age"));
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		
		response.sendRedirect("../test5_result.jsp"); // test5 의 상위 디렉토리를 지정
	}
	
}











