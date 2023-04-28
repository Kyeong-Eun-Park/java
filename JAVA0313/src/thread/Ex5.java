package thread;

public class Ex5 {

	public static void main(String[] args) {
		/*
		 * 쓰레드 우선순위 (Priority)
		 * - 실행중인 쓰레드가 우선적으로 실행되도록 조정 가능한 값
		 * - 1 ~ 10 까지의 값을 부여 가능하며, 기본값은 5이다.
		 * - 쓰레드 우선순위가 높을 수록 실행될 수 있는 확률이 높으나
		 *   절대적으로 작용하지는 않음
		 *   => 어디까지나 CPU 스케쥴에 따라 실행되며, 자주 실행될 수 있는 "확률" 을 높임
		 * - 우선순위에 의한 실행 도중 우선순위가 높은 쓰레드가 지속적으로 추가될 경우
		 *   우선순위가 낮은 쓰레드가 실행되지 못할 수 있다. = 기아(Starvation) 상태
		 *   => 기아 상태를 방지하기 위해서는 모든 쓰레드가
		 *      최소한의 시간만큼 일시정지 되도록 구현해야함(= sleep() 메서드 활용)
		 * */
		
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 100000; i++) {
					System.out.println("★★★★★★★★★★");
				}
			}
		});
		
		// 현재 우선순위 확인 : getPriority()
		System.out.println("t1 쓰레드 우선순위 : " + t1.getPriority());
		
		// 현재 쓰레드 우선순위 변경 : setPriority()
		t1.setPriority(8);
		System.out.println("t1 쓰레드 우선순위 : " + t1.getPriority());
		
		t1.setPriority(Thread.MAX_PRIORITY);
		System.out.println("t1 쓰레드 우선순위 : " + t1.getPriority());
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 100000; i++) {
					System.out.println("○○○○○○○○○○");
				}
			}
		});
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 100000; i++) {
					System.out.println("==========");
				}
			}
		});
		
		// t1, t2, t3 쓰레드의 우선순위를 서로 다르게 변경
		t1.setPriority(Thread.MAX_PRIORITY);	// ★★★★★★★★★★
		t3.setPriority(Thread.MAX_PRIORITY);	// ==========
		t2.setPriority(Thread.MIN_PRIORITY);	// ○○○○○○○○○○○
		
		t1.start();
		t2.start();
		t3.start();
		
		
	}

}
