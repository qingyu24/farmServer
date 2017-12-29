package com.example.demo;

import com.fngame.farm.FarmApplication;
import com.fngame.farm.manager.PlayerManager;
import com.fngame.farm.util.BeanTools;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FarmApplication.class)
public class DemoApplicationTests {
@Autowired
    PlayerManager playerManager;
	@Test
	public void contextLoads() {
/*   *//*     PlayerInfo player = playerManager.getPlayer((long) 33);
        FriendMapper bean = (FriendMapper) BeanTools.getBean(FriendMapper.class);
        Friend friend = bean.selectByPrimaryKey((long) 10003);
        System.out.println(friend.toString());
        System.out.println(player);*//*
        StoreConfig bean = (StoreConfig) BeanTools.getBean(StoreConfig.class);
        System.out.println(bean.toString());*/
    }

}
