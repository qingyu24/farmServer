package com.fngame.farm.manager;

import com.fngame.farm.configer.Crop;
import com.fngame.farm.configer.Entity;
import com.fngame.farm.configer.Order;
import com.fngame.farm.configer.Resp;
import com.fngame.farm.model.Animal;
import com.fngame.farm.model.Building;
import com.fngame.farm.model.Crops;
import com.fngame.farm.userdate.PlayerInfo;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Component
public class ConfigManager {
    public static ConfigManager instance;

    public static ConfigManager getInstance() {
        if (instance == null) {
            instance = new ConfigManager();
        }
        return instance;
    }

    private HashMap<String, ArrayList> loades = ConfigLoaderManager.getInstance().getLoaders();


    public List getloader(Object o) {
        return loades.get(o.getClass().getSimpleName());
    }

    @Cacheable(value = "building_conf", key = "#o.baseid")
    public Entity getBuildingConfig(Building o) {

        ArrayList<Entity> arrayList = loades.get(Entity.class.getSimpleName());
        if (o != null && arrayList != null) {
            for (Entity Entity : arrayList) {
                if (Entity.BuildingID.intValue() == o.getBaseid()) {
                    return Entity;
                }
            }
        }
        return null;
    }

    List list = new ArrayList(10);


    public List<Order> getOrders(PlayerInfo playerInfo, int size) {

        ArrayList<Order> arrayList = loades.get(Order.class.getSimpleName());
        list.clear();

        while (list.size() < size) {
            int v = (int) (Math.random() * arrayList.size());
            Order order = arrayList.get(v);
            if (!list.contains(order)) {

                list.add(order);

            }
        }
        return list;
    }

    @Cacheable(value = "crop_conf", key = "#crops.baseid")
    public Crop getCrops(Crops crops) {
        ArrayList<Crop> list = loades.get(Crop.class.getSimpleName());
        for (Crop crop : list) {
            if (crops.getBaseid() == crop.ID) {
                return crop;
            }
        }

        return null;
    }

    @Cacheable(value = "resp_conf", key = "#resp_code")
    public String getResp(String resp_code) {
        if (resp_code == null) return "未知错误1";
        ArrayList<Resp> arrayList = loades.get(Resp.class.getSimpleName());
        for (Resp resp : arrayList) {
            if (resp_code.equals(resp.resp_code)) {
                return resp.resp_desc;
            }
        }
        return "未知错误2";
    }

    public Entity getAnimalConfig(Animal animal) {


        return null;
    }
}
