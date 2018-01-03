package com.fngame.farm.mapper;

import com.fngame.farm.model.LikeInfo;
import com.fngame.farm.model.LikeInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LikeInfoMapper {
    int countByExample(LikeInfoExample example);

    int deleteByExample(LikeInfoExample example);

    int deleteByPrimaryKey(Long likeid);

    int insert(LikeInfo record);

    int insertSelective(LikeInfo record);

    List<LikeInfo> selectByExample(LikeInfoExample example);

    LikeInfo selectByPrimaryKey(Long likeid);

    int updateByExampleSelective(@Param("record") LikeInfo record, @Param("example") LikeInfoExample example);

    int updateByExample(@Param("record") LikeInfo record, @Param("example") LikeInfoExample example);

    int updateByPrimaryKeySelective(LikeInfo record);

    int updateByPrimaryKey(LikeInfo record);
}