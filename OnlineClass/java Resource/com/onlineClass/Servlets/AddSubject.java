package com.onlineClass.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.onlineClass.mgt.Subject;
import com.onlineClass.mgt.SubjectDao;


public class AddSubject extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public AddSubject() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("subjectId"));
		String subjectname =request.getParameter("subjectName");
		
		
		
		Subject subject=new Subject(id, subjectname);
		SubjectDao.saveSubject(subject);
		response.sendRedirect("subjects.jsp");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
