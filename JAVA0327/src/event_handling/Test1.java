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
		JFrame f = new JFrame("이벤트 처리 연습 - 4");
		f.setBounds(600, 400, 300, 300);
		
		// 1. JButton 생성 후 부착
		// 2. 버튼에 대한 이벤트 리스너를 4단계 방식으로 처리
		
		ActionListener listener = new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("로컬 버튼 클릭!!");
			}
		};
		
		JButton btn = new JButton("버튼");
		f.add(btn);
		btn.addActionListener(this.listener);
	
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	ActionListener listener = new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			System.out.println("멤버 버튼 클릭!!");
		}
	};
	
	public static void main(String[] args) {
		new Test1();
	}

}
