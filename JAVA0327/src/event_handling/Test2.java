package event_handling;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Test2 {

	public Test2() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("이벤트 처리 연습 - 5");
		f.setBounds(600, 400, 300, 300);
		
		// 1. JButton 객체 생성 후 프레임에 부착
		// 2. 버튼에 대한 이벤트처리 5단계 형식으로 구현
		JButton btn = new JButton("버튼");
		f.add(btn);
//		btn.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("버튼 클릭!!!");
//			}
//		});
		
		btn.addActionListener(e -> System.out.println("버튼 클릭!!!"));
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Test2();
	}

}
