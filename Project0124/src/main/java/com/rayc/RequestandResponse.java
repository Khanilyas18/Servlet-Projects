package com.rayc;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;

/**
 * Servlet implementation class RequestandResponse
 */
@WebServlet("/Exampleservlet")
public class RequestandResponse extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// Get the value of the "name" parameter
		String name = request.getParameter("name");

		// Get the Value of the "hobby" parameters (can be multiple)
		String[] hobbies = request.getParameterValues("hobby");

		// Get the User-Agent header
		String userAgent = request.getHeader("User-Agent");

		out.println("<html>");
		out.println("<head><title>Servlet Example</title></head>");
		out.println("<body>");
		out.println("<p>Name:" + name + "</p>");
		out.println("<p>Hobbies</p>");
		out.println("<ul>");
		if (hobbies != null) {
			for (String hobby : hobbies) {
				out.println("<li>" + hobby + "</li>");
			}
		}
		  out.println("</ul>");
		  out.println("<p>User-Agent"+userAgent+"</p>");
		  out.println("</body>");
		  out.println("</html>");

	}

}
