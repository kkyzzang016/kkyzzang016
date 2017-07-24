package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBEx3 {
	public DBEx3() {
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
		//select and where
		//System.out.print("사용자 아이디를 입력해주세요!");
		//String userid = new Scanner(System.in).next();
		String sql = "select * from member";
		//String sql = "select * from member where userid ='"+userid+"'";
		Statement stmt = null;
		ResultSet rs = null;
		
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
			try {
				
				ResultSetMetaData rsmd = rs.getMetaData();
				while(rs.next()) {
					/*//rs.getString(컬럼명) or (컬럼인덱스) 모두 출력하시오.
					System.out.print(rs.getString(1)+" ");
					System.out.print(rs.getString(2)+" ");
					System.out.println(rs.getString(3)+" ");
					System.out.println(rs.getString("name"));*/
				
				
				for(int i=1;i<=rsmd.getColumnCount();i++) {
					System.out.print(rs.getString(i));
				}
				System.out.println();
				}
				//where
			/*	if(rs.next()) {
					System.out.print("검색된 정보는 : ");
					System.out.print(rs.getString(1)+" ");
					System.out.print(rs.getString(2)+" ");
					System.out.println(rs.getString(3)+" ");
				}*/
				
				}catch(SQLException e) {
					e.printStackTrace();
				}finally {
					try {
						rs.close();
						stmt.close();
						conn.close();
					}catch(SQLException e) {
						e.printStackTrace();
					}
			}
	}
	
	public static void main(String[] args) {
		new DBEx3();
	}
}
