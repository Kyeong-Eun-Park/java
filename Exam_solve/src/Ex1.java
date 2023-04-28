import java.util.Random;

public class Ex1 {

	public static void main(String[] args) {
		
		// 다음 중 키워드(예약어)에 해당하는 것을 모두 고르시오.
		// return For 자바 switch void
		
		// 정수 300억을 저장하는 변수 num
//		long l = 3000000000;
		
		
		// 정수형 변수 3개를 저장 가능한 배열 arr을 선언하고,
		// 임의의 정수 3개로 초기화하는 코드를 '한문장' 으로 작성하시오.
//		int[] arr = {1, 2, 3}; 
//		int[] arr = new int[] {1, 2, 3};
		
		
		// 자바스크립트에서 웹브라우저 상에 알림창을 통해 메세지를...
		// alert()
		
		// 1 ~ 10까지 난수 발생 코드
		new Random().nextInt(11);
		
		// 레퍼런스 형변환
		Unit u = new GroundUnit();
		Tank t = new Tank();
		AirCraft ac = new AirCraft();

//		u = (Unit)ac;
//		u = ac;
//		GroundUnit gu = (GroundUnit)u;
//		AirUnit au = ac;
//		t = (Tank)u;
//		GroundUnit gu = t;
		
		
	}
}

class Card {
	static int width;
	static int height;
	
	int num;
	
	public Card(int n) {
		num = n;
	}
	
	public static void main(String[] args) {
		Card card = new Card(1);
	}
	
}









class Unit {}
class AirUnit extends Unit {}
class GroundUnit extends Unit {}
class Tank extends GroundUnit {}
class AirCraft extends AirUnit {}










class Employee {
	String name;
	int salary;
	
	public String getEmployee() {
		return name + " " + salary;
	}
}

/*
 * 조건1. Manager 클래스는 Employee 클래스가 갖는 사원명, 연봉은 물론
 *       새로운 멤버변수인 부서명(depart)를 갖는다.
 * 조건2. 사원 정보 (사원명, 연봉, 부서명)를 리턴하는 메서드 getManager() 를 갖는다.      
 * */
class Manager extends Employee {
	String depart;
	
	public String getManager() {
		return getEmployee() + " " + depart;
	}
	
}













