package array;

import java.util.Scanner;

public class Test2 {

	public static void main(String[] args) {
		/*
		 * n개의 숫자가 입력되면
		 * n개의 숫자를 왼쪽으로 하나씩 돌려서 출력하시오!
		 * 
		 * 입력예시)
		 * 5
		 * 1 2 3 4 5
		 * 
		 * 출력예시)
		 * 1 2 3 4 5
		 * 2 3 4 5 1
		 * 3 4 5 1 2
		 * 4 5 1 2 3
		 * 5 1 2 3 4
		 * 
		 * */
		int[] arr = {1, 2, 3, 4, 5};
		
		// 1번 방법
		for(int i = 0; i < arr.length; i++) {
			printArray(arr);
			rotation(arr);
		}
		
		System.out.println("----------------------");
		// 2번 방법 (배열 * 2)
		// 입력받기
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();	// n: 배열의 크기
		int[] arr2 = new int[n*2];
		for(int i = 0; i < n; i++) {
			int num = sc.nextInt();
			arr2[i] = num;
			arr2[i+n] = num;
		}
		
		// 배열 출력
		for(int i = 0; i < n; i++) {
			for(int j = i; j < i+n; j++) {
				System.out.print(arr2[j] + " ");
			}
			System.out.println();
		}
		
		
	} // main() 메서드 끝
	
	// 배열을 전달받아 배열에 요소를 우측으로 모두 출력 후 줄바꿈
	public static void printArray(int[] arr) {
		for(int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	// 배열을 전달받아 한바퀴 돌려주는 메서드
	public static void rotation(int[] arr) {
		int temp = arr[0];
		for(int i = 0; i < arr.length - 1; i++) {
			arr[i] = arr[i+1];
		}
		arr[arr.length - 1] = temp;
	}
	
	
	
	
	
	

}
