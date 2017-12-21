package com.fngame.farm.controller;

import com.fngame.farm.configer.Craft;
import com.fngame.farm.controller.base.BaseContorllerInterface;
import com.fngame.farm.controller.base.BaseController;
import com.fngame.farm.manager.ConfigLoaderManager;
import com.fngame.farm.manager.ConfigManager;
import com.fngame.farm.model.Crops;
import com.fngame.farm.userdate.RequserOrder;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("crops")
public class CropsController extends BaseController implements BaseContorllerInterface<Crops> {
    @Override
    public ResultInfo add(RequserOrder order, Crops crops) {
        resultInfo.setOrder(order);

        return resultInfo;
    }

    @Override
    public ResultInfo modify(RequserOrder order, Crops crops) {
        List getloader = ConfigManager.getInstance().getloader(new Craft());
        resultInfo.setOrder(order);

        HashMap<String, Object> data = resultInfo.getData();
        data.put("d",getloader);
        return resultInfo;
    }

    @Override
    public ResultInfo remove(RequserOrder order, Crops crops) {

        return null;
    }
}
