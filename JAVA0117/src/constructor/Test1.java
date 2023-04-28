package constructor;


class Account {
	String accountNo;
	String ownerName;
	int balance;
	
	// 기본 생성자와 동일한 Account() 생성자 정의
	// => 생성자 내에서 멤버변수를 다음과 같이 초기화
	//    accountNo: "111-1111-111"
	//	  ownerName: "홍길동"
	//	  balance:	 100000
	public Account() {
		accountNo = "111-1111-111";
		ownerName = "홍길동";
		balance = 100000;
	}

	// 파라미터 3개 (계좌번호, 예금주명, 현재잔고)를 전달받아 초기화하는 생성자 저의
	public Account(String accountNo, String ownerName, int balance) {
		this.accountNo = accountNo;
		this.ownerName = ownerName;
		this.balance = balance;
	}
	
}

public class Test1 {

	public static void main(String[] args) {

//		Account acc = new Account();
		
		Account acc = new Account("222-2222-222", "이순신", 100000);
		
		System.out.println("계좌번호 : " + acc.accountNo);
		System.out.println("예금주명 : " + acc.ownerName);
		System.out.println("현재잔고 : " + acc.balance);
		
	}

}
