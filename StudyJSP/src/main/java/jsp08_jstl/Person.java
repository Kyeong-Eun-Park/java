package jsp08_jstl;

public class Person {
	// 이름을 저장하는 멤버변수 name 선언
	// 나이를 저장하는 멤버변수 age 선언
	// 기본 생성자 정의
	// name, age 파라미터를 전달받아 초기화하는 파라미터 생성자 정의
	// Getter/Setter 정의
	private String name;
	private int age;
	
	public Person() {
		super();
	}

	public Person(String name, int age) {
		super();
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

}
