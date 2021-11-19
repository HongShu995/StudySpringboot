package com.hongshu.service.impl;

import com.hongshu.service.HelloService;
import org.springframework.stereotype.Service;

@Service("HelloService")
public class HelloServiceImpl implements HelloService
{
    @Override
    public String sqyHello(String name)
    {
        return "你好"+name;
    }
}
