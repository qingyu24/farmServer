package com.fngame.farm.model;

import java.io.Serializable;

/**
 * Created by qingyu on 2017/12/27 /11:11
 */
public class Goods implements Serializable{
    private Long id;

    private Long userid;

    private Integer baseid;


    private Integer count;


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


}
