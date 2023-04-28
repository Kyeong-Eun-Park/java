package ex05_09;

public class Ex6 {

	public static void main(String[] args) {
		// 197p
		
		// Q1) 정답: this
		// 클래스 내부에서 자신의 주소를 가리키는 예약어는 XXX 라고 합니다.
		
		// Q2) 정답: this()
		// 클래스에 여러 생성자가 오버로드되어 있을 경우에
		// 하나의 생성자에서 다른 생성자를 호출할 때 XXX를 사용하니다.
		
		// Q3) 정답: 클래스 변수 (정적 변수)
		// 클래스 내부에 선언하는 static 변수는 생성되는 인스턴스마다 만들어지는 것이 아닌
		// 여러 인스턴스가 공유하는 변수입니다. 따라서 클래스에 기반한 유일한 변수라는 의미로
		// XXX 라고도 합니다.
		
		// Q4) 정답: 스택, 데이터 영역
		// 지역 변수는 함수나 메서드 내부에서만 사용할 수 있고 XXX 메모리에 생성됩니다.
		// 멤버변수중 static 예약어를 사용하는 변수는 static XXX 메로리에 생성됩니다.
		
		// Q5)
		// 아침 출근길에 김 씨는 4000원을 내고 별다방에서 아메리카노를 사 마셨습니다.
		// 이 씨는 콩다방에서 4500원을 내고 라떼를 사 마셨습니다.
		// 이 과정을 객체지향으로 프로그래밍해보세요.
		Customer 김씨 = new Customer("김", 100000);
		Customer 이씨 = new Customer("이", 50000);
		
		CoffeeShop 커피빈 = new CoffeeShop("커피빈", 0);
		CoffeeShop 스벅 = new CoffeeShop("스벅", 0);
		
		System.out.println("----- 커피 구매 전 -----");
		
		김씨.showInfo();
		이씨.showInfo();
		
		커피빈.showInfo();
		스벅.showInfo();
		
		System.out.println("----- 커피 구매 -----");
		
		김씨.buyCoffee("아메리카노", 4000, 스벅);
		이씨.buyCoffee("라떼", 4500, 커피빈);
		
		System.out.println("----- 커피 구매 후 -----");
		
		김씨.showInfo();
		이씨.showInfo();
		
		커피빈.showInfo();
		스벅.showInfo();
		
		System.out.println("김씨 커피: " + 김씨.coffee.kind);
		System.out.println("이씨 커피: " + 이씨.coffee.kind);
		
		System.out.println("----- 커피 구매 -----");
		김씨.coffee = null;
		김씨.buyCoffee("아인슈패너", 50000, 커피빈);
		
		System.out.println("----- 커피 구매 후 -----");
		
		김씨.showInfo();
		System.out.println("김씨 커피: " + 김씨.coffee.kind);
		
	}

}

class Coffee {
	String kind;	// 커피 종류
	int price;		// 커피 가격
	
	public Coffee(String kind, int price) {
		this.kind = kind;
		this.price = price;
	}
}

class CoffeeShop {
	String name;// 가게이름
	int money;	// 매출
	
	public CoffeeShop(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
	// 커피 판매 기능
	public Coffee sellCoffee(String kind, int price) {
		this.money += price;
		return new Coffee(kind, price);
	}
	
	public void showInfo() {
		System.out.println("가게 이름: " + name);
		System.out.println("오늘 매출: " + money);
	}
}

class Customer {
	String name;
	int money;
	Coffee coffee;
	
	public Customer(String name, int money) {
		this.name = name;
		this.money = money;
	}
	
	public void buyCoffee(String kind, int price, CoffeeShop coffeeShop) {
		this.money -= price;
		this.coffee = coffeeShop.sellCoffee(kind, price);
		// 김 씨는 4000원을 내고 별다방에서 아메리카노를 사 마셨습니다.
		System.out.println(name + " 씨는 " + price + "원을 내고 " + coffeeShop.name
				+ "에서 " + kind + "를 사 마셨습니다.");
	}
	
	public void showInfo() {
		System.out.println("이름: " + name);
		System.out.println("돈: " + money);
		System.out.println("커피: " + coffee);
	}
	
}








