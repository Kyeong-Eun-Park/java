package jsp15_randomize;

import java.util.Random;

public class MyRandomize {
	
	public String getRandomNumber() {
		// Math.random() 메서드를 활용하거나 
		// Random 클래스 인스턴스의 nextXXX() 메서드를 활용하여
		// 난수를 생성할 수 있다.
		Random r = new Random();
		// 4자리 난수(0 ~ 9999) 생성 시
		int rNum = r.nextInt(10000);
		// => 문제 발생! 4자리보다 적은 자릿수를 표현 시 앞에 0이 붙지 않는다! (0011 -> 11)
		// => 따라서, 문자열로 변환하여 4자리 문자열 형식을 지정하고 앞에 0이 붙도록 처리해야함
		//    (%d 가 10진수를 표현하며, %4d 는 10진수 4자리 지정)
		//    (%04d 는 4자리 중 부족한 앞자리를 0으로 채움) 
		String strNum = String.format("%04d", rNum);
		
		// 생성된 난수를 문자열로 변환하여 리턴
		return strNum;
	}
	
	// 자릿수를 전달받아 해당 자릿수 만큼의 난수 생성하여 리턴
	// ex) 4 전달받을 경우 4자리 난수, 6 전달받을 경우 6자리 난수
	public String getRandomNumber2(int digit) {
		// Math.random() 메서드를 활용하거나 
		// Random 클래스 인스턴스의 nextXXX() 메서드를 활용하여
		// 난수를 생성할 수 있다.
		Random r = new Random();
		
		// 전달받은 자릿수를 10 ^ x 형태로 변환
		// => 주의! ^ 기호를 정수 연산자로 사용 시 비트단위 연산자로 취급되어 XOR 연산 수행됨
		// => 따라서, Math.pow() 메서드를 활용해야함(double -> int 형변환 필요)
		int rNum = r.nextInt((int)Math.pow(10, digit));
		// 전달받은 자릿수를 %0 과 d 사이에 문자열 결합
		String strNum = String.format("%0" + digit + "d", rNum);
		
		// 생성된 난수를 문자열로 변환하여 리턴
		return strNum;
	}
	
	public String getRandomString() {
		// 대문자 중 1개의 문자를 난수로 생성하여 리턴
		// => 대문자는 아스키코드 65 ~ 90번 사이의 문자이며
		//    이를 정수 난수로 표현하려면 0 ~ X 사이의 정수로 변환되어야 함
		//    따라서, 65 ~ 90 을 0 ~ 25 사이의 정수로 표현한 후 +65 수행하면 된다! 
		Random r = new Random();
		int rNum = r.nextInt(26) + 65;
		
		// 정수 -> char 타입 변환 후 다시 String 타입으로 변환
		return (char)rNum + "";
		
		// 또는, String.format() 메서드 활용
	}
	
	public String getRandomString2(int length) {
		// 전달받은 길이만큼의 난수 문자열을 생성하여 리턴
		Random r = new Random();
		String randomStr = ""; // 난수 문자열을 저장할 변수
		
		// 반복문을 사용하여 길이만큼 반복
		for(int i = 1; i <= length; i++) {
//			int rNum = r.nextInt(26) + 65; // 난수 문자열 1개 생성
			
			// 만약, 대문자 뿐만 아니라 소문자도 함께 난수에 포함시킬 경우
			// 65 ~ 90 과 97 ~ 122 사이의 범위를 지정해야함
			// 65 ~ 122 로 지정할 경우 91 ~ 96 사이의 특수문자 등도 포함됨
			int rNum = r.nextInt(58) + 65;
			
//			randomStr += (char)rNum + ""; // 문자열로 변환하여 결합
			
			// 따라서, 91 ~ 96 범위일 경우 문자열 결합을 수행하지 않고 
			// 반복을 한 번 더 수행하여 새로운 난수를 다시 발생
			if(rNum >= 91 && rNum <= 96) {
				i--; // 제어변수 i값을 1만큼 감소시키면 다시 기존 반복 수행 가능
			} else {
				randomStr += (char)rNum + ""; // 문자열로 변환하여 결합
			}
			
		}

		return randomStr;
		
	}
}












