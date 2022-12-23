package com.ruocheng.springboot.Mapper;

import com.ruocheng.springboot.entity.Common;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommonMapper {

    //预留，用于查询全部常用语句
    @Select("select * from common")
    List<Common> findAll();

    List<Common> selectCommon(@Param("sqlType") String sqlType, @Param("distract") String distract, @Param("alias") String alias);

    @Insert("INSERT into common(sqlType,distract,`sql`,alias,username,`time`) VALUES (#{sqlType},#{distract},#{sql},#{alias},#{username},#{time})")
    Integer insertCommon(String sqlType, String distract, String alias, String sql, String username, String time);
}
