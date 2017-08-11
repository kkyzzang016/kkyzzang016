package ex;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEx6
 */
@WebServlet("/ServletEx6")
public class ServletEx6 extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public Connection conn;
   public Statement stmt;
   public ResultSet rs;

   public void init() {
      String user = "root";
      String pw = "oracle";
      try {
         // Driver Loading
         Class.forName("com.mysql.jdbc.Driver");
         // DB Connection
         System.out.println("Driver successful");
         Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/test", user, pw);
         System.out.println("Connection successful");
         stmt=conn.createStatement();
      } catch (Exception e) {
         e.printStackTrace();
      }
   }

   public int getUpdate(String sql) {
      int result = -1;
      try {
         result = stmt.executeUpdate(sql);
      } catch (SQLException e) {
         e.printStackTrace();
      }
      return result;
   }

   /**
    * @see HttpServlet#HttpServlet()
    */
   public ServletEx6() {
      super();
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	  
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {

     // doGet(request, response);
	   String name = request.getParameter("name");
	   String job = request.getParameter("job");
	   String age = request.getParameter("age");
      String sql = "insert into servletDB values('"+name+"', '"+job+"', '"+Integer.parseInt(age)+"')";
      getUpdate(sql);
      sql = "select * from servletDB";
      try{
         rs = stmt.executeQuery(sql);
         
      }catch (SQLException e) {
         // TODO: handle exception
         e.printStackTrace();
      }
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.println("<html>");
      out.println("<body><center><h2> * 회 원 정 보 * </h2><hr><br><p>");
      out.println("<table border = '1'>");
      out.println("<tr>");
      out.println("<td align = 'center'> 이 름 </td><td align = 'center'> 직업 </td><td align = 'center'> 나이 </td>");
      out.println("</tr>");
      try{
         while(rs.next()){
            out.println("<tr>");
            out.println("<td>" + rs.getString(1) + "</td>");
            out.println("<td>" + rs.getString(2) + "</td>");
            out.println("<td>" + rs.getInt(3) + "</td>");
            out.println("</tr>");
         }
      }catch (SQLException e) {
         // TODO: handle exception
         e.printStackTrace();
      }
      out.println("</table>");
      out.println("</body>");
      out.println("</html>");
      out.close();
   }

   public void destroy() {
      try {
         if (rs != null)
            rs.close();
         if (stmt != null)
            stmt.close();
         if (conn != null)
            conn.close();
      } catch (Exception e) {
         // TODO: handle exception
         e.printStackTrace();
      }
   }

}