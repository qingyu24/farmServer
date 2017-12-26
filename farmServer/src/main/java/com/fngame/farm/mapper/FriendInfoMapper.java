package com.fngame.farm.mapper;

import com.fngame.farm.model.FriendInfo;
import com.fngame.farm.model.FriendInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface FriendInfoMapper {
    int countByExample(FriendInfoExample example);

    int deleteByExample(FriendInfoExample example);

    int insert(FriendInfo record);

    int insertSelective(FriendInfo record);

    List<FriendInfo> selectByExample(FriendInfoExample example);

    int updateByExampleSelective(@Param("record") FriendInfo record, @Param("example") FriendInfoExample example);

    int updateByExample(@Param("record") FriendInfo record, @Param("example") FriendInfoExample example);
}