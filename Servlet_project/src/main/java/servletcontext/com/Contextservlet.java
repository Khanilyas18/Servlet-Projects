package servletcontext.com;

import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Contextservlet
 */
@WebServlet("/Contextservlet")
public class Contextservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out =response.getWriter();
		
		//Get the servletContext object
		ServletContext context = getServletContext();
		
		// Set a global attribute
		context.setAttribute("appName", "Online Bookstore");
		out.println("<h3>Context attribute'appName'has been set!</h3>");
		
	}

}
