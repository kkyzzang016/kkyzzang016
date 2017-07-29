package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBEx4 {

	public DBEx4() {
		Connection conn = null;
		String user = "root";
		String pwd = "oracle";
		//String sql = "create table client(id varchar(10) primary key, pw varchar(10), name varchar(10), account int, money int, phone varchar(12))";
		Scanner sc = new Scanner(System.in);
		System.out.println("아이디를 입력해주세요!");
		String id = sc.nextLine();
		System.out.println("비밀번호를 입력해주세요!");
		String pw = sc.nextLine();
		System.out.println("이름 입력해주세요!");
		String name = sc.nextLine();
		System.out.println("계좌번호를 입력해주세요!");
		String account = sc.nextLine();
		System.out.println("돈을 입력해주세요!");
		String money = sc.nextLine();
		System.out.println("휴대폰번호를 입력해주세요!");
		String phone = sc.nextLine();
		String sql = "insert into client (id, pw, name, account, money,phone) values ('"+id+"', '"+pw+"', '"+name+"', '"+Integer.parseInt(account)+"', '"+
		Integer.parseInt(money)+"','"+phone+"')";
		
		try {
			//Driver Loading
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("Driver Successful ");

			//DB Connection
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test",user,pwd);
			System.out.println("Connection Successful ");
		}catch(SQLException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		Statement stmt=null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			stmt.executeUpdate(sql);
		}catch(SQLException e) {
			e.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new DBEx4();
	}
}
