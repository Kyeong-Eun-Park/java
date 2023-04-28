import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 웹에서의 요청을 처리할 수 있는 서블릿 클래스 정의
 * - 클래스 정의 시 javax.servlet.http.HttpServlet 클래스 상속받아 정의
 * - 이 때, 서블릿 기능을 사용하려면 servlet-api.jar 라이브러리 필수
 *   => 톰캣 사용중일 경우 톰캣 라이브러리(Server Runtime) 내에 이미 내장되어 있음
 * - 서블릿 클래스에서 특정 서블릿 주소에 대한 요청을 처리하려면 서블릿 주소 매핑 필수!
 *   1) web.xml(배포서술자) 파일에 매핑 작업을 기술하는 방법
 *   2) 서블릿 클래스 선언부 상단에 @WebServlet 어노테이션을 사용하는 방법
 *      => @WebServlet("/서블릿주소") 또는 @WebServlet("*.패턴") 형식으로 지정
 *   => 서블릿 매핑 주소 지정 방법
 *      1) 단일 패턴 지정 : "/서블릿주소" 형태로 작성하고, 해당 패턴과 일치하는 URL 만 정확히 감지
 *                          단, 단일 패턴을 복수개 한꺼번에 지정도 가능함
 *      2) 다중 패턴 지정 : "*.패턴명" 형태로 작성하고
 *                          XXX.패턴명 형태로 패턴명에 해당하는 부분만 일치하면
 *                          복수개의 서로 다른 URL 을 모두 감지하여 매핑 가능함   
 */

// 서블릿 클래스 정의 시 javax.servlet.http.HttpServlet 클래스를 상속받아 정의
// => 이 클래스는 web.xml 파일 내에 매핑 작업을 통해 "/myServlet" 주소와 매핑되어 있음
//    즉, "/myServlet" 주소 요청이 발생하면 TestMyServlet 클래스 인스턴스가 생성되고 실행됨
public class TestMyServlet extends HttpServlet {

	// 서블릿 클래스 내에는 GET 또는 POST 방식 요청에 대한 처리를 위해
	// doGet(), doPost() 메서드를 정의
	// => HttpServlet 클래스로부터 상속받아 오버라이딩하여 정의
	// => HTTP 요청 메서드에 따라 doGet() 또는 doPost() 메서드가 자동 호출됨
	// => 만약, 둘 중 하나만 정의했을 경우 나머지 요청에 대한 처리가 불가능하여
	//    응답 메세지로 HTTP 상태 코드 405(허용되지 않는 메서드) 오류가 전달됨
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// GET 방식 요청이 발생했을 경우 자동으로 호출되는 메서드
		System.out.println("GET 방식 요청에 대한 doGet() 메서드 호출됨!");
	}
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// POST 방식 요청이 발생했을 경우 자동으로 호출되는 메서드
		System.out.println("POST 방식 요청에 대한 doPost() 메서드 호출됨!");
	}
	
}

















