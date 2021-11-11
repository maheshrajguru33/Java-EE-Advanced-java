package com.onlineClass.Servlets;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.onlineClass.mgt.Teacher;
import com.onlineClass.mgt.TeacherDao;


public class AddTeacher extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AddTeacher() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		
		int id=Integer.parseInt(request.getParameter("teacherId"));
		String teachername =request.getParameter("teacherName");
		
		Teacher teacher=new Teacher(id, teachername);
		TeacherDao.saveTeacher(teacher);
		response.sendRedirect("teachers.jsp");
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
