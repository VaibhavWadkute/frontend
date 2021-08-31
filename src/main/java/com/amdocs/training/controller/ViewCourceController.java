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
@WebServlet("/viewCourse")
public class ViewCourceController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		DataSource dataSource = DataSourceUtil.dataSource();
		Connection conn = null;
		String sql = "select * from course";
		out.println("<table border=1 width=50% height=50%>");
		out.println("<tr><th>Course_ID</th><th>Course_Name</th><th>Course_Fees</th><th>Description</th><th>Resource</th><tr>");
		
		try {
			Connection conn1 = dataSource.getConnection();
			Statement stmt = conn1.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt(1);
				 String name1 = rs.getString(2);
				 int fees = rs.getInt(3);
				 String description = rs.getString(4);
				 String resource = rs.getString(5);
				 out.println("<tr><td>" + id + "</td> <td>" +name1 + "</td><td>" +fees + "</td><td>"+ description+"</td><td>" + resource + "</td><tr>");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.println("</table>");
		
		
	}
}
