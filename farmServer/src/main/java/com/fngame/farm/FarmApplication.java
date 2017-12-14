package com.fngame.farm;

import com.fngame.farm.util.XlsReader;
import com.fngame.farm.util.XlsUtil;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.io.IOException;


@SpringBootApplication
@EnableTransactionManagement
@MapperScan("com.fngame.farm.mapper")
@EnableCaching

public class FarmApplication {

    public static void main(String[] args) {
        try {
            XlsUtil.creatClass();
        } catch (IOException e) {
            e.printStackTrace();
        }

        XlsReader.read();
        SpringApplication.run(FarmApplication.class, args);
    }
}