package ex10_14;

import java.util.ArrayList;
import java.util.List;

public class Ex13 {

	public static void main(String[] args) {
		// 484p
		
		// Q1) 정답: final
		// 지역 내부 클래스에서 외부 클래스 메서드의 지역변수를 사용할 수는 있지만
		// 그 값을 변경하면 오류가 발생합니다. 
		// 이때 사용하는 지역변수는 XXX 변수가 되기 때문입니다.
		
		// Q2) 정답: 익명 내부 클래스
		// 내부 클래스 중 클래스 이름 없이 인터페이스나 추상 클래스 자료형에
		// 직접 대입하여 생성하는 클래스를 XXX 라고 합니다.
		
		// Q3) 정답: 람다식
		// 자바에서 제공하는 함수형 프로그래밍 방식으로
		// 인터페이스의 메서드를 직접 구현하는 코드를 XXX 이라고 합니다.
		
		// Q4) 정답: 함수형 인터페이스
		// 람다식으로 구현할 수 있는 인터페이스는 메서드를 하나만 가져야 합니다.
		// 이러한 인터페이스를 XXX 라고 합니다.
		
		// Q5)
		// 다음과 같이 두 정수를 매개변수로 하는 메서드가 인터페이스에 정의되어 있습니다.
		// 두 정수의 합을 반환하는 람다식을 구현하고 호출해 보세요.
		Calc cal = new Calc() {
			
			@Override
			public int add(int num1, int num2) {
				return 0;
			}
		};
		
		Calc cal2 = (num1, num2) -> num1 + num2;
		System.out.println(cal2.add(10, 20)); 
		
		// Q6) 정답: 스트림
		// 자바에서 자료 처리를 추상화하여 여러 자료형의 자료를
		// 동일하게 처리할 수 있도록 제공하는 클래스를 XXX 이라고 합니다.
		
		// Q7)
		List<Book> bookList = new ArrayList<Book>();
		bookList.add(new Book("자바", 25000));
		bookList.add(new Book("파이썬", 15000));
		bookList.add(new Book("안드로이드", 30000));
		bookList.add(new Book("자바스크립트", 18000));
		bookList.add(new Book("JSP", 28000));
		bookList.add(new Book("Spring", 34000));
		
		// 스트림을 생성하고 출력하기
		// 1. 모든 책의 가격의 합
		int sum = bookList.stream()
						  .mapToInt(b -> b.getPrice())
						  .sum();
		
		System.out.println(sum);
		
		// 2. 책의 가격이 20000원 이상인 책중 가격이 저렴한 순으로 출력
		bookList.stream().filter(b -> b.getPrice() >= 20000)
						 .sorted((b1, b2) -> b1.getPrice() - b2.getPrice())
						 .forEach(b -> System.out.println(b));
		
		
	}
}

class Book {
	private String name;
	private int price;
	
	public Book(String name, int price) {
		this.name = name;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return name + ": " + price;
	}
	
	
}

interface Calc {
	public int add(int num1, int num2);
}




