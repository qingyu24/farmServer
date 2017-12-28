package com.fngame.farm.controller;

import com.fngame.farm.controller.base.BaseContorllerInterface;
import com.fngame.farm.model.TeleBooth;
import com.fngame.farm.service.TeleBoothService;
import com.fngame.farm.userdate.RequserOrder;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qingyu on 2017/12/26 /17:02
 */

@RestController
@RequestMapping("telebooth")
public class TeleBoothController implements BaseContorllerInterface<TeleBooth> {

    @Autowired
    TeleBoothService teleBoothService;

    @Autowired
    ResultInfo resultInfo;

    @Override
    public ResultInfo add(RequserOrder order, TeleBooth teleBooth) {

        Boolean add = teleBoothService.add(resultInfo, teleBooth);
        if (add) {
            resultInfo.setSucess();
        }
        return resultInfo;
    }


    @Override
    public ResultInfo modify(RequserOrder order, TeleBooth teleBooth) {
        return null;
    }

    @Override
    public ResultInfo remove(RequserOrder order, TeleBooth teleBooth) {
        return null;
    }

    @Override
    public ResultInfo get(RequserOrder order, TeleBooth teleBooth) {

        teleBoothService.get(resultInfo,teleBooth);
        return resultInfo;
    }
    @RequestMapping("achieve")
    public ResultInfo achieve(RequserOrder order, TeleBooth teleBooth) {

        Boolean add = teleBoothService.achieve(resultInfo, teleBooth);
        if(add)resultInfo.setSucess();

        return resultInfo;
    }
    @RequestMapping("sell")
    public ResultInfo sell(RequserOrder order, TeleBooth teleBooth) {

        Boolean add = teleBoothService.sell(resultInfo, teleBooth);

        return resultInfo;
    }
    }
