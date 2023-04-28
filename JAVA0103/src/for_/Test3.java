package for_;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		/*
		 * *	i = 1 일때 반복횟수: 1
		 * **	i = 2 일때 반복횟수: 2
		 * ***	i = 3 일때 반복횟수: 3
		 * ****	i = 4 일때 반복횟수: 4
		 * *****i = 5 일때 반복횟수: 5
		 * 
		 * */
//		String star = "";
//		for(int i = 0; i < 60; i++) {
//			star += "*";
//			System.out.println(star);
//		}
		
//		for(int i = 1; i <= 6; i++) {
//			
//			// 별을 우측으로 출력하는 for문
//			for(int j = 0; j < i; j++) {
//				System.out.print("*");
//			}
//			
//			System.out.println();
//		}
		
		/*
		 * ***** i = 5 일때 반복횟수: 5
		 * ****	 i = 4 일때 반복횟수: 4
		 * ***	 i = 3 일때 반복횟수: 3
		 * **	 i = 2 일때 반복횟수: 2
		 * *	 i = 1 일때 반복횟수: 1
		 * 
		 * */
		
//		for(int i = 5; i >= 1; i--) {
//			for(int j = 1; j <= i; j++) {
//				System.out.print("*");
//			}
//			System.out.println();
//		}
		
		
		/*
		 * 		    * i=1 일때, 공백:4, 별:1
		 * 		   ** i=2 일때, 공백:3, 별:2
		 * 		  *** i=3 일때, 공백:2, 별:3
		 * 		 **** i=4 일때, 공백:1, 별:4
		 * 		***** i=5 일때, 공백:0, 별:5
		 * */
		
//		Scanner sc = new Scanner(System.in);
//		
//		int line = sc.nextInt();	// 줄수
//		int star = 1;				// 별 갯수
//		int space = line - star;	// 공백 갯수
//		
//		for(int i = 0; i < line; i++) {
//			
//			for(int j = 0; j < space; j++) { // 공백 찍기
//				System.out.print(" ");
//			}
//			
//			for(int j = 0; j < star; j++) { // 별찍기
//				System.out.print("*");
//			}
//			
//			System.out.println();
//			
//			star++;
//			space--;
//		}
		
		
		
		/*
		 * 		*****
		 * 		 ****
		 * 		  ***
		 * 		   **
		 * 		    *
		 * */
		
		int line = 12;
		int star = line;
		int space = 0;
		
		for(int i = 0; i < line; i++) {
			
			for(int j = 0; j < space; j++) { // 공백찍기
				System.out.print(" ");
			}
			
			for(int j = 0; j < star; j++) { // 별찍기
				System.out.print("*");
			}
			
			System.out.println();
			
			star--;
			space++;
			
		}
		
		
		
		
		
		
		
		
		
		
		
	}

}
