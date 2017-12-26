package com.fngame.farm.model;

import com.fngame.farm.mapper.TeleBoothMapper;
import com.fngame.farm.util.BeanTools;

import java.util.Date;

public class TeleBooth {
    private Long id;

    private Long userid;

    private Integer type;

    private Integer baseid;

    private Date begintime;

    private Integer count;

    private Integer money;

    private Integer achieve;

    private static long maxID;

    private  long getMaxID() {
        if (maxID == 0) {
            TeleBoothMapper bean = (TeleBoothMapper) BeanTools.getBean(TeleBoothMapper.class);

            try {
                maxID = bean.getMaxID();
            } catch (Exception e) {
                maxID = 10000;
            }

        }
        return ++maxID;
    }

    public TeleBooth() {
        this.id=this.getMaxID();
    }

    public Long getId() {
        return id;
    }

    public void setId() {

        this.id = this.getMaxID();
    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getBaseid() {
        return baseid;
    }

    public void setBaseid(Integer baseid) {
        this.baseid = baseid;
    }

    public Date getBegintime() {
        return begintime;
    }

    public void setBegintime(Date begintime) {
        this.begintime = begintime;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getAchieve() {
        return achieve;
    }

    public void setAchieve(Integer achieve) {
        this.achieve = achieve;
    }
}