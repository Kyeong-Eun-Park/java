package polymorphism;

public class Test3 {

	public static void main(String[] args) {
		
		Hero h = new Hero();
		h.setSword(new Sword(100, 1, 5));
		h.attack();
		
		h.setBow(new Bow(200, 10, 10));
		h.attack();
		
		System.out.println("--------------------------");
		// 상속관계로 설계한 후 다형성을 적용한 PolyHero 객체 생성
		PolyHero p = new PolyHero();
		p.setWeapon(new Sword(100, 1, 5));
		p.attack();
		
		p.setWeapon(new Bow(200, 10, 10));
		p.attack();
		
		p.setWeapon(new Gun(5000, 20, 50));
		p.attack();
	}
}

class Hero {
	// 다형성을 적용하지 않았을 경우 (멤버변수)
	Sword sword;
	Bow bow;
	
	// 무기를 장착하기 위해서 각각의 set 메서드
	public void setSword(Sword sword) {
		this.sword = sword;
		this.bow = null;	// 기존에 장착되어 있는 무기를 해제하는 작업도 필요
	}

	public void setBow(Bow bow) {
		this.bow = bow;
		this.sword = null;  // 기존에 장착되어 있는 무기를 해제하는 작업도 필요
	}
	
//	public void setGun(Gun gun) {
//		this.gun = gun;
//		this.sword = null;
//	}

	// 다형성을 적용하지 않았을 경우
	public void attack() {
		if(sword != null) {
			sword.attack();
		}
		
		if(bow != null) {
			bow.attack();
		}
	}

	
}

// 다형성을 최대한 활용한 PolyHero 클래스 설계
class PolyHero {
	// 멤버변수
	Weapon weapon;
	// 멤버변수에 대한 set 메서드
	public void setWeapon(Weapon weapon) {
		this.weapon = weapon;
//		this.sword = null; // 장착된 무기 해제작업 불필요!
	}
	
	// attack() 메서드
	public void attack() {
		if(weapon != null) {
			weapon.attack();
		}
	}
}

// Bow와 Sword를 추상화한 Weapon 클래스 설계
class Weapon {
	int demage;	// 데미지
	int range;	// 사정거리
	int attackSpeed; // 공격속도
	
	public Weapon(int demage, int range, int attackSpeed) {
		this.demage = demage;
		this.range = range;
		this.attackSpeed = attackSpeed;
	}
	
	public void attack() {
		String msg = range + " 거리에서" + demage + " 데미지를 " + attackSpeed + "속도로 공격";
		System.out.println(msg);
	}
}

class Sword extends Weapon {

	public Sword(int demage, int range, int attackSpeed) {
		super(demage, range, attackSpeed);
	}

	@Override
	public void attack() {
//		String msg = "검: " + range + " 거리에서" + demage + " 데미지를 " + attackSpeed + "속도로 공격";
//		System.out.println(msg);
		System.out.print("검: ");
		super.attack();
	}
	
//	int demage;	// 데미지
//	int range;	// 사정거리
//	int attackSpeed; // 공격속도
//	
//	public Sword(int demage, int range, int attackSpeed) {
//		this.demage = demage;
//		this.range = range;
//		this.attackSpeed = attackSpeed;
//	}
//	
//	public void attack() {
//		String msg = range + " 거리에서" + demage + " 데미지를 " + attackSpeed + "속도로 공격";
//		System.out.println(msg);
//	}
}

class Bow extends Weapon {

	// 추가된 멤버변수가 없을 경우 
	// Alt + Shift + S -> C
	public Bow(int demage, int range, int attackSpeed) {
		super(demage, range, attackSpeed);
	}

	@Override
	public void attack() {
//		String msg = "활: "+ range + " 거리에서" + demage + " 데미지를 " + attackSpeed + "속도로 공격";
//		System.out.println(msg);
		System.out.print("활: ");
		super.attack();
	}
	
	
	
//	int demage;
//	int range;
//	int attackSpeed;
//	
//	public Bow(int demage, int range, int attackSpeed) {
//		this.demage = demage;
//		this.range = range;
//		this.attackSpeed = attackSpeed;
//	}
//	
//	public void attack() {
//		String msg = range + " 거리에서" + demage + " 데미지를 " + attackSpeed + "속도로 공격";
//		System.out.println(msg);
//	}
	
}

class Gun extends Weapon {

	public Gun(int demage, int range, int attackSpeed) {
		super(demage, range, attackSpeed);
	}

	@Override
	public void attack() {
		System.out.print("총: ");
		super.attack();
	}

}














