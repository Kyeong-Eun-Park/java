package event_handling;

import java.awt.Component;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class Ex3 {

	public Ex3() {
		showFrame();
	}
	
	public void showFrame() {
		JFrame f = new JFrame("CheckBox 연습");
		f.setBounds(600, 400, 400, 300);
		
		// 패널을 하나 생성한 후 프레임에 부착
		JPanel p = new JPanel();
		f.add(p);
		
		JCheckBox cb1 = new JCheckBox("Java");
		JCheckBox cb2 = new JCheckBox("JSP");
		JCheckBox cb3 = new JCheckBox("Android");
		JCheckBox cb4 = new JCheckBox("Spring");
		JCheckBox cbAll = new JCheckBox("전체선택");
		JTextField tf = new JTextField(10);

//		JCheckBox[] cbs = {cb1, cb2, cb3, cb4};
//		ArrayList<JCheckBox> cbs = new ArrayList<JCheckBox>();
//		cbs.add(cb1); cbs.add(cb2); cbs.add(cb3); cbs.add(cb4);
		
		p.add(cb1); p.add(cb2); p.add(cb3); 
		p.add(cb4); 
		p.add(cbAll);
		p.add(tf);
		
		/*
		 * 전체선택 체크박스에 대한 이벤트 처리 => ActionListener
		 * => 전체선택 체크 시 cb1, cb2, cb3를 모두 체크
		 *    전체선택 체크 해제 시 cb1, cb2, cb3를 모두 체크해제
		 * */
		cbAll.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				if(cbAll.isSelected()) {
//					cb1.setSelected(true);
//					cb2.setSelected(true);
//					cb3.setSelected(true);
//				} else {
//					cb1.setSelected(false);
//					cb2.setSelected(false);
//					cb3.setSelected(false);
//				}
				
//				boolean isSelected = cbAll.isSelected();
//				cb1.setSelected(isSelected);
//				cb2.setSelected(isSelected);
//				cb3.setSelected(isSelected);
				
				// 배열 or ArrayList version
//				boolean isSelected = cbAll.isSelected();
//				for(JCheckBox cb : cbs) {
//					cb.setSelected(isSelected);
//				}
				
				boolean isSelected = cbAll.isSelected();
				Component[] comps = p.getComponents();
				for(Component comp : comps) {
					if(comp instanceof JCheckBox) {
						((JCheckBox)comp).setSelected(isSelected);
					}
				}
			}
		});
		
		
		
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		f.setVisible(true);
	}
	
	public static void main(String[] args) {
		new Ex3();
	}

}
