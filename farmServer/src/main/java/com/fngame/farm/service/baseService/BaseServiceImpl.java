package com.fngame.farm.service.baseService;

import com.fngame.farm.userdate.ResultInfo;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


/**
 * Created by qingyu on 2017/12/20.
 */
@Service
@Transactional
public interface BaseServiceImpl<T> {


    Boolean add(ResultInfo resultInfo, T t);


    Boolean modify(ResultInfo resultInfo, T t);


    Boolean remove(ResultInfo resultInfo, T t);


    Boolean get(ResultInfo resultInfo, T t);
}
