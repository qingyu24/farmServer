package com.fngame.farm.interceptor;

import com.fngame.farm.userdate.ResultInfo;
import com.fngame.farm.util.BeanTools;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalExceptionHandler {
    org.slf4j.Logger logger = LoggerFactory.getLogger(this.getClass());

    @ExceptionHandler(value = Exception.class)
    public ResultInfo defaultErrorHandler(Exception e) {
        System.out.println("-------------default error");
        System.out.println(e.toString());
        logger.error("错误", e);

        ResultInfo resultInfo = (ResultInfo) BeanTools.getBean(ResultInfo.class);
        resultInfo.setResp_code("10086");
        resultInfo.setResp_desc("处理有误");
        return resultInfo;
    }

}
