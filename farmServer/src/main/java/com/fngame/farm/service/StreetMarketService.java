package com.fngame.farm.service;

import com.fngame.farm.manager.PlayerManager;
import com.fngame.farm.model.*;
import com.fngame.farm.userdate.PlayerInfo;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

@Service
public class StreetMarketService {
    @Autowired
    PlayerManager PlayerManager;

    private static final Integer SELLOFF = 0;//表示卖出（已售）
    private static final Integer NOSELLOFF = 1;//表示未卖出
    private static  final Integer MAXCAPACITY = 20;//摊位最大数
    /*
     * 根据玩家id获取所有上架物品
     */
    public List<StreetMarket> getGoodsByUserId(ResultInfo resultInfo, Long userid) {
        PlayerInfo playerInfo = PlayerManager.getPlayer(userid);
        List<StreetMarket> goodsList = playerInfo.getStreetMarketInfoByUserId(userid);
        if (goodsList == null || goodsList.size() == 0) {
            resultInfo.setResp_code("600001");
        }
        HashMap<String, Object> data = resultInfo.getData();
        data.put("capacity", playerInfo.getUser().getMarketCapacity());
        data.put("goods", goodsList);
        data.put("userid", userid);
        data.put("username", playerInfo.getUser().getUsername());
        return goodsList;
    }


    /*
     * 物品上架
     * */
    @Transactional
    public boolean addGoods(ResultInfo resultInfo, Long userid, Integer baseid, Integer number, Integer price, Integer stallnumber, Integer flag) {
        PlayerInfo playerInfo = PlayerManager.getPlayer(userid);
        boolean result = false;

        //判断街边摊容量
        if(this.getCurrentMarketCapacity(userid)>=playerInfo.getUser().getMarketCapacity()){
            resultInfo.setResp_code("600002");
            return result;
        }
        //判断请求的摊位编号是否已有物品存在
        if(playerInfo.isEqualsStallNumber(userid,stallnumber)!=null){
            resultInfo.setResp_code("600003");
            return result;
        }


        //上架物品在crops表或grops表中更新数据（count的加减）
        Props props = playerInfo.getPropByBaseId(baseid);
        if(props==null){
            resultInfo.setResp_code("600023");
            return result;
        }
        if (props.getCount() < number) {//请求上架物品数超过拥有的物品总数
            resultInfo.setResp_code("600004");
            return result;
        }

        int count = props.getCount() - number;
        if(count==0){
            //如果上架后count值为0，则删除对应表的数据
            result = playerInfo.deleteGoods(props);
        }else{
            props.setCount(count);
            result = playerInfo.updateGoodsCountNumber(props);
        }

        if (!result) {
            resultInfo.setResp_code("600005");
            return result;
        }
        //上架物品在streetmarket表中插入一条数据
        StreetMarket streetMarket = new StreetMarket();
        streetMarket.setUserid(userid);
        streetMarket.setBaseid(baseid);
        streetMarket.setOnshelfnum(number);
        streetMarket.setPrice(price);
        streetMarket.setIsselloff(NOSELLOFF);
        streetMarket.setStallnumber(stallnumber);
        streetMarket.setFlag(flag);
        result = playerInfo.addStreetMarketGoods(streetMarket);
        if (!result) {//上架失败，添加上架信息失败
            resultInfo.setResp_code("600006");
        }
        //上架后获取街边摊数据，返回给前端
        if(result){
            this.getGoodsByUserId(resultInfo,userid);
        }
        return result;
    }

    /*
     * 物品下架
     * */
    @Transactional
    public boolean removeGoods(ResultInfo resultInfo, Long userid, Long id) {
        PlayerInfo playerInfo = PlayerManager.getPlayer(userid);
        boolean result = false;
        StreetMarket streetMarket = playerInfo.getOneStreetMarketInfo(id);
        if (streetMarket == null) {//下架失败，找不到下架物品
            resultInfo.setResp_code("600007");
            return result;
        }
        //判断仓库容量是否达上限




        //下架在crops表或grops表中更新数据（count的加减）
        Props props = playerInfo.getPropByBaseId(streetMarket.getBaseid());
        Integer flag = streetMarket.getFlag();
   /*       if (flag == 0) {
            props = playerInfo.getPropByBaseId(streetMarket.getBaseid());
        } else {
            props = playerInfo.getPropByBaseId(streetMarket.getBaseid());
        }*/

        //分两种情况：玩家已有该物品和玩家还没有该物品
        if (props == null) {
            //如果玩家还没有该物品，则下架后在仓库新增数据
            props = new Props();
            props.setUserid(userid);
            props.setBaseid(streetMarket.getBaseid());
            props.setCount(streetMarket.getOnshelfnum());
            props.setType(flag);
            result = playerInfo.addBuyGoods(props);
        }else{
            //如果玩家有该物品
            props.setCount(props.getCount() + streetMarket.getOnshelfnum());
            result = playerInfo.updateGoodsCountNumber(props);
        }

        if (!result) {//下架失败，更新仓库信息失败
            resultInfo.setResp_code("600008");
            return result;
        }
        //下架后删除街边摊单行数据
        result = playerInfo.deleteStreetMarketGoods(id);
        if (!result) {//下架失败，删除街边摊信息失败
            resultInfo.setResp_code("600009");
        }
        //下架后获取街边摊数据，返回给前端
        if(result){
            this.getGoodsByUserId(resultInfo,userid);
        }
        return result;
    }

