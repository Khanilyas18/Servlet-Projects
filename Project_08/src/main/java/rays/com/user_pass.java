package rays.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user_pass")
public class user_pass extends HttpServlet {

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		// get form data
		String username = request.getParameter("username");
		String password = request.getParameter("password");

		// simple validation (for emo purpose,using Hardcoded credentials)
		// in a real pplication validate against a database

		if (username != null && password != null && username.equals("ILYAS KHAN") && password.equals("password123")) {
			out.println("<html><body>");
			out.println("<h2>Login Successful");
			out.println("<p>Welcome"+" " + username + "!</p>");
			out.println("</body></html>");

		} else {
			out.println("<html><body>");
			out.println("Login failed");
			out.println("<p>Invalid username or Password</p>");
			out.println("<a href='User_Pass.html'>Try again</a>");
			out.println("</body></html>");
              
		}

	}

}
