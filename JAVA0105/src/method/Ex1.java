package method;

public class Ex1 {

	
	public static void main(String[] args) {
		/*
		 * 메서드 (Method)
		 * - 객체의 동작을 나타내는 최소 단위
		 * - 메서드를 정의한 후에는 반드시 호출되어야만 사용 가능
		 * - main() 메서드도 메서드의 일종
		 *   => JVM에 의해 자동으로 호출되는 메서드 = 프로그램의 시작점
		 * - 메서드를 호출할 때 전달하는 값을 전달일자(Argument) 라고 하며 
		 *   이 값을 메서드에서 전달받기 위해 선언하는 변수를 매개변수(Parameter)라고 함
		 *   => 이때, 메서드 호출 시 전달하는 값이 없을 수도 있다! 
		 *   => 메서드를 호출 할때 반드시 선언부의 매개변수 타입과 갯수에 맞게
		 *      데이터를 전달하여 호출해야한다!
		 * - 메서드 수행이 끝날 때 호출한 곳으로 전달할(되돌려줄) 값을 리턴값이라고 하며
		 *   리턴값에 해당하는 데이터타입을 리턴타입 부분에 명시 해야함 
		 *   => 메서드 수행 후 리턴값이 없을 수도 있다!
		 *      만약, 리턴값이 없을 경우 리턴타입에 반드시 void 라는 타입을 명시 해야한다! 
		 *   => 한번에 리턴 가능한 데이터는 한개!
		 * - 메서드 수행이 종료되면 반드시, 메서드를 호출한 곳으로 돌아와야함
		 *   이때, 리턴값이 존재한다면 호출한 곳으로 돌아올때 가지고 옴
		 * 
		 * < 메서드 정의 기본 문법 >
		 * [제한자] 리턴타입 메서드명([매개변수...]) {
		 * 		// 메서드 호출 시 실행될 코드들...
		 * }
		 *   
		 * < 메서드 정의 방법에 따른 분류 >
		 * 1. 매개변수 X, 리턴값 X
		 * 2. 매개변수 X, 리턴값 O
		 * 3. 매개변수 O, 리턴값 X
		 * 4. 매개변수 O, 리턴값 O          
		 * */
		
		// 1. 매개변수가 없고, 리턴값도 없는 메서드
		// => 매개변수가 없으므로 메서드 호출시 소괄호() 안에 아무 데이터도 전달하지 않음
		// => 리턴값이 없으므로 메서드 호출결과를 저장할 변수를 선언하거나
		//    출력문 등의 내부에서 메서드 호출 불가능하며, 단독으로 호출해야한다!
		System.out.println("동생아! 불 좀 꺼라!");
		sister_1();
		System.out.println("동생이 불을 껏다!");
		System.out.println("------------------------");
		
		// 2. 매개변수 X, 리턴값 O
		System.out.println("동생아! 물 좀 떠다도!");
		String result = sister_2();
//		String result = "물"; 과 동일한 코드로 사용됨.
		System.out.println("동생이 갖다준것 : " + result);
		System.out.println("------------------------");
		
		// 3. 매개변수 O, 리턴값 X
		System.out.println("동생아! 200원 줄테니 과자 사먹어라!");
//		sister_3(200);
		int money = 2000;
		sister_3(money);
		System.out.println("------------------------");
		
		// 4. 매개변수 O, 리턴값 O
		System.out.println("동생아! 1000원 줄테니 나도 새우깡 좀 사다도!");
		String snack = sister_4(1000);
//		String snack = "새우깡";
		System.out.println("동생이 사다준것 : " + snack);
	}
	
	// 4. 매개변수 O, 리턴값 O
	public static String sister_4(int money) {
		System.out.println("동생: 오빠가 과자 사오라고 " + money + "원을 줬다!");
		money -= 200;
		System.out.println("동생: 새우깡 사고 " + money + "원이 남았다!");
		return "새우깡";
	}
	
	
	// 3. 매개변수 O, 리턴값 X
	public static void sister_3(int money) {
		System.out.println("동생: 오빠가 과자 사먹으라고 " + money + "원을 줬다!");
		money -= 200;
		System.out.println("동생: 새우깡 사먹고 " + money + "원이 남았다!");
	}
	
	// 2. 매개변수 X, 리턴값 O
	public static String sister_2() {
		System.out.println("동생: 오빠가 물을 떠오라고 시켰다!");
		String result = "물";
		return result;
	}
	
	
	// 1. 매개변수가 없고, 리턴값도 없는 메서드
	// => 리턴값이 없으므로 리턴타입에 void 타입 명시 (생략불가!)
	// => 매개변수가 없으므로 메서드 선언부 소괄호() 안에 아무것도 기술하지 않음
	public static void sister_1() {
		System.out.println("동생: 오빠가 불을 끄라고 시켜서 불을 껏다!");
	}
	

}
