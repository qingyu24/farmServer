package com.fngame.farm.controller;

import com.fngame.farm.controller.base.BaseContorllerInterface;
import com.fngame.farm.controller.base.BaseController;
import com.fngame.farm.model.Animal;
import com.fngame.farm.service.AnimaleService;
import com.fngame.farm.userdate.RequserOrder;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/animale")
public class AnimaleController extends BaseController implements BaseContorllerInterface<Animal> {

    @Autowired
    AnimaleService animaleService;

    @RequestMapping("add")
    public ResultInfo add(RequserOrder order, Animal animal) {

        return resultInfo;
    }

    @RequestMapping("modify")
    public ResultInfo modify(RequserOrder order, Animal animal) {
        resultInfo.setOrder(order);

        return resultInfo;
    }

    @RequestMapping("remove")
    public ResultInfo remove(RequserOrder order, Animal animal) {
        resultInfo.setOrder(order);

        return resultInfo;
    }

}
