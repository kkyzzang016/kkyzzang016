package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBEx5 {

	public DBEx5() {
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
		System.out.println("���̵� �Է����ּ���!");		// �������� �Ǵ� ����� ����
		String userid = new Scanner(System.in).next();
		System.out.println("��ȣ�� �Է����ּ���!");
		String pwd = new Scanner(System.in).next();
		System.out.println("�̸��� �Է����ּ���!");
		String name = new Scanner(System.in).next();
		
		//String sql = "update member set name='"+name+"', pwd = '"+pwd+"' where userid ='"+userid+"'";
		String sql = "update member set name=?, pwd=? where userid=?";
		PreparedStatement pstmt= null;
		int result = -1;
		try {
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, name);
			pstmt.setString(2, pwd);
			pstmt.setString(3, userid);
			result = pstmt.executeUpdate();
			/*stmt = conn.createStatement();
			stmt.executeUpdate(sql);*/
		} catch (SQLException e) {
			e.printStackTrace();
		}
		System.out.println("��� : "+ (result<0 ? "����" : "����"));
	}
	
	public static void main(String[] args) {
		new DBEx5();
	}
}
