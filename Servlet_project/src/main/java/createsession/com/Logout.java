package createsession.com;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/Logout")
public class Logout extends HttpServlet {
	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		HttpSession session = request.getSession(false);// Dont create new session
		response.setContentType("text/html");
		if (session != null) {
			session.invalidate();
			response.getWriter().println("<h3>Session invalidated Succesfully!</h3>");

		} else {
			response.getWriter().println("<h3>No active session found!</h3>");
		}
		response.getWriter().println("<a href ='createsesion.html'>Go Back<a/>");

	}
}
