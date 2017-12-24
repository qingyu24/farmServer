package com.fngame.farm.controller;

import com.fngame.farm.manager.BaseAutowired;
import com.fngame.farm.manager.PlayerManager;
import com.fngame.farm.manager.SqlListManager;
import com.fngame.farm.mapper.UserMapper;
import com.fngame.farm.model.Props;
import com.fngame.farm.model.User;
import com.fngame.farm.model.UserExample;
import com.fngame.farm.userdate.PlayerInfo;
import com.fngame.farm.userdate.RequserOrder;
import com.fngame.farm.userdate.ResultInfo;
import com.fngame.farm.util.SqlList;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;

/**
 * Created by qingyu on 2017/12/21.
 */
@RestController
@RequestMapping("warhouse")
public class WareHouseController {
    @Autowired
    PlayerManager playerManager;
    @Autowired
    ResultInfo resultInfo;

    @RequestMapping("get")
    public ResultInfo getHouser(RequserOrder order, long userid) {
        resultInfo.setOrder(order);
        PlayerInfo player = playerManager.getPlayer(userid);
        List granary = player.getWarehouse();
        List<Props> propss = player.getPropss();
        HashMap<String, Object> data = resultInfo.getData();
        data.put("granary", granary);
        data.put("props", propss);
        resultInfo.setSucess();
        return resultInfo;
    }

    @Autowired
    BaseAutowired baseAutowired;

    @Autowired
    UserExample userExample;
    @Autowired
    BeanFactory beanFactory;

    @Autowired
    SqlListManager sqlListManager;
    @Autowired
    UserMapper userMapper;

    @RequestMapping("test")
    public String gets() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
 /*       SqlList newlist = sqlListManager.getNewlist();

        resultInfo.setSucess();
        ResultInfo bean = (ResultInfo) beanFactory.getBean(resultInfo.getClass());
        System.out.println(bean.toString());

        Method[] methods = userMapper.getClass().getMethods();

        Method insertSelective=null;
        for (Method method : methods) {
            System.out.println("ddd");
            System.out.println(method.getName());
            if(method.getName().equals("insertSelective")){
                insertSelective=method;
                break;
            }
        }*/
        Props user = new Props();
        user.setBaseid(1111);

        List<Props> newlist = sqlListManager.getNewlist();
        newlist.add(user);
        Props props = new Props();
        props.setBaseid(222);
        props.setUserid(Long.parseLong("22222222222"));
        return null;
    }
}
