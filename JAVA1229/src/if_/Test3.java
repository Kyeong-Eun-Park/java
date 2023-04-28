package if_;

import java.util.Scanner;

public class Test3 {

	public static void main(String[] args) {
		// 1. 정수형 변수 num1에 대한 양수, 음수, 0을 판별
		// => 출력예시) "num은 양수!"
		
		int num1 = -10;
		
//		String result1 = "num은 ";
//		if(num1 > 0) {	// 양수
//			result1 += "양수!";
//		} else if(num1 < 0) { // 음수
//			result1 += "음수!";
//		} else {	// 0
//			result1 += "0!";
//		}
		
		// 삼항연산자
//		String result1 = num1 > 0 ? "num은 양수!" : 
//						 num1 < 0 ? "num은 음수!" : "num은 0!"; 
		
		String result1 = "num은 ";
		result1 += num1 > 0 ? "양수!" :
				   num1 < 0 ? "음수!" : "0!";
		
		System.out.println(result1);
		
		System.out.println("===============================");
		// 2. 정수형 변수 num2에 대한 홀수, 짝수, 0을 판별
		// => 출력예시) "num은 홀수!"
		int num2 = 0;
		if(num2 == 0) {
			System.out.println("num은 0!");
		} else if(num2 % 2 == 1) {
			System.out.println("num은 홀수!");
		} else {
			System.out.println("num은 짝수!");
		}
		
		System.out.println("--------------------------");
		// 3. 문자 ch가 대문자 -> 소문자, 소문자 -> 대문자, 
		//    아니면 "ch는 영문자가 아닙니다!" 출력 
		// => 출력예시) 대문자: ch = a
		//			  소문자: ch = A
		//			  알파벳이 아닐경우: ch는 영문자가 아닙니다!
		char ch = 'a';
		boolean isUpperCase = ch >= 'A' && ch <= 'Z';
		boolean isLowerCase = ch >= 'a' && ch <= 'z';
		
//		String result3 = "ch = ";
//		if(isUpperCase)		result3 += (char)(ch + 32);
//		else if(isLowerCase)result3 += (char)(ch - 32);
//		else				result3 = "ch는 영문자가 아닙니다!";
//		System.out.println(result3);
		
		// 삼항연산자
		String result3 = isUpperCase ? "ch = " + (ch += 32) :
						 isLowerCase ? "ch = " + (ch -= 32) : "ch는 영문자가 아닙니다!"; 
								 
		System.out.println(result3);
		
		/*
		 * 학생 점수 (score)에 대한 학점(grade) 판별
		 * A학점: 90 ~ 100점
		 * B학점: 80 ~ 89점
		 * C학점: 70 ~ 79점
		 * D학점: 60 ~ 69점
		 * F학점: 0 ~ 59점
		 * 
		 * "X학점" 라고 출력
		 * (단, score에는 0 ~ 100 사이 데이터만 저장되어 있다고 가정)
		 * */
		System.out.println("-----------------------------");
		
		// 콘솔에서 입력받기
		Scanner sc = new Scanner(System.in);
		int score = sc.nextInt();
//		int score = 59;
		
		String grade = "";
//		if(score >= 90)		grade = "A";
//		else if(score >= 80)grade = "B";
//		else if(score >= 70)grade = "C";
//		else if(score >= 60)grade = "D";
//		else 				grade = "F";
//		grade += "학점";
		
		// 삼항연산자
		grade = score >= 90 ? "A" : 
				score >= 80 ? "B" : 
				score >= 70 ? "C" :
				score >= 60 ? "D" : "F";
		grade += "학점";
		
		System.out.println(grade);
		
		
	}

}