   /*
    购买地摊物品，购买后玩家物品增加，钱数较少，
    被购买的物品状态改为已售
    */
    @Transactional
    public boolean streetMarketBuy(ResultInfo resultInfo, Long userid, Long id) {
        PlayerInfo playerInfo = PlayerManager.getPlayer(userid);
        boolean result = false;

        StreetMarket streetMarket = playerInfo.getOneStreetMarketInfo(id);
        if (streetMarket == null) {//购买失败，购买的物品不存在
            resultInfo.setResp_code("600010");
            return result;
        }
        int money = playerInfo.getUser().getMoney() - streetMarket.getPrice();
        if (money < 0) {//金钱不足无法购买
            resultInfo.setResp_code("600011");
            return result;
        }

        if(streetMarket.getIsselloff()==0){//判断物品状态为已售
            resultInfo.setResp_code("600012");
            return result;
        }
        //被购买的物品状态改为已售
        streetMarket.setIsselloff(SELLOFF);
        result= playerInfo.updateStreetMarketGoods(streetMarket);
        if (!result) {
            resultInfo.setResp_code("600013");
            return result;
        }

        //购买的玩家物品数量增加，分两种情况：玩家有该物品，更新数据；玩家没有该物品，新增数据。
        Props props =  playerInfo.getPropByBaseId(streetMarket.getBaseid());
        Integer flag = streetMarket.getFlag();

        if (props == null) {
            //如果没有该物品，则新增数据
            resultInfo.setResp_code("600000");
            props = new Props();
            props.setUserid(userid);
            props.setBaseid(streetMarket.getBaseid());
            props.setCount(streetMarket.getOnshelfnum());
            props.setType(flag);
            result=playerInfo.addBuyGoods(props);
        }else{
            //如果有该物品，则数量增加，更新物品数量
            props.setCount(props.getCount()+streetMarket.getOnshelfnum());
            result=playerInfo.updateGoodsCountNumber(props);
        }
        if (!result){//购买失败，更新仓库信息失败
            resultInfo.setResp_code("600014");
            return result;
        }

        // 金钱数减少
        User user=playerInfo.getUser();
        user.setMoney(money);
        result=playerInfo.updateUser(user);
        if (!result){
            resultInfo.setResp_code("600015");
        }
        if(result){
            this.getGoodsByUserId(resultInfo,streetMarket.getUserid());
        }
        return result;
    }

    /*
    *出售地摊物品：物品的拥有者点击已售商品后获得金钱数，从而删除街边摊数据
     */
    @Transactional
    public boolean streetMarketSell(ResultInfo resultInfo, Long userid, Long id) {
        PlayerInfo playerInfo = PlayerManager.getPlayer(userid);
        boolean result = false;
        StreetMarket streetMarket = playerInfo.getOneStreetMarketInfo(id);
        if (streetMarket == null) {
            resultInfo.setResp_code("600016");
            return result;
        }
        if(streetMarket.getIsselloff()!=0){//物品未处于已售状态
            resultInfo.setResp_code("600017");
            return result;
        }

        //玩家获得金钱
        int money = playerInfo.getUser().getMoney() + streetMarket.getPrice();
        User user=playerInfo.getUser();
        user.setMoney(money);
        result=playerInfo.updateUser(user);
        if (!result){
            resultInfo.setResp_code("600018");
        }
        //删除街边摊物品
        result = playerInfo.deleteStreetMarketGoods(id);
        if (!result){
            resultInfo.setResp_code("600019");
        }
        if(result){
            this.getGoodsByUserId(resultInfo,userid);
        }
        return result;
    }

    /*
    * 扩充摊位
    * */
    public boolean increaseMarketCapacity(ResultInfo resultInfo, Long userid, Integer ingot) {
        PlayerInfo playerInfo = PlayerManager.getPlayer(userid);
        User user = playerInfo.getUser();
        boolean result = false;
        int capacity = user.getMarketCapacity() + 1;
        //摊位初始容量为10，最大为20
        if (capacity > MAXCAPACITY) {
            resultInfo.setResp_code("600020");
            return result;
        }
        if(user.getIngot()<ingot){//拥有的钻石数不够
            resultInfo.setResp_code("600021");
            return result;
        }

        user.setMarketCapacity(capacity);
        user.setIngot(user.getIngot()-ingot);
        result=playerInfo.updateUser(user);
        if(!result){
            resultInfo.setResp_code("600022");
        }
        if(result){
            this.getGoodsByUserId(resultInfo,userid);
        }
        return result;
    }

    /*
    * 获取街边摊上架物品的数量
    * */

    public  Integer getCurrentMarketCapacity(Long userid) {
        PlayerInfo playerInfo = PlayerManager.getPlayer(userid);
        List<StreetMarket> goodsList = playerInfo.getStreetMarketInfoByUserId(userid);
        return goodsList.size();
    }
}