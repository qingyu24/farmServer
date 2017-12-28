package com.fngame.farm.service;

import com.fngame.farm.mapper.UserMapper;
import com.fngame.farm.model.User;
import com.fngame.farm.model.UserExample;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

@Service
public class loginService {
    @Resource
    UserMapper userMapper;


    public boolean addUser(User user, Integer type) {
        //根据type 判断是否注册过
        User user1 = null;
        if (type == null) type = 1;
        switch (type) {
            case 1:
                user1 = this.getUser(user.getUsername(), user.getPassword(), 4);
                break;
            case 2:
                user1 = this.getUser(user.getTel(), user.getPassword(), type);
                break;
            case 3:
                user1 = this.getUser(user.getOpenid(), null, type);
        }
        int i = 0;
        if (user1 == null) {
            try {
                user.setExp(0);
                user.setScore(0);
                user.setIcon(0);
                user.setMoney(0);
                user.setBeans(0);
                user.setLevel(0);
                user.setIngot(0);
                i = userMapper.insert(user);
            } catch (Exception e) {
                return false;
            }
        }
        return i > 0;
    }

    public User getUser(String username, String password, Integer type) {
        UserExample userExample = new UserExample();
        UserExample.Criteria criteria = userExample.createCriteria();
if(type==null)type=1;

        switch (type) {
            case 1://账户密码登录
                criteria.andUsernameEqualTo(username);
                criteria.andPasswordEqualTo(password);
                break;
            case 2://电话号码登录
                criteria.andTelEqualTo(username);
                criteria.andPasswordEqualTo(password);
                break;
            case 3://QQ微信登录
                criteria.andOpenidEqualTo(username);
                break;
            case 4://检查是否有该用户名的用户
                criteria.andUsernameEqualTo(username);
                break;
        }

        List<User> users = userMapper.selectByExample(userExample);
        if (users.size() > 0) {
            User user = users.get(0);
            user.setLogintime(new Date());
            userMapper.updateByPrimaryKey(user);
            return users.get(0);
        }

        return null;
    }
}
