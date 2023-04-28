package lambda;

import java.util.ArrayList;
import java.util.List;

public class Test4 {

	public static void main(String[] args) {

		Customer customer1 = new Customer("홍길동", 40, 100);
		Customer customer2 = new Customer("이순신", 50, 200);
		Customer customer3 = new Customer("강감찬", 35, 20);
		Customer customer4 = new Customer("차무식", 20, 30);
		Customer customer5 = new Customer("최민식", 25, 50);
		
		List<Customer> list = new ArrayList<Customer>();
		
		list.add(customer1);
		list.add(customer2);
		list.add(customer3);
		list.add(customer4);
		list.add(customer5);
		
		System.out.println("===== 고객 명단(이름만) 추가된 순서대로 출력 =====");
//		list.stream().forEach(c -> System.out.println(c.getName()));
		list.stream().map(c -> c.getName())
					 .forEach(s -> System.out.println(s));
		
		System.out.println("===== 총 여행비용 출력 =====");
		int total = list.stream().mapToInt(c -> c.getPrice()).sum();
		System.out.println("총 여행 비용 : " + total);
		
		System.out.println("===== 30세 이상 고객 중 여행비용이 큰순으로 출력 =====");
		list.stream().filter(c -> c.getAge() >= 30)
					 .sorted((c1, c2) -> c2.getPrice() - c1.getPrice())
					 .forEach(c -> System.out.println(c));
		
		System.out.println("===== 가장 어린 사람 출력 =====");
		Customer customer = list.stream()
							   .min((c1, c2) -> c1.getAge() - c2.getAge())
							   .get();
		System.out.println(customer);
		
		System.out.println("===== 가장 비용이 적은 사람 출력 =====");
		customer = list.stream()
					   .min((c1, c2) -> c1.getPrice() - c2.getPrice())
					   .get();
		System.out.println(customer);
	}

}

class Customer {
	private String name;
	private int age;
	private int price;
	
	public Customer(String name, int age, int price) {
		this.name = name;
		this.age = age;
		this.price = price;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public int getPrice() {
		return price;
	}

	@Override
	public String toString() {
		return "Customer [name=" + name + ", age=" + age + ", price=" + price + "]";
	}
	
}
