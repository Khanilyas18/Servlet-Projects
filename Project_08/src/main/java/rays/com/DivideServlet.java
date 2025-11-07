package rays.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/DivideServlet")
public class DivideServlet extends HttpServlet {
	public void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		// get value from form
		int num1 = Integer.parseInt(request.getParameter("num1"));
		int num2 = Integer.parseInt(request.getParameter("num2"));
		// Divide numbers
		int sum = num1/num2;
		// print result
		out.println("<html><body>");
		out.println("<h2>Result:"+num1+" / "+num2+"="+sum+"</h2>");
		out.println("</body></html>");
		
	}

}


