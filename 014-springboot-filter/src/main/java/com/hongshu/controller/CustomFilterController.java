package com.hongshu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class CustomFilterController
{
    @ResponseBody
    @RequestMapping("/user/account")
    public String userAccount()
    {
        return "user/account";
    }

    @ResponseBody
    @RequestMapping("/query")
    public String queryAccount()
    {
        return "query";
    }
}
