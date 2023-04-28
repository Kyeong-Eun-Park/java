package array;

public class Test1 {

	public static void main(String[] args) {
		/*
		 * 1차원 배열(names)에 5명 학생의 이름을 저장하고,
		 * 2차원 배열(score)에 5명 학생의 국어, 영어, 수학 점수 저장 후 출력
		 * 학생별 총점을 1차원 배열(total)에 저장하고 출력
		 * 
		 * 		< 출력 예시 >
		 * 			국어	영어	수학
		 * 홍길동		80	80	80
		 * 이순신		90	80	77
		 * 강감찬		60	50	60
		 * 김태희		100	100	100
		 * 전지현		50	80	100
		 * ----------------------------
		 * < 학생별 총점 >
		 * 홍길동: 160점
		 * 이순신: 247점
		 * 강감찬: 170점
		 * 김태희: 300점
		 * 전지현: 230점
		 * 
		 * */
		
		String[] names = {"홍길동", "이순신", "강감찬", "김태희", "전지현"};
		int[][] score = {
				{80, 80, 80},
				{90, 80, 77},
				{60, 50, 60},
				{100, 100, 100},
				{50, 80, 100}
		};
		
		System.out.println("\t국어\t영어\t수학");
		for(int i = 0; i < score.length; i++) {
			
			System.out.print(names[i] + "\t");
			
			for(int j = 0; j < score[i].length; j++) {
				System.out.print(score[i][j] + "\t");
			}
			System.out.println();
		}
		System.out.println("--------------");
		System.out.println("< 학생별 총점 >");
		// 학생별 총점을 저장할 정수형 배열 total 생성
		int[] total = new int[names.length];
		
//		total[0] = score[0][0] + score[0][1] + score[0][2];
//		total[1] = score[1][0] + score[1][1] + score[1][2];
		
		for(int i = 0; i < score.length; i++) {
			for(int j = 0; j < score[i].length; j++) {
				total[i] += score[i][j];
			}
		}

		// 홍길동: 160점
		for(int i = 0; i < names.length; i++) {
			System.out.println(names[i] + ": " + total[i]);
		}
		
	}

}

