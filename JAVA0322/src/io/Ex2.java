package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 모니터로 데이터를 출력하는 방법
		 * 2. OutputStreamWriter 사용 (char 단위로 처리)
		 * 	- write() 메서드를 호출하여 char[] 배열 또는 String 객체를 전달하여
		 *    문자 데이터 출력 가능
		 *    => String 클래스는 char[] 배열로 관리되므로 Writer 계열에서 처리가능
		 * 	- 데코레이션 패턴을 활용하여 BufferedWriter 객체 사용 가능
		 * 	  => OutputStreamWriter 보다 BufferedWriter 의 처리속도가 빠르다!
		 * */
		
//		try (OutputStreamWriter writer = 
//				new OutputStreamWriter(System.out)){
//			String str = "Hello, 자바";
//			writer.write(str);
//			
//		} catch (IOException e) {
//			e.printStackTrace();
//		}
		
		// ==================================
		
		// Scanner 대신 사용 (속도가 더 빠름)
//		BufferedReader reader =
//				new BufferedReader(new InputStreamReader(System.in));
		
		// System.out.println() 대신 사용 (속도가 더 빠름)
		try (BufferedWriter writer =
				new BufferedWriter(new OutputStreamWriter(System.out))){
			
			String str = "Hello, 자바";
			writer.write(str);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
		
		
		
	}

}
