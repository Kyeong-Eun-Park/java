import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
 * 복수개의 서블릿 주소 요청을 하나의 서블릿 클래스에서 매핑하는 방법
 * 1. 중괄호{} 를 사용하여 서블릿 주소 복수개를 콤마로 구분하여 기술하는 방법
 *    @WebServlet({"/서블릿주소1", "/서블릿주소2", ...생략..., "/서블릿주소n"})
 * 2. 패턴을 지정하여 해당 패턴에 일치하는 모든 주소를 매핑시키는 방법
 *    @WebServlet("*.패턴")
 */

// myServlet6-1.do, myServlet6-2.do 서블릿 주소 2개만 묶음으로 처리할 경우
//@WebServlet({"/myServlet6-1.do", "/myServlet6-2.do"})

// 모든 주소가 xxx.do 로 끝날 때 .do 를 패턴으로 지정하여 처리할 경우
@WebServlet("*.do")
public class TestMyServlet6 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestMyServlet6 - doGet()");
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("TestMyServlet6 - doPost()");
	}
	
}






