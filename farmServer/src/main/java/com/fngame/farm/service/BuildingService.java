package com.fngame.farm.service;

import com.fngame.farm.configer.Structure;
import com.fngame.farm.manager.ConfigManager;
import com.fngame.farm.mapper.BuildingMapper;
import com.fngame.farm.mapper.UserMapper;
import com.fngame.farm.model.Building;
import com.fngame.farm.model.User;
import com.fngame.farm.userdate.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class BuildingService {
    @Autowired
    ConfigManager configManager;

    @Autowired
    BuildingMapper BuildingMapper;
    @Autowired
    UserMapper userMapper;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean addBuilding(Building building) {
        int i = BuildingMapper.insertSelective(building);

        return i > 0;
    }

    public boolean addBuild(Building building, ResultInfo resultInfo) {

        Structure bco = configManager.getBuildingConfig(building);
        User user = userMapper.selectByPrimaryKey(building.getUserid());
        if(bco==null){
            resultInfo.setResult("001", "该类型建筑不存在");
        return false;
        }
        if (bco.BuildPrice < user.getMoney()) {
            resultInfo.setResult("001", "金币不足");
            return false;
        }
        if (bco.BuildLevel < user.getLevel()) {
            resultInfo.setResult("002", "玩家等级不足");
            return  false;
        }
//加上其他判断条件
        building.setBeginTime(new Date());
        int i = BuildingMapper.insertSelective(building);

        return i > 0;
    }

}
