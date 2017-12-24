package com.fngame.farm.userdate;

import com.fngame.farm.manager.ConfigManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ResultInfo {
    private String main;

    private String sub;

    private String resp_code;

    private String resp_desc;

    private HashMap<String, Object> data;



    @Autowired
    ConfigManager configManager;
    public String getResp_code() {
        return resp_code;
    }

    public void setResp_code(String resp_code) {
        this.resp_code = resp_code;
        String resp = configManager.getResp(resp_code);
        this.resp_desc=resp;
    }

    public String getResp_desc() {
        return resp_desc;
    }

    public void setResp_desc(String resp_desc) {
        this.resp_desc = resp_desc;
    }

    public void setResult(String code, String resp_desc) {
        this.resp_code = code;
        this.resp_desc = resp_desc;
    }

    public HashMap<String, Object> getData() {
        if(data==null)data=new HashMap<>();
        return data;
    }

    public void setData(HashMap<String, Object> data) {
        this.data = data;
    }


    public void setMain(String main) {
        this.main = main;
        data.put("main", main);
    }


    public void setSub(String sub) {
        this.sub = sub;
        data.put("sub", sub);
        data.put("sub", sub);
    }

    public void setSucess() {
        this.resp_code = "000000";
        this.resp_desc = "操作成功";
    }

    public String getMain() {
        return main;
    }

    public String getSub() {
        return sub;
    }

    public void setOrder(RequserOrder order) {
        resp_code = null;

        resp_desc = null;
        if (data != null)
            data.clear();

        this.main = order.main;
        this.sub = order.sub;
    }

    @Override
    public String toString() {
        return "ResultInfo{" +
                "resp_code='" + resp_code + '\'' +
                ", resp_desc='" + resp_desc + '\'' +
                ", data=" + data +
                ", main='" + main + '\'' +
                ", sub='" + sub + '\'' +
                '}';
    }

    public void setfalse() {
        this.resp_code = "10005";
        this.resp_desc = "处理有误";
    }
}
