package generic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 제네릭 (Generic, 일반화)
		 * - 객체에서 사용할 데이터타입을 클래스 정의 시 미리 명시하지 않고
		 *   실제 객체 생성 시 데이터타입을 지정하여 사용하도록 하는 기법
		 * 	 => 객체를 생성할 때마다 각각 다른 데이터타입으로 사용 가능함
		 * 	 => 데이터타입을 지정 시 반드시 참조데이터타입만 지정 가능함(기본형 사용 불가)
		 * 		ex) <int> (X) -> <Integer> (O)
		 * - 데이터를 저장하는 시점에서 미리 저장 데이터에 대한 타입을 판별 가능하므로
		 * 	 데이터 저장시점에서 안정성을 향상시키고,
		 * 	 데이터를 꺼내는 시점에서 저장된 데이터타입만 저장된다는 보장이 생기므로
		 *   별도의 판별이나 형변환 없이 해당 타입 그대로 사용 가능하게 된다!
		 * - 주로, Collection API 들은 대부분 제네릭 타입으로 클래스가 설계되어 있음
		 * - 만약, 제네릭 타입 지정을 생략하는 경우 모든 데이터타입은 Object로 고정됨   
		 * */
		
		List list = new ArrayList();
		
		// 데이터를 추가하는 시점에서는 매우 편리함
		list.add(1);
		list.add("TWO");
		list.add(3.14);
		
		for(int i = 0; i < list.size(); i++) {
//			int data = list.get(i);
//			int data = (int)list.get(i);
			// => 첫번째 데이터는 정수이므로 int형으로 변환 가능하지만,
			//    두번째 데이터는 문자열이므로 int형으로 변환이 불가능함
			
			Object data = list.get(i);
//			System.out.println(data);
			
			if(data instanceof Integer) {
				int iData = (int)data;
				System.out.println(iData);
				
			} else if(data instanceof String) {
				String strData = (String)data;
				System.out.println(strData);
				
			} else if(data instanceof Double) {
				double dData = (double)data;
				System.out.println(dData);
				
			}
			
			// => Object 타입을 사용하여 데이터를 저장하는 경우
			//    저장시점에서는 데이터 타입 구분이 필요없으므로 편리하지만
			//    실제 데이터를 사용하는 시점에서는 데이터타입이 달라서 문제가 발생!
			// => 또한, 각 데이터타입 변수에 저장할 때는 추가적으로 형변환이 필요함
			
		}
		
		// 제네릭 타입으로 정수를 사용하기 위해 Integer 타입을 지정 (int X)
		List<Integer> list2 = new ArrayList<Integer>();
		
		list2.add(1);
//		list2.add("TWO"); // 컴파일 에러 발생!
//		list2.add(3.14); // 컴파일 에러 발생!
		list2.add(2);
		list2.add(3);
		
//		for(int i = 0; i < list2.size(); i++) {
//			// 반복문 등을 통해 데이터를 꺼낼때
//			// 제네릭 타입으로 리턴되므로 별도의 형변환이나 데이터타입 검사가 불필요함!
//			// => instanceof, (int) 불필요!
//			int data = list2.get(i); // 오토언박싱
//			System.out.println(data);
//		}
		
//		for(int o : list) {}	// 불가능
//		for(Object o : list) {}
		for(int data : list2) {
			System.out.println(data);
		}
		
		System.out.println("-----------------------------");
		
		// Map 계열 객체 생성 시 제네릭 타입 지정은 Key, Value 순으로 지정
		Map<Integer, String> map = new HashMap<>();
		// => Key는 정수, Value는 문자열만 사용 가능함
		map.put(1, "홍길동");
//		map.put(2, 10);	// 컴파일 에러 발생! int, String 순으로 전달해야함!
		
		Map<Integer, StudentDTO> map2 = new HashMap<>();
		map2.put(1, new StudentDTO());
		map2.put(2, new StudentDTO());
	}

}

class StudentDTO {
	private String name;
	private int age;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}





