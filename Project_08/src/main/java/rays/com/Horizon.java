package rays.com;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Servlet implementation class Horizon
 */
@WebServlet("/pages")
public class Horizon extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String page = request.getParameter("page");
		String target = "/index1.html";
        
		if ("home".equals(page)) {
			target = "/home.html";
			
			}else if ("about".equals(page)) {
			target = "/about.html";
			
			}else if ("contact".equals(page)) {
				target = "/contact.html";
			}
		RequestDispatcher rd = request.getRequestDispatcher(target);
		rd.forward(request, response);
	}
	

}
