package com.fngame.farm.userdate;

import com.fngame.farm.manager.BaseAutowired;
import com.fngame.farm.manager.PlayerManager;
import com.fngame.farm.mapper.*;
import com.fngame.farm.model.*;
import com.fngame.farm.util.BeanTools;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by qingyu on 2017/12/20.
 */
@Component
@Scope("prototype")
public class PlayerInfo extends BaseAutowired implements Serializable {
    private long id;

    public PlayerInfo(long userID) {
        id = userID;
    }

    public void setId(long id) {
        this.id = id;
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
        PropsMapper mapper = (PropsMapper) BeanTools.getBean(PropsMapper.class);
        PropsExample exp = new PropsExample();
        exp.clear();
        PropsExample.Criteria criteria4 = exp.createCriteria();
        criteria4.andUseridEqualTo(getId());
        List<Props> props = mapper.selectByExample(exp);
        return props;
    }


    public List<Building> getBuildings() {
        BuildingMapper mapper = (BuildingMapper) BeanTools.getBean(BuildingMapper.class);
        BuildingExample exp = new BuildingExample();
        exp.clear();
        exp.createCriteria().andUseridEqualTo(getId());
        List<Building> buildings = mapper.selectByExample(exp);
        return buildings;
    }

    public List<Animal> getAnimals() {
        AnimalMapper mapper = (AnimalMapper) BeanTools.getBean(AnimalMapper.class);
        AnimalExample exp = new AnimalExample();
        exp.clear();
        AnimalExample.Criteria criteria2 = exp.createCriteria();
        criteria2.andUseridEqualTo(getId());
        List<Animal> animals = mapper.selectByExample(exp);
        return animals;
    }

    public List<Crops> getCrops() {
        CropsMapper mapper = (CropsMapper) BeanTools.getBean(CropsMapper.class);
        CropsExample exp = new CropsExample();
        exp.clear();
        exp.createCriteria().andUseridEqualTo(getId());
        exp.createCriteria().andWarehouseEqualTo(1);
        List<Crops> crops = mapper.selectByExample(exp);
        return crops;
    }

    public List<UserOrder> getOrders() {
        UserOrderMapper mapper = (UserOrderMapper) BeanTools.getBean(UserOrderMapper.class);
        UserOrderExample exp = new UserOrderExample();
        exp.clear();
        UserOrderExample.Criteria criteria = exp.createCriteria();
        criteria.andUseridEqualTo(getId());
        List<UserOrder> orders = mapper.selectByExample(exp);
        return orders;
    }


 /*   public List getWarehouse() {
        CropsMapper  mapper = (CropsMapper) BeanTools.getBean(CropsMapper.class);
        CropsExample exp = new CropsExample();
        exp.clear();
        exp.createCriteria().andUseridEqualTo(getId());
        exp.createCriteria().andWarehouseEqualTo(1);
        List<Crops> crops = mapper.selectByExample(exp);
        return crops;
    }*/

    private List<Props> s_props;

    public List<Props> getSellingProps() {
        PropsMapper mapper = (PropsMapper) BeanTools.getBean(PropsMapper.class);
        PropsExample exp = new PropsExample();
        exp.clear();
        PropsExample.Criteria criteria4 = exp.createCriteria();
        criteria4.andUseridEqualTo(getId());
        criteria4.andIsinsaleGreaterThan(0);
        List<Props> props = mapper.selectByExample(exp);
        return props;
    }


    private List<Crops> s_crops;

    public List<Crops> getSellingCrops() {
        CropsMapper mapper = (CropsMapper) BeanTools.getBean(CropsMapper.class);
        CropsExample exp = new CropsExample();
        exp.clear();
        exp.createCriteria().andUseridEqualTo(getId());
        exp.createCriteria().andIsinsaleGreaterThan(0);
        List<Crops> crops = mapper.selectByExample(exp);
        return crops;
    }


    public void UpdatePlayer() {
        PlayerManager bean = (PlayerManager) BeanTools.getBean(PlayerManager.class);
        bean.UpdatePlayer(this);
    }

    public Props getPropByBaseId(Integer baseid) {
        PropsMapper mapper = (PropsMapper) BeanTools.getBean(PropsMapper.class);
        PropsExample exp = new PropsExample();
        exp.clear();
        PropsExample.Criteria criteria4 = exp.createCriteria();
        criteria4.andUseridEqualTo(getId());
        criteria4.andBaseidEqualTo(baseid);
        List<Props> props = mapper.selectByExample(exp);
        return props.isEmpty() ? null : props.get(0);
    }

    public Crops getCropByBaseId(Integer baseid) {
        CropsMapper mapper = (CropsMapper) BeanTools.getBean(CropsMapper.class);
        CropsExample exp = new CropsExample();
        exp.clear();
        exp.createCriteria().andUseridEqualTo(getId());
        exp.createCriteria().andBaseidEqualTo(baseid);
        List<Crops> crops = mapper.selectByExample(exp);
        return crops.isEmpty() ? null : crops.get(0);
    }

    public Goods getOneGoods(Integer baseid) {
        Crops cropss = this.getCropByBaseId(baseid);
        if (cropss == null) {
            return this.getPropByBaseId(baseid);
        }
        return cropss;
    }

    public List<PetData> getPets() {
        PetDataMapper bean = (PetDataMapper) BeanTools.getBean(PetDataMapper.class);
        PetDataExample pe = new PetDataExample();
        pe.clear();
        pe.createCriteria().andUseridEqualTo(getId());
        List<PetData> petData = bean.selectByExample(pe);
        return petData == null ? new ArrayList<PetData>(0) : petData;
    }

    public void addPet(PetData petData) {
        petDataMapper.insertSelective(petData);
    }

    public void updatePet(PetData petData) {
        petDataMapper.updateByPrimaryKeySelective(petData);
    }
}
