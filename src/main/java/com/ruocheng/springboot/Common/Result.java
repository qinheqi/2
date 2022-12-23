package com.ruocheng.springboot.Common;

import lombok.Data;

//统一返回封装结果
@Data
public class Result<T> {
    private String code;
    private T data;
    private String msg;

    public static <T> Result<T> success(T data) {
        Result<T> res = new Result<>();
        res.setCode("200");
        res.setData(data);
        return res;
    }

    public static <T> Result<T> success() {
        Result<T> res = new Result<>();
        res.setCode("200");
        return res;
    }

    public static <T> Result<T> error(String code, String msg) {
        Result<T> res = new Result<>();
        res.setCode(code);
        res.setMsg(msg);
        return res;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> res = new Result<>();
        res.setCode("-1");
        res.setMsg(msg);
        return res;
    }
}
