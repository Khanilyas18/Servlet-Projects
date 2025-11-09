package hidden.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Firstservlet
 */
@WebServlet("/Firstservlet")
public class Firstservlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
             
		    response.setContentType("text/html");
		    PrintWriter out = response.getWriter();
		    
		    String uname = request.getParameter("username");
		    String uid = request.getParameter("userid");
		    
		    // pass data to next servlet using hidden field
		    out.println("<form action ='Firstservlet' method = 'Post'>");
		    out.println("<input type='hiden' name='username' vlue='"+uname+"'>");
		    out.println("<input type='submit'value='Go to Firstservlet'>");
		    out.println("</form>");
	}

}
