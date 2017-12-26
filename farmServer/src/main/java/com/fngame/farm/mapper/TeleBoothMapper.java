package com.fngame.farm.mapper;

import com.fngame.farm.model.TeleBooth;
import com.fngame.farm.model.TeleBoothExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TeleBoothMapper {
    int countByExample(TeleBoothExample example);

    int deleteByExample(TeleBoothExample example);

    int deleteByPrimaryKey(Long id);

    int insert(TeleBooth record);

    int insertSelective(TeleBooth record);

    List<TeleBooth> selectByExample(TeleBoothExample example);

    TeleBooth selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") TeleBooth record, @Param("example") TeleBoothExample example);

    int updateByExample(@Param("record") TeleBooth record, @Param("example") TeleBoothExample example);

    int updateByPrimaryKeySelective(TeleBooth record);

    int updateByPrimaryKey(TeleBooth record);

    long getMaxID();
}
