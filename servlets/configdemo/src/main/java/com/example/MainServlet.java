package com.example;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class MainServlet extends HttpServlet {
    private String author;

    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        author = config.getInitParameter("author");
    };

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String appName = getServletContext().getInitParameter("appName");
        PrintWriter out = resp.getWriter();
        out.println("<html><body>");
        out.println("<h2>Servlet Config & Context Example</h2>");
        out.println("<p>Servlet Author (Config Param): " + author + "</p>");
        out.println("<p>Application Name (Context Param): " + appName + "</p>");
        out.println("</body></html>");
    };
}
