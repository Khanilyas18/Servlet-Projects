package rays.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class MultiServlet
 */
@WebServlet("/MultiServlet")
public class MultiServlet extends HttpServlet {
	
protected void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// get values from form
		
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		
		int multi = num1*num2;
		out.println("<html><body>");
		out.println("<h2>Result:"+num1+"*"+num2+"="+multi+"</h2>");
		out.println("</body></html>");
		
	}

}
