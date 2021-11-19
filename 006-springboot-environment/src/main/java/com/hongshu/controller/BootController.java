package com.hongshu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BootController
{
    @ResponseBody
    @RequestMapping("/hello")
    public String doSome()
    {
        return "hello SpringBoot app,设置了端口";
    }
}
