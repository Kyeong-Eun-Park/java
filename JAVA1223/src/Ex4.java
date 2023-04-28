
public class Ex4 {

	public static void main(String[] args) {
		/*
		 * 변수(Variable)
		 * - 자바에서 사용되는 데이터를 저장하는 메모리 공간
		 * - 한번에 하나의 데이터만 저장 가능
		 *   => 언제든 다른 데이터로 대체될 수 있다. (변할 수 있다.)
		 * - 변수를 사용하기 위해선 변수 선언이 먼저 진행되어야함 
		 * - 변수에 데이터를 저장하는 것을 변수 초기화라고 함 
		 * 
		 * < 변수 선언 기본 문법 >
		 * 데이터타입 변수명;
		 * => 데이터타입 : 기본형 또는 참조형 타입명 명시
		 * => 변수명 : 식별자 작성 규칙에 따른 변수명 지정
		 * 
		 * < 변수 초기화 기본 문법 >
		 * 변수명 = 데이터(또는 변수명)
		 * => 우변의 데이터를 좌변의 변수에 저장(대입, 할달, 초기화)
		 * 
		 * */
		
//		int a;
//		int b;
//		a = 1;
//		System.out.println(a + 1);
////		System.out.println(b);
//		a = 2;
//		System.out.println(a + 1);
		
		// 선언과 초기화를 동시에
//		int a = 10;
//		int b = 20;
		
		// 동시에 여러개 변수를 선언
//		int a, b;
//		a = 10;
//		b = 20;
		
		// 동시에 여러개 변수를 선언과 동시에 초기화
		int a = 10, b = 20;
		
		int c = a;
//		c = a;
		a = b;
		b = c;
		
		System.out.println("a: " + a);
		System.out.println("b: " + b);
//		System.out.println(a + b);
		
//		String name;
//		name = "차동원";
//		System.out.println(name);
		
		
	}

}
