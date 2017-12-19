package com.fngame.farm.controller;

import com.fngame.farm.controller.base.BaseContorllerInterface;
import com.fngame.farm.controller.base.BaseController;
import com.fngame.farm.model.Crops;
import com.fngame.farm.userdate.RequserOrder;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("crops")
public class CropsController extends BaseController implements BaseContorllerInterface<Crops> {
    @Override
    public ResultInfo add(RequserOrder order, Crops crops) {
        resultInfo.setOrder(order);
        System.out.println("ddd");
        return resultInfo;
    }

    @Override
    public ResultInfo modify(RequserOrder order, Crops crops) {
        return null;
    }

    @Override
    public ResultInfo remove(RequserOrder order, Crops crops) {
        return null;
    }
}
