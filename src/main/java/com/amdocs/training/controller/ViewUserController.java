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
@WebServlet("/viewUser")
public class ViewUserController extends HttpServlet{

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out = response.getWriter();
		DataSource dataSource = DataSourceUtil.dataSource();
		Connection conn = null;
		String sql = "select * from user";
		out.println("<table border=1 width=10% height=10%>");
		out.println("<tr><th>User_ID</th><th>Name</th><th>Phone_No</th><th>Email</th><th>Address</th><th>Reg_Date</th><th>Password</th><th>Upload_Image</th><tr>");
		
		try {
			Connection conn1 = dataSource.getConnection();
			Statement stmt = conn1.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while(rs.next()) {
				int id = rs.getInt(1);
				 String name1 = rs.getString(2);
				 long phone_no = rs.getLong(3);
				 String email = rs.getString(4);
				 String address = rs.getString(5);
				 String reg_date =rs.getString(6);
				 String pass = rs.getString(7);
				 String upload_photo = rs.getString(8);
				 out.println("<tr><td>" + id + "</td> <td>" +name1 + "</td><td>" +phone_no + "</td><td>"+ email+"</td><td>" + address + "</td><td>" + reg_date + "</td><td>"+pass+ "</td><td>"+ upload_photo+"</td><tr>");
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