package baut.com;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/SecondServl")
public class SecondServl extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Get request attribute
        String age = (String) request.getAttribute("userAge");

        // Get session attribute
        HttpSession session = request.getSession(false);
        String name = (String) session.getAttribute("userName");

        // Display results
        out.println("<h2>WELCOME " + name + "</h2>");
        out.println("<p>Your age is: " + age + "</p>");
        out.println("<p>Session ID: " + session.getId() + "</p>");
    }
}

       
   