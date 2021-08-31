 package com.amdocs.training.controller;
 
 import java.io.IOException;
 import java.io.PrintWriter;

 import javax.servlet.ServletException;
 import javax.servlet.annotation.WebServlet;
 import javax.servlet.http.HttpServlet;
 import javax.servlet.http.HttpServletRequest;
 import javax.servlet.http.HttpServletResponse;
 @WebServlet("/welcome")
 public class WelcomeController extends HttpServlet{

 	@Override
 	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
 		
 		PrintWriter out = response.getWriter();
 		response.sendRedirect("index.jsp");
 		
 	}
 }
