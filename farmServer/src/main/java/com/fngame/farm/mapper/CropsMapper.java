package com.fngame.farm.mapper;

import com.fngame.farm.model.Crops;
import com.fngame.farm.model.CropsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CropsMapper {
    int countByExample(CropsExample example);

    int deleteByExample(CropsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Crops record);

    int insertSelective(Crops record);

    List<Crops> selectByExample(CropsExample example);

    Crops selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Crops record, @Param("example") CropsExample example);

    int updateByExample(@Param("record") Crops record, @Param("example") CropsExample example);

    int updateByPrimaryKeySelective(Crops record);

    int updateByPrimaryKey(Crops record);
}