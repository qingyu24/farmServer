package com.fngame.farm.util;

import com.fngame.farm.manager.PlayerManager;
import com.fngame.farm.model.User;
import com.fngame.farm.userdate.PlayerInfo;
import org.springframework.stereotype.Component;

/**
 * Created by qingyu on 2018/1/4 /17:04
 */

public class PlayerMessage {
    private Long userid;

    private Integer level;

    private Integer exp;

    private Integer score;

    private Integer money;

    private Integer icon;

    private Integer beans;

    private Integer ingot;


    public PlayerMessage(Long userid) {
        PlayerManager mane = (PlayerManager) BeanTools.getBean(PlayerManager.class);

        PlayerInfo player = mane.getPlayer(userid);
        if (player != null) {
            User user = player.getUser();
            if (user != null) {
             this.userid=user.getUserid();
             this.level=user.getLevel();
             this.exp=user.getExp();
             this.score=user.getScore();
             this.money=user.getMoney();
             this.icon=user.getIcon();
             this.beans=user.getBeans();
             this.ingot=user.getIngot();
            }
        }


    }

    public Long getUserid() {
        return userid;
    }

    public void setUserid(Long userid) {
        this.userid = userid;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getExp() {
        return exp;
    }

    public void setExp(Integer exp) {
        this.exp = exp;
    }

    public Integer getScore() {
        return score;
    }

    public void setScore(Integer score) {
        this.score = score;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }

    public Integer getIcon() {
        return icon;
    }

    public void setIcon(Integer icon) {
        this.icon = icon;
    }

    public Integer getBeans() {
        return beans;
    }

    public void setBeans(Integer beans) {
        this.beans = beans;
    }

    public Integer getIngot() {
        return ingot;
    }

    public void setIngot(Integer ingot) {
        this.ingot = ingot;
    }
}
