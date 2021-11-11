package com.onlineClass.Servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.onlineClass.mgt.Student;
import com.onlineClass.mgt.StudentDao;

@WebServlet("/")
public class ReadStudents extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ReadStudents() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		
		int id=Integer.parseInt(request.getParameter("studentId"));
		String studentname =request.getParameter("studentName");
		
		Student student=new Student(id, studentname);
		StudentDao.saveStudent(student);
		response.sendRedirect("students.jsp");
	}
			
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}