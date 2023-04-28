package while_;

public class Test1 {

	public static void main(String[] args) {
		/*
		 * 중첩 while문을 사용하여 구구단 2단 ~ 9단 출력
		 * 
		 * < 2단 >
		 * 2 * 1 = 2
		 * 2 * 2 = 4
		 * ...
		 * 2 * 9 = 18
		 * 
		 * < 3단 >
		 * 3 * 1 = 3
		 * 3 * 2 = 6
		 * ...
		 * 
		 * < 9단 >
		 * ...
		 * 9 * 9 = 81
		 * 
		 * */
		
		int dan = 2;
		while(dan <= 9) {	// 단
			
			System.out.println("< " + dan + "단 >");
			
			int i = 1;
			while(i <= 9) {	// 곱해지는 수
				
				System.out.println(dan + " * " + i + " = " + dan*i);
				i++;
			}
			
			System.out.println();
			dan++;
		}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
