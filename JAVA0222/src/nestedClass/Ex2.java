package nestedClass;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * Builder Pattern
		 * - 자바의 여러가지 패턴 종류 중 하나
		 * - 인스턴스 생성 시 멤버변수의 갯수가 많아질 경우 다양한 방식으로
		 *   객체 생성을 위해서 생성자 오버로딩이 필요한데 생성자 오버로딩으로는 한계가 있다.
		 * - 필요한 멤버변수만 초기화 하면서 생성하고 싶은 경우에 빌더패턴이 사용됨
		 * - Spring(Spring boot 포함) 에서 @Builder 어노테이션만 사용하면
		 *   해당 클래스는 Builder 패턴으로 객체를 생성할 수 있음  
		 * - 특히 안드로이드에서 이미 제공해주는 클래스로 객체 생성할때 Builder 패턴이 자주보임   
		 * */
		// 1. 생성자 오버로딩 활용시
		// 문제점)
		//	- 생성자 오버로딩에 한계가 있음
		//	- 어떤 멤버변수가 초기화되는지 코드만 봐서는 알 수 없음
		new NormalPerson("홍길동", "901212-1234567");
		new NormalPerson("901212-1234567", "홍길동");
		// => new NormalPerson(name, jumin) 이지만 순서가 맞지 않아도 생성됨
		// =============================================================
		
		// 2. Setter 메서드를 활용한 SetterPerson
		// => 다양한 생성자를 오버로딩할 필요없이
		//	  필요한 멤버변수만 초기화가 가능해짐
		SetterPerson sp = new SetterPerson();
		sp.setJumin("901212-1234567");
		sp.setAge(10);
		
		// Setter 활용시 문제점)
		// 	- 한번의 생성자로 멤버변수를 초기화할 수 없음 (생성 후 데이터를 초기화하고 있음)
		//	- 불변의 객체를 만들 수 없음
		//	  => 파라미터로 해당 객체를 전달 후 객체를 조작하면
		//       참조변수 즉, 주소를 전달했으므로 변경된 데이터로 동작할것임
		//       ex. 어떤클래스 a = new 어떤클래스("이순신");
		//			 a.메서드(); <-- name이 이순신인 상태로 동작
		//			 a.setName("홍길동");
		//			 a.메서드(); <-- 위와 다르게 홍길동인 상태로 동작
		// =============================================================
		
		// 3. Builder 패턴적용
		// => new BuilderPerson을 직접 생성할 방법이 사라짐 (생성자 private)
		// => 어떤 멤버변수가 초기화 되고 있는지 코드만 봐서도 알 수 있음
		// => 모든 멤버변수가 private 처리되어 외부에서 조작할 수 없음
		// => 필요한 멤버변수만 set메서드를 활용하여 초기화 가능
		//    (실제로 멤버변수가 50개 정도는 될것이기 때문에 매우 유용!)
		BuilderPerson bp = new BuilderPerson.Builder("901212-1234567")
											.setAge(20)
											.setName("2420")
											.build();
//		bp.setName("이순신"); 
		// => setter 메서드를 정의하지 않아 객체생성 후 조작 불가 (불변객체 완성)
		
	}

}


// 1. 생성자 오버로딩 활용시
class NormalPerson {
	
	private String name;
	private String jumin;
	private int age;
	
	// 생성 방식을 보기위해 멤버변수 초기화 코드는 생략함
	public NormalPerson() {}
	public NormalPerson (String name) {}
//	public NormalPerson (String jumin) {} // 주민번호만 초기활 할 수 없음 (오버로딩 규칙 위반)
	public NormalPerson (String name, String jumin) {}
//	public NormalPerson (String jumin, String name) {}
	public NormalPerson (int age, String name) {}
//	public NormalPerson (int age, String jumin) {}
	public NormalPerson (String name, String jumin, int age) {}
}

// 2. 객체 생성 후 setter 메서드로 초기화 SetterPerson
class SetterPerson {
	private String name;
	private String jumin;
	private int age;
	
	public void setName(String name) {
		this.name = name;
	}
	public void setJumin(String jumin) {
		this.jumin = jumin;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

// 3. Builder 패턴 적용
class BuilderPerson {
	private String name;
	private String jumin;
	private int age;
	
	// 외부에서 생성할 수 없도록 private
	private BuilderPerson(Builder builder) {
		this.name = builder.name;
		this.jumin = builder.jumin;
		this.age = builder.age;
	}
	
	static class Builder {
		private String name;
		private String jumin;
		private int age;
		
		// 만약 필수 데이터가 필요하다면 파라미터 생성자 정의
		public Builder(String jumin) {
			this.jumin = jumin;
		}
		
		// 전달받은 파라미터로 멤버변수가 초기화된 자기자신(this)을 리턴함으로써
		// 계속해서 다른 메서드를 호출할 수 있도록 함
		public Builder setName(String name) {
			this.name = name;
			return this;
		}
		
		public Builder setAge(int age) {
			this.age = age;
			return this;
		}
		
		// 최종적으로 BuilderPerson을 생성하여 리턴함
		public BuilderPerson build() {
			return new BuilderPerson(this);
		}
	}
}







