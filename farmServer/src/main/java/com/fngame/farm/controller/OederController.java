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
public class OederController implements BaseContorllerInterface<UserOrder> {
    @Autowired
    BaseAutowired baseAutowired;

    @Autowired
    ResultInfo resultInfo;

    @Autowired
    OrderService orderService;

    @RequestMapping("getorder")
    public ResultInfo getOrder(RequserOrder requsetOrder, UserOrder order2) {

        resultInfo.setOrder(requsetOrder);

        orderService.getOrders(resultInfo,order2);

        return resultInfo;
    }

    @Override
    public ResultInfo add(RequserOrder order, UserOrder userOrder) {
        return null;
    }

    @Override
    public ResultInfo modify(RequserOrder order, UserOrder userOrder) {
        return null;
    }

    @Override
    public ResultInfo remove(RequserOrder order, UserOrder userOrder) {
        return null;
    }
}
