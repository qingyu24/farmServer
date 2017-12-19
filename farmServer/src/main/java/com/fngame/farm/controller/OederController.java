package com.fngame.farm.controller;

import com.fngame.farm.controller.base.BaseContorllerInterface;
import com.fngame.farm.model.Order;
import com.fngame.farm.userdate.RequserOrder;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("order")
public class OederController implements BaseContorllerInterface<Order> {
    @Override
    public ResultInfo add(RequserOrder requsetOrder, Order order2) {
        return null;
    }

    @Override
    public ResultInfo modify(RequserOrder requsetOrder, Order order2) {
        return null;
    }

    @Override
    public ResultInfo remove(RequserOrder requsetOrder, Order order2) {
        return null;
    }
}
