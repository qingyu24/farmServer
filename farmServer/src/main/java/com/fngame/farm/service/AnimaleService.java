package com.fngame.farm.service;

import com.fngame.farm.model.Animal;
import com.fngame.farm.service.baseService.BaseServiceImpl;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.stereotype.Service;

@Service
public class AnimaleService implements BaseServiceImpl<Animal> {

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
}
