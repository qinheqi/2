package com.ruocheng.springboot.Controller;

import java.util.HashMap;
import java.util.List;

public class LayuiTableData extends HashMap<String, Object> {
    public static LayuiTableData layData(int count, List<?> data) {
        LayuiTableData layui = new LayuiTableData();
        layui.put("code", 0);        // 这里的状态码必须设为0或者200
        layui.put("msg", "");        // 这里一般为空即可
        layui.put("count", count);    // 数据的总数（必须）
        layui.put("data", data);        // 数据（必须）
        return layui;
    }
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
