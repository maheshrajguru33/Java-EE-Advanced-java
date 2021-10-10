package com.learnsimpli.servlet;

import java.beans.Statement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class initDatabase extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public initDatabase() {
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
		
		try {
			// Step 1; Register your jdbc driver
			Class.forName("com.mysql.jdbc.Driver");
			
			String url = "jdbc:mysql://localhost:3306/userlogin";
			String username = "mahi123";
			String password = "Mahi@123";
			
			//Step 2; Getting the connection
			Connection connection = DriverManager.getConnection(url, username, password);
			
			//Step 3: Get the statement object
			java.sql.Statement statement= connection.createStatement();
			
			//Step 4: create the query and execute it.
			String sqlquery = "select * from user";
			
			//Step 5: Extract the result
			ResultSet resultSet = statement.executeQuery(sqlquery);
			
			PrintWriter out = response.getWriter();
			
			while(resultSet.next()) {
				String userempid = resultSet.getString(1);
				String empname = resultSet.getString(2);
				String salary = resultSet.getString(3);
				
				out.println("user id:-" +userempid + "user name :-"+empname +"salary:-"+ salary);
			}
			
			connection.close();
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
