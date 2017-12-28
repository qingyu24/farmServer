package com.fngame.farm.service;

import com.fngame.farm.etypes.EItemType;
import com.fngame.farm.manager.PlayerManager;
import com.fngame.farm.mapper.CropsMapper;
import com.fngame.farm.mapper.PropsMapper;
import com.fngame.farm.mapper.TeleBoothMapper;
import com.fngame.farm.mapper.UserMapper;
import com.fngame.farm.model.*;
import com.fngame.farm.userdate.PlayerInfo;
import com.fngame.farm.userdate.ResultInfo;
import com.fngame.farm.util.BeanTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by qingyu on 2017/12/26 /17:26
 */
@Service
public class TeleBoothService {
    @Autowired
    TeleBoothMapper teleBoothMapper;
    @Autowired
    TeleBoothExample teleBoothExample;
    @Autowired
    PlayerManager playerManager;


    public Boolean add(ResultInfo resultInfo, TeleBooth teleBooth) {
        PlayerInfo player = playerManager.getPlayer(teleBooth.getUserid());
        List<TeleBooth> teleBooths = player.getTeleBooths();
        if (teleBooths == null || teleBooths.size() == 0) {
            teleBooth.setBegintime(new Date());
            teleBoothMapper.insertSelective(teleBooth);

        } else if (teleBooths.size() == 1) {
            TeleBooth teleBooth1 = teleBooths.get(0);
            Integer achieve = teleBooth1.getAchieve();
            if (achieve == 1) {
                teleBooth.setBegintime(new Date());
                teleBooth.setId(teleBooth1.getId());
                int i = teleBoothMapper.updateByPrimaryKeySelective(teleBooth);
            } else if (achieve == 0) {
                resultInfo.setResp_code("00001");
                return false;
            }
        } else {

            return false;
        }
        Integer money = player.getUser().getMoney();
        if (money < teleBooth.getMoney()) {
            resultInfo.setResp_desc("111111");
            return false;
        }
        User user = player.getUser();
        user.setMoney(money - teleBooth.getMoney());
        UserMapper bean = (UserMapper) BeanTools.getBean(UserMapper.class);
        bean.updateByPrimaryKey(user);
        HashMap<String, Object> data = resultInfo.getData();
        data.put("teleBooth", teleBooth);
        return true;
    }


    public Boolean modify(ResultInfo resultInfo, TeleBooth teleBooth) {
        return null;
    }


    public Boolean remove(ResultInfo resultInfo, TeleBooth teleBooth) {


        return null;
    }

    @Transactional

    public Boolean get(ResultInfo resultInfo, TeleBooth teleBooth) {
        teleBooth = teleBoothMapper.selectByPrimaryKey(teleBooth.getId());
        HashMap<String, Object> data = resultInfo.getData();
        data.put("telebooth",teleBooth);
        return true;
    }

    public Boolean sell(ResultInfo resultInfo, TeleBooth teleBooth) {
        teleBooth = teleBoothMapper.selectByPrimaryKey(teleBooth.getId());
        if (teleBooth == null) {
            resultInfo.setResp_code("1111");
            return false;
        }
        if (teleBooth.getAchieve() == 1) {//订单已达成
            resultInfo.setResp_code("22222");
            return false;
        }
        PlayerInfo player = playerManager.getPlayer(teleBooth.getUserid());
        Integer type = teleBooth.getType();
        Integer baseid = teleBooth.getBaseid();

        Goods good = player.getOneGoods(teleBooth.getBaseid());

        if (good == null) {
            resultInfo.setfalse();
            return false;
        }
        Integer count = good.getCount();
        if (count < teleBooth.getCount()) {
            resultInfo.setResp_code("33333");
            return false;
        }
        good.setCount(count - teleBooth.getCount());
        this.updateGood(good,type);
        Integer money = player.getUser().getMoney();

        UserMapper bean = (UserMapper) BeanTools.getBean(UserMapper.class);
        player.getUser().setMoney(money + teleBooth.getMoney());
        bean.updateByPrimaryKeySelective(player.getUser());
        teleBooth.setAchieve(1);
        teleBoothMapper.updateByPrimaryKeySelective(teleBooth);
        return true;
    }

    public Boolean achieve(ResultInfo resultInfo, TeleBooth teleBooth) {
        PlayerInfo player = playerManager.getPlayer(teleBooth.getUserid());
        Integer type = teleBooth.getType();
        Integer baseid = teleBooth.getBaseid();

        Goods good = player.getOneGoods(teleBooth.getBaseid());

        if (good == null) {
            resultInfo.setfalse();
            return false;
        }

        good.setCount(teleBooth.getCount() + teleBooth.getCount());
        this.updateGood(good,type);

        return true;
    }



   private void updateGood(Goods good,Integer type){
       if (type == EItemType.CROP.ID()) {
           CropsMapper bean = (CropsMapper) BeanTools.getBean(CropsMapper.class);
           bean.updateByPrimaryKeySelective((Crops) good);
       } else if (type == EItemType.PROPS.ID()) {
           PropsMapper bean = (PropsMapper) BeanTools.getBean(Props.class);
           bean.updateByPrimaryKeySelective((Props) good);
       }
    }
}
