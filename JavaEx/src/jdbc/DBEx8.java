package jdbc;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DBEx8 {
   public DBEx8() {
      // TODO Auto-generated constructor stub
      DBAction db = DBAction.getInstance();
      Connection conn = db.getConnection();
      
      //ex1) 이름 '김'으로 시작하는 게시물(학생정보) 모두 검색
      String sql = "select * from member where name like '%화'";
      
      Statement stmt = null;
      ResultSet rs = null;
      ResultSetMetaData rsmd = null;
      try{
         stmt = conn.createStatement();
         rs = stmt.executeQuery(sql);
         rsmd = rs.getMetaData();
         int cols = rsmd.getColumnCount();
         while(rs.next()) {
        	 for(int i=1;i<=cols;i++) {
        		 System.out.println(rs.getString(i)+ "\t");
        	 }
        	 System.out.println();
         }
         
      }catch(SQLException e){
         e.printStackTrace();
      }finally {
			try {
				rs.close();
				stmt.close();
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
      }
   }
   public static void main(String[] args) {
      new DBEx8();
   }
}