package method;

public class Ex1 {

	public static void main(String[] args) {
		
		/*
		 * 객체지향 프로그래밍의 특징 (A.P.I.E)
		 * 
		 * 캡슐화 (Encapsulation) = 은닉성
		 * - 객체 내부의 구조(멤버변수 및 메서드 처리 과정)를 외부로부터 숨기고
		 *   메세지만으로 객체와 통신하도록 하는것
		 * - 클래스 정의 시 멤버변수를 private 접근제한자를 사용하여 외부 접근을 차단하고
		 *   public 접근제한자가 선언된 Getter / Setter 메서드를 정의하여
		 *   간접적으로 객체 내의 멤버변수에 접근하도록 하는것  
		 * - 모든 Getter / Setter 메서드는 누구나 접근 가능하도록 접근제한자 public을 사용
		 * - Getter 메서드는 내부 멤버변수 값을 외부로 리턴하는 역할을 수행하며
		 *   메서드 이름은 getXXX() 형태 (XXX: 리턴할 멤버변수 이름) 하고
		 *   파라미터는 없고, 리턴타입은 리턴할 멤버변수의 데이터타입을 지정
		 *   ex) 멤버변수 name에 대한 Getter 메서드명: public String getName(){}
		 * - Setter 메서드는 외부로부터 전달받은 값을 내부 멤버변수에 저장하는 역할을 수행하며
		 *   메서드 이름은 setXXX() 형태 (XXX: 데이터를 저장할 멤버변수 이름)
		 *   파라미터는 전달받은 데이터의 데이터타입을 지정하고, 리턴타입은 없으므로 void 지정
		 *   ex) 멤버변수 name에 대한 Setter 메서드명: public void setName(String name){}
		 * - Getter/Setter 자동 생성 단축키 : Alt + Shift + S -> R    
		 * */
		
		Student s = new Student();
		
		s.setName("홍길동");
		s.setAge(20);
		s.setScore(120900283);
		
		System.out.println(s.getName());
		System.out.println(s.getAge());
		System.out.println(s.getScore());
		
		System.out.println("-----------------------");
		s.score = 120900283;
		System.out.println(s.score);
	}

}

class Student {
	private String name;
	private int age;
	int score;
	
	// 멤버변수 name 값을 외부로 리턴하는 Getter 메서드 정의
	// => 파라미터: 없음, 리턴타입: String(이름(name) 리턴)
	public String getName() {
		return name;
	}
	
	// 이름(name)을 외부로 부터 전달받아 내부 멤버변수 name에 저장하는 Setter 메서드 정의
	// => 파라미터: 이름(String타입, name), 리턴타입: 리턴값이 없으므로 void
	public void setName(String name) {
		this.name = name;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		this.age = age;
	}

	// Getter / Setter 자동 생성 단축키 : Alt + Shift + S -> R
	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		if(score > 100) score = 100;
		if(score < 0) score = 0;
		this.score = score;
	}
	
//	public Student(String name, int age, int score) {
//		this.name = name;
//		this.age = age;
//		this.score = score;
//	}
	
	
	
	
}

