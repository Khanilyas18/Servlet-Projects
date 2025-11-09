package hidden.com;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class Secondservlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
          response.setContentType("text/html");
          PrintWriter out = response.getWriter();
          String uname = request.getParameter("username");
          String uid= request.getParameter("userid");// hiden field value
          
          // pass data to next servlet using hidden field
	}
}
