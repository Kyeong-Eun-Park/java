package jsp15_randomize;

import org.apache.commons.lang3.RandomStringUtils;

public class MyRandomize2 {
	// Apache Commons Lang API(3.x 버전) 활용하여 난수 발생
	// => RandomStringUtils 클래스의 static 메서드 randomXXX() 활용
	//    => 파라미터 : 난수 문자열 길이
	public String getRandomNumeric() {
		return RandomStringUtils.randomNumeric(20); // 난수 정수 20자리 생성
	}
	
	public String getRandomAlphabetic() {
		return RandomStringUtils.randomAlphabetic(20); // 난수 알파벳(대소문자 조합) 20자리 생성
	}
	
	public String getRandomAlphanumeric() {
		return RandomStringUtils.randomAlphanumeric(20); // 난수 알파벳, 정수 조합 20자리 생성
	}
	
	public String getRandom() {
		// 지정한 start ~ end 까지의 코드 범위 내의 문자 생성
		// random(길이, 시작코드번호, 끝코드번호, 문자로만생성여부, 숫자로만생성여부)
		return RandomStringUtils.random(20, 48, 122, false, false);
	}
	
	
}











