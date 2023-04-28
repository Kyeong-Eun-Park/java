package ex01_04;

public class Ex4_Q3 {

	public static void main(String[] args) {
		// 123p
		// Q3)
		// 구구단을 단보다 곱하는 수가 작거나 같은 경우 까지만
		// 출력하는 프로그램을 만들어 보세요.
		// 단, break문 사용
		
		for(int dan = 2; dan <= 9; dan++) {
			
			System.out.println("< " + dan + "단 >");
			for(int i = 1; i <= 9 ;i++) {
				if(dan < i) break; 
				System.out.println(dan + " * " + i + " = " + dan*i);
			}
			System.out.println();
		}
		
		
		
	}

}
