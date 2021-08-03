package com.panglin.mapper;

import com.panglin.pojo.ParkCollection;
import com.panglin.pojo.ParkCollectionExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ParkCollectionMapper {
    int countByExample(ParkCollectionExample example);

    int deleteByExample(ParkCollectionExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ParkCollection record);

    int insertSelective(ParkCollection record);

    List<ParkCollection> selectByExample(ParkCollectionExample example);

    ParkCollection selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") ParkCollection record, @Param("example") ParkCollectionExample example);

    int updateByExample(@Param("record") ParkCollection record, @Param("example") ParkCollectionExample example);

    int updateByPrimaryKeySelective(ParkCollection record);

    int updateByPrimaryKey(ParkCollection record);
}