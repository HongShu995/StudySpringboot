package com.hongshu.controller;

import com.hongshu.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController
{
    @GetMapping("/hello")
    public String hello()
    {
        return "hello";
    }

    @PostMapping("/user")
    public User user()
    {
        return new User();
    }
}
