package util;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;

public class Ex4 {

	public static void main(String[] args) {
		/*
		 * java.time 패키지
		 * - 날짜 및 시간 정보를 관리하는 클래스들의 모음 패키지 (JDK 8부터 제공됨)
		 *   => Date 및 Calendar 클래스에 비해 직관적이므로 사용하기 쉽다.
		 * 
		 * - LocalDate 클래스 - 날짜 관련 기능 제공
		 * - LocalTime 클래스 - 시간 관련 기능 제공
		 * - LocalDateTime 클래스 - 날짜 및 시간 관련 기능 제공 
		 * - Calendar 클래스처럼 객체 생성없이 시스템이 생성한 객체를 리턴받아 사용
		 *   => 생성자가 보이지 않도록 은닉되어 있음
		 * - 각 클래스의 now() 메서드를 호출하여 현재 시스템의 날짜 및 시간 정보 가져오고
		 *   각 클래스의 of() 메서드를 호출하여 날짜 및 시간 정보 설정
		 *   => static 메서드로 제공되므로 클래스명만으로 접근 가능
		 * - getXXX() 메서드를 호출하여 상세 항목 정보 가져오기 가능
		 *   => (ex. 연도: getYear(), 시간: getHour())    
		 *   
		 * */
		
		LocalDate date = LocalDate.now();
		System.out.println(date);
		
		LocalTime time = LocalTime.now();
		System.out.println(time);
		
		LocalDateTime dateTime = LocalDateTime.now();
		System.out.println(dateTime);
		
		System.out.println("--------------------------");
		
		// 각 객체의 값 설정 XXX.of() 메서드 사용
		LocalDate date2 = LocalDate.of(2000, 1, 1);
		System.out.println(date2);
		
		LocalTime time2 = LocalTime.of(9, 10, 59);
		System.out.println(time2);
		
		LocalDateTime dateTime2 = LocalDateTime.of(1999, 12, 31, 23, 59, 59);
		System.out.println(dateTime2);
		
		System.out.println("--------------------------");
		
		int year = date.getYear();
		int month = date.getMonthValue();	// 주의! getMonth() 메서드는 Month 타입 리턴
		int day = date.getDayOfMonth();
		System.out.println(year + " / " + month + " / " + day);
		
		// getMonth() 
		Month eMonth = date.getMonth(); // enum 타입 객체 형태로 리턴됨
		System.out.println(eMonth);
		
		System.out.println("----------------------------------");
		
		LocalDate now = LocalDate.now();
		LocalDate afterTwoYear = now.plusYears(2);
		System.out.println(afterTwoYear);
		
		System.out.println("2개월 뒤는 " + now.plusMonths(2) + " 입니다.");
		// => 연도 및 일자에 영향 있음
		System.out.println("2개월 뒤는 " + now.withMonth(2) + " 입니다.");
		// => 연도 및 일자는 영향 없음
		
		System.out.println("20일 뒤는 " + now.plusDays(20) + " 입니다.");
		
		// 빌더 패턴 (Builder Pattern)을 활용하여 메서드를 연쇄적으로 호출 가능
		System.out.println(now.plusYears(2).plusMonths(2).plusDays(20)); 
		
	}

}
