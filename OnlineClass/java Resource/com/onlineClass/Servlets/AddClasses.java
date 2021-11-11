package com.onlineClass.Servlets;

import java.io.IOException;


import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineClass.mgt.Classes;
import com.onlineClass.mgt.ClassesDao;



public class AddClasses extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddClasses() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("classId"));
		String classname =request.getParameter("className");
		
		Classes classes=new Classes(id, classname);
		ClassesDao.saveClasses(classes);
		response.sendRedirect("classes.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
