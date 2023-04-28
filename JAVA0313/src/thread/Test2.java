package thread;

public class Test2 {

	public static void main(String[] args) {
		// main() 메서드 내에서
		// "메세지 송신", "메세지 수신", "파일 전송" 작업을 동시에 100번씩 수행
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i < 100; i++) {
					System.out.println("메세지 송신");
				}
			}
		}).start();
		
		new Thread(() -> {
			for(int i = 0; i < 100; i++) {
				System.out.println("메세지 수신");
			}
		}).start();
		
		new Thread() {
			@Override
			public void run() {
				for(int i = 0; i < 100; i++) {
					System.out.println("파일 전송");
				}
			}
		}.start();
		
		
		
		
	}

}
