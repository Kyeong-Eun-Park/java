package for_;

public class Test2 {

	public static void main(String[] args) {
		/*
		 * 두 정수 a ~ b 까지 3의 배수의 합
		 * ex) X ~ X까지 3의 배수의합: XX
		 * */
		int a = 2, b = 12;
		int sum = 0;
		for(int i = a; i <= b; i++) {
			if(i % 3 == 0)	sum += i;
		}
		System.out.println(a + " ~ " + b + "까지 3의 배수의합: " + sum);
		System.out.println("=====================");
		
		/*
		 * 간단 3, 6, 9 게임
		 * - 정수 1 ~ 100 까지 1씩 증가하면서 반복
		 * - 각 정수를 화면에 출력
		 * - 단, 정수의 "일의 자리가" 3, 6, 9 중 하나일 경우 숫자 출력 대신에 "짝" 출력
		 * ex) 1 2 짝 4 5 짝 7 8 짝 10 11 ... 90 91 92 짝 94 95 짝 ... 100
		 * 
		 * */
		
		System.out.println(97 % 10 == 7);
		
		
		for(int i = 1; i <= 100; i++) {
			int num = i % 10;
			boolean is369 = num == 3 || num == 6 || num == 9;
			if(is369) {
				System.out.print("짝 ");
			} else {
				System.out.print(i + " ");
			}
		}
		
		System.out.println("-------------------------");
		
		/*
		 * 7의 갯수를 카운트 해보자!
		 * int n = 247427723
		 * ex) 7의 갯수: 3
		 * */
		int n = 74574;
		int count = 0;
		while(n > 0) {
			if(n % 10 == 7)	count++; 
			n /= 10;
		}
		System.out.println("7의 갯수: " + count);
		
		
		
		
		
		
		
		
	}

}
