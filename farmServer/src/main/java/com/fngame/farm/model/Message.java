package com.fngame.farm.model;

import java.io.Serializable;

public class Message implements Serializable {
    private Long msgid;

    private Long carinfoid;

    private Long userid;

    private String content;

    public Long getMsgid() {
        return msgid;
    }

    public void setMsgid(Long msgid) {
        this.msgid = msgid;
    }

    public Long getCarinfoid() {
        return carinfoid;
    }

    public void setCarinfoid(Long carinfoid) {
        this.carinfoid = carinfoid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}