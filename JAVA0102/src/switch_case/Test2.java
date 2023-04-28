package switch_case;

public class Test2 {

	public static void main(String[] args) {
		
		// 세 정수 n1, n2, n3 중 최대값 출력
		// ex) 최대값: 30
//		int n1 = 700, n2 = 300, n3 = 200;
//		String result = "최대값 : ";
//		if(n1 > n2) {	
//			if(n1 > n3)	result += n1;
//			else		result += n3;
//		} else { 
//			if(n2 > n3)	result += n2;
//			else		result += n3;
//		}
//		System.out.println(result);
		
		// 중첩 if (X)
//		if(n1 >= n2 && n1 >= n3) {
//			System.out.println("최대값 : " + n1);
//		} else if(n2 >= n1 && n2 >= n3) {
//			System.out.println("최대값 : " + n2);
//		} else {
//			System.out.println("최대값 : " + n3);
//		}
		
		// 삼항연산자 (변수활용)
		int n1 = 70, n2 = 30, n3 = 200;
		
		int max = (n1 > n2) ? n1 : n2;
		max = (max > n3) ? max : n3;
		
		System.out.println("최대값 : " + max);
		
		
		
	}

}
