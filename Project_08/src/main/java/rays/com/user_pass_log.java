package rays.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/user_pass_log")
public class user_pass_log extends HttpServlet {
	private static final String CORRECT_PASSWORD = "sid@";

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		out.println("<!DOCTYPE html>");
		out.println("<html lang='en'>");
		out.println("<head>");
		out.println("<meta charset='UTF-8'>");
		out.println("<meta name='viewport' content='width=device-width, initial-scale=1.0'>");
		out.println("<title>Login Form</title>");
		out.println("<style>");
		out.println("body { font-family: Arial, sans-serif; margin: 20px; }");
		out.println("form { max-width: 300px; margin: 0 auto; }");
		out.println("label{display:block;margin-bottom:5px; }");
		out.println("input[type='text'], input[type='password'] { width: 100%; padding:8px; margin-bottom: 10px;}");
		out.println(
				"button { background-color: #007bff; color: white; padding: 10px 15px;border: none; cursor: pointer; }");
		out.println("button:hover {background-color: #0056b3; }");
		out.println("</style>");
		out.println("</head>");
		out.println("<body>");
		out.println("<div>");
		out.println("<h2>Login Form</h2>");
		out.println("<form action='login' method='post'>");
		out.println("<div>");
		out.println("<label for='username'>Username:</label>");
		out.println("<input type='text'id='username' name='username' required>");
		out.println("</div>");
		out.println("<div>");
		out.println("<label for='password'>Password:</label>");
		out.println("<input type='password' id='password' name='password' required>");
		out.println("</div>");
		out.println("<button type='submit'>Submit</button>");
		out.println("</form>");
		out.println("</div>");
		out.println("</body>");
		out.println("</html>");

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();

		String username = request.getParameter("username");
		String password = request.getParameter("password");

		if (username == null || username.isEmpty() || password == null || password.isEmpty()) {

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Error</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div>");
			out.println("<h2>Error</h2>");
			out.println("<p>Username and password are required.</p>");
			out.println("<a href='login'>Back to Form</a>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
			return;

		}

		// Check if the password matches "sid@"

		if (password.equals(CORRECT_PASSWORD)) {

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Login Successful</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div>");
			out.println("<h2>Login Successful</h2>");
			out.println("<p>Welcome," + username + "!</p>");
			out.println("<a href='login'>Logout</a>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");

		} else {

			out.println("<!DOCTYPE html>");
			out.println("<html>");
			out.println("<head>");
			out.println("<title>Login Failed</title>");
			out.println("</head>");
			out.println("<body>");
			out.println("<div>");
			out.println("<h2>Login Failed</h2>");
			out.println("<p>Incorrect password. Please try again.</p>");
			out.println("<a href='login'>Back to Form</a>");
			out.println("</div>");
			out.println("</body>");
			out.println("</html>");
		}

	}
}
