package com.accolite.demo_servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class Servlet_Demo
 */
public class Servlet_Demo extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	Connection con=null;
	public Servlet_Demo() {
		super();
		try {
			Class.forName("com.mysql.jdbc.Driver");  
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/au","root","root");  
		}
		catch(Exception e)
		{ 
			System.out.println(e);
		}  	
	}


	//mysql-connector-java-5.1.45.zip.mysql-connector-java-5.1.45.src.com.mysql.jdbc

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String name=request.getParameter("name");
		String age=request.getParameter("age"); 
		try {
			Statement stmt=con.createStatement(); 
			stmt.executeUpdate("insert into servlet_streams_exercises(name,age) "+" values('"+name+"','"+Integer.parseInt(age)+"')");
			response.getWriter().append("inserted");
		} catch (SQLException e) {
			e.printStackTrace();
		}
			
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
