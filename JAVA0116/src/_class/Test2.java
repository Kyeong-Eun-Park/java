package _class;
/*
 * 은행계좌(Account2) 클래스 정의
 * 
 * - 메서드
 * 		1) showAccountInfo() : 계좌정보를 출력
 * 			< 출력예시 >
 * 			계좌번호 : 111-1111-111
 * 			예금주명 : 홍길동
 * 			현재잔고 : 100000원
 * 		2) deposit() : 입금 기능
 * 			- 매개변수 : 입금금액(정수, amount), 리턴값 없음
 * 			- 입금할 금액(amount)을 전달받아 현재잔고(balance)에 누적
 * 			- 입금할 금액과 입금 후의 잔고를 다음과 같이 출력
 * 				입금금액 : XXX원
 * 				현재잔고 : XXX원
 * 		3) withdraw() : 출금 기능
 * 			- 매개변수 : 출금할 금액(정수, amount), 리턴값 : 출금된 금액
 * 			- 출금할 금액(amount)을 전달받아 다음 조건에 따라 출금 수행
 * 				a. 출금할 금액보다 현재잔고가 작을 경우 (출금이 불가능할 경우)
 * 					출력) 출금할 금액 : XXX원
 * 						 잔액이 부족하여 출금 불가! (현재잔고: XXX원)
 * 				b. 출금할 금액보다 현재잔고가 크거나 같은 경우 (출금이 가능할 경우)
 * 					출금할 금액만큼 현재잔고에서 차감 후 다음과 같이 출력
 * 						출금할 금액 : XXX원
 * 						현재잔고 : XXX원 -> 출금하고 남은 금액만큼 출력
 * 						출금할 금액만큼 리턴
 * 				
 * 
 * 
 * */
class Account2 {
	String accountNo;
	String ownerName;
	int balance;
	
	public void showAccountInfo() {
		System.out.println("계좌번호 : " + accountNo);
		System.out.println("예금주명 : " + ownerName);
		System.out.println("현재잔고 : " + balance + "원");
	}
	
	public void deposit(int amount) {
		balance += amount;
		System.out.println("입금금액 : " + amount + "원");
		System.out.println("현재잔고 : " + balance + "원");
	}
	
//	3) withdraw() : 출금 기능
//	 * 			- 매개변수 : 출금할 금액(정수, amount), 리턴값 : 출금된 금액
//	 * 			- 출금할 금액(amount)을 전달받아 다음 조건에 따라 출금 수행
//	 * 				a. 출금할 금액보다 현재잔고가 작을 경우 (출금이 불가능할 경우)
//	 * 					출력) 출금할 금액 : XXX원
//	 * 						 잔액이 부족하여 출금 불가! (현재잔고: XXX원)
//	 * 				b. 출금할 금액보다 현재잔고가 크거나 같은 경우 (출금이 가능할 경우)
//	 * 					출금할 금액만큼 현재잔고에서 차감 후 다음과 같이 출력
//	 * 						출금할 금액 : XXX원
//	 * 						현재잔고 : XXX원 -> 출금하고 남은 금액만큼 출력
//	 * 						출금할 금액만큼 리턴
	public int withdraw(int amount) {
		System.out.println("출금할 금액 : " + amount + "원");
		if(amount > balance) { // 출금 X
			System.out.println("잔액이 부족하여 출금 불가! (현재잔고: " + balance + "원)");
			amount = 0;
		} else { // 출금 O
			balance -= amount;
			System.out.println("현재잔고 : " + balance + "원");
		}
		return amount;
	}
	
	public void transfer(int amount, Account2 other) {
		balance -= amount;
		other.balance += amount;
		System.out.println(ownerName + "의 잔액: " + balance); // 내 계좌 정보
		System.out.println(other.ownerName + "의 잔액: " + other.balance); // 돈받은놈
	}
	
}

public class Test2 {

	public static void main(String[] args) {
		Account2 acc = new Account2();
		acc.accountNo = "111-1111-111";
		acc.ownerName = "홍길동";
		acc.balance = 100000;
		
		acc.showAccountInfo();
		acc.deposit(50000);
		System.out.println("------------------");
		acc.showAccountInfo();
		
		System.out.println("------------------");
//		int money = acc.withdraw(200000);
//		System.out.println(money);
		
		Account2 acc2 = new Account2();
		acc2.accountNo = "222-2222-222";
		acc2.ownerName = "이순신";
		acc2.balance = 500000;
		acc2.showAccountInfo();
		
		// 홍길동 -> 이순신 50000원 이체
		acc.transfer(50000, acc2);
	
		// 이순신 -> 홍길동 100000원 이체
		acc2.transfer(100000, acc);
	}

}
