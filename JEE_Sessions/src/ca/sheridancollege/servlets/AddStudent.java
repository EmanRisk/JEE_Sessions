package ca.sheridancollege.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ca.sheridancollege.beans.Student;

/**
 * Servlet implementation class AddStudent
 */
@WebServlet("/add")
public class AddStudent extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//Get Parameters
		String name = request.getParameter("name");   
		int grade = Integer.parseInt(request.getParameter("grade")); //Parameters are always strings. If you want grade to be an int, you have to typecast (parse it)
		
		//Make student bean
		Student stu = new Student(name,grade);
		
		//Connect to a session 
		HttpSession session = request.getSession();
		
		//If the student list exists in the session, use that list to add the student to
		ArrayList<Student> students = (ArrayList<Student>)session.getAttribute("meow");
		
		//If the student list does not exist in the session, then create a new list to add our student to
		if(students == null) {
			students = new ArrayList<Student>();
		}
		
		//Put our student into our list
		//ArrayList<Student> students = new ArrayList<Student>(); //We don't have a student class yet, so we have to make a bean (student class)
		students.add(stu);
	
		//Store the list an an attribute, we store at as an attribute so our JSP can read it via getAttribute
		session.setAttribute("meow", students);
		
		//Go to the JSP
		request.getRequestDispatcher("showStudents.jsp").forward(request, response);
		
	}
}
