package rays.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Multipage
 */
@WebServlet("/Multipage")
public class Multipage extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String page = request.getParameter("page");
		String destination;

		if (page == null || page.equals("index")) {
			destination = "/index.html";
		} else if (page.equals("page1")) {
			destination = "/page1.html";

		} else if (page.equals("page2")) {
			destination = "/page2.html";

		}else {
			destination = "/index.html";
		}
		request.getRequestDispatcher(destination).forward(request, response);

	}

}
