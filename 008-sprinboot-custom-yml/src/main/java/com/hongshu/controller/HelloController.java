package com.hongshu.controller;

import com.hongshu.vo.SchoolInfo;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

@Controller
public class HelloController
{
    @Value("${server.port}")
    private Integer port;

    @Value("${server.servlet.context-path}")
    private String contextPath;

    @Value("${school.name}")
    private String name;

    @Value("${school.website}")
    private String website;

    @Value("${school.address}")
    private String address;

    @Value("${site}")
    private String site;

    @Resource
    private SchoolInfo info;

    @ResponseBody
    @RequestMapping("/data")
    public String queryData()
    {
        return this.toString();
    }

    @ResponseBody
    @RequestMapping("/info")
    public String queryInfo()
    {
        return "SchoolInfo对象===="+info.toString();
    }

    @Override
    public String toString()
    {
        return "HelloController{" +
                "使用的端口=" + port +
                ", 项目访问路径='" + contextPath + '\'' +
                ", 学校名称='" + name + '\'' +
                ", 学校网址='" + website + '\'' +
                ", 学校地址='" + address + '\'' +
                ", site='" + site + '\'' +
                '}';
    }
}
