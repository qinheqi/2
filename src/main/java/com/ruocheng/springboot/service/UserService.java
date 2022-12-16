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

    public Integer batchDelete(List<User> users) {

        for (User user : users) {
            return userMapper.deleteById(user.getId());
        }
        return 1;
    }

    public Integer insertUser(String username, String password, String email, String phone, String sex, String time){
        return userMapper.insertUser(username, password, email, phone, sex, time);
    }

    public List<User> findAll() {
        return userMapper.findAll();
    }
}
