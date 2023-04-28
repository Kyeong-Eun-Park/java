package operator;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * (& Ampersend), (| Vertical bar), (^ Caret)
		 * 논리연산자 (&&, ||, !, ^)
		 * - 두 피연산자 간의 논리적인 판별을 수행하는 연산자
		 * - 피연산자는 모두 boolean 타입 데이터만 사용 가능하며
		 *   결과값도 boolean 타입으로 리턴
		 * 
		 * < AND 연산자 (& 또는 &&) - 논리곱 >
		 * - 두 피연산자 모두 true일 경우에만 결과가 true이고,
		 *   하나라고 false일 경우 결과값이 false
		 * - F AND F = F, F AND T = F, T AND F = F, T AND T = T
		 * */
		
		boolean a = false;
		boolean b = true;
		
		// AND 연산자 (&&) : 둘다만족(true)할 경우에만 true
		System.out.println("a(false) && a(false) = " + (a && a));
		System.out.println("a(false) && b(true) = " + (a && b));
		System.out.println("b(true) && a(false) = " + (b && a));
		System.out.println("b(true) && b(true) = " + (b && b));
		System.out.println();
		
		// OR 연산자 (||) : 하나라도 만족(true)할 경우에 true
		System.out.println("a(false) || a(false) = " + (a || a));
		System.out.println("a(false) || b(true) = " + (a || b));
		System.out.println("b(true) || a(false) = " + (b || a));
		System.out.println("b(true) || b(true) = " + (b || b));
		System.out.println();
		
		// NOT 연산자 (!)
		System.out.println("!a(false) = " + (!a));
		System.out.println("!b(true) = " + (!b));
		System.out.println();
		
		// XOR 연산자 (^)
		System.out.println("a(false) ^ a(false) = " + (a ^ a));
		System.out.println("a(false) ^ b(true) = " + (a ^ b));
		System.out.println("b(true) ^ a(false) = " + (b ^ a));
		System.out.println("b(true) ^ b(true) = " + (b ^ b));
		System.out.println();
		
		// &&, || 을 사용하는 이유
		// => 불필요한 연산은 하지 않음 (Lazy Evaluation)
		int i = 10;
		boolean result = i > 9 || i++ > 9;
		System.out.println(i);
		
	}

}
