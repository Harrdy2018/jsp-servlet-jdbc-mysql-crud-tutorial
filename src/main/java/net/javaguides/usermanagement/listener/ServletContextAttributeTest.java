package net.javaguides.usermanagement.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.annotation.WebListener;

// ServletContext Attribute 监听器

@WebListener
public class ServletContextAttributeTest implements ServletContextAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("enter ServletContext attributeAdded");
        System.out.println("attribute name = " + servletContextAttributeEvent.getName());
        System.out.println("attribute value = " + servletContextAttributeEvent.getValue());
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("enter ServletContext attributeRemoved");
    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("enter ServletContext attributeReplaced");
    }
}
