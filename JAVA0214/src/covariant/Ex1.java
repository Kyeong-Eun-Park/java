package covariant;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 공변(Covariant)
		 * - 공변의 사전적 의미는 "하나가 변하면 다음것이 따라 변한다" 라는 뜻이다.
		 * 
		 * 오버라이딩 시에 "공변 리턴 타입" (다형성 polymorphism의 일종)
		 * - 오버라이딩이란 "부모 메서드와 시그니처가 완전히 동일한 메서드를 재정의하는 것"
		 *   => 시그니처: 리턴타입, 메서드명, 매개변수(갯수, 데이터타입, 순서)
		 * - 하지만, 메서드 오버라이딩 시 부모메서드 리턴타입에 하위타입이면 오버라이딩 가능  
		 * */
		// 1. 실제 객체와 참조변수의 타입이 동일한 상황
		A a = new A();
		B b = new B();
		// 2. 실제 객체와 참조변수의 타입이 다른 상황
		A a2 = new B(); // 업캐스팅	(A타입에 저장되어 있지만 실제 객체는 B)
		B b2 = (B)a2;	// 다운캐스팅	(실제 객체도 B)
		
		// 각각의 참조변수로 print() 메서드 호출
		a.print();
		b.print();
		a2.print();
		b2.print();
		// => print() 메서드가 오버라이딩 되어있기 때문에
		//    동적바인딩으로 인해 실행시점에서 실제 객체의 메서드가 실행된다!
		// 결론, 어느 타입에 저장되어 있으냐가 중요한것이 아니라
		// "실제 객체에 무엇이냐가 중요함!!!"
		System.out.println("==============================");
		
		A aType;
		B bType;
		
		aType = a.method();
		System.out.println(aType == a);
//		bType = a.method();	// 리턴타입이 A이므로 B로 다운캐스팅!
//		bType = (B)a.method(); // 문법적 오류는 아니나 실제 객체가 A타입이므로
							   // 실행시점에 오류발생!
		bType = b.method();
		aType = b.method();	// 리턴타입이 자식클래스 이므로 업캐스팅 가능
		
		System.out.println("------------------------------");
		aType = a2.method();
//		bType = a2.method();
		// => 참조변수 a2에 저장되어있는 실제 객체는 B타입이다
		//    그렇다면 오버라이딩된 method()가 호출되어 B타입이 리턴되어야 하는데?
		//    => 어디까지나 동적바인딩의 원리를 우리가 알고 있기 때문에 B클래스 method() 가
		//       실행된다고 알고 잇는 것이고, 컴파일시점 즉, 번역시점에는 A타입 참조변수로 method()
		//       를 호출하고 있기 때문에 A가 리턴되것으로 번역되므로 문법적오류 즉, 컴파일 오류발생!!
		
		bType = (B)a2.method();
		// => 실제 리턴된 객체가 B타입이므로
		//    실행시점 즉, 런타입 오류도 발생하지 않음
		
		
	}

}

class A {
	public void print() {
		System.out.println("A");
	}
	
	public A method() {
		System.out.println("A 메서드가 실행됨!");
		return this;
	}
}

class B extends A {

	@Override
	public void print() {
		System.out.println("B");
	}

	// 공변 리턴타입: 리턴타입을 부모메서드 리턴타입의 하위타입으로 설정 가능!!
	@Override
	public B method() {
		System.out.println("B 메서드가 실행됨");
		return this;
	}
	
	
}





