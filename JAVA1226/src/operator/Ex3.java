package operator;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 산술 연산시 자동 형변환
		 * - 산술 연산 전에 데이터 타입이 다르면
		 *   산술 연산을 수행하기 전 피연산자끼리의 데이터타입을 "일치" 시킨 후에 연산 수행
		 * 
		 * - 규칙1. int타입보다 작은 타입끼리의 연산은 모두 int타입으로 변환 후 연산 수행
		 * 		   => 따라서, 결과값은 무조건 int타입이 됨
		 * ex) byte + byte = int + int => 결과가 int타입
		 * ex) char + int = int + int => 결과가 int타입
		 * 
		 * - 규칙2. int 타입보다 큰 타입과의 연산은 큰 타입으로 변환 후 연산 수행
		 * ex) int + long = long + long => 결과가 long타입
		 * ex) int + double = double + double => 결과가 double타입 
		 * */
		
		char ch = 'A';
		System.out.println(ch + 2);
		
		char ch2 = (char)(ch + 2);
		System.out.println(ch2);
		
		int i = 100;
		long l = 200;
		int i2 = (int)(i + l);
		
		float f = 3.14f;
		long l2 = (long)(l + f);
		
		System.out.println("=======================");
		
		System.out.println((double)10 / 3);
		System.out.println(10 / 3.0);
		System.out.println((double)(10 / 3));
		
//		10 / 3				int / int = int
//		(double)(10 / 3)	(double)(int / int) => (double)3 => 3.0
//		(double)10 / 3		10.0 / 3.0 => 3.33335
//		10 / (double)3		10.0 / 3.0 => 3.33335
		
		byte b1 = 10, b2 = 20, b3;
//		b3 = b1 + b2;
		b3 = 10 + 20;	// 상수(리터럴) 끼리의 연산은 형변환이 발생하지 않는다.
//		b3 = 100 + 28;	// 오류! 리터럴끼리의 연산이더라도 범위를 초과하면 오류 발생!
		
	}

}
