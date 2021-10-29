package com.Servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class SearchProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public SearchProduct() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		String id=request.getParameter("Id");
		out.print("<h1> Display the product Information</h1>");
		out.print("<table border='1'><tr><th>Id</th><th>Prod_Name</th><th>price</th><th>Product company</th></tr>");
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/productdata","Mahi123","Mahi@123");
			
			Statement stat=con.createStatement();
			ResultSet rs=stat.executeQuery("select * from product where id="+id+"");
			
			while(rs.next()) {
				out.print("<tr><td>");
				out.println(rs.getInt(1));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(2));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getInt(3));
				out.print("</td>");
				out.print("<td>");
				out.println(rs.getString(4));
				out.print("</td>");
				out.print("</tr>");
				
			}
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		out.print("</table>");
	}
	

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		

	}
}
