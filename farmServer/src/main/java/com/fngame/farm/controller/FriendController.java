package com.fngame.farm.controller;

import com.fngame.farm.controller.base.BaseContorllerInterface;
import com.fngame.farm.model.Friend;
import com.fngame.farm.service.FriendService;
import com.fngame.farm.userdate.RequserOrder;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by qingyu on 2017/12/22.
 */
@RestController
@RequestMapping("friend")
public class FriendController implements BaseContorllerInterface<Friend> {
    @Autowired
    ResultInfo resultInfo;
    @Autowired
    FriendService friendService;

    @Override
    public ResultInfo add(RequserOrder order, Friend friend) {
        resultInfo.setOrder(order);
        Boolean add = true;
        try {
            add = friendService.add(resultInfo, friend);
        } catch (Exception e) {
            e.printStackTrace();
            resultInfo.setfalse();
        }
        if (add) {
            resultInfo.setSucess(true);
        }
        return resultInfo;
    }

    @Override
    public ResultInfo modify(RequserOrder order, Friend friend) {
        return null;
    }

    @Override
    public ResultInfo remove(RequserOrder order, Friend friend) {
        resultInfo.setOrder(order);
        Boolean add = friendService.remove(resultInfo, friend);
        if (!add) {
            resultInfo.setfalse();
        }
        return resultInfo;
    }

    @Override
    public ResultInfo get(RequserOrder order, Friend friend) {
        resultInfo.setOrder(order);
        Boolean aBoolean = friendService.get(resultInfo, friend);
        if (aBoolean) {
            resultInfo.setSucess(true);
        }
        return resultInfo;
    }

    @RequestMapping("agree")
    public ResultInfo agree(RequserOrder order, Friend friend) {
        resultInfo.setOrder(order);
        Boolean aBoolean = friendService.agree(resultInfo, friend);
        if (!aBoolean) {
            resultInfo.setfalse();
        }
        return resultInfo;
    }

}
