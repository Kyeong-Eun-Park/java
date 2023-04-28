package thread;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * < 멀티 쓰레딩 구현 방법 >
		 * 2. Runnable 인터페이스를 구현하는 서브클래스를 정의하는 방법
		 * 	- 기존에 다른 클래스를 상속중인 서브클래스는 Thread 클래스 상속이 불가능하므로
		 *    Thread 클래스 상속 대신 Runnable 인터페이스를 구현하면 된다.
		 *    (Thread 클래스는 Runnable 인터페이스의 구현체이다)
		 *  - Runnable 인터페이스 내에는 start() 메서드가 존재하지 않으며
		 *    존재 하더라도 추상메서드 형태이기 때문에 start() 메서드 호출이 불가능하다!
		 *    => 따라서, Thread 클래스를 통해 간접적으로 start() 메서드를 호출해야한다!
		 *  1) 멀티쓰레딩 코드가 포함될 서브클래스에서 Runnable 인터페이스를 구현 (implements)
		 *  2) 추상메서드인 run() 메서드를 구현(오버라이딩)하여 멀티쓰레딩 코드 기술
		 *  3) 멀티쓰레딩 클래스 인스턴스 생성
		 *  ----- 주의! Runnable 이넡페이스 내에 start() 메서드가 존재하지 않음 -----
		 *  4) start() 메서드를 갖고있는 Thread 클래스의 인스턴스 생성
		 *  5) Thread 인스턴스 통해 간접적으로 start() 메서드 호출  
		 * */
		
//		YourThread yt1 = new YourThread("★★A작업★★", 1000000);
//		YourThread yt2 = new YourThread("○○B작업○○", 1000000);
//		YourThread yt3 = new YourThread("◆◆C작업◆◆", 1000000);
//		Runnable r = new YourThread("◆◆C작업◆◆", 1000000);
		// => YourThread -> Runnable 업캐스팅 가능
		
		// Runnable 구현체 내부에는 start() 메서드가 존재하지 않는다!
//		yt1.start();
		
		// Thread 클래스의 인스턴스 생성 시 생성자 파라미터로 Runnable 구현체 객체 전달 후
		// Thread 객체를 통해 start() 메서드를 호출하여 간접적으로 멀티쓰레딩 수행
//		Thread t1 = new Thread(yt1);
//		Thread t2 = new Thread(yt2);
//		Thread t3 = new Thread(yt3);
		
		// ---------------------------------------------------------
		// YourThread 타입 변수는 Thread 클래스 생성자에 전달하는 작업 외에 사용되지 않는다.
		// 따라서, 1회설 변수를 선언하기 보다 Thread 생성자에
		// YourThread 객체 생성 코드를 직접 전달하여 변수 없이 객체 자체를 바로 전달 가능
		Thread t1 = new Thread(new YourThread("★★A작업★★", 1000000));
		Thread t2 = new Thread(new YourThread("○○B작업○○", 1000000));
		Thread t3 = new Thread(new YourThread("◆◆C작업◆◆", 1000000));
		
		t1.start();
		t2.start();
		t3.start();
		
	}
}
class A {}
class YourThread extends A implements Runnable {
	String str;
	int count;
	
	public YourThread(String str, int count) {
		this.str = str;
		this.count = count;
	}
	
	// Runnable 인터페이스에서 상속된 run() 메서드 오버라이딩 필수!
	@Override
	public void run() {
		for(int i = 0; i < count; i++) {
			System.out.println(i + " : " + str);
		}
	}
}





