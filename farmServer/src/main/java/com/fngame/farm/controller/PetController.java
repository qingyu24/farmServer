package com.fngame.farm.controller;

import com.fngame.farm.controller.base.BaseContorllerInterface;
import com.fngame.farm.model.PetData;
import com.fngame.farm.service.PetService;
import com.fngame.farm.userdate.RequserOrder;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qingyu on 2017/12/28 /15:01
 */
@RestController
@RequestMapping("pet")
public class PetController implements BaseContorllerInterface<PetData> {

    /**
     * The Result info.
     */
    @Autowired
    ResultInfo resultInfo;

    /**
     * The Pet service.
     */
    @Autowired
    PetService petService;

    @Override
    public ResultInfo add(RequserOrder order, PetData petData) {
        return null;
    }

    /**
     * Gets .
     *
     * @param order   the order
     * @param petData the pet data
     * @return the
     */
    @RequestMapping("getnew")
    public ResultInfo getnew(RequserOrder order, PetData petData) {
        resultInfo.setOrder(order);

        boolean getnew = petService.add(resultInfo, petData);

        resultInfo.setSucess(getnew);

        return resultInfo;
    }

    @Override
    public ResultInfo modify(RequserOrder order, PetData petData) {
        return null;
    }

    @Override
    public ResultInfo remove(RequserOrder order, PetData petData) {
        return null;
    }

    @Override
    public ResultInfo get(RequserOrder order, PetData petData) {
        resultInfo.setOrder(order);
        Boolean aBoolean = petService.get(resultInfo, petData);
        resultInfo.setSucess(aBoolean);
        return resultInfo;
    }

    /**
     * Activity result info.
     *
     * @param order   the order
     * @param petData the pet data
     * @return the result info
     */
    @RequestMapping("activity")
    public ResultInfo activity(RequserOrder order, PetData petData) {
        resultInfo.setOrder(order);
        boolean activity = petService.activity(resultInfo, petData);
        resultInfo.setSucess(activity);
        return resultInfo;
    }

    /**
     * Pet harvest result info.
     *
     * @param order   the order
     * @param petData the pet data
     * @return the result info
     */
    @RequestMapping("petHarvest")
    public ResultInfo petHarvest(RequserOrder order, PetData petData) {
        resultInfo.setOrder(order);
        petService.petharvest(resultInfo, petData);
        return resultInfo;
    }

    /**
     * Clean result info.
     *
     * @param order     the order
     * @param userid    the userid 玩家本人id
     * @param rubbishid the rubbishid ；垃圾id
     * @param targetid  the targetid 家园主人id
     * @return the result info
     */
    @RequestMapping("clean")
    public ResultInfo clean(RequserOrder order, Long userid,Long rubbishid,Long targetid){
        resultInfo.setOrder(order);
        petService.clean(resultInfo,userid,rubbishid,targetid);
    return resultInfo;
    }
}
