package thread;

public class Ex2 {

	public static void main(String[] args) {
		/*
		 * 멀티쓰레딩 구현 코드의 변형
		 * - 실제 프로그래밍에서 더 많이 쓰는 형식
		 * - Runnable 인터페이스를 구현하는 구현체 클래스를 별도로 정의하지 않고
		 *   Thread 클래스의 생성자에 Runnable 인터페이스 객체 생성코드를 바로작성
		 *   => Runnable 인터페이스의 임시 객체 형태를 Thread 생성자에 전달
		 * - Runnable 객체를 담는 변수가 없으므로 Runnable 객체에는 접근 불가능
		 *   만약, Thread 객체의 변수도 제거하는 경우 Thread 객체도 접근 불가능
		 *   => 일회용 객체(= 임시 객체) 라고 한다!
		 * 
		 * < 기본 문법 >
		 * Thread t = new Thread(new Runnable(){
		 * 
		 * 		@Override
		 * 		public void run(){
		 * 			// 먼티 쓰레딩으로 구현할 코드...
		 * 		}
		 * });
		 * t.start();
		 * => 위의 두 문장을 하나로 결합하여 Thread 객체도 임시객체로 사용 가능
		 * new Thread(new Runnable(){...}).start();
		 * 
		 * */
		Thread t = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i <100000; i++) {
					System.out.println(i + " : A작업");
				}
			}
		});
//		t.start();
		
		// ------------------------------------------
		// 위의 작업을 하나의 문장으로 결합
		// => Thread 클래스의 변수를 제거 후 객체 생성코드만 기술하고
		//    start() 메서드를 바로 호출
//		new Thread().start();
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i <100000; i++) {
					System.out.println(i + " : A작업");
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i <100000; i++) {
					System.out.println(i + " : B작업");
				}
			}
		}).start();
		
		new Thread(new Runnable() {
			@Override
			public void run() {
				for(int i = 0; i <100000; i++) {
					System.out.println(i + " : C작업");
				}
			}
		}).start();
		
		// 람다식 맛만
		new Thread(() -> {
			for(int i = 0; i <100000; i++) {
				System.out.println(i + " : 람다 작업");
			}
		}).start();
		
		
		/*
		 * 참고. Thread 클래스만으로 멀티쓰레딩을 구현하는 방법
		 * (위의 방법보다 사용빈도 낮음)
		 * 
		 * < 기본 문법 >
		 * new Thread(){
		 * 		@Override
		 * 		public void run(){
		 * 			// 멀티쓰레딩으로 처리할 코드...
		 * 		}
		 * }.start();
		 * */
		new Thread() {
			@Override
			public void run() {
				for(int i = 0; i <100000; i++) {
					System.out.println(i + " : D작업");
				}
			}
		}.start();
		
		
		
		
		
	}

}




