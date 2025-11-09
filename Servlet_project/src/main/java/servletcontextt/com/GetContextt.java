package servletcontextt.com;

import java.io.IOException;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/GetContextt")
public class GetContextt extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ServletContext context = getServletContext();
		String appName = (String) context.getAttribute("appName");

		response.setContentType("text/html");
		if (appName != null) {
			response.getWriter().println("<h3>App Name from context:" + appName + "</h3>");
			context.removeAttribute("appName");
			response.getWriter().println("<p>Attribute remove from servlet context");

		} else {
			response.getWriter().println("<h3>No app name found in context!</h3> ");
		}
		response.getWriter().println("<a href='Getsettcontextt2.html'>Go Back</a>");
	}
}
