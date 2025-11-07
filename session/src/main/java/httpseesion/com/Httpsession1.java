package httpseesion.com;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;

/**
 * Servlet implementation class Httpsession1
 */
@WebServlet("/Httpsession1")
public class Httpsession1 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// Get the session
		HttpSession session = request.getSession();

		// set an attribute in the session scope
		session.setAttribute("user", "Ilyas");

		// Retrieve the attributte
		String username = (String) session.getAttribute("user");
		System.out.println("username:" + username);// output:output:username Ilyas
	}

}
