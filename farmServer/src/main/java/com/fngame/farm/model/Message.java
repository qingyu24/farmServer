package com.fngame.farm.model;

import java.io.Serializable;
import java.util.Date;

public class Message implements Serializable {
    private Long msgid;

    private Long carinfoid;

    private Long fromUserid;

    private Long toUserid;

    private Date date;

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

    public Long getFromUserid() {
        return fromUserid;
    }

    public void setFromUserid(Long fromUserid) {
        this.fromUserid = fromUserid;
    }

    public Long getToUserid() {
        return toUserid;
    }

    public void setToUserid(Long toUserid) {
        this.toUserid = toUserid;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}