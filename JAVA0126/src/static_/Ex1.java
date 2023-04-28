package static_;



public class Ex1 {

//	public static void methodA() {}
//	public void methodB() {}
	
	public static void main(String[] args) {
//		methodB();
//		methodA();
		/*
		 * 변수 선언 위치에 따른 분류
		 * 1. 로컬 변수 (Local Variable)
		 * 	- 메서드 내부에서 선언된 변수 (for문, if문 등 포함)
		 *	- 주로 메서드의 중괄호 내부에서 선언되는 변수를 말하며
		 *    for문의 소괄호() 에서 선언되는 제어변수도 로컬 변수에 해당함
		 *    => 메서드 파라미터 부분인 소괄호() 에서 선언되는 변수를 별도로
		 *       파라미터 변수라고도 하지만, 로컬 변수로 통일해도 무관함
		 *  - 해당 변수가 선언된 위치로 부터 소속된 중괄호가 끝나는 지점까지만 접근 가능
		 *    => 라이프 사이클(Life Cycle) 이라고 하며,
		 *       로컬 변수의 라이프 사이클은 선언 지점부터 중괄호가 끝나는 지점까지 이다.
		 *  - 반드시 초기화 후에 사용 해야한다!     
		 *          
		 * 2. 멤버 변수 (Member Variable)
		 * 	- 클래스 내부, 메서드 외부에서 선언되는 변수
		 * 	- 클래스 내의 어느 위치에서라도 동일한 변수로 취급됨
		 * 	- 클래스 내의 생성자나 메서드 등에서 접근 가능
		 *  - 별도의 초기화를 하지 않을 경우 기본값으로 자동 초기화 됨
		 *  
		 *		1) 인스턴스 멤버 변수 (static X)
		 *		2) 클래스 멤버 변수 (static O)
		 *  
		 * */
		A.a = 10;
		A a = new A();
		A a2 = new A();
		
		System.out.println(a2.a);
		a2.a = 20;
		System.out.println(a.a);
		
		System.out.println("-------------------------");
		
		VariableEx ve = new VariableEx();
		
		System.out.println(ve.instanceMember);
		System.out.println(ve.instanceMember2);
		System.out.println(ve.classMember);
	}
}

class VariableEx {
	
	// 멤버 변수 선언
	String instanceMember = "인스턴스 멤버 변수";
	String instanceMember2; // 초기화 하지 않을 경우 기본값(null)으로 자동 초기화
	static String classMember = "클래스 멤버 변수";
	
	// 멤버 메서드 정의
	public void instanceMethod(String parameterValue) {
		String localValue = "로컬변수";
		
		System.out.println(parameterValue);
		System.out.println(localValue);
		System.out.println(instanceMember);
		System.out.println(classMember);
	}
	
	public static void classMethod() {
//		System.out.println(parameterValue);
//		System.out.println(localValue);
//		System.out.println(instanceMember);
		System.out.println(classMember);
	}
}






class A {
	static int a;
	int b;
}






