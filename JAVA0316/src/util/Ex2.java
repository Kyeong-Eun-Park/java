package util;

import java.util.Date;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * java.util.Date 클래스
		 * - 날짜 관련 기능을 제공하는 클래스
		 * - 대부분의 메서드가 deprecated 처리되어 있음
		 *   => 그러나, 다양한 API 들은 여전히 Date타입을 사용하는 경우가 많음
		 * - toString() 메서드가 오버라이딩 되어 있음
		 * - 기본 생성자를 호출하여 인스턴스 생성하면 시스템의 날짜 및 시간 정보를 사용하여
		 *   Date 객체를 생성하여 리턴   
		 * */
		Date d1 = new Date();
		System.out.println(d1);
		// "Thu Mar 16 15:00:48 KST 2023" 출력됨 (영어권 날짜 및 시간 표현 방법으로 사용됨)
		
		// long 타입 파라미터를 전달받는 생성자 호출
		Date d2 = new Date(2000000000000L);
		// 기준 날짜 및 시간으로부터 해당 long타입 값(ms)만큼 뒤의 날짜 및 시간으로 설정
		System.out.println(d2);
		
		Date d3 = new Date(2000, 6, 5);
		System.out.println(d3);
		
		// 1900년도가 기준이 되어 현재 연도에서 뺀값 리턴됨 
		System.out.println(d1.getYear() + 1900 + "년");
		
		// 시스템상에서 0 ~ 11월 형태로 사용하므로 +1 필수!
		System.out.println(d1.getMonth() + 1);
		
		System.out.println(d1.getDate());
		
		// 요일 정보를 정수로 리턴(0: 일요일, 6: 토요일)
		System.out.println(d1.getDay());
		
		System.out.println("--------------------------------------------");
		
		// d1: Thu Mar 16 15:06:44 KST 2023
		// d2: Wed May 18 12:33:20 KST 2033
//		long diff = d2.getTime() - d1.getTime();
//		long diff = d1.getTime() - d2.getTime();
		long diff = d1.getTime() - d1.getTime();
		System.out.println(diff);
		
		if(diff < 0) {
			System.out.println(diff / 1000 / 60 / 60 / 24 + "일 남았습니다");
		} else if(diff > 0){
			System.out.println(diff / 1000 / 60 / 60 / 24 + "일 지났습니다");
		} else {
			System.out.println("오늘입니다!");
		}
		
	}
}

