package bankSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.mysql.jdbc.StreamingNotifiable;

public class BankMainUI extends JFrame implements ActionListener{

	JLabel jl,lname,lmoney,lacc,name,money,acc;
	JPanel jp,jp1, jp2;
	JButton ip, chul,info,logout;
	BankMethod bm = new BankMethod();
	BankClientInfo bi;
	BankDB bd = new BankDB();
	String currentId = bm.currentID;
	public BankMainUI() {

		bi=bm.clientInfo(currentId);
		jl = new JLabel(" ");
		jp = new JPanel();
		jp.setBackground(new Color(0,0,30));
		jp1 = new JPanel();
		jp1.setBackground(new Color(0,0,30));
		jp1.setLayout(new BorderLayout());
		jp2 = new JPanel();
		jp2.setBackground(Color.WHITE);
		ip = new JButton("입금");
		ip.addActionListener(this);
		chul = new JButton("출금");
		chul.addActionListener(this);
		info = new JButton("회원정보");
		info.addActionListener(this);
		logout = new JButton("로그아웃");
		logout.addActionListener(this);
		
		lname = new JLabel("이름 : ");
		lmoney = new JLabel("          잔액 : ");
		lacc = new JLabel("          계좌 : ");
		name = new JLabel(bi.getName());
		money = new JLabel(String.valueOf(bi.getMoney()));
		acc = new JLabel(bi.getAccount());
		
		jp.add(ip);
		jp.add(chul);
		jp.add(info);
		jp.add(logout);
		jp1.add(jl, "North");
		jp1.add(jp,"Center");
		jp2.add(lname);
		jp2.add(name);
		jp2.add(lacc);
		jp2.add(acc);
		jp2.add(lmoney);
		jp2.add(money);
	
		GridBagLayout gbl = new GridBagLayout();
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.fill = GridBagConstraints.BOTH;
        setLayout(gbl);
        
        addGrid(gbl, gbc, jp1, 0, 0, 1, 1, 1, 1);			
        addGrid(gbl, gbc, jp2, 0, 1, 1, 5, 1, 10);
        
		setSize(500,300);
		setLocation(500, 200);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	 private void addGrid(GridBagLayout gbl, GridBagConstraints gbc, Component c,  
             int gridx, int gridy, int gridwidth, int gridheight, int weightx, int weighty) {
       gbc.gridx = gridx;
       gbc.gridy = gridy;
       gbc.gridwidth = gridwidth;
       gbc.gridheight = gridheight;
       gbc.weightx = weightx;
       gbc.weighty = weighty;
       gbl.setConstraints(c, gbc);
       add(c);
	}
	
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj==logout) {
			this.dispose();
			new BankLoginUI();
		}
		if(obj ==ip) {
			int ipmoney = Integer.parseInt(JOptionPane.showInputDialog("입금할 금액을 입력하세요!")); //옵션팬 발생하여 입금금액 얻어옴
			bi.setMoney(ipmoney+bi.getMoney());	//현재 회원정보 객체에 연산하여 저장
			money.setText(String.valueOf(bi.getMoney()));		//라벨 잔액갱신 출력
			bd.updateMoney(bi, bi.getId(),bi.getMoney());		//데이터베이스에 저장
		}
		if(obj==chul) {
			int chulmoney = Integer.parseInt(JOptionPane.showInputDialog("입금할 금액을 입력하세요!"));
			bi.setMoney(bi.getMoney()-chulmoney);		//현재 회원정보 객체에 연산하여 저장
			money.setText(String.valueOf(bi.getMoney()));		//라벨 잔액갱신 출력
			bd.updateMoney(bi, bi.getId(),bi.getMoney());		//데이터베이스에 저장
		}
		if(obj==info) {
			new Info(bi.getId(),bi.getName(),bi.getAccount(),bi.getAddress(),bi.getMoney(),bi.getPhone());
		}
	}
}
class Info extends JFrame{
	JLabel pid,pname,pacc,padd,pmoney,pphone;
	JLabel lid,lname,lacc,ladd,lmoney,lphone;
	JPanel jp;
	public Info(String id, String name, String acc, String add, int money, String phone) {
		jp = new JPanel();
		jp.setBackground(Color.WHITE);
		jp.setLayout(new GridLayout(6, 2));
		
		lid = new JLabel("                         ID : ");
		lname = new JLabel("                    이름 : ");
		lacc = new JLabel("                    계좌 : ");
		ladd = new JLabel("                    주소 : ");
		lmoney = new JLabel("                    잔액 : ");
		lphone = new JLabel("                    휴대폰 : ");
		pid = new JLabel(id);
		pname = new JLabel(name);
		pacc = new JLabel(acc);
		padd = new JLabel(add);
		pmoney = new JLabel(String.valueOf(money));
		pphone = new JLabel(phone);
		
		jp.add(lid);
		jp.add(pid);
		jp.add(lname);
		jp.add(pname);
		jp.add(lacc);
		jp.add(pacc);
		jp.add(ladd);
		jp.add(padd);
		jp.add(lmoney);
		jp.add(pmoney);
		jp.add(lphone);
		jp.add(pphone);
		add(jp);
		
		setVisible(true);
		setSize(650, 200);
		setLocation(500, 200);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
}