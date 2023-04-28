package while_;

public class Test1 {

	public static void main(String[] args) {
		
		// 1 ~ 10 까지 정수의 합 sum을 계산하여 출력
		// ex) 출력: 1 ~ 10까지의 합: sum
		
		int sum = 0;
		int i = 1;
		while(i <= 1000) {
			sum += i;
			i++;
		}
		System.out.println("1 ~ 10까지의 합: " + sum);
		
		/*
		 * 구구단 출력
		 * 
		 * < 2단 >
		 * 2 * 1 = 2
		 * 2 * 2 = 4
		 * 2 * 3 = 6
		 * ...
		 * 2 * 9 = 18
		 * 
		 * */
		
		int dan = 9;
		i = 1;
		System.out.println("< " + dan + "단 >");
		while(i < 10) {
			System.out.println(dan + " * " + i + " = " + dan*i);
			i++;
		}
		
		// 1 ~ 100 까지 짝수/홀수의 합을 출력
		// odd(홀수), even(짝수)
		// ex) 1 ~ 100 까지 짝수의 합: XX
		//	   1 ~ 100 까지 홀수의 합: XX
		
		i = 1;
		int odd = 0, even = 0;
		while(i <= 10) {
			if(i % 2 == 0)	even += i;
			else			odd += i;
			i++;
		}
		
		System.out.println("1 ~ 100 까지 짝수의 합: " + even);
		System.out.println("1 ~ 100 까지 홀수의 합: " + odd);
		
	}

}
