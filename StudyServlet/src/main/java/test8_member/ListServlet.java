package test8_member;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/List")
public class ListServlet extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("ListServlet - doGet()");
		
		// MemberDAO 객체 생성 후 selectMemberList() 메서드 호출하여 회원 목록 조회 작업 요청
		// => 파라미터 : 없음   리턴타입 : List<MemberDTO>(memberList)
		MemberDAO dao = new MemberDAO();
		List<MemberDTO> memberList = dao.selectMemberList();
//		System.out.println(memberList);
		
		// 포워딩 시 함께 전달될 request 객체에 조회 결과인 List 객체(memberList) 저장
		// => request 객체의 setAttribute() 메서드 활용
		request.setAttribute("memberList", memberList);
		
		// test8_member/member_list.jsp 페이지로 포워딩 - Redirect 방식
//		response.sendRedirect("test8_member/member_list.jsp");
		
		// Dispatch 방식 포워딩
		// => URL 이 변경되지 않고, request 객체가 유지됨
		RequestDispatcher dispatcher = 
				request.getRequestDispatcher("test8_member/member_list.jsp");
		dispatcher.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}
}













