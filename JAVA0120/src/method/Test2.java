package method;

class OverloadingMethod {
	// int형 정수 2개를 전달받아 덧셈 결과를 출력하는 add() 메서드 정의
	public void add(int num1, int num2) {
		System.out.println("add(int int)");
		System.out.println(num1 + num2);
	}
	// double형 정수 2개를 전달받아 덧셈 결과를 출력하는 add() 메서드 정의
	
	public void add(double num1, double num2) {
		System.out.println("add(double double)");
		System.out.println(num1 + num2);
	}
	// long형 정수 2개를 전달받아 덧셈 결과를 출력하는 add() 메서드 정의
	public void add(long num1, long num2) {
		System.out.println("add(long long)");
		System.out.println(num1 + num2);
	}
}

public class Test2 {

	public static void main(String[] args) {
		OverloadingMethod om = new OverloadingMethod();
		om.add(10, 20);
		om.add(3.14, 2.2);
		om.add(100L, 200L);
		System.out.println("---------------------");
		
		om.add(10, 2.2);
		om.add(3.14, 100L);
		om.add(100L, 2);
	}

}





