package regex;

import java.util.regex.Pattern;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * java.util.regex 패키지의 클래스를 활용하여 "정규표현식" 활용 가능
		 * 
		 * 1. Pattern 클래스
		 * - 정규표현식에 사용되는 패턴문자열을 객체로 관리하는 클래스
		 * - compile() 메서드를 사용하여 정규표현식 패턴 문자열을 갖는 객체 생성
		 *   matches() 메서드를 사용하여 특정 문자열을 대상으로 정규표현식 패턴 검사
		 * */
		
		// 1. 전화번호(휴대폰) 형식 검증
		// 		1) ^(010|011) : 010 또는 011로 시작
		//		2) [-\\s]? : - 기호 또는 공백이 포함될 수도 있고, 포함되지 않을 수도 있음
		//		3) \d{3,4} : 숫자 3자리 또는 4자리
		//		4) \d{4}$ : 숫자 4자리로 끝
		String regex = "^(010|011)[-\\s]?\\d{3,4}[-\\s]?\\d{4}$";
		
//		String phone = "010-1234-5678"; // 검사에 사용할 문자열
//		boolean result = Pattern.matches(regex, phone);
//		boolean result = phone.matches(regex);
//		System.out.println(phone + " 번호는 유효한 전화번호인가? " + result);
		
		String[] phoneNumbers = {
			"010-1234-5678", "010-1234-56789", "010-1234 5678", "01012345678",
			"010-1234-567a", "010)1234-5678"
		};
		
		for(String phone : phoneNumbers) {
			boolean result = phone.matches(regex);
			System.out.println(phone + " 번호는 유효한 전화번호인가? " + result);
		}
		
		System.out.println("====================================");
		// 2. 이메일 형식
		String emailRegex = "^[a-zA-Z0-9+-\\_.]+@[a-zA-Z0-9-]+\\.[a-zA-Z0-9-.]+$";
		String[] emails = {
				"aaa@aaa.com", "123@123.com", "123abc@abc.net", "ddd@abc123.com",
				"ccc@123abc.com", "aaa@aaa", "cccbbb.com", "asd@asd.co.kr"
		};
		
		for(String email : emails) {
			boolean result = Pattern.matches(emailRegex, email);
			System.out.println(email + " 이메일은 유효한가? " + result);
		}
		
		
		
		
		
	}

}
