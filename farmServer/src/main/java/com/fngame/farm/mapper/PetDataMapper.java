package com.fngame.farm.mapper;

import com.fngame.farm.model.PetData;
import com.fngame.farm.model.PetDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PetDataMapper {
    int countByExample(PetDataExample example);

    int deleteByExample(PetDataExample example);

    int deleteByPrimaryKey(Long id);

    int insert(PetData record);

    int insertSelective(PetData record);

    List<PetData> selectByExample(PetDataExample example);

    PetData selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") PetData record, @Param("example") PetDataExample example);

    int updateByExample(@Param("record") PetData record, @Param("example") PetDataExample example);

    int updateByPrimaryKeySelective(PetData record);

    int updateByPrimaryKey(PetData record);
}