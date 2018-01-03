package com.fngame.farm.model;

public class StreetMarket {
    private Long id;

    private Long userid;

    private Integer baseid;

    private Integer onshelfnum;

    private Integer price;

    private Integer isselloff;

    private Integer stallnumber;

    private Integer flag;

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

    public Integer getOnshelfnum() {
        return onshelfnum;
    }

    public void setOnshelfnum(Integer onshelfnum) {
        this.onshelfnum = onshelfnum;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Integer getIsselloff() {
        return isselloff;
    }

    public void setIsselloff(Integer isselloff) {
        this.isselloff = isselloff;
    }

    public Integer getStallnumber() {
        return stallnumber;
    }

    public void setStallnumber(Integer stallnumber) {
        this.stallnumber = stallnumber;
    }

    public Integer getFlag() {
        return flag;
    }

    public void setFlag(Integer flag) {
        this.flag = flag;
    }
}