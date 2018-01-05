package com.fngame.farm.userdate;

import com.fngame.farm.configer.Craft;
import com.fngame.farm.etypes.EFriendType;
import com.fngame.farm.manager.BaseAutowired;
import com.fngame.farm.manager.ConfigManager;
import com.fngame.farm.manager.PlayerManager;
import com.fngame.farm.mapper.*;
import com.fngame.farm.model.*;
import com.fngame.farm.util.BeanTools;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
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
        FriendInfoExample friendInfoExample = new FriendInfoExample();
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

    //获得合成列表组;
    public List<CraftProduce> getCraftProduces() {

        CraftProduceMapper mapper = (CraftProduceMapper) BeanTools.getBean(CraftProduceMapper.class);
        CraftProduceExample exp = new CraftProduceExample();
        exp.clear();
        CraftProduceExample.Criteria criteria3 = exp.createCriteria();
        criteria3.andUseridEqualTo(getId());
        List<CraftProduce> craftProduces = mapper.selectByExample(exp);
        return craftProduces;
    }

    public CraftProduce getCraftListById(Long id) {

        CraftProduceMapper mapper = (CraftProduceMapper) BeanTools.getBean(CraftProduceMapper.class);
        CraftProduceExample exp = new CraftProduceExample();
        exp.clear();
        CraftProduceExample.Criteria criteria3 = exp.createCriteria();
        criteria3.andUseridEqualTo(getId()).andIdEqualTo(id);
        List<CraftProduce> craftProduces = mapper.selectByExample(exp);
        return craftProduces.isEmpty() ? null : craftProduces.get(0);
    }

    //根据建筑物的id获取正在生产的物品的列表;
    public List<CraftProduce> getCraftListByBuildingId(Long buildingId) {

        CraftProduceMapper mapper = (CraftProduceMapper) BeanTools.getBean(CraftProduceMapper.class);
        CraftProduceExample exp = new CraftProduceExample();
        exp.clear();
        CraftProduceExample.Criteria criteria3 = exp.createCriteria();
        criteria3.andUseridEqualTo(getId()).andBuildingidEqualTo(buildingId);
        List<CraftProduce> craftProduces = mapper.selectByExample(exp);
        return craftProduces;
    }

      
     /*插入一个待生产的物品;
     * @param type 物品的类型 参考EItemType
     * @param buildingId //目标建筑的id；
     * @param itemId //物品的基础表的ID；
     */
    public CraftProduce insertCraft(int type, Long buildingId, int itemId){

        Craft baseCraft = ConfigManager.getInstance().getCraftById(itemId);
        if (null == baseCraft){
            return null;
        }
        List<CraftProduce> list = getCraftListByBuildingId(buildingId);
        CraftProduceMapper mapper = (CraftProduceMapper) BeanTools.getBean(CraftProduceMapper.class);
     
        CraftProduce craft  = new CraftProduce();

        craft.setBegintime(new Date());
        craft.setUserid(getId());
        craft.setType(type);
        craft.setBuildingid(buildingId);
        craft.setProductbaseid(itemId);
        craft.setSize(baseCraft.OutputNum);
        craft.setInproduce(list.size()); //排队待生产列表;
        mapper.insertSelective(craft);
        return craft;
    }

    /**
     * 原材料是否充足;
     * @param baseId
     * @return
     */
    public boolean isEnoughStuff(int baseId) {
        Craft baseCraft = ConfigManager.getInstance().getCraftById(baseId);
        ArrayList<Integer> list = new ArrayList<Integer>();
        String[] str = baseCraft.Staff.split("|");
        for (int i = 0; i < str.length; ++i) {
            String[] obj = str[i].split("_");
            int id = Integer.parseInt(obj[0]);
            int count = Integer.parseInt(obj[1]);
            Goods good = getOneGoods(id);
            if (null == good || good.getCount() < count) {
                return false;
            }
        }
        return true;
    }

    public boolean removeCraftById(Long id){
        CraftProduceMapper mapper = (CraftProduceMapper) BeanTools.getBean(CraftProduceMapper.class);
        int count = mapper.deleteByPrimaryKey(id);
        return count > 0;
    }

    //根据建筑的id获得某一个正在合成的物品;
    public CraftProduce getCraftByBuildingId(Long buildingId) {

        CraftProduceMapper mapper = (CraftProduceMapper) BeanTools.getBean(CraftProduceMapper.class);
        CraftProduceExample exp = new CraftProduceExample();
        exp.clear();
        CraftProduceExample.Criteria criteria3 = exp.createCriteria();
        criteria3.andUseridEqualTo(getId()).andBuildingidEqualTo(buildingId);
        List<CraftProduce> craftProduces = mapper.selectByExample(exp);
        return craftProduces.isEmpty() ? null : craftProduces.get(0);
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


    /**
     * 获取农作的列表;
     * @return
     */
    public List<Props> getCrops() {
        PropsMapper mapper = (PropsMapper) BeanTools.getBean(PropsMapper.class);
        PropsExample exp = new PropsExample();
        exp.clear();
        exp.createCriteria().andUseridEqualTo(getId()).andTypeEqualTo(1);
        List<Props> props = mapper.selectByExample(exp);
        return props;
    }

    //添加一个农作物;

 
    public Props addProp(int baseId, int count) {
        PropsMapper mapper = (PropsMapper) BeanTools.getBean(PropsMapper.class);

        Props c = getPropByBaseId(baseId);

        if (null != c) {
            c.setCount(c.getCount() + count);
            return c;
 
        } else {
            Props crop = new Props();
            crop.setUserid(getId());
            crop.setBaseid(baseId);
            crop.setStatus(0);
            crop.setTargetId(0L);
            crop.setCount(count);
            mapper.insertSelective(crop);
            return crop;
        }
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
        StreetMarket streetMarket = mapper.selectByPrimaryKey(id);
        return streetMarket;
    }

    /*
    *物品上架在streetmarket表中新增数据
    * */
    public boolean addStreetMarketGoods(StreetMarket streetMarket) {
        StreetMarketMapper mapper = (StreetMarketMapper) BeanTools.getBean(StreetMarketMapper.class);
        int row = mapper.insertSelective(streetMarket);
        return row > 0;
    }

    /*
    * 更新streetmarket表中的数据（在购买地摊物品时更改物品状态）
    * */
    public boolean updateStreetMarketGoods(StreetMarket streetMarket) {
        StreetMarketMapper mapper = (StreetMarketMapper) BeanTools.getBean(StreetMarketMapper.class);
        int row = mapper.updateByPrimaryKeySelective(streetMarket);
        return row > 0;
    }

    /*
    * 物品上架后在crops表或grops表中更新count值
    * */


    public boolean updateGoodsCountNumber(Props props) {
        int row;
        row = propsMapper.updateByPrimaryKeySelective(props);
        return row > 0;
    }

    /*
    * 添加购买物品：购买物品后，当玩家没有该物品信息，需要新增数据
    * */
 
    public boolean addBuyGoods(Props props) {
        int row;
        row = propsMapper.insertSelective(props);
        return row > 0;
    }

    /*
    * 物品下架后删除streetmarket表中数据
    * */
    public boolean deleteStreetMarketGoods(Long id) {
        StreetMarketMapper mapper = (StreetMarketMapper) BeanTools.getBean(StreetMarketMapper.class);
        int row = mapper.deleteByPrimaryKey(id);
        return row > 0;
    }

    /*
    * 查询玩家对应的摊位上是否有物品
    * */
    public StreetMarket isEqualsStallNumber(Long userid,Integer stallnumber){
        StreetMarketMapper mapper = (StreetMarketMapper) BeanTools.getBean(StreetMarketMapper.class);
        StreetMarketExample exp = new StreetMarketExample();
        exp.clear();
        exp.createCriteria().andUseridEqualTo(userid).andStallnumberEqualTo(stallnumber);
        List<StreetMarket> streetMarketList = mapper.selectByExample(exp);
        return streetMarketList.isEmpty() ? null : streetMarketList.get(0);
    }



    /**
     *@Author:Tian
     *@Description: 物品上架后仓库中的count数若为0，则删除仓库的这条数据
     *@Date: 12:28 2018/1/4
     */

    public boolean deleteGoods(Props props){
        int row;
        row = propsMapper.deleteByPrimaryKey(props.getId());
        return row > 0;
    }


    /*
    * 更新玩家数据:购买物品后玩家的金钱数增减
    * */
    public boolean updateUser(User user) {
        int row = userMapper.updateByPrimaryKeySelective(user);
        return row > 0;
    }

    /**
     *@Author:Tian
     *@Description: 获取车库信息
     *@Date: 10:17 2018/1/4
     */
    public List<CarInfo> getCarInfoByUserId(Long userid){
        CarInfoMapper mapper = (CarInfoMapper) BeanTools.getBean(CarInfoMapper.class);
        CarInfoExample exp = new CarInfoExample();
        exp.clear();
        exp.createCriteria().andUseridEqualTo(userid);
        List<CarInfo> carInfoList = mapper.selectByExample(exp);
        return carInfoList;
    }

    public CarInfo getOneCarInfo(long carinfoid){
        CarInfoMapper mapper = (CarInfoMapper) BeanTools.getBean(CarInfoMapper.class);
        CarInfo carInfo=mapper.selectByPrimaryKey(carinfoid);
        return carInfo;
    }

    /**
     *@Author:Tian
     *@Description: 获取留言信息
     *@Date: 19:06 2018/1/4
     */
    public List<Message> getMessage(Long carinfoid){
        MessageMapper mapper = (MessageMapper)BeanTools.getBean(MessageMapper.class);
        MessageExample exp = new MessageExample();
        exp.clear();
        exp.createCriteria().andCarinfoidEqualTo(carinfoid);
        List<Message> messageList = mapper.selectByExampleWithBLOBs(exp);
        return messageList;
    }

    /**
     *@Author:Tian
     *@Description: 获得点赞数量
     *@Date: 19:42 2018/1/4
     */
    public Integer getLikeInfoCount(Long carinfoid){
        LikeInfoMapper mapper = (LikeInfoMapper)BeanTools.getBean(LikeInfoMapper.class);
        LikeInfoExample exp = new LikeInfoExample();
        exp.clear();
        exp.createCriteria().andCarinfoidEqualTo(carinfoid);
        int likeinfonum=mapper.countByExample(exp);
        return likeinfonum;
    }

    /**
     *@Author:Tian
     *@Description: 判断玩家是否已点过赞
     *@Date: 19:55 2018/1/4
     */
    public boolean userIsLikeInfo(Long carinfoid,Long userid){
        LikeInfoMapper mapper = (LikeInfoMapper)BeanTools.getBean(LikeInfoMapper.class);
        LikeInfoExample exp = new LikeInfoExample();
        exp.clear();
        exp.createCriteria().andCarinfoidEqualTo(carinfoid).andUseridEqualTo(userid);
        List<LikeInfo> likeInfoList = mapper.selectByExample(exp);
        if(likeInfoList==null||likeInfoList.size()==0){
            return false;
        }else {
            return true;
        }
    }

    /**
     *@Author:Tian
     *@Description: 点赞功能
     *@Date: 10:03 2018/1/5
     */
    public boolean addLikeInfo(LikeInfo likeInfo){
        LikeInfoMapper mapper = (LikeInfoMapper)BeanTools.getBean(LikeInfoMapper.class);
        int row = mapper.insertSelective(likeInfo);
        return row>0;
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

    public void UpdatePlayer() {
        PlayerManager bean = (PlayerManager) BeanTools.getBean(PlayerManager.class);
        bean.UpdatePlayer(this);
    }

    public Props getPropByBaseId(Integer baseid) {
        PropsMapper mapper = (PropsMapper) BeanTools.getBean(PropsMapper.class);
        PropsExample exp = new PropsExample();
        exp.clear();
        PropsExample.Criteria criteria4 = exp.createCriteria();
        criteria4.andUseridEqualTo(getId()).andBaseidEqualTo(baseid);
        List<Props> props = mapper.selectByExample(exp);
        return props.isEmpty() ? null : props.get(0);

    }


    public Props getPropById(Long Id) {
        PropsMapper mapper = (PropsMapper) BeanTools.getBean(PropsMapper.class);
        PropsExample exp = new PropsExample();
        exp.clear();

        PropsExample.Criteria criteria4 = exp.createCriteria();
        criteria4.andUseridEqualTo(getId()).andIdEqualTo(Id.longValue());
        List<Props> props = mapper.selectByExample(exp);

        return props.isEmpty() ? null : props.get(0);

    }


    /**
     * 从粮仓或者货仓里面获取一个道具;
     * @param baseid
     * @return
     */
    public Goods getOneGoods(Integer baseid) {
        Props cropss = this.getPropByBaseId(baseid);
        return cropss;
    }

    /**
     * 根据id从粮仓或者货仓里面删除一组道具;
     * @param id
     * @return
     */
    public boolean removeGoodsById(int id){

        return true;
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

    public void updateCraft(CraftProduce craftProduce) {
        craftProduceMapper.updateByPrimaryKeySelective(craftProduce);
    }

    public Building getOneBuilding(Long rubbishid) {

        return buildingMapper.selectByPrimaryKey(rubbishid);

    }

    public void removeBuilding(Building oneBuilding) {
        buildingMapper.deleteByPrimaryKey(oneBuilding.getId());
    }

    public List<Friend> getAgreeFriends(Long userid) {
        FriendExample friendExample = new FriendExample();
        friendExample.clear();
        FriendExample.Criteria criteria = friendExample.createCriteria();
        criteria.andUseridEqualTo(userid).andAgreeEqualTo(EFriendType.AGREE.ID());
        return  friendMapper.selectByExample(friendExample);


    }
}
