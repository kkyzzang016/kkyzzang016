package bankSystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Iterator;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BankAdmin extends JFrame implements ActionListener{

	DefaultTableModel model; // 테이블의 객체생성,데이터의 수정,삭제등을 하려면 필수
	JTable table;
	JButton btnAdd, btnDel, btnUpdate, btnrefresh;
	JPanel pTop;
	JFrame jf;
	BankMethod bm = new BankMethod();
	
	int second=10;
	public BankAdmin(int a) {
		
	}
	public BankAdmin() {

		jf = new JFrame("");
		jf.setBackground(Color.WHITE);
		
		String[] title = { "ID", "PW", "이름", "주소", "계좌", "휴대폰", "생일" };

		model = new DefaultTableModel(title, 0);
		table = new JTable(model);
		jf.add("Center", new JScrollPane(table));

		pTop = new JPanel();
		pTop.setBackground(Color.YELLOW);
		jf.add("North", pTop);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pTop.add(btnAdd);

		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		pTop.add(btnUpdate);

		btnDel = new JButton("삭제");
		btnDel.addActionListener(this);
		pTop.add(btnDel);
		
		btnrefresh = new JButton("새로고침");
		btnrefresh.addActionListener(this);
		pTop.add(btnrefresh);
		
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setBounds(100, 100, 500, 400);
		jf.setVisible(true);
		
		model.setRowCount(0);
		for(int i=0;i<BankMethod.client.size();i++) {
			Vector<String> data = new Vector<String>();
			data.add(BankMethod.client.get(i).getId());
			data.add(BankMethod.client.get(i).getPw());
			data.add(BankMethod.client.get(i).getName());
			data.add(BankMethod.client.get(i).getAddress());
			data.add(BankMethod.client.get(i).getAccount());
			data.add(BankMethod.client.get(i).getPhone());
			data.add(BankMethod.client.get(i).getBirth());
			model.addRow(data);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob==btnAdd) {
			new Add();
		}
		if(ob==btnUpdate) {
			
		}
		if(ob==btnDel) {
			
		}
		if(ob==btnrefresh) {
			model.setRowCount(0);
			for(int i=0;i<BankMethod.client.size();i++) {
				Vector<String> data = new Vector<String>();
				data.add(BankMethod.client.get(i).getId());
				data.add(BankMethod.client.get(i).getPw());
				data.add(BankMethod.client.get(i).getName());
				data.add(BankMethod.client.get(i).getAddress());
				data.add(BankMethod.client.get(i).getAccount());
				data.add(BankMethod.client.get(i).getPhone());
				data.add(BankMethod.client.get(i).getBirth());
				model.addRow(data);
			}
		}
	}
	
	public static void main(String[] args) {
		new BankAdmin();
	}
}
class Add extends JFrame implements ActionListener{
	
	JLabel lid, lpw, lname, ladd, lacc, lphone, lbirth;
	JFrame jf;
	JPanel jp;
	JButton jb;
	JTextField tid,tpw,tname,tadd,tacc,tphone,tbirth;
	BankMethod bm = new BankMethod();
	public Add() {
		lid = new JLabel("아이디");
		lpw = new JLabel("PW");
		lname = new JLabel("이름");
		ladd = new JLabel("주소");
		lacc = new JLabel("계좌");
		lphone = new JLabel("휴대폰");
		lbirth = new JLabel("생년월일");
		
		jf = new JFrame();
		jp = new JPanel();
		jp.setLayout(new GridLayout(7, 2));
		jb = new JButton("추가");
		jb.addActionListener(this);
		
		tid = new JTextField(5);
		tpw = new JTextField(5);
		tname = new JTextField(5);
		tadd = new JTextField(5);
		tacc = new JTextField(5);
		tphone = new JTextField(5);
		tbirth = new JTextField(5);
		
		jp.setBackground(Color.YELLOW);
		jf.add(jp,"Center");
		jp.add(lid);
		jp.add(tid);
		jp.add(lpw);
		jp.add(tpw);
		jp.add(lname);
		jp.add(tname);
		jp.add(ladd);
		jp.add(tadd);
		jp.add(lacc);
		jp.add(tacc);
		jp.add(lphone);
		jp.add(tphone);
		jp.add(lbirth);
		jp.add(tbirth);
		jf.add(jb, "South");
		
		jf.setVisible(true);
		jf.setSize(200, 300);
		jf.setLocation(500,400);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb) {
			bm.newClient(tid.getText(), tpw.getText(), tname.getText(), tadd.getText(), tacc.getText(), tphone.getText(), tbirth.getText());
			jf.dispose();
		}
	}	
}
