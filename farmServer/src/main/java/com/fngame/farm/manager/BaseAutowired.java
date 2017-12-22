package com.fngame.farm.manager;

import com.fngame.farm.mapper.*;
import com.fngame.farm.model.*;
import com.fngame.farm.userdate.RequserOrder;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by qingyu on 2017/12/20.
 */
@Component
public class BaseAutowired {
    @Autowired
    public BuildingMapper buildingMapper;
    @Autowired
    public BuildingExample buildingExample;

    @Autowired
    public CropsMapper cropsMapper;

    @Autowired
    public CropsExample cropsExample;
    @Autowired
    public AnimalMapper animalMapper;

    @Autowired
    public AnimalExample animalExample;
    @Autowired
    public PropsMapper propsMapper;

    @Autowired
    public PropsExample propsExample;
    @Autowired
    public UserMapper userMapper;

    @Autowired
    public UserExample userExample;
    @Autowired
    public UserOrderMapper orderMapper;
    @Autowired
    public UserOrderExample orderExample;
    @Autowired
    public RequserOrder requserOrder;

    @Autowired
    FriendMapper friendMapper;
    @Autowired
    FriendExample friendExample;
    @Autowired
    BeanFactory beanFactory;

    public void getexample(String simpleName) {
        Object bean = beanFactory.getBean(simpleName + "Example");
        System.out.println(bean.getClass().getSimpleName());
        System.out.println(bean.toString());

    }
}
