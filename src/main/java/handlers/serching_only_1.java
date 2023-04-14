package handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import bin.emp_bo;
import dao.login_dao;


/**
 * Servlet implementation class serching_only_1
 */
@WebServlet("/serching_only_1")
public class serching_only_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public serching_only_1() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
		pw.print("<a href='home.html' style=\"	display: inline-block; background-color: #007bff; color: white; padding: 8px 16px;text-align: center;text-decoration: none;font-size: 16px;margin: 8px 4px;border-radius: 4px;cursor: pointer;font-family: Arial, sans-serif; background-color: #0069d9 \" >Back</a>");

		
		String id=request.getParameter("id");
		emp_bo e=new emp_bo();
		   e.setId(id);
	
		    int status=0;
		    List<emp_bo> ob=login_dao.Search_employee(e);
			  
	
			  
			  for(emp_bo el:ob)
			  {
				  pw.print("<h3>Employee Found</h3>");
				  pw.print("<table border='1px' width='100%' style='border-collapse: collapse; text-align: center; background-color: #ffffff;'>");
				   pw.print("<tr style='background-color: #f2f2f2;'> <th> Id </th> <th> Name </th> <th> Email </th> <th> Phone "
				           + "</th> <th> Date Of Joining</th> <th> Date Of Birth</th>"
				           + " <th> Adhar Details</th></tr>");
			       pw.print("<tr><td>" + el.getId() + "</td><td>" + el.getName() + "</td><td>" + el.getEmail() + "</td><td>" + el.getPhone() + "</td><td>" + el.getDoj() + "</td><td>" + el.getDob() + "</td><td>" + el.getAdhar() + "</td></tr>");
				  status++;}
			  pw.print("</table>");
			  
		    if(status>0)
			  {
				  
				  pw.close();
				  RequestDispatcher rd=request.getRequestDispatcher("Search_employee.html");
				  rd.forward(request, response);
				  
				 
			  }
		    else
			  {
				  pw.print("<br><h3>Employee Not Found</h3>");
				  RequestDispatcher rd=request.getRequestDispatcher("Search_employee.html");
				  rd.include(request, response);
				  pw.close();
			  }
		    
		
	}

}
