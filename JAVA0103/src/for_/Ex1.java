package for_;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 2. for문
		 * 
		 * < 기본 문법 >
		 * 
		 * for(초기식; 조건식; 증감식){
		 * 		// 조건식이 true일 때 반복 실행할 문장들;
		 * }
		 * 
		 * => 초기식: 반복 횟수를 제어할 제어변수를 선언하고 필요에 따라 초기화 수행 
		 * => 조건식: 제어변수를 사용하여 반복문을 반복하는 조건식 지정
		 * 			(조건식 결과가 true일 동안 계속 반복 수행하고, false이면 종료)
		 * => 실행문: 조건식 결과가 true일 동안 반복 실행할 문장을 기술
		 * => 증감식: 실행문 실행 후 조건식으로 이동하기 전 제어변수를 증감시킴
		 * => 초기식 -> 조건식 -> 실행문 -> 증감식 -> 조건식 -> 실행문.... 순으로 반복
		 * */
		
		// Hellow, World! 10번 출력
		
		for(int i = 1; i <= 10; i++) {
			System.out.println(i + " : Hellow, World!");
		}
		
		// for문이 종료되고 나면 제어변수 i는 사라짐
//		System.out.println(i);
		
		System.out.println("------------------------------");
		
		// 2 ~ 10 까지 2씩 증가하면서 i 값을 출력
		for(int i = 2; i <= 10; i += 2) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("----------------------------------");
		
		// 제어변수 i가 10 ~ 1 까지 1씩 감소하면서 i값을 출력 (10 9 8 7 6 5 4 ... 2 1)
		for(int i = 10; i >= 1; i--) {
			System.out.print(i + " ");
		}
		System.out.println();
		System.out.println("----------------------------------");
		
		// for문 에서 구성요소 제외 가능 예
		int i = 1;
		for(; i <= 10; i++) {
			System.out.print(i + " ");
		}
		System.out.println();
		
		
		
		
		
	}

}
