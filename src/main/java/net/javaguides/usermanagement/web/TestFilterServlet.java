package net.javaguides.usermanagement.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "TestFilter", urlPatterns = "/test/test/*")
public class TestFilterServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession httpSession = req.getSession();
        if (httpSession.getAttribute("user") == null) {
            httpSession.setAttribute("user", "oppo");
        }
        resp.setContentType("text/html;charset=utf-8");
        PrintWriter pw = resp.getWriter();
        pw.println("<p> Hello World! </p>");
        pw.println("<p>");
        pw.println("request ContextPath = "+req.getContextPath());
        pw.println("</p>");
        pw.println("<p>");
        pw.println("request URI = "+req.getRequestURI());
        pw.println("</p>");
        pw.println("<p>");
        pw.println("request URL = "+req.getRequestURL());
        pw.println("</p>");
        pw.println("<p>");
        pw.println("session attribute name = "+ "user");
        pw.println("session attribute value = "+ httpSession.getAttribute("user"));
        pw.println("</p>");
        pw.flush();
    }
}
