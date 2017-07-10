package BankSystem;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class BankApp extends JFrame implements ActionListener{
	public JFrame jf;
	public JPanel jp,jp1,jp2;
	public JLabel id,pw;
	public JLabel[] jl;
	public JTextField jid,jpw;
	public JButton login,newjoin,cancel;
	
	public BankApp() {
		jf = new JFrame("은행 애플리케이션");
		jf.setLayout(new BorderLayout());
		jl = new JLabel[9];
		for(int i=0;i<jl.length;i++) {
			jl[i]=new JLabel(" ");
		}
		jl[0].setText("   :");
		jl[1].setText("   :");
		
		jp = new JPanel();
		jp.setLayout(new GridLayout(2, 3));
		jp1 = new JPanel();
		jp1.setLayout(new GridLayout(1, 2));
		jp2 = new JPanel();
		jp2.setLayout(new BorderLayout());
		
		jid=new JTextField();
		jpw = new JTextField();
		
		id = new JLabel("아이디");
		pw = new JLabel("비밀번호");
		
		login = new JButton("로그인");
		newjoin = new JButton("회원가입");
		cancel = new JButton("종료");
		
		
		jp.add(id);
		jp.add(jl[0]);
		jp.add(jid);
		
		jp.add(pw);
		jp.add(jl[1]);
		jp.add(jpw);
		
		jp1.add(newjoin);
		jp1.add(cancel);
		jp2.add(jp1,"Center");
		jp2.add(jl[4],"East");
		jp2.add(jl[5],"West");
		jp2.add(jl[6],"North");
		jp2.add(jl[3],"South");
		
		jf.add(jp,"Center");
		jf.add(login,"East");
		jf.add(jl[7],"West");
		jf.add(jl[8],"North");
		jf.add(jp2,"South");
		//jf.add(login,"East");
		jf.setSize(300,150);
		jf.setVisible(true);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
		
	}
	public static void main(String[] args) {
		new BankApp();
	}
}
