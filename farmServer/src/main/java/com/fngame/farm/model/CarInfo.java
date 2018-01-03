package com.fngame.farm.model;

import java.io.Serializable;

public class CarInfo implements Serializable {
    private Long carinfoid;

    private Long userid;

    private Integer carid;

    private Integer parking;

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

    public Integer getCarid() {
        return carid;
    }

    public void setCarid(Integer carid) {
        this.carid = carid;
    }

    public Integer getParking() {
        return parking;
    }

    public void setParking(Integer parking) {
        this.parking = parking;
    }
}