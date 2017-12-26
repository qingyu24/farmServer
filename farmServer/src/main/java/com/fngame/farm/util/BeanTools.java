package com.fngame.farm.util;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by qingyu on 2017/12/24 /17:09
 */
@Configuration

public class BeanTools implements ApplicationContextAware {
    private static ApplicationContext applicationContext;


    public  void setApplicationContext(ApplicationContext context) {
        applicationContext = context;
    }

    public  static Object getBean(Class classname) {
        try{
            Object _restTemplate = applicationContext.getBean(classname);
            return _restTemplate;
        }catch(Exception e){
            return "";
        }
    }

}