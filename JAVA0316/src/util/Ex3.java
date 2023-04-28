package util;

import java.util.Calendar;
import java.util.Date;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * java.util.Calendar 클래스
		 * - 날짜 및 시간을 관리하는 클래스 (Date 클래스와 유사함)
		 * - 주로 날짜 및 시간 정보를 조정하는 용도로 사용
		 *   (과거에는 Calendar 클래스로 날짜 조작, Date 클래스로 날짜 표현함)
		 * - 추상클래스 이므로 인스턴스 생성이 불가능하며,
		 *   미리 시스템으로부터 생성되어 제공되는 인스턴스를 리턴받아 사용
		 *   => getInstance() 메서드 호출하여 인스턴스를 리턴받음  
		 * */
		
		// 추상클래스이므로 인스턴스 생성 불가
//		Calendar cal = new Calendar();
		
//		Calendar cal = Calendar.getInstance();
//		Calendar cal2 = Calendar.getInstance();
		
//		System.out.println(cal == cal2); // true가 나와야 진짜 싱글톤
		
		Calendar cal = Calendar.getInstance();
		System.out.println(cal);
		
		// get(int field) 메서드를 사용하여 특정 항목에 대한 값 가져오기
		// => 항목 지정을 위해 get() 메서드 파라미터로 Calendar.XXX 상수를 전달하여
		//    가져오고자 하는 대상 항목을 지정할 수 잇다.
		int year = cal.get(Calendar.YEAR);
		System.out.println(year + "년");
		
		// Date 클래스와 마찬가지로 0 ~ 11월 사용
		// => 따라서, 결과값 +1 필요
		int month = cal.get(Calendar.MONTH) + 1;
		System.out.println(month + "월");
		
		int day = cal.get(Calendar.DAY_OF_MONTH);
		System.out.println(day + "일");
		
		int dayOfWeek = cal.get(Calendar.DAY_OF_WEEK);
		System.out.println(dayOfWeek);	// 일요일: 1 ~ 토요일: 7
		
		int amPm = cal.get(Calendar.AM_PM);
		System.out.println(amPm);
		
		String strAmPm = amPm == Calendar.AM ? "오전" : "오후";
		System.out.println(strAmPm);
		
		System.out.println("============================");
		
		// Calendar <-> Date 객체 상호 변환
		// 1. Calendar -> Date 로 변환
		// => Calendar 객체의 getTime() 메서드 호출하여 Date 타입으로 리턴
		Date date = cal.getTime();
		System.out.println(date);
		
		// 2. Date -> Calendar로 변환
		Calendar cal2 = Calendar.getInstance();
		cal2.setTime(date);
		System.out.println(cal2.get(Calendar.YEAR));
		
	}

}





