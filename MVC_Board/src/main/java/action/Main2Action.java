package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.Main2Service;
import vo.ActionForward;
import vo.BoardBean;

public class Main2Action implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("Main2Action");
		
		ActionForward forward = null;
		
		// 최근 글 목록 5개 조회(날짜 기준 정렬 가장 최근 게시물 5개)
		// Main2Service - getRecentlyBoardList() 메서드 호출
		// => 파라미터 : 없음   리턴타입 : List<BoardBean>
		// => BoardDAO - selectRecentlyBoardList() 요청
		Main2Service service = new Main2Service();
		List<BoardBean> boardList = service.getRecentlyBoardList();
		
		System.out.println(boardList);
		
		// 조회 결과를 request 객체에 저장 후
		// index2.jsp 페이지로 포워딩(디스패치)
		request.setAttribute("boardList", boardList);
		
		forward = new ActionForward();
		forward.setPath("index2.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}













