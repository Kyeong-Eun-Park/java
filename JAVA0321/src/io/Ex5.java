package io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class Ex5 {

	public static void main(String[] args) {
		/*
		 * 키보드로부터 데이터를 입력받아 처리하는 방법
		 * 5. BufferedReader 객체를 사용하여 String 단위로 입력 데이터를 처리하는 방법
		 * 	- InputStream 객체를 파라미터로 갖는 InputStreamReader 객체 생성 후
		 * 	  다시 InputStreamReader 객체를 파라미터로 갖는 BufferedReader 객체 생성
		 * 	- read() 메서드가 아닌 readLine() 메서드를 사용하여 String 단위로 처리
		 * 	- 키보드를 통해 입력되는 데이터를 처리하는 최종적인 방법 (가장 효율적)
		 * */
		
		// 1. 기변 입력스트림 객체 (InputStream) 생성 = byte 단위 처리
//		InputStream is = System.in;
		
		// 2. 입력스트림을 연결하는 보조스트림 InputStreamReader 객체 생성 = char 단위
//		InputStreamReader reader = new InputStreamReader(is);
		
		// 3. 향상된 입력 보조스트림 BufferedReader 객체 생성 = String 단위 처리
//		BufferedReader buffer = new BufferedReader(reader);
		
		// ---- 위 세문장을 하나의 문장으로 결합 -----
//		BufferedReader buffer = new BufferedReader(
//				new InputStreamReader(System.in));
		
		System.out.println("데이터를 입력하세요.");
		
		try(BufferedReader buffer = new BufferedReader(
				new InputStreamReader(System.in))){
			
			// 입력스트림에서 한줄의 데이터 읽어오기
			String str = buffer.readLine();
			System.out.println("입력데이터: " + str);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

}
