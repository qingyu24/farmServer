package com.fngame.farm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.fngame.farm.mapper")
@EnableCaching

public class FarmApplication {

    public static void main(String[] args) {

        SpringApplication.run(FarmApplication.class, args);
    }
}
