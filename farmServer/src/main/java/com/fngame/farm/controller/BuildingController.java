package com.fngame.farm.controller;

import com.fngame.farm.controller.base.BaseContorllerInterface;
import com.fngame.farm.controller.base.BaseController;
import com.fngame.farm.etypes.EResultType;
import com.fngame.farm.model.Building;
import com.fngame.farm.service.BuildingService;
import com.fngame.farm.userdate.RequserOrder;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/building")
public class BuildingController extends BaseController implements BaseContorllerInterface<Building> {
        

    @Autowired
    BuildingService BuildingService;
    @Autowired
    ResultInfo resultInfo;

    @RequestMapping("add")
    public ResultInfo add(RequserOrder order, Building building) {
        resultInfo.setOrder(order);

        boolean b = false;
        try {
            b = BuildingService.add(resultInfo, building);
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println(resultInfo.toString());
        if (b) {
            resultInfo.setSucess();
            resultInfo.getData().put(EResultType.buildinfo.toString(), building);
        }
        return resultInfo;
    }


    @RequestMapping("modify")
    public ResultInfo modify(RequserOrder order, Building building) {
        resultInfo.setOrder(order);
        Boolean modify = BuildingService.modify(resultInfo, building);
        if (modify) resultInfo.setSucess();
        else {
            resultInfo.setResult("111", "建筑物移动失败");
        }

        return resultInfo;
    }

    @RequestMapping("remove")
    public ResultInfo remove(RequserOrder order, Building building) {
        resultInfo.setOrder(order);
        Boolean remove = BuildingService.remove(resultInfo, building);
        if (remove) resultInfo.setSucess();
        else {
            resultInfo.setResult("111", "删除建筑物失败");
        }

        return resultInfo;
    }

}
