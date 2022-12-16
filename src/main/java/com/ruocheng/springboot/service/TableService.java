package com.ruocheng.springboot.service;

import com.ruocheng.springboot.Mapper.TableMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
@Service
public class TableService {
    @Resource
    private TableMapper tableMapper;
    public List<HashMap<String, Object>> selectSQL(String sql) {
        return tableMapper.select(sql);
    }

    public Integer insertSQL(String sql) {
        return tableMapper.insert(sql);
    }

    public Integer updateSQL(String sql) {
        return tableMapper.update(sql);
    }

    public Integer deleteSQL(String sql) {
        return tableMapper.delete(sql);
    }
}
