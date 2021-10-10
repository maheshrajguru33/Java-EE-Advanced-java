package com.simplilearn.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public LoginServlet() {
      
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		
		ServletConfig servletConfig = getServletConfig();
		String userName=servletConfig.getInitParameter("Username");
		out.print("Username is"+ userName);
		
		ServletContext servletContext = getServletContext();
		String driverName = servletContext.getInitParameter("driver");
		out.print("<br> Driver name " + driverName);
		
		Enumeration<String> allParams = servletContext.getInitParameterNames();
		
		while(allParams.hasMoreElements()) {
			String eachParamKey = allParams.nextElement();
			String eachParamValue = servletContext.getInitParameter(eachParamKey);
			
			out.print("<br>"+eachParamKey+" "+ "fetched form servlet is " + eachParamValue);
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		doGet(request, response);
	}

}
