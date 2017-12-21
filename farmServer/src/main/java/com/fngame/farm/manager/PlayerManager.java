package com.fngame.farm.manager;

import com.fngame.farm.model.*;
import com.fngame.farm.userdate.PlayerInfo;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import java.util.List;

/**
 * Created by qingyu on 2017/12/20.
 */

@Component
public class PlayerManager extends BaseAutowired {


    @Cacheable(value = "player", key = "#userid")
    public PlayerInfo getPlayer(long userid) {
        PlayerInfo playerInfo = new PlayerInfo();
        List<Building> buildings = buildingMapper.selectByUserid(userid);
        playerInfo.setBuildings(buildings);
        List<Animal> animales = animalMapper.selectByUserid(userid);
        playerInfo.setAnimals(animales);
        List<Props> props = propsMapper.selectByUserid(userid);
        playerInfo.setPropss(props);
        orderExample.clear();
        UserOrderExample.Criteria criteria = orderExample.createCriteria();
        criteria.andUseridEqualTo(userid);
        List<UserOrder> orders = orderMapper.selectByExample(orderExample);
        playerInfo.setOrders(orders);
        return playerInfo;
    }

    @CachePut(value = "player", key = "#playerInfo.ID")
    public PlayerInfo UpdatePlayer(PlayerInfo playerInfo) {

        return playerInfo;
    }

    @CacheEvict(value = "player", key = "#playerInfo.ID")
    public void delePlayer(PlayerInfo playerInfo) {
    }
}
