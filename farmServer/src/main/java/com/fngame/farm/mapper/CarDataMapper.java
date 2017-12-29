package com.fngame.farm.mapper;

import com.fngame.farm.model.CarData;
import com.fngame.farm.model.CarDataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarDataMapper {
    int countByExample(CarDataExample example);

    int deleteByExample(CarDataExample example);

    int deleteByPrimaryKey(Long carinfoid);

    int insert(CarData record);

    int insertSelective(CarData record);

    List<CarData> selectByExample(CarDataExample example);

    CarData selectByPrimaryKey(Long carinfoid);

    int updateByExampleSelective(@Param("record") CarData record, @Param("example") CarDataExample example);

    int updateByExample(@Param("record") CarData record, @Param("example") CarDataExample example);

    int updateByPrimaryKeySelective(CarData record);

    int updateByPrimaryKey(CarData record);
}