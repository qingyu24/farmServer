package com.fngame.farm.interceptor;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

@WebListener
public class FarmListener implements ServletContextListener {
    Logger logger= LoggerFactory.getLogger(this.getClass());
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("servlet 初始化"+sce.toString());
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("servlet 被销毁"+sce.toString());

}
}
