package com.ruocheng.springboot.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import java.sql.Date;


@Data//自动实现get方法
public class    User {
    private Integer id;
    private String username;
    private String sex;
    private String password;
    private String email;
    private String phone;
    @JsonFormat(pattern = "yyyy-MM-dd ", timezone = "GWT+8")
    private Date time;
}




