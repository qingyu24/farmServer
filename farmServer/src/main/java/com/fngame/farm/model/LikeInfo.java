package com.fngame.farm.model;

import java.io.Serializable;

public class LikeInfo implements Serializable {
    private Long likeid;

    private Long carinfoid;

    private Long userid;

    public Long getLikeid() {
        return likeid;
    }

    public void setLikeid(Long likeid) {
        this.likeid = likeid;
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
}