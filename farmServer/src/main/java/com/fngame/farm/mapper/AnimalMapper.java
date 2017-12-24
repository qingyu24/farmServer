package com.fngame.farm.mapper;

import com.fngame.farm.model.Animal;
import com.fngame.farm.model.AnimalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AnimalMapper {
    int countByExample(AnimalExample example);

    int deleteByExample(AnimalExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Animal record);

    int insertSelective(Animal record);

    List<Animal> selectByExample(AnimalExample example);

    Animal selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Animal record, @Param("example") AnimalExample example);

    int updateByExample(@Param("record") Animal record, @Param("example") AnimalExample example);

    int updateByPrimaryKeySelective(Animal record);

    int updateByPrimaryKey(Animal record);

}