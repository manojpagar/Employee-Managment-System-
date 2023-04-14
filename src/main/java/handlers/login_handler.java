package handlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bin.login_do;
import dao.login_dao;

/**
 * Servlet implementation class login_handler
 */
@WebServlet("/login_handler")
public class login_handler extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public login_handler() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		
		String l_name =request.getParameter("name");
		String l_email =request.getParameter("email");
		String l_pass =request.getParameter("pass_1");
		String l_pass_2 =request.getParameter("pass_2");
		
		login_do ps= new login_do(l_name, l_email, l_pass, l_pass_2);
		
		int status = login_dao.insert(ps);
		
		if(status>0)
		{
			pw.print("<center><h2><Data is inserted></h2></center>");
			RequestDispatcher rd=request.getRequestDispatcher("login.html");
			rd.include(request, response);
		}
		else
		{
			pw.print("somthing is wrong please try again...");
			RequestDispatcher rd=request.getRequestDispatcher("sign_up.html");
			rd.include(request, response);
		}
	}

}
