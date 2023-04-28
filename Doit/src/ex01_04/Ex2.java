package ex01_04;

public class Ex2 {

	public static void main(String[] args) {
		// 69p
		
		// Q1) 정답: 예
		// 바이트 크기가 작은 자료형을 더 큰 자료형으로 대입하는
		// 형 변환은 자동으로 이루어 집니다. (예 / 아니오)
		
		// Q2) 정답: 아니오
		// 실수를 정수형 변수에 대입하는 경우에 형 변환이 자동으로
		// 이루어지고, 소수점 이하 부분만 없어집니다. (예 / 아니오)
		
		// Q3) 정답: 부동소수점
		// 더 많은 실수를 표현하기 위해서 가수부와 지수부로 비트를 나누어
		// 표현하는 방식을 XXX 이라고 합니다.
		
		// Q4)
		// 변수 두 개를 선언해서 10과 2.0을 대입하고
		// 두 변수의 사칙 연산 결과를 정수로 출력해 보세요.
		int a = 10;
		double b = 2.0;
		
		System.out.println((int)(a + b));
		System.out.println((int)(a - b));
		System.out.println((int)(a * b));
		System.out.println((int)(a / b));
		
		
		
		
	}

}
