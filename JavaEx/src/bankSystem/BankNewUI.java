package bankSystem;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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
	
	private JTextField tfID;
	private JTextField tfName;
	private JTextField tfBirth;
	private JComboBox<String> cbHP1;
	private JTextField tfHP1, tfHP2, tfHP3;
	private JTextField tfEmail;
	private JComboBox<String> cbEmail;
	private JPasswordField pfPW1, pfPW2;
	private JTextField acc;
	private JButton btnConfirm, btnJoin;
	private boolean idCheck;
	
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
		panel.add(pfPW1);

		// PW확인
		JLabel PWlbl2 = new JLabel("확 인");
		PWlbl2.setForeground(Color.WHITE);
		PWlbl2.setBounds(60, 90, 330, 90);
		panel.add(PWlbl2);
		pfPW2 = new JPasswordField(20); // 비밀번호 확인 입력
		pfPW2.setBounds(100, 120, 160, 25);
		panel.add(pfPW2);
		
		//계좌 (비활성화)
		JLabel ACClbl2 = new JLabel("계 좌");
		ACClbl2.setForeground(Color.WHITE);
		ACClbl2.setBounds(60, 120, 330, 90);
		panel.add(ACClbl2);
		acc = new JTextField(20); // 비밀번호 확인 입력
		acc.setBounds(100, 150, 160, 25);
		acc.setBackground(Color.LIGHT_GRAY);
		acc.setEnabled(false);
		panel.add(acc);

		// 성함
		JLabel namelbl = new JLabel("성 함");
		namelbl.setForeground(Color.WHITE);
		namelbl.setBounds(60, 150, 330, 90);
		panel.add(namelbl);
		tfName = new JTextField(20); // ID입력칸
		tfName.setBounds(100, 180, 160, 25);
		panel.add(tfName);

		// 주민등록번호
		JLabel birthlbl = new JLabel("생년월일");
		birthlbl.setForeground(Color.WHITE);
		birthlbl.setBounds(40, 180, 330, 90);
		panel.add(birthlbl);
		tfBirth = new JTextField(6); // 생년월일 입력칸
		tfBirth.setBounds(100, 210, 80, 25);
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
		cbHP1 = new JComboBox<String>(hp);
		cbHP1.setBounds(100, 240, 50, 25);
		panel.add(cbHP1);
		tfHP2 = new JTextField(4);
		tfHP2.setBounds(155, 240, 50, 25);
		panel.add(tfHP2);
		tfHP3 = new JTextField(4);
		tfHP3.setBounds(210, 240, 50, 25);
		panel.add(tfHP3);

		// 등록
		btnJoin = new JButton("등  록");
		btnJoin.setBounds(150, 300, 100, 30);
		panel.add(btnJoin);
		btnJoin.addActionListener(this);
		
		setVisible(true);
		setSize(430, 400);
		setLocation(800, 450);
        //setDefaultCloseOperation(EXIT_ON_CLOSE); //System.exit(0) //프로그램종료
        setDefaultCloseOperation(EXIT_ON_CLOSE); //dispose(); //현재창만 닫는다.
	}
	
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==btnJoin)
			this.setVisible(false);
			new BankLoginUI();
		
	}

}
