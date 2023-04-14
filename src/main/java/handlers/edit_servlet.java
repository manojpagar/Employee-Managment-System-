package handlers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bin.emp_bo;
import dao.login_dao;

/**
 * Servlet implementation class edit_servlet
 */
@WebServlet("/edit_servlet")
public class edit_servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public edit_servlet() {
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
		
		login_dao.getElementbyId(id);
		
		emp_bo eb=login_dao.getElementbyId(id);
		
		pw.print("<style>");
		pw.print("table {");
		pw.print("  border-collapse: collapse;");
		pw.print("  width: 100%;");
		pw.print("}");
		pw.print("th, td {");
		pw.print("  text-align: left;");
		pw.print("  padding: 8px;");
		pw.print("}");
		pw.print("th {");
		pw.print("  background-color: #4CAF50;");
		pw.print("  color: white;");
		pw.print("}");
		pw.print("tr:nth-child(even) {");
		pw.print("  background-color: #f2f2f2;");
		pw.print("}");
		pw.print("</style>");

		pw.print("<form action ='Update_controler' method='get'>");
		pw.print("<table>");
		pw.print("<tr>");
		pw.print("<th></th><th></th>");
		pw.print("</tr>");

		pw.print("<tr><td>ID:</td><td><input type='hidden' name='id' value='"+eb.getId()+"'/></td></tr>");  
		pw.print("<tr><td>Name:</td><td><input type='text' name='name' value='"+eb.getName()+"'/></td></tr>");
		pw.print("<tr><td>Email:</td><td><input type='text' name='email' value='"+eb.getEmail()+"'/></td></tr>");
		pw.print("<tr><td>Phone:</td><td><input type='text' name='phone' value='"+eb.getPhone()+"'/></td></tr>");
		pw.print("<tr><td>Date of Joining:</td><td><input type='text' name='doj' value='"+eb.getDoj()+"'/></td></tr>");
		pw.print("<tr><td>Date of Birth:</td><td><input type='text' name='dob' value='"+eb.getDob()+"'/></td></tr>");
		pw.print("<tr><td>Adhar Card:</td><td><input type='text' name='adhar' value='"+eb.getAdhar()+"'/></td></tr>");
		pw.print("<tr><td></td><td><input type='submit' value='Update'/></td></tr>");

		pw.print("</table>");
		pw.print("</form>");

	
	}

}
