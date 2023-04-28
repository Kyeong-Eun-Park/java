package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.JdbcUtil;
import vo.AuthInfoBean;
import vo.BoardBean;

public class BoardDAO {
	// 싱글톤 디자인 패턴을 활용한 BoardDAO 인스턴스 관리
	private BoardDAO() {}
	
	private static BoardDAO instance = new BoardDAO();

	public static BoardDAO getInstance() {
		return instance;
	}
	
	// ----------------------------------------------------------------------
	// 외부(Service)로부터 Connection 객체를 전달받아 멤버변수 con 에 저장
	private Connection con;

	public void setConnection(Connection con) {
		this.con = con;
	}
	// ----------------------------------------------------------------------
	// 글쓰기 작업을 수행할 insertBoard() 메서드 정의
	// => 파라미터 : BoardBean 객체(board)   리턴타입 : int(insertCount)
	public int insertBoard(BoardBean board) {
		int insertCount = 0;
		
		PreparedStatement pstmt = null;
		PreparedStatement pstmt2 = null;
		ResultSet rs = null;
		
		try {
			// board 테이블의 게시물 번호 중 가장 큰 번호 조회 후 새 글 번호 결정(+1)
			int board_num = 1;
			String sql = "SELECT MAX(board_num) FROM board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// 기존 게시물이 존재하여 최대 번호가 조회되었을 경우
			if(rs.next()) {
				// 새 글 번호(board_num) = 현재 최대 글 번호 + 1
				board_num = rs.getInt(1) + 1;
			}
			
			// 전달받은 게시물 정보(BoardBean 객체)를 사용하여 INSERT 작업 수행
			// => 참조글번호(board_re_ref) 값은 새 글 번호와 동일한 번호로 지정
			// => 들여쓰기레벨(board_re_lev) 값과 순서번호(board_re_seq) 값은 기본값 0으로 지정
			sql = "INSERT INTO board VALUES (?,?,?,?,?,?,?,?,?,?,now())";
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setInt(1, board_num); // 글번호
			pstmt2.setString(2, board.getBoard_name()); // 작성자
			pstmt2.setString(3, board.getBoard_pass()); // 패스워드
			pstmt2.setString(4, board.getBoard_subject()); // 제목
			pstmt2.setString(5, board.getBoard_content()); // 내용
			pstmt2.setString(6, board.getBoard_file()); // 파일명
			pstmt2.setInt(7, board_num); // 참조글번호(board_re_ref)
			pstmt2.setInt(8, 0); // 들여쓰기레벨(board_re_lev)
			pstmt2.setInt(9, 0); // 순서번호(board_re_seq)
			pstmt2.setInt(10, 0); // 조회수
			
			// INSERT 구문 실행 후 리턴값을 insertCount 변수에 저장
			insertCount = pstmt2.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - insertBoard()");
			e.printStackTrace();
		} finally {
			// 자원 반환
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(pstmt2);
		}
		
		return insertCount;
	}
	
