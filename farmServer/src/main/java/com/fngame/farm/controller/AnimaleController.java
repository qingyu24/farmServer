package com.fngame.farm.controller;

import com.fngame.farm.controller.base.BaseContorllerInterface;
import com.fngame.farm.controller.base.BaseController;
import com.fngame.farm.model.Animal;
import com.fngame.farm.model.Props;
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
        resultInfo.setOrder(order);
        boolean b = false;
        try {
            animaleService.add(resultInfo, animal);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(resultInfo.toString());
        if (b) {
            resultInfo.setSucess(true);
        }
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

    @Override
    public ResultInfo get(RequserOrder order, Animal animal) {
        return null;
    }
    // /

    @RequestMapping("feed")
    public ResultInfo feed(RequserOrder order, Animal animal, Props props) {
        resultInfo.setOrder(order);
        animaleService.feed(resultInfo,animal,props);

        return resultInfo;
    }


}
