package com.fngame.farm.service;

import com.fngame.farm.manager.PlayerManager;
import com.fngame.farm.mapper.FriendMapper;
import com.fngame.farm.model.Friend;
import com.fngame.farm.model.FriendExample;
import com.fngame.farm.model.User;
import com.fngame.farm.userdate.PlayerInfo;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;

/**
 * Created by qingyu on 2017/12/22 /12:27
 */
@Service
public class FriendService {
    @Autowired
    PlayerManager PlayerManager;
    @Autowired
    FriendMapper friendMapper;
    @Autowired
    FriendExample friendExample;

    @Transactional
    public Boolean add(ResultInfo resultInfo, Friend friend) {
        PlayerInfo player = PlayerManager.getPlayer(friend.getUserid());
        PlayerInfo fPlayer = PlayerManager.getPlayer(friend.getFriendid());
        if (player.getUser() == null || fPlayer.getUser() == null) {
            resultInfo.setResp_code("100005");
            return false;
        }
        List<Friend> Friends = player.getFriends();
        List<Friend> Friends_tar = fPlayer.getFriends();
        if (Friends.contains(friend) || Friends_tar.contains(friend)) {
            resultInfo.setResp_code("100004");
            return false;
        }

        Friend newFriends = getNewFriends(player.getUser(), fPlayer.getUser());
        newFriends.setAgree(0);
        Friend newFriends1 = getNewFriends(fPlayer.getUser(), player.getUser());
        newFriends1.setAgree(2);
        friendMapper.insertSelective(newFriends);
        friendMapper.insertSelective(newFriends1);
        Friends.add(newFriends);
        Friends_tar.add(newFriends1);
        player.UpdatePlayer();
        fPlayer.UpdatePlayer();
        return true;
    }

    private Friend getNewFriends(User player, User fPlayer) {
        Friend friend = new Friend();
        friend.setUserid(player.getUserid());
        friend.setFriendid(fPlayer.getUserid());
        friend.setHeadurl(fPlayer.getHeadurl());
        friend.setNickname(fPlayer.getNickname());
        friend.setSex(fPlayer.getSex());
        return friend;
    }


    public Boolean modify(ResultInfo resultInfo, Friend friend) {
        return null;
    }

    @Transactional
    public Boolean remove(ResultInfo resultInfo, Friend friend) {
        PlayerInfo player = PlayerManager.getPlayer(friend.getUserid());
        PlayerInfo fPlayer = PlayerManager.getPlayer(friend.getFriendid());

        player.getFriends().remove(friend);
        friendExample.clear();
        FriendExample.Criteria criteria = friendExample.createCriteria();
        criteria.andUseridEqualTo(friend.getUserid());
        criteria.andFriendidEqualTo(friend.getFriendid());
        friendMapper.deleteByExample(friendExample);

        friendExample.clear();
        FriendExample.Criteria criteria1 = friendExample.createCriteria();
        criteria1.andUseridEqualTo(friend.getFriendid());
        criteria1.andFriendidEqualTo(friend.getFriendid());
        friendMapper.deleteByExample(friendExample);

        player.getFriends().remove(friend.change());


        return null;
    }


    public Boolean get(ResultInfo resultInfo, Friend friend) {
        Long userid = friend.getUserid();
        PlayerInfo player = PlayerManager.getPlayer(userid);
        List<Friend> friends = player.getFriends();
        HashMap<String, Object> data = resultInfo.getData();
        data.put("friends", friends);
        return true;
    }
}
