package static_;

class StaticMember {
	static int a = 10;
	int b = 20;
	
	public void normalMethod() {
		System.out.println("일반 메서드!");
	}
	
	public static void staticMethod() {
		System.out.println("static 메서드!");
	}
}

public class Ex1 {

	public static void main(String[] args) {
//		StaticMember sm = new StaticMember();
//		sm.normalMethod();
		/*
		 * < 자바 프로그램 실행 과정 >
		 * 1. 소스 코드 작성 및 컴파일(번역) 후 클래스 실행(Ctrl + F11)
		 * 2. 클래스 로딩 - 클래스 멤버변수 및 메서드가 메모리에 로딩
		 * 3. main() 메서드 호출(실행) - JVM이 알아서 호출
		 * 4. 인스턴스 생성 - 인스턴스 멤버변수 및 메서드가 메모리에 로딩
		 * 5. 메서드 호출(실행) - 메서드 내의 로컬 변수가 메모리에 로딩
		 * 6. 결과 출력
		 * 
		 * < static 키워드 >
		 * - 정적(고정된) 이라는 의미를 갖는 키워드
		 * - 클래스, 메서드, 변수의 지정자로 사용가능
		 * - 멤버 메서드 또는 변수에 static 키워드를 사용할 경우
		 *   인스턴스 생성과 관계없이 클래스가 로딩되는 시점에 함께 메모리에 로딩됨
		 *   => 인스턴스 생성 전에 메모리에 로딩됨
		 *      따라서, 인스턴스 생성 없이도 접근 가능(클래스명만으로 접근 가능)
		 * 
		 * < static 멤버변수 >
		 * - 멤버변수 선언부 데이터타입 앞에 static 키워드를 사용하여 선언함
		 * - 인스턴스 생성전, 클래스가 메모리에 로딩될때 static 변수도 함께 로딩됨
		 *   => Heap 공간이 아닌 Method Area (Static Area)에 변수가 생성됨 (공유영역)
		 * - 모든 인스턴스가 하나의 변수를 공유함
		 *   (= 클래스 당 하나의 변수만 생성되며, 해당 변수를 모든 인스턴스가 공유)
		 * - 참조변수 없이 클래스 명만으로 해당 멤버에 접근 가능
		 *   (클래스명.멤버변수명)    
		 * 
		 * < static 메서드 >
		 * - static 멤버변수와 마찬가지로 클래스 로딩 시 함께 메모리에 로딩되므로
		 *   클래스명만으로 호출 가능한 메서드
		 *   (클래스명.메서드명())
		 * 
		 * */
		
//		System.out.println(s1.a); // 오류! 참조변수 선언 전 접근 불가능
		// => 일반 멤버변수는 반드시 인스턴스 생성 후 참조변수를 통해서만 접근이 가능!
		
		// static 멤버(클래스 멤버) 변수는 클래스명만으로 인스턴스 생성과 상관없이 접근 가능
		System.out.println("StaticMember.a = " + StaticMember.a);
		
		// static 멤버로 선언되지 않은 인스턴스 변수 b는 클래스명만으로 접근 불가!
//		System.out.println("StaticMember.b = " + StaticMember.b); // 오류!
		StaticMember s1 = new StaticMember();
		StaticMember s2 = new StaticMember();
		System.out.println("s1.a = " + s1.a + ", s2.a = " + s2.a);
		System.out.println("s1.b = " + s1.b + ", s2.b = " + s2.b);
		
//		s1.a = 99;
		// static 멤버변수 접근 시 참조변수로 접근도 가능하나
		// 주로 클래스명.멤버변수명 형태로 접근하는것이 올바른 접근방법이다!
		StaticMember.a = 99;
		System.out.println("s1.a = " + s1.a + ", s2.a = " + s2.a);
		// => s1 인스턴스의 멤버변수 a의 값만 변경하더라도
		//    static 변수이므로 모든 인스턴스가 해당 변수값을 공유하게 되어
		//    s2 인스턴스의 멤버변수 a도 99가 되어있다!
		//    => s1과 s2가 서로 다른 멤버변수가 아닌 하나의 멤버변수를 공유하고 있음
		
		// s2 인스턴스 변수 b의 값을 999로 변경
		s2.b = 999;
		System.out.println("s1.b = " + s1.b + ", s2.b = " + s2.b);
		// => s1과 s2는 서로 다른 인스턴스 변수 b를 갖게 되므로
		//    s2인스턴스의 변수 b의 값을 변경하더라도 s1인스턴스의 b는 영향을 받지 않는다!
		
		System.out.println("-----------------------------");
		
		// 일반메서드와 static 메서드 호출
		s1.normalMethod(); // 일반메서드 호출방법 (참조변수를 통해서 접근)
		s2.normalMethod();
//		StaticMemeber.normalMethod();
		
		StaticMember.staticMethod(); // static 메서드는 클래스 명만으로 호출가능!
		s1.staticMethod();
		
		
	}

}
