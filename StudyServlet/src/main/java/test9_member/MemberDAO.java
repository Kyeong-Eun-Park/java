package test9_member;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

// study_jsp3.test4_member 테이블의 데이터 처리 작업을 담당하는 MemberDAO 클래스 정의
// => 데이터베이스 연결 및 해제 작업을 담당하는 메서드는 JdbcUtil 클래스로 모듈화 되어 있음
public class MemberDAO {
	
	// member 테이블의 회원 가입(INSERT) 작업을 수행하는 insertMember() 메서드 정의
	// => 파라미터 : 가입 시 입력한 정보(이름, 아이디, 패스워드, 주민번호, E-Mail, 직업, 성별, 취미, 가입동기)
	// => 리턴타입 : int(insertCount)
//	public int insertMember(String name, String id, String passwd, String jumin, String email, String job, String gender, String hobby, String motivation) {
//		// 리턴할 데이터를 저장할 변수 선언
//		int insertCount = 0;
//		
//		// DB 작업에 사용될 변수 선언
//		Connection con = null;
//		PreparedStatement pstmt = null;
//
//		try {
//			// 1단계 & 2단계. JdbcUtil 클래스의 getConnection() 메서드 호출
//			con = JdbcUtil.getConnection();
//			
//			// 3단계 & 4단계
//			// 전달받은 데이터를 데이터베이스에 추가(INSERT)
//			String sql = "INSERT INTO test4_member VALUES (null,?,?,?,?,?,?,?,?,?,now())";
//			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, name);
//			pstmt.setString(2, id);
//			pstmt.setString(3, passwd);
//			pstmt.setString(4, jumin);
//			pstmt.setString(5, email);
//			pstmt.setString(6, job);
//			pstmt.setString(7, gender);
//			pstmt.setString(8, hobby);
//			pstmt.setString(9, motivation);
//			System.out.println(pstmt);
//
//			insertCount = pstmt.executeUpdate();
//		} catch (SQLException e) {
//			System.out.println("SQL 구문 오류 발생! - insertMember()");
//			e.printStackTrace();
//		} finally {
//			// JdbcUtil 클래스의 close() 메서드를 호출하여 사용 완료된 자원 반환
//			// => try ~ catch 블록에서 예외 발생 여부와 관계없이 항상 실행됨!
//			JdbcUtil.close(pstmt);
//			JdbcUtil.close(con);
//		}
//		
//		return insertCount;
//	}
	// ----------------------------------------------------------------------
	// member 테이블의 회원 가입(INSERT) 작업을 수행하는 insertMember() 메서드 정의
	// => 파라미터 : 가입 시 입력한 정보 = MemberDTO 객체(member)
	// => 리턴타입 : int(insertCount)
	public int insertMember(MemberDTO member) {
		// INSERT 작업 실행 결과를 저장할 변수 선언
		int insertCount = 0;
		
		// DB 작업에 사용될 변수 선언(finally 블럭에서 자원 반환을 위해 try 문 밖에서 선언)
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			// 1단계 & 2단계. JdbcUtil 클래스의 getConnection() 메서드 호출하여 Connection 객체 얻기
			con = JdbcUtil.getConnection();
			
			// 3단계. SQL 구문 작성 및 전달
			String sql = "INSERT INTO test4_member VALUES (null,?,?,?,?,?,?,?,?,?,now())";
			pstmt = con.prepareStatement(sql);
			// 데이터베이스 작업에 사용될 데이터는 MemberDTO 객체에 저장되어 전달받았으므로
			// MemberDTO 객체의 Getter 메서드를 호출하여 데이터에 접근해야함
//			pstmt.setString(1, name); // 기존 방법(변수 그대로 사용 시)
			pstmt.setString(1, member.getName()); // MemberDTO 객체(member)의 name 값 전달
			pstmt.setString(2, member.getId());
			pstmt.setString(3, member.getPasswd());
			pstmt.setString(4, member.getJumin());
			pstmt.setString(5, member.getEmail());
			pstmt.setString(6, member.getJob());
			pstmt.setString(7, member.getGender());
			pstmt.setString(8, member.getHobby());
			pstmt.setString(9, member.getMotivation());
			System.out.println(pstmt); // 실행될 구문 확인
			
			// 4단계. SQL 구문 실행 및 결과 처리
			// => INSERT 구문 실행 시 리턴되는 값(int) 을 insertCount 변수에 저장 후 리턴
			insertCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - insertMember()");
			e.printStackTrace();
		} finally {
			// 사용 완료된 DB 자원 반환
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
		
		return insertCount;
	}
	
	
	// 회원 상세정보를 조회 후 조회 결과를 리턴하는 selectMemberInfo() 메서드 정의
	// => 파라미터 : 아이디(id)   리턴타입 : void
	public MemberDTO selectMemberInfo(String id) {
		// 조회된 회원 상세정보(= 1개 레코드)를 저장할 MemberDTO 타입 변수 선언
		MemberDTO member = null;
		
		// DB 작업에 사용될 변수 선언(finally 블럭에서 자원 반환을 위해 try 문 밖에서 선언)
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// 1단계 & 2단계. JdbcUtil 클래스의 getConnection() 메서드 호출하여 Connection 객체 얻기
			con = JdbcUtil.getConnection();
			
			// 3단계. SQL 구문 작성 및 전달
			String sql = "SELECT * FROM test4_member WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			System.out.println(pstmt);
			
			// 4단계. SQL 구문 실행 및 결과 처리
			rs = pstmt.executeQuery();
			
			// 조회 결과가 있을 경우
			if(rs.next()) {
				// 1개 레코드 정보를 저장할 MemberDTO 객체 생성
				member = new MemberDTO();
				// ResultSet 객체에 저장된 1개 레코드 데이터를 MemberDTO 객체에 저장
				// member.set변수명(rs.get데이터타입("컬럼명"))
				member.setIdx(rs.getInt("idx"));
				member.setName(rs.getString("name"));
				member.setId(rs.getString("id"));
				member.setPasswd(rs.getString("passwd"));
				member.setJumin(rs.getString("jumin"));
				member.setEmail(rs.getString("email"));
				member.setJob(rs.getString("job"));
				member.setGender(rs.getString("gender"));
				member.setHobby(rs.getString("hobby"));
				member.setMotivation(rs.getString("motivation"));
				member.setHire_date(rs.getDate("hire_date"));
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 실행 오류! - selectMemberInfo()");
			e.printStackTrace();
		} finally {
			// DB 자원 반환
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
		
		// 1개 회원 정보가 저장된 MemberDTO 객체 리턴
		// 조회 실패 시 객체 생성이 되지 않으므로 기본값인 null 값이 외부로 리턴됨
		return member;
	}
	
	// 로그인을 위한 판별 작업 수행하는 isRightUser() 메서드 정의
	// => 파라미터 : 아이디(id), 패스워드(passwd)    리턴타입 : boolean(isRightUser)
//	public boolean isRightUser(String id, String passwd) {
	// => 파라미터 : MemberDTO 객체(member) 로 변경
	public boolean isRightUser(MemberDTO member) {
		// 리턴값을 저장할 변수 선언(초기값 = false = 로그인 실패)
		boolean isRightUser = false;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			// SELECT 구문 실행 결과가 있을 경우 "로그인 성공", 아니면 "로그인 실패!" 출력
			con = JdbcUtil.getConnection();
			String sql = "SELECT id FROM test4_member WHERE id = ? AND passwd = ?";
			pstmt = con.prepareStatement(sql);
//			pstmt.setString(1, id);
//			pstmt.setString(2, passwd);
			pstmt.setString(1, member.getId());
			pstmt.setString(2, member.getPasswd());

			rs = pstmt.executeQuery();

			// 조회 결과 레코드가 1개 or 0개이므로 반복 불필요
			// => 따라서, if 문을 사용하여 판별하거나 while 문 판별도 무관함
			if(rs.next()) { // while(rs.next()) 도 동일(한 번 반복하고 끝남)
				// next() 메서드 리턴값이 true = 로그인 성공
				// isRightUser 변수값을 true 로 변경
				isRightUser = true;
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - loginMember()");
			e.printStackTrace();
		} finally {
			//자원 반환
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
		
		// 로그인 판별 작업 결과 리턴
		return isRightUser;
	}
	
	// 회원 정보 수정을 위한 updateMember() 메서드 정의
	// => 파라미터 : MemberDTO 객체(member)   리턴타입 : int(updateCount)
	public int updateMember(MemberDTO member) {
		// UPDATE 작업 수행 결과를 저장할 변수 선언
		int updateCount = 0;
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			con = JdbcUtil.getConnection();
			
			// UPDATE 구문을 실행하여 회원 정보 수정(이름, 주민번호, 이메일, 직업, 성별, 취미, 가입동기)
			String sql = "UPDATE test4_member " 
							+ "SET name = ?, jumin = ?, email = ?, job = ?, gender = ?, hobby = ?, motivation = ? " 
							+ "WHERE id = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, member.getName());
			pstmt.setString(2, member.getJumin());
			pstmt.setString(3, member.getEmail());
			pstmt.setString(4, member.getJob());
			pstmt.setString(5, member.getGender());
			pstmt.setString(6, member.getHobby());
			pstmt.setString(7, member.getMotivation());
			pstmt.setString(8, member.getId());
			
			updateCount = pstmt.executeUpdate();
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - updateMember()");
			e.printStackTrace();
		} finally {
			//자원 반환
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
		
		return updateCount;
	}
	
	// 회원 목록 조회를 수행하는 selectMemberList() 메서드 정의
	// => 파라미터 : 없음   리턴타입 : List<MemberDTO>
	public List<MemberDTO> selectMemberList() {
		// 전체 목록 조회를 통해 조회된 결과는 복수개의 레코드이며
		// 1개 레코드를 저장하는 객체 타입이 MemberDTO 타입이므로
		// MemberDTO 타입 객체 여러개를 하나의 묶음으로 다뤄야한다!
		// => java.util.List 타입(실제 구현체는 ArrayList 타입) 객체 활용
		// 1) 전체 회원 목록을 저장할 List 타입 변수 선언
		//    => 내부에 저장될 객체를 MemberDTO 타입으로 고정
		List<MemberDTO> memberList = null;
		
		// member 테이블 전체 레코드 조회 수행 후 콘솔에 출력
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		try {
			con = JdbcUtil.getConnection();
			
			String sql = "SELECT * FROM test4_member";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// 2) 전체 회원 목록을 저장할 List 타입 객체(구현체 ArrayList) 생성
			// => 주의! while 문 내부에서 생성할 경우 매번 새로운 객체가 생성되어
			//    목록 전체를 저장할 수 없게되므로 while 문보다 위에서 생성해야한다!
			memberList = new ArrayList<MemberDTO>(); // ArrayList 객체를 생성하여 업캐스팅 수행
			// => 제네릭 타입 MemberDTO 를 객체 생성 코드에서도 명시
			
			while(rs.next()) {
				// 3) 1개 레코드(1명의 회원 정보)를 저장할 MemberDTO 타입 객체 생성
				// => 주의! 한 바퀴 반복할 때마다 새로운 레코드(회원 정보)를 저장하므로
				//    while 문 내부에서 객체를 생성해야한다!
				MemberDTO member = new MemberDTO();
				
				// 4) 조회된 결과의 현재 레코드에서 데이터를 꺼내서 MemberDTO 객체에 저장
				member.setIdx(rs.getInt("idx"));
				member.setName(rs.getString("name"));
				member.setId(rs.getString("id"));
				member.setJumin(rs.getString("jumin"));
				member.setEmail(rs.getString("email"));
				member.setJob(rs.getString("job"));
				member.setGender(rs.getString("gender"));
				member.setHobby(rs.getString("hobby"));
				member.setMotivation(rs.getString("motivation"));
				member.setHire_date(rs.getDate("hire_date"));
				
				// 5) 전체 회원 목록을 저장하는 List 객체에
				//    1명의 회원 정보가 저장된 MemberDTO 객체 추가
				//    => List 객체 생성 시 MemberDTO 타입으로 고정되어 있으므로
				//       다른 타입 객체는 추가할 수 없다! = 오류 발생
				memberList.add(member);
			}
		} catch (SQLException e) {
			System.out.println("SQL 구문 오류 발생! - selectMemberList()");
			e.printStackTrace();
		} finally {
			JdbcUtil.close(rs);
			JdbcUtil.close(pstmt);
			JdbcUtil.close(con);
		}
		
		// 6) 전체 회원 목록이 저장된 List 타입 객체 리턴
		return memberList;
		
	}
	
	
}










