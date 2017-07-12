package JavaExam_2W.Swing.TotoLadder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MainWindowMethod {

	String driver = "com.mysql.jdbc.Driver";
	String url = "jdbc:mysql://220.67.115.33:3306/stdt057";
	
	
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
	
	public MainWindowMethod(){
		
	try {
		Class.forName(driver);
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		System.out.println("오라클 드라이버 실패");
		}
	}

	public void charge(int n){
		
		String sql="update member set point=point+'"+n+"'where id='"+MainWindow.conid+"'";
		
		Connection conn=null;
		Statement stmt=null;
		
		conn=getConnection();
		try {
			stmt=conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			//System.out.println(n);
		}
	}
	public void poCheck(){
		
		String id=MainWindow.conid;
		String sql="select point from member where id='"+id+"'";
		
		Connection conn=null;
		Statement stmt=null;
		ResultSet rs=null;
		
		conn=getConnection();
		try {
			stmt=conn.createStatement();
			rs=stmt.executeQuery(sql);
			
			if(rs.next()){
			MainWindow.conpo=rs.getInt("point");
			System.out.println(rs.getInt("point"));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
public void returPo(int n){
		
		String sql="update member set point=point-'"+n+"'where id='"+MainWindow.conid+"'";
		
		Connection conn=null;
		Statement stmt=null;
		
		conn=getConnection();
		try {
			stmt=conn.createStatement();
			stmt.executeUpdate(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			try {
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

public void result(int n){
	
	String sql="update member set point=point+'"+n+"'where id='"+MainWindow.conid+"'";
	
	Connection conn=null;
	Statement stmt=null;
	
	conn=getConnection();
	try {
		stmt=conn.createStatement();
		stmt.executeUpdate(sql);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}finally{
		try {
			stmt.close();
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
public int gg(int n){
	if(MainWindow.betRs==1){
		if(MainWindow.ls==1&&MainWindow.tl==1&&MainWindow.jjak==1) n*=8;
		else if(MainWindow.ls==1&&MainWindow.tl==1&&MainWindow.jjak==3) n*=4;
		else if(MainWindow.ls==1&&MainWindow.tl==3&&MainWindow.jjak==1) n*=4;
		else if(MainWindow.ls==3&&MainWindow.tl==1&&MainWindow.jjak==1) n*=4;
		else if(MainWindow.ls==1&&MainWindow.tl==3&&MainWindow.jjak==3) n*=1;
		else if(MainWindow.ls==3&&MainWindow.tl==1&&MainWindow.jjak==3) n*=1;
		else if(MainWindow.ls==3&&MainWindow.tl==3&&MainWindow.jjak==1) n*=1;
		else n*=-1;
	}
	else if(MainWindow.betRs==2){
		if(MainWindow.ls==1&&MainWindow.fl==1&&MainWindow.hol==1) n*=8;
		else if(MainWindow.ls==1&&MainWindow.fl==1&&MainWindow.hol==3) n*=4;
		else if(MainWindow.ls==1&&MainWindow.fl==3&&MainWindow.hol==1) n*=4;
		else if(MainWindow.ls==3&&MainWindow.fl==1&&MainWindow.hol==1) n*=4;
		else if(MainWindow.ls==1&&MainWindow.fl==3&&MainWindow.hol==3) n*=1;
		else if(MainWindow.ls==3&&MainWindow.fl==1&&MainWindow.hol==3) n*=1;
		else if(MainWindow.ls==3&&MainWindow.fl==3&&MainWindow.hol==1) n*=1;
		else n*=-1;
	}
	else if(MainWindow.betRs==3){
		if(MainWindow.rs==1&&MainWindow.tl==1&&MainWindow.hol==1) n*=8;
		else if(MainWindow.rs==1&&MainWindow.tl==1&&MainWindow.hol==3) n*=4;
		else if(MainWindow.rs==1&&MainWindow.tl==3&&MainWindow.hol==1) n*=4;
		else if(MainWindow.rs==3&&MainWindow.tl==1&&MainWindow.hol==1) n*=4;
		else if(MainWindow.rs==1&&MainWindow.tl==3&&MainWindow.hol==3) n*=1;
		else if(MainWindow.rs==3&&MainWindow.tl==1&&MainWindow.hol==3) n*=1;
		else if(MainWindow.rs==3&&MainWindow.tl==3&&MainWindow.hol==1) n*=1;
		else n*=-1;
	}
	else if(MainWindow.betRs==4){
		if(MainWindow.rs==1&&MainWindow.fl==1&&MainWindow.jjak==1) n*=8;
		else if(MainWindow.rs==1&&MainWindow.fl==1&&MainWindow.jjak==3) n*=4;
		else if(MainWindow.rs==1&&MainWindow.fl==3&&MainWindow.jjak==1) n*=4;
		else if(MainWindow.rs==3&&MainWindow.fl==1&&MainWindow.jjak==1) n*=4;
		else if(MainWindow.rs==1&&MainWindow.fl==3&&MainWindow.jjak==3) n*=1;
		else if(MainWindow.rs==3&&MainWindow.fl==1&&MainWindow.jjak==3) n*=1;
		else if(MainWindow.rs==3&&MainWindow.fl==3&&MainWindow.jjak==1) n*=1;
		else n*=-1;
	}
	return n;
}
	
}
