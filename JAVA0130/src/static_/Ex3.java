package static_;

public class Ex3 {
	/*
	 * < static 멤버(클래스 멤버)와 인스턴스 멤버의 메모리 할당 순서 >
	 * 1. 클래스가 메모리에 로딩
	 * 2. static 키워드가 선언된 모든 멤버(변수 및 메서드)가 메모리에 로딩됨
	 * 3. static 키워드가 선언된 멤버변수 a,c를 로딩하기 위해서
	 *    우변의 check() 메서드가 실행되어야 하므로 check() 메서드가 호출
	 *    => 이때, check() 메서드도 static 메서드 이므로 메모리에 로딩된 상태
	 *    => a와 c중 윗줄의 코드부터 차례대로 실행되므로
	 *    	1) static int a 가 로딩되기 때문에 check(1) 이 호출되어 "call : 1" 출력됨
	 *    	2) static int c 가 로딩되기 때문에 check(3) 이 호출되어 "call : 3" 출력됨
	 * 4. 모든 static 멤버의 로딩이 끝난 후 main() 메서드가 자동으로 호출됨(프로그램 시작점)   
	 * 	=> "main() 메서드" 출력됨
	 * 5. main() 메서드 내에서 Ex3 클래스의 인스턴스가 생성됨
	 *  => 인스턴스 생성 시 인스턴스 멤버변수 int b가 메모리에 로딩됨
	 *     이때, int b의 값 할당을 위해 check(2) 메서드가 호출되므로
	 *     "call : 2" 출력됨
	 * */
	int b = check(2);
	
	static int a = check(1);
	
	public static int check(int i) {
		System.out.println("call : " + i);
		return i;
	}
	
	public static void main(String[] args) {
		System.out.println("main() 메서드");
		Ex3 ex = new Ex3();
	}
	
	static int c = check(3);

}
