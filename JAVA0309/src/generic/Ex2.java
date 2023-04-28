package generic;

public class Ex2 {

	public static void main(String[] args) {
		// 사용자 정의 클래스에 대한 제네릭 타입 적용
		
		NormalIntegerClass nic = new NormalIntegerClass();
		nic.data = 10;
//		nic.data = 3.14;
//		nic.data = "홍길동";
		// => 여러 데이터타입 데이터를 모두 저장하려면 최소한 Object 타입 변수 선언해야함
		
		// ----------------------------------------------
		NormalObjectClass noc = new NormalObjectClass();
		noc.data = 10;
		noc.data = 3.14;
		noc.data = "홍길동";
		// => Object 타입 변수이므로 모든 데이터타입 저장이 가능
		// => 단, 객체 내의 데이터를 꺼내서 사용할 때 타입 판별이 필수!
//		System.out.println(noc.data + 10);
		if(noc.data instanceof Integer) {
			System.out.println((int)noc.data + 10);
		}
		
		// ===========================================
		// 제네릭을 사용한 클래스의 인스턴스 생성
		// 1. 제네릭 타입 T를 Integer 타입으로 지정 (대체)
		GenericClass<Integer> gc = new GenericClass<Integer>();
		gc.setData(1); // setData(Integer data) 형태로 바뀌어 있음
//		gc.setData("홍길동"); // 컴파일에러 발생! Integer 타입만 전달 가능!
		
		System.out.println(gc.getData()); // 리턴타입이 Integer 타입으로 바뀌어 있음
		int num = gc.getData(); // 오토언박싱
		System.out.println(num + 10);
		
		// 2. 제네릭 타입 T를 Double 타입으로 지정 (대체)
		GenericClass<Double> gc2 = new GenericClass<Double>();
		gc2.setData(3.14);
		double dNum = gc2.getData();
		System.out.println(dNum);
		
		// 3. 제네릭 타입 T를 String 타입으로 지정 (대체)
		GenericClass<String> gc3 = new GenericClass<String>();
		gc3.setData("홍길동");
		String strName = gc3.getData();
		System.out.println(strName);
		
		// 4. 제네릭 타입 T를 Person 타입으로 지정
		GenericClass<Person> gc4 = new GenericClass<Person>();
		gc4.setData(new Person("홍길동", 20));
		Person p = gc4.getData();
		System.out.println(p);
		System.out.println(p.getName() + ", " + p.getAge());
		
		System.out.println("----------------------------------");
		// 제네릭 타입 지정 생략 시 Object 타입으로 지정됨
		// => Object 타입 미지정과 지정의 기능상의 차이는 없으나
		//    제네릭 타입 자체를 생략할 경우 경고메세지가 표시되므로 제네릭 사용 추천
		GenericClass gc5 = new GenericClass();
		GenericClass<Object> gc6 = new GenericClass<Object>();
	}
}

/*
 * 제네릭을 사용한 클래스 정의
 * - 클래스 정의 시점에서 클래스명 뒤에 <> 기호를 쓰고, 기호 사이에 '가상의 데이터타입' 명시
 * 	 => 보통 1글자 영문 대문자 사용(주로 E(Element), T(Type) 등을 사용)
 * 	 => 가상의 데이터타입이므로 실제 데이터타입으로 사용은 불가능하나
 *      제네릭 타입에서 임시로 설정하여 관리함
 * - 지정된 가상의 자료형은 클래스 내부에서 실제 데이터타입 명시하는 부분에 대체가 가능함     
 * */
class GenericClass <T> {
	// 제네릭타입 T 지정 시 클래스 내의 데이터타입 부분을 T로 지정하여
	// 임시 데이터타입으로 클래스 정의 가능(실제 사용 가능한 데이터타입은 아니다!)
	// => 차후, 객체 생성 시점에서 제네릭 타입에 대한 실제 데이터타입을 명시할 경우
	//	  현재 클래스 내의 제네릭타입 (T) 부분이 지정된 데이터타입으로 대체됨
	// => 실제 인스턴스 생성 시점에서 어떠한 데이터타입으로도 바꿀 수 있다!
	T data;	

	public T getData() {
		return data;
	}

	public void setData(T data) {
		this.data = data;
	}
}





// 제네릭을 적용하지 않는 일반 클래스 정의
// 1) 사용할 데이터타입을 특정 타입으로 관리하는 일반 클래스
class NormalIntegerClass {
	int data;	// data 변수에는 정수형 데이터만 저장이 가능함

	public int getData() {
		return data;
	}

	public void setData(int data) {
		this.data = data;
	}
}

// 2) 사용할 데이터타입을 Object 타입으로 관리하는 일반 클래스
class NormalObjectClass {
	Object data;	// data 변수에는 모든 데이터타입 데이터저장 가능

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}
}








