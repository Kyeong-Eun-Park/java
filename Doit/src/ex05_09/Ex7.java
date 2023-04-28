package ex05_09;

import java.util.ArrayList;

public class Ex7 {

	public static void main(String[] args) {
		// 230p
		
		// Q1) 정답: 같은
		// 배열은 XXX 자료형을 순서대로 관리할 때 사용하는 자료 구조 입니다.
		
		// Q3)
		// 배열의 길이가 5인 정수형 배열을 선언하고,
		// 1 ~ 10 중 짝수만을 배열에 저장한 후 그 합을 출력하세요.
		
		int[] arr = new int[5];
		
		int index = 0;
		for(int i = 1; i <= 10; i++) {
			if(i % 2 == 0) {
				arr[index] = i;
				index++;
			}
		}
		
		int sum = 0;
		for(int num : arr) {
			sum += num;
		}
		System.out.println(sum);
		System.out.println("------------------------------");
		
//		int[] arr1 = {10, 20, 30, 40};
//		Dog[] dogs = {new Dog("뽀삐", "시추"), new Dog("뽀삐", "시추")};
		
		Dog[] dogs = new Dog[5];
		dogs[0] = new Dog("뽀삐", "시추");
		dogs[1] = new Dog("배추", "푸들");
		dogs[2] = new Dog("토토", "말티즈");
		dogs[3] = new Dog("누렁이", "진돗개");
		dogs[4] = new Dog("똥강아지", "잡종");
		
		for(int i = 0; i < dogs.length; i++) {
			Dog dog = dogs[i];
			System.out.println(dog.showDogInfo());
//			System.out.println("뽀삐, 시추");
		}
		
		for(Dog dog : dogs) {
			System.out.println(dog.showDogInfo());
		}
		
		// Q5)
		// ArrayList를 활용하여 위로직을 구현
		ArrayList<Dog> dogList = new ArrayList<Dog>();
		dogList.add(dogs[0]);
		dogList.add(dogs[1]);
		dogList.add(dogs[2]);
		dogList.add(dogs[3]);
		dogList.add(dogs[4]);
		
		for(int i = 0; i < dogList.size(); i++) {
			Dog dog = dogList.get(i);
			System.out.println(dog.showDogInfo());
		}
		
		for(Dog dog : dogList) {
			System.out.println(dog.showDogInfo());
		}
		
		String str = new String("아무개");
		String str2 = "아무개";
	}

}

// Q4)
// 다음과 같이 Dog 클래스가 있습니다.
// 배열 길이가 5인 Dog[] 배열을 만든 후 Dog 인스턴스를 5개 생성하여
// 배열에 추가합니다. for문과 향상된 for문에서 Dog 클래스의
// showDogInfo() 메서드를 사용하여 배열에 추가한 Dog 정보를 모두 출력하세요.
class Dog {
	private String name;
	private String type;
	
	public Dog(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
	public String showDogInfo() {
		return name + ", " + type;
	}
}






