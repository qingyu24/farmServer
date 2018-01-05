
package com.fngame.farm.controller;

import com.fngame.farm.configer.Craft;
import com.fngame.farm.controller.base.BaseContorllerInterface;
import com.fngame.farm.controller.base.BaseController;
import com.fngame.farm.etypes.EItemType;
import com.fngame.farm.manager.ConfigManager;
import com.fngame.farm.manager.PlayerManager;
import com.fngame.farm.model.Building;
import com.fngame.farm.model.CraftProduce;
import com.fngame.farm.model.Crops;
import com.fngame.farm.model.Props;
import com.fngame.farm.userdate.PlayerInfo;
import com.fngame.farm.userdate.RequserOrder;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("crops")
public class CropsController extends BaseController implements BaseContorllerInterface<Crops> {

    @Autowired
    PlayerManager PlayerManager;


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
            resultInfo.setResp_code("300001");
            return resultInfo;
        }
        Props crop = playerInfo.getPropById(crops.getId());
        if(null == crop){
            //农作物种子不存在的错误;
            resultInfo.setResp_code("300002");
            return resultInfo;
        }
        Building build = playerInfo.getBuildingByID(crop.getTargetId().longValue());
        if (null == build) {
            //没有对应的目标农田;
            resultInfo.setResp_code("300003");
            return resultInfo;
        }
        CraftProduce craft = playerInfo.getCraftByBuildingId(crop.getTargetId().longValue());
        if(null != craft){
            //这块农田已经处于被种植状态;
            resultInfo.setResp_code("300004");
            return resultInfo;
        }

        /*
        String[] str = baseCraft.Staff.split("|");
        for (int i = 0 ; i < str.length; ++ i){
            String[] obj = str[i].split("_");
            int id = Integer.parseInt(obj[0]);
            int count = Integer.parseInt(obj[1]);
            Crops myCrop = playerInfo.getCropsByBaseId(id);
            if(null == myCrop || myCrop.getCount() < count){
                resultInfo.setResp_code("300008");
                return resultInfo;
            }
        }
        */

        CraftProduce cp = playerInfo.insertCraft(EItemType.CROP.ID(), crops.getTargetId().longValue(), crop.getBaseid());
        if (null == cp){
            //没有找到基础表里面的数据;
            resultInfo.setResp_code("300005");
            return resultInfo;
        }
        //删除仓库中的种子;

        resultInfo.getData().put("craftinfo", cp);
        resultInfo.setResp_code("000000");
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
    //收获农作物;
    @Override
    public ResultInfo get(RequserOrder order, Crops crops) {
        resultInfo.setOrder(order);
        Long userId = crops.getUserid();//所属用户的id;
        PlayerInfo playerInfo = PlayerManager.getPlayer(userId);
        if (null == playerInfo){
            //返回玩家不存在的错误;
            resultInfo.setResp_code("300001");
            return resultInfo;
        }
        CraftProduce craft = playerInfo.getCraftListById(crops.getId().longValue());
        if(null == craft){
            //这块农田已经处于被种植状态;
            resultInfo.setResp_code("300006");
            return resultInfo;
        }
        Craft baseCraft = ConfigManager.getInstance().getCraftById(craft.getProductbaseid());
        if (null == baseCraft){
            //没有找到基础表里面的数据;
            resultInfo.setResp_code("300005");
            return resultInfo;
        }
        int needTime = baseCraft.CraftTime.intValue();
        if(new Date().getTime() - craft.getBegintime().getTime() < needTime){
            //农作物还没有成熟;
            resultInfo.setResp_code("300007");
            return resultInfo;
        }
        boolean ret = playerInfo.removeCraftById(craft.getId());
        if (ret){
            //添加到农作物列表里面;
            Props newCrop = playerInfo.addProp(craft.getProductbaseid(), craft.getSize());
            resultInfo.getData().put("iteminfo", newCrop);
        }
        resultInfo.setResp_code("000000");
        return resultInfo;
    }
}

