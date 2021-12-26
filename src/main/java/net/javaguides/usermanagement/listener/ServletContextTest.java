package net.javaguides.usermanagement.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;

@WebListener
public class ServletContextTest implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("enter contextInitialized");
        // ServletContext 对象是一个为整个 web 应用提供共享的内存，任何请求都可以访问里面的内容
        ServletContext servletContext = servletContextEvent.getServletContext();
        Map<String, String> data = new HashMap<>();
        data.put("name", "Harrdy2018");
        data.put("age", "18");
        data.put("sex", "男");
        servletContext.setAttribute("TestData", data);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("enter contextDestroyed");
    }
}
