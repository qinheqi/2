package com.ruocheng.springboot.service;

import com.ruocheng.springboot.Mapper.CommonMapper;
import com.ruocheng.springboot.entity.Common;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommonService {

    @Autowired
    private CommonMapper commonMapper;

    public List<Common> findAll() {
        return commonMapper.findAll();
    }

    public Integer insert(String sqlType, String distract, String alias, String sql, String username, String time){
        return commonMapper.insertCommon(sqlType, distract, alias, sql, username, time);
    }
}
