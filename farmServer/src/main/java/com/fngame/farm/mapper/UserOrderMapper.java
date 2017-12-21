package com.fngame.farm.mapper;

import com.fngame.farm.model.UserOrder;
import com.fngame.farm.model.UserOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface UserOrderMapper {
    int countByExample(UserOrderExample example);

    int deleteByExample(UserOrderExample example);

    int deleteByPrimaryKey(Long id);

    int insert(UserOrder record);

    int insertSelective(UserOrder record);

    List<UserOrder> selectByExample(UserOrderExample example);

    UserOrder selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") UserOrder record, @Param("example") UserOrderExample example);

    int updateByExample(@Param("record") UserOrder record, @Param("example") UserOrderExample example);

    int updateByPrimaryKeySelective(UserOrder record);

    int updateByPrimaryKey(UserOrder record);

    long getMaxID();
}