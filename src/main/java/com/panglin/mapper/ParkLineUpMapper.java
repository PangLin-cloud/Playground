package com.panglin.mapper;

import com.panglin.pojo.LineUp;
import com.panglin.pojo.ParkLineUp;
import com.panglin.pojo.ParkLineUpExample;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;

import javax.sound.sampled.Line;
import java.util.List;
import java.util.Map;

public interface ParkLineUpMapper {
    int countByExample(ParkLineUpExample example);

    int deleteByExample(ParkLineUpExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(ParkLineUp record);

    int insertSelective(ParkLineUp record);

    List<ParkLineUp> selectByExample(ParkLineUpExample example);

    ParkLineUp selectByPrimaryKey(Integer id);

    List<LineUp> selectLineUpCountGroupByParkId();

    int updateByExampleSelective(@Param("record") ParkLineUp record, @Param("example") ParkLineUpExample example);

    int updateByExample(@Param("record") ParkLineUp record, @Param("example") ParkLineUpExample example);

    int updateByPrimaryKeySelective(ParkLineUp record);

    int updateByPrimaryKey(ParkLineUp record);
}