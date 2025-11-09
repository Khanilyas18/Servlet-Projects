package httpreq.com;

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
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// Get form data fromthe request
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// Display data
		out.println("<h2>Httpservletrequest example");
		out.println("<p>username:" + username + "</p>");
		out.println("<p>password:" + password + "</p>");

		// Other useful info from request
		out.println("<hr>");
		out.println("<p>Request Method:" + request.getMethod() + "</p>");
		out.println("<p>Request URL:" + request.getRequestURI() + "</p>");
		out.println("<p>Client IP:" + request.getRemoteAddr() + "</p>");

	}

}
