package langPackage;

import java.util.Arrays;

enum Jumin {
	남성(1,3), 여성(2,4), 외국인(5,6), 괴물;// 7 8 9
	
	int num1;
	int num2;
	private Jumin() {}
	private Jumin(int num1, int num2) {
		this.num1 = num1;
		this.num2 = num2;
	}
	
	// 정수num을 전달받아 일치하는 Enum을 리턴하는 getJumin
	public static Jumin getJumin(int num) {
		Jumin result = 괴물;
		switch (num) {
		case 1: case 3: result = 남성; break;
		case 2: case 4: result = 여성; break;
		case 5: case 6: result = 외국인; break;
		}
		return result;
	}
	
}

public class Test4 {

	public static void main(String[] args) {
		/*
		 * 주민등록번호(jumin)를 문자열로 저장 후 성별(남 또는 여) 판별
		 * 판별 조건
		 * 1) 뒷자리 첫번째 숫자가 1 또는 3 : "남성" 출력
		 * 2) 뒷자리 첫번째 숫자가 2 또는 4 : "여성" 출력
		 * 3) 뒷자리 첫번째 숫자가 5 또는 6 : "외국인" 출력
		 * */
		String jumin = "901111-1211222";
		
		int ch = Character.getNumericValue(jumin.charAt(7));
		String result = "외국인";
		switch (ch) {
		case 1: case 3: result = "남성"; break;
		case 2: case 4: result = "여성"; break;
		}
		System.out.println(result);
		
		System.out.println("---------------------------------------------");
		
		// switch - case (Enum 활용)
		result = "";
		switch(Jumin.getJumin(ch)) {
		case 남성: result = "남성";
		case 여성: result = "여성";
		case 외국인: result = "외국인";
		}
		System.out.println(result);
		System.out.println(Jumin.getJumin(5));
		
		System.out.println("---------------------------------------------");
		
		// 주소부분만 출력 (부산광역시 부산진구 동천로:109)
		String data1 = "Address:부산광역시 부산진구 동천로:109";
		System.out.println("주소: " + data1.substring(8));
		System.out.println("주소: " + data1.substring(data1.indexOf(":") + 1));
		
		// 이름 부분만 출력 (홍길동)
		String data2 = "이름: 홍길동, 나이: 20";
		System.out.println("이름: " + data2.substring(4, 7));
		System.out.println("이름: " + data2.split(",")[0].split(":")[1].trim());
		// data2.split(",")[0] : 이름: 홍길동
		// .split(":")[1] : 홍길동
		
		// 주소부분만 출력 (서울특별시 용산구 24번길, 210동 702호)
		String data3 = "Address:서울특별시 용산구 24번길, 210동 702호,Tel:0518030909";
//		System.out.println(data3.indexOf(":"));
//		System.out.println(data3.lastIndexOf(","));
		
		System.out.println(data3.substring(data3.indexOf(":") + 1, data3.lastIndexOf(",")));
		
		int startIndex = data3.indexOf(":") + 1;
		int endIndex = data3.lastIndexOf(",");
		System.out.println(data3.substring(startIndex, endIndex));
		
		// 필요한 데이터만 추출
		String data4 = "Address:부산광역시 부산진구 동천로 109, Floor:7층,Tel:051-803-0909";
		String[] strArr = data4.split(","); // Address:부산광역시 부산진구 동천로 109, 7층...
		System.out.println(Arrays.toString(strArr));
		for(String s : strArr) {
			System.out.println(s.split(":")[1].replace("-", "").trim()); 
		}
		
	}

}
