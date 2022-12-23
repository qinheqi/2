package com.ruocheng.springboot.service;

import com.ruocheng.springboot.Mapper.UserMapper;
import com.ruocheng.springboot.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    //预留，通过id删除用户
    public Integer deleteById(Integer id){
        return userMapper.deleteById(id);
    }

    public Integer insertUser(String username, String password, String email, String phone, String sex, String time){
        return userMapper.insertUser(username, password, email, phone, sex, time);
    }

    public Integer update(Integer id, String username, String password, String email, String phone, String sex){
        return userMapper.update(id, username, password, email, phone, sex);
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }
}
