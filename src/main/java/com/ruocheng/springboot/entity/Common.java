package com.ruocheng.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;


@Data//自动实现get方法
public class Common {
    private String sqlType;
    private String distract;
    private String table;
    private String sql;
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp time;
    private String alias;
    private String username;
}




