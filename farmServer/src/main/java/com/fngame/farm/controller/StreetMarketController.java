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

    /*
    * 根据id获取上架物品
    * */
    @GetMapping(value="/getgoods")
    public ResultInfo getGoodsByUserId(RequserOrder requsetOrder, @RequestParam("userid") Long userid){
        resultInfo.setOrder(requsetOrder);
        List<Goods> list= streetMarketService.getGoodsByUserId(resultInfo,userid);
        if(list!=null){
            resultInfo.setSucess();
        }
        return resultInfo;
    }

   /*
   *物品上架
    */
    @GetMapping(value="/goodsupshelf")
    public ResultInfo goodsUpShelf(RequserOrder requsetOrder,
                                   @RequestParam("userid") Long userid,
                                   @RequestParam("id") Long id,
                                   @RequestParam("number") Integer number,
                                   @RequestParam("price") Integer price,
                                   @RequestParam("flag") Integer flag){
        resultInfo.setOrder(requsetOrder);
        Boolean agree=streetMarketService.addGoods(resultInfo,userid,id,number,price,flag);
/*        if(flag.intValue()==0){
            agree = streetMarketService.addCrops(resultInfo,userid,id,number,price);
        }else{
            agree = streetMarketService.addCrops(resultInfo,userid,id,number,price);
        }*/
        if(agree){
            resultInfo.setSucess();
        }

        return resultInfo;
    }

    /*
     *物品下架
     */
    @GetMapping(value="/goodsdownshelf")
    public ResultInfo goodsDownShelf(RequserOrder requsetOrder,
                                   @RequestParam("userid") Long userid,
                                   @RequestParam("id") Long id,
                                   @RequestParam("number") Integer number,
                                   @RequestParam("price") Integer price,
                                     @RequestParam("flag") Integer flag){
        resultInfo.setOrder(requsetOrder);
        Boolean agree=streetMarketService.removeGoods(resultInfo,userid,id,number,price,flag);
        if(agree){
            resultInfo.setSucess();
        }
        return resultInfo;
    }
}
