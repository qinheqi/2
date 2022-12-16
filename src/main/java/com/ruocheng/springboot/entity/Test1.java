package com.ruocheng.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.sql.Timestamp;


@Data//自动实现get方法
public class Test1 {
    private String name;
    private String sex;
    private String idNumber;
    private String phone;
}




