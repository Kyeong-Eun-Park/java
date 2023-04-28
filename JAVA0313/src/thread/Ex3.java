package thread;

public class Ex3 {

	public static void main(String[] args) {
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					System.out.println("A작업");
				}
			}
		});
		t1.start();
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					System.out.println("B작업");
				}
			}
		});
		t2.start();
		
		System.out.println("현재 쓰레드명: " + Thread.currentThread().getName());
		System.out.println("t1 쓰레드명: " + t1.getName());
		System.out.println("t2 쓰레드명: " + t2.getName());
		
		Thread t3 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 10; i++) {
					// 현재 수행중인 쓰레드 객체를 가져오는 방법
					// => Thread 클래스의 static 메서드 currentThread() 메서드 호출
					Thread t = Thread.currentThread();
					System.out.println("C작업! 현재쓰레드: " + t.getName());
				}
			}
		});
		t3.setName("t3 쓰레드");
		t3.start();
		System.out.println("--------------------------------------------");
		
		MyThread mt = new MyThread("<<< 내 쓰레드 >>>", 10);
		mt.start();
		
		new Thread(() -> { 
			System.out.println(Thread.currentThread().getName()); 
		}, "<<< 내 2번째 쓰레드 >>>").start();
	}
}

class MyThread extends Thread {
	int count;

	public MyThread(String threadName, int count) {
		super(threadName);
//		setName(threadName);
		this.count = count;
	}

	@Override
	public void run() {
		for(int i = 0; i < count; i++) {
			System.out.println(i + " : " + getName());
		}
	}
}








