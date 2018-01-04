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

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

/**
 * Created by qingyu on 2017/12/26 /17:26
 */
@Service
@Transactional
public class TeleBoothService {
    /**
     * The Tele booth mapper.
     */
    @Autowired
    TeleBoothMapper teleBoothMapper;
    /**
     * The Tele booth example.
     */
    @Autowired
    TeleBoothExample teleBoothExample;
    /**
     * The Player manager.
     */
    @Autowired
    PlayerManager playerManager;


    /**
     * 添加新的订单.
     *
     * @param resultInfo the result info
     * @param teleBooth  the tele booth
     * @return the boolean
     */

    public Boolean add(ResultInfo resultInfo, TeleBooth teleBooth) {
        PlayerInfo player = playerManager.getPlayer(teleBooth.getUserid());
        List<TeleBooth> teleBooths = player.getTeleBooths();

        Integer money = player.getUser().getMoney();
        if (money < teleBooth.getMoney()) {
            resultInfo.setResp_code("700003");
            return false;
        }
        if (teleBooths == null || teleBooths.size() < 5) {
            teleBooth.setBegintime(new Date());
            teleBooth.setAchieve(0);
            teleBoothMapper.insertSelective(teleBooth);

        }/* else if (teleBooths.size() == 1) {
            TeleBooth teleBooth1 = teleBooths.get(0);
            Integer achieve = teleBooth1.getAchieve();
            if (achieve == 1 || teleBooth1.getLefttime() == 0) {
                teleBooth.setBegintime(new Date());
                teleBooth.setId(teleBooth1.getId());
                teleBooth.setAchieve(0);
                teleBoothMapper.updateByPrimaryKeySelective(teleBooth);
            } else if (achieve == 0) {//
                resultInfo.setResp_code("700002");
                return false;
            }  } */ else {
            resultInfo.setResp_code("700007");
            return false;
        }

        teleBooth.setAchieve(0);
        User user = player.getUser();
        user.setMoney(money - teleBooth.getMoney());
        UserMapper bean = (UserMapper) BeanTools.getBean(UserMapper.class);
        bean.updateByPrimaryKey(user);
        HashMap<String, Object> data = resultInfo.getData();
        data.put("teleBooth", teleBooth);
        return true;
    }


    /**
     * Modify boolean.
     *
     * @param resultInfo the result info
     * @param teleBooth  the tele booth
     * @return the boolean
     */
    public Boolean modify(ResultInfo resultInfo, TeleBooth teleBooth) {
        return null;
    }


    /**
     * Remove boolean.删除订单
     *
     * @param resultInfo the result info
     * @param teleBooth  the tele booth
     * @return the boolean
     */
    public Boolean remove(ResultInfo resultInfo, TeleBooth teleBooth) {
        PlayerInfo player = playerManager.getPlayer(teleBooth.getUserid());
        List<TeleBooth> teleBooths = player.getTeleBooths();

        for (TeleBooth booth : teleBooths) {
            if (booth.getId().longValue() == teleBooth.getId().longValue()) {
                if (booth.getLefttime() != 0 && booth.getAchieve() != 1) {
                    Integer ingot = player.getUser().getIngot();
                    if (ingot.intValue() < 10) {
                        resultInfo.setResp_code("000006");
                        return false;
                    }
                    User user = player.getUser();
                    user.setIngot(ingot - 10);
                    player.updateUser(user);
                }

                player.removeTeleBOOth(booth);
                teleBooth = booth;
                Integer money = teleBooth.getMoney();
                User user = player.getUser();
                Integer money1 = user.getMoney();
                user.setMoney(money + money1);
                player.updateUser(user);
            }
        }

        HashMap<String, Object> data = resultInfo.getData();
        ArrayList<TeleBooth> objects = new ArrayList<>(1);
        objects.add(teleBooth);
        data.put("telebooth", objects);
        return true;


    }

    /**
     * Get boolean.
     *
     * @param resultInfo the result info
     * @param teleBooth  the tele booth
     * @return the boolean
     */
    @Transactional

