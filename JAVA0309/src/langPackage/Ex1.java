package langPackage;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * StringBuilder & StringBuffer
		 * 
		 * - StringBuilder: 문자열이 안전하게 변경되도록 보장 (X)
		 * - StringBuffer: 문자열이 안전하게 변경되도록 보장 (O)
		 *   (멀티 쓰레드 프로그램이 아니라면 StringBuilder 속도가 빠름)
		 * */
		
		String javaStr = new String("Java");
		// System.identityHashCode 인스턴스가 처음 생성되었을 때 메모리 주소
		System.out.println("javaStr 문자열 주소: " + System.identityHashCode(javaStr));
		
		StringBuilder buffer = new StringBuilder(javaStr);
		System.out.println("연산 전 buffer 메모리 주소: " + System.identityHashCode(buffer));
		buffer.append(" and");
		System.out.println("연산 후 buffer 메모리 주소: " + System.identityHashCode(buffer));
		buffer.append(" android");
		System.out.println("연산 후 buffer 메모리 주소: " + System.identityHashCode(buffer));
		buffer.append(" programming is fun!!!");
		System.out.println("연산 후 buffer 메모리 주소: " + System.identityHashCode(buffer));
		
		javaStr = buffer.toString();
		System.out.println("새로 만들어진 문자열 주소: " + System.identityHashCode(javaStr));
		
		System.out.println("------------------------------------------------");
		
		String str1 = "abc";		// 리터럴
		String str2 = str1 + "de";	// 변수 + 리터럴
		String str3 = "abc";		// 리터럴
		String str4 = "a" + "bc";	// 리터럴 + 리터럴
		String str5 = "a";			
		String str6 = str5 + "bc";	// 변수 + 리터럴
		str5 += "bc";				// 변수에 += 연산자로 누적
		
		System.out.println(System.identityHashCode(str1));	// 리터럴
		System.out.println(System.identityHashCode(str3));	// 리터럴
		System.out.println(System.identityHashCode(str4));	// 리터럴 + 리터럴
		System.out.println(System.identityHashCode(str5));	// 변수 + 리터럴
		System.out.println(System.identityHashCode(str6));	// 변수에 += 연산자로 누적
		
	}
	
}
