package com.fngame.farm.model;

import com.fngame.farm.configer.Pets;
import com.fngame.farm.configer.skill;
import com.fngame.farm.service.PetService;
import com.fngame.farm.util.BeanTools;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.Date;
@Component
public class PetData implements Serializable {
    private Long id;

    private Long userid;

    private Integer baseid;

    private Integer status;

    private Date begintime;

    private Long targetid;

    private Integer skillstatus;

    private Integer propsid;

    private Integer gettype;

    private Long lefttime;

    public Integer getSkillid() {
        return skillid;
    }

    public void setSkillid(Integer skillid) {
        this.skillid = skillid;
    }

    private Integer skillid;


    public Long getLefttime() {

        return lefttime;
    }

    public void setLefttime(Long lefttime) {
        this.lefttime = lefttime;
    }

    public Integer getGettype() {
        return gettype;
    }

    public void setGettype(Integer gettype) {
        this.gettype = gettype;
    }

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
}