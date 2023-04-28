package variable;

public class Ex1 {
	public static void main(String[] args) {
		/*
		 * 기본 데이터 타입 (기본형, Primitive Type)
		 * 메모리에 효율적인 사용을 위해 사이즈별로 나누어 놓음
		 * - 자바에서 기본적으로 사용하는 데이터타입은 8가지
		 * 
		 * 			1Byte	2Byte	4Byte	8Byte
		 * ----------------------------------------
		 * 1. 정수형	byte	short	int		long
		 * 2. 실수형					float	double
		 * 3. 문자형			char
		 * 4. 논리형	boolean
		 * */
		
		byte b = 127;
		System.out.println(b);
		
//		b = 128; 오류가 발생 byte 타입은 -128 ~ 127 까지 이기 때문
		
		short s = 128;
		System.out.println(s);
		
//		s = 32768;
		
		int i = 32768;
		System.out.println(i);
		
//		i = 2147483648; // 정수 리터럴에 접미사가 없을 경우 int로 취급됨!
						// 최대 표현 가능한 숫자가 2147483647 까지
						// 따라서, 그 이상의 숫자를 표현하려면
						// 접미사 L을 붙여서 long 타입을 사용해야한다.
		
		long l = 2147483648L;
		System.out.println(l);
		
		l = 100L;
//		i = 100L;
		// 접미사 L이 붙으면 int 타입으로 저장가능한 숫자라 하더라도 저장 불가!
		
		float f = 3.14f;
		System.out.println(f);
		
		double d = 3.14;
		System.out.println(d);
		
		char c = 'A' + 1;
		System.out.println(c);
		
		boolean bool = true;
		System.out.println(bool);
		
		bool = false;
		System.out.println(bool);
	}
	
}
