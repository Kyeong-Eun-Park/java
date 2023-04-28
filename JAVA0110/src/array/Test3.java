package array;

public class Test3 {

	public static void main(String[] args) {
		/*
		 * 거스름돈 계산
		 * N이 32850일 경우
		 * 50000원	: 0개
		 * 10000원	: 3개
		 * 5000원	: 0개
		 * 1000원	: 2개
		 * 500원		: 1개
		 * 100원		: 3개
		 * 50원		: 1개
		 * 10원		: 0개
		 * 
		 * */
		int N = 32850;
		int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		
//		System.out.println(N / 50000); 
//		N %= 50000;
		
		for(int i = 0; i < money.length; i++) {
			int count = (N / money[i]);
			System.out.println(money[i]+"원	: " + count + "개");
			N %= money[i];
		}
		
		System.out.println("------------------------------------");
		N = 32850;
//		int[] money = {50000, 10000, 5000, 1000, 500, 100, 50, 10};
		
		int[] cnts = change(N, money);
		for(int i = 0; i < money.length; i++) {
			System.out.println(money[i]+"원	: " + cnts[i] + "개");
		}
		
	} // main() 메서드 끝
	
	// 금액(N), 화폐들(money) 을 전달받아 거스름돈 갯수를 저장하는 1차원배열을 리턴하는 메서드
	public static int[] change(int N, int[] money) {
		int[] cnts = new int[money.length];
		
		for(int i = 0; i < money.length; i++) {
			cnts[i] = N / money[i];
			N %= money[i];
		}
		
		return cnts;
	}
	
	

}
