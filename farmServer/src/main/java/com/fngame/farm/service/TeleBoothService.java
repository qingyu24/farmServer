package com.fngame.farm.service;

import com.fngame.farm.mapper.TeleBoothMapper;
import com.fngame.farm.model.TeleBooth;
import com.fngame.farm.model.TeleBoothExample;
import com.fngame.farm.service.baseService.BaseServiceImpl;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * Created by qingyu on 2017/12/26 /17:26
 */
@Service
public class TeleBoothService implements BaseServiceImpl<TeleBooth> {
    @Autowired
    TeleBoothMapper teleBoothMapper;
    @Autowired
    TeleBoothExample teleBoothExample;

    @Override
    public Boolean add(ResultInfo resultInfo, TeleBooth teleBooth) {
        TeleBoothExample.Criteria criteria = teleBoothExample.createCriteria();
        criteria.andUseridEqualTo(teleBooth.getUserid());
        List<TeleBooth> teleBooths = teleBoothMapper.selectByExample(teleBoothExample);
        if (teleBooths == null || teleBooths.size() == 0) {

        } else if (teleBooths.size() == 1) {
            TeleBooth teleBooth1 = teleBooths.get(0);
            Integer achieve = teleBooth1.getAchieve();
            if (achieve == 1) {
                teleBooth.setBegintime(new Date());
                teleBooth.setId(teleBooth1.getId());

            } else if (achieve == 0) {

                return false;
            }
        } else {

            return false;
        }
        return null;
    }

    @Override
    public Boolean modify(ResultInfo resultInfo, TeleBooth teleBooth) {
        return null;
    }

    @Override
    public Boolean remove(ResultInfo resultInfo, TeleBooth teleBooth) {
        return null;
    }

    @Override
    public Boolean get(ResultInfo resultInfo, TeleBooth teleBooth) {
        return null;
    }
}
