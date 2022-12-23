package com.ruocheng.springboot.Mapper;

import java.util.HashMap;
import java.util.List;

//实现任意sql语句的执行
public interface TableMapper {

    List<HashMap<String,Object>> select(String sql);

    Integer insert(String sql);

    Integer update(String sql);

    Integer delete(String sql);
}