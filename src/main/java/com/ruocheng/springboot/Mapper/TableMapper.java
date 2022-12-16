package com.ruocheng.springboot.Mapper;
import org.apache.ibatis.annotations.Insert;

import java.util.HashMap;
import java.util.List;

public interface TableMapper {

    List<HashMap<String,Object>> select(String sql);

    Integer insert(String sql);

    Integer update(String sql);

    Integer delete(String sql);
}