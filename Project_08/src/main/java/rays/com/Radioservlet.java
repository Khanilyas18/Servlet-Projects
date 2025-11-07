package rays.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Radioservlet
 */
@WebServlet("/Radioservlet")
public class Radioservlet extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		   response.setContentType("text/html");
		   PrintWriter out = response.getWriter();
		   String lang = request.getParameter("Language");

		if (lang == null) {
			out.println("<h2>please select a language!</h2>");
		} else if (lang.equals("a")) {
			out.println("<h2>you selected java</h2>");

		} else if (lang.equals("Python")) {
			out.println("<h2>you selected python</h2>");

		} else if (lang.equals("C++")) {
			out.println("<h2>you selected C++</h2>");

		} else {
			out.println("<h2>Unknown option selected</h2>");
		}
	}
}
