package switch_case;

public class Test1 {

	public static void main(String[] args) {
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
		
		int score = 100;
		String grade = "";
		
		if(0 <= score && score <= 100) { // 정상범위인지 판별
			
			switch (score/10) {
			case 10:	
			case 9:		grade = "A학점";	break;
			case 8:		grade = "B학점"; break;
			case 7:		grade = "C학점"; break;
			case 6:		grade = "D학점"; break;
			default:	grade = "F학점"; break;
			}
			
			System.out.println(grade);
			
		} else {
			System.out.println("점수입력 오류!");
		}
		
		
		
		
	}

}
