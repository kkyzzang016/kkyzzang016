package ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEx1
 */
@WebServlet("/ServletEx1")
public class ServletEx1 extends HttpServlet {
   private static final long serialVersionUID = 1L;

   /**
    * Default constructor.
    */
   public ServletEx1() {
      // TODO Auto-generated constructor stub
   }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      response.setContentType("text/html;charset=UTF-8");
      String result = null;
      PrintWriter out = response.getWriter();
      String id = "abc";
      String pw = "123";
      String req_id = request.getParameter("id");
      String req_pw = request.getParameter("pw");

      out.print("<html><body><h1>");
      if (req_id.equals(id)) {
         if (req_pw.equals(pw)){
            out.print(id + "님 환영합니다.");
         } else {
         out.println("");
         }
      }else{
         out.println("아이디 실패");
      }
      out.print("</h1></body></html>");
      out.close();
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
    *      response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
      // TODO Auto-generated method stub
      doGet(request, response);
   }

}