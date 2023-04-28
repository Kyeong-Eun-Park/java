package event_handling;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test1 {

	public Test1() {
		showFrame();
	}
	
	public void showFrame() {
		/*
		 * 1. 300, 200 프레임 생성
		 * 2. "버튼" 이라는 텍스트를 갖는 버튼 객체 부착
		 * 3. 클릭 이벤트 처리를 위해 ActionListener 인터페이스를 구현하는
		 *    핸들러 정의 (MyActionListener)
		 *    => 메서드 내에 "버튼 클릭" 문자열 출력하는 코드 기술
		 * 4. ActionListener 인터페이스 구현체 객체 생성
		 * 5. 버튼 객체의 addXXXListner() 메서드 호출하여 MyActionListener 객체 전달   
		 * */
		JFrame f = new JFrame("이벤트 처리 연습-1");
		f.setBounds(800, 400, 300, 300);
		
		JButton btn = new JButton("버튼");
		f.add(btn);
		
		MyActionListener listener = new MyActionListener();
		btn.addActionListener(listener);
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
		
		
		
		
		
		
	}
	
	public static void main(String[] args) {
		new Test1();
	}

}

class MyActionListener implements ActionListener {

	@Override
	public void actionPerformed(ActionEvent e) {
		System.out.println("버튼 클릭!!!");
	}
}










