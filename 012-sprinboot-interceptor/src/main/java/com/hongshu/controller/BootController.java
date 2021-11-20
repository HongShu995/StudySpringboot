package com.hongshu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BootController
{
    @ResponseBody
    @RequestMapping("/user/account")
    public String userAccount()
    {
        return "访问user/account地址";
    }

    @ResponseBody
    @RequestMapping("/user/login")
    public String userLogin()
    {
        return "访问user/login地址";
    }
}
