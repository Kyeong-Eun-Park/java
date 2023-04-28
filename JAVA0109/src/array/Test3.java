package array;

public class Test3 {

	public static void main(String[] args) {
		/*
		 * n개의 숫자가 입력되면, 다음과 같이 크기를 비교한 후 양식에 맞춰 출력하시오.
		 * 예를 들어 1, 2, 3, 2, 1 이라는 숫자가 입력되면,
		 * 첫번째 1과 나머지 2, 3, 2, 1을 비교하여 < < < = 를 출력
		 * 두번째 2와 나머지 1, 3, 2, 1을 비교하여 > < = > 를 출력
		 * 세번째 3과 나머지 1, 2, 2, 1을 비교하여 > > > > 를 출력
		 * 
		 * 1: < < < =
		 * 2: > < = >
		 * 3: > > > >
		 * 4: > = < >
		 * 5: = < < < 
		 * */
		
		// 1번 방법
//		int[] arr = {1, 2, 3, 2, 1};
//		for(int i = 0; i < arr.length; i++) {
//			int num = arr[i];
//			String result = (i+1) + ": ";
//			for(int j = 0; j < arr.length; j++) {
//				if(j == i) continue;
//				
//				if(num > arr[j])		result += "> ";
//				else if(num < arr[j])	result += "< ";
//				else					result += "= ";
//			}
//			System.out.println(result);
//		}
		
		int[] arr = {1, 2, 3, 2, 1};
		
		for(int i = 0; i < arr.length; i++) {
			System.out.println(method(arr, i));
		}
		
//		method2(arr);
		
	} // main() 메서드 끝
	
	public static String method(int[] arr, int index) {
		int num = arr[index];
		String result = (index + 1) + ": ";
		for(int i = 0; i < arr.length; i++) {
			
			if(i == index) continue; 
			
			if(num > arr[i])		result += "> ";
			else if(num < arr[i])	result += "< ";
			else					result += "= ";
		}
		return result;
	}
	
	public static void method2(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			int num = arr[i];
			String result = (i+1) + ": ";
			for(int j = 0; j < arr.length; j++) {
				if(j == i) continue;
				
				if(num > arr[j])		result += "> ";
				else if(num < arr[j])	result += "< ";
				else					result += "= ";
			}
			System.out.println(result);
		}
	}
	
	
	

}
