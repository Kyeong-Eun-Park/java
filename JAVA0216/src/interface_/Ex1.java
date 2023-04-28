package interface_;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 인터페이스 필요성 (장점)
		 * 3. 상속 관계가 없는 객체끼리의 관계를 부여하여 다형성 활용 가능
		 * */
		
		HandPhone hp1 = new HandPhone();
		HandPhone hp2 = new HandPhone();
		DigitalCamera dc1 = new DigitalCamera();
		DigitalCamera dc2 = new DigitalCamera();
		
		// => Object 타입 배열에 HandPhone, DigitalCamera 인스턴스를 업캐스팅 하여 저장 
		Object[] objs = { hp1, dc1, hp2, dc2 };
		
		// 반복문을 사용하여 Object[] 배열 크기만큼 반복
		for(int i = 0; i < objs.length; i++) {
			Object obj = objs[i];
			if(obj instanceof HandPhone) {
				// instanceof 연산자를 사용하여 객체를 판별 후 다시 다운캐스팅을 통해
				// 원래 객체 형태로 변환하여 사용 해야함!
				HandPhone hp = (HandPhone)obj;
				hp.charge();
			} else if(obj instanceof DigitalCamera) {
				DigitalCamera dc = (DigitalCamera)obj;
				dc.charge();
			} 
		}
		
		// ----- 향상된 for문 -----
		for(Object obj : objs) {
			if(obj instanceof HandPhone) {
				HandPhone hp = (HandPhone)obj;
				hp.charge();
			} else if(obj instanceof DigitalCamera) {
				DigitalCamera dc = (DigitalCamera)obj;
				dc.charge();
			}
		}
		
		System.out.println("----------------------------------");
		
		// ----- 인터페이스를 통해 상속관계가 아닌 클래스끼리 상속 관계 부여 -----
		/*
		 * HandPhone2 클래스와 DigitalCamera2 는 특정 클래스와 상속 관계가 아니지만
		 * 두 클래스와 유일한 공통클래스는 Object 클래스 외에
		 * Chargable 인터페이스를 정의하여 공통 부모로 정의하면
		 * 업캐스팅 후에도 두 객체의 고유 멤버인 charge() 메서드가
		 * 인터페이스 내의 추상메서드로 정의되어 있기 때문에
		 * 타입 판별없이, 다운캐스팅 없이도 공통 메서드 호출이 가능하다!
		 * */
		HandPhone2 hp3 = new HandPhone2();
		HandPhone2 hp4 = new HandPhone2();
		DigitalCamera2 dc3 = new DigitalCamera2();
		DigitalCamera2 dc4 = new DigitalCamera2();
		
		Chargable[] objs2 = { hp3, hp4, dc3, dc4 };
		
		for(Chargable ch : objs2) {
			// 공통 부모인 Chargable 인터페이스 타입으로 업캐스팅 한 뒤에도
			// 공통 메서드인 charge() 메서드에 직접 접근 가능 => instanceof 판별 필요없음
			ch.charge();
		}
		
		
		
	}

}
//----- 인터페이스를 통해 상속관계가 아닌 클래스끼리 상속 관계 부여 -----
// 서로 상속 관계가 없는 HandPhone 과 DigitalCamera 클래스에
// 인터페이스를 통한 상속 관계를 부여하면 다형성을 확장하여 적용 가능
interface Chargable {
	public void charge();
}

class Phone2 {}
class HandPhone2 extends Phone2 implements Chargable {
	@Override
	public void charge() {
		System.out.println("HandPhone 충전");
	}
}

class Camera2 {}
class DigitalCamera2 extends Camera2 implements Chargable {
	@Override
	public void charge() {
		System.out.println("DigitalCamera 충전");
	}
}



// ------ 상속 관계가 아닐 경우 나쁜(불편한) 예 ---------
class Phone {}
class HandPhone extends Phone {
	public void charge() {
		System.out.println("HandPhone 충전");
	}
}

class Camera {}
class DigitalCamera extends Camera {
	public void charge() {
		System.out.println("DigitalCamera 충전");
	}
}









