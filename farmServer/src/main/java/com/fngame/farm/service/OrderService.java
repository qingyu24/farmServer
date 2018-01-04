package com.fngame.farm.service;

import com.fngame.farm.configer.Order;
import com.fngame.farm.manager.ConfigManager;
import com.fngame.farm.manager.PlayerManager;
import com.fngame.farm.mapper.UserOrderMapper;
import com.fngame.farm.model.UserOrder;
import com.fngame.farm.service.baseService.BaseServiceImpl;
import com.fngame.farm.userdate.PlayerInfo;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by qingyu on 2017/12/21.
 */
@Service
public class OrderService implements BaseServiceImpl<UserOrder> {
    @Autowired
    PlayerManager playerManager;
    @Autowired
    UserOrderMapper orderMapper;

    @Override
    public Boolean add(ResultInfo resultInfo, UserOrder userOrder) {
        return null;
    }

    @Override
    public Boolean modify(ResultInfo resultInfo, UserOrder userOrder) {
        return null;
    }

    @Override
    public Boolean remove(ResultInfo resultInfo, UserOrder userOrder) {
        orderMapper.deleteByPrimaryKey(userOrder.getId());
        PlayerInfo player = playerManager.getPlayer(userOrder.getUserid());
        boolean remove = player.getOrders().remove(userOrder);
        System.out.println(remove);
       if(remove){
        this.addOrder(resultInfo, userOrder);
        player.UpdatePlayer();}
        else{
           resultInfo.setResult("0001","该订单不存在");
       }
        return true;
    }

    @Override
    public Boolean get(ResultInfo resultInfo, UserOrder userOrder) {
        return null;
    }

    List list = new ArrayList();


    public boolean getOrders(ResultInfo resultInfo, UserOrder userOrder) {

        PlayerInfo player = playerManager.getPlayer(userOrder.getUserid());
        List<UserOrder> orders = player.getOrders();
        resultInfo.getData().put("orders", orders);
        return true;

    }


    public boolean addOrder(ResultInfo resultInfo, UserOrder userOrder) {

        PlayerInfo player = playerManager.getPlayer(userOrder.getUserid());
        List<Order> orders = ConfigManager.getInstance().getOrders(player, 1);
        long maxID = orderMapper.getMaxID();
        UserOrder ord = new UserOrder();
        ord.setBaseid(orders.get(0).OrderID);
        ord.setUserid(userOrder.getUserid());
        ord.setId(++maxID);
        orderMapper.insertSelective(ord);
        player.getOrders().add(ord);
        player.UpdatePlayer();
        HashMap<String, Object> data = resultInfo.getData();
        ArrayList<UserOrder> userOrders = new ArrayList<>(1);
        userOrders.add(ord);
        data.put("orders", userOrders);
        return true;
    }

    public boolean adhieve(ResultInfo resultInfo, UserOrder userOrder) {

        return false;

    }
}
