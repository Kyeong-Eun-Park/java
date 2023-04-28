package for_;

public class Test1 {

	public static void main(String[] args) {
		/*
		 * 구구단의 특정 단 출력
		 * 
		 * < 2단 >
		 * 2 * 1 = 2
		 * ...
		 * 2 * 9 = 18
		 * */
		int dan = 99;
		System.out.println("< " + dan + "단 >");
		for(int i = 1; i <= 9; i++) {
			System.out.println(dan + " * " + i + " = " + dan * i);
		}
		
		
	}

}
