package com.coki;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.ClientInfoStatus;
import java.util.Iterator;

/**
 * Servlet implementation class ExampleServlet
 */
@WebServlet("/ExampleServlet")
public class ExampleServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Using get parameter() from HTML form
		String username = request.getParameter("username");
		out.println("<h2>Hello," + (username != null ? username : "Guest") + "</h2>");

		// using getCookies()
		Cookie[] cookies = request.getCookies();
		if (cookies != null) {
			out.println("<h3>Cookies<h3>");
			for (Cookie cookie : cookies) {
				out.println("Name:" + cookie.getName() + ",Value" + cookie.getValue() + "<br>");

			}
		} else {
			out.println("<p> No Cookies Found");

			// Using getRemoteAddr()
			String ipAddress = request.getRemoteAddr();
			out.println("<h3>Client IP Address </h3>");
			out.println("<p>" + ipAddress + "</p>");

			// Using getRequestURI()
			String requestURI = request.getRequestURI();
			out.println("<h3>Request URI</h3>");
			out.println("<p>" + requestURI + "</p>");

		}

	}

}
