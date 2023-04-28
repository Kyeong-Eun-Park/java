package array;

public class Test2 {

	public static void main(String[] args) {
		/*
		 * 학생 5명의 점수를 배열 score에 저장하고
		 * 각 학생 점수의 총점과 평균을 계산하여 출력
		 * < 추가 항목 >
		 * 1. 학생 이름을 저장하는 배열 names를 생성하여
		 *    이순신, 홍길동, 강감찬, 김태희, 전지현 문자열 5개를 저장한 후
		 *    학생 번호 대신 이름을 출력
		 * 2. 학생 점수 중 최고점수와 최저 점수를 찾아 출력
		 * 
		 * < 출력 예시 >
		 * 이순신: 80점
		 * 홍길동: 100점
		 * 강감찬: 50점
		 * 김태희: 90점
		 * 전지현: 77점
		 * ---------------
		 * 총점: 397점
		 * 평균: 79.4점
		 * 최고점수: 100점
		 * 최저점수: 50점
		 * */
		int[] score = {80, 100, 50, 90, 77};
		String[] names = {"이순신", "홍길동", "김태희", "진양철", "진도준"};
		
		int sum = 0;
		for(int i = 0; i < score.length; i++) {
			System.out.println(names[i] + ": " + score[i] + "점");
			sum += score[i];
		}
		
		System.out.println("---------------");
		System.out.println("총점: " + sum);
		System.out.println("평균: " + ((double)sum/names.length));
		
//		int a = 100, b = 20;
//		int max = a > b ? a : b;
//		System.out.println(max);
		
//		int max = 0;
//		int min = 100;
//		for(int i = 0; i < score.length; i++) {
//			if(max < score[i]) {
//				max = score[i];
//			}
//			
//			if(min > score[i]) {
//				min = score[i];
//			}
//		}
		
//		int max = score[0];
//		int min = score[0];
//		for(int i = 1; i < score.length; i++) {
//			if(max < score[i]) max = score[i];
//			if(min > score[i]) min = score[i];
//		}
		
		// 삼항연산자 + 향상된for문 
		int max = 0;
		int min = 100;
		for(int s : score) {
			max = max > s ? max : s;
			min = min > s ? s : min; 
		}
				
		System.out.println("최고점수: " + max);
		System.out.println("최저점수: " + min);
		
		
		
		
		
		
		
	}

}
