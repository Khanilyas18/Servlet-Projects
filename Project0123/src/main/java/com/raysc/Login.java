package com.raysc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
// Getting from data
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		
		// Business logic(Simple check)
		if ("Ilyas khan".equals(username)&&"1234".equals(password)) {
			response.getWriter().println("Welcome"+username+"!");
		} else {
response.getWriter().println("Invalid username or password");
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>hello,this is a servlet response!</h2>");
		out.println("<p>Client IP:"+request.getRemoteAddr()+"</p>");
		out.println("</body></html>");
		
	}

}
