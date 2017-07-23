package bankSystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankLoginUI extends JFrame implements ActionListener {

	JFrame login_Jf;
	JPanel loginJp;
	JLabel login_ID, login_PW;
	JTextField login_JID, login_JPW;
	JButton login_loginB, login_newjoin, login_exit;

	public BankLoginUI() {
		login_Jf = new JFrame("����");
		loginJp = new JPanel();
		login_ID = new JLabel("    ���̵� : ");
		login_ID.setForeground(Color.white);
		login_PW = new JLabel("    �н����� : ");
		login_PW.setForeground(Color.white);

		login_JID = new JTextField(20);
		login_JPW = new JTextField(20);
		login_loginB = new JButton("�α���");
		login_newjoin = new JButton("�ű�");
		login_exit = new JButton("����");

		loginJp.setBackground(new Color(0, 0, 30));
		login_ID.setBounds(20, 15, 80, 25);
		login_PW.setBounds(20, 60, 80, 25);
		login_JID.setBounds(100, 15, 160, 25);
		login_JPW.setBounds(100, 60, 160, 25);
		login_loginB.setBounds(270, 10, 80, 80);
		login_loginB.addActionListener(this);

		login_newjoin.setBounds(70, 100, 90, 30);
		login_newjoin.addActionListener(this);

		login_exit.setBounds(210, 100, 90, 30);
		login_exit.addActionListener(this);
		login_Jf.add(login_ID);
		login_Jf.add(login_PW);
		login_Jf.add(login_JID);
		login_Jf.add(login_JPW);
		login_Jf.add(login_loginB);
		login_Jf.add(login_newjoin);
		login_Jf.add(login_exit);
		login_Jf.add(loginJp);

		login_Jf.setTitle("����");
		login_Jf.setSize(370, 165);
		login_Jf.setVisible(true);
		login_Jf.setLocation(800, 450);
		login_Jf.setResizable(false);
		login_Jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob==login_newjoin){
			dispose();
			new BankNewUI();
		}
		if(ob==login_exit){
			System.exit(0);
		}
		if(ob==login_loginB){
			new BankMainUI();
		}
	}

	public static void main(String[] args) {
		new BankLoginUI();
	}
}
