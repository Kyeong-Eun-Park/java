package override;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 메서드 오버라이딩 (Method Overriding)
		 * - 슈퍼클래스로 부터 상속받은 메서드를 서브클래스에서 새롭게 재정의 하는것
		 * - 반드시 상속관계에서 상속받은 메서드에 대해서만 적용 가능
		 * - 서브클래스에서 오버라이딩 수행 후에는 슈퍼클래스의 메서드는 은닉됨
		 * 
		 * < 메서드 오버라이딩 규칙 >
		 * 1. 슈퍼클래스의 메서드와 시그니처(리턴타입, 메서드명, 매개변수)가 동일 해야함
		 * 2. 접근제한자는 범위가 좁아질 수 없다.
		 *    ( => 부모가 public이면 자식도 public만 선택 가능함) 
		 * */
		Child c = new Child();
		c.parentPrn(); // 서브클래스에서 오버라이딩된 parentPrn() 메서드가 호출됨
		// => 이때, 오버라이딩된 메서드로 인해 슈퍼클래스의 메서드는 은닉되기 때문에
		//    Child 인스턴스를 통해서는 Parent 클래스의 parentPrn() 접근이 불가능
		c.childPrn();
		
		System.out.println("===================");
		
		Parent p = new Parent();
		p.parentPrn();
		System.out.println("===================");
		
		Dog dog = new Dog();
		Cat cat = new Cat();
		dog.cry();
		cat.cry();
		
		System.out.println("===================");
		
		AirUnit au = new AirUnit();
		au.move(10, 20);
		
		GroundUnit gu = new GroundUnit();
		gu.move(100, 200);
	}

}

class Unit {
	public void move(int x, int y) {
		System.out.println("전달받은 x, y 좌표로 이동");
	}
}

class AirUnit extends Unit {	// 공중유닛
	// 공중유닛은 클릭한 위치로 이동하는데
	// 아무제약이 없으므로 재정의할 필요가 없음
}

class GroundUnit extends Unit { // 지상유닛

	@Override
	public void move(int x, int y) {
		System.out.println("장애물 체크 후 우회하여 x, y좌표로 이동");
	}	
}


// ====================================================
class Animal {
	String name;
	int age;
	
	public void cry() {
		System.out.println("동물 울음소리!");
	}
}

class Dog extends Animal {
	// 자동 오버라이딩 단축키: Alt + Shift + S -> V
	@Override
	public void cry() {
		// @Override 표시는 어노테이션(Annotation) 기능으로 자바 컴파일러를 위한 주석
		// 이 메서드가 오버라이딩 되어 있다는 표시이므로, 반드시 오버라이딩만 가능하며
		// 오버라이딩 규칙을 위반할 경우 오류가 발생!
		System.out.println("멍멍!");
	}
}

class Cat extends Animal {

	@Override
	public void cry() {
		System.out.println("야옹!");
	}
}

// ==================================================
class Parent {
	public void parentPrn() {
		System.out.println("슈퍼클래스의 parentPrn()");
	}
}

class Child extends Parent {
	// Parent 클래스의 parentPrn() 메서드를 상속받아 오버라이딩을 수행
	// => 슈퍼클래스인 Parent 클래스의 parentPrn() 메서드와 시그니처를 동일하게 정의하고
	//    접근제한자는 public이므로 다른 접근제한자로 변경 불가 (좁아질 수 없음)
	public void parentPrn() {
		System.out.println("서브클래스에서 오버라이딩된 parentPrn()");
	}
	
	public void childPrn() {
		System.out.println("서브클래스의 childPrn()");
	}
}








