package rays.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class css_pt1
 */
@WebServlet("/css_pt1")
public class css_pt1 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
         out.println("<!DOCTYPE html>");
         out.println("<html>");
         out.println("<head>");
         out.println("<link rel='stylesheet'type='text/css' href='Style.css'>");
         out.println("<title> servlet with CSS</title>");
         out.println("</head>");
         out.println("<body>");
         out.println("<h1> Hello from servlet</h1>");
         out.println("<p>This is styled with external CSS</p>");
         out.println("</body>");
         out.println("</html>");
	}

}
