package rays.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class login
 */
@WebServlet("/login")
public class login extends HttpServlet {

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
        
		out.println("<!DOCTYPE html>");
		out.println("<html lang='en'>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
        out.println("<title>Login Form </title>");
		
		
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container mt-5'>");
		out.println("<h2>Login Form</h2>");
		out.println("<form action='login'method='post'class='mt-3'>");
		out.println("<div class='mb-3'>");
		out.println("<label for='username'class='form-label'>Username:</label>");
		out.println("<input type='text'class='form-control'id='username'name='username'required>");
		out.println("</div>");
		out.println("<div class='mb-3'>");
		out.println("<label for='password'class='form-label'>Password:</label>");
		out.println("<input type='password'class='form-control'id='password'name='password'required>");
		out.println("</div>");
		out.println("<button type='submit'class='btn btn-primary'>Submit</button>");
		out.println("</form>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html");
		}
	protected void doPost(HttpServletRequest request,HttpServletResponse response)
	throws ServletException,IOException{
		response.setContentType("text/html");
		PrintWriter out=response.getWriter();
		String username=request.getParameter("username");
		String password=request.getParameter("password");
		
		
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println("<title>Form Submission Result</title>");
		
		
		out.println("</head>");
		out.println("<body>");
		out.println("<div class='container mt-5'>");
		out.println("<h2>Submission Result</h2>");
		out.println("<div class='alert-info'>");
		out.println("<p><strong>Username</strong>"+(username != null? username:"Not provided")+"</p>");
		out.println("<p><strong>Password</strong>"+(password != null? password:"Not provided")+"</p>");
		out.println("</div>");
		out.println("<a href='login'class='btn btn-secondary'>Back to form</a>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");
		
		
	}
	
}

