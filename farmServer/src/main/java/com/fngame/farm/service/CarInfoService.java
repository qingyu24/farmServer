package com.fngame.farm.service;

import com.fngame.farm.manager.PlayerManager;
import com.fngame.farm.model.CarInfo;
import com.fngame.farm.userdate.PlayerInfo;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Author:Tian
 * @Description：
 * @Date:Created in 16:47 2018/1/3
 * @Modified By:
 */
public class CarInfoService {

    @Autowired
    PlayerManager PlayerManager;

    public List<CarInfo> getCarInfoByUserId(ResultInfo resultInfo,Long userid){
        PlayerInfo playerInfo = PlayerManager.getPlayer(userid);
//        List<CarInfo> carInfoList = playerInfo.
        return null;
    }
}
