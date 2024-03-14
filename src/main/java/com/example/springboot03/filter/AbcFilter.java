package com.example.springboot03.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author yanhao
 * @data 2024/3/12
 */
//@WebFilter(urlPatterns = "/*")
public class AbcFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Abc 拦截到了请求... 放行前逻辑");

        //放行
        chain.doFilter(request, response);

        System.out.println("Abc 拦截到了请求... 放行后逻辑");

    }

}
