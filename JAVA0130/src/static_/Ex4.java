package static_;

public class Ex4 {

	public static void main(String[] args) {
		/*
		 * 싱글톤 (singleton)
		 * - 애플리케이션이 시작될때 어떤 클래스가 최초 한번만 메모리를 할당하고
		 *   그 메모리에 인스턴스를 만들어 사용하는 디자인 패턴
		 * - 일반적으로 java에서는 생성자를 private로 선언해서 생성 불가능하게 하고 
		 *   getInstance() 메서드 작성해서 객체를 받도록 구현 
		 * */
		Car c1 = Car.getInstance();
		Car c2 = Car.getInstance();
		System.out.println(c1 == c2);
		
	}
}

class Car {
	// 3. getInstance() 메서드를 호출할때마다 new Car()로 객체를 생성하게되면
	//    결국 Car 객체가 여러개일 수 있으므로 Car 타입 변수 car를 선언
	///   => 이때, getInstance() 메서드에서 car변수를 리턴해야 하는데
	//       getInstance() 메서드가 static 이므로 인스턴스 멤버변수는 접근 불가!
	//       따라서, car 변수도 static 으로 선언하고 외부에서 조작할수 없도록 private 처리
	private static Car car;
	// 1. 외부에서 객체를 생성할 수 없도록 생성자 private 처리
	private Car() {}	
	// 2. Car 객체를 리턴할 getInstance() 메서드를 선언
	//    => 이때, Car 객체를 리턴하므로 리턴타입은 Car
	//		 일반메서드는 참조변수로 호출가능한데 외부에서 new Car() 할 방법이 없기때문에
	//       static 메서드로 선언하여 클래스명.getInstance() 로 호출할 수 있도록함
	static Car getInstance(){
		if(car == null) {
			car = new Car();
		}
		return car;
	}
}







