package JavaExam_2W.Swing.TotoLadder;

import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame {

	private Container cp;
	private JTextField tfID;
	private JPasswordField pfPW;
	private JButton btnJoin, btnLogin;
	private boolean loginCheck;

	ImageIcon icon1 = new ImageIcon("media\\logo1.png");

	ImageIcon icon2 = new ImageIcon("media\\joinlogo.jpg");

	// Join join = new Join("회원가입");

	// 데이터 베이스 주소
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://220.67.115.33:3306/stdt057";

	public Login(String title) {
		// TODO Auto-generated constructor stub
		super(title); // JFrame 클래스로 생성자를 통해서 제목을 보냄

		// 오라클 드라이버 클래스
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("오라클 드라이버 실패");
		}

		// Swing에서는 프레임의 컴포넌트를 삽입하기 위해서는 프레임에서 Container를 얻어와야 한다.
		cp = this.getContentPane(); // 프레임에 기본페널이 있음
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // 프레임 닫기
		// 프레임 크기, 위치와 함께
		this.setBounds(500, 200, 350, 300);
		// 프레임 색상지정
		// this.setBackground(new Color(255, 255, 155));
		cp.setBackground(new Color(0, 0, 30));
		// 프레임 보이도록 설정, 항상 마지막에 와야한다.
		initDesign();
		this.setVisible(true);

	}

	public Connection getConnection() {
		// TODO Auto-generated method stub
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "stdt057", "skagur7227");
		} catch (SQLException e) {
			System.out.println("DB연동 실패");
		}
		return conn;
	}

	public void initDesign() {
		// pannel
		JPanel panel = new JPanel();
		placeLoginPanel(panel);
		panel.setBackground(new Color(0, 0, 30));
		panel.setLayout(null);

		this.add(panel);
	}

	public void placeLoginPanel(JPanel panel) {

		JLabel logoLbl = new JLabel("", icon1, JLabel.CENTER);
		logoLbl.setBounds(10, 30, 330, 90);
		panel.add(logoLbl);

		JLabel idLbl = new JLabel("UserID");
		idLbl.setForeground(Color.WHITE);
		idLbl.setBounds(50, 150, 80, 25);
		panel.add(idLbl);

		JLabel pwLbl = new JLabel("PW");
		pwLbl.setForeground(Color.WHITE);
		pwLbl.setBounds(50, 180, 80, 25);
		panel.add(pwLbl);

		tfID = new JTextField(20); // ID입력칸
		tfID.setBounds(100, 150, 160, 25);
		panel.add(tfID);
		pfPW = new JPasswordField(20); // PW입력칸
		pfPW.setBounds(100, 180, 160, 25);
		panel.add(pfPW);

		btnJoin = new JButton("회원가입");
		btnJoin.setBounds(50, 210, 100, 25);
		panel.add(btnJoin);
		btnJoin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new Join("회원가입");
			}
		});

		btnLogin = new JButton("로그인");
		btnLogin.setBounds(180, 210, 100, 25);
		panel.add(btnLogin);
		// 로그인 체크 후 메인화면으로 출력
		btnLogin.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				loginCheck();

			}
		});

	}

	public void loginCheck() {
		// select를 통해 DB안에 존재하는 아이디와 패스워드가 동시에 있을 시 로그인

		String tempid = tfID.getText();
		String pw = pfPW.getText();

		String sql = "select id, password, point from member where id='" + tempid + "'and password='" + pw + "'";

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		conn = getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);

			if (rs.next()) {
				String ad = "admin";
				if (ad.equals(tempid)) {
					new Manager("관리자");
				} else {
					JOptionPane.showMessageDialog(null, tfID.getText() + "님 환영합니다!");
					MainWindow.conid = rs.getString("id");
					MainWindow.conpw = rs.getString("password");
					;
					MainWindow.conpo = rs.getInt("point");
					MainWindow mw = new MainWindow("메인화면");
					this.setVisible(false);
				}

			} else
				JOptionPane.showMessageDialog(null, "아이디와 비밀번호를 올바르게 입력하십시오");

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	// ====================== DB메소드 =======================================//

	public void select() {
		String sql = "select id from member where " + tfID.getText();

		Connection conn = null;
		Statement stmt = null;
		ResultSet rs = null;

		conn = getConnection();
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
			while (rs.next()) {
				rs.getString("id");
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

	// ====================================================================================//
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Login("LOGIN");

	}

}
