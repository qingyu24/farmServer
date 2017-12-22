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

    private static PlayerManager playerManager;

    public static PlayerManager getInstance() {
        if (playerManager == null) playerManager = new PlayerManager();
        return playerManager;
    }

    @Cacheable(value = "player", key = "#userid")
    public PlayerInfo getPlayer(long userid) {
        PlayerInfo playerInfo = new PlayerInfo();

        userExample.clear();
        userExample.createCriteria().andUseridEqualTo(userid);

        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() > 0) playerInfo.setUser(users.get(0));

        buildingExample.clear();
        buildingExample.createCriteria().andUseridEqualTo(userid);
        List<Building> buildings = buildingMapper.selectByExample(buildingExample);
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
        cropsExample.clear();
        cropsExample.createCriteria().andUseridEqualTo(userid);
        List<Crops> crops = cropsMapper.selectByExample(cropsExample);
        playerInfo.setCrops(crops);
        friendExample.clear();
        FriendExample.Criteria criteria1 = friendExample.createCriteria();
        criteria1.andUseridEqualTo(userid);
        List<Friend> friends = friendMapper.selectByExample(friendExample);
        playerInfo.setFriends(friends);

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
