package com.fngame.farm.model;

import org.springframework.stereotype.Component;

import java.io.Serializable;

@Component
public class UserOrder implements Serializable{
    public Long id;

    public Long userid;

    public Integer baseid;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UserOrder userOrder = (UserOrder) o;

        if (id != null ? !id.equals(userOrder.id) : userOrder.id != null) return false;
        if (userid != null ? !userid.equals(userOrder.userid) : userOrder.userid != null) return false;
        return baseid != null ? baseid.equals(userOrder.baseid) : userOrder.baseid == null;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (userid != null ? userid.hashCode() : 0);
        result = 31 * result + (baseid != null ? baseid.hashCode() : 0);
        return result;
    }
}