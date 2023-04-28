package enum_;

public class Test1 {

	public static void main(String[] args) {
		/*
		 * enum(Week)을 활용하여
		 * 
		 * 주말 까지 몇일 남았는지 출력 (주말이면 "이미 주말!!!" 출력)
		 * 
		 * 예) 오늘은 X요일... 주말까지 X일 남았다!
		 * 
		 * */
		Week week = Week.금;
		
//		if(week == Week.토 || week == Week.일) {
		if(week.ordinal() > Week.금.ordinal()) {
			System.out.println("이미 주말!!!");
		} else {
			System.out.println("오늘은 " + week + "요일... 주말까지 "
					+ Week.토.compareTo(week) + "일 남았다!");
		}
		
	}
}

enum Week {
	월, 화, 수, 목, 금, 토, 일
}








