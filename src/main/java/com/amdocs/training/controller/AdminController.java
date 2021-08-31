package com.amdocs.training.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.amdocs.training.dao.AdminDAO;
import com.amdocs.training.dao.UserDAO;
import com.amdocs.training.dao.impl.AdminDAOImpl;
import com.amdocs.training.dao.impl.UserDAOImpl;
import com.amdocs.training.model.Admin;
import com.amdocs.training.model.User;

//@WebServlet("/adminLogin")
public class AdminController extends HttpServlet {
	
	/*@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		
		Admin admin = new Admin(id,name,email,password);
		
		AdminDAO dao = new AdminDAOImpl();
		
		boolean saveAdmin = dao.saveAdmin(admin);
		
		if(saveAdmin) {
			out.println("Admin Saved Successfully!");
		}
		else {
			out.println("try again");
		}
		
	}*/
	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		String name = request.getParameter("name");
		String password = request.getParameter("password");
		AdminDAO dao = new AdminDAOImpl();
	    List<User> list = dao.findAll();	
	    if(name.equals("Admin") && password.equals("Admin@123")) {
	    	out.println(list.toString());
	    	out.println("<table border=1 width=10% height=10%>");
    		out.println("<tr><th>User_ID</th><th>Name</th><th>Phone_No</th><th>Email</th><th>Address</th><th>Reg_Date</th><th>Password</th><th>Upload Image</th><tr>");
    		for(int i=1; i<list.size();i++)
	    	{
	    		
	    		//out.println(list.get(i));
    			/*int id = list.get(i).getUser_id();
   			    String username = list.get(i).getName();
   			    long phone_no = list.get(i).getPhone_no();
   			    String email = list.get(i).getEmail();
   			    String address = list.get(i).getAddress();
   			    String reg_date = list.get(i).getReg_date();
   			    String pass = list.get(i).getPassword();
   			    String upload_photo = list.get(i).getUpload_photo();
   			    out.println("<tr><td>" + id + "</td> <td>" +username + "</td><td>" +phone_no + "</td><td>"+ email+"</td><td>" + address + "</td><td>" + reg_date + "</td><td>"+pass+ "</td><td>"+ upload_photo+"</td><tr>");
   			 */
	    	}
    		out.println("</table>");
    	
	    }
		
	}

}
