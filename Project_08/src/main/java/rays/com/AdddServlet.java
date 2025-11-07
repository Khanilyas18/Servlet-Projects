package rays.com;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class AdddServlet
 */
@WebServlet("/AdddServlet")
public class AdddServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		try {
			double num1 = Double.parseDouble(request.getParameter("num1"));
			double num2 = Double.parseDouble(request.getParameter("num2"));

			String operation = request.getParameter("operation");
			double result = 0;
			String message = "";
			switch (operation) {
			case "Add":
				result = num1 + num2;
			   message = num1 + "+" + num2 + "=" + result;
				break;
			case "Sub":
				result = (double)num1 - num2;
				message = num1 + "-" + num2 + "=" + result;
				break;
			case "Mul":
				result = num1 * num2;
				message = num1 + "X" + num2 + "=" + result;
				break;
			case "Div":
				if (num2 != 0) {
					result = num1 / num2;
					message = num1 + "/" + num2 + "=" + result;
				} else {
					message = "Error division by zero";
				}
				break;

			default:
				message = "Invalid Operations";

			}
			out.println("<html><body>");
			out.println("<h2> Result" + message + "</h2>");
			out.println("</body></html>");
		} catch (Exception e) {
			out.println("<h3style='color:red;'>Invalid Input! Please enter numbers only</h3>");
		}
		out.close();
	}

}
