package com.ruocheng.springboot.Mapper;

import com.ruocheng.springboot.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select count(*) from user where username=#{username} and password=#{password}")
    User login(String username,String password);

    //通过注解+sql语句实现数据查询
    @Select("select * from user")
    List<User> findAll();

    @Insert("INSERT into user(username, password, email, phone, sex, time) VALUES (#{username},#{password},#{email},#{phone},#{sex},#{time})")
    Integer insertUser(String username, String password, String email, String phone, String sex, String time);

    @Update("update ser set username=#{username},password=#{password},email=#{email},phone=#{phone},sex=#{sex} where id=#{id}")
    Integer update(User user);

    @Delete("delete from user where id = #{id}")
    Integer deleteById(Integer id);

    @Select("select * from user where username=#{username} and password=#{password}")
    User findPersonMessage(String username,String password);

}
