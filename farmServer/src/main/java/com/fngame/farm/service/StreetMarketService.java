package com.fngame.farm.service;

import com.fngame.farm.manager.PlayerManager;
import com.fngame.farm.model.Goods;
import com.fngame.farm.model.StreetMarket;
import com.fngame.farm.model.User;
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
            resultInfo.setResp_code("111001");
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

        //上架物品在crops表或grops表中更新数据（count的加减）
        Goods goods = new Goods();
        if (flag == 0) {
            goods = playerInfo.getCropByBaseId(baseid);
        } else {
            goods = playerInfo.getPropByBaseId(baseid);
        }
        if (goods == null || goods.getCount() < number) {
            resultInfo.setResp_code("111004");
            return result;
        }
        goods.setCount(goods.getCount() - number);
        result = playerInfo.updateGoodsCountNumber(goods, flag);
        if (!result) {
            resultInfo.setResp_code("111003");
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
        if (!result) {
            resultInfo.setResp_code("111002");
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
        if (streetMarket == null) {
            resultInfo.setResp_code("111005");
            return result;
        }
        //下架在crops表或grops表中更新数据（count的加减）
        Goods goods = new Goods();
        Integer flag = streetMarket.getFlag();
        if (flag == 0) {
            goods = playerInfo.getCropByBaseId(streetMarket.getBaseid());
        } else {
            goods = playerInfo.getPropByBaseId(streetMarket.getBaseid());
        }
        if (goods == null) {
            resultInfo.setResp_code("111006");
            return result;
        }
        goods.setCount(goods.getCount() + streetMarket.getOnshelfnum());
        result = playerInfo.updateGoodsCountNumber(goods, flag);
        if (!result) {
            resultInfo.setResp_code("111003");
        }
        //下架后删除街边摊单行数据
        result = playerInfo.deleteStreetMarketGoods(id);
        if (!result) {
            resultInfo.setResp_code("111007");
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
        //被购买的物品状态改为已售
        StreetMarket streetMarket = playerInfo.getOneStreetMarketInfo(id);
        if (streetMarket == null) {
            resultInfo.setResp_code("111008");
            return result;
        }
        int money = playerInfo.getUser().getMoney() - streetMarket.getPrice();
        if (money < 0) {//金钱不足无法购买
            resultInfo.setResp_code("111010");
            return result;
        }

        streetMarket.setIsselloff(SELLOFF);
        result= playerInfo.updateStreetMarketGoods(streetMarket);
        if (!result) {
            resultInfo.setResp_code("111009");
        }

        //购买的玩家物品数量增加，分两种情况：玩家有该物品，更新数据；玩家没有该物品，新增数据。
        Goods goods = new Goods();
        Integer flag = streetMarket.getFlag();
        if (flag == 0) {
            goods = playerInfo.getCropByBaseId(streetMarket.getBaseid());
        } else {
            goods = playerInfo.getPropByBaseId(streetMarket.getBaseid());
        }
        if (goods == null) {
            resultInfo.setResp_code("111006");
            return result;
        }

        if (goods == null) {
            //如果没有该物品，则新增数据
            resultInfo.setResp_code("111006");
            goods.setUserid(userid);
            goods.setBaseid(streetMarket.getBaseid());
            goods.setCount(streetMarket.getOnshelfnum());
            result=playerInfo.addBuyGoods(goods,flag);
        }else{
            //如果有该物品，则数量增加，更新物品数量
            goods.setCount(goods.getCount()+streetMarket.getOnshelfnum());
            result=playerInfo.updateGoodsCountNumber(goods,flag);
        }
        if (!result){
            resultInfo.setResp_code("111012");
        }

        // 金钱数减少
        User user=playerInfo.getUser();
        user.setMoney(money);
        result=playerInfo.updateUser(user);
        if (!result){
            resultInfo.setResp_code("111011");
        }
        return result;
    }

    /*
    *出售地摊物品：物品的拥有者点击已售商品后获得金钱数，从而下架物品
     */
    @Transactional
    public boolean streetMarketSell(ResultInfo resultInfo, Long userid, Long id) {
        PlayerInfo playerInfo = PlayerManager.getPlayer(userid);
        boolean result = false;
        StreetMarket streetMarket = playerInfo.getOneStreetMarketInfo(id);
        if (streetMarket == null) {
            resultInfo.setResp_code("111013");
            return result;
        }
        Goods goods = new Goods();
        Integer flag = streetMarket.getFlag();
        if (flag == 0) {
            goods = playerInfo.getCropByBaseId(streetMarket.getBaseid());
        } else {
            goods = playerInfo.getPropByBaseId(streetMarket.getBaseid());
        }
        if (goods == null) {
            resultInfo.setResp_code("111006");
            return result;
        }
        //玩家获得金钱
        int money = playerInfo.getUser().getMoney() + streetMarket.getPrice();
        User user=playerInfo.getUser();
        user.setMoney(money);
        result=playerInfo.updateUser(user);
        if (!result){
            resultInfo.setResp_code("111014");
        }
        //下架物品
        result=removeGoods(resultInfo,userid,id);
        return result;
    }

    /*
    * 扩充摊位
    * */
    public boolean increaseMarketCapacity(ResultInfo resultInfo, Long userid, Integer number) {
        PlayerInfo playerInfo = PlayerManager.getPlayer(userid);
        User user = playerInfo.getUser();
        boolean result = false;
        int capacity = user.getMarketCapacity() + number;
        //摊位初始容量为10，最大为20
        if (capacity > MAXCAPACITY) {
            resultInfo.setResp_code("110015");
            return result;
        }
        user.setMarketCapacity(capacity);
        result=playerInfo.updateUser(user);
        if(!result){
            resultInfo.setResp_code("111016");
        }
        return result;
    }


}