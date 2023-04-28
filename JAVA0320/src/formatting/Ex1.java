package formatting;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 날짜 및 시간 정보에 대한 형식화 (Formatting) 클래스
		 * - 날짜 및 시간 정보를 개발자가 원하는 형식으로 표현하기 위한 클래스
		 * - 형식 지정 문자를 사용하여 표현할 형식 지정
		 * 1. SimpleDateFormat 클래스
		 * 		- Date 타입 객체에 대한 형식화
		 * 		- 형식 지정문자
		 * 		  y : 연도 (yy: 두자리, yyyy: 네자리), M: 월, d: 일
		 * 		  E : 요일 (E: 한글자, EEEE: 풀네임)
		 * 		  H : 시(0 ~ 23), h : 시(1 ~ 12), m : 분, s : 초, a : 오전/오후
		 * 
		 * 2. DateTimeFormatter 클래스
		 * 		- LocalDate, LocalTime, LocalDateTime 타입 객체에 대한 형식화
		 * 		- 기본적인 형식 지정문자 사용법이 SimpleDateFormat 클래스와 동일함
		 * 		- 주의사항! LocalDate 또는 LocalTime 의 경우 존재하지 않는 항목에 대해
		 *        패턴이 지정될 경우 예외가 발생할 수 있다!
		 * 
		 * */
		
		// ----- SimpleDateFormat 클래스를 사용한 Date 객체 표현 형식 변경 -----
		Date now = new Date();
		System.out.println(now); // Mon Mar 20 15:58:20 KST 2023
		
		// 1. 표현 형식을 지정하기 위해 형식 지정문자를 사용한 문자열 패턴 생성
		String pattern = "yyyy년 MM월 dd일 EEEE a hh:mm:ss";
		
		// 2. SimpleDateFormat 클래스 객체 생성 => 파라미터로 패턴 문자열 전달
 		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	 	
 		// 3. SimpleDateFormat 객체의 format() 메서드를 호출하여 Date 객체 전달
 		//    => 지정된 패턴에 따라 Date 객체의 날짜 및 시간 표현을 변경한 문자열 리턴
 		String formattingNow = sdf.format(now);
 		
 		System.out.println(formattingNow);
 		
 		// ----- DateTimeFormatter 클래스를 사용한 java.time 패키지 표현 형식 변경 -----
 		LocalDateTime now2 = LocalDateTime.now();
 		System.out.println(now2);
 		
 		String pattern2 = "yyyy년 MM월 dd일 EEEE a hh:mm:ss";
		
 		// DateTimeFormatter 클래스의 ofPattern() 메서드를 호출하여 패턴 전달
 		DateTimeFormatter dtf = DateTimeFormatter.ofPattern(pattern2);
 		
 		// LocalDateTime 객체의 format() 메서드를 호출하여 DateTimeFormatter 객체 전달
		System.out.println(now2.format(dtf)); 
		
		
	}
}
