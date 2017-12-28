package com.fngame.farm;

import com.fngame.farm.manager.ConfigLoaderManager;
import org.junit.Test;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import test.com.fngame.farm.manager.ConfigManagerTest;

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

