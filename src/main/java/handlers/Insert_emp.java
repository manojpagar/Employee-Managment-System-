package handlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bin.emp_bo;
import dao.login_dao;

/**
 * Servlet implementation class Insert_emp
 */
@WebServlet("/Insert_emp")
public class Insert_emp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Insert_emp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
	    response.setContentType("text/html");
	    PrintWriter pw=response.getWriter();
	    
	    
	    String id=request.getParameter("id");
	    String name =request.getParameter("name");
	    String email =request.getParameter("email");
	    String phone =request.getParameter("phone");
	    String doj =request.getParameter("doj");
	    String dob =request.getParameter("dob");
	    String adhar =request.getParameter("adhar");
	    
	    emp_bo eb = new emp_bo(id, name, email, phone, doj, dob, adhar);
	    
	    int status=login_dao.addEmployee(eb);
		
		if(status>0)
		{
			System.out.println("Employee_add successfully");
			pw.print("Employee_add successfully");
			RequestDispatcher rd=request.getRequestDispatcher("home.html");
			rd.forward(request,response);
		}
		else
		{
			pw.print("Something wrong plese try again  <br>");
			RequestDispatcher rd=request.getRequestDispatcher("Insert.html");
			rd.include(request,response);
		}
	    
	}

}
