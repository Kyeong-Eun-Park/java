package break_continue;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * break & continue
		 * - 반복문 내에서 반복문을 제어하는데 사용
		 * - 주로 조건식(if문 등)과 결합하여 사용
		 * 
		 * 1. break 문
		 * - 현재 수행중인 반복문을 종료하고 빠져나가는데 사용
		 * - break 문을 만나면 반복문 내의 break문 보다 아래쪽 문장 실행을 생략하고
		 *   즉시 반복문을 빠져나감.
		 * 
		 * 2. continue 문
		 * - 현재 수행중인 반복문의 특정 문장 실행을 생략하는데 사용
		 * - 현재 수행중인 반복문의 continue문보다 아래쪽 문장 실행을 생략하고
		 *   다음 반복을 진행하기 위해 위로 점프
		 * - for문에서 continue문은 증감식으로 이동하며, while문은 조건식으로 이동함
		 * */
		
		int i = 1;
		while(true) {
			System.out.println(i);
			
			if(i == 5) {
				break;
			}
			
			i++;
		}
		System.out.println("while문 종료 후 i: " + i);
		
		System.out.println("===========================================");
		
		for(i = 1; i <= 10; i++) {
			
			if(i % 2 == 1) { // 홀수일 경우
				continue;
			}
			
			System.out.println(i);
		}
		
		System.out.println("---------------------------");
		
		i = 0;
		while(i <= 10) {
			// 주의! while문 내에서 continue문을 사용해야할 경우
			// 제어변수를 제어하는 증감식이 continue문보다 윗쪽에 위치해야한다!
			// => 아래쪽에 위치할 경우 실행되지 못하고 무한루프에 빠질 수 있다!
			i++;
			if(i % 2 == 1) {
				continue;
			}
			System.out.println(i); // 2, 4, 6, 8, 10
			
		}
		
		
		
		
		
		
		
		
	}

}
