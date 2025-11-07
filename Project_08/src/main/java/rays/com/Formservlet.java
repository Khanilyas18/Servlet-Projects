package rays.com;

import jakarta.servlet.ServletException;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;


import java.io.*;


@WebServlet("/Formservlet")
public class Formservlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String name = request.getParameter("username");
		String email = request.getParameter("email");

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h2>Form Submitted Successfully!</h2>");
		out.println("<p>Name: " + name + "</p>");
		out.println("<p>Email: " + email + "</p>");
		out.println("</body></html>");
	}
}
