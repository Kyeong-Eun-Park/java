package constructor;

public class Ex4 {

	public static void main(String[] args) {
		/*
		 * this 키워드
		 * 2. 생성자 this()
		 * 	- 하나의 생성자에서 자신의 클래스 내의 "또 다른" 생성자를 호출하는 코드
		 * 	- 생성자 오버로딩 수행할 경우 멤버변수 초기화 코드가 중복될 수 있다!
		 * 		=> 따라서, 코드 중복을 제거하기 위해 하나의 생성자에 작업 처리 코드를 기술하고
		 * 		   다른 생성자에서는 해당 생성자를 호출하여 데이터만 전달한 뒤
		 * 		   간접적으로 멤버변수를 초기화하도록 한다! => 중복 제거됨
		 * 	- this() 형식으로 호출하며, 생성자에 전달할 파라미터를 소괄호() 안에 기술
		 * 		=> 해당 파라미터 타입 및 갯수와 일치하는 생성자가 호출됨
		 * 	- 주의사항! 생성자 this()는 생성자 내에서 반드시 첫문장으로 실행되어야 한다!
		 * */
		Person2 p = new Person2();
		System.out.println("이름: " + p.name);
		System.out.println("나이: " + p.age);
		System.out.println("------------------");
		
		Person2 p2 = new Person2("이순신");
		System.out.println("이름: " + p2.name);
		System.out.println("나이: " + p2.age);
		System.out.println("------------------");
		
		Person2 p3 = new Person2("이순신", 44);
		System.out.println("이름: " + p3.name);
		System.out.println("나이: " + p3.age);
		System.out.println("------------------");
	}

}

class Person2 {
	
	String name;
	int age;
	
	public Person2() {
		this("홍길동");
//		this("홍길동", 20);
		System.out.println("Person2() 생성자 호출됨!");
//		name = "홍길동";
//		age = 20;
	}

	public Person2(String name) {
		this(name, 20);
		System.out.println("Person2(String) 생성자 호출됨!");
//		this.name = name;
//		age = 20;
	}

	public Person2(String name, int age) {
		System.out.println("Person2(String, int) 생성자 호출됨!");
		this.name = name;
		this.age = age;
	}
	
}











