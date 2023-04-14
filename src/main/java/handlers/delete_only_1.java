package handlers;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bin.emp_bo;
import dao.login_dao;

/**
 * Servlet implementation class delete_only_1
 */
@WebServlet("/delete_only_1")
public class delete_only_1 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public delete_only_1() {
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
		
		pw.print("<html>");
		pw.print("<head><title>Delete Employee</title>");
		pw.print("<style>");
		pw.print("table {");
		pw.print("  border-collapse: collapse;");
		pw.print("  width: 100%;");
		pw.print("}");

		pw.print("th, td {");
		pw.print("  text-align: left;");
		pw.print("  padding: 8px;");
		pw.print("}");

		pw.print("tr:nth-child(even){");
		pw.print("  background-color: #f2f2f2;");
		pw.print("}");

		pw.print("th {");
		pw.print("  background-color: #4CAF50;");
		pw.print("  color: white;");
		pw.print("}");
		pw.print("</style>");
		pw.print("</head>");

		pw.print("<body>");
		pw.print("<a href='home.html' style=\"	display: inline-block; background-color: #007bff; color: white; padding: 8px 16px;text-align: center;text-decoration: none;font-size: 16px;margin: 8px 4px;border-radius: 4px;cursor: pointer;font-family: Arial, sans-serif; background-color: #0069d9 \" >Back</a>");

		
		pw.print("<table>");
		pw.print("<tr>");
		pw.print("<th>Id</th>");
		pw.print("<th>Name</th>");
		pw.print("<th>Email</th>");
		pw.print("<th>Phone</th>");
		pw.print("<th>Date Of Joining</th>");
		pw.print("<th>Date Of Birth</th>");
		pw.print("<th>Adhar Details</th>");
		pw.print("<th>Delete</th>");
		pw.print("</tr>");

		List<emp_bo> list = login_dao.fetch();

		for (emp_bo eb : list) {
		    pw.print("<tr>");
		    pw.print("<td>" + eb.getId() + "</td>");
		    pw.print("<td>" + eb.getName() + "</td>");
		    pw.print("<td>" + eb.getEmail() + "</td>");
		    pw.print("<td>" + eb.getPhone() + "</td>");
		    pw.print("<td>" + eb.getDoj() + "</td>");
		    pw.print("<td>" + eb.getDob() + "</td>");
		    pw.print("<td>" + eb.getAdhar() + "</td>");
		    pw.print("<td><a href='Deleting?id=" + eb.getId() + "'>Delete</a></td>");
		    pw.print("</tr>");
		}

		pw.print("</table>");
		pw.print("</body>");
		pw.print("</html>");

	}

}
