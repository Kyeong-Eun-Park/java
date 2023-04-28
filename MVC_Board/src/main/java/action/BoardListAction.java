package action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import svc.BoardListService;
import vo.ActionForward;
import vo.BoardBean;
import vo.PageInfo;

public class BoardListAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("BoardListAction");
		
		ActionForward forward = null;
		
		// BoardListService 객체를 통해 게시물 목록 조회 후
		// 조회 결과를 request 객체에 저장 후 board_list.jsp 페이지로 포워딩
		// -----------------------------------------------------------------------
		// 페이징 처리를 위해 조회 목록 갯수 조절 시 사용될 변수 선언
		int listLimit = 10; // 한 페이지에서 표시할 게시물 목록 갯수(10개로 제한)
		int pageNum = 1; // 현재 페이지 번호 설정(기본값 1, pageNum 파라미터 사용)
		
		// pageNum 파라미터가 존재할 경우 pageNum 변수값을 파라미터 값으로 교체
		if(request.getParameter("pageNum") != null) {
			if(!request.getParameter("pageNum").equals("")) { // 널스트링이 아니면 가져오기
				pageNum = Integer.parseInt(request.getParameter("pageNum"));
			}
		}
		
		// 조회 시작 행번호(startRow) 계산
		int startRow = (pageNum - 1) * listLimit; // 0, 10, 20...
		// -----------------------------------------------------------------------
		// BoardListService 클래스의 인스턴스 생성 후 
		// getBoardList() 메서드 호출하여 게시물 목록 조회 요청
		// => 파라미터 : 시작행번호, 조회할목록갯수    리턴타입 : List<BoardBean>(boardList)
		BoardListService service = new BoardListService();
		List<BoardBean> boardList = service.getBoardList(startRow, listLimit);
		// -----------------------------------------------------------------------
		// 페이징 처리를 위한 계산 작업
		// 한 페이지에서 표시할 페이지 목록(번호) 갯수 계산
		// 1. BoardListService - getBoardListCount() 메서드를 호출하여
		//    전체 게시물 수 조회(페이지 목록 갯수 계산에 사용)
		//    => 파라미터 : 없음   리턴타입 : int(listCount)
		int listCount = service.getBoardListCount();
//		System.out.println("총 게시물 수 : " + listCount);
		
		// 2. 한 페이지에서 표시할 페이지 목록 갯수 설정
		int pageListLimit = 3; // 페이지 목록 갯수를 3개로 제한
		
		// 3. 전체 페이지 목록 수 계산
		// => 전체 게시물 수를 목록 갯수로 나누고, 남은 나머지가 0보다 클 경우 페이지 수 + 1
		//    (페이지수 + 1 계산하기 위해 삼항연산자 활용)
		int maxPage = listCount / listLimit + (listCount % listLimit > 0 ? 1 : 0);
		
		// 4. 시작 페이지 번호 계산
		// => 페이지 목록 갯수가 3일 때
		//    1 ~ 3 페이지 사이일 경우 시작 페이지 번호 : 1
		//    4 ~ 6 페이지 사이일 경우 시작 페이지 번호 : 4
		int startPage = (pageNum - 1) / pageListLimit * pageListLimit + 1;
		
		// 5. 끝 페이지 번호 계산
		// => 시작 페이지 번호에 페이지 목록 갯수를 더한 후 - 1
		int endPage = startPage + pageListLimit - 1;
		
		// 만약, 끝 페이지 번호(endPage) 가 최대 페이지 번호(maxPage) 보다 클 경우
		// 끝 페이지 번호를 최대 페이지 번호로 교체
		if(endPage > maxPage) {
			endPage = maxPage;
		}
		
		// 페이징 처리 정보를 저장하는 PageInfo 클래스 인스턴스 생성 및 데이터 저장
		PageInfo pageInfo = new PageInfo(listCount, pageListLimit, maxPage, startPage, endPage);
//		System.out.println(pageInfo);
		// -----------------------------------------------------------------------
		// 글목록(List 객체)과 페이징정보(PageInfo 객체), 현재 페이지번호(pageNum)를 
		// request 객체에 저장
		request.setAttribute("boardList", boardList);
		request.setAttribute("pageInfo", pageInfo);
		request.setAttribute("pageNum", pageNum);
		
		// ActionForward 객체 생성 후 board/board_list.jsp 페이지 포워딩
		// => URL 및 request 객체 유지 = 디스패치
		forward = new ActionForward();
		forward.setPath("board/board_list.jsp");
		forward.setRedirect(false);
		
		return forward;
	}

}










