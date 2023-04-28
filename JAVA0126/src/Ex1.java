
public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 기본형(Primitive Type) 변수와 참조형(Reference Type) 변수의 차이
		 * - 기본형 변수는 실제값(리터럴)을 저장하며,
		 *   참조형 변수는 실제값이 저장된 인스턴스의 주소값(참조값 = 레퍼런스)을 저장
		 * 
		 * 기본형 변수와 참조형 변수의 값을 복사(전달)할 때 차이점
		 * 1. 기본형 변수의 값을 복사할 경우
		 * 	- 변수에 저장된 실제 값을 복사(전달) = Pass by value
		 * 	- 실제 값을 복사하게 되면 원본 값과 동일한 값이 별도로 생성되어 전달되므로
		 *    복사된 값을 변경하더라도 원본 값과 상관이 없기 때문에 원본값은 변경되지 않는다!
		 * 
		 * 2. 참조형 변수의 값을 복사할 경우
		 * 	- 변수에 저장된 인스턴스 주소값을 복사(전달) = Pass by reference
		 * 	- 주소 값을 복사하게 되면 원본 값에 저장된 주소와 동일한 주소가 전달되므로
		 *    실제 인스턴스 하나를 함께 공유하게 된다.
		 *    따라서, 한쪽에서 인스턴스에 접근하여 저장된 값을 변경할 경우
		 *    동일한 주소값을 참조하는 쪽에도 영향을 받게 된다.
		 *    => 즉, 한쪽에서 값을 변경하면 다른쪽의 값도 함께 변경되 효과를 갖는다.
		 * */
		int x = 10;
		int y = x;
		System.out.println("x = " + x + ", y = " + y);
		
		y = 99;
		System.out.println("x = " + x + ", y = " + y);
		// => 기본형 변수 y의 값을 변경하더라도
		//    원본데이터 기본형 변수 x의 값은 변경되지 않음
		System.out.println("--------------------------------");
		
		Num n = new Num();
		n.x = 10;
		n.y = n.x;
		System.out.println("n.x = " + n.x + ", n.y = " + n.y);
		
		n.y = 99;
		System.out.println("n.x = " + n.x + ", n.y = " + n.y);
		// => Num 클래스의 인스턴스 내에 있는 기본형 변수 y의 값을 변경 하더라도
		//    원본 데이터 기본형 변수 x의 값은 변경되지 않음
		System.out.println("--------------------------------");
		
		Num n2 = new Num();
		n2.x = 10;
		n2.y = 10;
		
		Num n3 = n2; // Num 타입 참조형 변수 n3에 참조형 변수 n2의 값 복사(= 주소값 복사)
		// => 참조형 변수 n2가 가리키는 인스턴스 주소값을 n3에 복사(전달) 했으므로
		//    n2와 n3가 가리키는(참조하는) 인스턴스가 동일함
		
		System.out.println("n2.x = " + n2.x + ", n2.y = " + n2.y);
		System.out.println("n3.x = " + n3.x + ", n2.y = " + n3.y);
		
		n3.y = 99;
		System.out.println("n2.x = " + n2.x + ", n2.y = " + n2.y);
		System.out.println("n3.x = " + n3.x + ", n2.y = " + n3.y);
		// => n2와 n3 모두 하나의 인스턴스를 참조하고 있으므로
		//    한쪽에서 인스턴스 내의 변수값을 변경하면
		//    다른쪽의 인스턴스도 동일하므로 똑같이 변경된 사항이 적용됨!
		System.out.println("-----------------------------");
		
		PassValue pv = new PassValue();
		
		int xNum = 10;
		System.out.println("changeValue() 메서드 호출 전 x : " + xNum);
		pv.changeValue(xNum);
		System.out.println("changeValue() 메서드 호출 후 x : " + xNum);
		
		System.out.println("--------------------------------------");
		
		Num num = new Num();
		num.x = 10;
		System.out.println("changeReferenceValue() 메서드 호출 전 num.x : " + num.x);
		pv.changeReferenceValue(num);
		System.out.println("changeReferenceValue() 메서드 호출 후 num.x : " + num.x);
	}
}

class PassValue {
	// 참조형을 전달받음
	public void changeReferenceValue(Num num) {
		System.out.println("changeReferenceValue() 메서드의 변경 전 num.x : " + num.x);
		num.x = 999;
		System.out.println("changeReferenceValue() 메서드의 변경 후 num.x : " + num.x);
	}
	
	// 기본형을 전달받음
	public void changeValue(int x) {
		System.out.println("changeValue() 메서드의 변경 전 x : " + x);
		x = 999;
		System.out.println("changeValue() 메서드의 변경 후 x : " + x);
	}
}

class Num {
	int x;	// 기본형 변수 x
	int y;	// 기본형 변수 y
}








