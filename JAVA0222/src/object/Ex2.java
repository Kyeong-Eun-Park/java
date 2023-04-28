package object;

import java.util.Objects;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 3. equals() 메서드
		 * - 두 객체가 같은 객체인지를 판별하는 메서드
		 * - Object 클래스의 equals() 메서드는 두 객체의 주소값(참조값)을 비교하여
		 *   주소값이 같으면 true, 서로 다르면 false리턴
		 * 
		 * */
		int num1 = 10;
		int num2 = 10;
		
		// 기본 데이터타입 변수값을 비교할 때 동등비교연산자(==)를 통해 같은지를 비교
		// => 기본 데이터타입 변수에 같은 값을 저장할 경우 동등비교연산 결과는 true
		if(num1 == num2) {
			System.out.println("num1, num2 는 같다!");
		} else {
			System.out.println("num1, num2 는 다르다!");
		}
		
		// 인스턴스를 생성할 때마다 서로 다른 메모리 공간에 인스턴스가 생성되므로
		// 해당 인스턴스의 주소값도 인스턴스마다 달라진다!
	 	Object obj1 = new Object();
	 	Object obj2 = new Object();
		
		if(obj1 == obj2) {
			System.out.println("obj1, obj2 는 같다!");
		} else {
			System.out.println("obj1, obj2 는 다르다!");
		}
		
		Object obj3 = obj1;
		if(obj1 == obj3) {
			System.out.println("obj1, obj3 는 같다!");
		} else {
			System.out.println("obj1, obj3 는 다르다!");
		}
		System.out.println("--------------------------------------");
		// 참조변수명.equals(비교할참조변수명) 형태로 사용
		// => 동등비교연산을 통한 비교 결과와 동일한 결과가 출력됨
		if(obj1.equals(obj2)) {
			System.out.println("obj1, obj2 는 같다!");
		} else {
			System.out.println("obj1, obj2 는 다르다!");
		}
		
		String str1 = "abc";
		String str2 = new String("abc");
		if(str1 == str2) {
			System.out.println("str1, str2 는 같다!");
		} else {
			System.out.println("str1, str2 는 다르다!");
		}
		
		if(str1.equals(str2)) {
			System.out.println("str1, str2 는 같다!");
		} else {
			System.out.println("str1, str2 는 다르다!");
		}
		
		System.out.println("===================================");
		// 일반적으로 현실에서 두 객체가 같은가? 라는 질문은 두객체의 주소값이 아닌
		// 객체 내에 저장된 실제 데이터가 같은지를 물어보는 것이 일반적이다.
		// 그러나, equals() 메서드는 두 객체의 주소값을 비교하므로
		// 두 객체에 저장된 데이터가 같더라도 false가 리턴되므로 적합하지 않다.
		Person p1 = new Person("홍길동", 20);
		Person p2 = new Person("홍길동", 20);
		
		if(p1.equals(p2)) {
			System.out.println("p1 과 p2 가 같다!");
		} else {
			System.out.println("p1 과 p2 가 다르다!");
		}
		
		System.out.println("======================================");
		
		EqualsPerson p3 = new EqualsPerson("홍길동", 20);
		EqualsPerson p4 = new EqualsPerson("홍길동", 20);
		
		if(p3.equals(p4)) {
			System.out.println("p3 과 p4의 실제 값이 같다!");
		} else {
			System.out.println("p3 과 p4의 실제 값이 다르다!");
		}
		
	}

}

class EqualsPerson {
	String name;
	int age;
	public EqualsPerson(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	// Object 클래스의 equals() 메서드를 오버라이딩 하여
	// 모든 멤버변수가 같으면 true, 하나라도 다르면 false를 리턴하도록 구현
//	@Override
//	public boolean equals(Object obj) { // p3.equals(p4)
//		
//		// 참조영역 축소로 인해 obj에서 age변수가 보이지 않는다!
////		if(this.age == obj.age) {}
//		if(obj instanceof EqualsPerson ) {
//			EqualsPerson p = (EqualsPerson)obj;
//			if(age == p.age && name.equals(p.name)) {
//				return true;
//			} 
//		} 
//		
//		return false;
//	}
	
	// equals() 메서드 자동 오버라이딩 단축키 : Alt + Shift + S -> H
	@Override
	public boolean equals(Object obj) {	// p3.equals(p4)
		if (this == obj)	// p3.equals(p3)
			return true;
		if (obj == null)	// 1. p3.equals(null)
							// 2. EqualsPerson p5;
							//    p3.equals(p5);
			return false;
		if (getClass() != obj.getClass())	// p3.equals(p1)
											// p3: EqualsPerson, p1: Person
			return false;
		EqualsPerson other = (EqualsPerson) obj;
		return age == other.age && Objects.equals(name, other.name);
	}
	
}








