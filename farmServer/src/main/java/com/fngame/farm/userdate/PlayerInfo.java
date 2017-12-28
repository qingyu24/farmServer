package com.fngame.farm.userdate;

import com.fngame.farm.manager.BaseAutowired;
import com.fngame.farm.manager.PlayerManager;
import com.fngame.farm.mapper.*;
import com.fngame.farm.model.*;
import com.fngame.farm.util.BeanTools;
import com.fngame.farm.util.DBList;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by qingyu on 2017/12/20.
 */
@Component
public class PlayerInfo implements Serializable{
    private long id;
    private User user;
    private List<Building> buildings;
    private List<Animal> animals;
    private List<Crops> crops;
    private List<UserOrder> orders;
    private List<Props> propss;
    private DBList<Friend> Friends;
    private List<CraftProduce> craftProduces;
    private List<TeleBooth> teleBooths;

    public PlayerInfo(long userID){
        id = userID;
    }

    //获取好友的列表;
    public List<FriendInfo> getFriendList() {

        FriendInfoMapper friendInfoMapper = (FriendInfoMapper) BeanTools.getBean(FriendInfoMapper.class);
        FriendInfoExample friendInfoExample = (FriendInfoExample) BeanTools.getBean(FriendInfoExample.class);
        friendInfoExample.clear();
        FriendInfoExample.Criteria criteria3 = friendInfoExample.createCriteria();
        criteria3.andUseridEqualTo(this.getId());
        List<FriendInfo> list = friendInfoMapper.selectByExample(friendInfoExample);
        return list;
    }

    //获取电话亭的数据列表;
    public List<TeleBooth> getTeleBooths() {
        TeleBoothMapper mapper = (TeleBoothMapper) BeanTools.getBean(TeleBoothMapper.class);
        TeleBoothExample tel = new TeleBoothExample();
        tel.clear();
        TeleBoothExample.Criteria criteria5 = tel.createCriteria();
        criteria5.andUseridEqualTo(this.getId());
        List<TeleBooth> teleBooths = mapper.selectByExample(tel);
        return teleBooths;
    }

    //获取用户的ID
    public long getId() {
        return id;
    }

    //?
    public List<CraftProduce> getCraftProduces() {

        CraftProduceMapper mapper = (CraftProduceMapper) BeanTools.getBean(CraftProduceMapper.class);
        CraftProduceExample exp = new CraftProduceExample();
        exp.clear();
        CraftProduceExample.Criteria criteria3 = exp.createCriteria();
        criteria3.andUseridEqualTo(getId());
        List<CraftProduce> craftProduces = mapper.selectByExample(exp);
        return craftProduces;
    }

    public List<Friend> getFriends() {
        FriendMapper mapper = (FriendMapper) BeanTools.getBean(FriendMapper.class);
        FriendExample exp = new FriendExample();
        exp.clear();
        FriendExample.Criteria criteria1 = exp.createCriteria();
        criteria1.andUseridEqualTo(getId());
        List<Friend> friends = mapper.selectByExample(exp);
        return friends;
    }

    public User getUser() {
        UserMapper mapper = (UserMapper) BeanTools.getBean(UserMapper.class);
        UserExample exp = new UserExample();
        exp.clear();
        exp.createCriteria().andUseridEqualTo(getId());
        List<User> users = mapper.selectByExample(exp);
        return users.isEmpty() ? null : users.get(0);
    }

    public List<Props> getPropss() {
        return propss;
    }

    public void setPropss(List<Props> propss) {
        this.propss = propss;
    }

    public List<Building> getBuildings() {
        return buildings;
    }

    public void setBuildings(List<Building> buildings) {
        this.buildings = buildings;
    }

    public List<Animal> getAnimals() {
        return animals;
    }

    public void setAnimals(List<Animal> animals) {
        this.animals = animals;
    }

    public List<Crops> getCrops() {
        return crops;
    }

    public void setCrops(List<Crops> crops) {
        this.crops = crops;
    }

    public List<UserOrder> getOrders() {
        return orders;
    }

    public void setOrders(List<UserOrder> orders) {
        this.orders = orders;
    }

    HashMap<String, Object> map = new HashMap<>();

    private List hous_crop = new ArrayList();

    public List getWarehouse() {

        hous_crop.clear();
        for (Crops crop : crops) {
            if (crop.getWarehouse() == 1) {
                hous_crop.add(crop);
            }
        }
        return hous_crop;
    }

    private List<Props> s_props;

    public List<Props> insalProps() {
        if (s_props == null) s_props = new ArrayList<Props>(10);
        s_props.clear();
        for (Props props : this.propss) {
            if (props.getIsinsale() > 0) {
                s_props.add(props);
            }
        }
        return s_props;
    }


    private List<Crops> s_crops;

    public List<Crops> insalCrops() {
        if (s_crops == null) s_crops = new ArrayList<Crops>(10);
        s_crops.clear();
        for (Crops crops : this.crops) {
            if (crops.getIsinsale() > 0) {
                s_crops.add(crops);
            }
        }
        return s_crops;
    }


    public void UpdatePlayer() {
        PlayerManager bean = (PlayerManager) BeanTools.getBean(PlayerManager.class);
        bean.UpdatePlayer(this);
    }

    public Props getonProps(Integer baseid) {
        List<Props> propss = this.getPropss();
        if(propss==null)return  null;
        for (Props props : propss) {
            if(props.getBaseid()==baseid)return props;
        }
    return null;
    }

    public Crops getOneCrops(Integer baseid) {
        List<Crops> cropss = this.getCrops();
        if(cropss==null)return  null;
        for (Crops crops : cropss) {
            if(crops.getBaseid()==baseid)return crops;
        }
        return null;
    }

    public Crops getOneGoods(Integer baseid) {
        List<Crops> cropss = this.getCrops();
        if(cropss==null)return  null;
        for (Crops crops : cropss) {
            if(crops.getBaseid()==baseid)return crops;
        }
        return null;
    }

}
