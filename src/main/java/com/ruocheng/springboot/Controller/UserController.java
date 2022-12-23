package com.ruocheng.springboot.Controller;

import cn.hutool.core.io.IoUtil;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import cn.hutool.poi.excel.ExcelUtil;
import cn.hutool.poi.excel.ExcelWriter;
import com.ruocheng.springboot.Common.Result;
import com.ruocheng.springboot.Mapper.UserMapper;
import com.ruocheng.springboot.entity.User;
import com.ruocheng.springboot.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestController//接口所有查询的数据会被渲染成json.返回
@RequestMapping("/user")
public class UserController {

    @Resource
    private UserMapper userMapper;

    @Resource
    private UserService userService;

    @ResponseBody
    public LayuiTableData findUserAll(){
        // 查询数据库获取数据
        List<User> findAll = userService.findAll();
        // 调用并返回LayuiTableData处理数据 此数据符合layui表格渲染的要求
        return LayuiTableData.layData(findAll.size(), findAll);
    }

    @GetMapping("/all")
    public LayuiTableData findAll(){
        return findUserAll();
    }

    @PostMapping("/login")
    public Result<User> login(@RequestBody String userStr, HttpServletRequest request) {
        System.out.println(userStr);
        JSONObject userObj = JSONUtil.parseObj(userStr);

        // 方法1.把接口参数转换成Java bean
//        User user = JSONUtil.toBean(userStr, User.class);

        // 方法2.直接从json对象获取属性
        String username = userObj.getStr("username");
        String password = userObj.getStr("password");

        //通过JDBC查询数据
//        User user = JDBCUtil.executeQuery(username, password);

        //通过Mybatis查询数据
        User user = userMapper.findPersonMessage(username, password);
        if (user != null) { //用户合法
            request.getSession().setAttribute("user", user); //读取用户信息
            return Result.success(user);
        } else {
            return Result.error("账号或密码错误！");
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request, HttpServletResponse response) throws IOException {
        request.getSession().removeAttribute("user");
        if (request.getSession().getAttribute("user") == null) {
            return "SUCCESS";
        } else {
            return "FAIL";
        }
    }

    @DeleteMapping("/{id}")
    public Integer delete(@PathVariable Integer id) {
        return userMapper.deleteById(id);
    }

    public String StringToLocalDateTime(){
        // 使用静态方法生成此对象
        LocalDateTime localDateTime = LocalDateTime.now();
        // 格式化时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }

    @PostMapping("/register")
    public Result<Integer> insertUser(@RequestBody String userStr){

        System.out.println(userStr);
        JSONObject userObj = JSONUtil.parseObj(userStr);

        String username = userObj.getStr("username");
        String password = userObj.getStr("password");
        String email = userObj.getStr("email");
        String phone = userObj.getStr("phone");
        String sex = userObj.getStr("sex");
        String time = StringToLocalDateTime();

        Integer result = userService.insertUser(username, password, email, phone, sex, time);
        if (result != null) { //用户合法
            return Result.success(result);
        } else {
            return Result.error("账号或密码错误！");
        }
    }
}
