package try_catch;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 예외(Exception)
		 * - 개발자가 의도하지 않은 상황에서 발생하는 문제
		 * - 예외 발생 시 프로그램은 해당 지점에서 비정상적으로 종료됨
		 * - 오류(Error)와 달리 심각도가 낮으며 예외 처리(Exception Handling)를 통해
		 *   예외 발생 시 해결책을 기술하여 프로그램이 정상적으로 종료되도록 처리 가능
		 * - 예외 처리를 위해 try ~ catch 문을 사용하여 처리 작업 수행
		 *   => try 블록 내에서 예외 발생 가능성이 있는 코드들을 감시하고
		 *   	예외가 발생했을 경우 JVM이 던지는 예외 객체를 전달받아
		 *   	catch 블록 중 해당 객체 타입과 일치하는 catch 블록을 싱행하여 예외를 처리
		 *   => 예외가 발생하지 않으면 catch블록은 실행되지 않는다!
		 *   
		 * - 예외 종류 분류
		 * 	1) Compile Checked Exception 계열
		 * 		- 컴파일(번역) 시점에서 예외 발생 가능성을 판별 가능하므로
		 * 		  예외 처리가 되어 있지 않으면 컴파일 에러 발생함(예외처리 강제성 있음)
		 * 		- 대표적인 예외 : IOException, SQLException, ClassNotFoundException 
		 * 
		 *  2) Compile Unchecked Exception 계열
		 *  	- 컴파일(번역) 시점에서 예외 발생 가능성을 판별할 수 없으며
		 *  	  실행 시점에서 예외 발생 여부가 판별되므로
		 *  	  예외 처리 여부를 별도로 감시하지 않음(예외 처리 강제성이 없음)
		 *  	  => 예외가 발생할 것으로 예상되는 코드를 찾아서 예외 처리를 수행해야함
		 *  	- 대표적인 예외 : RuntimeException 계열
		 *  	  => ArithmeticException, ArrayIndexOutOfBoundsException
		 *  		 NullPointerException, ClassCastException 등
		 * - java.lang 패키지 내에 Exception 클래스와 서브 클래스들이 제공되며
		 *   각 예외는 "자신의 슈퍼클래스 타입으로 업캐스팅" 도 가능함
		 * */
		
		System.out.println("프로그램 시작!");
		
		try {
			System.out.println("try 블록 시작!");
			int num1 = 3;
			int num2 = 0;
			
			System.out.println(num1 / num2);
			// 현재 예외가 발생한 코드의 아래쪽 나머지 코드들(try블록 내의 코드들)은
			// 실행되지 못하고, catch 블록으로 가서 예외 객체에 해당하는 클래스를 찾아
			// 해당 catch 블록 내의 코드들을 실행하게 된다!
			
			System.out.println("try 블록 끝!");
			
		} catch (ArithmeticException e) {
			// ArithmeticException 예외가 try 블록 내에서 발생하면
			// JVM에 의해 ArithmeticException 예외 객체가 생성되고 던져짐
			// 따라서, catch 블록의 소괄호 안에 해당 예외 클래스와 일치하는 참조변수를 선언하여
			// 던져지는 예외 객체를 전달 받아야 한다(catch)
			System.out.println("ArithmeticException 예외 발생! - 0으로 나눌 수 없습니다!");
		}
		
		System.out.println("프로그램 종료!");
		
		System.out.println("==========================================");
		
		System.out.println("프로그램 시작!");
		
		try {
			System.out.println("try 블록 시작!");
			int[] arr = {1, 2, 3};
			System.out.println(arr[3]);
			System.out.println("try 블록 끝!");
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println("ArrayIndexOutOfBoundsException 예외 발생!");
			e.printStackTrace();
		}
		
		System.out.println("프로그램 종료!");
		
		
		
		
		
		
		
		
	}

}