    public Boolean get(ResultInfo resultInfo, TeleBooth teleBooth) {
        PlayerInfo player = playerManager.getPlayer(teleBooth.getUserid());
        List<TeleBooth> teleBooths = player.getTeleBooths();
        if (teleBooths == null) {
            teleBooths = new ArrayList<TeleBooth>();

        }
        HashMap<String, Object> data = resultInfo.getData();
        data.put("telebooth", teleBooths);
        return true;
    }

    /**
     * Sell boolean.
     *
     * @param resultInfo the result info
     * @param teleBooth  the tele booth
     * @return the boolean
     */
    public Boolean sell(ResultInfo resultInfo, TeleBooth teleBooth) {
        teleBooth = teleBoothMapper.selectByPrimaryKey(teleBooth.getId());
        if (teleBooth == null) {
            resultInfo.setResp_code("700001");
            return false;
        }
        if (teleBooth.getLefttime() == 0) {
            resultInfo.setResp_code("700008");
            return false;
        }
        if (teleBooth.getAchieve() == 1) {//订单已达成
            resultInfo.setResp_code("700004");
            return false;
        }
        PlayerInfo player = playerManager.getPlayer(teleBooth.getUserid());
        Integer type = teleBooth.getType();

        Goods good = player.getOneGoods(teleBooth.getBaseid());

        if (good == null) {
            resultInfo.setResp_code("700005");
            return false;
        }
        Integer count = good.getCount();
        if (count < teleBooth.getCount()) {
            resultInfo.setResp_code("700005");
            return false;
        }
        good.setCount(count - teleBooth.getCount());
        this.updateGood(good, type);
        Integer money = player.getUser().getMoney();

        UserMapper bean = (UserMapper) BeanTools.getBean(UserMapper.class);
        player.getUser().setMoney(money + teleBooth.getMoney());
        bean.updateByPrimaryKeySelective(player.getUser());
        teleBooth.setAchieve(1);
        teleBoothMapper.updateByPrimaryKeySelective(teleBooth);
        return true;
    }

    /**
     * Achieve boolean.
     *
     * @param resultInfo the result info
     * @param teleBooth  the tele booth
     * @return the boolean
     */
    public Boolean achieve(ResultInfo resultInfo, TeleBooth teleBooth) {
        PlayerInfo player = playerManager.getPlayer(teleBooth.getUserid());
        Integer type = teleBooth.getType();
        List<TeleBooth> teleBooths = player.getTeleBooths();
        TeleBooth dbTel = null;
        for (TeleBooth booth : teleBooths) {
            if (booth.getId().longValue() == teleBooth.getId().longValue()) {
                dbTel = booth;
            }
        }
        Goods good = player.getOneGoods(teleBooth.getBaseid());

        if (good == null) {
            resultInfo.setResp_code("700005");
            return false;
        }
        if (dbTel == null) {
            resultInfo.setResp_code("700001");
            return false;
        }

        if (dbTel.getAchieve() != 1) {

            resultInfo.setResp_code("700006");
            return false;
        }

        player.removeTeleBOOth(dbTel);
        good.setCount(good.getCount() + dbTel.getCount());
        this.updateGood(good, type);

        return true;
    }


    private void updateGood(Goods good, Integer type) {
        if (type == EItemType.CROP.ID()) {
            CropsMapper bean = (CropsMapper) BeanTools.getBean(CropsMapper.class);
            bean.updateByPrimaryKeySelective((Crops) good);
        } else if (type == EItemType.PROPS.ID()) {
            PropsMapper bean = (PropsMapper) BeanTools.getBean(Props.class);
            bean.updateByPrimaryKeySelective((Props) good);
        }
    }


    public Boolean getFriendOrder(ResultInfo resultInfo, TeleBooth teleBooth) {
        ArrayList<TeleBooth> list = new ArrayList<>();
        PlayerInfo player = playerManager.getPlayer(teleBooth.getUserid());
        List<Friend> friends = player.getAgreeFriends(teleBooth.getUserid());

        for (Friend friend : friends) {
            Long userid = friend.getFriendid();
            List<TeleBooth> teleBooths = playerManager.getPlayer(userid).getTeleBooths();
            list.addAll(teleBooths);
        }
        resultInfo.getData().put("telebooth",list);
        return true;
    }
}
