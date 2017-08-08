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
import javax.swing.JOptionPane;
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
	public static String id="";
	public BankAdmin(int a) {
		
	}
	public BankAdmin() {

		jf = new JFrame("");
		jf.setBackground(Color.WHITE);
		
		String[] title = { "ID", "PW", "이름", "주소", "계좌", "휴대폰", "생일", "잔액" };

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
		
		model.setRowCount(0);			//테이블에 전체 회원정보 출력
		for(int i=0;i<BankMethod.client.size();i++) {
			Vector<String> data = new Vector<String>();
			data.add(BankMethod.client.get(i).getId());
			data.add(BankMethod.client.get(i).getPw());
			data.add(BankMethod.client.get(i).getName());
			data.add(BankMethod.client.get(i).getAddress());
			data.add(BankMethod.client.get(i).getAccount());
			data.add(BankMethod.client.get(i).getPhone());
			data.add(BankMethod.client.get(i).getBirth());
			data.add(String.valueOf(BankMethod.client.get(i).getMoney()));
			model.addRow(data);
		}
	}
	
	public void actionPerformed(ActionEvent e) {
		Object ob = e.getSource();
		if(ob==btnAdd) {
			new Client("추가");
		}
		if(ob==btnUpdate) {
			id = JOptionPane.showInputDialog("수정을 원하는 회원의 ID를 입력하세요!"); //스태틱변수에 수정을 원하는 회원 ID입력
			new Client("수정");
			 
		}
		if(ob==btnDel) {
			new Client("삭제");
		}
		if(ob==btnrefresh) {		//새로고침 버튼 클릭 시 전체회원정보 갱신하여 출력
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
				data.add(String.valueOf(BankMethod.client.get(i).getMoney()));
				model.addRow(data);
			}
		}
	}
	
	public static void main(String[] args) {
		new BankAdmin();
	}
}
class Client extends JFrame implements ActionListener{
	
	JLabel lid, lpw, lname, ladd, lacc, lphone, lbirth,lmoney;
	JFrame jf;
	JPanel jp;
	JButton jb;
	JTextField tid,tpw,tname,tadd,tacc,tphone,tbirth,tmoney;
	BankClientInfo bi;
	BankMethod bm = new BankMethod();
	BankDB bd = new BankDB();
	public Client(String str) {
		bi= bm.clientInfo(BankAdmin.id);
		lid = new JLabel("아이디");
		lpw = new JLabel("PW");
		lname = new JLabel("이름");
		ladd = new JLabel("주소");
		lacc = new JLabel("계좌");
		lphone = new JLabel("휴대폰");
		lbirth = new JLabel("생년월일");
		lmoney = new JLabel("잔액");
		
		jf = new JFrame();
		jp = new JPanel();
		jp.setLayout(new GridLayout(8, 2));
		jb = new JButton(str);
		jb.addActionListener(this);
		
		tid = new JTextField(5);
		tid.setText(bi.getId());
		tpw = new JTextField(5);
		tpw.setText(bi.getPw());
		tname = new JTextField(5);
		tname.setText(bi.getName());
		tadd = new JTextField(5);
		tadd.setText(bi.getAddress());
		tacc = new JTextField(5);
		tacc.setText(bi.getAccount());
		tphone = new JTextField(5);
		tphone.setText(bi.getPhone());
		tbirth = new JTextField(5);
		tbirth.setText(bi.getBirth());
		tmoney = new JTextField(5);
		tmoney.setText(String.valueOf(bi.getMoney()));
		if(jb.getText().equals("삭제")) {
			lpw.setVisible(false);
			lname.setVisible(false);
			lacc.setVisible(false);
			ladd.setVisible(false);
			lphone.setVisible(false);
			lbirth.setVisible(false);
			lmoney.setVisible(false);
			tpw.setVisible(false);
			tname.setVisible(false);
			tadd.setVisible(false);
			tacc.setVisible(false);
			tphone.setVisible(false);
			tbirth.setVisible(false);
			tmoney.setVisible(false);
		}
		else if(jb.getText().equals("추가")) {
			tmoney.setText("0");
			tmoney.disable();
		}
		
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
		jp.add(lmoney);
		jp.add(tmoney);
		jf.add(jb, "South");
		
		jf.setVisible(true);
		jf.setSize(200, 300);
		jf.setLocation(500,400);
		
	}

	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==jb) {
			if(jb.getText().equals("추가")) {		//추가버튼 클릭 시 회원추가
			bm.newClient(tid.getText(), tpw.getText(), tname.getText(), tadd.getText(), tacc.getText(), tphone.getText(), tbirth.getText());
			jf.dispose();
			}
			else if(jb.getText().equals("삭제")) {
				bd.deleteClientData(tid.getText());
				bm.deleteVector(tid.getText());
				jf.dispose();
			}
			else if(jb.getText().equals("수정")) {		//수정버튼 클릭 시 회원정보 수정
				String id = tid.getText();
				String pw = tpw.getText();
				String name = tname.getText();
				String add = tadd.getText();
				String acc = tacc.getText();
				String phone = tphone.getText();
				String birth = tbirth.getText();
				int money =Integer.parseInt(tmoney.getText());
				//벡터에 클라이언트 정보 수정
				bm.updateVector(BankAdmin.id, id, pw, name, add, acc, phone, birth, money);
				System.out.println(bm.client.get(bm.searchIndex(tid.getText())).getId());
				System.out.println(bm.client.get(bm.searchIndex(tid.getText())).getPw());
				//벡터에 수정된 값대로 DB에 업데이트
				bd.updateClientData(bm.client.get(bm.searchIndex(tid.getText())), BankAdmin.id);
				System.out.println("수정");
				jf.dispose();
			}
		}
	}	
}
