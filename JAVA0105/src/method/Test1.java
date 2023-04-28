package method;









public class Test1 {

	public static void hello() {
		for(int i = 0; i < 10; i++) {
			System.out.println(i + " : Hellow, World!");
		}
	}
	
	public static void hello2(String str, int count) {
		for(int i = 0; i < count; i++) {
			System.out.println(str);
		}
	}
	
	public static void main(String[] args) {
		// 1. 매개변수 X, 리턴값 X 메서드
		// "Hellow, World!" 문자열 10번 반복 출력하는 hello() 메서드 호출
		hello();
		System.out.println("----------------------");
		
		// 2. 매개변수 O, 리턴값 X 메서드
		// "안녕하세요"와 반복횟수를 전달하여 
		// 전달받은 횟수만큼 "안녕하세요"를 출력하는 hello2() 메서드 호출
		hello2("안녕 안한데", 7);
		System.out.println("--------------------");
		// 3. 매개변수 X, 리턴값 O
		// 1 ~ 10 까지 정수의 합(55)을 계산하여 리턴하는 메서드 sum() 호출 후 결과 출력
		int result = sum();
//		int result = 55;
		System.out.println(result);
		System.out.println(sum());
//		System.out.println(55);
		System.out.println("------------------------");
		
		// 4. 매개변수 O, 리턴값 O
		// 1 부터 전달받은 매개변수 까지의 합을 리턴하는 메서드 sum2() 호출 후 결과 출력
		int result2 = sum2(100);
//		int result2 = 5050;
		System.out.println(result2);
		System.out.println(sum2(100));
//		System.out.println(5050);
	}

	public static int sum() {
		int sum = 0;
		for(int i = 1; i <= 10; i++) {
			sum += i;
		}
		return sum;
	}
	
	public static int sum2(int limit) {
		int sum = 0;
		for(int i = 1; i <= limit; i++) {
			sum += i;
		}
		return sum;
	}
	
}







