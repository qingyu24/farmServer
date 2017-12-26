package com.fngame.farm.mapper;

import com.fngame.farm.model.Props;
import com.fngame.farm.model.PropsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface PropsMapper {
    int countByExample(PropsExample example);

    int deleteByExample(PropsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Props record);

    int insertSelective(Props record);

    List<Props> selectByExample(PropsExample example);

    Props selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Props record, @Param("example") PropsExample example);

    int updateByExample(@Param("record") Props record, @Param("example") PropsExample example);

    int updateByPrimaryKeySelective(Props record);

    int updateByPrimaryKey(Props record);
}