package com.fngame.farm.manager;

import com.fngame.farm.mapper.*;
import com.fngame.farm.model.*;
import com.fngame.farm.userdate.RequserOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import sun.reflect.generics.scope.Scope;

/**
 * Created by qingyu on 2017/12/20.
 */
@Component
public class BaseAutowired {
    @Autowired
public     BuildingMapper buildingMapper;
    @Autowired
    public BuildingExample buildingExample;

    @Autowired
  public   CropsMapper cropsMapper;

    @Autowired
    public CropsExample cropsExample;
    @Autowired
   public AnimalMapper animalMapper;

    @Autowired
    public AnimalExample animalExample;
    @Autowired
  public   PropsMapper propsMapper;

    @Autowired
    public PropsExample propsExample;
    @Autowired
  public   UserMapper userMapper;

    @Autowired
    public UserExample userExample;
    @Autowired
   public UserOrderMapper orderMapper;
    @Autowired
  public   UserOrderExample orderExample;
    @Autowired
    public RequserOrder requserOrder;


}
