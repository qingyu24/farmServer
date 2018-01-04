package com.fngame.farm.controller;

import com.fngame.farm.controller.base.BaseContorllerInterface;
import com.fngame.farm.manager.BaseAutowired;
import com.fngame.farm.model.UserOrder;
import com.fngame.farm.service.OrderService;
import com.fngame.farm.userdate.RequserOrder;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("order")
public class OrderController implements BaseContorllerInterface<UserOrder> {
    @Autowired
    BaseAutowired baseAutowired;

    @Autowired
    ResultInfo resultInfo;

    @Autowired
    OrderService orderService;

    @RequestMapping("getorder")
    public ResultInfo getOrder(RequserOrder requsetOrder, UserOrder order2) {

        resultInfo.setOrder(requsetOrder);

        orderService.getOrders(resultInfo, order2);

        return resultInfo;
    }

    @Override
    public ResultInfo add(RequserOrder order, UserOrder userOrder) {

        resultInfo.setOrder(order);
        orderService.addOrder(resultInfo, userOrder);
        return resultInfo;
    }

    @Override
    public ResultInfo modify(RequserOrder order, UserOrder userOrder) {


        return null;
    }

    @Override
    public ResultInfo remove(RequserOrder order, UserOrder userOrder) {
        resultInfo.setOrder(order);
        orderService.remove(resultInfo, userOrder);

        return resultInfo;
    }

    @Override
    public ResultInfo get(RequserOrder order, UserOrder userOrder) {
        return null;
    }

    @RequestMapping("delete")
    public ResultInfo remove(RequserOrder order, UserOrder userOrder, Integer achieve) {

        resultInfo.setOrder(order);

        if (achieve == 1) {//完成订单给予奖励
            orderService.adhieve(resultInfo, userOrder);
        } else {//删除订单
            orderService.remove(resultInfo, userOrder);

        }
        return resultInfo;
    }

}
