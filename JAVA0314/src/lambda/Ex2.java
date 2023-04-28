package lambda;

// 1. 파라미터와 리턴타입 없는 경우
@FunctionalInterface
interface MyFunc1 {
	// 함수형 인터페이스 어노테이션(@FunctionalInterface) 선언시 에러 발생!
	// => 함수형 인터페이스는 반드시 하나의 추상메서드를 가져야함
	public void methodA();
//	public void methodB();
}

// 2. 파라미터가 있는 람다식
@FunctionalInterface
interface MyFunc2 {
	public void methodB(String msg);
}

// 3. 파라미터, 리턴타입이 있는 람다식
@FunctionalInterface
interface MyFunc3 {
	public String methodC(String msg);
}

public class Ex2 {

	// 1. 파라미터: X, 리턴타입: X
	public static void useFIMethodA(MyFunc1 fi) {
		fi.methodA();
	}
	// 2. 파라미터: O, 리턴타입: X
	public static void useFIMethodB(MyFunc2 fi) {
		fi.methodB("홍길동");
	}
	// 3. 파라미터: O, 리턴타입: O
	public static String useFIMethodC(MyFunc3 fi) {
		return fi.methodC("홍길동");
	}
	
	public static void main(String[] args) {
		/*
		 * 함수형 인터페이스 (functional interface) 또는 타켓타입(target type)
		 * - 람다식은 결과적으로 
		 *   "추상메서드가 1개 뿐인 인터페이스 타입의 클래스를 손쉽게 구현하는 방법"
		 * - 반드시 하나의 abstract 메서드만 존재
		 * - 만약 abstract 메서드가 없거나 두개 이상 존재한다면 람다식으로 대체할 수 없다!
		 * - 함수형 인터페이스 @FunctionalInterface 어노테이션 선언  
		 * */
		
		useFIMethodA(new MyFunc1() {
			
			@Override
			public void methodA() {
				System.out.println("익명 내부클래스 형태");
			}
		});
		
		useFIMethodA(() -> System.out.println("람다식"));
		
		useFIMethodB(new MyFunc2() {
			
			@Override
			public void methodB(String msg) {
				System.out.println(msg);
			}
		});
		
		useFIMethodB((String msg) -> { System.out.println(msg); });
		useFIMethodB(msg -> System.out.println(msg));
		
		useFIMethodC(new MyFunc3() {
			@Override
			public String methodC(String msg) {
				return msg;
			}
		});
		
		useFIMethodC((String msg) -> { return msg; });
		useFIMethodC(msg -> msg);
	}

}
