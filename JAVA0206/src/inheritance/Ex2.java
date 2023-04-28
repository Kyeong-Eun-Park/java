package inheritance;

public class Ex2 {

	public static void main(String[] args) {
		// private 접근제한자를 갖는 멤버는 상속 대상에서 제외됨
		// => private 접근제한자는 자신의 클래스내에서만 접근가능하고
		//    다른 클래스에서 접근 불가능하도록 제어 하므로
		//    상속받는 자식도 접근 불가능하기 때문에 상속되지 않는다!
		SpiderMan sm = new SpiderMan();
		sm.name = "피터 파커";
		sm.age = 20;
		sm.nickName = "친절한 이웃 스파이더맨";
		sm.eat();
		sm.jump();
		sm.fireWeb();
		// sm.normalLife(); // 오류! private 접근제한자로 선언된 메서드는 상속 불가!
		System.out.println("=========================");
		
		// 생성자도 상속 대상에서 제외됨
		// => 생성자의 이름은 클래스의 이름과 동일해야하는데
		//    생성자를 상속받을 경우 자신의 이름이 아닌 부모 클래스의 이름이 사용되므로
		//    생성자 작성 규칙을 위반하게 되므로 생성자는 상속되지 않는다!
		Person p = new Person("홍길동", 20);
//		SpiderMan sm2 = new SpiderMan("피터 파커", 20); // 오류!
		// => 생성자도 상속되지 않으므로, 서브클래스 타입의 파라미터 생성자 호출 불가능
		
		
	}
}

class Person {
	String name;
	int age;
	
	public Person() {}
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}
	
	public void eat() {
		System.out.println("밥 먹기!");
	}
	
	public void jump() {
		System.out.println("점프!");
	}
	
	private void normalLife() {
		System.out.println("평범한 삶!");
	}
}

class SpiderMan extends Person {
	String nickName;
	
	public void fireWeb() {
		System.out.println("거미줄 발사!");
	}
}











