package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.Scanner;

public class DBEx7 {

	Scanner sc;
	public String inputStr() {
		return sc.next();
	}
	public DBEx7() {
		sc = new Scanner(System.in);
		DBAction db = DBAction.getInstance();
		Connection conn = db.getConnection();
		
		//String sql = "select * from member order by name asc";
		
		String sql = "select * from member " + " limit 2, 5";
		
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ResultSetMetaData rsmd = null;
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			rsmd = rs.getMetaData();
			int cols = rsmd.getColumnCount();
			
			while(rs.next()) {
				for(int i=1;i<=cols;i++) {
					System.out.print(rs.getString(i)+"\t");
				}
				System.out.println();
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				pstmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
	public static void main(String[] args) {
		new DBEx7();
	}
}
