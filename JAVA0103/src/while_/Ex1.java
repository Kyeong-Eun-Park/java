package while_;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 중첩 while문
		 * - while문 내에 또 다른 while문을 기술하여 반복 문장을 여러번 반복하는 문
		 * - 기존 반복문을 바깥쪽 while문 이라고 가정했을때
		 *   해당 반복문 내에서 다시 반복을 수행하는 while문을 안쪽 while문이라고 함
		 *   => 안쪽 while문 반복 횟수 = 안쪽 while문 반복횟수 * 바깥쪽 while문 반복횟수
		 * < 기본 문법 >
		 * 초기식1;
		 * while(조건식1){
		 * 		실행문1;
		 * 
		 * 		초기식2;
		 * 		while(조건식2){
		 * 			실행문2;
		 * 			증감식2;
		 * 		}
		 * 
		 * 		증감식1;
		 * }
		 * 
		 * */
		
		int i = 1;
		while(i < 60) {
			System.out.println("i = " + i);
			
			int j = 1;
			while(j < 60) {
				System.out.println("----- j = " + j);
				j++;
			}
			
			i++;
		}
		
		
		
		
		
		
		
	}

}
