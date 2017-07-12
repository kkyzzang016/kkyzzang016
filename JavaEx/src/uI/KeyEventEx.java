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
	//Ű�� ������ �� �߻�
	public void keyPressed(KeyEvent e) {
		ta.append(e.getKeyChar() + "�� ����\n");
		if(e.getKeyChar() == KeyEvent.VK_SPACE) {
			System.out.println("�����̽��� �ԷµǾ����ϴ�.");
		}
		//else if(e.getKeyChar() ==KeyEvent.)
	}
	//
	public void keyReleased(KeyEvent e) {
		ta.append(e.getKeyChar()+ "�� ������ \n");
		
	}
	//�Էµ� Ű�� ���� �Ǻ�
	public void keyTyped(KeyEvent e) {
		ta.append(e.getKeyChar() + "�� �Է�\n");
		
	}
	
	public static void main(String[] args) {
		new KeyEventEx();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==b) ta.setText(null);
		
	}
}
