package ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletEx4
 */
@WebServlet("/ServletEx4")
public class ServletEx4 extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletEx4() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      response.getWriter().append("Served at: ").append(request.getContextPath());
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      response.setContentType("text/html;charset=UTF-8");
      PrintWriter out = response.getWriter();
      out.print("<html><body>");
      String items[] = request.getParameterValues("item");
      if(items == null){
         out.print("������ �׸��� �����ϴ�.");
      }else{
         out.println("����� ������ �׸��Դϴ�.<hr>");
         for(String item : items){
            out.print(item + " ");
         }
      }
      out.println("<br><a href = 'javascript:history.go(-1)'>�ٽ�</a>");
      out.print("</body></html>");
      out.close();
   }

}