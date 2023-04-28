package inheritance;

public class Test1 {

	public static void main(String[] args) {
		ItwillBank ib = new ItwillBank();
		ib.accountNo = "111-1111-111";
		ib.ownerName = "홍길동";
		ib.balance = 100000;
		
		ib.showAccountInfo();
		
		ib.deposit(50000);
		System.out.println("출금된 금액: " + ib.withdraw(100000) + "원");
		System.out.println("------------------");
		ib.contract("자동차");
	}

}

class Account {
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
}

/*
 * Account 클래스를 상속받는 ItwillBank 클래스 정의
 * => 은행계좌 기본기능 + 보험 관리 기능 추가
 * - 멤버변수: 보험명(insureName, 문자열)
 * - 메서드: contract() 메서드 (파라미터 보험명(insureName), 리턴값 없음)
 * 			=> 전달받은 보험명을 멤버변수에 저장하고
 * 				"계약하신 보험명: XXX 보험" 출력
 * */
class ItwillBank extends Account {
	String insureName;
	public void contract(String insureName) {
		this.insureName = insureName;
		System.out.println("계약하신 보험명: " + this.insureName + " 보험");
	}
}










