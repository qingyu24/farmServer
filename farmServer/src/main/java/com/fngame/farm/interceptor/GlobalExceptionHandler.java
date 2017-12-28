package com.fngame.farm.interceptor;

import com.fngame.farm.userdate.ResultInfo;
import com.fngame.farm.util.BeanTools;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice

public class GlobalExceptionHandler {

    @ExceptionHandler(value = Exception.class)
    public ResultInfo defaultErrorHandler() {
        System.out.println("-------------default error");
        ResultInfo resultInfo = (ResultInfo) BeanTools.getBean(ResultInfo.class);
        resultInfo.setResp_code("10086");
        resultInfo.setResp_desc("处理有误");
        return resultInfo;
    }

}
