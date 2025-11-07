package com.rayss;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Servlet implementation class Lifecycle_2
 */
@WebServlet("/restaurant")
public class Lifecycle_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;

	// Called once when servlet is created (Restaurant opens)

	@Override
	public void init() throws ServletException {
		System.out.println("Resaurant opened:Kitchen is Ready!");
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String dish = request.getParameter("dish");
		if (dish == null)
			dish = "Special Thali";

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<html><body style = 'font-family:Arial;'>");
		out.println("<h2> Welcome to java Restaurant!</h2>");
		out.println("<p>Order received:<b>" + dish + "</b></p>");
		out.println("<p>Chef is preparing your meal...</p>");
		out.println("<hr>");
		out.println("<small>Note:Kitchen (init)was set up once when restaurant opened<br>");
		out.println("Every new order (service/doGet) is served here<br>");
		out.println("when restaurant is closes,cleanup(destroy)happens.</small>");
		out.println("</body></html>");
		System.out.println("order served" + dish);

	}

	// Called once before servlet is removed(Restaurant closes)}
	@Override
	public void destroy() {
		getServletContext().log("Restaurant closed:destroy()called");
		System.out.println("Restaurant closed");
	}
}
