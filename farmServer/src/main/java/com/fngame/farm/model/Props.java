package com.fngame.farm.model;

import java.io.Serializable;

public class Props extends Goods implements Serializable {
    private Long id;

    private Long userid;

    private Integer baseid;

    private Integer count;

    private Integer warehouse;

    private Long ownerid;

    private Integer isinsale;

    private Integer price;

    private Integer isselloff;

    private Integer stallnumber;

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

    public Long getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(Long ownerid) {
        this.ownerid = ownerid;
    }

    public Integer getIsinsale() {
        return isinsale;
    }

    public void setIsinsale(Integer isinsale) {
        this.isinsale = isinsale;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getIsselloff() {
        return isselloff;
    }

    public void setIsselloff(Integer isselloff) {
        this.isselloff = isselloff;
    }

    public Integer getStallnumber() {
        return stallnumber;
    }

    public void setStallnumber(Integer stallnumber) {
        this.stallnumber = stallnumber;
    }
}