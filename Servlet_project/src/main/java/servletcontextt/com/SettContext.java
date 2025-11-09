package servletcontextt.com;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class SettContext
 */
@WebServlet("/SettContext")
public class SettContext extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String appName = request.getParameter("appName");
		
		ServletContext context = getServletContext();
		context.setAttribute("appName", "appName");
		
		response.setContentType("text/html");
		response.getWriter().println("<h3>Application Name set in ServletContext</h3>");
		response.getWriter().println("<a href='Getsettcontextt2.html'>Go Back</a>");
		
	}

}
