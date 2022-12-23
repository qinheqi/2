package com.ruocheng.springboot.Common;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * 过滤器，用于过滤非法请求
 */
public class AuthFilter implements Filter {

    private static final String[] WHITE_URLS = {"/login.html","/register.html"};
    private static final String[] FILE_SUFFIX = {"jpeg","jpg","png","gif","bmp","webp","css","js","woff","woff2"};

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpServletResponse response = (HttpServletResponse) servletResponse;
        String servletPath = request.getServletPath();
        if(Arrays.asList(WHITE_URLS).contains(servletPath) || endWith(servletPath)){
            filterChain.doFilter(request,response); //放行请求
        } else {
            Object user = request.getSession().getAttribute("user");
            if(user != null){
                filterChain.doFilter(request,response); //放行请求
            } else {
                response.sendRedirect("/login.html");
            }
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

    private  boolean endWith(String path){
        for(String fileSuffix:FILE_SUFFIX){
            if(path.endsWith(fileSuffix)){
                return true;
            }
        }
        return false;
    }

    public static class LayuiTableData extends HashMap<String, Object> {
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
}
