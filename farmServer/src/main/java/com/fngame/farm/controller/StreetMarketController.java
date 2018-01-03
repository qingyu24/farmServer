/*
package com.fngame.farm.controller;

import com.fngame.farm.model.Goods;
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
    private StreetMarketService streetMarketService;

    @Autowired
    private ResultInfo resultInfo;

    */
/*
    * 根据用户id获取上架物品
    * *//*

    @GetMapping(value="/getgoods")
    public ResultInfo getGoodsByUserId(RequserOrder requsetOrder, @RequestParam("userid") Long userid){
        resultInfo.setOrder(requsetOrder);
        List<Goods> list= streetMarketService.getGoodsByUserId(resultInfo,userid);
        if(list!=null){
            resultInfo.setSucess(true);
        }
        return resultInfo;
    }

   */
/*
   *物品上架
    *//*

    @GetMapping(value="/goodsupshelf")
    public ResultInfo goodsUpShelf(RequserOrder requsetOrder,
                                   @RequestParam("userid") Long userid,//用户id
                                   @RequestParam("id") Long id,//物品id
                                   @RequestParam("number") Integer number,//物品数量
                                   @RequestParam("price") Integer price,//物品价格
                                   @RequestParam("stallnumber") Integer stallnumber,//物品摊位编号
                                   @RequestParam("flag") Integer flag){//是crops还是grops，0是crops，1是grops
        resultInfo.setOrder(requsetOrder);
        Boolean agree=streetMarketService.addGoods(resultInfo,userid,id,number,price,stallnumber,flag);
*/
/*        if(flag.intValue()==0){
            agree = streetMarketService.addCrops(resultInfo,userid,id,number,price);
        }else{
            agree = streetMarketService.addCrops(resultInfo,userid,id,number,price);
        }*//*

        if(agree){
            resultInfo.setSucess(true);
        }

        return resultInfo;
    }

    */
/*
     *物品下架
     *//*

    @GetMapping(value = "/goodsdownshelf")
    public ResultInfo goodsDownShelf(RequserOrder requsetOrder,
                                     @RequestParam("userid") Long userid,//用户id
                                     @RequestParam("id") Long id,//物品id
                                     @RequestParam("number") Integer number,//物品数量
                                     @RequestParam("price") Integer price,//物品价格
                                     @RequestParam("stallnumber") Integer stallnumber,//物品摊位编号
                                     @RequestParam("flag") Integer flag) {//是crops还是grops，0是crops，1是grops
        resultInfo.setOrder(requsetOrder);
        Boolean agree = streetMarketService.removeGoods(resultInfo, userid, id, number, price,stallnumber,flag);
        if (agree) {
            resultInfo.setSucess(true);
        }
        return resultInfo;
    }

    */
/*
    * 购买地摊物品
    * *//*


    @GetMapping(value = "/streetMarketBuy")
    public ResultInfo streetMarketBuy(RequserOrder requsetOrder,
                                      @RequestParam("userid") Long userid,//购买者的id
                                      @RequestParam("id") Long id,//购买物品的id
                                      @RequestParam("number") Integer number,//购买的数量
                                      @RequestParam("price") Integer price,//购买的价格
                                      @RequestParam("stallnumber") Integer stallnumber,//购买的摊位编号
                                      @RequestParam("flag") Integer flag//是crops还是grops，0是crops，1是grops
                                      ) {
//        购买后物品增加，钱数较少，被购买的玩家物品状态改为已售
        resultInfo.setOrder(requsetOrder);
        Boolean agree = streetMarketService.streetMarketBuy(resultInfo, userid, id, number, price,stallnumber,flag);
        if(agree){
            resultInfo.setSucess(true);
        }
        return resultInfo;
    }

    */
/*
    * 卖掉物品获得金钱
    * 物品的拥有者点击已售商品后获得金钱数，从而将物品数量减掉
    * *//*

    @GetMapping(value = "/streetMarketSell")
    public ResultInfo streetMarketSell(RequserOrder requsetOrder,
                                       @RequestParam("userid") Long userid,//物品拥有者id
                                       @RequestParam("id") Long id,//物品的id
                                       @RequestParam("number") Integer number,//购买的数量
                                       @RequestParam("price") Integer price,//出售的价格
                                       @RequestParam("stallnumber") Integer stallnumber,//购买的摊位编号
                                       @RequestParam("flag") Integer flag//是crops还是grops，0是crops，1是grops
                                       ){
        resultInfo.setOrder(requsetOrder);
        Boolean agree = streetMarketService.streetMarketSell(resultInfo, userid, id, number, price,stallnumber,flag);
        if(agree){
            resultInfo.setSucess(true);
        }
        return resultInfo;
    }

    */
/*
    * 扩充摊位数
    * *//*

    @GetMapping(value = "/increaseMarketCapacity")
    public ResultInfo increaseMarketCapacity(RequserOrder requsetOrder,
                                             @RequestParam("userid") Long userid,//玩家id
                                             @RequestParam("number") Integer number//扩充摊位数量
                                             ){
        resultInfo.setOrder(requsetOrder);
        Boolean agree =streetMarketService.increaseMarketCapacity(resultInfo, userid,number);
        if(agree){
            resultInfo.setSucess(true);
        }
        return resultInfo;
    }

}
*/
