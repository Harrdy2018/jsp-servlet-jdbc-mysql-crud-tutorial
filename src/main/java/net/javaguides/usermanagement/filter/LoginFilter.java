package net.javaguides.usermanagement.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


@WebFilter(
        filterName = "loginFilter",
        urlPatterns = "/test/test/*",
        initParams = {
                @WebInitParam(name = "loginUI", value = "/home/loginUI"),
                @WebInitParam(name = "loginProcess", value = "/home/login"),
                @WebInitParam(name = "encoding", value = "utf-8"),
        }
)
public class LoginFilter implements Filter {
    private FilterConfig config;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.config = filterConfig;
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String loginUI = config.getInitParameter("loginUI");
        String loginProcess = config.getInitParameter("loginProcess");
        String encoding = config.getInitParameter("encoding");

        HttpServletRequest request = (HttpServletRequest)servletRequest;
        HttpServletResponse response = (HttpServletResponse)servletResponse;

        request.setCharacterEncoding(encoding);

        // 不带 http://域名:端口 地址
        String uri = request.getRequestURI();
        System.out.println("uri = " + uri);
        if (uri.contains(loginUI) || uri.contains(loginProcess)) {
            // 请求登陆
            filterChain.doFilter(request,response);
        } else {
            if (request.getSession().getAttribute("user") == null) {
                // 重定向到登陆界面
                response.sendRedirect(request.getContextPath()+"/test/test"+loginUI);
            } else {
                filterChain.doFilter(request,response);
            }
        }

    }

    @Override
    public void destroy() {
        this.config = null;
    }
}
