package com.amdocs.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

import com.amdocs.training.db.DataSourceUtil;

@WebServlet("/adminLogin")
public class Controller extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
			
	    if(name.equals("Admin") && password.equals("Admin@123")) {
    		/*out.println("<html>\r\n" + 
    				"<head>\r\n" + 
    				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n" + 
    				"<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n" + 
    				"</head>\r\n" + 
    				"<body>\r\n" + 
    				"<hr>\r\n" + 
    				"<a href = \"welcome\">Home</a> |\r\n" +   
    				"<a href=\"course.jsp\"> Add Course </a> |\r\n" +  
    				"<a href=\"viewCourse\"> View Courses </a> |\r\n" + 
    				"<a href=\"viewUser\"> View Users </a> |\r\n" + 
    				"<a href=\"viewFeedback\"> View Feedback </a> |\r\n" + 
    				"</body>\r\n" + 
    				"</html>");*/
	    	response.sendRedirect("viewAdmin.jsp");
    	
    		
    		}
	    
	    else {
	    	out.println("Enter valid admin");
	    	//response.sendRedirect("index.jsp");
	    }
    		
    	
	    }

}
