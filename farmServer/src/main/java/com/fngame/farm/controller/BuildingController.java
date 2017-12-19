package com.fngame.farm.controller;

import com.fngame.farm.controller.base.BaseContorllerInterface;
import com.fngame.farm.etypes.EResultType;
import com.fngame.farm.model.Building;
import com.fngame.farm.service.BuildingService;
import com.fngame.farm.userdate.RequserOrder;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/buliding")
public class BuildingController implements BaseContorllerInterface<Building> {

    @Autowired
    BuildingService BuildingService;
    @Autowired
    ResultInfo resultInfo;

    @RequestMapping("add")
    public ResultInfo add(RequserOrder order, Building building) {
        resultInfo.setOrder(order);
        System.out.println(resultInfo.toString());
        boolean b = BuildingService.addBuild(building, resultInfo);
        System.out.println(resultInfo.toString());
        if (b) {
            resultInfo.getData().put(EResultType.buildinfo.toString(), building);
        }
        return resultInfo;
    }


    @RequestMapping("modify")
    public ResultInfo modify(RequserOrder order, Building building) {
        resultInfo.setOrder(order);

        return resultInfo;
    }

    @RequestMapping("remove")
    public ResultInfo remove(RequserOrder order, Building building) {
        resultInfo.setOrder(order);

        return resultInfo;
    }

}
