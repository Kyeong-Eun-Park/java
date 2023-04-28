package ex01_04;

public class Ex4_Q5 {

	public static void main(String[] args) {
		// 123p
		/*
		 * Q5)
		 * 반복문과 조건문을 사용하여 다음 모양을 출력하는 프로그램을 만들어 보세요.
		 * 
		 * 			   *
		 * 			  ***
		 * 			 *****
		 * 			*******
		 * 			 *****
		 * 			  ***
		 * 			   *
		 * */
		
		int line = 17;
		int star = 1;
		int space = line/2;
		
		for(int i = 0; i < line; i++) {
			
			// 공백
			for(int j = 0; j < space; j++) {
				System.out.print(" ");
			}
			// 별
			for(int j = 0; j < star; j++) {
				System.out.print("*");
			}
			// 공백
			for(int j = 0; j < space; j++) {
				System.out.print(" ");
			}
			System.out.println();
			
			// i가 3이전
			if(i < line/2) {
				star += 2;
				space--;
			} else {
				star -= 2;
				space++;
			}
			
		}
		
		
		
		
		
	}

}
