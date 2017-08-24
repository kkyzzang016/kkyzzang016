package ctr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.UserInfo;
import dao.MemberDAO;

/**
 * Servlet implementation class joinServlet
 */
//@WebServlet("/joinServlet")
@WebServlet("/join.do")
public class JoinServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public JoinServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      RequestDispatcher dispatcher = request.getRequestDispatcher("/member/memberForm.jsp");
      dispatcher.forward(request, response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      request.setCharacterEncoding("UTF-8");
      String id = request.getParameter("id");
      String pass = request.getParameter("pass");
      String name = request.getParameter("name");
      String regist = request.getParameter("regist");
      UserInfo user = new UserInfo();
      user.setId(id);
      user.setPass(pass);
      user.setName(name);
      user.setRegist(regist);
      //MemberDAO class 생성
      MemberDAO mDao = MemberDAO.getInstance();
      int result = mDao.insertMember(user);
      HttpSession session = request.getSession();
      if(result == 1) {
         session.setAttribute("userid", user.getId());
         request.setAttribute("message", "회원 가입에 성공했습니다.");
      }else {
         request.setAttribute("message", "회원 가입에 실패했습니다.");
      }
      
      RequestDispatcher dispatcher = request.getRequestDispatcher("/member/login.jsp");
      dispatcher.forward(request, response);
   }

}