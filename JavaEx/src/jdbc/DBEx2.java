package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;



public class DBEx2 {
	
	
	public DBEx2() {
		String user = "root";
		String pw = "oracle";
		Connection conn = null;
		try {
			//Driver Loading
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Successful ");

			//DB Connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",user,pw);
			System.out.println("Connection Successful ");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		//insert
		String name = "À¯½ÂÃ¶";
		String userid = "½ÂÃ¶";
	
		String sql ="insert into member(name, userid) values ('"+name+"', '"+userid+"')";
		
		Statement stmt=null;
		int result = -1;
		try {
		stmt = conn.createStatement();
		result = stmt.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				conn.close();
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		System.out.println(result< 0 ? "½ÇÆÐ!" : "¼º°ø!");
	}
	public static void main(String[] args) {
		new DBEx2();
	}
}
