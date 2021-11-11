

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Dashboard Page</title>

</head>
<body>
	<%
		String usernameSession = (String) session.getAttribute("username");
		if (session.getAttribute("username") == null) {
			response.sendRedirect("invalid.jsp?error=1");
		}
	%>
	<div class="container mt-3">
		<h2>Welcome to Learners Academy</h2>
		  <a href="logout.jsp"><span class="glyphicon glyphicon-log-out"></span> Logout</a><br><br>
		  <a href="students.jsp">View Students</a><br><br>
		  <a href="teachers.jsp"> <span class="glyphicon glyphicon">View Teachers</span></a><br><br>
		  <a href="subjects.jsp"> <span class="glyphicon glyphicon">View Subjects</span></a><br><br>
		  <a href="classes.jsp"> <span class="glyphicon glyphicon">View Classes</span></a><br><br>
		
</div>

</body>
</html>