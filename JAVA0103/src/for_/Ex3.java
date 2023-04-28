package for_;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 중첩 for문
		 * - for문 내에 또 다른 for문을 기술하여 반복 문장을 여러번 반복하는 문
		 * 
		 * < 기본 문법 >
		 * for(초기식1; 조건식1; 증감식1){
		 * 
		 * 		for(초기식2; 조건식2; 증감식2){
		 * 
		 * 		}
		 * 
		 * }
		 * */
		
		for(int dan = 2; dan <= 9; dan++) { // 단
			
			System.out.println("< " + dan + "단 >");
			
			for(int i = 1; i <= 9; i++) { // 곱하는수
				System.out.println(dan + " * " + i + " = " + dan*i);
			}
			System.out.println();
		}
		
		
		
		
		
	}

}
