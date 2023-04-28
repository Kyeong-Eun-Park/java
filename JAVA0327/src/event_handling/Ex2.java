package event_handling;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Ex2 {

	public Ex2() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("이벤트 처리 - 5");
		f.setBounds(600, 400, 300, 300);
		
		/*
		 * < 이벤트 처리 5단계 >
		 * 5단계. 익명 내부클래스 (Annonymous Inner Class)의 임시 객체 형태로 사용
		 * - 기본적인 개념은 익명 내부클래스와 동일하나 이벤트 처리 대상이 하나뿐일 경우
		 *   별도의 변수가 필요없으므로 변수 선언부를 제외하고
		 *   리스너 연결을 위한 addXXXLinstener() 메서드 파라미터로 
		 *   익명 내부클래스를 구현하는 코드를 바로 기술하여 객체를 전달
		 * - 별도의 변수가 없으므로 두 개 이상의 컴포넌트에 리스너 연결이 불가능함
		 *   => 즉 1회용 리스너 객체가 됨
		 * */
		
		f.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("로컬 windowClosing");
			}
			
		});
		
//		f.addWindowListener(e -> System.out.println("로컬 windowClosing"));
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex2();
	}

}
