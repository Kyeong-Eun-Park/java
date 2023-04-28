package enum_;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * enum에 속성 추가
		 * 
		 * 1. Enum 클래스에서 제공되는 ordinal로는 한계가 있음
		 * 	- 특정 데이터를 지정해 주고싶다!
		 * 예) 지역번호: (서울: 02, 경기도: 031, 부산: 051 ...)
		 * 	URL: NAVER("https://www.naver.com") 
		 * 		 DAUM("https://www.daum.net") 
		 * 		 GOOGLE("https://www.google.com")
		 * 
		 * 2. 시스템 유지보수중 enum의 멤버가 추가되거나 변경된다면?
		 * 	- 기존 ordinal 이 깨질 수 있다.
		 * 	=> ordinal로 계산하고 있던 모든 로직을 찾아 수정해야한다.
		 * 예) 평일만 관리하고 잇었다. (월, 화, 수, 목, 금 -> 0, 1, 2, 3, 4)
		 * 	  주말고 관리해야 할것 같다 (일, 월, 화, 수, 목, 금, 토 -> 0, 1, 2 ..6)
		 * 
		 * 3. 모두 같은 뜻인데 DB의 테이블마다 다른 데이터로 관리되고 있다.
		 * 예) 학교 데이터 (졸업여부: Y/N)
		 * 	   공장 생산관리 데이터 (입고완료여부: 1/0)
		 * 					   (출고완료여부: true/false)
		 * 	   배민 (결져완료여부: T/F)
		 * */
		
		Area 부산 = Area.부산;
		System.out.println(부산.areaNum); 
		
		Site site = Site.NAVER;
		System.out.println(site.url);
		
		Status status = Status.Y;
		System.out.println(status.iValue);
		System.out.println(status.bValue);
		System.out.println(status.sValue);
		
		if(status.bValue) {
			System.out.println("if문 잘됨");
		}
		
	}
}

enum Area {
	서울("02"), 경기도("031"), 인천("032"), 부산("051");
	
	String areaNum;
	private Area(String areaNum) {
		this.areaNum = areaNum;
	}
}

enum Site {
	NAVER("https://www.naver.com"), 
	DAUM("https://www.daum.net"), 
	GOOGLE("https://www.google.com");
	
	String url;
	private Site(String url) {
		this.url = url;
	}
}

enum Status {
	Y(1, true, "T"), N(0, false, "F");
	
	int iValue;
	boolean bValue;
	String sValue;
	
	private Status(int iValue, boolean bValue, String sValue) {
		this.iValue = iValue;
		this.bValue = bValue;
		this.sValue = sValue;
	}
	
}








