import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ServletLifeCycle")
public class Test4ServletLifeCycle extends HttpServlet {
	// 서블릿 라이프 사이클
	// init() -> service() -> doGet() 또는 doPost() -> destroy()
	// => 이 때, init() 은 서블릿 클래스가 최초로 1회 실행될 때 한 번만 실행됨
	// => destroy() 메서드는 서버 종료 시 마지막으로 1회 실행됨
	
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Test4ServletLifeCycle - doGet()");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("Test4ServletLifeCycle - doPost()");
	}

	@Override
	public void init() throws ServletException {
		// 서블릿 클래스에 대한 요청 시 가장 먼저 자동으로 호출됨
		// => 서블릿 클래스에 대한 인스턴스 생성 후 인스턴스 초기화 목적으로 호출됨
		// => 서블릿 라이프 사이클 상에서 첫 요청에 대해 최초 1회만 실행됨(= 서버 중지 전까지)
		System.out.println("init() 메서드 호출됨!");
		super.init();
	}
	
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// init() 메서드가 호출된 후 자동으로 호출됨
		// => 서블릿 클래스로 생성된 인스턴스 내에서 쓰레드(Thread, 나중에 배움)가 1개 생성됨
		// => 요청이 발생할 때마다(= 서블릿이 호출될 때마다) 매번 호출됨
		//    즉, 매번 쓰레드가 1개씩 생성됨
		System.out.println("service() 메서드 호출됨!");
		super.service(req, resp);
	}

	@Override
	public void destroy() {
		// 서비스(= 톰캣 서버)가 중지(= 종료)될 때 자동으로 호출됨
		// => 자바 콘솔에서는 기본 상태에서 확인 불가
		System.out.println("destroy() 메서드 호출됨!");
		super.destroy();
	}

	
	
	
}
















