package com.hongshu.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginInterceptor implements HandlerInterceptor
{
    /**
     *
     * @param handler  被拦截器的控制器对象
     * @return boolean
     *    true： 请求能被Controller处理
     *    false: 请求被截断
     */
    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception
    {
        System.out.println("执行了LoginInterceptor的preHandle方法");
        return true;
    }
}
