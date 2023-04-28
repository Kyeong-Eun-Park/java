package operator;

public class Ex4 {

	public static void main(String[] args) {
		/*
		 * 삼항 연산자 (조건연산자)
		 * - 연산에 참여하는 항이 3개인 연산자
		 * - 특정 조건에 따라 다른 값을 실행하는 연산자
		 *   => if ~ else 문과 동일한 기능을 수행
		 * - 2가지 경우의 수 (true 또는 false)에 대한 결과를 수행
		 * 
		 * < 기본 문법 >
		 * 조건식 ? 값1 : 값2 
		 * => 조건식에는 결과값이 boolean 타입인 식만 올 수 있다.
		 * => 연산식 판별 결과가 true일 경우 값1 부분을 반환, false 일 경우 값2 부분을 반환
		 * */
		
		int num = 10;
		String result = (num % 2 == 0) ? "짝수" : "홀수";
		System.out.println(result);
		
//		result = num % 2 == 0 ? "짝수" : 12;
		// : 기준으로 좌우 데이터타입이 다르면 안됨!!
		
//		num % 2 == 0 ? System.out.println("짝수") : System.out.println("홀수");
		// : 기준 좌우 실행문이 오면 안됨!!
		
		// 최대값, 최소값
		int a = 80;
		int b = 50;
		
		int max = (a > b) ? a : b;
		int min = (a < b) ? a : b;
		
		System.out.println(max);
		System.out.println(min);
		
		System.out.println();
		
		// 반올림
//		double d = 97.3;
		
//		System.out.println((int)(d + 1)); 
//		System.out.println((int)d);
//		System.out.println((int)(d * 10 % 10)); 
		
//		int round = 98;
//		int round = 97;
		
//		int round = d * 10 % 10 > 5 ? (int)(d + 1) : (int)d;
		
//		int round = (int)d;
//		round += d * 10 % 10 > 5 ? 1 : 0;
		
		System.out.println("------------------------");
		double d = 97.9;
		int round = (int)(d + 0.5);
		System.out.println(round);
		
		/*
		 * 삼항 연산자의 중첩 사용
		 * - 경우의 수가 3가지 이상일 때 사용
		 * - 삼항연산자 내에서 true 또는 false 일때 반환할 부분에
		 *   또 다른 삼항연산자를 사용하여 그 다음 조건을 판별하는 방법
		 * 
		 * < 기본 문법 >
		 * 조건식1 ? 값1 : 조건식2 ? 값2 : 값3;
		 * 
		 * ex) 홀수, 짝수, 0의 3가지 경우의 수 판별
		 * */
		int n = 3;
		String r = n == 0 	  ? "0"   : 
				   n % 2 == 0 ? "짝수" : "홀수";
		
//		String r = n == 0 ? "0" : "짝수";
//		String r = n == 0 ? "0" : "홀수";
		
		System.out.println(r);
		
		
		
	}

}
