package try_catch;

public class Ex4 {

	public static void main(String[] args) {
		/*
		 * try ~ catch ~ finally 구문
		 * - 기본적으로 try, catch 블록의 역할은 동일하나
		 *   finally 블록에 기술된 코드들은 예외 발생 여부와 관계없이 실행됨
		 * - 일반적인 try 구분 바깥의 코드도 예외 발생여부와 관계없이 실행되는 것은 동일하나
		 *   try ~ catch 블록 내에서 return 문의 사용으로 인해 메서드 수행이 종료되더라도
		 *   반드시 finally 블록의 코드를 실행한 후에 메서드가 종료된다!
		 * - 주로, 데이터베이스 작업(JDBC) 이나 파일 작업을 위해 DB서버 등의 자원 사용시
		 *   예외가 발생하더라도 자원을 반환하기 위한 코드는 무조건 실행되러야 하므로
		 *   finally 블록 내에 자원 반환 코드를 기술하면 예외 발생여부와 관계없이 실행됨   
		 * 
		 * */
		
		try {
			System.out.println("1 - try 블록 시작!");
			
			int num1 = 3, num2 = 1;
			System.out.println(num1 / num2);
			
			System.out.println("2 - 예외 미발생. try 블록 끝!");
		} catch (Exception e) {
			System.out.println("3 - catch 블록 시작! 원인: " + e.getMessage());
		} finally {
			System.out.println("4 - finally 블록 시작! 언제나 실행되는 코드!");
		}
			
		System.out.println("5 - try 구문 끝!");
		
		System.out.println("===============================================");
		
		System.out.println("메서드 호출 시작!");
		method();
		System.out.println("메서드 호출 끝!");
		
	} // main() 메서드 끝
	
	public static void method() {
		/*
		 * 메서드 호출 시 예외 발생 여부에 따른 처리 순서
		 * 
		 * 1. 예외가 발생하지 않을 경우
		 * 	1 -> 2 -> return문 (아직 실행 X) -> 4(finally 블록 실행) -> return
		 * 
		 * 2. 예외가 발생했을 경우
		 * 	1 -> 예외발생 -> 3(catch블록 실행) -> 4(finally 블록 실행) -> 5
		 * */
		try {
			System.out.println("1 - try 블록 시작!");
			
			int num1 = 3, num2 = 1;
			System.out.println(num1 / num2);
			
			System.out.println("2 - 예외 미발생. try 블록 끝!");
			
			return; // 메서드 수행을 중단하고 호출한 곳으로 돌아감
			
		} catch (Exception e) {
			System.out.println("3 - catch 블록 시작! 원인: " + e.getMessage());
		} finally {
			System.out.println("4 - finally 블록 시작! 언제나 실행되는 코드!");
		}
			
		System.out.println("5 - try 구문 끝!");
		
	}

}
