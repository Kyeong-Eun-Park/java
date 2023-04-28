package if_;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 중첩 if문
		 * - if문 블록 내에서 또 다른 if문을 기술하는 것
		 * - 중첩 횟수에는 제한이 없음
		 * 
		 * < 기본 문법 >
		 * if(조건식1){
		 * 		if(조건식1-1){
		 * 			
		 * 		} else {
		 * 			if(조건식1-2){
		 * 
		 * 			} else if(){
		 * 
		 * 			} 
		 * 		}
		 * }
		 * 
		 * */
		
		/*
		 * 학생 점수 (score)에 대한 학점(grade) 판별
		 * A학점: 90 ~ 100점
		 * B학점: 80 ~ 89점
		 * C학점: 70 ~ 79점
		 * D학점: 60 ~ 69점
		 * F학점: 0 ~ 59점
		 * 그외: 점수입력 오류!
		 * "X학점" 라고 출력
		 * (단, score에는 int형에 저장될 수 있는 범위의 데이터가 저장된다고 가정)
		 * */
		
//		if(90 <= score && score <= 100) {
//			
//		} else if(80 <= score && score <= 89) {
//			
//		} 
		int score = -50;
		String grade = "";
		if(0 <= score && score <= 100) { // 정상범위인지 판별
			
			if(score >= 90) {
				grade = "A학점";
			} else if(score >= 80) {
				grade = "B학점";
			} else if(score >= 70) {
				grade = "C학점";
			} else if(score >= 60) {
				grade = "D학점";
			} else {
				grade = "F학점";
			}
			
			System.out.println(grade);
			
		} else {
			System.out.println("점수 입력 오류!");
		}
		
		
		
		
	}

}
