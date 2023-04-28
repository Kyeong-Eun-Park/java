package ex01_04;

public class Ex4_Q1 {

	public static void main(String[] args) {
		// 123p
		// Q1)
		// operator 값이 +, -, *, / 인 경우에 사칙 연산을 수행하는
		// 프로그램을 if문과 switch-case 문을 사용해 작성해 보세요.
		
		int num1 = 10;
		int num2 = 2;
		char operator = '+';
		
		// if version
		if(operator == '+') {
			System.out.println(num1 + num2);
		} else if (operator == '-') {
			System.out.println(num1 - num2);
		} else if (operator == '*') {
			System.out.println(num1 * num2);
		} else if (operator == '/') {
			System.out.println(num1 / num2);
		}
		
		// switch - case version
		switch (operator) {
		case '+': System.out.println(num1 + num2); break;
		case '-': System.out.println(num1 - num2); break;
		case '*': System.out.println(num1 * num2); break;
		case '/': System.out.println(num1 / num2); break;
		}
		
		
	}

}
