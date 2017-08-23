package db;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBAction {
   public static DBAction instance = new DBAction();
   public Connection conn = null;

   public DBAction() {
      String user = "root";
      String pw = "oracle";
      try {
         // Driver loading
         Class.forName("com.mysql.jdbc.Driver");
         System.out.println("Driver successful");
         // db connection
         conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", user, pw);
         System.out.println("Connection successful");
      } catch (SQLException e) {
         e.printStackTrace();
      } catch (ClassNotFoundException ex) {
         ex.printStackTrace();
      }
   }

   public static DBAction getInstance() {
      if (instance == null) {
         instance = new DBAction();
      }
      return instance;
   }

   public Connection getConnection() {
      return conn;
   }
}