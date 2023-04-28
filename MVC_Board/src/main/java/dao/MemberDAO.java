package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import db.JdbcUtil;
import vo.AuthInfoBean;
import vo.MemberBean;

/*
 * 실제 비즈니스 로직을 수행하는 DAO 클래스 정의
 * => 각 Service 클래스의 객체에서 DAO 객체에 접근할 때 고유 데이터가 불필요하므로
 *    (즉, 각 객체별로 저장되는 데이터를 별도로 관리할 필요가 없으므로)
 *    DAO 객체를 단 하나만 생성하고, Service 클래스에서 공유하도록
 *    싱글톤 디자인 패턴(Singleton Design Pattern)을 적용하여 클래스를 정의하면
 *    메모리를 효율적으로 사용할 수 있다!
 */
public class MemberDAO {
	/*
	 * -------- 싱글톤 디자인 패턴을 활용한 DAO 인스턴스 생성 및 리턴 작업 ----------
	 * 1. 외부에서 인스턴스 생성이 불가능하도록 생성자를 private 접근제한자로 지정
	 * 2. 자신의 클래스 내에서 직접 인스턴스를 생성하여 멤버변수에 저장
	 *    => 유일한 인스턴스가 되어야 하며, 인스턴스 생성 없이도 변수에 접근 가능하도록
	 *       멤버변수를 static 변수로 선언
	 *    => 외부에서 접근하여 멤버변수 값을 변경할 수 없도록 private 접근제한자로 지정
	 * 3. 생성된 인스턴스를 외부로 리턴하는 Getter 메서드 정의
	 *    => 인스턴스 생성 없이 클래스가 메모리에 로딩될 때 함께 로딩되도록
	 *       static 메서드로 선언(static 변수인 instance 에 접근하기 위해 static 메서드로 정의)
	 *    => 누구나 접근할 수 있도록 public 접근제한자로 지정
	 */
	private MemberDAO() {}
	
	private static MemberDAO instance = new MemberDAO();
	
	public static MemberDAO getInstance() {
		return instance;
	}

	// ------------------------------------------------------------------------------
	// Connection 타입 멤버변수 선언 및 Setter 정의
	// => 외부(Service 클래스)로부터 Connection 객체를 전달받아 저장해두기 위함
	private Connection con;
	
	public void setConnection(Connection con) {
		this.con = con;
	}
	// ------------------------------------------------------------------------------

	// 회원 가입 작업을 위한 insertMember() 메서드 정의
	// => 파라미터 : MemberBean 객체(member)   리턴타입 : int(insertCount)
	public int insertMember(MemberBean member) {
		System.out.println("MemberDAO - insertMember()");
		
		int insertCount = 0;
		
		// Connection 객체 가져오기
//		Connection con = JdbcUtil.getConnection();
		// => Service 클래스가 관리하므로 DAO 클래스에서는 Connection 객체 사용만 해야한다!
		//    Connection 객체를 전달받아 저장할 setConnection() 메서드를 통해 객체 저장 후
		//    각 작업을 수행하는 메서드에서는 해당 멤버변수에 접근해여 Connection 객체 사용
		
		// PreparedStatement 타입 변수 선언
		PreparedStatement pstmt = null;
		
		try {
			// mvc_board3.member 테이블에 회원 정보 INSERT
			// => 단, 회원번호(idx)는 null 값 전달 시 AUTO_INCREMENT 속성에 의해 번호 자동 증가
			//    가입일(date)은 데이터베이스의 now() 함수 활용, 
			//    인증상태(auth_status)는 기본값 "N" 으로 설정
			String sql = "INSERT INTO member VALUES (null, ?, ?, ?, ?, ?, now(), ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getId());
			pstmt.setString(3, member.getPasswd());
			pstmt.setString(4, member.getEmail());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, "N");
			
			System.out.println(pstmt);
			
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 - insertMember()");
			e.printStackTrace();
		} finally {
			// 자원 반환
			JdbcUtil.close(pstmt);
			
			// 주의! DAO 객체에서 Connection 객체 반환 금지! => Service 객체가 반환하기 때문
//			JdbcUtil.close(con);
		}
		
