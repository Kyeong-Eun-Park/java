package auth;

import org.apache.commons.lang3.RandomStringUtils;

public class GenerateRandomCode {
	
	// 난수 길이에 해당하는 영문자, 숫자 조합 난수 생성 후 리턴하는 getRandomCode() 메서드 정의
	// => commons-lang3-3.12.0.jar 라이브러리 필요
	public static String getRandomCode(int length) {
		return RandomStringUtils.randomAlphanumeric(length);
	}
	
}
