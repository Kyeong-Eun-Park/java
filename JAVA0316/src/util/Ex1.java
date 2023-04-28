package util;

import java.util.StringTokenizer;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * StringTokenizer 클래스
		 * - java.util 패키지
		 * - 문자열을 분리하여 토큰(Token = 분리된 각 문자열)을 생성하는 기능을 제공
		 * - Delimeter(구분자 또는 분리자)를 기준으로 문자열을 분리하여
		 *   StringTokenizer 타입 객체로 관리
		 *   => 객체 내의 분리된 문자열을 토큰(Token)이라고 함
		 *   
		 * < 생성자 >
		 * StringTokenizer st = new StringTokenizer("원본문자열", 구분자);
		 * => 구분자를 기준으로 원본문자열을 분리하여 객체로 생성  
		 *   
		 * < 제공 메서드 >
		 * 1. countTokens()
		 * 2. hasMoreTokens()
		 * 3. nextToken()  
		 * */
		
		String str = "자바/JSP/안드로이드";
		StringTokenizer st = new StringTokenizer(str, "/");
		System.out.println("분리된 토큰 갯수: " + st.countTokens());
//		System.out.println("다음 토큰이 존재하는가? " + st.hasMoreTokens());
//		System.out.println("다음 토큰 가져오기: " + st.nextToken());
//		System.out.println("다음 토큰이 존재하는가? " + st.hasMoreTokens());
//		System.out.println("다음 토큰 가져오기: " + st.nextToken());
//		System.out.println("다음 토큰이 존재하는가? " + st.hasMoreTokens());
//		System.out.println("다음 토큰 가져오기: " + st.nextToken());
//		System.out.println("다음 토큰이 존재하는가? " + st.hasMoreTokens());
//		System.out.println("다음 토큰 가져오기: " + st.nextToken());
		
		while(st.hasMoreTokens()) {
			System.out.println("토큰 꺼내기: " + st.nextToken());
		}
		
		System.out.println("===================================");
		
		String str2 = "자바.JSP.안드로이드";
		// StringTokenizer의 구분자로 사용될 문자열에 마침표 사용 시 그대로 사용가능
		// => String 클래스의 split() 메서드와 달리 정규표현식을 적용하지 않음
		StringTokenizer st2 = new StringTokenizer(str2, ".");
		
		while(st2.hasMoreTokens()) {
			System.out.println("토큰 꺼내기: " + st2.nextToken());
		}
		
		System.out.println("==================================");
		
		String str3 = "자바/JSP$안드로이드";
		
		StringTokenizer st3 = new StringTokenizer(str3, "$/");
		// => 원본문자열 내에서 $기호와 / 기호를 기준으로 모든 문자열을 분리함
		
		while(st3.hasMoreTokens()) {
			System.out.println(st3.nextToken());
		}
		
		System.out.println("----------------------");
		
		String str4 = "자바/JSP$안드로이드";
		String[] strs = str4.split("\\$|/");
		for(String s : strs) {
			System.out.println(s);
		}
		
		
	}
}
