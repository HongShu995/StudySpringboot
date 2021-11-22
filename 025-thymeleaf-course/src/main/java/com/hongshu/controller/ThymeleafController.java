package com.hongshu.controller;

import com.hongshu.model.SysUser;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/tpl")
public class ThymeleafController
{
    //标准变量表达式
    @GetMapping("/expression1")
    public String expression1(Model model)
    {
        model.addAttribute("site","120.77.241.193");
        model.addAttribute("myuser",new SysUser(1001,"李四","男",20));
        return "expression1";
    }

    //选择变量表达式
    @GetMapping("/expression2")
    public String expression2(Model model)
    {
        model.addAttribute("site","120.77.241.193");
        model.addAttribute("myuser",new SysUser(1001,"李四","男",20));
        return "expression2";
    }

    //链接表达式
    @GetMapping("/link")
    public String link(Model model)
    {
        model.addAttribute("userId",1002);
        return "link";
    }

    //测试链接表达式
    @GetMapping("/queryAccount")
    @ResponseBody
    public String queryAccount(Integer id)
    {
        return "queryAccount,参数id="+id;
    }

    //有两个参数的地址
    @GetMapping("/queryUser")
    @ResponseBody
    public String queryUser(String name, Integer age)
    {
        return "queryUser,有两个参数：name="+name+",age="+age;
    }
}
