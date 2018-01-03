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

    public Building getBuildingByID(Long buildId) {
        BuildingMapper mapper = (BuildingMapper) BeanTools.getBean(BuildingMapper.class);
        BuildingExample exp = new BuildingExample();
        exp.clear();
        exp.createCriteria().andUseridEqualTo(getId()).andIdEqualTo(buildId);
        List<Building> buildings = mapper.selectByExample(exp);
        return buildings.isEmpty() ? null : buildings.get(0);
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
        List<Crops> crops = mapper.selectByExample(exp);
        return crops;
    }

    public Crops getCropByID(Long cropId) {
        CropsMapper mapper = (CropsMapper) BeanTools.getBean(CropsMapper.class);
        CropsExample exp = new CropsExample();
        exp.createCriteria().andIdEqualTo(cropId);
        List<Crops> crops = mapper.selectByExample(exp);
        return crops.isEmpty() ? null : crops.get(0);
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

    /*
    * 根据用户id获取所有已上架物品
    * */
    public List<StreetMarket> getStreetMarketInfoByUserId(Long userid) {
        StreetMarketMapper mapper = (StreetMarketMapper) BeanTools.getBean(StreetMarketMapper.class);
        StreetMarketExample exp = new StreetMarketExample();
        exp.clear();
        exp.createCriteria().andUseridEqualTo(userid);
        List<StreetMarket> streetMarketList = mapper.selectByExample(exp);
        return streetMarketList;
    }

    /*
    * 根据streetmarket id获取单行数据
    * */
    public StreetMarket getOneStreetMarketInfo(Long id) {
        StreetMarketMapper mapper = (StreetMarketMapper) BeanTools.getBean(StreetMarketMapper.class);
        StreetMarketExample exp = new StreetMarketExample();
        exp.clear();
        exp.createCriteria().andIdIsNotNull().andIdEqualTo(id);
        StreetMarket streetMarket = mapper.selectByPrimaryKey(id);
        return streetMarket;
    }

    /*
    *物品上架在streetmarket表中新增数据
    * */
    public boolean addStreetMarketGoods(StreetMarket streetMarket) {
        StreetMarketMapper mapper = (StreetMarketMapper) BeanTools.getBean(StreetMarketMapper.class);
        StreetMarketExample exp = new StreetMarketExample();
        exp.clear();
        int row = mapper.insertSelective(streetMarket);
        return row > 0;
    }

    /*
    * 更新streetmarket表中的数据（在购买地摊物品时更改物品状态）
    * */
    public boolean updateStreetMarketGoods(StreetMarket streetMarket) {
        StreetMarketMapper mapper = (StreetMarketMapper) BeanTools.getBean(StreetMarketMapper.class);
        StreetMarketExample exp = new StreetMarketExample();
        exp.clear();
        int row = mapper.updateByPrimaryKeySelective(streetMarket);
        return row > 0;
    }

    /*
    * 物品上架后在crops表或grops表中更新count值
    * */

    public boolean updateGoodsCountNumber(Goods goods, Integer flag) {
        int row;
        if (flag == 0) {
            Crops crop = (Crops) goods;
            row = cropsMapper.updateByPrimaryKeySelective(crop);
        } else {
            Props prop = (Props) goods;
            row = propsMapper.updateByPrimaryKeySelective(prop);
        }
        return row > 0;
    }

    /*
    * 添加购买物品：购买物品后，当玩家没有该物品信息，需要新增数据
    * */
    public boolean addBuyGoods(Goods goods, Integer flag) {
        int row;
        if (flag == 0) {
            Crops crop = (Crops) goods;
            row = cropsMapper.insertSelective(crop);
        } else {
            Props prop = (Props) goods;
            row = propsMapper.insertSelective(prop);
        }
        return row > 0;
    }

    /*
    * 物品下架后删除streetmarket表中数据
    * */
    public boolean deleteStreetMarketGoods(Long id) {
        StreetMarketMapper mapper = (StreetMarketMapper) BeanTools.getBean(StreetMarketMapper.class);
        StreetMarketExample exp = new StreetMarketExample();
        exp.clear();
        int row = mapper.deleteByPrimaryKey(id);
        return row > 0;
    }

    /*
    * 更新玩家数据:购买物品后玩家的金钱数增减
    * */
    public boolean updateUser(User user) {
        int row = userMapper.updateByPrimaryKeySelective(user);
        return row > 0;
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
        exp.createCriteria().andUseridEqualTo(getId());
        List<Props> props = mapper.selectByExample(exp);
        return props;
    }


    private List<Crops> s_crops;

    public List<Crops> getSellingCrops() {
        CropsMapper mapper = (CropsMapper) BeanTools.getBean(CropsMapper.class);
        CropsExample exp = new CropsExample();
        exp.clear();
        exp.createCriteria().andUseridEqualTo(getId());
        List<Crops> crops = mapper.selectByExample(exp);
        return crops;
    }

    private void andUseridEqualTo(long id) {
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
        criteria4.andUseridEqualTo(getId());
        criteria4.andBaseidEqualTo(baseid);
        criteria4.andUseridEqualTo(getId()).andBaseidEqualTo(baseid);
        List<Props> props = mapper.selectByExample(exp);
        return props.isEmpty() ? null : props.get(0);
    }

    public Crops getCropByBaseId(Integer baseid) {
        CropsMapper mapper = (CropsMapper) BeanTools.getBean(CropsMapper.class);
        CropsExample exp = new CropsExample();
        exp.clear();
        exp.createCriteria().andUseridEqualTo(getId()).andBaseidEqualTo(baseid);
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

    public void removeTeleBOOth(TeleBooth booth) {
        teleBoothMapper.deleteByPrimaryKey(booth.getId());
    }

    public PetData getPet(Long id) {
        List<PetData> pets = this.getPets();
        for (PetData pet : pets) {
            if (pet.getId().longValue() == id.longValue()) {
                return pet;
            }
        }
        return null;
    }


    public void addBuilding(Building building) {
        buildingMapper.insertSelective(building);
    }
}
