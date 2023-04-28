package event_handling;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class Ex3 {

	public Ex3() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("이벤트 처리-3");
		f.setBounds(600, 400, 300, 200);
		
		/*
		 * < 이벤트 처리 5단계 >
		 * 3단계. 내부클래스(Inner Class) 형태로 정의
		 * 리스너 인터페이스 또는 어댑터 클래스를 구현 시 내부클래스 형태로 구현하여 사용
		 * => 이벤트 리스너 구현체는 보통 GUI 클래스에서만 사용됨 (= 전용클래스)
		 *    따라서, 별도의 클래스로 외부에 정의하기 보다는 내부클래스 형태로 정의해서 사용
		 *    GUI 클래스 내부에 핸들러 클래스를 정의하면 내부클래스가 됨
		 * => 외부에 정의하는 방법과 클래스 모양은 동일하나 클래스 정의 위치만 달라짐
		 * 
		 * [ 위치에 따른 차이점 ]
		 * 1) 멤버 레벨에 정의하는 멤버 내부클래스  
		 * 	=> 멤버 변수의 성격과 동일한 클래스가 됨 (= 접근 범위가 멤버변수와 동일해짐) 
		 * 2) 메서드 내부에 정의하는 로컬 내부 클래스
		 *  => 로컬 변수의 성격과 동일한 클래스가 됨 (= 접근 범위가 로컬변수와 동일해짐)
		 * */
		
		// 멤버 내부 클래스 형태로 정의
//		MyMemberWindowAdapter listener = new MyMemberWindowAdapter();
//		f.addWindowListener(listener);
		
		// 로컬 내부 클래스 형태로 정의
		class MyLocalWindowAdapter extends WindowAdapter {

			@Override
			public void windowClosing(WindowEvent e) {
				System.out.println("로컬레벨 windowClosing");
			}
		}
		
		MyLocalWindowAdapter listener = new MyLocalWindowAdapter();
		f.addWindowListener(listener);
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public void showFrame2() {
		
		// 메서드가 달라지면 로컬 내부클래스는 접근이 불가능하므로
		// 여러 메서드에서 하나의 리스너를 공유하려면 멤버 내부클래스 형태로 정의 해야한다!
//		MyLocalWindowAdapter listener;
		
		MyMemberWindowAdapter listener;
	}
	
	public static void main(String[] args) {
		new Ex3();
	}
	
	// 이벤트 처리 3단계. 내부클래스(Inner Class)형태로 정의
	// 멤버 내부클래스 형태로 정의
	// => 인스턴스 멤버와 동일한 위치에 정의하므로 인스턴스 내부 클래스라고도 함
	// => 인스턴스 내의 여러 메서드에서 공유 가능
	class MyMemberWindowAdapter extends WindowAdapter {

		@Override
		public void windowClosing(WindowEvent e) {
			System.out.println("멤버레벨 windowClosing");
		}
		
	}
	

}
