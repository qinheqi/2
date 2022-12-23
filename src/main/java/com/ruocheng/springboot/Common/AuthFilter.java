package com.ruocheng.springboot.Common;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.Arrays;

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
}
