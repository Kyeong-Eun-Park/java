package interface_;

public class Ex2 {

	public static void main(String[] args) {

	}
}

// 클래스 상속 시 다중 상속이 안되는 이유
abstract class 동물클래스 {
	public abstract void 번식();
}

class 고래클래스 extends 동물클래스 {

	@Override
	public void 번식() {
		System.out.println("새끼를 낳아 번식!");
	}
}

class 상어클래스 extends 동물클래스 {

	@Override
	public void 번식() {
		System.out.println("알을 낳아 번식!");
	}
}

// 만약, 고래클래스와 상어클래스를 동시에 상속받아 고래상어 클래스 정의한다면
// 다중 상속 시 부모의 메서드가 동일할 경우 메서드 접근이 모호성이 발생할 수 있으므로
// 자바에서는 다중상속을 허용하지 않는다!!!
//class 고래상어클래스 extends 고래클래스, 상어클래스 {
//	public void 부모의번식() {
//		super.번식();	 // 이 번식 메서드는 고래와 상어 중 누구의 번식 메서드인가?
//		// 따라서, 자바에서는 모호한 상황을 차단하기 위해 애초부터 다중 상속을 허용하지 않음
//	}
//}
// ==============================================================
interface 고래인터페이스 {
	public void 번식();
}

interface 상어인터페이스 {
	public void 번식();
}

// 인터페이스 끼리 다중 extends
//interface 고래상어인터페이스 extends 고래인터페이스, 상어인터페이스 {
//	
//}

// 구현클래스에서 다중 implements
class 고래상어 implements 고래인터페이스, 상어인터페이스 {

	@Override
	public void 번식() {
		// 추상메서드인 번식() 메서드를 상속받아 구현하더라도
		// 어느 부모의 번식() 메서드인지 구별할 필요가 없다! = 모두 추상메서드이기 때문
		// => 실행할 내용을 서브클래스에서 직접 정의하면 되기 때문에 부모의 메서드는 무관함
		// => 모든 구현은 서브클래스에게 맡기고, 인터페이스는 메서드 형식(표준)만 규정하는 역할
		System.out.println("고래상어는 상어처럼 알을 낳아 번식한다!");
	}
	
}