		return insertCount; // MemberJoinProService 로 리턴
		
	}

	// 로그인 판별 작업을 위한 selectCorrectUser() 메서드 정의
	public boolean selectCorrectUser(MemberBean member) {
		boolean isLoginSuccess = false;
		
		// PreparedStatement, ResultSet 타입 변수 선언
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// SELECT 구문을 사용하여 아이디와 패스워드가 일치하는 레코드 조회
			// => 조회 결과가 있을 경우 로그인 성공 표시로 isLoginSuccess 를 true 로 변경
			String sql = "SELECT * FROM member WHERE id = ? AND passwd = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());
			
			rs = pstmt.executeQuery();
			
			// 조회 결과가 있을 경우 isLoginSuccess 를 true 로 변경
			if(rs.next()) {
				isLoginSuccess = true;
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - selectCorrectUser()");
			e.printStackTrace();
		} finally {
			// 자원 반환(단, Connection 객체 반환 금지)
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return isLoginSuccess; // MemberLoginProService 로 리턴
	}

	// 회원 목록 조회 작업을 수행하는 selectMemberList() 메서드 정의
	public List<MemberBean> selectMemberList() {
		List<MemberBean> memberList = null;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 전체 회원 목록을 조회하는 SQL 구문 작성
			String sql = "SELECT * FROM member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// 조회 결과를 반복을 통해 List<MemberBean> 객체에 저장
			// => 단, 반복문 실행 전 전체 레코드를 저장하는 List 객체 생성 필요
			memberList = new ArrayList<MemberBean>();
			
			while(rs.next()) {
				// 1개 레코드를 저장할 MemberBean 객체 생성
				MemberBean member = new MemberBean();
				member.setIdx(rs.getInt("idx"));
				member.setName(rs.getString("name"));
				member.setId(rs.getString("id"));
				member.setEmail(rs.getString("email"));
				member.setGender(rs.getString("gender"));
				member.setDate(rs.getDate("date"));
				
				// 전체 레코드를 저장하는 List 객체에 1개 레코드가 저장된 MemberBean 객체 저장
				memberList.add(member);
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - selectMemberList()");
			e.printStackTrace();
		} finally {
			// 자원 반환
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return memberList; // AdminMemberListService 로 리턴
	}
	
	// 아이디 중복 체크
	public boolean selectId(String id) {
		boolean isDuplicate = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// member 테이블의 id 가 일치하는 레코드 조회 - SELECT
			// => 조회 결과가 있을 경우 isDuplicate 변수값을 true 로 변경
			String sql = "SELECT * FROM member WHERE id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				isDuplicate = true; // 중복이라고 표시
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return isDuplicate;
	}

	// 이메일 인증 여부 판별
	// => 파라미터 : MemberBean 객체   리턴타입 : boolean(isAuthenticatedUser)
	public boolean selectAuthStatus(MemberBean member) {
		boolean isAuthenticatedUser = false;
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 아이디에 해당하는 인증상태(auth_status) 조회
//			String sql = "SELECT auth_status FROM member WHERE id = ?";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, member.getId());
//			
//			if(rs.next()) {
//				if(rs.getString(1).equals("Y")) { // auth_status 컬럼이 "Y" 일 경우
//					isAuthenticatedUser = true; // 인증상태를 true 로 변경
//				}
//			}
			
			// 아이디가 일치하고 인증상태가 "Y" 인 레코드 조회
			String sql = "SELECT * FROM member WHERE id = ? AND auth_status = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, "Y");
			
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 조회 레코드가 있을 경우
				isAuthenticatedUser = true; // 인증상태를 true 로 변경
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
		}
		
		return isAuthenticatedUser;
	}
	
	// 인증 정보 등록
	public int insertAuthInfo(AuthInfoBean authInfo) {
		int insertCount = 0;
		
		PreparedStatement pstmt = null, pstmt2 = null;
		ResultSet rs = null;
		
		try {
			// 아이디에 해당하는 레코드 검색 - SELECT
			// => 아이디가 존재할 경우 아이디에 해당하는 기존 인증 코드 수정 - UPDATE
			// => 아이디가 존재하지 않을 경우 아이디와 새 인증 코드 등록 - INSERT
			// => 둘 중 하나라도 실행되면 결과값을 insertCount 에 저장
			String sql = "SELECT * FROM auth_info WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, authInfo.getId());
			rs = pstmt.executeQuery();
			
			if(rs.next()) { // 기존 인증 정보가 존재할 경우(아이디 없음) - UPDATE
				sql = "UPDATE auth_info SET auth_code = ? WHERE id = ?";
				pstmt2 = con.prepareStatement(sql);
				pstmt2.setString(1, authInfo.getAuth_code());
				pstmt2.setString(2, authInfo.getId());
			} else { // 기존 인증 정보가 존재하지 않을 경우(아이디 있음) - INSERT
				sql = "INSERT INTO auth_info VALUES (?, ?)";
				pstmt2 = con.prepareStatement(sql);
				pstmt2.setString(1, authInfo.getId());
				pstmt2.setString(2, authInfo.getAuth_code());
			}
			
			// UPDATE 또는 INSERT 구문 공통 실행
			insertCount = pstmt2.executeUpdate();
			
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - insertAuthInfo()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(pstmt2);
		}
		
		return insertCount;
	}
	
}





















