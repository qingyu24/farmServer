package com.fngame.farm.mapper;

import com.fngame.farm.model.CarInfo;
import com.fngame.farm.model.CarInfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface CarInfoMapper {
    int countByExample(CarInfoExample example);

    int deleteByExample(CarInfoExample example);

    int deleteByPrimaryKey(Long carinfoid);

    int insert(CarInfo record);

    int insertSelective(CarInfo record);

    List<CarInfo> selectByExample(CarInfoExample example);

    CarInfo selectByPrimaryKey(Long carinfoid);

    int updateByExampleSelective(@Param("record") CarInfo record, @Param("example") CarInfoExample example);

    int updateByExample(@Param("record") CarInfo record, @Param("example") CarInfoExample example);

    int updateByPrimaryKeySelective(CarInfo record);

    int updateByPrimaryKey(CarInfo record);
}