package com.fngame.farm.manager;

import com.fngame.farm.mapper.*;
import com.fngame.farm.model.*;
import com.fngame.farm.userdate.RequserOrder;
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
    public CropsMapper cropsMapper;

    @Autowired
    public AnimalMapper animalMapper;

    @Autowired
    public PropsMapper propsMapper;


    @Autowired
    public UserMapper userMapper;


    @Autowired
    public UserOrderMapper orderMapper;

    @Autowired
    public RequserOrder requserOrder;

    @Autowired
    public FriendMapper friendMapper;



    @Autowired
    protected TeleBoothMapper teleBoothMapper;

    /*    public void getexample(String simpleName) {
            Object bean = beanFactory.getBean(simpleName + "Example");
            System.out.println(bean.getClass().getSimpleName());
            System.out.println(bean.toString());

        }*/

    @Autowired
    protected PetDataMapper petDataMapper;
    @Autowired
    protected  CraftProduceMapper craftProduceMapper;
}
