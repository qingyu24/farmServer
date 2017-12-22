package com.fngame.farm.controller.base;

import com.fngame.farm.userdate.RequserOrder;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.web.bind.annotation.RequestMapping;

public interface BaseContorllerInterface<T> {

    @RequestMapping("add")
    ResultInfo add(RequserOrder order, T t);

    @RequestMapping("modify")
    ResultInfo modify(RequserOrder order, T t);

    @RequestMapping("remove")
    ResultInfo remove(RequserOrder order, T t);

    @RequestMapping("get")
    ResultInfo get(RequserOrder order, T t);

}
