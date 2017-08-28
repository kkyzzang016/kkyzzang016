package ctr;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import bean.EmployeesBean;
import bean.UserInfo;
import dao.EmployeesDAO;
import dao.MemberDAO;

/**
 * Servlet implementation class LoginServlet
 */
//@WebServlet("/LoginServlet") 
@WebServlet("/loginemp.do")
public class LoginServlet_emp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet_emp() {
        super();
        // TODO Auto-generated constructor stub
        
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String url = "/employees/login.jsp";
		HttpSession session = request.getSession();
		if(session.getAttribute("userid") != null) {
			url="/employees/mainPage.jsp";
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(url);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		String reqPage = "/employees/login.jsp";
		
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		
		EmployeesDAO eDao = EmployeesDAO.getInstance();
		int result = eDao.userCheck(id, pass);
		
		if(result ==1) {
			EmployeesBean Vo = eDao.getMember(id);
			HttpSession session = request.getSession();
			
			session.setAttribute("loginUser", Vo);
			request.setAttribute("employees", "ȸ�� ���Կ� �����߽��ϴ�.");
			reqPage = "/employees/mainPage.jsp";
			
		}else if(result==0) {
			request.setAttribute("message", "��й�ȣ�� ���� �ʽ��ϴ�.");
		}else if(result==-1) {
			request.setAttribute("message", "�������� �ʴ� ȸ���Դϴ�.");
		}
		RequestDispatcher dispatcher = request.getRequestDispatcher(reqPage);
		dispatcher.forward(request, response);
	}

}
