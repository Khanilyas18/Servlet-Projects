package ik.com;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/Formservlet")
public class Formservlet {
protected void doPost(HttpServletRequest request,HttpServletResponse response)
throws ServletException,IOException{
	
	String name = request.getParameter("username");
	String email = request.getParameter("email");
	
	response.setContentType("text/html");
	PrintWriter out = response.getWriter();
	out.println("<html><body>");
	out.println("<h2>Form submitted Successfully!</h2>");
	out.println("<p>Name:"+name+"</p>");
	out.println("<p>Email:"+email+"</p>");
	out.println("</body></html>");

	
}
}
