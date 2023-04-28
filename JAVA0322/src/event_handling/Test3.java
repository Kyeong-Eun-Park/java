package event_handling;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test3 {

	public Test3() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("이벤트 처리 연습-3");
		f.setBounds(800, 400, 300, 300);
		
		// 이벤트 처리 3단계. 내부 클래스 형태로 이벤트 처리
		// 1. 멤버레벨 (MemberActionListener)
		// 2. 로컬레벨 (LocalActionListener)
		JButton btn = new JButton("버튼");
		f.add(btn);
		// 1. 멤버레벨 (MemberActionListener)
		MemberActionListener listener = new MemberActionListener();
		btn.addActionListener(listener);
		
		// 2. 로컬레벨 (LocalActionListener)
		class LocalActionListener implements ActionListener {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("로컬 레벨 버튼 클릭!");
			}
		}
		LocalActionListener listener2 = new LocalActionListener();
		btn.addActionListener(listener2);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	class MemberActionListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("멤버 레벨 버튼 클릭!");
		}
	}
	
	public static void main(String[] args) {
		new Test3();
	}

}
