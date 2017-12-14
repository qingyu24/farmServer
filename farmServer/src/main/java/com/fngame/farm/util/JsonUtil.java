package com.fngame.farm.util;

import com.alibaba.fastjson.JSONObject;

public class JsonUtil {
    private static JSONObject json = new JSONObject();

    public static JSONObject getResul(String  code, String desc) {
        json.clear();
        json.put("resp_code", code);
        json.put("resp_desc", desc);
        return json;
    }
}
