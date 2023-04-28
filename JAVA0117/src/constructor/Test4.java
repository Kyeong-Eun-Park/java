package constructor;

import java.util.ArrayList;

// 1. 기본생성자
// 2. 계좌번호 전달받는 생성자
// 3. 계좌번호, 예금주명 전달받는 생성자
// 4. 계좌번호, 예금주명, 현재잔고 전달받는 생성자
// 단, this() 를 활용해서 설계하시오.
class Account3 {
	String accountNo;	// "111-1111-111"
	String ownerName;	// "홍길동"
	int balance;		// 10000
	
	public Account3() {
		this("111-1111-111", "홍길동", 10000);
	}
	
	public Account3(String accountNo) {
		this(accountNo, "홍길동", 10000);
	}
	
	public Account3(String accountNo, String ownerName) {
		this(accountNo, ownerName, 10000);
	}
	
	public Account3(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
	public void showAccountInfo() {
		System.out.println("계좌번호: " + accountNo);
		System.out.println("예금주명: " + ownerName);
		System.out.println("현재잔고: " + balance);
	}
}

public class Test4 {

	public static void main(String[] args) {
		Account3 acc = new Account3();
		Account3 acc2 = new Account3("333-3333-333");
		Account3 acc3 = new Account3("555-5555-555", "이순신");
		Account3 acc4 = new Account3("777-7777-777", "김태희", 500000);
		
//		acc.showAccountInfo();
//		System.out.println("-----------------");
//		acc2.showAccountInfo();
//		System.out.println("-----------------");
//		acc3.showAccountInfo();
//		System.out.println("-----------------");
//		acc4.showAccountInfo();
//		System.out.println("-----------------");
		
//		int a = 10;
//		int[] arr = {a, 20, 30};
		
//		for(int i = 0; i < arr.length; i++) {
//			int b = arr[i];
//		}
		
//		for(int num : arr) {
//			System.out.println(num);
//		}
		
		Account3[] arr = {acc, acc2, acc3, acc4, new Account3()};
		
//		for(int i = 0; i < arr.length; i++) {
////			Account3 ac = arr[i];
////			ac.showAccountInfo();
//			arr[i].showAccountInfo();
//			System.out.println("---------------------");
//		}
		
		// 향상된 for문
//		for(Account3 ac : arr) {
//			ac.showAccountInfo();
//			System.out.println("---------------------");
//		}
		
		// 배열의 크기가 변경될 수 있는 ArrayList
		// => 일반배열은 크기가 고정되어 변경할 수 없지만
		//    자바에서 제공하는 ArrayList 클래스는 계속해서 배열에 요소를 추가가능
		// => <> 제네릭 (자세한 설명은 추후에...)
		//	  배열에 저장할 데이터타입을 제한할 수 잇다!
		ArrayList<Account3> arrayList = new ArrayList<Account3>();
//		arrayList.add(10);
//		arrayList.add("문자열");
		arrayList.add(acc);
		arrayList.add(acc2);
		arrayList.add(acc3);
		arrayList.add(acc4);
		arrayList.add(new Account3());
		
		// 일반 for문 으로 showAccountInfo() 메서드 호출
//		for(int i = 0; i < arrayList.size(); i++) {
//			Account3 ac = arrayList.get(i);
//			ac.showAccountInfo();
//			System.out.println("---------------");
//		}
		
		// 향상된 for문으로 변경
		for(Account3 ac : arrayList) {
			ac.showAccountInfo();
			System.out.println("---------------------");
		}
		
		
	}

}











