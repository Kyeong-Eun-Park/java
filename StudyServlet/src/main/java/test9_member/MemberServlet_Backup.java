package test9_member;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import test8_member.MemberDAO;
import test8_member.MemberDTO;

// 서블릿 주소(URL) 패턴이 xxx.me 로 끝나는 모든 서블릿 주소 요청을 처리하는 서블릿 클래스
//@WebServlet("*.me")
public class MemberServlet_Backup extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공통으로 작업을 처리할 doProcess() 메서드 호출
		doProcess(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 공통으로 작업을 처리할 doProcess() 메서드 호출
		doProcess(request, response);
	}
	
	// GET 방식 요청과 POST 방식 요청을 하나로 처리하는 doProcess 메서드 정의
	// => 메서드 선언부는 이름을 제외하면 doGet(), doPost() 메서드와 동일
	// => doGet(), doPost() 메서드에서 doProcess() 메서드 호출
	protected void doProcess(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("MemberServlet");
		
		// POST 방식일 때 해당 요청에 대한 한글 인코딩 처리
		request.setCharacterEncoding("UTF-8");
		
		/*
		 * =============================================================================
		 * xxx.me 서블릿 주소 요청에 대한 하나의 서블릿 통합 완료했음
		 * 그러나, 각 서블릿 주소에 따라 서로 다른 작업을 수행해야한다.
		 * 이 때, 주소표시줄에 입력되어 있는 URL 에서 서블릿 주소 부분을 가져온 뒤
		 * 각 서블릿 주소를 구별하여 각각 수행해야할 동작을 결정해야한다.
		 * 따라서, 요청 정보가 저장된 request 객체에서 서블릿 주소 추출 필요함!
		 * ex) MemberList.me 와 MemberInfo.me 일 때의 동작이 다르므로
		 *     URL 에서 서블릿 주소(컨텍스트 경로(= 프로젝트명) 뒷부분의 xxx.me) 추출 후
		 *     문자열 비교를 통해 각 서블릿 주소 구별 작업을 수행해야함
		 */
		// 0. 참고) 요청 주소(URL) 정보 전체 추출(= 가져오기)
//		String requestURL = request.getRequestURL().toString();
//		System.out.println("requestURL : " + requestURL);
		// requestURL : http://localhost:8080/StudyServlet/MemberInfo.me
		// => 단, 서버마다 IP 주소(localhost) 또는 포트번호(8080) 등이 달라질 수 있으므로
		//    요청 URL 전체를 문자열로 판별하는 작업은 효율적이지 않다!
		
		// 1. 요청 주소 중 URI 부분(/프로젝트명/서블릿주소) 추출
//		String requestURI = request.getRequestURI();
//		System.out.println("requestURI : " + requestURI);
		
		// 2. 요청 주소 중 컨텍스트 경로(/프로젝트명) 추출
//		String contextPath = request.getContextPath();
//		System.out.println("contextPath : " + contextPath);
		
		// 3. 요청 주소 중 서블릿 주소 부분(/서블릿주소) 추출
		// => 1번, 2번 결과물(requestURI, contextPath) 을 가공하여 추출
		// 1) contextPath 에 해당하는 requestURI 의 문자열을 널스트링으로 치환
		//    => String 클래스의 replace(찾을문자열, 바꿀문자열) 메서드 활용
//		String command = requestURI.replace(contextPath, "");
//		System.out.println("command : " + command);
		
		// 2) "/서블릿주소" 부분에 대한 부분문자열 추출
		//    => String 클래스의 substring(추출할 시작인덱스) 메서드 활용
		//    => "/StudyServlet/MemberList.me" 주소 중 "/MemberList.me" 부분을 추출해야하므로
		//       "/StudyServlet" 문자열의 길이를 알아낸 뒤 
		//       substring() 메서드에 해당 길이를 시작인덱스로 활용하여 추출 가능
		//    ex) "/StudyServlet/MemberList.me" 문자열의 "/MemberList.me" 시작인덱스가 13 이고
		//        "/StudyServlet" 문자열의 길이(length() 메서드 활용)가 13이므로
		//        해당 문자열 길이를 시작인덱스로 활용하여 끝까지 문자열 추출
//		String command = requestURI.substring(contextPath.length());
//		System.out.println("command : " + command);
		// --------------------------------------------------------------------------------
		// 위의 1 ~ 3번 과정을 하나의 메서드로 통합하여 제공
		// => request 객체의 getServletPath() 메서드 활용
		String command = request.getServletPath();
		System.out.println("command : " + command);
		// --------------------------------------------------------------------------------
		// 추출된 서블릿 주소(command)를 문자열 비교를 통해 각 작업을 구별하고
		// 구별된 주소에 따른 액션(작업) 요청
		// => 주의! 서블릿 주소의 "/" 기호도 반드시 포함하여 비교해야함
		if(command.equals("/MemberMain.me")) {
//			System.out.println("메인페이지!");
			
			// test9_member/member_main.jsp 페이지로 포워딩(Dispatch)
			// 서블릿 -> 뷰페이지로 이동
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("test9_member/member_main.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/MemberJoinForm.me")) {
			// test9_member/join_form.jsp 페이지로 포워딩(Dispatch)
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("test9_member/join_form.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/MemberLoginForm.me")) {
			// test9_member/login_form.jsp 페이지로 포워딩(Dispatch)
			RequestDispatcher dispatcher = 
					request.getRequestDispatcher("test9_member/login_form.jsp");
			dispatcher.forward(request, response);
		} else if(command.equals("/MemberJoinPro.me")) {
			// join_form.jsp 페이지로부터 전달받은 폼 파라미터(회원 정보) 가져와서
			// MemberDTO 객체에 저장 후 MemberDAO 객체를 통해 회원 가입 비즈니스 로직 처리
			String name = request.getParameter("name");
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			String jumin = request.getParameter("jumin1") + "-" + request.getParameter("jumin2");
			String email = request.getParameter("email1") + "@" + request.getParameter("email2");
			String job = request.getParameter("job");
			String gender = request.getParameter("gender");
			String[] hobbies = request.getParameterValues("hobby");
			String hobby = ""; // 문자열 결합을 통해 취미를 하나로 묶을 변수 선언(실제 사용할 변수)
			for(String item : hobbies) {
				hobby += item + "/";
			}
			String motivation = request.getParameter("motivation");
			
			// MemberDTO 객체 생성 및 파라미터 데이터 저장
			MemberDTO member = new MemberDTO();
			member.setName(name);
			member.setId(id);
			member.setPasswd(passwd);
			member.setJumin(jumin);
			member.setEmail(email);
			member.setJob(job);
			member.setGender(gender);
			member.setHobby(hobby);
			member.setMotivation(motivation);
			
			// MemberDAO 객체 생성 후 insertMember() 메서드 호출하여 회원 가입 처리 요청
			// => 파라미터 : MemberDTO 객체(member)   리턴타입 : int(insertCount)
			MemberDAO dao = new MemberDAO();
			int insertCount = dao.insertMember(member);
			
			// 회원 가입 처리 결과 판별
			// => 성공 시 메인페이지로 포워딩
			// => 실패 시 자바스크립트를 사용하여 "회원 가입 실패!" 출력 후 이전 페이지로 돌아가기
			if(insertCount > 0) {
				// 리다이렉트 방식 포워딩
				response.sendRedirect("MemberMain.me");
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('회원 가입 실패!');");
				out.println("history.back();");
				out.println("</script>");
				out.flush();
			}
		} else if(command.equals("/MemberLoginPro.me")) {
			// login_form.jsp 페이지로부터 전달받은 로그인 정보를 가져와서
			// 회원 로그인 비즈니스 로직 처리
			String id = request.getParameter("id");
			String passwd = request.getParameter("passwd");
			
			// MemberDTO 객체(member) 생성 및 아이디, 패스워드 저장
			MemberDTO member = new MemberDTO();
			member.setId(id);
			member.setPasswd(passwd);
			
			// MemberDAO 객체 생성 및 isRightUser() 메서드 호출하여 아이디, 패스워드 판별 요청
			// => 파라미터 : MemberDTO 객체   리턴타입 : boolean(isRightUser)
			MemberDAO dao = new MemberDAO();
			boolean isRightUser = dao.isRightUser(member);
			
			// 요청 결과 판별
			// isRightUser 가 true 일 경우 세션 객체에 아이디를 속성명 "sId" 로 저장 후
			// 메인페이지(MemberMain)로 포워딩
			// 아니면, "로그인 실패" 출력
			if(isRightUser) {
				HttpSession session = request.getSession();
				session.setAttribute("sId", id);
				
				// 메인페이지로 포워딩(서블릿 -> 서블릿 이동이므로 리다이렉트 방식 포워딩)
				response.sendRedirect("MemberMain.me");
			} else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('로그인 실패!');");
				out.println("history.back();");
				out.println("</script>");
				out.flush();
			}
		} else if(command.equals("/MemberLogout.me")) {
			// 로그아웃 처리를 위한 비즈니스 로직 수행(DB 작업 없음)
			// 세션 객체 초기화 후 메인페이지로 포워딩
			HttpSession session = request.getSession();
			session.invalidate();
			
			// 서블릿 -> 서블릿 포워딩이므로 Redirect 방식
			response.sendRedirect("MemberMain.me");
		} else if(command.equals("/MemberList.me")) {
			// 글목록 조회 비즈니스 로직 수행 후 test9_member/member_list.jsp 페이지로 포워딩
			// 세션 아이디가 null 이거나 또는 널스트링이거나 또는 "admin" 이 아닐 경우
			// 자바스크립트를 사용하여 "잘못된 접근입니다!" 출력 후 메인페이지로 이동
			HttpSession session = request.getSession();
			String id = (String)session.getAttribute("sId");
			if(id == null || id.equals("") || !id.equals("admin")) {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>");
				out.println("alert('잘못된 접근입니다!');");
				out.println("location.href='MemberMain.me';");
				out.println("</script>");
				out.flush();
			} else {
				// MemberDAO 객체 생성 후 selectMemberList() 메서드 호출하여 회원 목록 조회 작업 요청
				// => 파라미터 : 없음   리턴타입 : List<MemberDTO>(memberList)
				MemberDAO dao = new MemberDAO();
				List<MemberDTO> memberList = dao.selectMemberList();
				
				// 포워딩 시 함께 전달될 request 객체에 조회 결과인 List 객체(memberList) 저장
				request.setAttribute("memberList", memberList);
				
				// Dispatch 방식 포워딩
				// => URL 이 변경되지 않고, request 객체가 유지됨
				RequestDispatcher dispatcher = 
						request.getRequestDispatcher("test9_member/member_list.jsp");
				dispatcher.forward(request, response);
			}
			
		} // 서블릿 주소 판별 끝
		
		// -------------------------------------------------------------------------------
		// 포워딩 작업(Dispatch vs Redirect) 코드 중복 제거를 위해
		// 서블릿 주소 판별 및 각종 작업이 끝난 후 별도의 블럭에서 통합된 포워딩 작업 수행
		
		// -------------------------------------------------------------------------------
		
	} // doProcess() 메서드 끝
	
}















