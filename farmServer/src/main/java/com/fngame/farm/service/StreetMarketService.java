package com.fngame.farm.service;

import com.fngame.farm.manager.PlayerManager;
import com.fngame.farm.mapper.CropsMapper;
import com.fngame.farm.mapper.PropsMapper;
import com.fngame.farm.model.*;
import com.fngame.farm.userdate.PlayerInfo;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class StreetMarketService {
    @Autowired
    PlayerManager PlayerManager;

    @Autowired
    CropsMapper cropsMapper;

    @Autowired
    PropsMapper propsMapper;
    /*
    * 根据玩家id获取所有上架物品
     */
    public List<Goods> getGoodsByUserId(ResultInfo resultInfo,Long userid){
        PlayerInfo playerInfo = PlayerManager.getPlayer(userid);
        List<Goods> goodsList = new ArrayList<Goods>();
        List<Crops> crops = playerInfo.insalCrops();
        List<Props> props = playerInfo.insalProps();
        HashMap<String, Object> data =resultInfo.getData();
        goodsList.addAll(crops);
        goodsList.addAll(props);
        data.put("goods",goodsList);
        return goodsList;
    }

    /*
    * 根据玩家id获得好友列表
    * */
    public List<FriendInfo> getFriendsByUserId(ResultInfo resultInfo,Long userid){
        PlayerInfo playerInfo = PlayerManager.getPlayer(userid);
        List<FriendInfo> friendInfoList=playerInfo.getFriendList();
        HashMap<String, Object> data =resultInfo.getData();
        data.put("friendInfoList",friendInfoList);
        return friendInfoList;
    }

    /*
    *根据玩家id获得粮仓
    * */
/*    public List<Crops> getCropsByUserId(ResultInfo resultInfo,Long userId){
        PlayerInfo playerInfo = PlayerManager.getPlayer(userId);
        List<Crops> cropslist=playerInfo.getCrops();
        HashMap<String, Object> data =resultInfo.getData();
        data.put("cropslist",cropslist);
        return cropslist;
    }*/

    /*
     *根据玩家id获得货场
     * */
/*    public List<Props> getPropsByUserId(ResultInfo resultInfo,Long userid){
        PlayerInfo playerInfo = PlayerManager.getPlayer(userid);
        List<Props> propslist=playerInfo.getPropss();
        HashMap<String, Object> data =resultInfo.getData();
        data.put("propslist",propslist);
        return propslist;
    }*/


    /*
    * 物品上架
    * */
    public boolean addGoods(ResultInfo resultInfo,Long userid,Long id,Integer number,Integer price,Integer flag){
        PlayerInfo playerInfo = PlayerManager.getPlayer(userid);
        List<Goods> goodslist= new ArrayList<Goods>();
        if(flag.intValue()==0){
            goodslist.addAll(playerInfo.getCrops());
        }else{
            goodslist.addAll(playerInfo.getPropss());
        }
        for(Goods goods:goodslist){
            if(goods.getId().equals(id)){
                int count = goods.getCount().intValue();
                int num = number.intValue();
                if(num!=0&&count>=num){
                    if(flag.intValue()==0){
                        Crops crops = (Crops)goods;
                        crops.setIsinsale(number);
                        crops.setPrice(price);
                        cropsMapper.updateByPrimaryKeySelective(crops);

                    }else{
                        Props props=(Props)goods;
                        props.setIsinsale(number);
                        props.setPrice(price);
                        propsMapper.updateByPrimaryKeySelective(props);
                    }
                    resultInfo.setSucess();
                }else{
                    resultInfo.setfalse();
                    return false;
                }
            }
        }
        return true;
    }

    /*
     * 货物上架
     * */
/*    public boolean addCrops(ResultInfo resultInfo,Long userid,Long cropsid,Integer number,Integer price){
        PlayerInfo playerInfo = PlayerManager.getPlayer(userid);
        List<Crops> cropsList=playerInfo.getCrops();
        for (Crops crops:cropsList){
            if(crops.getId().equals(cropsid)){
                int count = crops.getCount().intValue();
                int num = number.intValue();
                if(num!=0&&count>=num){
                    crops.setIsinsale(number);
                    crops.setPrice(price);
                    cropsMapper.updateByPrimaryKeySelective(crops);
                    resultInfo.setSucess();
                }else{
                    resultInfo.setfalse();
                    return false;
                }
            }
        }
        return true;
    }*/

    /*
    * 物品下架
    * */
    public boolean removeGoods(ResultInfo resultInfo,Long userid,Long id,Integer number,Integer price,Integer flag){
        PlayerInfo playerInfo = PlayerManager.getPlayer(userid);
        List<Goods> goodslist= new ArrayList<Goods>();
        if(flag.intValue()==0){
            goodslist.addAll(playerInfo.getCrops());
        }else{
            goodslist.addAll(playerInfo.getPropss());
        }
        for(Goods goods:goodslist){
            int isinsale =goods.getIsinsale().intValue();
            int num = number.intValue();
            if(num<=isinsale){
                if(flag.intValue()==0){
                    Crops crops = (Crops)goods;
                    crops.setIsinsale(isinsale-num);
                    crops.setPrice(price);
                    cropsMapper.updateByPrimaryKeySelective(crops);
                }else{
                    Props props = (Props)goods;
                    props.setIsinsale(isinsale-num);
                    if((isinsale-num)==0){
                        props.setPrice(0);
                    }else{
                        props.setPrice(price);
                    }
                    propsMapper.updateByPrimaryKeySelective(props);
                }
                resultInfo.setSucess();
            }else{
                resultInfo.setfalse();
                return false;
            }
        }
        return true;
    }




}
