package for_;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 1 ~ 100 까지의 합
		 * => 만약, 초기화를 수행하지 않은 채로 합계를 누적하는 경우 오류가 발생하므로
		 *    반드시 누적변수는 변수의 선언과 함께 초기화 필수!
		 * */
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			sum += i;
		}
		System.out.println("정수 1 ~ 100 까지의 합: " + sum);
		
		/*
		 * 반복문과 조건문의 결합
		 * - 반복문 내에서 조건문을 통해 특정 조건일때만 일부 반복문을 수행 제어 가능
		 *   ex) 1 ~ 100 까지 1씩 증가하면서 홀수와 짝수의 합을 따로 누적
		 * */
		// odd (홀수), even (짝수)
		int odd = 0;
		int even = 0;
		
		for(int i = 1; i <= 100; i++) {
			
			if(i % 2 == 0) { // 짝수
				even += i;
			} else {
				odd += i;
			}
		}
		
		System.out.println("1 ~ 100 까지 짝수의 합: " + even);
		System.out.println("1 ~ 100 까지 홀수의 합: " + odd);
		
		
		
	}

}
