package method;

/*
 * 은행계좌(Account) 클래스 정의
 * - 멤버변수(단, 모든 멤버변수를 private 접근제한자로 선언)
 * 1) 계좌번호(accountNo)
 * 2) 예금주명(ownerName)
 * 3) 현재잔고(balanc)
 * - 모든 멤버변수에 대한 Getter / Setter 메서드 정의
 * */
class Account {
	
	private String accountNo;
	private String ownerName;
	private int balance;
	private boolean isVip; // vip 여부
	
	public boolean isVip() {
		return isVip;
	}
	public void setVip(boolean isVip) {
		this.isVip = isVip;
	}
	
	
	public String getAccountNo() {
		return accountNo;
	}
	public void setAccountNo(String accountNo) {
		this.accountNo = accountNo;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public int getBalance() {
		return balance;
	}
//	public void setBalance(int balance) {
//		this.balance = balance;
//	}
	
	public void deposit(int amount) {
		this.balance += amount;
		System.out.println("입금할 금액: " + amount + "원");
		System.out.println("입금 후 현재잔고: " + balance + "원");
	}
	
	public void showAccountInfo() {
		System.out.println("계좌번호: " + getAccountNo());
		System.out.println("예금주명: " + this.getOwnerName());
		System.out.println("현재잔고: " + balance);
	}
	
}


public class Test1 {

	public static void main(String[] args) {

		Account acc = new Account();
		acc.setAccountNo("111-1111-111");
		acc.setOwnerName("홍길동");
//		acc.setBalance(100000);
		// => 은행 계좌 기능 중 잔고설정(setBalance())은 적합하지 않은 기능이므로
		//    입금기능 (deopsit()) 을 통해 처리하는 것이 더 적합함
		acc.deposit(100000);
		
		System.out.println("계좌번호 : " + acc.getAccountNo());
		System.out.println("예금주명 : " + acc.getOwnerName());
		System.out.println("현재잔고 : " + acc.getBalance() + "원");
		System.out.println("-------------------------");
		acc.showAccountInfo();
		
	}

}
