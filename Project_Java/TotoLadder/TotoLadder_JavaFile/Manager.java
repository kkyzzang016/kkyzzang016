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
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class Manager extends JFrame implements ActionListener {

	Container cp;
	JButton btn1, btn2, btn4;
	DefaultTableModel model; // 테이블의 객체생성,데이터의 수정,삭제등을 하려면 필수
	JTable table;
	JTextField tfid, tfpw, tfName, tfbirthday, tfhp, tfemail, tfdate, tfpoint;
	String num; // 수정할 번호

	
	UpdateFrame2 updateFrame2 = new UpdateFrame2("회원정보수정");
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://220.67.115.33:3306/stdt057";

	public Manager(String title) {
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
		this.setBounds(500, 200, 500, 500);
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
		String[] title = { "번호", "ID", "pw", "이름", "생년월일", "폰번호", "Email", "가입날짜", "포인트" };

		model = new DefaultTableModel(title, 0);
		table = new JTable(model);
		this.add("Center", new JScrollPane(table));

		// pannel
		JPanel jp = new JPanel();
		jp.setBackground(new Color(0, 0, 30));
		this.add("North", jp);
		tableWrite();

		btn1 = new JButton("회원정보갱신");
		btn1.setBounds(25, 15, 100, 45);
		btn1.addActionListener(this);
		jp.add(btn1);

		btn2 = new JButton("회원정보수정");
		btn2.setBounds(150, 15, 100, 45);
		btn2.addActionListener(this);
		jp.add(btn2);

		btn4 = new JButton("회원정보삭제");
		btn4.setBounds(400, 15, 100, 45);
		btn4.addActionListener(this);
		jp.add(btn4);

		updateFrame2.btnMod.addActionListener(this);

	}

	/////////////////////// Update method
	public void updateData() {

		String num = updateFrame2.num;
		String id = updateFrame2.tfid.getText();
		String password = updateFrame2.tfpw.getText();
		String name = updateFrame2.tfname.getText();
		String birthday = updateFrame2.tfbd.getText();
		String hp = updateFrame2.tfhp.getText();
		String email = updateFrame2.tfemail.getText();
		int point = Integer.parseInt(updateFrame2.tfpoint.getText());

		String sql = "update member set id=?, password=?,name=?,birthday=?,hp=?,email=?,point=? where num=" + num;
		// update hello set name=?, addr=? where num="+num
		Connection conn = null;
		PreparedStatement pstmt = null;

		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, password);
			pstmt.setString(3, name);
			pstmt.setString(4, birthday);
			pstmt.setString(5, hp);
			pstmt.setString(6, email);
			pstmt.setInt(7, point);

			pstmt.executeUpdate();

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

	public void tableWrite() {
		// 테이블 초기화
		model.setRowCount(0);

		// connection, preapare....

		// sql...번호 오름차순으로 조회
		String sql = "select * from member order by num asc";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		conn = getConnection();
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();

			// 조회할 행이 1개 이상일때는 무조건 while
			while (rs.next()) {

				Vector<String> data = new Vector<String>();
				data.add(rs.getString("num"));
				data.add(rs.getString("id"));
				data.add(rs.getString("password"));
				data.add(rs.getString("name"));
				data.add(rs.getString("birthday"));
				data.add(rs.getString("hp"));
				data.add(rs.getString("joindate"));
				data.add(rs.getString("email"));
				data.add(rs.getString(String.valueOf("point")));

				// 테이블에 추가
				model.addRow(data);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

	/// 회원삭제메소드
	public void deleteData2(String num) {

		System.out.println("num=" + num);
		String sql = "delete from member where num=" + num;

		// sql문 실행후 해당번호가 없으면 메세지, 삭제되면 tablewrite()호출
		Connection conn = null;
		Statement stmt = null;

		conn = getConnection();
		try {
			stmt = conn.createStatement();

			int a = stmt.executeUpdate(sql);

			if (a == 0)
				JOptionPane.showMessageDialog(this, "없는 데이터 번호입니다.");
			else
				tableWrite();

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob = e.getSource();
		if (ob == btn1) {
			tableWrite();

		} else if (ob ==btn2){
			
			String num=JOptionPane.showInputDialog("수정할 데이터의 번호를 입력하시오");
			
			String sql="select * from member where num="+num;
			
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs =null;
			
			conn=getConnection();
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				if(rs.next()){
					//수정창에 기존 해당데이터 값을 가져와야함
					updateFrame2.num=num;
					updateFrame2.tfid.setText(rs.getString("id"));
					updateFrame2.tfpw.setText(rs.getString("password"));
					updateFrame2.tfname.setText(rs.getString("name"));
					updateFrame2.tfbd.setText(rs.getString("birthday"));
					updateFrame2.tfhp.setText(rs.getString("hp"));
					updateFrame2.tfjoin.setText(rs.getString("joindate"));
					updateFrame2.tfemail.setText(rs.getString("email"));
					updateFrame2.tfpoint.setText(rs.getString(String.valueOf("point")));
					
					
					
					updateFrame2.setVisible(true);
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}finally{
				
				try {
					rs.close();
					pstmt.close();
					conn.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
			
			
		} else if (ob == updateFrame2.btnMod) {
			updateData();
			tableWrite();
			
			updateFrame2.setVisible(false);
			
		}else if(ob==btn4)
	{

		String num = JOptionPane.showInputDialog("삭제할 데이터의 번호를 입력하시오");
		deleteData2(num);
	}
	}
	public static void main(String[] args) {
// TODO Auto-generated method stub

		new Manager("관리자창");
		
		
}
}
