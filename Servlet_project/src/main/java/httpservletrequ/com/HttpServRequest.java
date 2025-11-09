package httpservletrequ.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/HttpServRequest")
public class HttpServRequest extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// set an attribute first (for demonstration)
		request.setAttribute("userMessage", "Hello User");

		// Later,remove it
		request.removeAttribute("userMessage");

		// response.setContentType("text/html");
		response.getWriter().println("Attribute removed from request scope.");

	}

}
