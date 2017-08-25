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
 * Servlet implementation class UpdateServlet
 */
@WebServlet("/memberUpdate.do")
public class MemberUpdateServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

   /**
    * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      request.setCharacterEncoding("UTF-8");
      String userid = request.getParameter("id");
      MemberDAO mDao = MemberDAO.getInstance();
      
      UserInfo mVo = mDao.getMember(userid);
      System.out.println(mVo.getId()+"id");
      request.setAttribute("mVo", mVo);
      RequestDispatcher dispatcher = request.getRequestDispatcher("/member/memberUpdate.jsp");
      //UpdateForm.jsp : 수정 폼 페이지로 이동(Request Scope)
      dispatcher.forward(request, response);
   }

   /**
    * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
    */
   protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      // TODO Auto-generated method stub
      request.setCharacterEncoding("UTF-8");
      String userid = request.getParameter("id");
      String pwd = request.getParameter("pass");
      String name = request.getParameter("name");
      String regist = request.getParameter("regist");
      
      UserInfo user = new UserInfo();
      user.setId(userid);
      user.setPass(pwd);
      user.setName(name);
      user.setRegist(regist);
      
      MemberDAO mDao = MemberDAO.getInstance();
      mDao.updateMember(user);
      response.sendRedirect("/member/mainPage.jsp"); //mainPage.jsp로 이동하기
   }

}