package com.fngame.farm.service;

import com.fngame.farm.configer.Entity;
import com.fngame.farm.manager.ConfigManager;
import com.fngame.farm.mapper.BuildingMapper;
import com.fngame.farm.mapper.UserMapper;
import com.fngame.farm.model.Building;
import com.fngame.farm.model.BuildingExample;
import com.fngame.farm.model.User;
import com.fngame.farm.userdate.ResultInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class BuildingService {
    @Autowired
    ConfigManager configManager;

    @Autowired
    BuildingMapper BuildingMapper;
    @Autowired
    UserMapper userMapper;

    @Autowired
    BuildingExample buildingExample;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    public boolean addBuilding(Building building) {
        int i = BuildingMapper.insertSelective(building);

        return i > 0;
    }

    volatile String d;

    @Transactional
    public Boolean add(ResultInfo resultInfo, Building building) throws Exception {


        Entity bco = configManager.getBuildingConfig(building);
        if (bco == null) {
            resultInfo.setResult("001", "该类型建筑不存在");
            return false;
        }
        User user = userMapper.selectByPrimaryKey(building.getUserid());

    /*    if (bco.BuildPrice > user.getMoney()) {
            resultInfo.setResult("001", "金币不足");

            return false;
        }*/
        buildingExample.clear();
        BuildingExample.Criteria criteria = buildingExample.createCriteria();
        criteria.andUseridEqualTo(building.getUserid());
        criteria.andBaseidEqualTo(building.getBaseid());
        int size = BuildingMapper.selectByExample(buildingExample).size();

        if (bco.BuildLimited <= size) {
            resultInfo.setResult("003", "该类建筑数量已达上限");
            return false;
        }

        if (bco.UnlockLv > user.getLevel()) {
            resultInfo.setResult("002", "玩家等级不足");
            return false;
        }

        //前置建筑
//加上其他判断条件

        building.setBeginTime(new Date());
        int i = BuildingMapper.insertSelective(building);
        buildingExample.setDistinct(true);
        buildingExample.setOrderByClause("begin_time");
        List<Building> buildings = BuildingMapper.selectByExample(buildingExample);
        //获取新添加的ＩＤ
        building.setId(buildings.get(0).getId());
        return i > 0;

    }


    public Boolean modify(ResultInfo resultInfo, Building building) {
        Entity bco = configManager.getBuildingConfig(building);
        if (bco == null) {
            resultInfo.setResult("001", "该类型建筑不存在");
            return false;
        }
        if (!bco.Move && (building.getXpos() != null || building.getYpos() != null)) {
            resultInfo.setResult("00001", "该建筑不能移动");
            return false;
        }
        if (building.getDir() != null && !bco.Flip) {
            resultInfo.setResult("00001", "该建筑不能转动");
            return false;
        }
        int i = BuildingMapper.updateByPrimaryKeySelective(building);
        return i > 0;
    }


    public Boolean remove(ResultInfo resultInfo, Building building) {

        Entity bco = configManager.getBuildingConfig(building);
        if (bco == null) {
            resultInfo.setResult("001", "该类型建筑不存在");
            return false;
        }
        if (bco.Clear) {
            try {
                int i = BuildingMapper.deleteByPrimaryKey(building.getId());
                return true;
            } catch (Exception e) {
                return false;
            }


        }
        return false;
    }
}
