package com.hongshu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class JspController
{
    //public String doJsp(HttpServletRequest request)
    //{
    //    request.setAttribute("data","springboot使用jsp");
    //    //视图的逻辑名称
    //    return "index";
    //}

    @RequestMapping("/myjsp")
    public String doJsp(Model model)
    {
        //等价request.setAttribute("data","springboot使用jsp");
        //把数据放入到request作用域
        model.addAttribute("data","springboot使用jsp");
        //视图的逻辑名称
        return "index";
    }
}
