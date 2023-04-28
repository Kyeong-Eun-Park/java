package thread;

public class Test2 {

	public static void main(String[] args) {
		
		SendMessageThread smt = new SendMessageThread("안녕하세요", 100000);
		FileTransferThread ftt = new FileTransferThread("a.java", 100000);
		ReceiveMessageThread rmt = new ReceiveMessageThread("Re:안녕하세요", 100000);
		
		smt.start();
		ftt.start();
		rmt.start();
	}
}

// 메세지 전송 클래스를 Thread 클래스를 상속받아 정의 SendMessageThread
class SendMessageThread extends Thread {
	String str;
	int count;
	public SendMessageThread(String str, int count) {
		this.str = str;
		this.count = count;
	}
	@Override
	public void run() {
		for(int i = 0; i < count; i++) {
			System.out.println(i + " : " + str);
		}
	}
}

// 파일 전송 클래스를 Thread 클래스를 상속받아 정의 FileTransferThread
class FileTransferThread extends Thread {
	String str;
	int count;
	public FileTransferThread(String str, int count) {
		this.str = str;
		this.count = count;
	}
	@Override
	public void run() {
		for(int i = 0; i < count; i++) {
			System.out.println(i + " : " + str);
		}
	}
}
// 메세지 수신 클래스를 Thread 클래스를 상속받아 정의 ReceiveMessageThread
class ReceiveMessageThread extends Thread {
	String str;
	int count;
	public ReceiveMessageThread(String str, int count) {
		this.str = str;
		this.count = count;
	}
	@Override
	public void run() {
		for(int i = 0; i < count; i++) {
			System.out.println(i + " : " + str);
		}
	}
}







