package createsession.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Createsessionn
 */
@WebServlet("/Createsessionn")
public class Createsessionn extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession();
		session.setAttribute("user", "john Doe");
		
		String user = (String)session.getAttribute("user");
		response.setContentType("text/html");
		response.getWriter().println("<h3>Session created succesfully!</h3>");
		response.getWriter().println("<p>Session ID:" + session.getId() + "</p>");
		response.getWriter().println("<p>UserName:" + user + "</p>");
		response.getWriter().println("<a href ='createsesion.html'>Go Back<a/>");
	}

}
