package com.fngame.farm.service;

import com.fngame.farm.configer.Entity;
import com.fngame.farm.manager.ConfigManager;
import com.fngame.farm.manager.PlayerManager;
import com.fngame.farm.model.Animal;
import com.fngame.farm.model.Props;
import com.fngame.farm.service.baseService.BaseServiceImpl;
import com.fngame.farm.userdate.PlayerInfo;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AnimaleService implements BaseServiceImpl<Animal> {
    @Autowired
    ConfigManager configManager;
    @Autowired
    PlayerManager playerManager;
    @Override
    public Boolean add(ResultInfo resultInfo, Animal animal) {
        return null;
    }

    @Override
    public Boolean modify(ResultInfo resultInfo, Animal animal) {
        return null;
    }

    @Override
    public Boolean remove(ResultInfo resultInfo, Animal animal) {
        return null;
    }

    @Override
    public Boolean get(ResultInfo resultInfo, Animal animal) {
        return null;
    }

    public boolean feed(ResultInfo resultInfo, Animal animal, Props props) {
        Entity bco = configManager.getAnimalConfig(animal);
        PlayerInfo player = playerManager.getPlayer(animal.getUserid());
        List<Props> propss = player.getPropss();
        for (Props propss1 : propss) {
            if(propss1.getId()==props.getId()){

            }
        }

        return true;
    }



 public void    getProps(){


 }
}
