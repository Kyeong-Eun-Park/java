package ex10_14;

public class Ex11 {

	public static void main(String[] args) {
		// 386p
		
		// Q1) 정답: equals
		// 두 개의 인스턴스가 메모리는 다르더라도 논리적으로 동일하다는 것을 구현하는
		// Object의 메서드는 XXX 입니다.
		
		// Q2) 
		// String 클래스는 멤버로 가지는 문자열 변수가 final 이어서 변하지 않습니다.
		// 다음과 같이 두개의 String 변수를 연결할 때 
		// 힙 메모리에 생성되는 String 인스턴스를 그려보세요.
		String a = "abc";
		String b = "def";
		a = a + b;
		String c = "abcdef";
		System.out.println(a);
		System.out.println(c);
		System.out.println(a == c);
		String d = "abc";
		// + 연산자를 사용해 문자열을 결합하는 것은 매 연산 시 마다 새로운 물자열을 가진
		// String 인스턴스가 생성되어 메모리공간을 차지하게 되므로 
		// 가능한 한 결합횟수를 줄이는 것이 좋다.
		
		// Q3) 정답: Wrapper 클래스
		// 기본 자료형을 멤버변수로 포함하여 메서드를 제공함으로써
		// 기본 자료형의 객체를 제공하는 클래스를 XXX 라고 합니다.
		
		// Q4)
		// 다음 코드의 출력 결과가 '진돗개 멍멍이' 가 되도록 MyDog 클래스를 수정하세요.
		MyDog dog = new MyDog("멍멍이", "진돗개");
		System.out.println(dog);
	}
}

class MyDog {
	String name;
	String type;
	
	public MyDog(String name, String type) {
		this.name = name;
		this.type = type;
	}

	@Override
	public String toString() {
		return type + " " + name;
	}
	
	
}






