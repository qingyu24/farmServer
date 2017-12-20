package com.fngame.farm.manager;

import com.fngame.farm.configer.Entity;
import com.fngame.farm.model.Building;
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

    @Cacheable(value = "building", key = "#o.baseid")
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

}
