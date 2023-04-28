package operator;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 비교연산자 (= 관계연산자) (>, >=, <=, <, ==, !=)
		 * - 두 피연산자 간의 대소관계 등을 비교 하여 true 또는 false 값 반환
		 * */
		int a = 10, b = 5;
		System.out.println("a > b 인가? " + (a > b));
		System.out.println("a < b 인가? " + (a < b));
		System.out.println("a >= b 인가? " + (a >= b));
		System.out.println("a <= b 인가? " + (a <= b));
		System.out.println("a == b 인가? " + (a == b));
		System.out.println("a != b 인가? " + (a != b));
		System.out.println("=================");
		
		// char 타입을 비교연산자에 사용시 정수(유니코드)값을 비교
		System.out.println('A' > 'B');
//		System.out.println("A" > "B"); // 문자열을 대소관계 X
		System.out.println('A' == 65);
		
		System.out.println("=================");
		System.out.println(3 == 3.0);
		System.out.println(0.1 == 0.1f); // 근사치 표현에 의해 서로 다른값으로 취급됨!
		System.out.println((float)0.1 == 0.1f);
		
		System.out.println("=================");
		
		// 참고!
		// 기본데이터타입과 참조형데이터 타입 비교시 주의사항! (나중에 자세히 설명)
		String str1 = "abc";
		String str2 = "ab";
		String str3 = "c";
		String str4 = str2 + "c";	// 변수 + 리터럴
		String str5 = str2 + str3;	// 변수 + 변수
		String str6 = "ab" + "c";	// 리터럴 + 리터럴
		
		System.out.println(str1);
		System.out.println(str4);
		System.out.println(str5);
		System.out.println(str6);
		
		System.out.println("< 동등비교 연산자로 비교 >");
		System.out.println(str1 == str4);
		System.out.println(str1 == str5);
		System.out.println(str1 == str6);
		
		System.out.println("< equals() 메서드로 비교 >");
		System.out.println(str1.equals(str4));
		System.out.println(str1.equals(str5));
		System.out.println(str1.equals(str6));
		
		// 결론, 리터럴 사용시 "기본 데이터 타입 처럼" 사용 가능
		// 변수에 저장 후 연산 시 Heap 메모리의 주소를 비교하므로
		// 값이 같더라도 false로 판담됨
		// => 문자열은 equals() 메서드로 비교하자!
		
		
		
		
		
	}

}
