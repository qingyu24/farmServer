package com.fngame.farm.userdate;

import com.fngame.farm.manager.BaseAutowired;
import com.fngame.farm.manager.PlayerManager;
import com.fngame.farm.mapper.FriendInfoMapper;
import com.fngame.farm.model.*;
import com.fngame.farm.util.BeanTools;
import com.fngame.farm.util.DBList;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by qingyu on 2017/12/20.
 */
@Component
public class PlayerInfo extends BaseAutowired {
    private long id;
    private User user;
    private List<Building> buildings;
    private List<Animal> animals;
    private List<Crops> crops;
    private List<UserOrder> orders;
    private List<Props> propss;
    private DBList<Friend> Friends;
    private List<FriendInfo> FriendsInfo;
    private List<CraftProduce> craftProduces;
    private List<TeleBooth> teleBooths;



    public List<FriendInfo> getFriendsInfo() {

        FriendInfoMapper friendInfoMapper = (FriendInfoMapper) BeanTools.getBean(FriendInfoMapper.class);
        FriendInfoExample friendInfoExample = (FriendInfoExample) BeanTools.getBean(FriendInfoExample.class);
        if (Friends.isChange()) {
            Friends.setChange(false);
            friendInfoExample.clear();
            FriendInfoExample.Criteria criteria3 = friendInfoExample.createCriteria();
            criteria3.andUseridEqualTo(this.getId());
            List<FriendInfo> friendInfos = friendInfoMapper.selectByExample(friendInfoExample);
            this.setFriendsInfo(friendInfos);
        }
        return FriendsInfo;
    }
    public List<TeleBooth> getTeleBooths() {
        return teleBooths;
    }

    public void setTeleBooths(List<TeleBooth> teleBooths) {
        this.teleBooths = teleBooths;
    }

    public void setFriendsInfo(List<FriendInfo> friendsInfo) {
        FriendsInfo = friendsInfo;
    }


    public long getId() {

        if (user != null) {
            id = user.getUserid();
        } else id = 0;
        return id;
    }

    public List<CraftProduce> getCraftProduces() {
        return craftProduces;
    }

    public void setCraftProduces(List<CraftProduce> craftProduces) {
        this.craftProduces = craftProduces;
    }

    public List<Friend> getFriends() {

        return (List) Friends;
    }

    public void setFriends(List<Friend> Friends) {
        if (this.Friends == null)
            this.Friends = new DBList();

        this.Friends.clear();
        this.Friends.addAll(Friends);
    }

    public void setId(long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
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

        PlayerManager.getInstance().UpdatePlayer(this);
    }

}
