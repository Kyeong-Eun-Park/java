package _class;

public class Ex3 {

	public static void main(String[] args) {
		Hero 뽀삐 = new Hero();
		뽀삐.demage = 50;
		뽀삐.hp = 500;
		
		Hero 가렌 = new Hero();
		가렌.demage = 100;
		가렌.hp = 600;
		
		// 뽀삐가 가렌을 attack
		뽀삐.attack(가렌);
		가렌.showInfo();
		
		// 가렌이 뽀삐를 attack
		가렌.attack(뽀삐);
		뽀삐.showInfo();
		
		System.out.println("-----------------------");
		캐릭터 c1 = new 캐릭터();
		Bubble b1 = c1.spaceBar();
		Bubble b2 = c1.spaceBar();
		System.out.println(b1);
		System.out.println(b2);
	}
}

class Bubble {}
class 캐릭터 {
//	Bubble b1 = new Bubble();
	public Bubble spaceBar() {
		return new Bubble();
//		return b1;
	}
}

class Hero {
	int demage;
	int hp;
	
//	Hero(){} // 생성자
	
	public void showInfo() {
		System.out.println("데미지: " + demage);
		System.out.println("hp: " + hp);
	}
	
	public void attack(Hero other) {
		other.hp -= demage;
	}
	
}
