<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%@ page import="ca.sheridancollege.beans.Student" %>
<%@ page import="java.util.*" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Show Students</h1>

<%
ArrayList<Student> students = (ArrayList<Student>)session.getAttribute("meow");
%>

	Number of Students: <%= students.size() %><br><br>

<% for(int i = 0; i < students.size(); i++){
	Student s = students.get(i);
	%>
	Name: <%= s.getName() %> <br>
	Grade: <%= s.getGrade() %> <br><br>
	<%
	} 
	%>
<a href="Student.html">Add Student</a>

</body>
</html>