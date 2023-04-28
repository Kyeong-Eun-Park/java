package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Ex1 {

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
		
		System.out.println("3번 인덱스 요소를 문자 '4'로 교체 : " + list.set(3, '4'));
		System.out.println("list 객체에 모든 요소 출력: " + list);
		
		List subList = list.subList(1, 3);
		System.out.println("1번 인덱스부터 3번인덱스보다 작은 부분 리스트 추출: " + subList);
		
		System.out.println("-----------------------------------------");
		Object[] arr = list.toArray();
		for(Object o : arr) {
			System.out.println(o);
		}
		System.out.println("-----------------------------------------");
		
		list.add(3);
		System.out.println("list 객체에 모든 요소 출력: " + list);
		
		// 첫인덱스부터 탐색
		System.out.println("3이라는 요소의 인덱스 번호: " + list.indexOf(3));
		// 끝 인덱스부터 탐색
		System.out.println("3이라는 요소의 인덱스 번호: " + list.lastIndexOf(3));
		// 존재하지 않는 요소 지정할 경우 인덱스 번호 -1 리턴 (데이터 없음)
		System.out.println("10이라는 요소의 인덱스 번호: " + list.indexOf(10));
		
		System.out.println("실수 3.14가 존재하는가? " + list.contains(3.14));
		System.out.println("실수 5.0가 존재하는가? " + list.contains(5.0));
		
		System.out.println("=======================================");
		
		List list2 = new ArrayList(list);
		System.out.println("list2 객체에 모든 요소 출력 : " + list2);
		System.out.println("list와 list2 객체는 동일한 객체인가? " + (list == list2));
		System.out.println("list와 list2 객체는 요소가 동일한 객체인가? " + list.equals(list2));
		
		System.out.println("=======================================");
		// Arrays 클래스 asList() 메서드 호출하여 데이터를 연속적으로 전달하면
		// 해당 데이터들을 List 타입 객체로 변환해준다.
		List arrayList = Arrays.asList(1, 2, 3, 4, 5);
		System.out.println(arrayList);
		
		// 주의! 기본 데이터타입 배열 자체를 asList() 메서드 파라미터로 전달하면
		// 정상적인 변환 불가능(asList() 메서드 파라미터로 클래스타입 배열을 전달해야한다!)
		// => 오류는 발생하지 않으나 배열 데이터를 정상적으로 전달 불가능
//		int[] iArr = {1, 2, 3, 4, 5};
//		List arrayList2 = Arrays.asList(iArr);
//		System.out.println(arrayList2);
//		
//		for(Object o : arrayList2) {
//			System.out.println(o);
//		}
		
		// -> int 타입 대신 클래스타입인 Integer 사용할 경우 사용 가능
		Integer[] iArr = {1, 2, 3, 4, 5};
		List arrayList2 = Arrays.asList(iArr);
		System.out.println(arrayList2);
		
		String[] strArr = {"1", "2", "3"};
		List arrayList3 = Arrays.asList(strArr);
		System.out.println(arrayList3);
		
		System.out.println("=================================");
		
		// list3 객체 생성하고, 정수 3, 4, 1, 6, 5, 2 추가
		List list3 = new ArrayList();
		list3.add(3);
		list3.add(4);
		list3.add(1);
		list3.add(6);
		list3.add(5);
		list3.add(2);
		System.out.println("정렬 전: " + list3);
		
		// Collections 클래스의 static 메서드 sort() 사용 시 List 객체 정렬 가능
		Collections.sort(list3);
		System.out.println("정렬 후: " + list3);
		
		// Collections 클래스의 static 메서드 shuffle() 사용 시 List 객체 뒤섞기 가능
		Collections.shuffle(list3);
		System.out.println("셔플 후: " + list3);
		
		// ------------------------------------------------------------------
		// 참고! TreeSet 객체에 저장된 요소를 List 객체로 변환하여 shuffle 하거나
		// HashSet 객체에 저장된 요소를 List 객체로 변환하여 sort 가능
//		Set set = new HashSet();
//		set.add(1); set.add(20); set.add(3); set.add(450); set.add(55);
//		System.out.println(set);
		
		// Set 객체 생성 시 Arrays.asList() 메서드를 통해 List 객체를 생성한 후
		// 해당 객체를 Set 객체 생성자 파라미터로 전달해도 된다!
		// (Set <--> List 상호 변환 가능)
		Set set = new HashSet(Arrays.asList(1, 20, 3, 450, 55, 3));
		System.out.println("Set 객체: " + set);
		
		List list4 = new ArrayList(set);
		System.out.println("List 객체: " + list4);
		Collections.sort(list4);
		System.out.println("List 객체 정렬 후: " + list4);
		
		// --------------------------------------------------------------
		// 중복제거 (순서유지)
		Set set2 = new HashSet(
			Arrays.asList("ABCD", "A", "ABCD", "AB", "A", "AB", "ABC"));
		List list5 = new ArrayList(set2);
		System.out.println(list5);
		
		Set set3 = new LinkedHashSet(
			Arrays.asList("ABCD", "A", "ABCD", "AB", "A", "AB", "ABC"));
		List list6 = new ArrayList(set3);
		System.out.println(list6);
		
		
		
	}

}
