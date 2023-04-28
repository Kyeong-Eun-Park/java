package method;
/*
 * 계산기(Calculator2) 클래스 정의
 * - 덧셈, 뺄셈, 곱셈, 나눗셈 기능을 모두 calc() 메서드로 처리
 *   => 첫번째 파라미터로 연산자(기호, char 타입 opr)를 전달하고
 *      두번째 파라미터부터 피연산자(숫자, int타입 가변인자 nums)을 2개 이상 전달하여
 *      연산자에 따라 각각의 연산을 누적하여 결과를 출력
 * */
class Calculator2 {
	
	// 1번 방법
//	public void calc(char opr, int... nums) {
//		
//		int result = nums[0];
//		System.out.print(nums[0]);
//		if(opr == '+') {
//			
//			for(int i = 1; i < nums.length; i++) {
//				System.out.print(" + " + nums[i]);
//				result += nums[i];
//			}
//			
//		} else if(opr == '-') {
//			
//			for(int i = 1; i < nums.length; i++) {
//				System.out.print(" - " + nums[i]);
//				result -= nums[i];
//			}
//			
//		} else if(opr == '*') {
//			
//			for(int i = 1; i < nums.length; i++) {
//				System.out.print(" * " + nums[i]);
//				result *= nums[i];
//			}
//			
//			
//		} else if(opr == '/') {
//			
//			for(int i = 1; i < nums.length; i++) {
//				System.out.print(" / " + nums[i]);
//				result /= nums[i];
//			}
//			
//		}
//		
//		System.out.println(" = " + result);
//	}
	
	// 2번 방법
//	public void calc(char opr, int... nums) {
//		int result = nums[0];
//		System.out.print(nums[0]);
//		for(int i = 1; i < nums.length; i++) {
//			if(opr == '+') {
//				System.out.print(" + " + nums[i]);
//				result += nums[i];
//			} else if(opr == '-') {
//				System.out.print(" - " + nums[i]);
//				result -= nums[i];
//			} else if(opr == '*') {
//				System.out.print(" * " + nums[i]);
//				result *= nums[i];
//			} else if(opr == '/') {
//				System.out.print(" / " + nums[i]);
//				result /= nums[i];
//			}
//		}
//		System.out.println(" = " + result);
//	}
	
	// 3번 방법
	public void calc(char opr, int... nums) {
		String str = makeStr(opr, nums); // 10 + 20 =
		int result = sum(opr, nums);	// 30
		System.out.println(str + result);
	}
	
	public String makeStr(char opr, int... nums) {
		String result = nums[0] + "";
		for(int i = 1; i < nums.length; i++) {
			result += " " + opr + " " + nums[i]; 
		}
		result += " = ";
		return result;
	}
	
	public int sum(char opr, int... nums) {
		int result = nums[0];
		for(int i = 1; i < nums.length; i++) {
			switch (opr) {
			case '+': result += nums[i]; break;
			case '-': result -= nums[i]; break;
			case '*': result *= nums[i]; break;
			case '/': result /= nums[i]; break;
			}
		}
		return result;
	}
	
}

public class Test4 {

	public static void main(String[] args) {
		Calculator2 cal = new Calculator2();
		cal.calc('+', 10, 20);		// 10 + 20 = 30 출력
		cal.calc('+', 10, 20, 30);	// 10 + 20 + 30 = 60 출력
		
		cal.calc('-', 100, 10);		// 100 - 10 = 90 출력
		cal.calc('-', 100, 10, 20);	// 101 - 10 - 20 = 70 출력
		
		cal.calc('*', 10, 20);		
		cal.calc('*', 10, 20, 30);
		
		cal.calc('/', 100, 10);		
		cal.calc('/', 100, 10, 2);
	}

}





