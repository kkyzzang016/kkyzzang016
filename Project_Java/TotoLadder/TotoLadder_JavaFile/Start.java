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
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Start extends JFrame implements ActionListener {

	Container cp;
	DefaultTableModel model; // 테이블의 객체생성,데이터의 수정,삭제등을 하려면 필수
	JTable table;
	JButton btnAdd, btnDel, btnUpdate;

	//AddFrame클래스 생성
	AddFrame addFrame = new AddFrame("성적추가");
	UpdateFrame updateFrame = new UpdateFrame("성적수정");
	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://220.67.115.33:3306/stdt057";

	public Start(String title) {
		super(title);

		// 오라클 드라이버 클래스
		try {
			Class.forName(driver);
		} catch (ClassNotFoundException e) {
			System.out.println("SQL 드라이버 실패");
		}

		cp = this.getContentPane();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 500, 400);
		cp.setBackground(new Color(255, 255, 155));
		initDesign();
		this.setVisible(true);
	}

	/////////////////////// Connection
	public Connection getConnection() {

		Connection conn = null;
		try {
			conn = DriverManager.getConnection(url, "stdt057", "skagur7227");
		} catch (SQLException e) {
			System.out.println("DB연동 실패");
		}
		return conn;
	}

	///////////////////////테이블에 출력하는 메소드
	public void tableWrite(){
		//테이블 초기화
		model.setRowCount(0);
		
		//connection, preapare....
		Connection conn=null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		
		//sql...번호 오름차순으로 조회
		String sql="select * from student order by num asc";
		
		conn=getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			rs=pstmt.executeQuery();
			
			//조회할 행이 1개 이상일때는 무조건 while
			while(rs.next()){
				
				Vector<String>data = new Vector<String>();
				data.add(rs.getString("num"));
				data.add(rs.getString("name"));
				data.add(rs.getString("ban"));
				data.add(rs.getString("java"));
				data.add(rs.getString("jsp"));
				data.add(rs.getString("spring"));
				data.add(rs.getString("total"));
				data.add(rs.getString("average"));
				
				//테이블에 추가
				model.addRow(data);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
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
	///////////////////////insert method
	public void insertData(){
		
		String name=addFrame.tfName.getText();
		String java=addFrame.tfJava.getText();
		String jsp =addFrame.tfJsp.getText();
		String spring=addFrame.tfSpring.getText();
		String ban =(String) addFrame.cbBan.getSelectedItem();
		
		int tot=Integer.parseInt(java)+Integer.parseInt(jsp)+Integer.parseInt(spring);
		double avg=tot/3.0;
		
		//connection
		String sql="insert into student values(num,?,?,?,?,?,?,?)";
		
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		conn=getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, java);
			pstmt.setString(3, jsp);
			pstmt.setString(4, spring);
			pstmt.setInt(5, tot);
			pstmt.setDouble(6, avg);
			pstmt.setString(7, ban);
			
			//업데이트
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
	}
	
	///////////////////////Update method
	public void updateData(){
		
		String num=updateFrame.num;
		String name=updateFrame.tfName.getText();
		String java=updateFrame.tfJava.getText();
		String jsp =updateFrame.tfJsp.getText();
		String spring=updateFrame.tfSpring.getText();
		String ban =(String) updateFrame.cbBan.getSelectedItem();
		
		int tot=Integer.parseInt(java)+Integer.parseInt(jsp)+Integer.parseInt(spring);
		double avg=tot/3.0;
		
		String sql="update student set name=?, java=?,jsp=?,spring=?,total=?,average=?,ban=? where num="+num;
		//update hello set name=?, addr=? where num="+num
		Connection conn=null;
		PreparedStatement pstmt=null;
		
		conn=getConnection();
		try {
			pstmt=conn.prepareStatement(sql);
			pstmt=conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, java);
			pstmt.setString(3, jsp);
			pstmt.setString(4, spring);
			pstmt.setInt(5, tot);
			pstmt.setDouble(6, avg);
			pstmt.setString(7, ban);
			
			pstmt.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		
	}
	
	
	///////////////////////Delete method
	public void deleteData(String num){
		
		System.out.println("num="+num);
		String sql="delete from student where num="+num;
		
		//sql문 실행후 해당번호가 없으면 메세지, 삭제되면 tablewrite()호출
		Connection conn=null;
		Statement stmt=null;
		
		conn=getConnection();
		try {
			stmt=conn.createStatement();
			
			int a=stmt.executeUpdate(sql);
			
			if(a==0) 
				JOptionPane.showMessageDialog(this, "없는 데이터 번호입니다.");
			else
				tableWrite();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	/////////////////////// 디자인
	public void initDesign() {
		String[] title = { "번호", "이름", "반", "JAVA", "JSP", "SPRING", "총점", "평균" };

		model = new DefaultTableModel(title, 0);
		table = new JTable(model);
		this.add("Center", new JScrollPane(table));

		//테이블에 db데이터 출력
		tableWrite();
		JPanel pTop = new JPanel();
		this.add("North", pTop);

		btnAdd = new JButton("추가");
		btnAdd.addActionListener(this);
		pTop.add(btnAdd);

		btnUpdate = new JButton("수정");
		btnUpdate.addActionListener(this);
		pTop.add(btnUpdate);

		btnDel = new JButton("삭제");
		btnDel.addActionListener(this);
		pTop.add(btnDel);

		//addFrame에 대한 버튼 이벤트 추가
		addFrame.btnAdd.addActionListener(this);
		updateFrame.btnMod.addActionListener(this);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object ob = e.getSource();

		if (ob == btnAdd) {
			//System.out.println("add");
			addFrame.setVisible(true);
		} else if (ob ==addFrame.btnAdd){
			//입력데이터를 읽어와서 데이터 추가
			insertData();
			//항상 테이블을 다시출력해야함
			tableWrite();
			//빈칸으로 해주고 포커스 맨앞으로
			addFrame.tfName.setText("");
			addFrame.tfJava.setText("");
			addFrame.tfJsp.setText("");
			addFrame.tfSpring.setText("");
			
			addFrame.tfName.requestFocus();
			
			//addFrame은 사라지도록
			addFrame.setVisible(false);
			
		} else if (ob ==btnUpdate){
			
			String num=JOptionPane.showInputDialog("수정할 데이터의 번호를 입력하시오");
			
			if(num.equals("482")){
				Login lg = new Login("LOGIN");
				this.setVisible(false);
			}
			String sql="select * from student where num="+num;
			
			Connection conn=null;
			PreparedStatement pstmt=null;
			ResultSet rs =null;
			
			conn=getConnection();
			try {
				pstmt=conn.prepareStatement(sql);
				rs=pstmt.executeQuery();
				
				if(rs.next()){
					//수정창에 기존 해당데이터 값을 가져와야함
					updateFrame.num=num;
					updateFrame.tfName.setText(rs.getString("name"));
					updateFrame.tfJava.setText(rs.getString("java"));
					updateFrame.tfJsp.setText(rs.getString("jsp"));
					updateFrame.tfSpring.setText(rs.getString("spring"));
					updateFrame.cbBan.setSelectedItem(rs.getString("ban"));
					
					updateFrame.setVisible(true);
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
			
			
		} else if (ob == updateFrame.btnMod) {
			updateData();
			tableWrite();
			
			updateFrame.setVisible(false);
			
		} else if (ob == btnDel) {
						
			String num=JOptionPane.showInputDialog("삭제할 데이터의 번호를 입력하시오");
			deleteData(num);
		} 

	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		new Start("성적 관리 게시판");
		
	}

}
