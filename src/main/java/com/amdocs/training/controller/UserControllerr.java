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
@WebServlet("/register")
public class UserControllerr extends HttpServlet{

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		int id = Integer.parseInt(request.getParameter("id"));
		String username = request.getParameter("username");
		long phone = Long.parseLong(request.getParameter("phone"));
		String email = request.getParameter("email");
		String address = request.getParameter("address");
		String reg_date = request.getParameter("reg_date");
		String password = request.getParameter("password");
		String image = request.getParameter("image");
		
		User user = new User(id,username,phone,email,address,reg_date,password,image);
		
		UserDAO dao = new UserDAOImpl();
		
		boolean saveUser = dao.saveUser(user);
		
		if(saveUser)
		{
			out.println("user save successfully");
		}
		
		else
		{
			out.println("try again");
		}
		
		
		
		
	}
}
