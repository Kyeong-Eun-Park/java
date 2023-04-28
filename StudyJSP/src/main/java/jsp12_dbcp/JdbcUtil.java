package jsp12_dbcp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;

// 데이터베이스 연결 등의 기본 작업 처리를 위한 메서드를 갖는 JdbcUtil 클래스 정의
public class JdbcUtil {
	
	// Connection Pool 을 통해 커넥션을 관리하는 DataSource 객체를 통해
	// Connection 객체를 전달받아 리턴하는 getConnection() 메서드 정의
	// => 자주 사용하는 메서드이므로 클래스명만으로 바로 접근하도록 하기 위해 
	//    static 메서드로 정의하기 위해 접근제한자 뒤에 static 붙임
	public static Connection getConnection() {
		// DB 연결 정보를 저장하는 Connection 타입 변수 선언
		Connection con = null;
		
		try {
			// DBCP 를 활용한 데이터베이스 연동
			// context.xml 에 설정된 커넥션풀로부터 Connection 객체 가져오기
			// 0. context.xml 파일에 커넥션풀(CP) 정보 설정하기
			// 1. 톰캣으로부터 context.xml 파일의 <Context> 태그를 객체 형태로 가져오기
			// => InitialContext 객체 생성하여 Context 타입으로 업캐스팅(형변환)
			Context initCtx = new InitialContext();
			
			// 2. 생성된 Context 객체(initCtx)로부터 context.xml 파일의 <Resource> 태그를 객체로 가져오기
			// => Context 객체(initCtx)의 lookup() 메서드를 호출하여 찾아올 리소스 지정
			//    (파라미터 : "java:comp/env" 문자열)
			//    (리턴타입 : Object => Context 타입 객체로 다운캐스팅)
//	 	Context envCtx = (Context)initCtx.lookup("java:comp/env");
			
			// 3. <Resource> 태그가 복수개 있을 경우(DB 여러개) 
			// 각 리소스 구분을 위해 지정한 이름(JNDI)을 사용하여 해당 리소스 선택하여 가져오기
			// => Context 객체(envCtx)의 lookup() 메서드를 호출하여 찾아올 리소스 지정
			//    (파라미터 : 리소스 이름 => Resource 태그에 설정된 name 속성값)
			//                => 주의! context.xml 파일 내의 지정된 name 속성값이 다를 수 있음!
			//    (리턴타입 : Object => javax.sql.DataSource 타입으로 다운캐스팅)
//	 	DataSource ds = (DataSource)envCtx.lookup("jdbc/MySQL");
			
			// -- 참고. 위의 2번과 3번 작업을 하나의 문장으로 결합 --
			DataSource ds = (DataSource)initCtx.lookup("java:comp/env/jdbc/MySQL");
			
			// 4. 커넥션 풀을 관리하는 DataSource 객체로부터 미리 생성되어 있는 Connection 객체 가져오기
			// => DataSource 객체의 getConnection() 메서드를 호출(리턴타입 : java.sql.Connection)
			con = ds.getConnection();
			
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// DB 연결 정보가 저장된 Connection 객체 리턴
		return con;
		
	}
	
	// -----------------------------------------------------------------------------------
	// 데이터베이스 작업 완료 후 사용이 끝난 객체를 반환하기 위한 close() 메서드 정의
	// => 외부에서 인스턴스 생성 없이 클래스명만으로 호출할 수 있도록 static 메서드로 정의
	// => Connection, PreparedStatement, ResultSet 객체를 각각 close() 하는 메서드를 정의 시
	//    동일한 메서드 이름을 사용하여 정의하되, 파라미터를 달리하여 정의 = 메서드 오버로딩
	// 1. Connection 객체를 반환하는 close() 메서드 정의
	//    => 파라미터 : Connection 객체   리턴타입 : void
	public static void close(Connection con) {
		try {
			// Connection 객체의 close() 메서드 호출하여 반환
			// 단, 객체가 null 이 아닐 경우에만 close() 메서드 호출
			if(con != null) {
				con.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 2. PreparedStatement 객체를 반환하는 close() 메서드 정의
	//    => 파라미터 : PreparedStatement 객체   리턴타입 : void
	public static void close(PreparedStatement pstmt) {
		try {
			// PreparedStatement 객체의 close() 메서드 호출하여 반환
			// 단, 객체가 null 이 아닐 경우에만 close() 메서드 호출
			if(pstmt != null) {
				pstmt.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 3. ResultSet 객체를 반환하는 close() 메서드 정의
	//    => 파라미터 : ResultSet 객체   리턴타입 : void
	public static void close(ResultSet rs) {
		try {
			// ResultSet 객체의 close() 메서드 호출하여 반환
			// 단, 객체가 null 이 아닐 경우에만 close() 메서드 호출
			if(rs != null) {
				rs.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
}












