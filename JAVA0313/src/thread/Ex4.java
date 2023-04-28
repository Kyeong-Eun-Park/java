package thread;

import java.time.LocalTime;

public class Ex4 {

	public static void main(String[] args) {
		/*
		 * Thread 상태 제어 (sleep() 메서드를 통한 쓰레드 일시정지)
		 * - Thread.sleep() 메서드를 호출하여 일시 정지 가능
		 *   => 현재 수행중인 쓰레드를 지정된 시간동안 재우기
		 * - 지정가능한 시간은 밀리초(ms) 단위 (1ms = 1/1000초, 1000ms = 1초)
		 * - 지정한 시간만큼만 정확히 소요되는 것은 아니고
		 *   자원 회수 및 할당 등으로 인해 약간의 시간차가 발생할 수 있다!
		 *   
		 * - 주로 특정 쓰레드에 대한 타이머 기능을 부여하기 위한 용도로 사용하거나
		 *   *** 쓰레드간의 우선순위로 인한 기아(Starvation) 상태를 방지하는 용도로 사용됨  
		 * */
		
		Thread timer = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 1; i <= 60; i++) {
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					
					System.out.println(LocalTime.now());
				}
			}
		});
		timer.start();
		
		
		
	}

}
