package com.fngame.farm.controller;

import com.fngame.farm.model.Goods;
import com.fngame.farm.model.StreetMarket;
import com.fngame.farm.service.StreetMarketService;
import com.fngame.farm.userdate.RequserOrder;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/streetmarket")
public class StreetMarketController {
    @Autowired
    private ResultInfo resultInfo;

    @Autowired
    private StreetMarketService streetMarketService;
    /*
     * 根据用户id获取上架物品
     * */


    @GetMapping(value="/getgoods")
    public ResultInfo getGoodsByUserId(RequserOrder requsetOrder, @RequestParam("userid") Long userid){
        resultInfo.setOrder(requsetOrder);
        List<StreetMarket> list= streetMarketService.getGoodsByUserId(resultInfo,userid);
        if(list!=null&&list.size()!=0){
            resultInfo.setSucess(true);
        }
        return resultInfo;
    }

    /*
     *物品上架
     */

    @GetMapping(value="/goodsupshelf")
    public ResultInfo goodsUpShelf(RequserOrder requsetOrder,
                                   @RequestParam("userid") Long userid,//用户id
                                   @RequestParam("baseid") Integer baseid,//物品baseid
                                   @RequestParam("number") Integer number,//物品数量
                                   @RequestParam("price") Integer price,//物品价格
                                   @RequestParam("stallnumber") Integer stallnumber,//物品摊位编号
                                   @RequestParam("flag") Integer flag){//是crops还是grops，0是crops，1是grops
        resultInfo.setOrder(requsetOrder);
        Boolean agree=streetMarketService.addGoods(resultInfo,userid,baseid,number,price,stallnumber,flag);
        if(agree){
            resultInfo.setSucess(true);
        }
        return resultInfo;
    }


    /*
    * 物品下架
    * */
    @GetMapping(value = "/goodsdownshelf")
    public ResultInfo goodsDownShelf(RequserOrder requsetOrder,
                                     @RequestParam("id") Long id,//下架的goods id
                                     @RequestParam("userid") Long userid//用户id
    ) {
        resultInfo.setOrder(requsetOrder);
        Boolean agree = streetMarketService.removeGoods(resultInfo,userid,id);
        if (agree) {
            resultInfo.setSucess(true);
        }
        return resultInfo;
    }

    /*
    * 购买地摊物品
    * */

    @GetMapping(value = "/streetMarketBuy")
    public ResultInfo streetMarketBuy(RequserOrder requsetOrder,
                                      @RequestParam("id") Long id,//购买的goods id
                                      @RequestParam("userid") Long userid//（购买者）玩家id
    ) {
        resultInfo.setOrder(requsetOrder);
        Boolean agree = streetMarketService.streetMarketBuy(resultInfo,userid,id);
        if(agree){
            resultInfo.setSucess(true);
        }
        return resultInfo;
    }
    /*
    * 售出物品，获得金钱
    * */
    @GetMapping(value = "/streetMarketSell")
    public ResultInfo streetMarketSell(RequserOrder requsetOrder,
                                       @RequestParam("id") Long id,//购买的goods id
                                       @RequestParam("userid") Long userid//（购买者）玩家id
    ){
        resultInfo.setOrder(requsetOrder);
        Boolean agree = streetMarketService.streetMarketSell(resultInfo, userid, id);
        if(agree){
            resultInfo.setSucess(true);
        }
        return resultInfo;
    }

    /*
    * 扩充摊位数
    * */
    @GetMapping(value = "/increaseMarketCapacity")
    public ResultInfo increaseMarketCapacity(RequserOrder requsetOrder,
                                             @RequestParam("userid") Long userid,//玩家id
                                             @RequestParam("ingot") Integer ingot//扩充消耗的钻石
    ){
        resultInfo.setOrder(requsetOrder);
        Boolean agree =streetMarketService.increaseMarketCapacity(resultInfo, userid,ingot);
        if(agree){
            resultInfo.setSucess(true);
        }
        return resultInfo;
    }



}
