package net.javaguides.usermanagement.web;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

@WebServlet(name = "Test", urlPatterns = "/test")
public class TestServlet extends HttpServlet {
    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        // HttpServlet(abstract) 继承 GenericServlet(abstract)
        // GenericServlet(abstract) 实现 Servlet和ServletConfig接口
        // getServletConfig() 存在于 GenericServlet(abstract)
        ServletContext servletContext = getServletConfig().getServletContext();
        Map<String, String> data = (Map<String, String>)servletContext.getAttribute("TestData");
        Set<String> key = data.keySet();

        res.setContentType("text/html;charset=utf-8");
        PrintWriter pw = res.getWriter();
        pw.println("<p> Hello World! </p>");
        for (String s:key) {
            pw.println("<p>");
            pw.println("key = " + s + " value = " + data.get(s));
            pw.println("</p>");
        }
        pw.flush();
    }
}
