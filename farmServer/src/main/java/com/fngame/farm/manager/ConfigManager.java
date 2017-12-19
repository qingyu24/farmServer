package com.fngame.farm.manager;

import com.fngame.farm.configer.Structure;
import com.fngame.farm.model.Building;
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

    public Structure getBuildingConfig(Building o) {
        ArrayList<Structure> arrayList = loades.get(new Structure());
        if (o != null && arrayList != null) {
            for (Structure structure : arrayList) {
                if (structure.ID == o.getBaseid()) {
                    return structure;
                }
            }
        }
        return null;
    }
}