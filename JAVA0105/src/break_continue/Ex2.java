package break_continue;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 중첩 반복문 내에서 break, continue 문 사용 시
		 * break문, continue문이 소속된 반복문에 효과가 적용됨
		 * 따라서, 원하는 반복문 블럭에 break, continue문을 적용하고 싶을 경우
		 * 레이블(Label) 기능을 활용하여 원하는 블럭 지정하고
		 * break, continue문 사용시 해당 레이블을 지정하도록 해야한다!
		 * 
		 * < 기본 문법 >
		 * 레이블명:
		 * 원하는 블록문 {
		 * 		안쪽 블록문 {
		 * 			조건식(){
		 * 				break 레이블명;
		 * 			}
		 * 		}
		 * }
		 * 
		 * */
		
		OUTTER: // 레이블1
		for(int dan = 2; dan <= 9; dan++) {
			System.out.println("< " + dan + "단 >");
			INNER: // 레이블2
			for(int i = 1; i <= 9; i++) {
				if(dan == 6) {
//					break; // 안쪽 for문을 종료하고 System.out.println(); 문장이 실행
//					continue; // 아래쪽 실행문을 생략하고 안쪽 for문의 증감식(i++)으로 이동
					
//					break INNER; // 일반 break문과 동일함
//					continue INNER; // 일반 continue문과 동일함
					
//					break OUTTER; // 바깥쪽 for문을 종료하고 "프로그램 종료!"
					continue OUTTER; // 바깥쪽 for문의 증감식(dan++) 으로 이동
					// dan이 6일때 i가 1일 경우 continue문을 만나
					// 안쪽 for문을 포함하여 바깥쪽 for문의 continue문 애로쪽 문장을 생략 후
					// 다음 바깥 for문 반복을 위해 증감식(dan++) 으로 이동
				}
				System.out.println(dan + " * " + i + " = " + (dan*i));
			}
			
			System.out.println();
		}
		
		System.out.println("프로그램 종료!");
		
		
		
		
		
	}

}
