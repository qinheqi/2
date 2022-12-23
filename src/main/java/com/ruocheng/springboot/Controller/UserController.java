package com.ruocheng.springboot.Controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ruocheng.springboot.Common.LayuiTableData;
import com.ruocheng.springboot.Common.Result;
import com.ruocheng.springboot.Mapper.UserMapper;
import com.ruocheng.springboot.entity.User;
import com.ruocheng.springboot.service.UserService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

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

    /**
     * 查询用户信息
     * @return 用户信息
     */
    @GetMapping("/all")
    public LayuiTableData findAll(){
        return findUserAll();
    }

    /**
     * 登录
     * @param userStr 前端传入输入的用户信息
     * @param request 调用request库
     * @return
     */
    @PostMapping("/login")
    public Result<User> login(@RequestBody String userStr, HttpServletRequest request) {
        System.out.println(userStr);
        JSONObject userObj = JSONUtil.parseObj(userStr);

        // 方法1.把接口参数转换成Java bean
//        User user = JSONUtil.toBean(userStr, User.class);

        // 方法2.直接从json对象获取属性
        String username = userObj.getStr("username");
        String password = userObj.getStr("password");

        //通过Mybatis查询数据
        User user = userMapper.findPerson(username, password);
        if (user != null) { //用户合法
            request.getSession().setAttribute("user", user); //读取用户信息
            return Result.success(user);
        } else {
            return Result.error("账号或密码错误！");
        }
    }

    /**
     * 登出
     * @param request 调用request库
     * @return 登出结果
     */
    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("user");
        if (request.getSession().getAttribute("user") == null) {
            return "SUCCESS";
        } else {
            return "FAIL";
        }
    }

    public String StringToLocalDateTime(){
        // 使用静态方法生成此对象
        LocalDateTime localDateTime = LocalDateTime.now();
        // 格式化时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }

    /**
     * 注册
     * @param userStr 前端传入的用户信息
     * @return 注册结果
     */
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
        if (result != null) {
            return Result.success(result);
        } else {
            return Result.error("注册失败！");
        }
    }

    /**
     * 登录
     * @param userStr 前端传入输入的用户信息
     * @return 删除结果
     */
    @PostMapping("/deleteById")
    public Integer deleteById(@RequestBody String userStr) {
        System.out.println(userStr);
        JSONObject userObj = JSONUtil.parseObj(userStr);

        // 方法2.直接从json对象获取属性
        Integer id = userObj.getInt("id");

        //通过Mybatis查询数据
        return userService.deleteById(id);
    }

    /**
     * 编辑
     * @param userStr 前端传入的用户信息
     * @return 编辑结果
     */
    @PostMapping("/update")
    public Result<Integer> updateUser(@RequestBody String userStr){

        System.out.println(userStr);
        JSONObject userObj = JSONUtil.parseObj(userStr);

        Integer id = userObj.getInt("id");
        String username = userObj.getStr("username");
        String password = userObj.getStr("password");
        String email = userObj.getStr("email");
        String phone = userObj.getStr("phone");
        String sex = userObj.getStr("sex");

        Integer result = userService.update(id, username, password, email, phone, sex);
        if (result != null) {
            return Result.success(result);
        } else {
            return Result.error("编辑失败！");
        }
    }
}
