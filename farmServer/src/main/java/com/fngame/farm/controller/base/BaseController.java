package com.fngame.farm.controller.base;

import com.fngame.farm.service.AnimaleService;
import com.fngame.farm.userdate.ResultInfo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component

public class BaseController {
    @Autowired
    public ResultInfo resultInfo;
    @Autowired
    public AnimaleService animaleService;

    public Logger logger= LoggerFactory.getLogger(this.getClass());

}
