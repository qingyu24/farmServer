package com.fngame.farm.manager;

import com.fngame.farm.model.*;
import com.fngame.farm.userdate.PlayerInfo;
import org.springframework.beans.factory.annotation.Autowired;
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
    @Autowired
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

        animalExample.clear();
        AnimalExample.Criteria criteria2 = animalExample.createCriteria();
        criteria2.andUseridEqualTo(userid);
        List<Animal> animales = animalMapper.selectByExample(animalExample);
        playerInfo.setAnimals(animales);

        propsExample.clear();
        PropsExample.Criteria criteria4 = propsExample.createCriteria();
        criteria4.andUseridEqualTo(userid);
        List<Props> props = propsMapper.selectByExample(propsExample);
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

        craftProduceExample.clear();
        CraftProduceExample.Criteria criteria3 = craftProduceExample.createCriteria();
        criteria3.andUseridEqualTo(userid);
        List<CraftProduce> craftProduces = craftProduceMapper.selectByExample(craftProduceExample);
        playerInfo.setCraftProduces(craftProduces);

        teleBoothExample.clear();
        TeleBoothExample.Criteria criteria5 = teleBoothExample.createCriteria();
        criteria5.andUseridEqualTo(userid);
        List<TeleBooth> teleBooths = teleBoothMapper.selectByExample(teleBoothExample);
        playerInfo.setTeleBooths(teleBooths);

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
