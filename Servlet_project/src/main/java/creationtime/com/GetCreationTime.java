package creationtime.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.sql.Date;


@WebServlet("/GetCreationTime")
public class GetCreationTime extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get or create session
		HttpSession session = request.getSession();
		//Get session creation time (miliseconds)
		long creationTime = session.getCreationTime();
		//convert to readable data
		Date createdDate = new Date(creationTime);
		// send response
		response.setContentType("text/html");
		response.getWriter().println("<h3>Session ID:"+session.getId()+"</h3>");
		response.getWriter().println("<h3>Session created At:"+createdDate+"</h3>");
		//  Run without html page
	}

}
