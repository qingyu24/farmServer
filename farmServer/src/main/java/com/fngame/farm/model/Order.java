package com.fngame.farm.model;

public class Order {
    private Long id;

    private Long userid;

    private Integer baseid;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getBaseid() {
        return baseid;
    }

    public void setBaseid(Integer baseid) {
        this.baseid = baseid;
    }
}