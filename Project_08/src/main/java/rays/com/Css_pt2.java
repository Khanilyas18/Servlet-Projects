package rays.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/Css_pt2")
public class Css_pt2 extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out =response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html><head><title>Servlet Response</title>");
        out.println("<link rel = 'stylesheet'type='text/css'href=Stylee.css>");
        out.println("</head><body>");
        out.println("<h1>you clicked the button</h1>");
        out.println("<a href='indexx.html'><button>go Back</button></a>");
        out.println("</body></html>");
        
	}

}
