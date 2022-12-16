package com.ruocheng.springboot.Mapper;

import com.ruocheng.springboot.entity.Common;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CommonMapper {

    //通过注解+sql语句实现数据查询
    @Select("select * from common")
    List<Common> findAll();

//    @Select("select * from housing_chongqing where type=#{type} and distract=#{password} and name=#name}")
//    List<Housing> selectHousing(@Param("type") String type, @Param("distract") String distract, @Param("name") String name);

//    @Select("select * from housing_chongqing where sqlType=#{type} and distract=#{distract} and housingName=#{name}")
//    List<Housing> selectHousing(@Param("type") String type, @Param("distract") String distract, @Param("name") String name);

    List<Common> selectCommon(@Param("sqlType") String sqlType, @Param("distract") String distract, @Param("alias") String alias);

//    void insertCommon(@Param("type") String type, @Param("distract") String distract, @Param("table") String table, @Param("alias") String alias, @Param("sql") String sql);

    @Insert("INSERT into common(sqlType,distract,`sql`,alias,username,`time`) VALUES (#{sqlType},#{distract},#{sql},#{alias},#{username},#{time})")
    Integer insertCommon(String sqlType, String distract, String alias, String sql, String username, String time);
}
