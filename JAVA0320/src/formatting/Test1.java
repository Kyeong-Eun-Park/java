package formatting;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class Test1 {

	public static void main(String[] args) {
		// Date 객체를 생성하여 오늘 날짜 및 현재 시간을 다음과 같이 변환하여 출력
		// ex) 2023년 03월 20일(월) [오후] 04시 08분 30초
		
		Date now = new Date();
		String pattern = "yyyy년 MM월 dd일(E) [a] hh시 mm분 ss초";
		
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
	 	String strNow = sdf.format(now);
	 	System.out.println(strNow);
		
	 	System.out.println(new SimpleDateFormat(pattern).format(new Date()));
	 	
	 	System.out.println(LocalDateTime.now().format(DateTimeFormatter.ofPattern(pattern)));
	 	
	 	
		
	}

}
