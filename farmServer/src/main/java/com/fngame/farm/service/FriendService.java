package com.fngame.farm.service;

import com.fngame.farm.etypes.EFriendType;
import com.fngame.farm.manager.PlayerManager;
import com.fngame.farm.mapper.FriendMapper;
import com.fngame.farm.model.Friend;
import com.fngame.farm.model.FriendExample;
import com.fngame.farm.model.FriendInfo;
import com.fngame.farm.model.User;
import com.fngame.farm.userdate.PlayerInfo;
import com.fngame.farm.userdate.ResultInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by qingyu on 2017/12/22 /12:27
 */
@Service
public class FriendService {
    private static long friendid = 0;
    @Autowired
    PlayerManager PlayerManager;
    @Autowired
    FriendMapper friendMapper;
    @Autowired
    FriendExample friendExample;
    List<Friend> m_friends = new ArrayList<>(2);

    @Transactional
    public Boolean add(ResultInfo resultInfo, Friend friend) throws Exception {
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
        newFriends1.setAgree(1);
        friendMapper.insertSelective(newFriends);
        friendMapper.insertSelective(newFriends1);
        Friends.add(newFriends);
        Friends_tar.add(newFriends1);
        player.UpdatePlayer();
        fPlayer.UpdatePlayer();
        return true;
    }

    private Friend getNewFriends(User player, User fPlayer) {
        if (friendid == 0) {
            friendExample.clear();
            try {
                friendid = friendMapper.getID();
            } catch (Exception e) {
                //如果数据库数据为空
                friendid = 10000;
            }
        }
        Friend friend = new Friend();
        friend.setUserid(player.getUserid());
        friend.setFriendid(fPlayer.getUserid());
        friend.setId(++friendid);
        return friend;
    }


    public Boolean modify(ResultInfo resultInfo, Friend friend) {
        return null;
    }

    @Transactional
    public Boolean remove(ResultInfo resultInfo, Friend friend) {


        PlayerInfo player = PlayerManager.getPlayer(friend.getUserid());
        PlayerInfo fPlayer = PlayerManager.getPlayer(friend.getFriendid());

        if (player == null || fPlayer == null) {
            resultInfo.setResp_code("100005");
            return false;
        }
        boolean remove1 = player.getFriends().remove(friend);
        boolean remove = fPlayer.getFriends().remove(friend.change());
        if (!remove1 || !remove) {
            resultInfo.setResp_code("100005");
            return false;
        }

        friendExample.clear();
        FriendExample.Criteria criteria = friendExample.createCriteria();
        criteria.andUseridEqualTo(friend.getUserid());
        criteria.andFriendidEqualTo(friend.getFriendid());
        friendMapper.deleteByExample(friendExample);


        friendExample.clear();
        FriendExample.Criteria criteria1 = friendExample.createCriteria();
        criteria1.andUseridEqualTo(friend.getFriendid());
        criteria1.andFriendidEqualTo(friend.getUserid());
        friendMapper.deleteByExample(friendExample);

        HashMap<String, Object> data = resultInfo.getData();
        m_friends.clear();
        m_friends.add(friend);
        friend.setAgree(0);
        data.put("friends", m_friends);

        return true;
    }


    public Boolean get(ResultInfo resultInfo, Friend friend) {
        Long userid = friend.getUserid();
        PlayerInfo player = PlayerManager.getPlayer(userid);
        List<FriendInfo> friends = player.getFriendList();
        HashMap<String, Object> data = resultInfo.getData();
        data.put("friends", friends);
        return true;
    }

    public Boolean agree(ResultInfo resultInfo, Friend friend) {

        PlayerInfo player = PlayerManager.getPlayer(friend.getUserid());
        PlayerInfo fPlayer = PlayerManager.getPlayer(friend.getFriendid());
        if (player.getUser() == null || fPlayer.getUser() == null) {
            resultInfo.setResp_code("100005");
            return false;
        }
        List<Friend> getfriend = this.getfriend(friend);
        if (getfriend.size() == 2) {
            getfriend.get(0).setAgree(EFriendType.AGREE.ID());
            getfriend.get(1).setAgree(EFriendType.AGREE.ID());

            friendMapper.updateByPrimaryKeySelective(getfriend.get(0));
            friendMapper.updateByPrimaryKeySelective(getfriend.get(1));
        } else {
            resultInfo.setResp_code("100005");
            return false;
        }
        player.UpdatePlayer();
        fPlayer.UpdatePlayer();
        HashMap<String, Object> data = resultInfo.getData();
        for (Friend friend1 : getfriend) {
            if (friend1.getUserid() == friend.getFriendid()) {
                m_friends.clear();
                m_friends.add(friend1);
                data.put("friends", m_friends);
            }
        }

        return true;
    }


    public List<Friend> getfriend(Friend friend) {
        ArrayList<Friend> m_friends = new ArrayList<>(2);
        PlayerInfo player = PlayerManager.getPlayer(friend.getUserid());

        List<Friend> friends = player.getFriends();

        for (Friend friend1 : friends) {
            if (friend1.getFriendid() == friend.getFriendid() && friend1.getUserid() == friend.getUserid()) {
                m_friends.add(friend1);
            }
        }

        List<Friend> friends1 = PlayerManager.getPlayer(friend.getFriendid()).getFriends();
        for (Friend friend1 : friends1) {
            if (friend1.getFriendid() == friend.getUserid() && friend1.getUserid() == friend.getFriendid()) {
                m_friends.add(friend1);
            }
        }
        return m_friends;
    }

}
