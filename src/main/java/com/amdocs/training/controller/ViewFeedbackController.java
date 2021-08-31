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
@WebServlet("/viewFeedback")
public class ViewFeedbackController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		DataSource dataSource = DataSourceUtil.dataSource();
		Connection conn = null;
		String sql = "select * from feedback";
		out.println("<table border=1 width=50% height=50%>");
		out.println("<tr><th>Course_ID</th><th>Course_Name</th><th>Course_Fees</th><th>Description</th><th>Resource</th><tr>");
		
		try {
			Connection conn1 = dataSource.getConnection();
			Statement stmt = conn1.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt(1);
				 String name1 = rs.getString(2);
				 String email = rs.getString(3);
				 int f_id = rs.getInt(4);
				 String feedback = rs.getString(5);
				 out.println("<tr><td>" + id + "</td> <td>" +name1 + "</td><td>" +email + "</td><td>"+ f_id+"</td><td>" + feedback + "</td><tr>");
			}
		
		} catch (SQLException e) {
			e.printStackTrace();
		}
		out.println("</table>");
		out.println("<html>\r\n" + 
				"<head>\r\n" + 
				"<meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\r\n" + 
				"<link href=\"style.css\" rel=\"stylesheet\" type=\"text/css\">\r\n" + 
				"</head>\r\n" + 
				"<body>\r\n" + 
				"<hr>\r\n" + 
				"<a href = \"viewAdmin.jsp\">Back</a> |\r\n" +    
				"</body>\r\n" + 
				"</html>");
		
	}
}
