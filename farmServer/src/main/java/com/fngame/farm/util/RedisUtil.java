package com.fngame.farm.util;

/**
 * Created by qingyu on 2017/12/28 /16:17
 */

import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.lang.reflect.Proxy;

public class RedisUtil extends Thread  {
    @Override
    public void run() {
        this.runbat();
    }
    org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());
    private void runbat() {

        String batName = "Redis-x64-3.2.100\\redis-server.exe";
        String cofig = "Redis-x64-3.2.100\\redis.windows.conf";
        String[] strings = new String[1];
        strings[0] = cofig;
        try {
            Process ps = Runtime.getRuntime().exec(batName, strings);

            logger.info("启动redis");
            ps.waitFor();

        } catch (IOException ioe) {
            logger.error("启动redis失败",ioe);
            ioe.printStackTrace();
        } catch (InterruptedException e) {
            logger.error("启动redis失败",e);
            e.printStackTrace();
        }
        logger.info("redis已经启动，本次启动失败");

    }

}
