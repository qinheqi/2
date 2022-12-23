package com.ruocheng.springboot.Controller;

import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ruocheng.springboot.Mapper.TableMapper;
import com.ruocheng.springboot.service.TableService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


@RestController//接口所有查询的数据会被渲染成json.返回
@RequestMapping("/table")
public class TableController {

    @Resource
    private TableMapper tableMapper;

    @Resource
    private TableService tableService;

    @ResponseBody
    public LayuiTableData ArbitraryTableSQL(String sqlType, String sql) {
         if(Objects.equals(sqlType, "查询")) {
             List<HashMap<String, Object>> table = tableService.selectSQL(sql);
            return LayuiTableData.layTypeData(table.size(), table, sqlType);
        }
        else if(Objects.equals(sqlType, "新增")) {
            Integer table = tableService.insertSQL(sql);
            return LayuiTableData.layTypeData(Collections.singletonList(table).size(), Collections.singletonList(table), sqlType);
        }
        else if(Objects.equals(sqlType, "修改")) {
            Integer test1 = tableService.updateSQL(sql);
            return LayuiTableData.layTypeData(Collections.singletonList(test1).size(), Collections.singletonList(test1), sqlType);
        }
        else if(Objects.equals(sqlType, "删除")) {
            Integer test1 = tableService.deleteSQL(sql);
            return LayuiTableData.layTypeData(Collections.singletonList(test1).size(), Collections.singletonList(test1), sqlType);
        }
        return null;
    }

    @PostMapping ("/arbitrarySQL")
    public LayuiTableData arbitraryTableSQL(@RequestBody String arbitraryStr) {

        JSONObject arbitraryObj = JSONUtil.parseObj(arbitraryStr);

        String sqlType = arbitraryObj.getStr("sqlType");
        String sql = arbitraryObj.getStr("sql");

        return ArbitraryTableSQL(sqlType, sql);
    }
}