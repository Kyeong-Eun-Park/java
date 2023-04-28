package collection;

import java.util.ArrayList;
import java.util.List;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 2. List 계열
		 * - 인덱스 번호를 사용하여 저장 순서가 유지됨
		 * - 데이터 중복 허용
		 * - 배열과 유사하나, 배열과 달리 저장 공간이 자동으로 확장됨
		 * - List 계열의 구현체 클래스 : ArrayList, Vector, LinkedList 등
		 * - 기본적인 메서드 대부분 Set 계열과 동일함 (= 부모가 동일하기 때문에)  
		 * 
		 * < ArrayList vs Vector >
		 * - 기본적인 구조가 동일하며, 메서드가 동일함
		 * - ArrayList 와 Vector 가 다른점은 Vector의 경우
		 *   멀티쓰레드 환경에서 안전하게 객체를 사용할 수 있다! (쓰레드는 나중에 배움)
		 *   => ArrayList는 멀티쓰레드 환경을 지원하지 않음
		 *   
		 * < ArrayList vs LinkedList >
		 * - 기본적인 구조가 완전 다르며, 메서드는 동일함
		 * - ArrayList는 배열 구조로써 인덱스를 활용하므로
		 *   데이터 탐색이나 "순차적인" 추가/삭제에 빠르다
		 * - LinkedList는 다음 데이터의 위치를 현재 데이터가 갖고 있는 형태이며
		 *   항상 시작점부터 순차적으로 다음 데이터를 추적해가는 형식의 구조
		 *   => 중간 데이터 추가/삭제는 빠르지만, 데이터 탐색이나 순차적인작업은 느림   
		 * */
		List list = new ArrayList();
		
		list.add("ONE");
		list.add(2);
		list.add(3.14);
		
		System.out.println("list 객체가 비어있는가? " + list.isEmpty());
		System.out.println("list 객체에 저장된 요소의 갯수는? " + list.size());
		System.out.println("list 객체에 모든 요소 출력: " + list);
		
		System.out.println("중복 데이터 3.14 추가 가능한가? " + list.add(3.14));
		
		System.out.println("list 객체가 비어있는가? " + list.isEmpty());
		System.out.println("list 객체에 저장된 요소의 갯수는? " + list.size());
		System.out.println("list 객체에 모든 요소 출력: " + list);
		
		// add(int index, Object e)
		list.add(2, 3); // 기존 2번 인덱스의 데이터를 밀어내고 정수 3을 2번 인덱스에 삽입
		System.out.println("list 객체에 모든 요소 출력: " + list);
		System.out.println("--------------------------------------");
		
		System.out.println("3번 인덱스 요소: " + list.get(3));
//		System.out.println("5번 인덱스 요소: " + list.get(5)); // 오류 발생!
		
		// List 객체의 모든 요소 꺼내기
		// 일반 for문 사용하여 List 객체의 get() 메서드로 인덱스를 통해 접근
		// => 특정 인덱스 범위 반복이 가능하다는 장점이 있음
//		for(int i = 0; i < list.size(); i++) {
//			System.out.println(list.get(i));
//		}
		
//		for(Object o : list) {
//			System.out.println(o);
//		}
		System.out.println("---------------------------------------------");
//		System.out.println("인덱스를 사용하여 정수2 (인덱스1) 삭제: " + list.remove(1));
//		System.out.println("정수 2를 지정하여 해당 요소 직접 삭제: " + list.remove(2));
//		System.out.println("정수 2를 지정하여 해당 요소 직접 삭제: " + list.remove("2"));
		System.out.println("정수 2를 지정하여 해당 요소 직접 삭제: " + list.remove((Object)2));
		// => 정수2를 지정하는 것이 아닌 2번 인덱스 지정으로 취급됨
		//    따라서, 정수2를 지정하여 삭제해야하는 경우 Object 타입으로 형변환 필요!
		System.out.println("list 객체에 모든 요소 출력: " + list);
		
		
		
		
	}

}
