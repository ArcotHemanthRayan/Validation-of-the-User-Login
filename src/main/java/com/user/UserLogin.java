package com.user;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/userlogin")
public class UserLogin extends HttpServlet 
{
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
//		Set the content type
		response.setContentType("text/html");
		
//		Get the writer
		PrintWriter out = response.getWriter();
		
//		Get the userName from the request
		String uName = request.getParameter("userName");
		String userPassword = request.getParameter("userPassword");
		
//		Get a reference to the HttpSession object
		HttpSession theSession = request.getSession();
		
//		Validate the username
		if(uName.trim().equals("user1") && userPassword.trim().equals("user@1")
		   ||uName.trim().equals("user2") && userPassword.trim().equals("user@2")
		   ||uName.trim().equals("user3") && userPassword.trim().equals("user@3")
		   ||uName.trim().equals("user4") && userPassword.trim().equals("user@4")
		   ||uName.trim().equals("user5") && userPassword.trim().equals("user@5")) 
		{
//			Save the username in the session
			theSession.setAttribute("userName", uName);
			theSession.setAttribute("userPassword", userPassword);
			
//			Redirect to the Dashboard
			response.sendRedirect("dashboard");
			
		}
		else 
		{
			out.println("<font color='red'>Invalid username or password !!!!! <br></font>");
			out.println("<font color='green'>Please login again using valid Username and Password</font>");
			RequestDispatcher dispatcher = request.getRequestDispatcher("index.html");
			dispatcher.include(request, response);
		}
			
	}

}
