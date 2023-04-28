package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Test2 {

	public static void main(String[] args) throws Exception {
		/*
		 * 케이크 먹기
		 * 
		 * 케이크를 n조각으로 자른 후 규칙에 따라 케이크를 먹기로 합니다.
		 * 1. 케이크는 편의를 위해서 1번 조각을 기준으로 시계방향으로 n번 조각까지 순서대로 있다고 한다.
		 * 2. 항상 1번 조각 케이크 부터 먹는다.
		 * 3. 다음 조각은 이전에 먹은 케이크 조각에서 시계 방향으로 남아있는 조각들 중 k번째에 잇는 조각을 먹는다.
		 * 4. 케이크가 2조각 남으면, 먹는 것을 멈춘다.
		 * 
		 * 케이크를 자른 조각의 개수 n과 k가 주어졌을 때, 마지막에 남은 케이크 조각의 번호를 출력 하시오.
		 * 
		 * n = 8, k = 2 : 4 8
		 * n = 6, k = 3 : 3 5
		 * 
		 * 입력형식) 8 2
		 * 출력형식) 4 8
		 * 
		 * */
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
//		int n = 8;
//		int k = 2;
		
		int[] cake = new int[n];
		for(int i = 0; i < cake.length; i++) {
			cake[i] = (i + 1);
		}
		boolean[] arr = new boolean[n];
		
		int index = 0;
		arr[index] = true;
		while(!isDone(arr)) {
			int next = findNextIndex(arr, index, k);
			arr[next] = true;
			index = next;
		}
		
		for(int i = 0; i < arr.length; i++) {
			if(!arr[i]) System.out.print(cake[i] + " ");
		}
		
	}
	
	public static int findNextIndex(boolean[] arr, int curr, int k) {
		int cnt = 0;
		while(true) {
			curr++;
			// 배열에 인덱스를 벗어낫을때 처음으로 변경
			if(curr >= arr.length) curr = 0; 
			if(!arr[curr]) cnt++;	// fale 이면 즉, cake를 안먹엇으면 cnt증가
			
			if(cnt == k) return curr;
		}
		
	}
	
	public static boolean isDone(boolean[] arr) {
		boolean result = false;
		
		int cnt = 0;
		for(boolean b : arr) {
			if(!b) cnt++;
		}
		
		// 2조각 남았으면 return true
		if(cnt == 2) result = true;
		
		return result;
	}
	
	
	
	
	
	

}
