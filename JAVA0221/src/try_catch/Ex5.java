package try_catch;

import java.sql.DriverManager;
import java.sql.SQLException;

public class Ex5 {

	public static void main(String[] args) throws Exception {
		/*
		 * 예외 처리에 대한 위임 (= 예외던지기 = throws)
		 * - 예외 발생 시 예외가 발생한 메서드(자신)에서 직접 처리하지 않고
		 *   자신의 메서드를 호출한 곳으로 예외 처리를 위임할 수 있음
		 * - 메서드 선언부 마지막에 throws 키워드를 사용하여 발생 가능성이 있는
		 *   예외 클래스 이름을 명시하여 해당 예외가 발생했을 때 예외를 던짐(throws)
		 * - 주로, 메서드 내의 특정 코드에서 예외가 발생할 것으로 예상되는 경우
		 *   외부에서 해당 메서드를 호출하는 시점에서 미리 알 수 있도록
		 *   내부 예외를 외부로 던진 후 외부에서 해당 예외를 탐지하고 처리하도록 할 때 사용
		 * - throws 키워드를 통해 예외를 위임하는 경우 예외가 발생한 위치에서는
		 *   예외 처리를 수행하지 않아도 컴파일 에러가 발생하지 않으며,
		 *   예외 처리를 위임 받은 곳에서 반드시 예외를 처리하는 코드를 기술해야함
		 *   => 만약, 위임받은 예외를 직접 처리하지 않으려면 자신의 메서드에서도
		 *      throws 키워드를 통해 호출한 곳으로 위임할 수 있음
		 * - throws 키워드 뒤에 기술되는 예외클래스는 catch 블록과 마찬가지로
		 *   각각의 예외클래스를 따로 기술하거나 상위 타입 예외클래스 하나만으로 대체 가능      
		 *   
		 * ex) throws ArithmeticException, NullPointerException 기술 시
		 * 		두 개의 예외만 외부로 던지고, 나머지 예외는 직접 처리해야한다!
		 * 
		 * ex) throws RuntimeException 기술 시      
		 *      RuntimeException 계열 예외는 외부로 던지고, 나머지 예외는 직접 처리
		 * 
		 * ex) throws Exception 기술 시 모든 예외를 외부로 던짐
		 *       
		 *       
		 * */
//		try {
//			팀장();
//			// => throws 키워드를 통해 예외처리를 위임할 수 있으나
//			//    현재 위치가 main() 메서드 이며 main() 메서드에서 위임할 경우
//			//    더이상 예외처리를 기술할 곳이 없기 때문에 예외 위임이 불가능하다!
//			// => 최종 메서드인 main() 메서드에서 반드시 try ~ catch 문 사용 필수!
//		} catch (Exception e) {
//			System.out.println("main() 메서드에서 최종적으로 모든 예외 처리!");
//		}
		팀장();
		System.out.println("정상 종료!");
	} // main() 메서드 끝
	
	public static void 팀장() throws Exception {
		// 1) 팀장 메서드에서 직접 위임된 예외를 처리
//		try {
//			대리1();	// ArithmeticException, NullPointerException
//			대리2();	// ClassNotFoundException, SQLException
//			// => 두 예외 모두 하나의 Exception 예외로 위임됨
//		} catch (RuntimeException e) {
//			System.out.println("팀장이 ArithmeticException, NullPointerException 예외를 모두 처리");
//		} catch (Exception e) {
//			System.out.println("팀장이 나머지 모든 예외를 직접 처리!");
//		}
		
		// 2) 팀장() 메서드를 호출한 곳으로 예외 위임
		대리1();
		대리2();
		// => 모든 예외를 하나로 묶어서 위임하려면
		//		1. 모든 클래스를 각각 명시
		//		2. RuntimeException과 ClassNotFoundException, SQLException
		//      3. RuntimeException과 Exception 으로 명시
		//      4. Exception 으로 모든 예외 통합
		
	}
	
	public static void 대리1() throws ArithmeticException, NullPointerException {
		사원1(); // ArithmeticException
		사원2(); // NullPointerException
	}
	
	public static void 대리2() throws Exception {
		사원3(); // ClassNotFoundException
		사원4(); // SQLException
		// => 하나의 예외로 묶어서 던지려면 공통 클래스인 Exception 클래스 사용해야함
	}
	
	public static void 사원1() throws ArithmeticException {
		System.out.println(3 / 1);
	}
	
	public static void 사원2() throws NullPointerException {
		String str = "홍길동";
		System.out.println(str.length());
	}
	
	public static void 사원3() throws ClassNotFoundException {
		Class.forName("com.mysql.jdbc.Driver");
	}
	
	public static void 사원4() throws SQLException {
		DriverManager.getConnection("");
	}
	

}
