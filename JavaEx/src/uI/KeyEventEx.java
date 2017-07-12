package uI;
import java.awt.TextArea;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;

public class KeyEventEx extends JFrame implements KeyListener, ActionListener{

	TextArea ta;
	TextField txt;
	JButton b;
	public KeyEventEx() {
		b = new JButton("Swing Button");
		txt = new TextField();
		ta = new TextArea();
		add("North",txt);
		add("Center", ta);
		add("South",b);
		setSize(300,300);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		txt.addKeyListener(this);
		b.addActionListener(this);
	}
	//키가 눌렸을 때 발생
	public void keyPressed(KeyEvent e) {
		ta.append(e.getKeyChar() + "가 눌림\n");
		if(e.getKeyChar() == KeyEvent.VK_SPACE) {
			System.out.println("스페이스가 입력되었습니다.");
		}
		//else if(e.getKeyChar() ==KeyEvent.)
	}
	//
	public void keyReleased(KeyEvent e) {
		ta.append(e.getKeyChar()+ "를 놓았음 \n");
		
	}
	//입력된 키의 종류 판별
	public void keyTyped(KeyEvent e) {
		ta.append(e.getKeyChar() + "가 입력\n");
		
	}
	
	public static void main(String[] args) {
		new KeyEventEx();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b) ta.setText(null);
		
	}
}
