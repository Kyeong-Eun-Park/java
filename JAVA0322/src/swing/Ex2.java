package swing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class Ex2 {

	public Ex2() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("버튼 생성");
		f.setBounds(600, 400, 300, 300);
		
		// 버튼 컴포넌트(JButton)를 생성하여 프레임(JFrame = 현재 객체)에 부착
		JButton btn = new JButton("버튼");
		f.add(btn);
		
//		btn.addActionListener(new ActionListener() {
//			
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				System.out.println("버튼 클릭!!!");
//			}
//		});
		
//		var comp = document.getElmentById("id");
//		comp.addEventListener(function (e){
//			alert(e.message)
//		});
//		comp.addEventListener(e => alert(e.message));
		
		btn.addActionListener(e -> System.out.println("버튼 클릭!!!"));
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex2();
	}

}
