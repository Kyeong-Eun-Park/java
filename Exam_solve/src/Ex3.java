import java.util.StringJoiner;

public class Ex3 {

	public static void main(String[] args) {
		char ch = 'A';
		
		String result = "기타문자";
		if(Character.isUpperCase(ch)) {
			result = ch + " : 대문자";
		} else if (Character.isLowerCase(ch)) {
			result = ch + " : 대문자";
		} else if(ch >= 0 && ch <= 9) {
			result = ch + " : 대문자";
		}
		
		System.out.println(result);
		
	}

}
