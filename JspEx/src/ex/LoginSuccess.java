package ex;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginSuccess
 */
@WebServlet("/LoginSuccess")
public class LoginSuccess extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public ServletContext sc;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginSuccess() {
        super();
        // TODO Auto-generated constructor stub
    }

    public void init(ServletConfig config) throws ServletException{
    	sc = config.getServletContext();
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
		RequestDispatcher rd1 =sc.getRequestDispatcher("/Header");
		RequestDispatcher rd2 =sc.getRequestDispatcher("/Footer");
		
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		rd1.include(request, response);
		out.println("<h3>"+request.getParameter("name")+"님 환영합니다!!!!</h3>");
		rd2.include(request, response);
		out.close();
	}

}
