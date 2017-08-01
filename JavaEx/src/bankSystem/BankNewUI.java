package bankSystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class BankNewUI extends JFrame implements ActionListener{
	
	JTextField tfID;
	JTextField tfName;
	JTextField tfBirth;
	JComboBox<String> cbHP1;
	 JTextField tfHP1, tfHP2, tfHP3;
	 JTextField tfEmail;
	 JComboBox<String> cbEmail;
	 JPasswordField pfPW1, pfPW2;
	 JTextField acc,add1;
	 public static JTextField add;
	 JButton btnConfirm, btnJoin,btnadd;
	 boolean idCheck;
	 BankMethod bm = new BankMethod();

	public BankNewUI() {
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 30));
		panel.setLayout(null);
		this.add(panel);

		// 회원 가입 정보 입력
		// ID
		JLabel IDlbl = new JLabel("아이디");
		IDlbl.setForeground(Color.WHITE);
		IDlbl.setBounds(50, 30, 330, 90);
		panel.add(IDlbl);
		tfID = new JTextField(20); // ID입력칸  
		tfID.setBounds(100, 60, 160, 25);
		tfID.addActionListener(this);
		tfID.disable();
		panel.add(tfID);
		btnConfirm = new JButton("중복확인");
		btnConfirm.setBounds(270, 60, 90, 25);
		btnConfirm.addActionListener(this);
		panel.add(btnConfirm);

		// PW
		JLabel PWlbl = new JLabel("패스워드");
		PWlbl.setForeground(Color.WHITE);
		PWlbl.setBounds(40, 60, 330, 90);
		panel.add(PWlbl);
		pfPW1 = new JPasswordField(20); // 비밀번호 입력
		pfPW1.setBounds(100, 90, 160, 25);
		pfPW1.addActionListener(this);
		panel.add(pfPW1);
		
		// 주소
		JLabel ADlbl = new JLabel("       주 소");
		ADlbl.setForeground(Color.WHITE);
		ADlbl.setBounds(40, 90, 330, 90);
		panel.add(ADlbl);
		add = new JTextField(20); // 비밀번호 입력
		add.setBounds(100, 120, 130, 25);
		add.addActionListener(this);
		panel.add(add);
		add.disable();
		add1 = new JTextField(20); // 비밀번호 입력
		add1.setBounds(235, 120, 90, 25);
		add1.addActionListener(this);
		panel.add(add1);
		add1.disable();
		btnadd = new JButton("검색");
		btnadd.setBounds(330, 120, 60, 25);
		btnadd.addActionListener(this);
		panel.add(btnadd);

		//계좌 (비활성화)
		JLabel ACClbl2 = new JLabel("계 좌");
		ACClbl2.setForeground(Color.WHITE);
		ACClbl2.setBounds(60, 120, 330, 90);
		panel.add(ACClbl2);
		acc = new JTextField(20); // 비밀번호 확인 입력
		acc.setBounds(100, 150, 160, 25);
		acc.setBackground(Color.white);  
		acc.disable();
		acc.setText(bm.makeAccount());
		panel.add(acc);

		// 성함
		JLabel namelbl = new JLabel("성 함");
		namelbl.setForeground(Color.WHITE);
		namelbl.setBounds(60, 150, 330, 90);
		panel.add(namelbl);
		tfName = new JTextField(20); // ID입력칸
		tfName.setBounds(100, 180, 160, 25);
		tfName.addActionListener(this);	
		panel.add(tfName);

		// 주민등록번호
		JLabel birthlbl = new JLabel("생년월일");
		birthlbl.setForeground(Color.WHITE);
		birthlbl.setBounds(40, 180, 330, 90);
		panel.add(birthlbl);			
		tfBirth = new JTextField(6); // 생년월일 입력칸
		tfBirth.setBounds(100, 210, 80, 25);
		tfBirth.addActionListener(this);
		panel.add(tfBirth);
		JLabel birthlbl2 = new JLabel("주민등록번호 앞자리만 입력");
		birthlbl2.setForeground(Color.WHITE);
		birthlbl2.setBounds(190, 180, 330, 90);
		panel.add(birthlbl2);

		// 핸드폰
		JLabel hplbl = new JLabel("핸드폰번호");   
		hplbl.setForeground(Color.WHITE);
		hplbl.setBounds(25, 210, 330, 90);
		panel.add(hplbl);
		//tfHP1 = new JTextField(4); // 번호 입력칸
		String[] hp = {"010","011","016","017","018"};
		/*cbHP1 = new JComboBox<String>(hp);
		cbHP1.setBounds(100, 240, 50, 25);
		cbHP1.addActionListener(this);*/
		tfHP1 = new JTextField(3);
		tfHP1.setBounds(100, 240, 50, 25);
		tfHP1.addActionListener(this);
		panel.add(tfHP1);
		tfHP2 = new JTextField(4);
		tfHP2.setBounds(155, 240, 50, 25);
		tfHP2.addActionListener(this);
		panel.add(tfHP2);
		tfHP3 = new JTextField(4);
		tfHP3.setBounds(210, 240, 50, 25);
		tfHP3.addActionListener(this);
		panel.add(tfHP3);

		// 등록
		btnJoin = new JButton("등  록");
		btnJoin.setBounds(150, 300, 100, 30);
		panel.add(btnJoin);
		btnJoin.addActionListener(this);
		btnJoin.setVisible(false);
		
		setVisible(true);
		setSize(430, 400);
		setLocation(800, 450);
        //setDefaultCloseOperation(EXIT_ON_CLOSE); //System.exit(0) //프로그램종료
        setDefaultCloseOperation(EXIT_ON_CLOSE); //dispose(); //현재창만 닫는다.
	}
	
	public void actionPerformed(ActionEvent e) {
		
		Object ob = e.getSource();

		if(ob == btnadd) {
			new AddressSearch();
			add1.enable();
			add.enable();
		}
		if(ob ==btnConfirm) {
			String tempid = JOptionPane.showInputDialog("ID를 입력하세요!");
			if(bm.idConfirm(tempid)) {
				JOptionPane.showMessageDialog(null, "사용가능한 ID입니다!");
				btnJoin.setVisible(true);
				tfID.setText(tempid);
			}
			else JOptionPane.showMessageDialog(null, "중복된 ID입니다. 새로운 ID를 입력하세요!");
		}
		if(ob == btnJoin) {
			if(tfID.getText().equals(null)||pfPW1.getText().equals(null)||add.getText().equals(null)||add1.getText().equals(null)||
					acc.getText().equals(null)||tfName.getText().equals(null)||tfBirth.equals(null)||tfHP1.getText().equals(null)||
					tfHP2.getText().equals(null)||tfHP3.getText().equals(null)) {
				JOptionPane.showMessageDialog(null, "정보가 누락되었습니다!");
			}
			else {
				bm.newClient(tfID.getText(), pfPW1.getText(), tfName.getText(), add.getText(), add1.getText(), acc.getText(), 
																	tfHP1.getText(), tfHP2.getText(), tfHP3.getText(), tfBirth.getText());
				dispose();
				new BankLoginUI();
			}
		}
	}
	
	
	
	}
