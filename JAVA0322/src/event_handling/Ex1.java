package event_handling;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import javax.swing.JFrame;

public class Ex1 {

	/*
	 * 이벤트(Event)
	 * - 컴포넌트(버튼 등)에서 사용자에 의해 어떤 상호작용이 일어나는 것
	 *   ex) 버튼 클릭, 마우스 이동, 키보드 입력, 체크박스 선택 등
	 * - 이벤트가 발생했을 때 어떤 동작을 수행하기 위해서는
	 *   대상 컴포넌트와 이벤트를 처리하는 이벤트 리스너를 서로 연결해야함
	 *   => 각 컴포넌트에 따라 서로 다른 리스너가 제공됨
	 *   	ex) 버튼 클릭 이벤트 담당: ActionListener 사용
	 *   => 컴포넌트 객체의 addXXX() 메서드를 호출하여 리스너 객체를 파라미터로 전달하여 연결
	 *      이때, XXX은 담당 리스너 인터페이스(또는 클래스) 이름
	 *      ex) btn.addActionListener(리스너객체);  
	 * 
	 * 이벤트 처리(Event Handling)
	 * - 컴포넌트에 특정 이벤트가 발생했을 때 수행할 동작을 지정하여 처리하는 것
	 * - 리스너 인터페이스 구현을 통해 내부에 수행할 동작을 명시
	 *   => XXXListener 인터페이스 또는 XXXAdapter 클래스가 제공됨
	 *   
	 * < 이벤트 처리 5단계 >  
	 * 1. 리스너 인테퍼이스를 구현하는 구현체 클래스를 정의
	 * 	=> 이벤트 방샐 시 수행할 동작을 구현체 내부의 메서드에 기술하고
	 *     리스너 연결시 구현체 객체 생성하여 메서드 파라미터로 전달
	 * */
	
	public Ex1() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("이벤트 처리-1");
		f.setBounds(600, 400, 300, 300);
		
		// 1. 핸들러 객체 생성
		MyWindowListener listener = new MyWindowListener();
		
		// 2. 이벤트 연결을 위한 대상 객체의 addXXXListener() 메서드를 호출하여
		//    파라미터로 핸들러 객체를 전달 => 대상과 이벤트 리스너 연결이 완료됨
		f.addWindowListener(listener);
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		// ===================================
		JFrame f2 = new JFrame();
		f2.setBounds(800, 400, 300, 300);
		// 만약, 처리할 이벤트가 동일할 경우 새 객체를 생성하지 않고
		// 기존에 생성한 리스너 객체를 그대로 재사용 가능
		f2.addWindowListener(listener);
		f2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f2.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex1();
	}

}

// 이벤트 처리 1단계
// 이벤트 처리를 위해 리스너 인터페이스를 구현하는 핸들러 클래스 별도로 정의
// 윈도우(프레임)에 대한 이벤트 처리 담당 리스너 : WindowListener 인터페이스
class MyWindowListener implements WindowListener {

	@Override
	public void windowOpened(WindowEvent e) {
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		System.out.println("windowClosing");
	}

	@Override
	public void windowClosed(WindowEvent e) {
		
	}

	@Override
	public void windowIconified(WindowEvent e) {
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		
	}
	
}







