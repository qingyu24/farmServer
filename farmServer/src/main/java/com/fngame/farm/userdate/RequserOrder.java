package com.fngame.farm.userdate;

import org.springframework.stereotype.Component;

@Component
public class RequserOrder {
    public String main;
    public String sub;

    public String getMain() {
        return main;
    }

    public void setMain(String main) {
        this.main = main;
    }

    public String getSub() {
        return sub;
    }

    public void setSub(String sub) {
        this.sub = sub;
    }
}
