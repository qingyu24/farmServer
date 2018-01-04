package com.fngame.farm.interceptor;

import com.fngame.farm.util.MD5;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.*;

@Component
public class loginInterceptor extends HandlerInterceptorAdapter {
    public loginInterceptor() {
        super();
    }

    private static String secret = "123";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        StringBuilder sb = new StringBuilder();
        Map map = new HashMap();
        Enumeration pNames = request.getParameterNames();
        while (pNames.hasMoreElements()) {
            String paramName = (String) pNames.nextElement();
            String paramValue = request.getParameter(paramName);
            map.put(paramName, paramValue);
        }
        String ret = getSignData(map);
        System.out.println("收到消息");
        System.out.println(map.toString());
/*        return Verify(ret, request.getParameter("sign"));*/
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

        super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        super.afterCompletion(request, response, handler, ex);

    }

    @Override
    public void afterConcurrentHandlingStarted(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        super.afterConcurrentHandlingStarted(request, response, handler);

    }

    private boolean Verify(String data, String sign) {
        String mySign = new MD5().getMD5ofStr(data);
        if (mySign.equals(sign)) {
            return true;
        }
        return false;
    }

    private String getSignData(Map<String, String> params) {
        StringBuffer content = new StringBuffer();
        List keys = new ArrayList(params.keySet());
        Collections.sort(keys);
        for (int i = 0; i < keys.size(); i++) {
            String key = (String) keys.get(i);
            if ((!"sign".equals(key)) && (!"sign_type".equals(key))) {
                String value = (String) params.get(key);
                if (value != null)
                    content.append(new StringBuilder().append(i == 0 ? "" : "&").append(key).append("=").append(value).toString());
                else content.append(new StringBuilder().append(i == 0 ? "" : "&").append(key).append("=").toString());
            }
        }
        content.append(secret);
        return content.toString();
    }
}
