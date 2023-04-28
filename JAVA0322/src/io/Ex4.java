package io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Ex4 {

	public static void main(String[] args) {
		/*
		 * 객체 직렬화(Serialization) & 역직렬화(Deserialization)
		 * 
		 * - 자바에서 사용하는 객체에 영속성을 부여하여
		 *   파일 또는 네트워크 등으로 내보내는 것을 직렬화라고 하며
		 *   반대로 파일이나 네트워크로 부터 데이터를 읽어 객체로 
		 *   변환하는 것을 역직렬화라고 함
		 * - ObjectInputStream, ObjectOutputStream 클래스 사용
		 * - 주의! 직렬화 대상이 되는 클래스를 정의할 때는
		 *   반드시 Serializable 인터페이스 상속 필수!
		 * - 만약, 직렬화 클래스 내에서 출력 대상으로부터 제외시킬 변수가 있을 경우
		 *   해당 변수 선언부 앞에 transient 키워드를 사용하면 출력대상에서 제외됨    
		 * */
		
		// Person 객체 생성
		Person p = new Person("홍길동", 20, "901010-1234567");
		
		// File경로 관리를 위한 File 객체 생성
		File f = new File("C:\\temp\\person.txt");
		
		// Person 객체를 외부 파일로 출력하기 (= 직렬화, Serialization)
		try (ObjectOutputStream oos = new ObjectOutputStream(
				new FileOutputStream(f))){
			
			oos.writeObject(p);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.out.println("객체 출력 완료!");
		
		System.out.println("======================================");
		
		// 외부 폴더(C드라이브 - temp - person.txt)에 저장되어 있는 파일 내의
		// Person 객체를 ObjectInputStream 객체를 사용하여 읽어오기
		// => 역직렬화(Deserialization)
		try (ObjectInputStream ois = new ObjectInputStream(
				new FileInputStream(f))){
			
			// ObjectInputStream 객체의 readObject() 메서드를 호출하여
			// 파일에 저장된 객체를 Object 타입으로 읽어오기
//			Person person = (Person)ois.readObject();
			
//			Person person = null;
//			System.out.println(person);
			
			Object o = ois.readObject();
			if(o instanceof Person) {
				Person person = (Person)o;
				System.out.println(person);
			}
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		
		
		
		
	}
}

// 직렬화를 위한 Person 클래스 정의
// => 주의! 직렬화 대상이되는 클래스를 정의할 때 반드시 Serialization 인터페이스 상속 필수!
// 별도의 추상메서드가 없는 단순한 마커(Marker) 용도의 인터페이스
class Person implements Serializable {
	String name;
	int age;
	transient String jumin;
	
	public Person(String name, int age, String jumin) {
		this.name = name;
		this.age = age;
		this.jumin = jumin;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", jumin=" + jumin + "]";
	}
}









