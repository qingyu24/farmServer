/*
package com.fngame.farm.controller;

import com.fngame.farm.configer.Craft;
import com.fngame.farm.controller.base.BaseContorllerInterface;
import com.fngame.farm.controller.base.BaseController;
import com.fngame.farm.manager.ConfigManager;
import com.fngame.farm.manager.PlayerManager;
import com.fngame.farm.model.Crops;
import com.fngame.farm.service.CropService;
import com.fngame.farm.userdate.PlayerInfo;
import com.fngame.farm.userdate.RequserOrder;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("crops")
public class CropsController extends BaseController implements BaseContorllerInterface<Crops> {

    @Autowired
    PlayerManager PlayerManager;
    @Autowired
    CropService cropService;

    //种植农作物
    @Override
    public ResultInfo add(RequserOrder order, Crops crops) {
        resultInfo.setOrder(order);
        Long userId = crops.getUserid();//所属用户的id;
       // crops.getId();//存在于背包内的id；
       // crops.getOwnerid(); //目标农田的id
        PlayerInfo playerInfo = PlayerManager.getPlayer(userId);
        if (null == playerInfo){
            //返回玩家不存在的错误;
        }
        Crops crop = playerInfo.getCropByID(crops.getId());
        if(null == crop){
            //农作物种子不存在的错误;
        }

        return resultInfo;
    }

    @Override
    public ResultInfo modify(RequserOrder order, Crops crops) {
        List getloader = ConfigManager.getInstance().getloader(new Craft());
        resultInfo.setOrder(order);
        HashMap<String, Object> data = resultInfo.getData();
        data.put("d", getloader);
        return resultInfo;
    }

    @Override
    public ResultInfo remove(RequserOrder order, Crops crops) {

        return null;
    }

    @Override
    public ResultInfo get(RequserOrder order, Crops crops) {
        return null;
    }

    @RequestMapping("gain")
    public ResultInfo gain(RequserOrder order, Crops crops) {
        resultInfo.setOrder(order);
        cropService.gain(resultInfo, crops);
        return null;
    }

    @RequestMapping("plant")
    public ResultInfo plant(RequserOrder order, Crops crops) {
        resultInfo.setOrder(order);
        cropService.plant(resultInfo, crops);

        return null;
    }
}
*/
