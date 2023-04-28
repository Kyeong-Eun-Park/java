
public class Ex2 {

	public static void main(String[] args) {
		/*
		 * for <--> while 전환
		 * 무엇을 수행하는 코드인지 설명
		 * */
		
//		int dan = 4;
//		for(int i = 0; i <= 9; i++) {
//			System.out.println(dan + " * " + i + " = " + dan*i);
//		}
		int dan = 4;
		int i = 0;
		while(i <= 9) {
			System.out.println(dan + " * " + i + " = " + dan*i);
			i++;
		}
		
		/*
		 * 형변환 (원인 및 해결책)
		 * char ch = 'A'
		 * ch = ch + 2
		 * 
		 * ch = (char)(ch + 2)
		 * ch += 2;
		 * */
		
		/*
		 * 배열 선언 및 초기화
		 * 
		 * int[] arr;
		 * int arr[];
		 * 
		 * arr = {1, 2, 3}
		 * 
		 * arr = new int[3]
		 * arr = new int[3]{1, 2, 3}
		 * arr = new int[]{1, 2, 3}
		 * */
		int[] arr;
		arr = new int[3];
		
		System.out.println(arr[0]);
		
	}

}
