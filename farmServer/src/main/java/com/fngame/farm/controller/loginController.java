package com.fngame.farm.controller;

import com.alibaba.fastjson.JSONObject;
import com.fngame.farm.model.User;
import com.fngame.farm.service.loginService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Date;

@RestController
@RequestMapping("/login")
public class loginController {
    private static String resp_desc = "resp_desc";
    private static String resp_code = "resp_code";
    private static String data = "data";

    @Resource
    private loginService loginService;

    private JSONObject jsonObject = new JSONObject();

    @RequestMapping("login")
    public JSONObject login(Integer type, String username, String password, String sign) {
        //根据type 区分登录方式

        jsonObject.clear();
        User userByname = loginService.getUser(username, password, type);

        if (userByname != null) {
            jsonObject.put(resp_code, "000000");
            jsonObject.put(resp_desc, "登录成功");
            JSONObject jsonObject1 = new JSONObject();
            jsonObject1.put("userinfo", userByname);
            jsonObject.put(data, jsonObject1);
        } else {
            jsonObject.put(resp_code, "0000");
            jsonObject.put(resp_desc, "登录失败，用户不存在");
        }
        return jsonObject;
    }

    @RequestMapping("resign")
    public JSONObject resign(User user, Integer type) {
        user.setRegtime(new Date());

        boolean b = loginService.addUser(user, type);
        if (b) {
            jsonObject.clear();
            jsonObject.put(resp_code, "000000");
            jsonObject.put(resp_desc, "注册成功");
        } else {
            jsonObject.clear();
            jsonObject.put(resp_code, "0000");
            jsonObject.put(resp_desc, "注册失败，用户已存在");
        }
        return jsonObject;
    }

}
