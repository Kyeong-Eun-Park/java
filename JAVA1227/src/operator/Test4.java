package operator;

public class Test4 {

	public static void main(String[] args) {
		/*
		 * 문자 ch에 대해 "대문자" 와 "소문자" 판별, 
		 * 그 나머지는 "기타문자"
		 * */
		char ch = 'B';
		
		String s = ('A' <= ch && ch <= 'Z') ? "대문자" : 
				   (ch >= 'a' && ch <= 'z') ? "소문자" : "기타문자";
		
		System.out.println(s);
		
		/*
		 * < 삼항연산자 활용 >
		 * 뷔폐 요금 계산
		 * 1. 뷔폐의 기본요금(price)은 30000원 이다.
		 * 2. 손님의 나이(age)에 따라 할인 조건이 적용된다.
		 * 3. 뷔폐 할인 조건 : 나이(age)가 5세 이하일 경우 70% 할인된 요금으로 계산
		 * 					나이(age)가 65세 이상일 경우 50% 할인된 요금으로 계산
		 * 4. 최종적으로 뷔폐요금 출력
		 * */
		int price = 30000;
		int age = 55;
		
//		int result = age <= 5  ? (int)(price * 0.3) : 
//					 age >= 65 ? (int)(price * 0.5) : price;
		
//		int result = (int)(price * 0.3);
//		int result = (int)(price * 0.5);
//		int result = price;
					 
//		price = (int)(price * 0.3);
//		price = (int)(price * 0.5);
				
//		price *= 0.3;
//		price *= 0.5;
		
		price *= age <= 5  ? 0.3 :
				 age >= 65 ? 0.5 : 1;
		
		System.out.println(price);
		
		
		
	}

}
