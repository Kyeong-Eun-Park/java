package event_handling;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Ex2 {

	/*
	 * < 이벤트 처리 5단계 >
	 * 2. 리스너 인터페이스 대신 어댑터 클래스 사용
	 *  - 추상메서드 2개 이상인 인터페이스를 구현할 경우
	 *    불필요한 메서드까지 구현해야하므로 코드가 길어짐
	 *  - 리스너 인터페이스를 미리 구현해놓은 어댑터 클래스를 상속받는 핸들러에서
	 *    원하는 메서드만 선택하여 오버라이딩 가능하므로 코드가 간결해짐
	 *  - XXXListener 인터페이스에 대응하응 XXXAdapter 클래스가 제공됨
	 *    단, 추상메서드가 하나뿐인 인터페이스는 어댑터클래스가 제공되지 않음
	 * */
	
	public Ex2() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("이벤트 처리-2");
		f.setBounds(600, 400, 300, 200);
		
		// 1. 핸들러 객체 WindowAdapter 구현체 생성)
//		MyWindowAdapter listener = new MyWindowAdapter();
		
		// 2. 이벤트 연결을 위한 대상 객체의 addXXXListener 메서드를 호출하여
		//	  파라미터로 핸들러 객체를 전달
//		f.addWindowListener(listener);
		
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("windowClosing");
			}
		});
		
		// 람다식 안되는 이유
		// 1. WindowAdapter는 클래스
		// 2. 여러 메서드중 특정 메서드를 오버라이딩 한것뿐!
//		f.addWindowListener(e -> System.out.println("windowClosing"));
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex2();
	}

}

// 이벤트 처리 2단계
// 이벤트 처리를 위한 리스너 인터페이스 대신 어댑터 클래스를 구현하는 핸들러 클래스 별도로 정의
// WindowListener 인터페이스 => 이에 대한 어댑터클래스 : WindowAdapter 클래스
class MyWindowAdapter extends WindowAdapter {

	// 상속받은 슈퍼클래스의 메서드 중 필요한 메서드만 선택 오버라이딩
	// => windowClosing() 메서드 오버라이딩
	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
	}
	
}







