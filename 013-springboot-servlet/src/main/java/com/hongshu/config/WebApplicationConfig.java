package com.hongshu.config;

import com.hongshu.web.MyServlet;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WebApplicationConfig
{
    //定义方法，注册servlet对象
    @Bean
    public ServletRegistrationBean servletRegistrationBean()
    {
        //public ServletRegistrationBean(T servlet, String... urlMappings)
        //第一个参数是 Servlet对象， 第二个是url地址

        //ServletRegistrationBean bean =
        //new ServletRegistrationBean( new MyServlet(),"/myservlet");
       ServletRegistrationBean bean = new ServletRegistrationBean();
       bean.setServlet(new MyServlet());
       bean.addUrlMappings("/myservlet");
       return bean;
    }
}
