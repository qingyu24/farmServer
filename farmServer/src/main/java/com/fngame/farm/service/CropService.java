package com.fngame.farm.service;

import com.fngame.farm.configer.Crop;
import com.fngame.farm.manager.ConfigManager;
import com.fngame.farm.manager.PlayerManager;
import com.fngame.farm.mapper.CropsMapper;
import com.fngame.farm.mapper.UserMapper;
import com.fngame.farm.model.Crops;
import com.fngame.farm.userdate.PlayerInfo;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by qingyu on 2017/12/22.
 */
public class CropService {
    @Autowired
    PlayerManager playerManager;
    @Autowired
    ConfigManager configManager;


    @Autowired
    UserMapper userMapper;

    @Autowired
    CropsMapper cropsMapper;

    public Boolean add(ResultInfo resultInfo, Crops crops) {
        return null;
    }


    public Boolean modify(ResultInfo resultInfo, Crops crops) {
        return null;
    }


    public Boolean remove(ResultInfo resultInfo, Crops crops) {
        return null;
    }

    public Boolean gain(ResultInfo resultInfo, Crops crops) {
        PlayerInfo player = playerManager.getPlayer(crops.getUserid());
        Crop cof_crop = configManager.getCrops(crops);
        if(cof_crop==null){resultInfo.setResult("1","该类型不存在"); return false;}
        if(player==null){
            resultInfo.setResp_code("100001");
        }
        if(cof_crop.PlantLevel>player.getUser().getLevel()){}

        return null;
    }
    public Boolean plant(ResultInfo resultInfo, Crops crops) {
        return null;
    }
}
