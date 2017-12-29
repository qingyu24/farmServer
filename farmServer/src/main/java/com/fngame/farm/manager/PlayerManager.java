package com.fngame.farm.manager;

import com.fngame.farm.userdate.PlayerInfo;
import com.fngame.farm.util.BeanTools;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.stereotype.Component;

/**
 * Created by qingyu on 2017/12/20.
 */

@Component
public class PlayerManager extends BaseAutowired {


    public PlayerInfo getPlayer(Long userid) {

        PlayerInfo playerInfo = (PlayerInfo) BeanTools.getBean(PlayerInfo.class);
        playerInfo.setId(userid);

        //buildingExample.clear();
        //buildingExample.createCriteria().andUseridEqualTo(userid);
        //List<Building> buildings = buildingMapper.selectByExample(buildingExample);
        //playerInfo.setBuildings(buildings);

        //animalExample.clear();
        // AnimalExample.Criteria criteria2 = animalExample.createCriteria();
        //criteria2.andUseridEqualTo(userid);
        //List<Animal> animales = animalMapper.selectByExample(animalExample);
        // playerInfo.setAnimals(animales);

        //propsExample.clear();
        // PropsExample.Criteria criteria4 = propsExample.createCriteria();
        // criteria4.andUseridEqualTo(userid);
        //List<Props> props = propsMapper.selectByExample(propsExample);
        //playerInfo.setPropss(props);

        //orderExample.clear();
        // UserOrderExample.Criteria criteria = orderExample.createCriteria();
        //criteria.andUseridEqualTo(userid);
        // List<UserOrder> orders = orderMapper.selectByExample(orderExample);
        //playerInfo.setOrders(orders);

        //cropsExample.clear();
        //cropsExample.createCriteria().andUseridEqualTo(userid);
        //List<Crops> crops = cropsMapper.selectByExample(cropsExample);
        //playerInfo.setCrops(crops);

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
