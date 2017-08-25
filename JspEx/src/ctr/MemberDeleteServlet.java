package ctr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDAO;

/**
 * Servlet implementation class memberDelete
 */
@WebServlet("/memberDelete.do")
public class MemberDeleteServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      doPost(request, response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      request.setCharacterEncoding("UTF-8");
      String userid = request.getParameter("id");
      MemberDAO mDao = MemberDAO.getInstance();
      int result = mDao.memberDelete(userid);
      String msg = result > 0 ? "회원탈퇴 되었습니다." : "다시 시도해주세요";
      request.setAttribute("msg", msg);
      
      HttpSession session = request.getSession();
      session.invalidate();
      
      RequestDispatcher dispatcher = request.getRequestDispatcher("/member/mainPage.jsp");
      dispatcher.forward(request, response);
      
   }

}