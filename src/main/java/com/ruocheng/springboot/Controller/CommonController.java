package com.ruocheng.springboot.Controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ruocheng.springboot.Common.AuthFilter;
import com.ruocheng.springboot.Mapper.CommonMapper;
import com.ruocheng.springboot.entity.Common;
import com.ruocheng.springboot.service.CommonService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;


@RestController//接口所有查询的数据会被渲染成json.返回
@RequestMapping("/Common")
public class CommonController {

    @Resource
    private CommonMapper commonMapper;

    @Resource
    private CommonService commonService;

    @ResponseBody
    public AuthFilter.LayuiTableData findCommonAll() {
        // 查询数据库获取数据
        List<Common> findAll = commonService.findAll();
        // 调用并返回LayuiTableData处理数据 此数据符合layui表格渲染的要求
        return AuthFilter.LayuiTableData.layData(findAll.size(), findAll);
    }

    @GetMapping("/all")
    public AuthFilter.LayuiTableData findAll() {
        return findCommonAll();
    }

    @ResponseBody
    public AuthFilter.LayuiTableData selectCommon(String sqlType, String distract, String alias) {
        // 查询数据库获取数据
        List<Common> housing = commonMapper.selectCommon(sqlType, distract, alias);
        // 调用并返回LayuiTableData处理数据 此数据符合layui表格渲染的要求
        return AuthFilter.LayuiTableData.layData(housing.size(), housing);
    }

    @PostMapping("/selectCommonAll")
    public AuthFilter.LayuiTableData selectCommonAll(@RequestBody String userStr) {

        JSONObject userObj = JSONUtil.parseObj(userStr);

        String sqlType = userObj.getStr("sqlType");
        String distract = userObj.getStr("distract");
        String alias = userObj.getStr("alias");

        return selectCommon(sqlType, distract, alias);
    }

    public String StringToLocalDateTime(){
        // 使用静态方法生成此对象
        LocalDateTime localDateTime = LocalDateTime.now();
        // 格式化时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }

    @PostMapping("/insertCommon")
    public Integer insertCommon(@RequestBody String userStr){

        System.out.println(userStr);
        JSONObject userObj = JSONUtil.parseObj(userStr);

        String sqlType = userObj.getStr("sqlType");
        String distract = userObj.getStr("distract");
        String alias = userObj.getStr("alias");
        String sql = userObj.getStr("sql");
        String username = userObj.getStr("username");
        String time = StringToLocalDateTime();

        return commonService.insert(sqlType, distract, alias, sql, username, time);
    }
}