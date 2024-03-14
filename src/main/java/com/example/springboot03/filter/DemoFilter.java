package com.example.springboot03.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author yanhao
 * @data 2024/3/12
 * <p>
 * init方法：过滤器的初始化方法。在web服务器启动的时候会自动的创建Filter过滤器对象，在创建过滤器对象的时候会自动调用init初始化方法，这个方法只会被调用一次。
 * <p>
 * doFilter方法：这个方法是在每一次拦截到请求之后都会被调用，所以这个方法是会被调用多次的，每拦截到一次请求就会调用一次doFilter()方法。
 * <p>
 * destroy方法： 是销毁的方法。当我们关闭服务器的时候，它会自动的调用销毁方法destroy，而这个销毁方法也只会被调用一次。
 * <p>
 * springboot中过滤器使用：
 */

// 定义一个类，实现一个标准的Filter过滤器的接口
//@WebFilter(urlPatterns = "/*")
public class DemoFilter implements Filter {

    // 初始化方法, 只调用一次
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init 初始化方法执行了");
    }

    // 拦截到请求之后调用, 调用多次
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("Demo 拦截到了请求...放行前逻辑");
        //放行
        chain.doFilter(request, response);

        System.out.println("DemoFilter   放行后逻辑.....");
    }

    // 销毁方法, 只调用一次
    @Override
    public void destroy() {
        System.out.println("destroy 销毁方法执行了");
    }
}
