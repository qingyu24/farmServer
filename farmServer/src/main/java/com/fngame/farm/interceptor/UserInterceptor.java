package com.fngame.farm.interceptor;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by zhuzhengqing on 2017/12/19.
 */
@Component
public class UserInterceptor extends HandlerInterceptorAdapter {
    public UserInterceptor() {
        super();
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String userid = request.getParameter("userid");
        if (request.getSession().getAttribute("userid") != null) {
            return true;
        }
        return true;
    }
}
