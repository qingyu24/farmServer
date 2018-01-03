package com.fngame.farm.mapper;

import com.fngame.farm.model.StreetMarket;
import com.fngame.farm.model.StreetMarketExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface StreetMarketMapper {
    int countByExample(StreetMarketExample example);

    int deleteByExample(StreetMarketExample example);

    int deleteByPrimaryKey(Long id);

    int insert(StreetMarket record);

    int insertSelective(StreetMarket record);

    List<StreetMarket> selectByExample(StreetMarketExample example);

    StreetMarket selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") StreetMarket record, @Param("example") StreetMarketExample example);

    int updateByExample(@Param("record") StreetMarket record, @Param("example") StreetMarketExample example);

    int updateByPrimaryKeySelective(StreetMarket record);

    int updateByPrimaryKey(StreetMarket record);
}