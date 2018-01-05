package com.fngame.farm.model;


import java.io.Serializable;
import java.util.Date;

public class TeleBooth implements Serializable {
    private Long id;

    private Long userid;

    private Integer type;

    private Integer baseid;

    private Date begintime;

    private Integer count;

    private Integer money;

    private Integer achieve;

    private Long lefttime;

    public Long getLefttime() {
        try {
            long begintime = this.getBegintime().getTime() + 6 * 60 * 60 * 1000 - System.currentTimeMillis();
            long leftTime = Math.max(begintime, 0);
            lefttime = leftTime;
        } catch (Exception e) {
            e.printStackTrace();
            lefttime = 0L;
        }
        return lefttime;
    }

    public void setLefttime(Long lefttime) {
        this.lefttime = lefttime;
    }


    public Long getId() {
        return id;
    }


    public void setId(long id) {

        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getBaseid() {
        return baseid;
    }

    public void setBaseid(Integer baseid) {
        this.baseid = baseid;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getAchieve() {
        return achieve;
    }

    public void setAchieve(Integer achieve) {
        this.achieve = achieve;
    }
}