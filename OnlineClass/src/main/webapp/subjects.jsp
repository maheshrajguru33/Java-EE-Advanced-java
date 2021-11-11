<%@page import="java.sql.DriverManager"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Statement"%>
<%@page import="java.sql.Connection"%>



<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Student Data</title>
</head>
	 
<body>
</head>
<body>
<h1>Add Subjects</h1>
	<div align="Left">
	
	<form action="AddSubject" method="get">
			Subject Id		  :	<input type="text" name="subjectId"/><br><br>
		Enter Subjects Name	  : <input type="text" name="subjectName"/><br><br>
			
			
		<br>
		<input type="submit" value="AddSubject">
	</form>
	</div>
</body>
</html>
	
	<h1>Subjects List</h1>
	
<%
String id = request.getParameter("userId");
String driverName = "com.mysql.jdbc.Driver";
String connectionUrl = "jdbc:mysql://localhost:3306/";
String dbName = "learnersacademy";
String userId = "Mahi123";
String password = "Mahi@123";

try {
Class.forName(driverName);
} catch (ClassNotFoundException e) {
e.printStackTrace();
}

Connection connection = null;
Statement statement = null;
ResultSet resultSet = null;
%>
<h2 align="center"><font><strong> Show Students</strong></font></h2>
<table align="center" cellpadding="5" cellspacing="5" border="1">
<tr>

</tr>
<tr bgcolor="green">
<td><b>Subjects Id</b></td>
<td><b>Subjects Name</b></td>

</tr>
<%
try{ 
connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
statement=connection.createStatement();
String sql ="SELECT * FROM subjects";

resultSet = statement.executeQuery(sql);
while(resultSet.next()){
%>
<tr bgcolor="gray">

<td><%=resultSet.getString("subjectId") %></td>
<td><%=resultSet.getString("subjectName") %></td>

</tr>
	
<% 
 
}

} catch (Exception e) {
e.printStackTrace();
}
%>
</table>
