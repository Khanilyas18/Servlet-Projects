package hello_22;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Demo3
 */

public class Demo3 extends HttpServlet {
	@Override
	protected void doGet(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1> Hy myself Ilyas khan</h1>");
		out.println("</body></html>");
	}	
	}
       
   
    

	
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//	
