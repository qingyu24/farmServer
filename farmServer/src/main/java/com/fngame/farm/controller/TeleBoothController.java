package com.fngame.farm.controller;

import com.fngame.farm.model.TeleBooth;
import com.fngame.farm.service.TeleBoothService;
import com.fngame.farm.service.baseService.BaseServiceImpl;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by qingyu on 2017/12/26 /17:02
 */
@Component
public class TeleBoothController implements BaseServiceImpl<TeleBooth> {

    @Autowired
    TeleBoothService teleBoothService;

    @Override
    public Boolean add(ResultInfo resultInfo, TeleBooth teleBooth) {
        teleBoothService.add(resultInfo,teleBooth);
        return null;
    }

    @Override
    public Boolean modify(ResultInfo resultInfo, TeleBooth teleBooth) {
        return null;
    }

    @Override
    public Boolean remove(ResultInfo resultInfo, TeleBooth teleBooth) {
        return null;
    }

    @Override
    public Boolean get(ResultInfo resultInfo, TeleBooth teleBooth) {
        return null;
    }
}
