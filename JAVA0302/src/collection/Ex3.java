package collection;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Ex3 {

	public static void main(String[] args) {
		/*
		 * 3. Map 계열
		 * - 데이터 키(Key)와 값(Value) 한쌍의 형태로 관리하는 자료구조 (해쉬테이블 구조)
		 * - 키는 중복이 불가능하며, 값은 중복이 가능함
		 *   => 키 관리 객체 : Set (중복 제거에 효과적)
		 * - 구현체 클래스 : HashMap, Properties 등  
		 * */
		Map map = new HashMap();
		
		map.put(1, "Java");
		map.put(2, "JSP");
		map.put(3, "Android");
		
		System.out.println("map 객체의 모든 키와 값 출력 : " + map);
		
		// 중복되는 키를 사용하여 다른 값을 저장하는 경우
//		map.put(3, "Oracle");
		// => 기존에 3번키가 존재하므로 "Android" 값을 제거하고, "Oracle" 값 저장(덮어쓰기)
		//    이때, 제거되는 값 "Android" 가 Object 타입으로 리턴됨
		System.out.println("3번 키에 Oracle 문자열 저장 : " + map.put(3, "Oracle"));
		System.out.println("map 객체의 모든 키와 값 출력 : " + map);
		
		// 새로운 키에 중복된 값을 저장하는 경우
		map.put(4, "JSP");
		System.out.println("map 객체의 모든 키와 값 출력 : " + map);
		
		System.out.println("정수 2에 해당하는 키의 데이터 : " + map.get(2));
		System.out.println("정수 6에 해당하는 키의 데이터 : " + map.get(6));
		
		// Set keySet() : Map 객체 내의 모든 키 리턴
		// => Set 타입 변수에 저장하거나 Set 타입 객체 형태로 직접 사용 가능
		Set keySet = map.keySet();
		System.out.println("map 객체 내의 모든 키 : " + keySet);
		
		// Collection values() : Map 객체 내의 모든 값 리턴
		// => Set 타입 또는 List 타입 등의 변수에 할당 불가능(다운캐스팅도 불가능!)
		System.out.println("map 객체 내의 모든 값 : " + map.values());
		
//		Set values = (Set)map.values();
//		List values = (List)map.values();
		
		// Set 또는 List 계열 객체 생성 시 파라미터로 전달하여 객체 변환 가능
//		Set values = new HashSet(map.values());
		// => 만약, 중복된 값이 존재할 경우 Set 타입으로 관리하면 중복이 제거되므로 주의!
		List values = new ArrayList(map.values());
		System.out.println("map 객체 내의 모든 값: " + values);
		
		// Set entrySet() : 키와 값을 한쌍으로 갖는 Map.Entry 객체의 모임
		// => 키와 값의 한쌍이 다른 키와 값의 한쌍과 중복될 수 없으므로 Set 타입으로 관리됨
		Set entrySet = map.entrySet();
		System.out.println(entrySet);
		
		System.out.println("map 객체가 비어있는가? " + map.isEmpty());
		System.out.println("map 객체에 저장된 요소 갯수 : " + map.size());
		
		// 요소를 제거하는 remove() 메서드는 2가지로 제공됨
		// Object remove(Object key) : key에 해당하는 요소 제거
		System.out.println("4번 key에 해당하는 요소 제거 : " + map.remove(4));
		System.out.println("map 객체의 모든 키와 값 출력: " + map);
		// 만약, 존재하지 않는 키를 지정할 경우 null 값 리턴됨
		System.out.println("4번 key에 해당하는 요소 제거 : " + map.remove(4));
		
		// boolean remove(Object key, Object value) : key와 value 모두 일치하는 요소 제거
 		System.out.println("3번 key의 Oracle 값에 해당하는 요소 제거: " + map.remove(3, "Oracle"));
 		System.out.println("map 객체의 모든 키와 값 출력: " + map);
		
 		// 만약, 키와 값이 일치하지 않거나 존재하지 않는 키를 지정할 경우 false 리턴됨
 		System.out.println("3번 key의 Oracle 값에 해당하는 요소 제거: " + map.remove(3, "Oracle"));
		System.out.println("2번 key의 JAVA값에 해당하는 요소 제거: " + map.remove(2, "JAVA"));
		
		System.out.println("===========================================");
		
		/*
		 * HashMap 객체 (map2) 생성 후 다음 요소 추가
		 * 		KEY			VALUE
		 * "010-1234-5678"	"홍길동"
		 * "010-2222-3333"	"이순신"
		 * "010-4444-5555"	"강감찬"
		 * */
		Map map2 = new HashMap();
		map2.put("010-1234-5678", "홍길동");
		map2.put("010-2222-3333", "이순신");
		map2.put("010-4444-5555", "강감찬");
		System.out.println(map2);
		
		System.out.println("==================================");
		// => map2에 데이터 추가후 모든 요소에 접근하여 
		//    "이름: XXX, 전화번호: XXX" 출력!
		
		// Map 객체 반복하는 방법
		// 1. Iterator 사용 시
		// => Map 객체의 keySet() 메서드를 호출하여 모든 키를 꺼낸 다음
		//    해당 Key 가 저장된 Set 객체의 iterator() 메서드를 호출하여
		//    Iterator 객체 리턴받아 사용
		Set keySet2 = map2.keySet(); // 010-1234-5678, 010-2222-3333...
		Iterator iterator = keySet2.iterator();
		
		while(iterator.hasNext()) { // 다음 요소(키)가 존재할 동안 반복
			// 1) 키 꺼내기 위해서는 next() 메서드로 반복자의 키 하나씩 접근
			// => 이때, next() 메서드 리턴타입이 Object 이므로 상황에 따라 형변환 필요!
			String phone = iterator.next().toString(); // 010-1234-5678
			
			// 2) 값 꺼내기 위해서는 키를 사용하여 get() 메서드를 통해 값에 접근
			// => 이때, get() 메서드 리턴타입이 Object 이므로 상황에 따라 형변환 필요!
			String name = map2.get(phone).toString();
			
			System.out.println("이름: " + name + ", 전화번호 : " + phone);
		}
		
		System.out.println("-------------------------------------");
		
		// Key를 사용하여 반복하지 않고, Map.Entry 객체를 통한 반복
		Set entrySet2 = map2.entrySet();
		Iterator entryIterator = entrySet2.iterator();
		
		while(entryIterator.hasNext()) {
			Map.Entry entry = (Entry)entryIterator.next();
			String phone = entry.getKey().toString();
			String name = entry.getValue().toString();
			
			System.out.println("이름: " + name + ", 전화번호 : " + phone);
		}
		
		System.out.println("-------------------------------------");
		
		// 2. 향상된 for문 사용하여 접근
//		Set keySet3 = map2.keySet();
		for(Object phone : map2.keySet()) { // 010-1234-5678 ...
			String name = map2.get(phone).toString();
			System.out.println("이름: " + name + ", 전화번호 : " + phone);
		}
		
		System.out.println("-------------------------------------");
		// 2-1. 향상된 for문 (Map.Entry)
		Map<String, String> map3 = new HashMap(map2);
//		Set<Map.Entry<String, String>> entrySet3 = map3.entrySet();
		for(Map.Entry<String, String> entry : map3.entrySet()) {
			System.out.println("이름: " + entry.getValue() + ", 전화번호: " + entry.getKey());
		}
		System.out.println("-------------------------------------");
		
		// boolean containsKey(Object key) : 해당 key의 존재 여부 리턴
		System.out.println("010-1234-5678 키가 존재하는가? " + 
								map2.containsKey("010-1234-5678"));
		System.out.println("010-1234-9999 키가 존재하는가? " + 
								map2.containsKey("010-1234-9999"));
		
		// boolean containsValue(Object value) : 해당 value의 존재 여부 리턴
		System.out.println("홍길동 이름(값)이 존재하는가? " + map2.containsValue("홍길동"));
		System.out.println("김태희 이름(값)이 존재하는가? " + map2.containsValue("김태희"));
		
		// void clear() : 모든 키와 값을 초기화
		map2.clear();
		System.out.println(map2);
		
		System.out.println("============================");
		
//		10	Administration	200	1700
		List list = new ArrayList();
		Departments dto = new Departments();
		dto.setDepartment_id("10");
		dto.setDepartment_name("Administration");
		dto.setManager_id("200");
		dto.setLocation_id("1700");
		list.add(dto);
		System.out.println(dto);
		
		System.out.println("============================");
		
		Map<String, String> dto2 = new HashMap();
		dto2.put("department_id", "10");
		dto2.put("department_name", "Administration");
		dto2.put("manager_id", "200");
		dto2.put("location_id", "1700");
		System.out.println(dto2);
		
		
	}

}

class Departments {
	
	private String department_id;	
	private String department_name;
	private String manager_id;
	private String location_id;
	
	public String getDepartment_id() {
		return department_id;
	}
	public void setDepartment_id(String department_id) {
		this.department_id = department_id;
	}
	public String getDepartment_name() {
		return department_name;
	}
	public void setDepartment_name(String department_name) {
		this.department_name = department_name;
	}
	public String getManager_id() {
		return manager_id;
	}
	public void setManager_id(String manager_id) {
		this.manager_id = manager_id;
	}
	public String getLocation_id() {
		return location_id;
	}
	public void setLocation_id(String location_id) {
		this.location_id = location_id;
	}
	@Override
	public String toString() {
		return "Departments [department_id=" + department_id + ", department_name=" + department_name + ", manager_id="
				+ manager_id + ", location_id=" + location_id + "]";
	}
	
	
}



