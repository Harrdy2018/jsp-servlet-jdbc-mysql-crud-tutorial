package net.javaguides.usermanagement.web;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "Query", urlPatterns = "/test/query")
public class QueryServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("start /test/query get request");
        // 请求体乱码
        req.setCharacterEncoding("utf-8");
        // 返回体乱码
        resp.setContentType("text/html;charset=UTF-8");
        // 获取请求头字段
        // User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36
        System.out.println(req.getHeader("User-Agent"));
        // get请求 获取查询参数 http://localhost:8080/jsp_servlet_jdbc_mysql_crud_tutorial/test/query?name=harrdy
        // post请求 获取表单参数 http://localhost:8080/jsp_servlet_jdbc_mysql_crud_tutorial/test/query 表单 name="harrdy"
        System.out.println(req.getParameter("name"));
        PrintWriter pw = resp.getWriter();
        pw.println("Hello QueryServlet 我是谁");
        pw.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 请求体乱码
        req.setCharacterEncoding("utf-8");
        // 返回体乱码
        resp.setContentType("text/html;charset=UTF-8");
        // 获取请求头字段
        // User-Agent: Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/96.0.4664.110 Safari/537.36
        System.out.println(req.getHeader("User-Agent"));
        // get请求 获取查询参数 http://localhost:8080/jsp_servlet_jdbc_mysql_crud_tutorial/test/query?name=harrdy
        // post请求 获取表单参数 http://localhost:8080/jsp_servlet_jdbc_mysql_crud_tutorial/test/query 表单 name="harrdy"
        System.out.println(req.getParameter("name"));
        PrintWriter pw = resp.getWriter();
        pw.println("Hello QueryServlet 我是谁");
        pw.flush();
    }
}
