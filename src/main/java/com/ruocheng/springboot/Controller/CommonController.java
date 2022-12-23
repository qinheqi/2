package com.ruocheng.springboot.Controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ruocheng.springboot.Common.LayuiTableData;
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
    public LayuiTableData findCommonAll() {
        // 查询数据库获取数据
        List<Common> findAll = commonService.findAll();
        // 调用并返回LayuiTableData处理数据 此数据符合layui表格渲染的要求
        return LayuiTableData.layData(findAll.size(), findAll);
    }

    /**
     * 预留接口，进行所有常用语句的查询与展示
     * @return findCommonAll()返回的是符合layui规范的表格数据
     */
    @GetMapping("/all")
    public LayuiTableData findAll() {
        return findCommonAll();
    }

    @ResponseBody
    public LayuiTableData selectCommon(String sqlType, String distract, String alias) {
        // 查询数据库获取数据
        List<Common> housing = commonMapper.selectCommon(sqlType, distract, alias);
        // 调用并返回LayuiTableData处理数据 此数据符合layui表格渲染的要求
        return LayuiTableData.layData(housing.size(), housing);
    }

    /**
     * 根据选择内容查询常用语句
     * @param selectStr 前端传入的查询条件信息
     * @return 查询结果
     */
    @PostMapping("/selectCommonAll")
    public LayuiTableData selectCommonAll(@RequestBody String selectStr) {

        JSONObject userObj = JSONUtil.parseObj(selectStr);

        String sqlType = userObj.getStr("sqlType");
        String distract = userObj.getStr("distract");
        String alias = userObj.getStr("alias");

        return selectCommon(sqlType, distract, alias);
    }

    /**
     * 方法：获取当前（可用于操作留痕，但目前未完善）
     * @return 字符串格式的时间（"yyyy-MM-dd HH:mm:ss"）
     */
    public String GetLocalDateTime(){
        // 使用静态方法生成此对象
        LocalDateTime localDateTime = LocalDateTime.now();
        // 格式化时间
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return localDateTime.format(formatter);
    }

    /**
     * 用于新增一条查用语句
     * @param commonStr 前端传入的JSON格式的常用语句信息
     * @return 新增条数
     */
    @PostMapping("/insertCommon")
    public Integer insertCommon(@RequestBody String commonStr){

        System.out.println(commonStr);
        JSONObject userObj = JSONUtil.parseObj(commonStr);

        String sqlType = userObj.getStr("sqlType");
        String distract = userObj.getStr("distract");
        String alias = userObj.getStr("alias");
        String sql = userObj.getStr("sql");
        String username = userObj.getStr("username");
        String time = GetLocalDateTime();

        return commonService.insert(sqlType, distract, alias, sql, username, time);
    }
}