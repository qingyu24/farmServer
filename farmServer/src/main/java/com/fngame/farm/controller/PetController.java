package com.fngame.farm.controller;

import com.fngame.farm.controller.base.BaseContorllerInterface;
import com.fngame.farm.model.PetData;
import com.fngame.farm.service.PetService;
import com.fngame.farm.userdate.RequserOrder;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qingyu on 2017/12/28 /15:01
 */
@RestController
@RequestMapping("pet")
public class PetController implements BaseContorllerInterface<PetData> {

    @Autowired
    ResultInfo resultInfo;

    @Autowired
    PetService petService;

    @Override
    public ResultInfo add(RequserOrder order, PetData petData) { return null; }

    @RequestMapping("getnew")
    public ResultInfo getnew(RequserOrder order, PetData petData) {
        resultInfo.setOrder(order);

        boolean getnew = petService.add(resultInfo, petData);

        resultInfo.setSucess(getnew);

        return resultInfo;
    }

    @Override
    public ResultInfo modify(RequserOrder order, PetData petData) {
        return null;
    }

    @Override
    public ResultInfo remove(RequserOrder order, PetData petData) {
        return null;
    }

    @Override
    public ResultInfo get(RequserOrder order, PetData petData) {
        return null;
    }

    @RequestMapping("activity")
    public ResultInfo activity (RequserOrder order, PetData petData) {
        resultInfo.setOrder(order);
        petService.activity(resultInfo,petData);
        return resultInfo;
    }



}