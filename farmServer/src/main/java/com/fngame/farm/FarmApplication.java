package com.fngame.farm;

import com.fngame.farm.manager.ConfigLoaderManager;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.xml.ws.ResponseWrapper;

@EnableAutoConfiguration
@SpringBootApplication
@MapperScan("com.fngame.farm.mapper")
@EnableCaching
@ServletComponentScan
@EnableTransactionManagement

public class FarmApplication {

    public static void main(String[] args) {

        ConfigLoaderManager.getInstance().loaderAll();
        SpringApplication.run(FarmApplication.class, args);
    }
}
