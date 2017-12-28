package com.fngame.farm.model;

import java.io.Serializable;

/**
 * Created by qingyu on 2017/12/27 /11:11
 */
public class Goods implements Serializable{
    private Long id;

    private Long userid;

    private Integer baseid;

    private Integer warehouse;

    private Integer count;


    private Integer isinsale;

    private Integer price;

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

    public Integer getWarehouse() {
        return warehouse;
    }

    public void setWarehouse(Integer warehouse) {
        this.warehouse = warehouse;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
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
}
