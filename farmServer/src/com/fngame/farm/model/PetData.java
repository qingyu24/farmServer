package com.fngame.farm.model;

import java.util.Date;

public class PetData implements s{
    private Long id;

    private Long userid;

    private Integer baseid;

    private Integer status;

    private Date begintime;

    private Long targetid;

    private Integer skillstatus;

    private Integer propsid;

    private Integer skillid;

    private Integer propscount;

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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Long getTargetid() {
        return targetid;
    }

    public void setTargetid(Long targetid) {
        this.targetid = targetid;
    }

    public Integer getSkillstatus() {
        return skillstatus;
    }

    public void setSkillstatus(Integer skillstatus) {
        this.skillstatus = skillstatus;
    }

    public Integer getPropsid() {
        return propsid;
    }

    public void setPropsid(Integer propsid) {
        this.propsid = propsid;
    }

    public Integer getSkillid() {
        return skillid;
    }

    public void setSkillid(Integer skillid) {
        this.skillid = skillid;
    }

    public Integer getPropscount() {
        return propscount;
    }

    public void setPropscount(Integer propscount) {
        this.propscount = propscount;
    }
}