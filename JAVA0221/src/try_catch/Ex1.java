package try_catch;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 오류(Error)
		 * - 프로그램 자체 또는 JVM등 치명적인 원인으로 인해 발생하는 문제점
		 * - 오류가 발생하면 프로그램은 강제로 종료됨
		 * - 개발자가 수정이 불가능한 문제
		 * 
		 * 예외(Exception)
		 * - 사용자의 잘못된 조작 실수 또는 개발자의 잘못된 코딩등으로 인해 발생하는 문제점
		 * - 예외가 발생해도 프로그램은 즉시 강제 종료됨
		 * - 개발자가 예외 상황이 발생했을 때 대처 방안을 기술할 수 있다.
		 * 
		 * < 예외 관련 용어 >
		 * 1. 예외가 발생했을 때 예외 발생 여부를 감지하는 대상 : 리스너(Listener)
		 * 2. 예외가 발생했을 때 정상적으로 종료될 수 있도록 처리하는 것 : 예외처리
		 *    => 예외가 발생하지 않도록 미리 원인을 제거하는 것은 예외 처리가 아니며
		 * 		 예외가 발생할 상황을 미리 탐지하여 예외가 발생했을 때
		 *       프로그램이 정상 종료되도록 처리하는 것을 예외 처리라고 한다.
		 * */
		
		System.out.println("프로그램 시작!");
		
		int num1 = 10;
		int num2 = 0;
		
		// 자바에서는 연산 시 두번째 피연산자가 0일 경우 나눗셈 과정에서 예외 발생함!
//		System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
		// => 예외 발생 코드 아래쪽의 나머지 코드는 실행되지 못한 채 비정상 종료됨
		
		/*
		 * Exception in thread "main" java.lang.ArithmeticException: / by zero
				at try_catch.Ex1.main(Ex1.java:30)
			1) Exception in thread "main" java.lang.ArithmeticException:
				=> 예외 발생 상황 정보 및 예외 발생을 탐지한 예외 클래스명
			2) / by zero
				=> 예외 발생 원인 메세지
			3) at try_catch.Ex1.main(Ex1.java:30)
				=> 예외 발생 위치 (Ex1.java 클래스의 30번 라인에서 예외 발생)
		 * */
		
		// 만약, 예외가 발생하지 않도록 if문을 통해 피연산자 값 검사하는 경우
		// 예외 처리가 아니다!
//		if(num2 != 0) {
//			System.out.println(num1 + " / " + num2 + " = " + (num1 / num2));
//		}
		
		String str = null; // 참조 변수에 저장된 주소값이 없음
//		System.out.println(str.length()); 
		// null 값을 참조하는 객체에 접근하여 작업을 수행하려 할 경우
		// 접근이 불가능하므로 NullPointerException 예외가 발생하게 된다!
		
		int[] arr = new int[2];
		arr[2] = 10;
		// 배열 인덱스 사용 시 존재하지 않는 인덱스 사용할 경우
		// ArrayIndexOutOfBoundsException 예외가 발생하게 된다!
		
		
		System.out.println("프로그램 종료!");
		
	}

}
