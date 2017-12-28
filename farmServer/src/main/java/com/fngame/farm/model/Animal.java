package com.fngame.farm.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.Date;
@Component

public class Animal implements Serializable{
    private Long id;

    private Integer baseid;

    private Long userid;

    private Integer count;

    private Integer warehouse;

    private Integer ownerid;

    private Date feedtime;

    private Integer canreap;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getBaseid() {
        return baseid;
    }

    public void setBaseid(Integer baseid) {
        this.baseid = baseid;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Integer warehouse) {
        this.warehouse = warehouse;
    }

    public Integer getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Integer ownerid) {
        this.ownerid = ownerid;
    }

    public Date getFeedtime() {
        return feedtime;
    }

    public void setFeedtime(Date feedtime) {
        this.feedtime = feedtime;
    }

    public Integer getCanreap() {
        return canreap;
    }

    public void setCanreap(Integer canreap) {
        this.canreap = canreap;
    }
}