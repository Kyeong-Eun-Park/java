package variable;

public class Test3 {

	public static void main(String[] args) {
		/*
		 * printf(), println() 활용하여 구구단 출력
		 * 
		 * < 2단 >
		 * 2 * 1 = 2
		 * 2 * 2 = 4
		 * 2 * 3 = 6
		 * ...
		 * 2 * 9 = 18
		 * 
		 * */
		int dan = 5;
//		String은 %s 사용
//		int는 %d 사용
		
		// printf()
		System.out.printf("< %d단 >\n", dan);
		System.out.printf("%d * 1  = %d\n", dan, dan*1);
		System.out.printf("%d * 2  = %d\n", dan, dan*2);
		System.out.printf("%d * 3  = %d\n", dan, dan*3);
		System.out.printf("%d * 4  = %d\n", dan, dan*4);
		System.out.printf("%d * 5  = %d\n", dan, dan*5);
		System.out.printf("%d * 6  = %d\n", dan, dan*6);
		System.out.printf("%d * 7  = %d\n", dan, dan*7);
		System.out.printf("%d * 8  = %d\n", dan, dan*8);
		System.out.printf("%d * 9  = %d\n", dan, dan*9);

		System.out.println("------------------------------------");
		
		// println()
		System.out.println("< " + dan + "단 >");
		System.out.println(dan + " * 1 = " + dan*1);
		System.out.println(dan + " * 2 = " + dan*2);
		System.out.println(dan + " * 3 = " + dan*3);
		System.out.println(dan + " * 4 = " + dan*4);
		System.out.println(dan + " * 5 = " + dan*5);
		System.out.println(dan + " * 6 = " + dan*6);
		System.out.println(dan + " * 7 = " + dan*7);
		System.out.println(dan + " * 8 = " + dan*8);
		System.out.println(dan + " * 9 = " + dan*9);


		
		
	}

}
