package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class UserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");

        String name = req.getParameter("name");
        String email = req.getParameter("email");

        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h1>Form submitted</h1>");
        out.println("<p><b>Name: </b>" + name + "</p>");
        out.println("<p><b>E-mail: </b>" + email + "</p></body></html>");
    }
}
