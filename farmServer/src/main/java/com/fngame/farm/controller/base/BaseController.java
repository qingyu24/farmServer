package com.fngame.farm.controller.base;

import com.fngame.farm.service.AnimaleService;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

@Component

public class BaseController {
    @Autowired
    public ResultInfo resultInfo;
    @Autowired
    public AnimaleService animaleService;


}
