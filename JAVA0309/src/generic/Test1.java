package generic;

import java.util.ArrayList;
import java.util.List;

public class Test1 {

	public static void main(String[] args) {
		/*
		 * Collection (ArrayList)을 활용하여 Person 객체 여러개를
		 * 저장 후 일반 for문과 향상된 for문을 활용하여 Person 정보 출력!
		 * */
		List<Person> list = new ArrayList<Person>();
		
		Person p = new Person("홍길동", 20);
		list.add(p);
		list.add(new Person("강감찬", 40));
		list.add(new Person("김태희", 50));
		
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
//			Person person = list.get(i);
		}
		
		for(Person person : list) {
			System.out.println(person);
		}
		
	}
}

/*
 * Person 클래스 정의
 * - 멤버변수(private): 이름(name, 문자열), 나이(age, 정수)
 * - 생성자: 이름과 나이를 전달받아 초기화하는 생성자
 * - toString() 메서드 오버라이딩 (이름과 나이를 결합하여 리턴)
 * - Getter / Setter 정의 
 * */
class Person {
	private String name;
	private int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
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






