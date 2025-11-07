package hello.com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
@WebServlet("/Demo1")
public class Demo1 extends HttpServlet{
	protected void doGet(HttpServletRequest reuest,HttpServletResponse response)
	throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body>");
		out.println("<h1>hello from the servlet!</h1>");
		out.println("</body> </html>");
	}

}
