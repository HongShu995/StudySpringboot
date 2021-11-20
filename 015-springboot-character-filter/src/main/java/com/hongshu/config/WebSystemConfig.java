package com.hongshu.config;

import com.hongshu.web.MyServlet;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.CharacterEncodingFilter;

@Configuration
public class WebSystemConfig
{
    //注册servlet
    @Bean
    public ServletRegistrationBean servletRegistrationBean()
    {
        ServletRegistrationBean bean = new ServletRegistrationBean();
        bean.setServlet(new MyServlet());
        bean.addUrlMappings("/servlet");
        return bean;
    }

    //注册Filter
    @Bean
    public FilterRegistrationBean filterRegistrationBean()
    {
        FilterRegistrationBean bean = new FilterRegistrationBean();
        //使用框架中的过滤器类
        CharacterEncodingFilter filter = new CharacterEncodingFilter();
        filter.setEncoding("utf-8");
        //指定request，response都使用encoding设定的值
        filter.setForceEncoding(true);
        //指定过滤的url
        bean.setFilter(filter);
        bean.addUrlPatterns("/*");
        return bean;
    }
}
