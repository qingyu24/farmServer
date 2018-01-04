package com.fngame.farm.mapper;

import com.fngame.farm.model.CraftProduce;
import com.fngame.farm.model.CraftProduceExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CraftProduceMapper {
    int countByExample(CraftProduceExample example);

    int deleteByExample(CraftProduceExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CraftProduce record);

    int insertSelective(CraftProduce record);

    List<CraftProduce> selectByExample(CraftProduceExample example);

    CraftProduce selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CraftProduce record, @Param("example") CraftProduceExample example);

    int updateByExample(@Param("record") CraftProduce record, @Param("example") CraftProduceExample example);

    int updateByPrimaryKeySelective(CraftProduce record);

    int updateByPrimaryKey(CraftProduce record);
}