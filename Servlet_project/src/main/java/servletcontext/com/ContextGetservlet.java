package servletcontext.com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.Servlet;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/ContextGetservlet")
public class ContextGetservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// Get the same servletcontext object
		ServletContext context = getServletContext();

		// Retrieve the attribute
		String appName = (String) context.getAttribute("appName");

		if (appName != null) {
			out.println("<h3>Application Name:" + appName + "</h3>");

		} else {
			out.println("<h3>No context attribute</h3>");
		}

	}

}