	// 글목록 조회 작업 수행하는 selectBoardList() 메서드 정의
	// => 파라미터 : 시작행번호, 조회할목록갯수   리턴타입 : List<BoardBean>(boardList)
	public List<BoardBean> selectBoardList(int startRow, int listLimit) {
		List<BoardBean> boardList = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// board 테이블의 모든 레코드 조회
			// => 정렬 기준 : 참조글번호(board_re_ref) 기준 내림차순, 
			//                순서번호(board_re_seq) 기준 오름차순
			// => 조회 시작 레코드 행번호(startRow) 부터 표시할 목록 갯수(listLimit) 만큼만 조회
			String sql = "SELECT * "
							+ "FROM board "
							+ "ORDER BY board_re_ref DESC, board_re_seq ASC "
							+ "LIMIT ?,?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, startRow);
			pstmt.setInt(2, listLimit);
			rs = pstmt.executeQuery();
			
			// 조회 결과를 반복문을 통해 저장
			// => 단, 반복 전 전체 게시물 목록이 저장될 List 객체 생성
			boardList = new ArrayList<BoardBean>();
			
			while(rs.next()) {
				// 1개 레코드를 저장할 BoardBean 객체(board) 생성 후 레코드 저장
				BoardBean board = new BoardBean();
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_name(rs.getString("board_name"));
//				board.setBoard_pass(rs.getString("board_pass"));
				board.setBoard_subject(rs.getString("board_subject"));
//				board.setBoard_content(rs.getString("board_content"));
//				board.setBoard_file(rs.getString("board_file"));
				board.setBoard_re_ref(rs.getInt("board_re_ref"));
				board.setBoard_re_lev(rs.getInt("board_re_lev"));
				board.setBoard_re_seq(rs.getInt("board_re_seq"));
				board.setBoard_readcount(rs.getInt("board_readcount"));
				board.setBoard_date(rs.getTimestamp("board_date"));
				
				// 1개 레코드 저장 확인
//				System.out.println(board);
				
				// 전체 목록을 저장하는 List 객체에 1개 레코드가 저장된 BoardBean 객체 추가
				boardList.add(board);
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - selectBoardList()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return boardList;
	}
	
	// 총 게시물 수 조회를 수행하는 selectBoardListCount() 메서드 정의
	// => 파라미터 : 없음   리턴타입 : int(listCount)
	public int selectBoardListCount() {
		int listCount = 0;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// board 테이블의 전체 레코드 수 조회 = COUNT() 함수 활용
			String sql = "SELECT COUNT(*) FROM board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				listCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - selectBoardListCount()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return listCount;
	}
	
	// 글 상세 정보 조회
	// => 파라미터 : 글번호   리턴타입 : BoardBean(board)
	public BoardBean selectBoard(int board_num) {
		BoardBean board = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 글번호(board_num)가 일치하는 레코드 조회
			String sql = "SELECT * FROM board WHERE board_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				// BoardBean 객체(board) 생성 후 조회 결과 저장
				board = new BoardBean();
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_name(rs.getString("board_name"));
//				board.setBoard_pass(rs.getString("board_pass"));
				board.setBoard_subject(rs.getString("board_subject"));
				board.setBoard_content(rs.getString("board_content"));
				board.setBoard_file(rs.getString("board_file"));
				board.setBoard_re_ref(rs.getInt("board_re_ref"));
				board.setBoard_re_lev(rs.getInt("board_re_lev"));
				board.setBoard_re_seq(rs.getInt("board_re_seq"));
				board.setBoard_readcount(rs.getInt("board_readcount"));
				board.setBoard_date(rs.getTimestamp("board_date"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - selectBoard()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return board;
	}
	
	// 조회수 증가
	public int updateReadcount(int board_num) {
		int updateCount = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			// 글번호에 해당하는 레코드의 readcount 값을 1만큼 증가 - UPDATE
			String sql = "UPDATE board "
							+ "SET board_readcount = board_readcount + 1 "
							+ "WHERE board_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - updateReadcount()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return updateCount;
	}
	
	// 게시물 본인 확인(패스워드 일치 여부 판별)
	public boolean isBoardWriter(int board_num, String board_pass) {
		boolean isBoardWriter = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			// 글번호에 해당하는 패스워드를 조회한 후 별도로 패스워드 일치 여부 판별할 경우
//			String sql = "SELECT board_pass FROM board WHERE board_num = ?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setInt(1, board_num);
//			rs = pstmt.executeQuery();
//			
//			// 만약, 조회된 패스워드와 입력된 패스워드가 같을 경우
//			// isBoardWriter 변수값을 true 로 변경
//			if(rs.next()) {
//				if(rs.getString("board_pass").equals(board_pass)) {
//					isBoardWriter = true;
//				}
//			}
			// ------------------------------------------------------------
			// 글번호와 패스워드가 일치하는 게시물을 조회
			String sql = "SELECT * FROM board "
								+ "WHERE board_num = ? AND board_pass = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			pstmt.setString(2, board_pass);
			rs = pstmt.executeQuery();
			
			// 만약, 조회 결과가 있을 경우 isBoardWriter 변수값을 true 로 변경
			if(rs.next()) {
				isBoardWriter = true;
			}
			
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - isBoardWriter()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return isBoardWriter;
	}
	
	// 글 삭제
	public int deleteBoard(int board_num) {
		int deleteCount = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			String sql = "DELETE FROM board WHERE board_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, board_num);
			deleteCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - deleteBoard()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return deleteCount;
	}
	
	// 글 수정
	public int updateBoard(BoardBean board) {
		int updateCount = 0;
		
		PreparedStatement pstmt = null;
		
		try {
			// board 테이블의 글번호가 일치하는 레코드의 작성자, 제목, 내용 수정 - UPDATE
			String sql = "UPDATE board "
							+ "SET board_name = ?, board_subject = ?, board_content = ? "
							+ "WHERE board_num = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, board.getBoard_name());
			pstmt.setString(2, board.getBoard_subject());
			pstmt.setString(3, board.getBoard_content());
			pstmt.setInt(4, board.getBoard_num());
			
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - updateBoard()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(pstmt);
		}
		
		return updateCount;
	}
	
	// 답글 쓰기
	public int insertReplyBoard(BoardBean board) {
		int insertCount = 0;
		
		PreparedStatement pstmt = null, pstmt2 = null, pstmt3 = null;
		ResultSet rs = null;
		
		try {
			// 새 글 번호 계산을 위한 가장 큰 글번호 조회
			// => 조회 결과 있을 경우 글번호 + 1 값을 새 글 번호로 설정
			int board_num = 1; // 새 글 번호
			
			String sql = "SELECT MAX(board_num) FROM board";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				board_num = rs.getInt(1) + 1;
			}
			
			// ------------------------------------------------------------
			int ref = board.getBoard_re_ref(); // 원본 글의 참조글번호
			int lev = board.getBoard_re_lev(); // 원본 글의 들여쓰기레벨
			int seq = board.getBoard_re_seq(); // 원본 글의 순서번호
			
			// 기존 답글들에 대한 순서번호 증가 - UPDATE
			// => 원본글의 참조글번호(board_re_ref)와 같고
			//    원본글의 순서번호(board_re_seq) 보다 큰 레코드들의
			//    순서번호를 1씩 증가시키기
			sql = "UPDATE board "
						+ "SET "
							+ "board_re_seq = board_re_seq + 1 "
						+ "WHERE "
							+ "board_re_ref = ? "
							+ "AND board_re_seq > ?";			
			pstmt2 = con.prepareStatement(sql);
			pstmt2.setInt(1, ref);
			pstmt2.setInt(2, seq);
			pstmt2.executeUpdate();
			
			// 새 답글에 사용될 원본글의 lev, seq 값 + 1 처리
			lev++;
			seq++;
			
			// -----------------------------------------------------------
			// 답글 INSERT
			// => 글쓰기와 달리 ref, lev, seq 값은 별도로 설정된 값 사용
			sql = "INSERT INTO board VALUES (?,?,?,?,?,?,?,?,?,?,now())";
			pstmt3 = con.prepareStatement(sql);
			pstmt3.setInt(1, board_num); // 글번호
			pstmt3.setString(2, board.getBoard_name()); // 작성자
			pstmt3.setString(3, board.getBoard_pass()); // 패스워드
			pstmt3.setString(4, board.getBoard_subject()); // 제목
			pstmt3.setString(5, board.getBoard_content()); // 내용
			pstmt3.setString(6, board.getBoard_file()); // 파일명
			pstmt3.setInt(7, ref); // 참조글번호(board_re_ref) - 기본 글쓰기와 다름
			pstmt3.setInt(8, lev); // 들여쓰기레벨(board_re_lev) - 기본 글쓰기와 다름
			pstmt3.setInt(9, seq); // 순서번호(board_re_seq) - 기본 글쓰기와 다름
			pstmt3.setInt(10, 0); // 조회수
			
			insertCount = pstmt3.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - insertReplyBoard()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(pstmt2);
			JdbcUtil.close(pstmt3);
		}
		
		return insertCount;
	}
	
	// 최근 게시물 목록 5개 조회
	public List<BoardBean> selectRecentlyBoardList() {
		List<BoardBean> boardList = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// board 테이블의 레코드를 날짜 기준 내림차순 정렬하여 5개 조회
			String sql = "SELECT * FROM board "
								+ "ORDER BY board_date DESC "
								+ "LIMIT 5";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// 전체 레코드를 저장할 ArrayList 객체 생성
			boardList = new ArrayList<BoardBean>();
			
			while(rs.next()) {
				// 1개 레코드를 저장할 BoardBean 객체(board) 생성 후 레코드 저장
				BoardBean board = new BoardBean();
				board.setBoard_num(rs.getInt("board_num"));
				board.setBoard_name(rs.getString("board_name"));
//				board.setBoard_pass(rs.getString("board_pass"));
				board.setBoard_subject(rs.getString("board_subject"));
//				board.setBoard_content(rs.getString("board_content"));
//				board.setBoard_file(rs.getString("board_file"));
//				board.setBoard_re_ref(rs.getInt("board_re_ref"));
//				board.setBoard_re_lev(rs.getInt("board_re_lev"));
//				board.setBoard_re_seq(rs.getInt("board_re_seq"));
//				board.setBoard_readcount(rs.getInt("board_readcount"));
				board.setBoard_date(rs.getTimestamp("board_date"));
				
				// 1개 레코드 저장 확인
//				System.out.println(board);
				
				// 전체 목록을 저장하는 List 객체에 1개 레코드가 저장된 BoardBean 객체 추가
				boardList.add(board);
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - selectRecentlyBoardList()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return boardList;
	}
	
	
	
	
}














