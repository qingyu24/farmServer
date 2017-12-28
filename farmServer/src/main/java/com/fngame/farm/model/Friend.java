package com.fngame.farm.model;

import java.io.Serializable;

public class Friend implements Serializable {
    private Long id;

    private Long userid;

    private Long friendid;

    private Integer agree;

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

    public Long getFriendid() {
        return friendid;
    }

    public void setFriendid(Long friendid) {
        this.friendid = friendid;
    }

    public Integer getAgree() {
        return agree;
    }

    public void setAgree(Integer agree) {
        this.agree = agree;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Friend friend = (Friend) o;

        if (userid != null ? !userid.equals(friend.userid) : friend.userid != null) return false;
        return friendid != null ? friendid.equals(friend.friendid) : friend.friendid == null;
    }

    @Override
    public int hashCode() {
        int result = userid != null ? userid.hashCode() : 0;
        result = 31 * result + (friendid != null ? friendid.hashCode() : 0);
        return result;
    }

    public Friend change() {
        long s = userid;
        userid = friendid;
        friendid = s;
        return this;
    }

}