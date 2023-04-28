package method;

class AbsNum {
	// 1. int형 정수 1개(num)를 전달받아 절대값을 리턴
	public int abs(int num) {
//		if(num < 0) {
//			num = -num;
//		}
//		return num;		
		return num < 0 ? -num : num;
	}
	
	// 2. double형 실수 1개(num)를 전달받아 절대값을 리턴
	public double dAbs(double num) {
		return num < 0 ? -num : num;
	}
	
	// 3. long형 정수 1개(num)를 전달받아 절대값을 리턴
	public long lAbs(long num) {
		return num < 0 ? -num : num;
	}
}

public class Ex2 {

	public static void main(String[] args) {
		
		/*
		 * 메서드 오버로딩 (Method Overloading) = 메서드 다중정의
		 * - 동일한 이름의 매개변수가 다른 메서드를 여러개 정의하는 것
		 * - 동일한 이름으로 서로 다른 파라미터를 전달받아 다른 작업을 처리하도록 하는 것
		 * - 규칙1. 메서드명은 동일
		 *   규칙2. 매개변수의 타입이나 갯수가 달라야함 (순서)
		 * 	 규칙3. 리턴타입이 다른 것은 오버로딩과 무관함
		 *   규칙4. 매개변수의 변수명만 다른것은 오버로딩과 무관함
		 *   => 즉, 메서드 호출 시점에서 전달되는 데이터에 따라
		 *      각각 다른 메서드를 호출하도록 "구분" 되어야함!
		 * */
		AbsNum absNum = new AbsNum();
		int num = absNum.abs(-5);
		System.out.println("-5의 절대값: " + num);
		System.out.println("-3.14의 절대값: " + absNum.dAbs(-3.14));
		System.out.println("-100L의 절대값: " + absNum.lAbs(-100L));
		System.out.println("----------------------------------------------");
		
		OverloadingAbsNum oan = new OverloadingAbsNum();
		System.out.println("정수 10의 절대값: " + oan.abs(10));
		System.out.println("실수 3.14의 절대값: " + oan.abs(3.14));
		System.out.println("정수 100L의 절대값: " + oan.abs(100L));
		
		// 메서드 오버로딩의 대표적인 예: print(), println() 
//		System.out.print();
		System.out.println();
		
		
	}

}

// 메서드 오버로딩을 사용하여 클래스 정의
// => 1) 매개변수의 데이터타입이 다른 오버로딩 메서드 정의
class OverloadingAbsNum {
	// 1. 정수 1개(num)를 전달받아 절대값을 리턴하는 메서드 abs() 정의
	public int abs(int num) {
		System.out.println("abs(int) 메서드 호출됨!");
		return num < 0 ? -num : num;
	}
	
	// 2. 실수 1개(num)를 전달받아 절대값을 리턴하는 메서드 abs() 정의 - 오버로딩 적용
	public double abs(double num) {
		System.out.println("abs(double) 메서드 호출됨!");
		return num < 0 ? -num : num;
	}
	
	// 3. long타입 1개(num)를 전달받아 절대값을 리턴하는 메서드 abs() 정의 - 오버로딩 적용
	public long abs(long num) {
		System.out.println("abs(long) 메서드 호출됨!");
		return num < 0 ? -num : num;
	}
}









