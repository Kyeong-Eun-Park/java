package try_catch;

public class Ex6 {

	public static void main(String[] args) {
		/*
		 * 사용자 정의 예외 발생
		 * - 미리 지정된 예외 상황이 아닌 개발자가 지정한 상황에서 직접 예외를 발생시키는 것
		 * - throw 키워드를 사용하여 특정 지점에서 예외를 발생 시킬 수 있다.
		 * 	 => throw 키워드가 사용된 위치의 코드는 예외발생으로 인한 컴파일 에러가 발생하며
		 * 		예외 처리를 위해 try ~ catch 문을 사용하거나 throws 키워드로 위임해야함
		 * - 주로, 문법 오류는 아니나 개발자에 의해 논리적인 오류로 취급해야하는 코드에서
		 * 	 해당 코드를 호출하는 곳으로 예외 발생 사실을 알려주기 위해 사용
		 * */
		int score = 180;
		try {
			grade(score);
		} catch (Exception e) {
			// 정상범위가 아닌 점수가 입력되면 Exception 타입 예외가 발생하고
			// 해당 예외가 발생했을 때 수행할 작업을 catch 블록에서 기술
			e.printStackTrace();
		}
		
		System.out.println("정상 종료");
		
	} // main() 메서드 끝
	
	
	public static void grade(int score) throws Exception {
		if(score < 0 || score > 100) {
//			System.out.println("점수 입력 오류!");
			// 개발자에 의해 직접 예외를 발생 시키려면
			// 예외 발생 코드를 조건문을 통해 판별 후 해당 조건문 내에서
			// throw 키워드를 사용하여 예외클래스 타입 객체를 생성(new)하여 던져야함(throw)
//			throw new ArithmeticException("점수 입력 오류!");
			throw new Exception("점수 입력 오류!");
		}
	}
	

}
