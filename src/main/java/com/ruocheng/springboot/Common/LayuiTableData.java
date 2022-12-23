package com.ruocheng.springboot.Common;

import java.util.HashMap;
import java.util.List;

/**
 * 封装layui能够识别的格式
 */
public class LayuiTableData extends HashMap<String, Object> {
    //不带sql类型的封装
    public static LayuiTableData layData(int count, List<?> data) {
        LayuiTableData layui = new LayuiTableData();
        layui.put("code", 0);        // 这里的状态码必须设为0或者200
        layui.put("msg", "");        // 这里一般为空即可
        layui.put("count", count);    // 数据的总数（必须）
        layui.put("data", data);        // 数据（必须）
        return layui;
    }
    //带sql类型的封装
    public static LayuiTableData layTypeData(int count, List<?> data, String type) {
        LayuiTableData layui = new LayuiTableData();
        layui.put("code", 0);        // 这里的状态码必须设为0或者200
        layui.put("msg", "");        // 这里一般为空即可
        layui.put("count", count);    // 数据的总数（必须）
        layui.put("data", data);        // 数据（必须）
        layui.put("type", type);        // 数据（必须）
        return layui;
    }
}
