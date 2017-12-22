package com.fngame.farm.controller;

import com.fngame.farm.controller.base.BaseContorllerInterface;
import com.fngame.farm.model.Props;
import com.fngame.farm.userdate.RequserOrder;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("props")
public class PropsController implements BaseContorllerInterface<Props> {
    @Override
    public ResultInfo add(RequserOrder order, Props props) {
        return null;
    }

    @Override
    public ResultInfo modify(RequserOrder order, Props props) {
        return null;
    }

    @Override
    public ResultInfo remove(RequserOrder order, Props props) {
        return null;
    }

    @Override
    public ResultInfo get(RequserOrder order, Props props) {
        return null;
    }
}
