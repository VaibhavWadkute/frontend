package com.amdocs.training.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.dao.impl.UserDAOImpl;
import com.amdocs.training.model.User;
@WebServlet("/login")
public class LoginController extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		UserDAO dao = new UserDAOImpl();
		User user = dao.validateUser(username, password);
		if(user != null)
		{
			 int id = user.getUser_id();
			 String name = user.getName();
			 long phone_no = user.getPhone_no();
			 String email = user.getEmail();
			 String address = user.getAddress();
			 String reg_date = user.getReg_date();
			 String pass = user.getPassword();
			 String upload_photo = user.getUpload_photo();
			out.println("<table border=1 width=20% height=10%>");
    		out.println("<tr><th>User_ID</th><th>Name</th><th>Phone_No</th><th>Email</th><th>Address</th><th>Registration_Date</th><th>Password</th><th>Upload Image</th><tr>");
			//out.println(user);
            out.println("<tr><td>" + id + "</td> <td>" +name + "</td><td>" +phone_no + "</td><td>"+ email+"</td><td>" + address + "</td><td>" + reg_date + "</td><td>"+pass+ "</td><td>"+ upload_photo+"</td><tr>");
			out.println("</table>");
			
			out.println("<html>\r\n" + 
    				"<head>\r\n" + 
    				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n" + 
    				"<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n" + 
    				"</head>\r\n" + 
    				"<body>\r\n" + 
    				"<hr>\r\n" + 
    				"<a href = \"welcome\">Home</a> |\r\n" +    
    				"<a href=\"viewCourse\"> View Courses </a> |\r\n" + 
    				"<a href=\"feedback.jsp\"> Give Feedback </a> |\r\n" + 
    				"</body>\r\n" + 
    				"</html>");
		}
		else
		{
			out.println("Enter a valid user");
		}
		
	}
}