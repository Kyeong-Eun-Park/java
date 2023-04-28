package interface_;

public class Ex3 {

	public static void main(String[] args) {
		// 인터페이스 끼리의 상속
	}
}

interface IHello {
	public void sayHello(String name);
}

interface IGoodBye {
	public void sayGoodBye(String name);
}

// 인터페이스 끼리 상속을 받을 경우 extends 키워드를 사용해야한다!
// => 인터페이스가 가질 수 있는 메서드는 모두 추상메서드 이므로
//    부모 인터페이스를 상속받아 구현할 수 없기 때문에
//    인터페이스끼리의 상속은 구현(implements)이 아닌 확장(extends)을 사용
// 또한, 클래스 상속과는 달리 2개 이상의 인터페이스를 상속받을 수 있다!
// => 부모 인터페이스의 모든 메서드가 추상메서드이므로
//    부모 인터페이스들 중 누구의 메서드인지 구별할 필요가 없이
//    서브인터페이스도 추상메서드 형태로 보관하기 때문이다!
interface ITotal extends IHello, IGoodBye {
	public void greeting(String name);
}

// 2개의 인터페이스를 상속받은 ITotal 인터페이스를
// 서브클래스에서 상속받아 구현하면 모든 인터페이스의 내용을 구현하게 된다!
// 만약, 하나라도 추상메서드를 구현하지 않으려면 추상클래스로 선언해야한다! 
class ISay implements ITotal {

	@Override
	public void sayHello(String name) {}

	@Override
	public void sayGoodBye(String name) {}

	@Override
	public void greeting(String name) {}
	
}

// -------------------------------------------
abstract class ISay2 implements ITotal {
	@Override
	public void sayGoodBye(String name) {}
	@Override
	public void sayHello(String name) {}
}

class ISay2SubClass extends ISay2 {

	// 추상클래스인 ISay2 클래스를 상속 받더라도 미구현 된 greeting() 메서드만 구현하면 된다!
	// => 다른 메서드 오버라이딩도 가능하지만, 강제성은 greeting() 메서드에만 부여됨
	@Override
	public void greeting(String name) {}
}











