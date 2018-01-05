package com.fngame.farm.service;

import com.fngame.farm.manager.PlayerManager;
import com.fngame.farm.model.CarInfo;
import com.fngame.farm.model.LikeInfo;
import com.fngame.farm.model.Message;
import com.fngame.farm.userdate.PlayerInfo;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * @Author:Tian
 * @Description： 停车场的业务逻辑
 * @Date:Created in 16:47 2018/1/3
 * @Modified By:
 */
@Service
public class CarInfoService {

    @Autowired
    PlayerManager PlayerManager;

    /**
     *@Author:Tian
     *@Description:  获取车库信息列表
     *@Date: 10:12 2018/1/4
     */
    public List<CarInfo> getCarInfoByUserId(ResultInfo resultInfo,Long userid){
        PlayerInfo playerInfo = PlayerManager.getPlayer(userid);
        List<CarInfo> carInfoList = playerInfo.getCarInfoByUserId(userid);
        if(carInfoList==null||carInfoList.size()==0){
            resultInfo.setResp_code("111001");
        }
        HashMap<String, Object> data = resultInfo.getData();
        data.put("carInfoList",carInfoList);
        return carInfoList;
    }

    /**
     *@Author:Tian
     *@Description: 获取一个车辆的详细信息
     *@Date: 18:58 2018/1/4
     */
    @Transactional
    public Boolean getOneCarInfo(ResultInfo resultInfo,Long userid,Long carinfoid){
        PlayerInfo playerInfo = PlayerManager.getPlayer(userid);
        CarInfo carInfo = playerInfo.getOneCarInfo(carinfoid);
        Boolean result=false;
        if(carInfo==null){
            resultInfo.setResp_code("111002");
            return result;
        }
        List<Message> messageList = playerInfo.getMessage(carinfoid);
        if(messageList==null||messageList.size()==0){
            resultInfo.setResp_code("111003");
        }
        String islikeinfo="";
        if(playerInfo.userIsLikeInfo(carinfoid,userid)){
            islikeinfo="like";
        }else{
            islikeinfo="unlike";
        }
        Integer likecount = playerInfo.getLikeInfoCount(carinfoid);
        HashMap<String, Object> data = resultInfo.getData();
        data.put("carInfo",carInfo);
        data.put("messageList",messageList);
        data.put("islikeinfo",islikeinfo);
        data.put("likecount",likecount);
        return result;
    }

    /**
     *@Author:Tian
     *@Description: 点赞
     *@Date: 10:16 2018/1/5
     */
    public boolean addLikeInfo(ResultInfo resultInfo,Long carinfoid,Long userid){
        PlayerInfo playerInfo = PlayerManager.getPlayer(userid);
        boolean result = false;
        if(!playerInfo.userIsLikeInfo(carinfoid,userid)){
            resultInfo.setResp_code("111004");
            return result;
        }
        LikeInfo likeInfo = new LikeInfo();
        likeInfo.setCarinfoid(carinfoid);
        likeInfo.setUserid(userid);
        result=playerInfo.addLikeInfo(likeInfo);
        return result;
    }

}
