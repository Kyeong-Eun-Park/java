package thread;

public class Ex1 {

	public static void main(String[] args) {
		/*
		 * 프로그램(Program)
		 * - 디스크에 설치되어 있는 실행되기 전 상태의 소프트웨어
		 * 
		 * 프로세스(Process)
		 * - 프로그램을 실행하여 메모리에 로딩된 상태(= 실행 중인 프로그램)
		 * - 멀티태스킹 (Multi Tasking)
		 * 	 => 프로세스가 여러개 일 때 해당 프로스세들이 동시에 수행되는 것
		 * 		(정확히는 CPU가 빠른 속도로 프로세스들을 번갈아가며 처리함 = 진짜 동시 X)
		 * 	
		 * 쓰레드(Thread)
		 * - 프로세스 내에서 작업의 최소 단위
		 * - 하나의 프로세스 내에 쓰레드가 한개(= Single Thread)일 때
		 * 	 해당 프로세스 내에서 동시에 수행 가능한 작업은 단 하나 뿐이다.
		 * - 하나의 프로세스 내에서 동시에 수행가능한 작업을 늘리려면
		 *   멀티 쓰레딩(= Multi Thread)을 구현 해야한다!
		 * 	 (ex. 메신저에서 파일 전송과 함께 메세지 송신, 수신을 동시에 수행하는 것)
		 * 
		 * 일반적인 프로그래밍은 싱글 쓰레드로 동작하므로
		 * 하나의 작업이 끝난 후에야 그 다음 작업이 수행될 수 있다!
		 * */
		 NoThread nt1 = new NoThread("★★A작업★★", 1000000);
		 NoThread nt2 = new NoThread("○○B작업○○", 1000000);
		 NoThread nt3 = new NoThread("◆◆C작업◆◆", 1000000);
	
		 nt1.run();	// A작업이 100만번 수행이 끝나면
		 nt2.run();	// B작업이 실행되고, B작업이 100만번 수행이 끝나면
		 nt3.run();	// C작업이 실행됨
		 // => 즉, 기본적인 프로그램은 앞의 코드가 실행이 끝나야만 다음 코드가 실행된다!
	}

}

class NoThread {
	String str;
	int count;
	
	public NoThread(String str, int count) {
		this.str = str;
		this.count = count;
	}
	
	public void run() {
		// count 횟수만큼 str 반복 출력
		for(int i = 0; i < count; i++) {
			System.out.println(i + " : " + str);
		}
	}
	
}








