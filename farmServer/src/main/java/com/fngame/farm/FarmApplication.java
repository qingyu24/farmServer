package com.fngame.farm;

import com.fngame.farm.manager.ConfigLoaderManager;
import com.fngame.farm.util.RedisUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@EnableAutoConfiguration
@SpringBootApplication
@MapperScan("com.fngame.farm.mapper")
@EnableCaching(proxyTargetClass = true)
@EnableTransactionManagement

public class FarmApplication {

    public static void main(String[] args) {
        new RedisUtil().start();
        ConfigLoaderManager.getInstance().loaderAll();
        SpringApplication.run(FarmApplication.class, args);
    }

}

