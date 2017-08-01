package bankSystem;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankLoginUI extends JFrame implements ActionListener {

	JFrame login_Jf;
	JPanel loginJp;
	JLabel login_ID, login_PW;
	JTextField login_JID, login_JPW;
	JButton login_loginB, login_newjoin, login_exit;
	BankMethod bm = new BankMethod();
	public BankLoginUI() {
		login_Jf = new JFrame("은행");
		loginJp = new JPanel();
		login_ID = new JLabel("    아이디 : ");
		login_ID.setForeground(Color.white);
		login_PW = new JLabel("    패스워드 : ");
		login_PW.setForeground(Color.white);

		login_JID = new JTextField(20);
		login_JPW = new JTextField(20);
		login_loginB = new JButton("로그인");
		login_newjoin = new JButton("신규");
		login_exit = new JButton("종료");

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

		login_Jf.setTitle("은행");
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
			String tempid = login_JID.getText();
			String temppw= login_JPW.getText();
			if(bm.login(tempid, temppw)) {
				if(tempid.equals("admin")) {
					new BankAdmin();
					login_Jf.dispose();
				}
				else {
				new BankMainUI();
				login_Jf.dispose();
				}
			}
			else {
				JOptionPane.showMessageDialog(null, "잘못입력하셨습니다.");
			}
			
			
		}
	}

	public static void main(String[] args) {
		new BankLoginUI();
	}
}