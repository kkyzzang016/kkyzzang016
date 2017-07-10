package UI;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DialogEx extends JFrame{

	public JButton button;
	public Dialog dialog;
	public DialogEx() {
		button = new JButton("새창");
		dialog = new Dialog(this);
		dialog.setSize(100,100);
		
		dialog = new LoginDialog(this);
		//dialog.setLayout(new FlowLayout());
		dialog.pack();
		
		setLayout(new FlowLayout());
		add(button);
		setSize(300,200);
		setVisible(true);
		setLocation(500, 300);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dialog.setVisible(true);
			}
		});
	}
	public static void main(String[] args) {
		new DialogEx();
	}
}
class MyDialog extends JDialog{
	public MyDialog(JFrame frame) {
		super(frame);
	}
}
class Cli{
	private String id;
	private String pw;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getPw() {
		return pw;
	}
	public void setPw(String pw) {
		this.pw = pw;
	}
	
}
class LoginDialog extends JDialog implements ActionListener{
	protected Cli cli;
	JButton b;
	JTextField tid,tpw;
	public LoginDialog(JFrame frame) {
		super(frame);
		cli = new Cli();
		
		cli.setId("강광용");
		cli.setPw("kky1201");
		
		JLabel id = new JLabel("아이디");
		JLabel pw = new JLabel("비밀번호");
		b = new JButton("로그인");
		b.addActionListener(this);
		tid = new JTextField();
		tpw = new JTextField();
		
		JPanel jp = new JPanel();
		this.setLayout(new BorderLayout());
		jp.setLayout(new GridLayout(2, 2));
		jp.add(id);
		jp.add(tid);
		jp.add(pw);
		jp.add(tpw);
		
		add(jp,"Center");
		add(b,"East");
		setSize(100,100);
		setVisible(false);
		setLocation(500, 300);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==b) {
			String id = tid.getText();
			String pw = tpw.getText();
			if(id.equals(cli.getId())&&pw.equals(cli.getPw())) {
				JOptionPane.showMessageDialog(tid,"로그인 성공");
				System.out.println("로그인 성공");
				this.setVisible(false);
			}
			else {
				JOptionPane.showMessageDialog(tid,"로그인 실패");
				System.out.println("로그인 실패");
			}
	}
  }
}