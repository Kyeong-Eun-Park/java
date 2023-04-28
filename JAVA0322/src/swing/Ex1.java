package swing;

import javax.swing.JFrame;

/*
 * Java Swing
 * - 자바에서 GUI 구현을 위해 제공되는 API
 * - 이전에 Java AWT(Active Window Toolkit)
 *   => AWT API와 Swing API를 조합하여 사용
 * - java.awt 패키지와 javax.swing 패키지의 각종 클래스 및 인터페이스 활용
 * ------------------------------------------------------------
 * 자주 사용되는 용어
 * 1. 컨테이너 : 여러 컴포넌트를 하나로 묶어서 부착 가능한 객체
 * 		- 프레임과 패널을 주로 사용
 * 		- JFrame 클래스와 JPanel 클래스로 구현
 * 
 * 2. 컴포넌트 : 화면을 구성하는 각각의 요소
 * 		- 버튼, 체크박스, 라디오버튼, 텍스트필드, 텍스트에어리어
 * 		- 컨테이너에 부착하여 사용
 * 		- 각 컴포넌트에서 사용자로부터 어떤 동작이 발생하면 해당 동작을 처리하는 이벤트 처리 필요 
 * 
 * ============================================================
 * 
 * < 창 생성하는 기본 문법 >  
 * 1. 창(윈도우)을 생성하기 위해서는 Window 계열 객체 생성 필요
 * 		=> JFrame 클래스를 사용
 * 		=> JFrame 객체를 생성하거나 JFrame 클래스를 상속받는 서브클래스를 정의하여 창 생성  
 *   	ex) class Ex1 extends JFrame {} 또는 JFrame f = new JFrame();
 * */
public class Ex1 extends JFrame {

	public Ex1() {
		showFrame();
	}
	
	public void showFrame() {
		setSize(300, 200); // 가로 300, 세로 200 크기 설정
		setLocation(300, 350); // 창이 생성될 좌표설정
		setTitle("JFrame을 상속받아 생성"); // 제목표시줄 타이틀 생성
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true); // 프레임을 화면에 표시
		// ------------------------------------------------
		// JFrame 객체를 직접 생성하여 프레임 생성
		JFrame f = new JFrame("JFrame 으로 생성한 프레임");
		f.setSize(600, 400);
		f.setLocation(600, 600);
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex1();
	}

	
	
	
}
