package com.fngame.farm.controller;

import com.fngame.farm.controller.base.BaseContorllerInterface;
import com.fngame.farm.model.TeleBooth;
import com.fngame.farm.service.TeleBoothService;
import com.fngame.farm.userdate.RequserOrder;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * The type Tele booth controller.
 */
@RestController
@RequestMapping("telebooth")
public class TeleBoothController implements BaseContorllerInterface<TeleBooth> {

    /**
     * The Tele booth service.
     */
    @Autowired
    TeleBoothService teleBoothService;

    /**
     * The Result info.
     */
    @Autowired
    ResultInfo resultInfo;

    //添加订单
    @Override
    public ResultInfo add(RequserOrder order, TeleBooth teleBooth) {
        resultInfo.setOrder(order);
        Boolean add = teleBoothService.add(resultInfo, teleBooth);
        if (add) {
            resultInfo.setSucess(true);
        }
        return resultInfo;
    }


    @Override
    public ResultInfo modify(RequserOrder order, TeleBooth teleBooth) {
        return null;
    }

    @Override
    public ResultInfo remove(RequserOrder order, TeleBooth teleBooth) {
        resultInfo.setOrder(order);
        Boolean remove = teleBoothService.remove(resultInfo, teleBooth);
        resultInfo.setSucess(remove);
        return resultInfo;
    }

    @Override
    public ResultInfo get(RequserOrder order, TeleBooth teleBooth) {
        resultInfo.setOrder(order);
        Boolean aBoolean = teleBoothService.get(resultInfo, teleBooth);
        if (aBoolean) {
            resultInfo.setSucess(true);
        }
        return resultInfo;
    }

    @RequestMapping("friendOrder")
    public ResultInfo getFriend(RequserOrder order, TeleBooth teleBooth) {
        resultInfo.setOrder(order);
        Boolean aBoolean = teleBoothService.getFriendOrder(resultInfo, teleBooth);
        if (aBoolean) {
            resultInfo.setSucess(true);
        }
        return resultInfo;
    }
    /**
     * Achieve result info.
     * 玩家点击确认收订单货物
     *
     * @param order     the order
     * @param teleBooth the tele booth
     * @return the result info
     */
    @RequestMapping("achieve")
    public ResultInfo achieve(RequserOrder order, TeleBooth teleBooth) {
        resultInfo.setOrder(order);
        Boolean add = teleBoothService.achieve(resultInfo, teleBooth);
        if (add) resultInfo.setSucess(true);

        return resultInfo;
    }

    /**
     * Sell result info.
     * 好友售卖货物
     *
     * @param order     the order
     * @param teleBooth the tele booth
     * @return the result info
     */
    @RequestMapping("sell")
    public ResultInfo sell(RequserOrder order, TeleBooth teleBooth) {
        resultInfo.setOrder(order);
        Boolean add = teleBoothService.sell(resultInfo, teleBooth);
        resultInfo.setSucess(add);
        return resultInfo;
    }
}
