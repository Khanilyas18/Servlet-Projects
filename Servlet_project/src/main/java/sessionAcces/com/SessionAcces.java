package sessionAcces.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;

@WebServlet("/SessionAcces")
public class SessionAcces extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get or create session
		HttpSession session = request.getSession();

		// Get creation time
		long creationTime = session.getCreationTime();
		Date createdDate = new Date(creationTime);

		// Get last Accessed time
		long lastAccessedTime = session.getLastAccessedTime();
		Date lastAccessedDate = new Date(lastAccessedTime);

		// Set Content type
		response.setContentType("text/html");

		// Display info
		response.getWriter().println("<h3>Session ID :" + session.getId() + "</h3>");
		response.getWriter().println("<p>Session created at :" + createdDate + "</p>");
		response.getWriter().println("<p>Last Accessed at :" + lastAccessedDate);

	}

}
