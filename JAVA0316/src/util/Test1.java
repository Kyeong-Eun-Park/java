package util;

import java.util.StringTokenizer;

public class Test1 {

	public static void main(String[] args) {
		String data = "Address:부산광역시 부산진구 동천로109,Floor:7층,Tel:051-803-0909";
		// 1. 각 항목별 분리 (StringTokenizer 클래스 사용)
		// 2. 각 항목에서 실제 데이터를 분리하여 추출
		
		StringTokenizer st = new StringTokenizer(data, ",");
		
		while(st.hasMoreTokens()) {
//			String[] arr = st.nextToken().split(":"); // Address:부산광역시 부산진구 동천로109
//			String key = arr[0]; // Address 부산광역시 부산진구 동천로109
//			String value = arr[1];
//			System.out.println(value);
			
//			String str = st.nextToken();
//			String key = str.split(":")[0];
//			String value = str.split(":")[1];
//			System.out.println(value);
			
			System.out.println(st.nextToken().split(":")[1]); 
		}
		
		System.out.println("===============================");
		
		StringTokenizer st2 = new StringTokenizer(data, ",:");
		
		while(st2.hasMoreTokens()) {
			st2.nextToken();
			System.out.println(st2.nextToken()); 
		}
		
	}

}
