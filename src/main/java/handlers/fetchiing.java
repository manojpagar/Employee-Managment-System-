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
 * Servlet implementation class fetchiing
 */
@WebServlet("/fetchiing")
public class fetchiing extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public fetchiing() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		   PrintWriter pw=response.getWriter();
		   
		   pw.print("<a href='home.html' style=\"	display: inline-block; background-color: #007bff; color: white; padding: 8px 16px;text-align: center;text-decoration: none;font-size: 16px;margin: 8px 4px;border-radius: 4px;cursor: pointer;font-family: Arial, sans-serif; background-color: #0069d9 \" >Back</a>");
		   
		   pw.print("<table border='1px' width='100%' style='border-collapse: collapse; text-align: center; background-color: #ffffff;'>");
		   pw.print("<tr style='background-color: #f2f2f2;'> <th> Id </th> <th> Name </th> <th> Email </th> <th> Phone "
		           + "</th> <th> Date Of Joining</th> <th> Date Of Birth</th>"
		           + " <th> Adhar Details</th></tr>");

		   List<emp_bo> list = login_dao.fetch();

		   for (emp_bo eb : list) {
		       pw.print("<tr><td>" + eb.getId() + "</td><td>" + eb.getName() + "</td><td>" + eb.getEmail() + "</td><td>" + eb.getPhone() + "</td><td>" + eb.getDoj() + "</td><td>" + eb.getDob() + "</td><td>" + eb.getAdhar() + "</td></tr>");
		   }

		   pw.print("</table>");

	
	}

}
