package if_;

public class Test1 {

	public static void main(String[] args) {
		/*
		 * if문
		 * 정수형 변수 num에 대한 절대값 계산하여 출력
		 * => ex) num이 5일때 -> "변수 num = 5"
		 *    ex) num이 -10일때 -> "변수 num = 10"
		 * */
//		int num = 5;
//		if(num < 0) {
//			num = -num;
//		}
//		System.out.println("변수 num = " + num);
//		System.out.println("============================");
		
		// 삼항 연산자
		int num = 10;
//		num = num < 0 ? -num : num;
		num *= num < 0 ? -1 : 1;
//		num *= -1; // 조건이 true일때
//		num *= 1;  // 조건이 false일때
		System.out.println("변수 num = " + num);
		
		// 변수의 범위(scope, Life Cycle)
//		int num2 = -10;
//		if(num2 < 0) {
//			int result = -num2;
//		}
//		System.out.println("변수 num2 = " + result);
		
		// 중괄호 안에서 선언된 변수는
		// 해당 중괄호가 끝나는 시점에서 사라지기 때문에
		// 중괄호 밖에서 사용(접근)할 수 없음!
		
		
		/*
		 * 문자 ch가 대문자일때, 소문자로 변환하여 출력
		 * => ex) ch가 'A' 일때 -> "ch = a"
		 * (참고. 정수형 대문자 + 32 -> 소문자)
		 * */
		char ch = 'a';
		
//		if(ch >= 'A' && ch <= 'Z') {
////			ch = (char)(ch + 32);
//			ch += 32;
//		}
		
		// 삼항연산자
//		ch = (ch >= 'A' && ch <= 'Z') ? (char)(ch + 32) : ch;
		ch += (ch >= 'A' && ch <= 'Z') ? 32 : 0;
//		ch += 32;	// true일때
//		ch += 0;	// false일때
		System.out.println("ch = " + ch);
		
		
	}

}
