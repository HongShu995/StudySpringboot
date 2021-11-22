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
}
