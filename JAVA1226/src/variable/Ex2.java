package variable;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * String 타입
		 * - 문자열을 표현하기 위한 데이터 타입
		 * - 기본형이 아닌 참조형 (Reference type)
		 * - 1개 이상의 문자열을 큰 따움표 ("") 로 묶어서 표현
		 * - 아무것도 포함하지 않는 문자열 ("")을 널스트링(null string) 
		 * - 덧셈 연산자(+)를 사용해서 문자열간 결합이 가능
		 * */
		
		System.out.println("1" + "2");
		System.out.println(1 + "문자열"); // 정확히는 정수가 문자열로 변환된 후 결합!
		System.out.println(1 + 2 + "문자열");
		int a = 1 + 2;
		System.out.println(a + "문자열" + a);
		
	}

}
