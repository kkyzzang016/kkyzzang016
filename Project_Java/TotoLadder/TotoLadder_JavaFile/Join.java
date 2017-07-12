package JavaExam_2W.Swing.TotoLadder;

import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Join extends JFrame implements ActionListener{

	private JTextField tfID;
	private JTextField tfName;
	private JTextField tfBirth;
	private JComboBox<String> cbHP1;
	private JTextField tfHP1, tfHP2, tfHP3;
	private JTextField tfEmail;
	private JComboBox<String> cbEmail;
	private JPasswordField pfPW1, pfPW2;
	private JButton btnConfirm, btnJoin;
	private boolean idCheck;

	ImageIcon icon2 = new ImageIcon("media\\joinlogo.png");

	Container cp;

	// 데이터 베이스 주소
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://220.67.115.33:3306/stdt057";

	public Join(String title) {
		super(title);
		
		// 오라클 드라이버 클래스
		try {
			Class.forName(driver);
			System.out.println("MYSQL 드라이버 성공");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("MYSQL 드라이버 실패");
		}
		
		// TODO Auto-generated constructor stub
		// JFrame 클래스로 생성자를 통해서 제목을 보냄
		// Swing에서는 프레임의 컴포넌트를 삽입하기 위해서는 프레임에서 Container를 얻어와야 한다.
		cp = this.getContentPane(); // 프레임에 기본페널이 있음
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 닫기
		// 프레임 크기, 위치와 함께
		this.setBounds(450, 130, 400, 400);
		// 프레임 색상지정
		// this.setBackground(new Color(255, 255, 155));
		cp.setBackground(new Color(255, 255, 255));
		// 프레임 보이도록 설정, 항상 마지막에 와야한다.
		initDesign();
		this.setVisible(true);
	}

	public void initDesign() {
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 0, 30));
		panel.setLayout(null);
		this.add(panel);

		JLabel logoLbl = new JLabel("", icon2, JLabel.CENTER);
		logoLbl.setBounds(30, -15, 330, 90);
		panel.add(logoLbl);
		// 회원 가입 정보 입력

		// ID
		JLabel IDlbl = new JLabel("회원 ID");
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

		// 이메일
		JLabel emaillbl = new JLabel("E-mail");
		emaillbl.setForeground(Color.WHITE);
		emaillbl.setBounds(55, 240, 330, 90);
		panel.add(emaillbl);
		tfEmail = new JTextField(10); // 번호 입력칸
		tfEmail.setBounds(100, 270, 80, 25);
		panel.add(tfEmail);
		JLabel emaillbl2 = new JLabel("@");
		emaillbl2.setForeground(Color.WHITE);
		emaillbl2.setBounds(190, 270, 30, 30);
		panel.add(emaillbl2);
		String [] email = {"naver.com","hanmail.net","gmail.com","nate.com"};
		cbEmail = new JComboBox<String>(email);
		cbEmail.setBounds(210, 270, 110, 25);
		panel.add(cbEmail);

		// 등록
		btnJoin = new JButton("등  록");
		btnJoin.setBounds(150, 310, 100, 30);
		panel.add(btnJoin);
		btnJoin.addActionListener(this);

	}
	
	//=============================[DB메소드]==================================//
	// 1. DB연동 확인
	public Connection getConnection()
	{
		Connection conn=null;
		
		try {
			conn=DriverManager.getConnection(url, "stdt057", "skagur7227");
			System.out.println("db연동 성공");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("db연동 실패");
		}
		
		return conn;
	}

	// 회원가입
	public void insert(){
		
		String id = tfID.getText();
		String pasword = pfPW1.getText();
		String name = tfName.getText();
		String birthday = tfBirth.getText();
		String hp = cbHP1.getSelectedItem() + "-" + tfHP2.getText() + "-" + tfHP3.getText();
		String email = tfEmail.getText() + "@" + cbEmail.getSelectedItem();
		int point=0;
	
		String sql="insert into member values (num,?,?,?,?,?,joindate,?,?)";
		// db연결
		Connection conn=null;
		// Preparestatement
		PreparedStatement pstmt=null;
		
		conn = getConnection();		
		try {
			pstmt = conn.prepareStatement(sql);
			// 미완성된 "?"퀀텀 순서대로 바인딩
			pstmt.setString(1, id);
			pstmt.setString(2, pasword);
			pstmt.setString(3, name);
			pstmt.setString(4, birthday);
			pstmt.setString(5, hp);
			pstmt.setString(6, email);
			pstmt.setInt(7, point);

			// 업데이트
			pstmt.executeUpdate();
			System.out.println("**추가되었습니다**");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}
	// 중복확인
	public void IDCheck(){
		
		String id=tfID.getText();
		String num="";
		String sql="select id from member where id='"+id+"'";
		boolean flag=false;
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		
		conn =getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			if(rs.next()) {
				num=JOptionPane.showInputDialog("사용 중인 ID입니다!");
				if(num.equals(id)) IDCheck();
				else tfID.setText(num);
			}
			
			else JOptionPane.showMessageDialog(tfID, "사용가능한 ID입니다.");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob = e.getSource();
		
		if(ob==btnJoin){
			insert();
			this.setVisible(false);
			Login lg = new Login("로그인");
		}
		else if(ob==btnConfirm){
			IDCheck();
		}
	}
	
	//=========================================================================//
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Join("회원가입");
		
	}
}
