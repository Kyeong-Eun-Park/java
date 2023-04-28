
public class Ex2 {

	public static void main(String[] args) {
		// 입장료 할인 문제
		int pee = 50000;
		int age = 40;
		
		if (age <= 19 && age >= 5) {
			pee -= 25000;
		} else if(age < 5 || age > 65) {
			pee *= 0.7;
		} 
//		else {
//			pee *= 1;
//		}
		
		System.out.println();
		
	}

}
