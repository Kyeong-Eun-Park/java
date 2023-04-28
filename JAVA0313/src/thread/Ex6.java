package thread;

public class Ex6 {

	public static void main(String[] args) {
		/*
		 * 멀티 쓰레딩 환경에서의 문제점
		 * - 복수개의 쓰레드에서 동일한 객체의 데이터에 접근할 경우
		 * 	 각 쓰레드에서 사용되는 데이터의 일관성이 깨질 수 있다!
		 *   => A라는 쓰레드에서 접근해서 사용하는 데이터를
		 *      B라는 쓰레드에서 동시에 접근해서 변경할 경우
		 *      올바른 데이터가 아니게 될 수 있음 (= 데이터 일관성이 깨졌다!)
		 * - 공유 데이터에 대한 일관성 문제를 해결하기 위해서
		 *   Lock 개념과 동기화(Synchronize) 기능을 사용
		 *   => 메서드 또는 특정 코드 블럭에 synchronize 키워드를 사용하여 동기화 적용    
		 * */
		Account account = new Account(100000);
		
		// 출금 쓰레드를 수행할 객체 2개 생성
		WithdrawThread iBanking = new WithdrawThread("인터넷뱅킹", account, 2000);
		WithdrawThread mBanking = new WithdrawThread("모바일뱅킹", account, 2000);
		
		iBanking.start();
		mBanking.start();
		
		
	}

}

class Account {
	int balance;

	public Account(int balance) {
		this.balance = balance;
	}
	
	// 입금: deposit()
	// => 입력받은 금액(amount)을 현재잔고(balance)에 누적 후 현재잔고 리턴
	public int deposit(int amount) {
		balance += amount;
		return balance;
	}
	
	// 출금: withdraw()
	// => 출금할 금액(amount)을 전달받아 현재잔고에서 차감 후 출금금액 리턴
	//    단, 현재잔고가 출금할 금액보다 크거나 같을 경우에만 출금을 수행하고 현재잔고 출력
	//    아니면, "잔액이 부족하여 출금할 수 없습니다" 출력
	public synchronized int withdraw(int amount) {
		
		if(balance >= amount) {	// 출금 O
			balance -= amount;
		} else {
			System.out.println("잔액이 부족하여 출금할 수 없습니다");
			amount = 0;
		}
		
		System.out.println("출금된 금액: " + amount + ", 출금 후 잔액 : " + balance);
		return amount;
		
	}
}

// 출금 기능을 전담할 쓰레드 정의
class WithdrawThread extends Thread { 
	Account account;
	int amount;
	
	public WithdrawThread(String threadName, Account account, int amount) {
		super(threadName);
		this.account = account;
		this.amount = amount;
	}

	@Override
	public void run() {
		
		for(int i = 1; i <= 6; i++) {
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
			int money = account.withdraw(amount);
		}
		
		
	}
	
	
}






















