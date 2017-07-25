package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DBEx6 {
   public Scanner scan;

   public String inputStr() {
      return scan.next();
   }

   public DBEx6() {
      // TODO Auto-generated constructor stub
      scan = new Scanner(System.in);
      String user = "root";
      String pw = "oracle";
      Connection conn = null;

      try {
         // Driver Loading
         Class.forName("com.mysql.jdbc.Driver");
         System.out.println("Driver successful");
         // DB Connection
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", user, pw);
         System.out.println("Connection successful");
      } catch (SQLException e) {
         e.printStackTrace();
      } catch (ClassNotFoundException ex) {
         ex.printStackTrace();
      }

      // delete and where
      System.out.print("���̵� �Է����ּ��� : ");
      String userid = inputStr();

      // delete member where userid='userid';
      //String sql = "delete from member where userid = '" + userid + "'";
      String sql = "delete from member where userid=?";
      // ex) PreparedStatement ����Ͻÿ�
      // String sql = �ڵ带 �ۼ��غ�����

      //Statement stmt = null;
      PreparedStatement pstmt =null;
      int result = -1;
      try {
         //stmt = conn.createStatement();
    	  pstmt = conn.prepareStatement(sql);
    	  pstmt.setString(1, userid);
        // result = stmt.executeUpdate(sql);
    	  result = pstmt.executeUpdate();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      System.out.println("��� : "+(result < 0 ? "����" : "����"));
   }

   public static void main(String[] args) {
      new DBEx6();
   }
}