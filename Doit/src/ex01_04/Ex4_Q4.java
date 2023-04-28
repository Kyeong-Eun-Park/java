package ex01_04;

public class Ex4_Q4 {

	public static void main(String[] args) {
		// 123p
		/*
		 * Q4)
		 * 반복문을 사용하여 다음 모양을 출력하는 프로그램을 만들어 보세요.
		 * 
		 * 		   *
		 * 		  ***
		 * 		 *****
		 * 		*******
		 * 
		 * */
//		int line = 17;
//		int star = 1;
//		int space = line - star;
//		
//		for(int i = 0; i < line; i++) {
//			// 공백
//			for(int j = 0; j < space; j++) {
//				System.out.print(" ");
//			}
//			// 별
//			for(int j = 0; j < star; j++) {
//				System.out.print("*");
//			}
//			// 공백
//			for(int j = 0; j < space; j++) {
//				System.out.print(" ");
//			}
//			System.out.println();
//			star += 2;
//			space--;
//		}
		
		
		// method version
		int line = 15;
		int star = 1;
		int space = line - star;
		
		for(int i = 0; i < line; i++) {
//			printSpace(space); // 공백
//			printStar(star); // 별
//			printSpace(space); // 공백
//			System.out.println();
			
			printChar(space, " ");
			printChar(star, "*");
			printChar(space, " ");
			System.out.println();
			
			star += 2;
			space--;
		}
	}
	
	// 횟수와 문자를 전달받아 횟수만큼 전달받은 문자를 우측으로 출력하는 메서드
	public static void printChar(int count, String str) {
		for(int i = 0; i < count; i++) {
			System.out.print(str);
		}
	}
	
	public static void printSpace(int count) {
		for(int i = 0; i < count; i++) {
			System.out.print(" ");
		}
	}
	
	public static void printStar(int count) {
		for(int i = 0; i < count; i++) {
			System.out.print("*");
		}
	}
	
	

}
