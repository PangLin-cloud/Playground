package com.panglin.mapper;

import com.panglin.pojo.PlayUser;
import com.panglin.pojo.PlayUserExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface PlayUserMapper {
    int countByExample(PlayUserExample example);

    int deleteByExample(PlayUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(PlayUser record);

    int insertSelective(PlayUser record);

    List<PlayUser> selectByExample(PlayUserExample example);

    PlayUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") PlayUser record, @Param("example") PlayUserExample example);

    int updateByExample(@Param("record") PlayUser record, @Param("example") PlayUserExample example);

    int updateByPrimaryKeySelective(PlayUser record);

    int updateByPrimaryKey(PlayUser record);
}