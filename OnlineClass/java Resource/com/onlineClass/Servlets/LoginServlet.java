package com.onlineClass.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import javax.servlet.http.HttpSession;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public LoginServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String action = request.getServletPath();
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		System.out.println("Username :- "+ username + " Password :- "+ password);
		

		if (username == null | "".equals(username)) {
			response.sendRedirect("invalid.jsp?error=1");
		} else if (password == null | "".equals(password)) {
			response.sendRedirect("invalid.jsp?error=2");
		} else {
			if ("MaheshRajguru".equals(username) && "Rajguru@123".equals(password)) {
				HttpSession session = request.getSession();
				session.setAttribute("username", username);
				request.getRequestDispatcher("Dashboard.jsp").forward(request, response);
			}
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
		
		
	}
}