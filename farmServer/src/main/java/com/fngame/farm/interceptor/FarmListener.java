package com.fngame.farm.interceptor;

import com.mysql.jdbc.log.LogFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class FarmListener implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println(sce.toString());
        System.out.println("servlet 初始化");
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("servlet 被销毁");
        Exception exception = new Exception();

    }
}
