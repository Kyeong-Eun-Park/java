package util;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Test3 {

	public static void main(String[] args) throws Exception {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		String[] input = reader.readLine().split(" ");
		int n = Integer.parseInt(input[0]);
		int k = Integer.parseInt(input[1]);
		
//		int n = 6;
//		int k = 3;
		
		ArrayList<Integer> cake = new ArrayList<Integer>();
		// 1 ~ 8 까지 cake 초기화
		for(int i = 1; i <= n; i++) {
			cake.add(i);
		}
		
		int index = 0;
		while(cake.size() > 2) {
			cake.remove(index);
			index += (k-1);
			if(index >= cake.size()) index = index - cake.size();
		}
		
		System.out.println(cake);
		
	}

}
