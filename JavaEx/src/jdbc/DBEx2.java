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
		String name = "";
		String userid = "";
		String pwd = "";
		
		
		Scanner sc = new Scanner(System.in);
		System.out.println("이름을 입력하세용!");
		name=sc.nextLine();
		System.out.println("아이디를 입력하세용!");
		userid = sc.nextLine();
		System.out.println("비밀번호를 입력하세요!");
		pwd = sc.nextLine();
		
		String sql ="insert into member(name, userid, pwd) values ('"+name+"', '"+userid+"', '"+pwd+"')";
		
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
		System.out.println(result< 0 ? "실패!" : "성공!");
	}
	public static void main(String[] args) {
		new DBEx2();
	}
}
