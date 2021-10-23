package com.mahi;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class LoginController
 */
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username =request.getParameter("username");
		String password =request.getParameter("password");
		PrintWriter out= response.getWriter();
		
		RequestDispatcher rd=null;
		if(username.equalsIgnoreCase("Mahesh") && password.equals("Rajguru")) {
			rd=request.getRequestDispatcher("SuccessServlet");
			rd.forward(request, response);
			
		}else {
			out.println("Username or password is invalid");
			rd=request.getRequestDispatcher("login.html");
			
		}
			
		
	}

}
